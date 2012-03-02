// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, useForLoop, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity, explicitThisUsage
/*******************************************************************************
 * Copyright (c) 2012 Ericsson Research Canada
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class implements the Navigator View filter used to display the 
 * review elements unassigned to participants.
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.internal.filters;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIAnomalyBasic;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIAnomalyContainer;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIContent;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIContentsContainer;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIFileContext;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIPostponedFile;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIReviewItem;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class UnassignParticipantFilter extends ViewerFilter {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method select.
	 * 
	 * @param aViewer
	 *            Viewer
	 * @param aParentElement
	 *            Object
	 * @param aElement
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean select(Viewer aViewer, Object aParentElement, Object aElement) {

		//Only Review elements that are unassigned are shown
		if (aElement instanceof R4EUIReviewItem) {
			if (((R4EUIReviewItem) aElement).getItem().getAssignedTo().size() == 0) {
				return true;
			} else {
				List<R4EUIFileContext> files = ((R4EUIReviewItem) aElement).getFileContexts();
				for (R4EUIFileContext file : files) {
					if (file.getFileContext().getAssignedTo().size() == 0) {
						return true;
					} else {
						IR4EUIModelElement[] contents = file.getContentsContainerElement().getChildren();
						for (IR4EUIModelElement content : contents) {
							if (((R4EUIContent) content).getContent().getAssignedTo().size() == 0) {
								return true;
							}
						}
						IR4EUIModelElement[] anomalies = file.getAnomalyContainerElement().getChildren();
						for (IR4EUIModelElement anomaly : anomalies) {
							if (((R4EUIAnomalyBasic) anomaly).getAnomaly().getAssignedTo().size() == 0) {
								return true;
							}
						}
					}
				}
			}
			return false;
		} else if (aElement instanceof R4EUIFileContext) {
			if (aElement instanceof R4EUIPostponedFile) {
				return true;
			}
			if (((R4EUIFileContext) aElement).getFileContext().getAssignedTo().size() == 0) {
				return true;
			} else {
				IR4EUIModelElement[] contents = ((R4EUIFileContext) aElement).getContentsContainerElement()
						.getChildren();
				for (IR4EUIModelElement content : contents) {
					if (((R4EUIContent) content).getContent().getAssignedTo().size() == 0) {
						return true;
					}
				}
				IR4EUIModelElement[] anomalies = ((R4EUIFileContext) aElement).getAnomalyContainerElement()
						.getChildren();
				for (IR4EUIModelElement anomaly : anomalies) {
					if (((R4EUIAnomalyBasic) anomaly).getAnomaly().getAssignedTo().size() == 0) {
						return true;
					}
				}
			}
			return false;
		} else if (aElement instanceof R4EUIContentsContainer) {
			IR4EUIModelElement[] contents = ((IR4EUIModelElement) aElement).getChildren();
			for (IR4EUIModelElement content : contents) {
				if (((R4EUIContent) content).getContent().getAssignedTo().size() == 0) {
					return true;
				}
			}
			return false;
		} else if (aElement instanceof R4EUIContent) {
			if (((R4EUIContent) aElement).getContent().getAssignedTo().size() == 0) {
				return true;
			}
			return false;
		} else if (aElement instanceof R4EUIAnomalyBasic) {
			if (((R4EUIAnomalyBasic) aElement).getAnomaly().getAssignedTo().size() == 0) {
				return true;
			}
			return false;
		} else if (aElement instanceof R4EUIContentsContainer) {
			if (((R4EUIContentsContainer) aElement).getChildren().length == 0) {
				return false;
			}
			for (IR4EUIModelElement child : ((R4EUIContentsContainer) aElement).getChildren()) {
				if (((R4EUIContent) child).getContent().getAssignedTo().size() == 0) {
					return true;
				}
			}
			return false;
		} else if (aElement instanceof R4EUIAnomalyContainer) {
			if (((R4EUIAnomalyContainer) aElement).getChildren().length == 0) {
				return false;
			}
			for (IR4EUIModelElement child : ((R4EUIAnomalyContainer) aElement).getChildren()) {
				if (((R4EUIAnomalyBasic) child).getAnomaly().getAssignedTo().size() == 0) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
