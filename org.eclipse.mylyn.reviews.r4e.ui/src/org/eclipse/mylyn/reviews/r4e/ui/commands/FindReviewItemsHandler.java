// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class implements the context-sensitive command to find review items
 * in the parent project to add to the review
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.commands;

import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.dialogs.FindReviewItemsDialog;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class FindReviewItemsHandler extends AbstractHandler {

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

		//Get project to use (use adapters if needed)
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		final Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
		IProject project = null;
		//NOTE:  The valadity testes are done if the ProjectPropertyTester class
		if (selectedElement instanceof IProject) { 
			project = (IProject) selectedElement;
		} else if (selectedElement instanceof IJavaProject) {
			project = ((IJavaProject)selectedElement).getProject();
		} else if (selectedElement instanceof ICProject) {
			project = ((ICProject)selectedElement).getProject();
		} else if (selectedElement instanceof IPackageFragment || selectedElement instanceof IPackageFragmentRoot) {
			project = ((IJavaElement)selectedElement).getJavaProject().getProject();
		} else if (selectedElement instanceof IFolder) {
			project = ((IFolder)selectedElement).getProject();
		} else if (selectedElement instanceof IAdaptable) {
			final IAdaptable adaptableProject = (IAdaptable) selectedElement; 
			project = (IProject) adaptableProject.getAdapter(IProject.class); 
		} else {
			//Should never happen
			Activator.Ftracer.traceError("No project defined for selection of class " + selectedElement.getClass());
			Activator.getDefault().logError("No project defined for selection of class " + selectedElement.getClass(), null);
			final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Find Review Item Error",
    				new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "No project defined for selection", null), IStatus.ERROR);
			dialog.open();
			return null;
		}
	
		//Fire up the find review items dialog to get the latest commit info for the first selection
		//TODO:  This should be changed to use the new core interface for the current Version control system.
		R4EUIModelController.setDialogOpen(true);

		final FindReviewItemsDialog dialog = new FindReviewItemsDialog(R4EUIModelController.getNavigatorView().
				getSite().getWorkbenchWindow().getShell(), project);
    	dialog.open();
    	//Note the review item will be added to the review in the dialog if needed
		R4EUIModelController.setDialogOpen(false);
		return null;
	}
}
