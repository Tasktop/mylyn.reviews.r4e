// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
/*******************************************************************************
 * Copyright (c) 2012 Ericsson AB and others.
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class implements the context-sensitive command to assign participants
 * to a review element (Review Item, File Context, Contents, Anomaly)
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.commands.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EParticipant;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.UIUtils;

/**
 * @author Sebastien Dubois
 * @version $Revision: 1.0 $
 */
public class AddAssignHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	/**
	 * Field COMMAND_MESSAGE. (value is ""Add Assignees to Element..."")
	 */
	private static final String COMMAND_MESSAGE = "Add Assignees to Element...";

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method execute.
	 * 
	 * @param aEvent
	 *            ExecutionEvent
	 * @return Object
	 * @see org.eclipse.core.commands.IHandler#execute(ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent aEvent) {

		final ISelection selection = R4EUIModelController.getNavigatorView().getTreeViewer().getSelection();

		final Job job = new Job(COMMAND_MESSAGE) {

			public String familyName = R4EUIConstants.R4E_UI_JOB_FAMILY;

			@Override
			public boolean belongsTo(Object family) {
				return familyName.equals(family);
			}

			@Override
			public IStatus run(IProgressMonitor monitor) {
				if (selection instanceof IStructuredSelection) {
					if (!selection.isEmpty()) {
						Object element = null;

						element = ((IStructuredSelection) selection).getFirstElement();
						if (!(element instanceof IR4EUIModelElement)) {
							return Status.CANCEL_STATUS;
						}

						//Get participants to assign
						final List<R4EParticipant> participants = UIUtils.getAssignParticipants();

						//Assign them
						if (participants.size() > 0) {
							monitor.beginTask(COMMAND_MESSAGE, ((IStructuredSelection) selection).size());
							R4EUIModelController.setJobInProgress(true);

							for (final Iterator<?> iterator = ((IStructuredSelection) selection).iterator(); iterator.hasNext();) {
								element = iterator.next();
								if (!(element instanceof IR4EUIModelElement)) {
									continue;
								}
								R4EUIPlugin.Ftracer.traceInfo("Add Assignees..." //$NON-NLS-1$
										+ ((IR4EUIModelElement) element).getName());
								((IR4EUIModelElement) element).addAssignees(participants);

								monitor.worked(1);
								if (monitor.isCanceled()) {
									R4EUIModelController.setJobInProgress(false);
									UIUtils.setNavigatorViewFocus((IR4EUIModelElement) element, 0);
									return Status.CANCEL_STATUS;
								}
							}
							R4EUIModelController.setJobInProgress(false);
						}
						element = ((IStructuredSelection) selection).getFirstElement();
						UIUtils.setNavigatorViewFocus((IR4EUIModelElement) element, 0);
					}
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
		return null;
	}
}
