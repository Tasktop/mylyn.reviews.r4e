/*******************************************************************************
 * Copyright (c) 2010, 2012 Ericsson AB and others.
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * This class defines the base class for the tabbed proprties for all UI elements
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.properties.tabbed;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.properties.general.ModelElementProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.forms.widgets.FormUtil;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

/**
 * @author Sebastien Dubois
 * @version $Revision: 1.0 $
 */
public class ModelElementTabPropertySection extends AbstractPropertySection implements IPropertyListener {

	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------

	/**
	 * Field fReviewProps.
	 */
	protected ModelElementProperties fProperties;

	/**
	 * Field fRefreshInProgress.
	 */
	protected boolean fRefreshInProgress = false;

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method setInput.
	 * 
	 * @param part
	 *            IWorkbenchPart
	 * @param aSelection
	 *            ISelection
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(IWorkbenchPart, ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection aSelection) {

		//Get current selection.
		if (null == aSelection || aSelection.isEmpty()) {
			return;
		}

		//Get model element selected
		final IR4EUIModelElement element = (IR4EUIModelElement) ((StructuredSelection) aSelection).getFirstElement();
		if (null != element) {
			fProperties = (ModelElementProperties) ((R4EUIModelElement) element).getAdapter(IPropertySource.class);
			refresh();
		}
	}

	/**
	 * Method propertyChanged.
	 * 
	 * @param source
	 *            Object
	 * @param propId
	 *            int
	 * @see org.eclipse.ui.IPropertyListener#propertyChanged(Object, int)
	 */
	public void propertyChanged(Object source, int propId) {
		refresh();
	}

	/**
	 * Method refresh.
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		//default implementation
		fRefreshInProgress = true;
		setEnabledFields();
		fRefreshInProgress = false;
	}

	/**
	 * Method setEnabledFields.
	 */
	protected void setEnabledFields() { // $codepro.audit.disable emptyMethod
		//default implementation
	}

	/**
	 * Method scroll.
	 * 
	 * @param aComp
	 *            ScrolledComposite
	 * @param aXOffset
	 *            int
	 * @param aYOffset
	 *            int
	 */
	public static void scroll(ScrolledComposite aComp, int aXOffset, int aYOffset) {
		final Point origin = aComp.getOrigin();
		final Point contentSize = aComp.getContent().getSize();
		int xorigin = origin.x + aXOffset;
		int yorigin = origin.y + aYOffset;
		xorigin = Math.max(xorigin, 0);
		xorigin = Math.min(xorigin, contentSize.x - 1);
		yorigin = Math.max(yorigin, 0);
		yorigin = Math.min(yorigin, contentSize.y - 1);
		aComp.setOrigin(xorigin, yorigin);
	}

	/**
	 * Method addScrollListener. Transfer scrolling from Combo box to the parent scrolled form
	 * 
	 * @param aCombo
	 *            CCombo
	 */
	public static void addScrollListener(final CCombo aCombo) {
		aCombo.addListener(SWT.MouseVerticalWheel, new Listener() {
			@SuppressWarnings("restriction")
			public void handleEvent(Event event) {
				final ScrolledComposite form = FormUtil.getScrolledComposite(aCombo);
				aCombo.select(aCombo.getSelectionIndex());
				if (null != form && null != form.getVerticalBar()) {
					if (event.count < 0) {
						// scroll form down
						scroll(form, 0, form.getVerticalBar().getIncrement());
					} else {
						// scroll form up
						scroll(form, 0, -form.getVerticalBar().getIncrement());
					}
				}
				event.doit = false;
			}
		});
	}
}
