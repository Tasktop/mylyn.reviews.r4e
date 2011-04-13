// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
/*******************************************************************************
 * Copyright (c) 2010 Ericsson Research Canada
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class implements the context-sensitive command used 
 * to remove the currently selected element form the model
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.commands;

import java.io.FileNotFoundException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EFormalReview;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReview;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewPhase;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewType;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.core.versions.ReviewVersionsException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIReviewItem;
import org.eclipse.mylyn.reviews.r4e.ui.utils.MailServicesProxy;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class RestoreElementHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method execute.
	 * @param event ExecutionEvent
	 * @return Object 
	 * @throws ExecutionException
	 * @see org.eclipse.core.commands.IHandler#execute(ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) {

		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		if (!selection.isEmpty()) {
			IR4EUIModelElement element = null;
			R4EReview review = R4EUIModelController.getActiveReview().getReview();
			for (final Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
				try {
					element = (IR4EUIModelElement) iterator.next();
					Activator.Ftracer.traceInfo("Restore element " + element.getName());
					element.setEnabled(true);
					element.open();
					R4EUIModelController.getNavigatorView().getTreeViewer().refresh();  //TODO temporary fix to restore element properly
					
	    			if (element instanceof R4EUIReviewItem) {
	    				//Send email notification if needed
	    				if (review.getType().equals(R4EReviewType.R4E_REVIEW_TYPE_FORMAL)) {
	    					if (((R4EFormalReview)review).getCurrent().equals(R4EReviewPhase.R4E_REVIEW_PHASE_PREPARATION)) {
	    						MailServicesProxy.sendItemsReadyNotification();
	    					}
	    				}
	    			}
				} catch (ResourceHandlingException e) {
					UIUtils.displayResourceErrorDialog(e);
				} catch (OutOfSyncException e) {
					UIUtils.displaySyncErrorDialog(e);
				} catch (FileNotFoundException e) {
			    	Activator.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
			    	Activator.getDefault().logError("Exception: " + e.toString(), e);
				} catch (ReviewVersionsException e) {
					UIUtils.displayVersionErrorDialog(e);
				} catch (CoreException e) {
					UIUtils.displayCoreErrorDialog(e);
				}
			}
		}
		return null;
	}
}
