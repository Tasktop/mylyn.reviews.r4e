// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, staticFieldSecurity, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity, explicitThisUsage
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
 * This class implements the tabbed property section for the Rule model 
 * element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.properties.tabbed;

import org.eclipse.mylyn.reviews.r4e.core.model.R4ECommentType;
import org.eclipse.mylyn.reviews.r4e.core.model.drules.DRModelFactory;
import org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRule;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.Persistence.RModelFactoryExt;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIRule;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIRuleViolation;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class RuleTabPropertySection extends ModelElementTabPropertySection {
	
	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------
	
	/**
	 * Field fIdText.
	 */
	private CLabel fIdText = null;
	
	/**
	 * Field fTitleText.
	 */
	private CLabel fTitleText = null;
	
	/**
	 * Field fDescriptionText.
	 */
	private CLabel fDescriptionText = null;
	
	/**
	 * Field fClassCombo.
	 */
	protected CCombo fClassCombo = null;
	
	/**
	 * Field fRankCombo.
	 */
	protected CCombo fRankCombo = null;
	
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method createControls.
	 * @param parent Composite
	 * @param aTabbedPropertySheetPage TabbedPropertySheetPage
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(Composite, TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		//Tell element to build its own detailed tab layout
		final TabbedPropertySheetWidgetFactory widgetFactory = aTabbedPropertySheetPage.getWidgetFactory();
		final Composite composite = widgetFactory.createFlatFormComposite(parent);
	    FormData data = null;
	   
	    //ID
	    fIdText = widgetFactory.createCLabel(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	    fIdText.setLayoutData(data);
	    fIdText.addFocusListener(new FocusListener() {		
			public void focusLost(FocusEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelRule, currentUser);
	    				modelRule.setId(fIdText.getText());
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
	    
	    final CLabel idLabel = widgetFactory.createCLabel(composite, R4EUIConstants.ID_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fIdText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fIdText, 0, SWT.CENTER);
	    idLabel.setLayoutData(data);
	    
	    //Title
	    fTitleText = widgetFactory.createCLabel(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fIdText, ITabbedPropertyConstants.VSPACE);
	    fTitleText.setLayoutData(data);
	    fTitleText.addFocusListener(new FocusListener() {		
			public void focusLost(FocusEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelRule, currentUser);
	    				modelRule.setTitle(fTitleText.getText());
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
	    
	    final CLabel titleLabel = widgetFactory.createCLabel(composite, R4EUIConstants.TITLE_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fTitleText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fTitleText, 0, SWT.CENTER);
	    titleLabel.setLayoutData(data);
	    
	    //Description
	    fDescriptionText = widgetFactory.createCLabel(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fTitleText, ITabbedPropertyConstants.VSPACE);
	    fDescriptionText.setLayoutData(data);
	    fDescriptionText.addFocusListener(new FocusListener() {		
			public void focusLost(FocusEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelRule, currentUser);
	    				modelRule.setDescription(fDescriptionText.getText());
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
	    
	    final CLabel descriptionLabel = widgetFactory.createCLabel(composite, R4EUIConstants.DESCRIPTION_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fDescriptionText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fDescriptionText, 0, SWT.CENTER);
	    descriptionLabel.setLayoutData(data);
	    
	    //Class
	    fClassCombo = widgetFactory.createCCombo(composite, SWT.READ_ONLY);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fDescriptionText, ITabbedPropertyConstants.VSPACE);
	    fClassCombo.setLayoutData(data);
	    fClassCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelRule, currentUser);
	    				final R4ECommentType type = RModelFactoryExt.eINSTANCE.createR4ECommentType();
	    				type.setType(UIUtils.getClassFromString(fClassCombo.getText()));
	    				modelRule.setType(type);
	    				R4EUIModelController.FResourceUpdater.checkIn(bookNum);
	    			} catch (ResourceHandlingException e1) {
	    				UIUtils.displayResourceErrorDialog(e1);
	    			} catch (OutOfSyncException e1) {
	    				UIUtils.displaySyncErrorDialog(e1);
	    			}
	    		}
    			refresh();
			}
			public void widgetDefaultSelected(SelectionEvent e) { // $codepro.audit.disable emptyMethod
				//No implementation needed
			}
		});
	    
	    final CLabel classLabel = widgetFactory.createCLabel(composite, R4EUIConstants.CLASS_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fClassCombo, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fClassCombo, 0, SWT.CENTER);
	    classLabel.setLayoutData(data);
	    
	    //Rank
	    fRankCombo = widgetFactory.createCCombo(composite, SWT.READ_ONLY);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fClassCombo, ITabbedPropertyConstants.VSPACE);
	    fRankCombo.setLayoutData(data);
	    fRankCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelRule, currentUser);
	    				modelRule.setRank(UIUtils.getRankFromString(fRankCombo.getText()));
	    				R4EUIModelController.FResourceUpdater.checkIn(bookNum);
	    			} catch (ResourceHandlingException e1) {
	    				UIUtils.displayResourceErrorDialog(e1);
	    			} catch (OutOfSyncException e1) {
	    				UIUtils.displaySyncErrorDialog(e1);
	    			}
	    		}	
    			refresh();
			}
			public void widgetDefaultSelected(SelectionEvent e) { // $codepro.audit.disable emptyMethod
				//No implementation needed
			}
		});
	    
	    final CLabel rankLabel = widgetFactory.createCLabel(composite, R4EUIConstants.RANK_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fRankCombo, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fRankCombo, 0, SWT.CENTER);
	    rankLabel.setLayoutData(data);
	}

	/**
	 * Method refresh.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		if (null != ((R4EUIRule)fProperties.getElement()).getRule()) {
			fRefreshInProgress = true;
			final R4EDesignRule modelRule = ((R4EUIRule)fProperties.getElement()).getRule();
			fIdText.setText(modelRule.getId());
			fTitleText.setText(modelRule.getTitle());
			fDescriptionText.setText(modelRule.getDescription());
			fClassCombo.setItems(UIUtils.getClasses());
			if (null != modelRule.getType() && null != ((R4ECommentType)modelRule.getType()).getType()) {
				fClassCombo.select(((R4ECommentType)modelRule.getType()).getType().getValue());
			}
			fRankCombo.setItems(UIUtils.getRanks());
			fRankCombo.select(modelRule.getRank().getValue());
			setEnabledFields();
			fRefreshInProgress = false;
		}
	}
	
	/**
	 * Method setEnabledFields.
	 */
	@Override
	protected void setEnabledFields() {
		if (R4EUIModelController.isDialogOpen()) {
			fIdText.setEnabled(false);
			fTitleText.setEnabled(false);
			fDescriptionText.setEnabled(false);
			fClassCombo.setEnabled(false);
			fRankCombo.setEnabled(false);
		} else {
			fIdText.setEnabled(true);
			fTitleText.setEnabled(true);
			fDescriptionText.setEnabled(true);
			fClassCombo.setEnabled(true);
			fRankCombo.setEnabled(true);
		}
	}
}
