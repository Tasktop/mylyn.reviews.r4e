// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
/*******************************************************************************
 * Copyright (c) 2011, 2012 Ericsson AB and others.
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class implements the context-sensitive command to add a new anomaly
 * that is linked to the currently selected element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.commands.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIAnomalyContainer;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIContent;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIFileContext;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUITextPosition;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.R4EUIConstants;

/**
 * @author Sebastien Dubois
 * @version $Revision: 1.0 $
 */
public class NewLinkedAnomalyHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	/**
	 * Field COMMAND_MESSAGE. (value is ""Adding Linked Anomaly..."")
	 */
	private static final String COMMAND_MESSAGE = "Adding Linked Anomaly...";

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method execute.
	 * 
	 * @param event
	 *            ExecutionEvent
	 * @return Object
	 * @see org.eclipse.core.commands.IHandler#execute(ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) {

		final ISelection selection = R4EUIModelController.getNavigatorView().getTreeViewer().getSelection();

		final Job job = new Job(COMMAND_MESSAGE) {
			public String familyName = R4EUIConstants.R4E_UI_JOB_FAMILY;

			@Override
			public boolean belongsTo(Object family) {
				return familyName.equals(family);
			}

			@Override
			public IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(COMMAND_MESSAGE, IProgressMonitor.UNKNOWN);
				R4EUIModelController.setJobInProgress(true);

				if (selection instanceof IStructuredSelection) {
					//Add a linked anomaly to this selection
					if (!selection.isEmpty()) {
						final Object element = ((IStructuredSelection) selection).getFirstElement();
						if (element instanceof R4EUIContent) {
							R4EUIPlugin.Ftracer.traceInfo("Adding Linked " + "Anomaly to Element " //$NON-NLS-1$ //$NON-NLS-2$
									+ ((IR4EUIModelElement) element).getName());
							addLinkedAnomaly((R4EUIContent) element);
						}
					}
				}

				R4EUIModelController.setJobInProgress(false);
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(false);
		job.schedule();
		return null;
	}

	/**
	 * Method addLinkedAnomaly.
	 * 
	 * @param aElement
	 *            R4EUIContent
	 */
	private void addLinkedAnomaly(R4EUIContent aElement) {
		final R4EUIFileContext fileContext = (R4EUIFileContext) aElement.getParent().getParent();
		final R4EUIAnomalyContainer container = (fileContext.getAnomalyContainerElement());
		container.createAnomaly(fileContext, (R4EUITextPosition) aElement.getPosition(), false);
	}
}
