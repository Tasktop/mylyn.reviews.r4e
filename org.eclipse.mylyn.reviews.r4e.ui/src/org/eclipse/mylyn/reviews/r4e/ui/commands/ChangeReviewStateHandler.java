// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class implements the context-sensitive command to set an element
 * as reviewed/not reviewed
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.commands;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIModelElement;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class ChangeReviewStateHandler extends AbstractHandler {

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
			for (final Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
				try {
					element = (IR4EUIModelElement) iterator.next();
					Activator.Ftracer.traceInfo("Changing review state for element " + element.getName());
					element.setReviewed(!(element.isReviewed()));
				} catch (ResourceHandlingException e) {
					Activator.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
					Activator.getDefault().logError("Exception: " + e.toString(), e);
					final ErrorDialog dialog = new ErrorDialog(null, "Error", "Error while creating element ", // $codepro.audit.disable variableDeclaredInLoop
		    				new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
					dialog.open();			
				} catch (OutOfSyncException e) {
					Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
					final ErrorDialog dialog = new ErrorDialog(null, "Error", "Synchronization error detected while adding element.  " + // $codepro.audit.disable variableDeclaredInLoop
							"Please refresh the review navigator view and try the command again",
		    				new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
					dialog.open();
					// TODO later we will want to do this automatically 
				}
			}
		}
		return null;
	}
}
