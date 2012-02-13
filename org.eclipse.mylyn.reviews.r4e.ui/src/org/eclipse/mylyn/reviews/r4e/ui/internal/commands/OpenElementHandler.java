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
 * This class implements the review navigator view toolbar command used 
 * to browse the view's treeviewer elements and open the ones that can be open
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.commands;

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
 * This class implements the context-sensitive command to open the
 * currently selected element and load data from the model
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

import java.io.FileNotFoundException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.CompatibilityException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.core.versions.ReviewVersionsException;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIReviewBasic;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.UIUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.services.IEvaluationService;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class OpenElementHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method execute.
	 * 
	 * @param event
	 *            ExecutionEvent
	 * @return Object
	 * @throws ExecutionException
	 * @see org.eclipse.core.commands.IHandler#execute(ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) {

		final UIJob job = new UIJob("Opening Element...") {

			public String familyName = R4EUIConstants.R4E_UI_JOB_FAMILY;

			@Override
			public boolean belongsTo(Object family) {
				return familyName.equals(family);
			}

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				final ISelection selection = HandlerUtil.getCurrentSelection(event);
				if (selection instanceof IStructuredSelection) {
					if (!selection.isEmpty()) {
						IR4EUIModelElement element = null;
						try {
							element = (IR4EUIModelElement) ((IStructuredSelection) selection).getFirstElement();

							if (element instanceof R4EUIReviewBasic) {
								R4EUIPlugin.Ftracer.traceInfo("Opening element " + element.getName());
								final R4EUIReviewBasic activeReview = R4EUIModelController.getActiveReview();
								if (null != activeReview) {
									activeReview.close();
								}
							}
							element.open();
							UIUtils.setNavigatorViewFocus(element, 1);
						} catch (ResourceHandlingException e) {
							UIUtils.displayResourceErrorDialog(e);
							//make sure the element is released from memory
							if (element != null && element instanceof R4EUIReviewBasic) {
								element.close();
							}
						} catch (CompatibilityException e) {
							UIUtils.displayCompatibilityErrorDialog(e);
							//make sure the element is released from memory
							if (element != null && element instanceof R4EUIReviewBasic) {
								element.close();
							}
						} catch (ReviewVersionsException e) {
							UIUtils.displayVersionErrorDialog(e);

						} catch (FileNotFoundException e) {
							R4EUIPlugin.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
							R4EUIPlugin.getDefault().logError("Exception: " + e.toString(), e);
							final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR,
									"File not found error detected while opening element", new Status(IStatus.ERROR,
											R4EUIPlugin.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
							dialog.open();
						}
					}
				}
				try {
					final IEvaluationService evService = (IEvaluationService) HandlerUtil.getActiveWorkbenchWindowChecked(
							event)
							.getService(IEvaluationService.class);
					evService.requestEvaluation("org.eclipse.mylyn.reviews.r4e.ui.commands.nextState");
					evService.requestEvaluation("org.eclipse.mylyn.reviews.r4e.ui.commands.previousState");
				} catch (ExecutionException e) {
					R4EUIPlugin.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
		return null;
	}
}
