// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, staticFieldSecurity, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity, com.instantiations.assist.eclipse.analysis.instanceFieldSecurity
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
 * This class implements the tabbed property section for the Anomaly model element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EAnomaly;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIPosition;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIAnomaly;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class AnomalyTabPropertySection extends AbstractPropertySection implements IPropertyListener {
	
	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------
	
	/**
	 * Field fAnomaly.
	 */
	protected AnomalyProperties fAnomalyProps;
	
	/**
	 * Field fPosition.
	 */
	private IR4EUIPosition fPosition;
	
	/**
	 * Field FTitleText.
	 */
	protected static Text FTitleText = null;
	
	/**
	 * Field FAuthorText.
	 */
	protected static Text FAuthorText = null;
	
	/**
	 * Field FCreationDateText.
	 */
	protected static Text FCreationDateText = null;
	
	/**
	 * Field FPositionText.
	 */
	protected static Text FPositionText = null;
	
	/**
	 * Field FDescriptionText.
	 */
	protected static Text FDescriptionText = null;

	/**
	 * Field fRefreshInProgress.
	 */
	private boolean fRefreshInProgress = false;

	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method dispose.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		R4EUIModelController.removeDialogStateListener(this);
	}
	
	/**
	 * Method createControls.
	 * @param parent Composite
	 * @param aTabbedPropertySheetPage TabbedPropertySheetPage
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(Composite, TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		R4EUIModelController.addDialogStateListener(this);

		//Tell element to build its own detailed tab layout
		final TabbedPropertySheetWidgetFactory widgetFactory = aTabbedPropertySheetPage.getWidgetFactory();
		final Composite composite = widgetFactory.createFlatFormComposite(parent);
	    FormData data = null;
	   
	    //Anomaly title
	    FTitleText = widgetFactory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
	    FTitleText.setLayoutData(data);
	    FTitleText.addModifyListener(new ModifyListener() {			 // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.avoidInnerClasses
			@SuppressWarnings("synthetic-access")
			public void modifyText(ModifyEvent e) {
				if (!fRefreshInProgress) {
					try {
						final String currentUser = R4EUIModelController.getReviewer();
						final R4EAnomaly modelAnomaly = ((R4EUIAnomaly)fAnomalyProps.getElement()).getAnomaly();
						final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelAnomaly, currentUser);
						modelAnomaly.setTitle(FTitleText.getText());
						R4EUIModelController.FResourceUpdater.checkIn(bookNum);
					} catch (ResourceHandlingException e1) {
						UIUtils.displayResourceErrorDialog(e1);
					} catch (OutOfSyncException e1) {
						UIUtils.displaySyncErrorDialog(e1);
					}
				}
			}
		});

	    final CLabel titleLabel = widgetFactory.createCLabel(composite, R4EUIConstants.TITLE_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(FTitleText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(FTitleText, 0, SWT.CENTER);
	    titleLabel.setLayoutData(data);
	    
	    //Anomaly Author (read-only)
	    FAuthorText = widgetFactory.createText(composite, "");
	    FAuthorText.setEditable(false);
	    FAuthorText.setEnabled(false);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(FTitleText, ITabbedPropertyConstants.VSPACE);
	    FAuthorText.setLayoutData(data);
	
	    final CLabel authorLabel = widgetFactory.createCLabel(composite, R4EUIConstants.AUTHOR_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(FAuthorText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(FAuthorText, 0, SWT.CENTER);
	    authorLabel.setLayoutData(data);
	
	    //Anomaly Creation Date (read-only)
	    FCreationDateText = widgetFactory.createText(composite, "");
	    FCreationDateText.setEditable(false);
	    FCreationDateText.setEnabled(false);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(FAuthorText, ITabbedPropertyConstants.VSPACE);
	    FCreationDateText.setLayoutData(data);
	
	    final CLabel creationDateLabel = widgetFactory.createCLabel(composite, R4EUIConstants.CREATION_DATE_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(FCreationDateText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(FCreationDateText, 0, SWT.CENTER);
	    creationDateLabel.setLayoutData(data);
	    
	    //Anomaly position (read-only)
	    FPositionText = widgetFactory.createText(composite, "");
	    FPositionText.setEditable(false);
	    FPositionText.setEnabled(false);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(FCreationDateText, ITabbedPropertyConstants.VSPACE);
	    FPositionText.setLayoutData(data);
	
	    final CLabel positionLabel = widgetFactory.createCLabel(composite, R4EUIConstants.POSITION_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(FPositionText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(FPositionText, 0, SWT.CENTER);
	    positionLabel.setLayoutData(data);
	    
	    //Review Description
	    FDescriptionText = widgetFactory.createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(FPositionText, ITabbedPropertyConstants.VSPACE);
	    data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE); // $codepro.audit.disable numericLiterals
	    FDescriptionText.setLayoutData(data);
	    FDescriptionText.addModifyListener(new ModifyListener() {			 // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.avoidInnerClasses
	    	@SuppressWarnings("synthetic-access")
			public void modifyText(ModifyEvent e) {
	    		if (!fRefreshInProgress) {
	    			try {
	    				final String currentUser = R4EUIModelController.getReviewer();
						final R4EAnomaly modelAnomaly = ((R4EUIAnomaly)fAnomalyProps.getElement()).getAnomaly();
	    				final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelAnomaly, currentUser);
	    				modelAnomaly.setDescription(FDescriptionText.getText());
	    				R4EUIModelController.FResourceUpdater.checkIn(bookNum);
	    			} catch (ResourceHandlingException e1) {
	    				UIUtils.displayResourceErrorDialog(e1);
	    			} catch (OutOfSyncException e1) {
	    				UIUtils.displaySyncErrorDialog(e1);
	    			}
	    		}
	    	}
	    });
	    
	    final CLabel descriptionLabel = widgetFactory.createCLabel(composite, R4EUIConstants.DESCRIPTION_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(FDescriptionText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(FDescriptionText, 0, SWT.TOP);
	    descriptionLabel.setLayoutData(data);
	}
		
	/**
	 * Method setInput.
	 * @param part IWorkbenchPart
	 * @param aSelection ISelection
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(IWorkbenchPart, ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection aSelection) {
		//Get current selection.
		if (null == aSelection || aSelection.isEmpty()) return;
		
		//Get model element selected
		final IR4EUIModelElement element = (IR4EUIModelElement) ((StructuredSelection)aSelection).getFirstElement();
		if (null != element && element instanceof R4EUIAnomaly) {
			fAnomalyProps = (AnomalyProperties) ((R4EUIAnomaly)element).getAdapter(IPropertySource.class);
			refresh();
		}
	}

	/**
	 * Method refresh.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		fRefreshInProgress = true;
		final R4EAnomaly modelAnomaly = ((R4EUIAnomaly)fAnomalyProps.getElement()).getAnomaly();
		FTitleText.setText(modelAnomaly.getTitle());
		FAuthorText.setText(modelAnomaly.getUser().getId());
		FCreationDateText.setText(modelAnomaly.getCreatedOn().toString());
		fPosition = ((R4EUIAnomaly)fAnomalyProps.getElement()).getPosition();
		if (null == fPosition) {
			FPositionText.setText(R4EUIConstants.GLOBAL_ANOMALY_PROPERTY_VALUE);
		} else {
			FPositionText.setText(fPosition.toString());
		}
		FDescriptionText.setText(modelAnomaly.getDescription());
		setEnabledFields();
		fRefreshInProgress = false;
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
	 * Method propertyChanged.
	 * @param source Object
	 * @param propId int
	 * @see org.eclipse.ui.IPropertyListener#propertyChanged(Object, int)
	 */
	public void propertyChanged(Object source, int propId) {
		setEnabledFields();
	}
	
	/**
	 * Method setEditableFields.
	 */
	private void setEnabledFields() {
		if (R4EUIModelController.isDialogOpen()) {
			FTitleText.setEnabled(false);
			FDescriptionText.setEnabled(false);
		} else {
			FTitleText.setEnabled(true);
			FDescriptionText.setEnabled(true);
		}
	}
}