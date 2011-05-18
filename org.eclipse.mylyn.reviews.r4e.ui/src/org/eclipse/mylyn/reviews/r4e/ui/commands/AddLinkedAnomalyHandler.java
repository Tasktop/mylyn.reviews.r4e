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
 * This class implements the context-sensitive command to add a new anomaly
 * that is linked to the currently selected element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.core.versions.ReviewVersionsException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIAnomalyBasic;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIAnomalyContainer;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIContent;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIFileContext;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUITextPosition;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class AddLinkedAnomalyHandler extends AbstractHandler {

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
	public Object execute(ExecutionEvent event) {

		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			//TODO: This is a long-running operation.  For now set cursor.  Later we want to start a job here
			final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			shell.setCursor(shell.getDisplay().getSystemCursor(SWT.CURSOR_WAIT));

			//Add a linked anomaly to this selection
			if (!selection.isEmpty()) {
				final IR4EUIModelElement element = ((IR4EUIModelElement) ((IStructuredSelection) selection).getFirstElement());
				if (element instanceof R4EUIContent) {
					try {
						Activator.Ftracer.traceInfo("Adding linked anomaly to element " + element.getName());
						addLinkedAnomaly((R4EUIContent) element);
					} catch (ResourceHandlingException e) {
						UIUtils.displayResourceErrorDialog(e);
					} catch (OutOfSyncException e) {
						UIUtils.displaySyncErrorDialog(e);
					}
				}
			}
			shell.setCursor(null);
		}
		return null;
	}

	/**
	 * Method addLinkedAnomaly.
	 * 
	 * @param aElement
	 *            R4EUISelection
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 * @throws ReviewVersionsException
	 */
	private void addLinkedAnomaly(R4EUIContent aElement) throws ResourceHandlingException, OutOfSyncException {

		final R4EUIFileContext fileContext = (R4EUIFileContext) aElement.getParent().getParent();
		R4EUIAnomalyContainer container = (R4EUIAnomalyContainer) (fileContext.getAnomalyContainerElement());
		//Get data from user
		if (null == container) {
			container = new R4EUIAnomalyContainer(fileContext, R4EUIConstants.ANOMALIES_LABEL);
			fileContext.addChildren(container);
		}

		final R4EUIAnomalyBasic uiAnomaly = container.createAnomaly(fileContext.getTargetFileVersion(),
				(R4EUITextPosition) aElement.getPosition());
		if (null != uiAnomaly) {
			//Set focus to newly created anomaly comment
			R4EUIModelController.getNavigatorView()
					.getTreeViewer()
					.expandToLevel(uiAnomaly, AbstractTreeViewer.ALL_LEVELS);
			R4EUIModelController.getNavigatorView()
					.getTreeViewer()
					.setSelection(new StructuredSelection(uiAnomaly), true);
		}
	}
}
