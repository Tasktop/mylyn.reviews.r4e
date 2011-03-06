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
 * This class implements the tabbed property section for the additional properties
 * for the Review Group model element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.properties.tabbed;

import org.eclipse.emf.common.util.EList;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewGroup;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIReviewGroup;
import org.eclipse.mylyn.reviews.r4e.ui.utils.EditableListWidget;
import org.eclipse.mylyn.reviews.r4e.ui.utils.IEditableListListener;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class ReviewGroupExtraTabPropertySection extends ModelElementTabPropertySection implements IEditableListListener {

	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------
	
	/**
	 * Field fAvailableProjects.
	 */
	protected EditableListWidget fAvailableProjects = null;
	
	/**
	 * Field fAvailableComponents.
	 */
	protected EditableListWidget fAvailableComponents = null;
	
	/**
	 * Field FEntryCriteriaText.
	 */
	protected Text fDefaultEntryCriteriaText = null;
	
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method dispose.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
	 */
	@Override
	public void dispose() {
		if (null != fAvailableProjects) fAvailableProjects.dispose();
		if (null != fAvailableComponents)fAvailableComponents.dispose();
		super.dispose();
	}
	
	/**
	 * Method shouldUseExtraSpace.
	 * @return boolean
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}
	
	/**
	 * Method createControls.
	 * @param parent Composite
	 * @param aTabbedPropertySheetPage TabbedPropertySheetPage
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(Composite, TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent.getParent(), aTabbedPropertySheetPage);

		final TabbedPropertySheetWidgetFactory widgetFactory = aTabbedPropertySheetPage.getWidgetFactory();
	    final Composite composite = widgetFactory.createFlatFormComposite(parent);
		FormData data = null;
		
	    //Projects
		data = new FormData();
		data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        fAvailableProjects = new EditableListWidget(widgetFactory, composite, data, this, 1, Text.class, null);

	    final CLabel projectsLabel = widgetFactory.createCLabel(composite, R4EUIConstants.AVAILABLE_PROJECTS_LABEL);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fAvailableProjects.getComposite(), -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(fAvailableProjects.getComposite(), 0, SWT.TOP);
	    projectsLabel.setLayoutData(data);
	    
	    //Components
		data = new FormData();
		data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
		data.top = new FormAttachment(fAvailableProjects.getComposite(), ITabbedPropertyConstants.VSPACE);
	    fAvailableComponents = new EditableListWidget(widgetFactory, composite, data, this, 2, Text.class, null);

	    final CLabel componentsLabel = widgetFactory.createCLabel(composite, R4EUIConstants.AVAILABLE_COMPONENTS_LABEL);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fAvailableComponents.getComposite(), -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(fAvailableComponents.getComposite(), 0, SWT.TOP);
	    componentsLabel.setLayoutData(data);
	    
	    //Entry Criteria
	    fDefaultEntryCriteriaText = widgetFactory.createText(composite, "", SWT.MULTI);
		data = new FormData();
		data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
		data.top = new FormAttachment(fAvailableComponents.getComposite(), ITabbedPropertyConstants.VSPACE);
		fDefaultEntryCriteriaText.setLayoutData(data);
	    fDefaultEntryCriteriaText.addFocusListener(new FocusListener() {		
			public void focusLost(FocusEvent e) {
				if (!fRefreshInProgress) {
					try {
						final String currentUser = R4EUIModelController.getReviewer();
						final R4EReviewGroup modelGroup = ((R4EUIReviewGroup)fProperties.getElement()).getReviewGroup();
						final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelGroup, currentUser);
						modelGroup.setDefaultEntryCriteria(fDefaultEntryCriteriaText.getText());
						R4EUIModelController.FResourceUpdater.checkIn(bookNum);
					} catch (ResourceHandlingException e1) {
						UIUtils.displayResourceErrorDialog(e1);
					} catch (OutOfSyncException e1) {
						UIUtils.displaySyncErrorDialog(e1);
					}
				}
			}
			public void focusGained(FocusEvent e) { // $codepro.audit.disable emptyMethod
				//Nothing to do
			}
		});
	    UIUtils.addTabbedPropertiesTextResizeListener(fDefaultEntryCriteriaText);
	    
	    final CLabel entryCriteriaLabel = widgetFactory.createCLabel(composite, R4EUIConstants.DEFAULT_ENTRY_CRITERIA_LABEL);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fDefaultEntryCriteriaText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(fDefaultEntryCriteriaText, 0, SWT.TOP);
		entryCriteriaLabel.setLayoutData(data);
	}
	
	/**
	 * Method refresh.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		fRefreshInProgress = true;
		final R4EReviewGroup modelReview = ((R4EUIReviewGroup)fProperties.getElement()).getGroup();
	
		final String[] projects = (String[]) modelReview.getAvailableProjects().toArray();
		fAvailableProjects.clearAll();
		Item item = null;
		for (int i = 0; i < projects.length; i++) {
			String project  = projects[i];
			if (i >= fAvailableProjects.getItemCount()) {
				item = fAvailableProjects.addItem(); 
			} else {
				item = fAvailableProjects.getItem(i);
				if (null == item) item = fAvailableProjects.addItem(); 
			}
			item.setText(project);
		}
		final String[] components = (String[]) modelReview.getAvailableComponents().toArray();
		fAvailableComponents.clearAll();
		for (int i = 0; i < components.length; i++) {
			String component  = components[i];
			if (i >= fAvailableComponents.getItemCount()) {
				item = fAvailableComponents.addItem();
			} else {
				item = fAvailableComponents.getItem(i);
				if (null == item) item = fAvailableComponents.addItem();
			}
			item.setText(component);
		}
		fDefaultEntryCriteriaText.setText(modelReview.getDefaultEntryCriteria());
		setEnabledFields();
		fRefreshInProgress = false;
	}
	
	/**
	 * Method setEnabledFields.
	 */
	@Override
	protected void setEnabledFields() {
		if (R4EUIModelController.isDialogOpen() || (!((R4EUIReviewGroup)fProperties.getElement()).isOpen())) {
			fAvailableProjects.setEnabled(false);
			fAvailableComponents.setEnabled(false);
			fDefaultEntryCriteriaText.setEnabled(false);
		} else {
			fAvailableProjects.setEnabled(true);
			fAvailableComponents.setEnabled(true);
			fDefaultEntryCriteriaText.setEnabled(true);
		}
	}

	/**
	 * Method itemsUpdated.
	 * @param aItems Item[]
	 * @param aInstanceId int
	 * @see org.eclipse.ui.utils.IEditableListListener#itemsUpdated(Item[] aItems)
	 */
	public void itemsUpdated(Item[] aItems, int aInstanceId) {
		// Update the core model data with new data
		try {
			if (1 == aInstanceId) {
				//First widget: available projects
				if (!fRefreshInProgress) {
					final String currentUser = R4EUIModelController.getReviewer();
					final R4EReviewGroup modelGroup = ((R4EUIReviewGroup)fProperties.getElement()).getReviewGroup();
					final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelGroup, currentUser);
					final EList<String> projects = modelGroup.getAvailableProjects();
					projects.clear();
					for (Item item : aItems) {
						projects.add(item.getText());
					}
					R4EUIModelController.FResourceUpdater.checkIn(bookNum);
				}
			} else if (2 == aInstanceId) {
				//Second widget: available components
				if (!fRefreshInProgress) {
					final String currentUser = R4EUIModelController.getReviewer();
					final R4EReviewGroup modelGroup = ((R4EUIReviewGroup)fProperties.getElement()).getReviewGroup();
					final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelGroup, currentUser);
					final EList<String> components = modelGroup.getAvailableComponents();
					components.clear();
					for (Item item : aItems) {
						components.add(item.getText());
					}
					R4EUIModelController.FResourceUpdater.checkIn(bookNum);
				}
			}
			refresh();
		} catch (ResourceHandlingException e1) {
			UIUtils.displayResourceErrorDialog(e1);
		} catch (OutOfSyncException e1) {
			UIUtils.displaySyncErrorDialog(e1);
		}
	}
}
