/**
/**
 * Copyright (c) 2010 Ericsson
 *  
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * Contributors:
 * Alvaro Sanchez-Leon  - Initial API and implementation
 * 
 */
package org.eclipse.mylyn.reviews.r4e.core.model.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion;
import org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>R4E File Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EFileVersionImpl#getPlatformURI <em>Platform URI</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EFileVersionImpl#getVersionID <em>Version ID</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EFileVersionImpl#getRepositoryPath <em>Repository Path</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EFileVersionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EFileVersionImpl#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class R4EFileVersionImpl extends EObjectImpl implements R4EFileVersion {
	/**
	 * The default value of the '{@link #getPlatformURI() <em>Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPlatformURI() <em>Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected String platformURI = PLATFORM_URI_EDEFAULT;
	/**
	 * The default value of the '{@link #getVersionID() <em>Version ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionID()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getVersionID() <em>Version ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionID()
	 * @generated
	 * @ordered
	 */
	protected String versionID = VERSION_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getRepositoryPath() <em>Repository Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_PATH_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRepositoryPath() <em>Repository Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryPath()
	 * @generated
	 * @ordered
	 */
	protected String repositoryPath = REPOSITORY_PATH_EDEFAULT;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final IResource RESOURCE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected IResource resource = RESOURCE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected R4EFileVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RModelPackage.Literals.R4E_FILE_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatformURI() {
		return platformURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatformURI(String newPlatformURI) {
		String oldPlatformURI = platformURI;
		platformURI = newPlatformURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_FILE_VERSION__PLATFORM_URI, oldPlatformURI, platformURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersionID() {
		return versionID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionID(String newVersionID) {
		String oldVersionID = versionID;
		versionID = newVersionID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_FILE_VERSION__VERSION_ID, oldVersionID, versionID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryPath() {
		return repositoryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryPath(String newRepositoryPath) {
		String oldRepositoryPath = repositoryPath;
		repositoryPath = newRepositoryPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_FILE_VERSION__REPOSITORY_PATH, oldRepositoryPath, repositoryPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_FILE_VERSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IResource getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(IResource newResource) {
		IResource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_FILE_VERSION__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RModelPackage.R4E_FILE_VERSION__PLATFORM_URI:
				return getPlatformURI();
			case RModelPackage.R4E_FILE_VERSION__VERSION_ID:
				return getVersionID();
			case RModelPackage.R4E_FILE_VERSION__REPOSITORY_PATH:
				return getRepositoryPath();
			case RModelPackage.R4E_FILE_VERSION__NAME:
				return getName();
			case RModelPackage.R4E_FILE_VERSION__RESOURCE:
				return getResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RModelPackage.R4E_FILE_VERSION__PLATFORM_URI:
				setPlatformURI((String)newValue);
				return;
			case RModelPackage.R4E_FILE_VERSION__VERSION_ID:
				setVersionID((String)newValue);
				return;
			case RModelPackage.R4E_FILE_VERSION__REPOSITORY_PATH:
				setRepositoryPath((String)newValue);
				return;
			case RModelPackage.R4E_FILE_VERSION__NAME:
				setName((String)newValue);
				return;
			case RModelPackage.R4E_FILE_VERSION__RESOURCE:
				setResource((IResource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RModelPackage.R4E_FILE_VERSION__PLATFORM_URI:
				setPlatformURI(PLATFORM_URI_EDEFAULT);
				return;
			case RModelPackage.R4E_FILE_VERSION__VERSION_ID:
				setVersionID(VERSION_ID_EDEFAULT);
				return;
			case RModelPackage.R4E_FILE_VERSION__REPOSITORY_PATH:
				setRepositoryPath(REPOSITORY_PATH_EDEFAULT);
				return;
			case RModelPackage.R4E_FILE_VERSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RModelPackage.R4E_FILE_VERSION__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RModelPackage.R4E_FILE_VERSION__PLATFORM_URI:
				return PLATFORM_URI_EDEFAULT == null ? platformURI != null : !PLATFORM_URI_EDEFAULT.equals(platformURI);
			case RModelPackage.R4E_FILE_VERSION__VERSION_ID:
				return VERSION_ID_EDEFAULT == null ? versionID != null : !VERSION_ID_EDEFAULT.equals(versionID);
			case RModelPackage.R4E_FILE_VERSION__REPOSITORY_PATH:
				return REPOSITORY_PATH_EDEFAULT == null ? repositoryPath != null : !REPOSITORY_PATH_EDEFAULT.equals(repositoryPath);
			case RModelPackage.R4E_FILE_VERSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RModelPackage.R4E_FILE_VERSION__RESOURCE:
				return RESOURCE_EDEFAULT == null ? resource != null : !RESOURCE_EDEFAULT.equals(resource);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (platformURI: ");
		result.append(platformURI);
		result.append(", versionID: ");
		result.append(versionID);
		result.append(", repositoryPath: ");
		result.append(repositoryPath);
		result.append(", name: ");
		result.append(name);
		result.append(", resource: ");
		result.append(resource);
		result.append(')');
		return result.toString();
	}

} //R4EFileVersionImpl