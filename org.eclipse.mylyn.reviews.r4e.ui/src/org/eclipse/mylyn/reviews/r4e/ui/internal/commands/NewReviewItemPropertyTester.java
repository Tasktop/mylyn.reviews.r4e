/*******************************************************************************
 * Copyright (c) 2011 Ericsson Research Canada
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class implements a property tester that is used to see if a review item can
 * be added
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.internal.commands;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.Iterator;

import org.eclipse.compare.ITypedElement;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EItem;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EParticipant;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewPhase;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewState;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewType;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EUserRole;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.editors.R4ECompareEditorInput;
import org.eclipse.mylyn.reviews.r4e.ui.internal.editors.R4EFileEditorInput;
import org.eclipse.mylyn.reviews.r4e.ui.internal.editors.R4EFileRevisionEditorInput;
import org.eclipse.mylyn.reviews.r4e.ui.internal.editors.R4EFileRevisionTypedElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.editors.R4EFileTypedElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIReviewBasic;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.UIUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class NewReviewItemPropertyTester extends PropertyTester {

	/**
	 * Method test.
	 * 
	 * @param receiver
	 *            Object
	 * @param property
	 *            String
	 * @param args
	 *            Object[]
	 * @param expectedValue
	 *            Object
	 * @return boolean
	 * @see org.eclipse.core.expressions.IPropertyTester#test(Object, String, Object[], Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		//Command is disabled if the review is completed
		final R4EUIReviewBasic activeReview = R4EUIModelController.getActiveReview();
		if (null == activeReview || activeReview.isUserReviewed()) {
			return false;
		}

		//Check if command is enabled based on input
		if (receiver instanceof AbstractSet) {
			final Iterator<?> iterator = ((AbstractSet<?>) receiver).iterator();
			if (iterator.next() instanceof TextSelection) {
				if (!(isR4EEditorInputAvailable())) {
					return false;
				}
			}
		}

		if (receiver instanceof AbstractList) {
			final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (null != window) {
				final IWorkbenchPage page = window.getActivePage();
				if (null != page && !(page.getActivePart() instanceof ContentOutline)) {
					return true; //not an Outline view
				}
			}
			//This happens when the command is selected from the outline view on an external or workspace file
			final Iterator<?> iterator = ((AbstractList<?>) receiver).iterator();
			if (!iterator.hasNext()) {
				if (!(isR4EEditorInputAvailable())) {
					return false;
				}
			} else {
				final Object obj = iterator.next();
				if ((R4EUIPlugin.isJDTAvailable() && obj instanceof ISourceReference)
						|| (R4EUIPlugin.isCDTAvailable() && obj instanceof org.eclipse.cdt.core.model.ISourceReference)) {
					if (!(isR4EEditorInputAvailable())) {
						return false;
					}
				}
			}
		}

		//For formal reviews, review items can only be added by reveiwers in the planning and preparation phase
		if (activeReview.getReview().getType().equals(R4EReviewType.R4E_REVIEW_TYPE_FORMAL)) {
			R4EParticipant reviewer = null;
			try {
				reviewer = activeReview.getParticipant(R4EUIModelController.getReviewer(), false);
			} catch (ResourceHandlingException e) {
				UIUtils.displayResourceErrorDialog(e);
				return false;
			}
			if (null == reviewer) {
				return false;
			}

			if (((R4EReviewState) activeReview.getReview().getState()).getState().equals(
					R4EReviewPhase.R4E_REVIEW_PHASE_STARTED)) {
				if (!(reviewer.getRoles().contains(R4EUserRole.R4E_ROLE_LEAD))
						&& !(reviewer.getRoles().contains(R4EUserRole.R4E_ROLE_AUTHOR))
						&& !(reviewer.getRoles().contains(R4EUserRole.R4E_ROLE_ORGANIZER))) {
					return false;
				}
			} else if (!((R4EReviewState) activeReview.getReview().getState()).getState().equals(
					R4EReviewPhase.R4E_REVIEW_PHASE_PREPARATION)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method isR4EEditorInputAvailable.
	 * 
	 * @return boolean
	 */
	private boolean isR4EEditorInputAvailable() {
		IEditorInput editorInput = null;
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (null != window) {
			final IWorkbenchPage page = window.getActivePage();
			if (null != page && null != page.getActiveEditor()) {
				editorInput = page.getActiveEditor().getEditorInput();
				//Single editor
				if (editorInput instanceof R4EFileRevisionEditorInput) {
					if (null == ((R4EFileRevisionEditorInput) editorInput).getFileVersion().getRepositoryPath()) {
						return false; //No valid target
					}
					final R4EItem parentItem = ((R4EItem) ((R4EFileRevisionEditorInput) editorInput).getFileVersion()
							.eContainer()
							.eContainer());
					if (null != parentItem.getRepositoryRef()) {
						return false; //Cannot add review item on a commit
					}
				} else if (editorInput instanceof R4EFileEditorInput) {
					final R4EItem parentItem = ((R4EItem) ((R4EFileEditorInput) editorInput).getFileVersion()
							.eContainer()
							.eContainer());
					if (null != parentItem.getRepositoryRef()) {
						return false; //Cannot add review item on a commit
					}
					//Compare editor
				} else if (editorInput instanceof R4ECompareEditorInput) {
					final ITypedElement targetElement = ((R4ECompareEditorInput) editorInput).getLeftElement();
					if (null == targetElement) {
						return false;
					}
					R4EItem parentItem = null;
					ITypedElement element = ((R4ECompareEditorInput) editorInput).getLeftElement();
					if (element instanceof R4EFileRevisionTypedElement) {
						parentItem = ((R4EItem) ((R4EFileRevisionTypedElement) element).getFileVersion()
								.eContainer()
								.eContainer());
					} else if (element instanceof R4EFileTypedElement) {
						parentItem = ((R4EItem) ((R4EFileTypedElement) element).getFileVersion()
								.eContainer()
								.eContainer());
					}
					if (null != parentItem && null != parentItem.getRepositoryRef()) {
						return false; //Cannot add review item on a commit
					}
				}
			}
		}
		return true;
	}
}