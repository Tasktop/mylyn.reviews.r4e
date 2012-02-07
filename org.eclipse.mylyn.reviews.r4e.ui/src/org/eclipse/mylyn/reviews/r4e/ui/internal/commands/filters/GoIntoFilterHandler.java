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
 * This class implements the navigator view toolbar command set/unset the tree viewer input to
 * the currently selected element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.commands.filters;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.ui.R4EUIPlugin;
import org.eclipse.mylyn.reviews.r4e.ui.internal.filters.FocusFilter;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.internal.navigator.ReviewNavigatorActionGroup;
import org.eclipse.mylyn.reviews.r4e.ui.internal.navigator.ReviewNavigatorTreeViewer;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class GoIntoFilterHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

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
		final ReviewNavigatorTreeViewer viewer = (ReviewNavigatorTreeViewer) R4EUIModelController.getNavigatorView()
				.getTreeViewer();
		final Object[] elements = viewer.getVisibleExpandedElements();
		final FocusFilter filter = ((ReviewNavigatorActionGroup) R4EUIModelController.getNavigatorView().getActionSet()).getFocusFilter();

		//Set current element as root level for the navigator tree
		final Command command = aEvent.getCommand();
		boolean oldValue = HandlerUtil.toggleCommandState(command);
		if (!oldValue) {
			final IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
			if (null != selection) {
				final IR4EUIModelElement element = (IR4EUIModelElement) selection.getFirstElement();
				if (null != element) {
					R4EUIPlugin.Ftracer.traceInfo("Setting focus on current element");
					R4EUIModelController.setCurrentFocusElement(element);
					viewer.setInput(element.getParent());
					viewer.setDefaultInput(element.getParent());
					viewer.addFilter(filter);
					viewer.setExpandedElements(elements);
				}
			}
		} else {
			R4EUIPlugin.Ftracer.traceInfo("Removing focus");
			viewer.removeFilter(filter);
			R4EUIModelController.setCurrentFocusElement(R4EUIModelController.getRootElement());
			if (R4EUIModelController.getNavigatorView().isDefaultDisplay()) {
				viewer.setInput(R4EUIModelController.getRootElement());
			} else { //Assume TreeTable display
				viewer.setInput(R4EUIModelController.getActiveReview());
				viewer.setDefaultInput(R4EUIModelController.getRootElement());
			}
			if (0 < elements.length) {
				for (Object element : elements) {
					viewer.expandToLevel((element), 1);
				}
			}
		}
		return null;
	}

}
