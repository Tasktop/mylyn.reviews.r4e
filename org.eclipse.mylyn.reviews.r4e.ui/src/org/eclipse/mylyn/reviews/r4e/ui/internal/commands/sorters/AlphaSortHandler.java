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
 * This class implements the navigator view toolbar command to apply the 
 * default alphabetical sorter
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.commands.sorters;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.navigator.ReviewNavigatorActionGroup;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.UIUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.IEvaluationService;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class AlphaSortHandler extends AbstractHandler {

	/**
	 * Method execute.
	 * 
	 * @param aEvent
	 *            ExecutionEvent
	 * @return Object
	 * @throws ExecutionException
	 * @see org.eclipse.core.commands.IHandler#execute(ExecutionEvent)
	 */
	public Object execute(ExecutionEvent aEvent) throws ExecutionException {

		//We need to preserve the expansion state and restore it afterwards
		final TreeViewer viewer = R4EUIModelController.getNavigatorView().getTreeViewer();
		final ViewerComparator sorter = ((ReviewNavigatorActionGroup) R4EUIModelController.getNavigatorView()
				.getActionSet()).getAlphaSorter();

		final Object[] elements = viewer.getExpandedElements();
		boolean oldValue = HandlerUtil.toggleCommandState(aEvent.getCommand());

		if (!oldValue) {
			R4EUIPlugin.Ftracer.traceInfo("Apply alpha sorter to ReviewNavigator");
			viewer.setComparator(sorter);
		} else {
			R4EUIPlugin.Ftracer.traceInfo("Remove alpha sorter from ReviewNavigator");
			viewer.setComparator(null);
		}
		R4EUIModelController.getNavigatorView().getTreeViewer().setExpandedElements(elements);

		try {
			final IEvaluationService evService = (IEvaluationService) HandlerUtil.getActiveWorkbenchWindowChecked(aEvent)
					.getService(IEvaluationService.class);
			evService.requestEvaluation(R4EUIConstants.ALPHA_SORTER_COMMAND);
			evService.requestEvaluation(R4EUIConstants.REVIEW_TYPE_SORTER_COMMAND);
		} catch (ExecutionException e) {
			R4EUIPlugin.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
		}
		//Refresh view if possible
		final ISelection selection = HandlerUtil.getCurrentSelection(aEvent);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IR4EUIModelElement) {
				UIUtils.setNavigatorViewFocus((IR4EUIModelElement) element, 0);
			}
		}
		return null;
	}
}
