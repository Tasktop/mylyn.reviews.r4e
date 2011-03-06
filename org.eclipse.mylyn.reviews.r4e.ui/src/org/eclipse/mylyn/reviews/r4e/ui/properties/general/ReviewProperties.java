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
 * This class encapsulates the properties for the Review UI model element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.properties.general;

import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIReview;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class ReviewProperties extends ModelElementProperties {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------
	
	/**
	 * Field REVIEW_NAME_ID. (value is ""reviewElement.name"")
	 */
	protected static final String REVIEW_NAME_ID = "reviewElement.name";

	/**
	 * Field REVIEW_NAME_PROPERTY_DESCRIPTOR.
	 */
	protected static final TextPropertyDescriptor REVIEW_NAME_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_NAME_ID, R4EUIConstants.NAME_LABEL);

	/**
	 * Field REVIEW_START_DATE_ID. (value is ""reviewElement.startDate"")
	 */
	protected static final String REVIEW_START_DATE_ID = "reviewElement.startDate";

	/**
	 * Field REVIEW_START_DATE_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor REVIEW_START_DATE_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			REVIEW_START_DATE_ID, R4EUIConstants.START_DATE_LABEL);
	
	/**
	 * Field REVIEW_END_DATE_ID. (value is ""reviewElement.endDate"")
	 */
	protected static final String REVIEW_END_DATE_ID = "reviewElement.endDate";

	/**
	 * Field REVIEW_END_DATE_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor REVIEW_END_DATE_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			REVIEW_END_DATE_ID, R4EUIConstants.END_DATE_LABEL);
	
	/**
	 * Field REVIEW_DESCRIPTION_ID. (value is ""reviewElement.description"")
	 */
	protected static final String REVIEW_DESCRIPTION_ID = "reviewElement.description";

	/**
	 * Field REVIEW_DESCRIPTION_PROPERTY_DESCRIPTOR.
	 */
	protected static final TextPropertyDescriptor REVIEW_DESCRIPTION_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_DESCRIPTION_ID, R4EUIConstants.DESCRIPTION_LABEL);
	
	/**
	 * Field REVIEW_PROJECT_ID. (value is ""reviewElement.project"")
	 */
	private static final String REVIEW_PROJECT_ID = "reviewElement.project";

	/**
	 * Field REVIEW_PROJECT_PROPERTY_DESCRIPTOR.
	 */
	private static final TextPropertyDescriptor REVIEW_PROJECT_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_PROJECT_ID, R4EUIConstants.PROJECT_LABEL);
	
	/**
	 * Field REVIEW_COMPONENTS_ID. (value is ""reviewElement.components"")
	 */
	private static final String REVIEW_COMPONENTS_ID = "reviewElement.components";

	/**
	 * Field REVIEW_COMPONENTS_PROPERTY_DESCRIPTOR.
	 */
	private static final TextPropertyDescriptor REVIEW_COMPONENTS_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_COMPONENTS_ID, R4EUIConstants.COMPONENTS_LABEL);
	
	/**
	 * Field REVIEW_ENTRY_CRITERIA_ID. (value is ""reviewElement.entryCriteria"")
	 */
	private static final String REVIEW_ENTRY_CRITERIA_ID = "reviewElement.entryCriteria";

	/**
	 * Field REVIEW_ENTRY_CRITERIA_PROPERTY_DESCRIPTOR.
	 */
	private static final TextPropertyDescriptor REVIEW_ENTRY_CRITERIA_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_ENTRY_CRITERIA_ID, R4EUIConstants.ENTRY_CRITERIA_LABEL);
	
	/**
	 * Field REVIEW_OBJECTIVES_ID. (value is ""reviewElement.objectives"")
	 */
	private static final String REVIEW_OBJECTIVES_ID = "reviewElement.objectives";

	/**
	 * Field REVIEW_OBJECTIVES_PROPERTY_DESCRIPTOR.
	 */
	private static final TextPropertyDescriptor REVIEW_OBJECTIVES_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_OBJECTIVES_ID, R4EUIConstants.OBJECTIVES_LABEL);
	
	/**
	 * Field REVIEW_REFERENCE_MATERIAL_ID. (value is ""reviewElement.referenceMaterial"")
	 */
	private static final String REVIEW_REFERENCE_MATERIAL_ID = "reviewElement.referenceMaterial";

	/**
	 * Field REVIEW_REFERENCE_MATERIAL_PROPERTY_DESCRIPTOR.
	 */
	private static final TextPropertyDescriptor REVIEW_REFERENCE_MATERIAL_PROPERTY_DESCRIPTOR = new TextPropertyDescriptor(
			REVIEW_REFERENCE_MATERIAL_ID, R4EUIConstants.REFERENCE_MATERIAL_LABEL);
	
	/**
	 * Field DESCRIPTORS.
	 */
	private static final IPropertyDescriptor[] DESCRIPTORS = { REVIEW_NAME_PROPERTY_DESCRIPTOR,  
		REVIEW_START_DATE_PROPERTY_DESCRIPTOR, REVIEW_END_DATE_PROPERTY_DESCRIPTOR, 
		REVIEW_DESCRIPTION_PROPERTY_DESCRIPTOR, REVIEW_PROJECT_PROPERTY_DESCRIPTOR,
		REVIEW_COMPONENTS_PROPERTY_DESCRIPTOR, REVIEW_ENTRY_CRITERIA_PROPERTY_DESCRIPTOR,
		REVIEW_OBJECTIVES_PROPERTY_DESCRIPTOR, REVIEW_REFERENCE_MATERIAL_PROPERTY_DESCRIPTOR};
	
	
	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------
	
	/**
	 * Constructor for ReviewGeneralProperties.
	 * @param aElement R4EUIModelElement
	 */
	public ReviewProperties(R4EUIModelElement aElement) {
		super(aElement);
	}

	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method getPropertyDescriptors.
	 * @return IPropertyDescriptor[]
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return DESCRIPTORS;
	}
	
	/**
	 * Method getPropertyValue.
	 * @param aId Object
	 * @return Object
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(Object)
	 */
	@Override
	public Object getPropertyValue(Object aId) {
		if (null != getElement()) {
			if (REVIEW_NAME_ID.equals(aId)) { 
				return ((R4EUIReview)getElement()).getReview().getName();
			} else if (REVIEW_START_DATE_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getStartDate().toString();
			} else if (REVIEW_END_DATE_ID.equals(aId)) {
				if (null == ((R4EUIReview)getElement()).getReview().getEndDate()) return R4EUIConstants.IN_PROGRESS_MSG;
				return ((R4EUIReview)getElement()).getReview().getEndDate().toString();
			} else if (REVIEW_DESCRIPTION_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getExtraNotes();
			} else if (REVIEW_PROJECT_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getProject();
			} else if (REVIEW_COMPONENTS_ID.equals(aId)) { 
				return ((R4EUIReview)getElement()).getReview().getComponents().toString();
			} else if (REVIEW_ENTRY_CRITERIA_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getEntryCriteria();
			} else if (REVIEW_OBJECTIVES_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getObjectives();
			} else if (REVIEW_REFERENCE_MATERIAL_ID.equals(aId)) {
				return ((R4EUIReview)getElement()).getReview().getReferenceMaterial();
			}
		}
		return null;
	}

	/**
	 * Method setPropertyValue.
	 * @param aId Object
	 * @param aValue Object
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(Object, Object)
	 */
	@Override
	public void setPropertyValue(Object aId, Object aValue) { // $codepro.audit.disable emptyMethod
		if (!(R4EUIModelController.isDialogOpen()) && getElement().isOpen() && !getElement().isReviewed()) {
			try {
				if (REVIEW_NAME_ID.equals(aId)) { 
					final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(((R4EUIReview)getElement()).getReview(), 
							R4EUIModelController.getReviewer());
					((R4EUIReview)getElement()).getReview().setName((String) aValue);
					R4EUIModelController.FResourceUpdater.checkIn(bookNum);
				} else if (REVIEW_DESCRIPTION_ID.equals(aId)) {
					final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(((R4EUIReview)getElement()).getReview(), 
							R4EUIModelController.getReviewer());
					((R4EUIReview)getElement()).getReview().setExtraNotes((String) aValue);
					R4EUIModelController.FResourceUpdater.checkIn(bookNum);
				}
			} catch (ResourceHandlingException e) {
				UIUtils.displayResourceErrorDialog(e);
			} catch (OutOfSyncException e) {
				UIUtils.displaySyncErrorDialog(e);
			}
		}
	}
}
