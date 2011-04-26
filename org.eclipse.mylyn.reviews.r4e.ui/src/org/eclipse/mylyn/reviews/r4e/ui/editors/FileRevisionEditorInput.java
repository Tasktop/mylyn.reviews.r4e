/*******************************************************************************
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * Ericsson (Sebastien Dubois) - Adapted to use with R4E
 *******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.editors;

import java.io.InputStream;
import java.net.URI;
import java.text.DateFormat;
import java.util.Date;

import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion;
import org.eclipse.mylyn.reviews.r4e.core.rfs.spi.IRFSRegistry;
import org.eclipse.mylyn.reviews.r4e.core.rfs.spi.RFSRegistryFactory;
import org.eclipse.mylyn.reviews.r4e.core.rfs.spi.ReviewsFileStorageException;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * An Editor input for file revisions
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class FileRevisionEditorInput extends PlatformObject implements
		IWorkbenchAdapter, IStorageEditorInput {

	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------

	/**
	 * Field fVersion
	 */
	private final R4EFileVersion fFileVersion;
	

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * @param aFileVersion
	 *            the R4E file version
	 * @param aStorage
	 *            the contents of the file revision
	 */
	public FileRevisionEditorInput(R4EFileVersion aFileVersion) {
		Assert.isNotNull(aFileVersion);
		fFileVersion = aFileVersion;
	}

	/**
	 * @param aFileVersion R4EFileVersion
	 * @param aStorage IStorage
	 * @param aCharset String
	 */
	public FileRevisionEditorInput(R4EFileVersion aFileVersion, IStorage aStorage, String aCharset) {
		this(aFileVersion/*, wrapStorage(aStorage, aCharset)*/);
	}

	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method wrapStorage.
	 * @param aStorage IStorage
	 * @param aCharset String
	 * @return IStorage
	 */
	private static IStorage wrapStorage(final IStorage aStorage, final String aCharset) {
		if (null == aCharset) return aStorage;
		if (aStorage instanceof IFileState) {
			return new IFileState() {
				public Object getAdapter(@SuppressWarnings("rawtypes") Class aAdapter) {
					return aStorage.getAdapter(aAdapter);
				}

				public boolean isReadOnly() {
					return aStorage.isReadOnly();
				}

				public String getName() {
					return aStorage.getName();
				}

				public IPath getFullPath() {
					return aStorage.getFullPath();
				}

				public InputStream getContents() throws CoreException {
					return aStorage.getContents();
				}

				public String getCharset() {
					return aCharset;
				}

				public boolean exists() {
					return ((IFileState) aStorage).exists();
				}

				public long getModificationTime() {
					return ((IFileState) aStorage).getModificationTime();
				}
			};
		}

		return new IEncodedStorage() {
			public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
				return aStorage.getAdapter(adapter);
			}

			public boolean isReadOnly() {
				return aStorage.isReadOnly();
			}

			public String getName() {
				return aStorage.getName();
			}

			public IPath getFullPath() {
				return aStorage.getFullPath();
			}

			public InputStream getContents() throws CoreException {
				return aStorage.getContents();
			}

			public String getCharset() {
				return aCharset;
			}
		};
	}
	
	/**
	 * @param aFileVersion R4EFileVersion - the file revision
	 * @param aMonitor IProgressMonitor
	 * @return a file revision editor input
	 * @throws CoreException
	 */
	public static FileRevisionEditorInput createEditorInputFor(R4EFileVersion aFileVersion, IProgressMonitor aMonitor)
			throws CoreException {
		return new FileRevisionEditorInput(aFileVersion);
	}
	
	/**
	 * Method getStorage.
	 * @return IStorage
	 * @see org.eclipse.ui.IStorageEditorInput#getStorage()
	 */
	public IStorage getStorage() {
		if (useWorkspaceResource()) {
			return ((IFile)fFileVersion.getResource());
		}
		try {
			return fFileVersion.getFileRevision().getStorage(null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method exists.
	 * @return boolean
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	public boolean exists() {
		return true;
	}

	/**
	 * Method getImageDescriptor.
	 * @return ImageDescriptor
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	/**
	 * Method getName.
	 * @return String
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	public String getName() {
		if (useWorkspaceResource()) {
			return fFileVersion.getResource().getName();
		}
		try {
			return fFileVersion.getFileRevision().getStorage(null).getName();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method getPersistable.
	 * @return IPersistableElement
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	public IPersistableElement getPersistable() {
		return null;   // can't persist
	}

	/**
	 * Method getToolTipText.
	 * @return String
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	public String getToolTipText() {
		if (useWorkspaceResource()) {
			return fFileVersion.getResource().getProjectRelativePath().toPortableString();
		}
		try {
			return fFileVersion.getFileRevision().getStorage(null).getFullPath().toString();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method getAdapter.
	 * @param aAdapter Class
	 * @return Object
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(Class)
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class aAdapter) {
		if (IWorkbenchAdapter.class.equals(aAdapter)) return this;
		final Object object = super.getAdapter(aAdapter);
		if (null != object) return object;
		if (aAdapter.isInstance(fFileVersion)) return fFileVersion;
		if (fFileVersion instanceof IAdaptable) {
			final Object adapted = ((IAdaptable) fFileVersion).getAdapter(aAdapter);
			if (aAdapter.isInstance(adapted)) return adapted;
		}
		final Object adapted = Platform.getAdapterManager().getAdapter(fFileVersion, aAdapter);
		if (aAdapter.isInstance(adapted)) return adapted;
		if (IStorage.class.equals(aAdapter)) {
			try {
				return fFileVersion.getFileRevision().getStorage(null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Method getChildren.
	 * @param aObject Object
	 * @return Object[]
	 * @see org.eclipse.ui.model.IWorkbenchAdapter#getChildren(Object)
	 */
	public Object[] getChildren(Object aObject) {
		return new Object[0];
	}

	/**
	 * Method getImageDescriptor.
	 * @param aObject Object
	 * @return ImageDescriptor
	 * @see org.eclipse.ui.model.IWorkbenchAdapter#getImageDescriptor(Object)
	 */
	public ImageDescriptor getImageDescriptor(Object aObject) {
		return null;
	}

	/**
	 * Method getLabel.
	 * @param aObject Object
	 * @return String
	 * @see org.eclipse.ui.model.IWorkbenchAdapter#getLabel(Object)
	 */
	public String getLabel(Object aObject) {
		return getName();
	}

	/**
	 * Method getParent.
	 * @param aObject Object
	 * @return Object
	 * @see org.eclipse.ui.model.IWorkbenchAdapter#getParent(Object)
	 */
	public Object getParent(Object aObject) {
		return null;
	}

	/**
	 * Method equals.
	 * @param aObject Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object aObject) {
		if (aObject == this) return true;

		if (aObject instanceof FileRevisionEditorInput) {
			final FileRevisionEditorInput other = (FileRevisionEditorInput) aObject;
			return other.fFileVersion.equals(this.fFileVersion);
		}
		return false;
	}

	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return fFileVersion.getFileRevision().hashCode();
	}

	/**
	 * @return IFileRevision - the revision
	 */
	public R4EFileVersion getFileVersion() {
		return fFileVersion;
	}

	/**
	 * @return URI - the URI
	 */
	public URI getURI() {
		return fFileVersion.getFileRevision().getURI();
	}

	/**
	 * Method useWorkspaceResource.
	 * @return boolean
	 */
	private boolean useWorkspaceResource() {
		// Get handle to local storage repository
		IRFSRegistry localRepository;
		try {
			localRepository = RFSRegistryFactory.getRegistry(
					R4EUIModelController.getActiveReview().getReview());

			//If resource is available in the workspace, use it.  Otherwise use the local repo version
			if (null != fFileVersion.getResource()) {
				String workspaceFileId = localRepository.blobIdFor(((IFile)fFileVersion.getResource()).getContents());
				String repoFileId = fFileVersion.getLocalVersionID();
				if (workspaceFileId.equals((repoFileId))) {
					return true;
				}
			}
		} catch (ReviewsFileStorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return false;
	}
}
