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
 * This class encapsulates the properties for the AnomalyExtended UI model element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.internal.properties.general;

import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIAnomalyExtended;
import org.eclipse.mylyn.reviews.r4e.ui.internal.model.R4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.internal.utils.R4EUIConstants;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class AnomalyExtraProperties extends AnomalyBasicProperties {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	/**
	 * Field ANOMALY_STATE_ID. (value is ""anomalyElement.state"")
	 */
	private static final String ANOMALY_STATE_ID = "anomalyElement.state";

	/**
	 * Field ANOMALY_STATE_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor ANOMALY_STATE_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			ANOMALY_STATE_ID, R4EUIConstants.STATE_LABEL);

	/**
	 * Field ANOMALY_NOT_ACCEPTED_REASON_ID. (value is ""anomalyElement.notAcceptedReason"")
	 */
	private static final String ANOMALY_NOT_ACCEPTED_REASON_ID = "anomalyElement.notAcceptedReason";

	/**
	 * Field ANOMALY_NOT_ACCEPTED_REASON_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor ANOMALY_NOT_ACCEPTED_REASON_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			ANOMALY_NOT_ACCEPTED_REASON_ID, R4EUIConstants.NOT_ACCEPTED_REASON_LABEL);

	/**
	 * Field ANOMALY_DECIDED_BY_ID. (value is ""anomalyElement.decidedBy"")
	 */
	private static final String ANOMALY_DECIDED_BY_ID = "anomalyElement.decidedBy";

	/**
	 * Field ANOMALY_DECIDED_BY_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor ANOMALY_DECIDED_BY_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			ANOMALY_DECIDED_BY_ID, R4EUIConstants.DECIDED_BY_LABEL);

	/**
	 * Field ANOMALY_FIXED_BY_ID. (value is ""anomalyElement.fixedBy"")
	 */
	private static final String ANOMALY_FIXED_BY_ID = "anomalyElement.fixedBy";

	/**
	 * Field ANOMALY_FIXED_BY_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor ANOMALY_FIXED_BY_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			ANOMALY_FIXED_BY_ID, R4EUIConstants.FIXED_BY_LABEL);

	/**
	 * Field ANOMALY_FOLLOWUP_BY_ID. (value is ""anomalyElement.followupBy"")
	 */
	private static final String ANOMALY_FOLLOWUP_BY_ID = "anomalyElement.followupBy";

	/**
	 * Field ANOMALY_FOLLOWUP_BY_PROPERTY_DESCRIPTOR.
	 */
	protected static final PropertyDescriptor ANOMALY_FOLLOWUP_BY_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			ANOMALY_FOLLOWUP_BY_ID, R4EUIConstants.FOLLOWUP_BY_LABEL);

	/**
	 * Field DESCRIPTORS.
	 */
	private static final IPropertyDescriptor[] DESCRIPTORS = { ANOMALY_TITLE_PROPERTY_DESCRIPTOR,
			ANOMALY_POSITION_PROPERTY_DESCRIPTOR, ANOMALY_AUTHOR_PROPERTY_DESCRIPTOR,
			ANOMALY_CREATION_DATE_PROPERTY_DESCRIPTOR, ANOMALY_DESCRIPTION_PROPERTY_DESCRIPTOR,
			ANOMALY_STATE_PROPERTY_DESCRIPTOR, ANOMALY_DUE_DATE_PROPERTY_DESCRIPTOR, ANOMALY_CLASS_PROPERTY_DESCRIPTOR,
			ANOMALY_RANK_PROPERTY_DESCRIPTOR, ANOMALY_RULE_ID_PROPERTY_DESCRIPTOR,
			ANOMALY_NOT_ACCEPTED_REASON_PROPERTY_DESCRIPTOR, ANOMALY_DECIDED_BY_PROPERTY_DESCRIPTOR,
			ANOMALY_FIXED_BY_PROPERTY_DESCRIPTOR, ANOMALY_FOLLOWUP_BY_PROPERTY_DESCRIPTOR };

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Constructor for AnomalyProperties.
	 * 
	 * @param aElement
	 *            R4EUIModelElement
	 */
	public AnomalyExtraProperties(R4EUIModelElement aElement) {
		super(aElement);
	}

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	/**
	 * Method getPropertyDescriptors.
	 * 
	 * @return IPropertyDescriptor[]
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return DESCRIPTORS;
	}

	/**
	 * Method getPropertyValue.
	 * 
	 * @param aId
	 *            Object
	 * @return Object
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(Object)
	 */
	@Override
	public Object getPropertyValue(Object aId) {
		final Object result = super.getPropertyValue(aId);
		if (null != result) {
			return result;
		}
		if (ANOMALY_STATE_ID.equals(aId)) {
			return R4EUIAnomalyExtended.getStates()[Integer.valueOf(((R4EUIAnomalyExtended) getElement()).getAnomaly()
					.getState()
					.getValue())];
		} else if (ANOMALY_NOT_ACCEPTED_REASON_ID.equals(aId)) {
			if (null != ((R4EUIAnomalyExtended) getElement()).getAnomaly().getNotAcceptedReason()) {
				return ((R4EUIAnomalyExtended) getElement()).getAnomaly().getNotAcceptedReason();
			}
			return "";
		} else if (ANOMALY_DECIDED_BY_ID.equals(aId)) {
			if (null != ((R4EUIAnomalyExtended) getElement()).getAnomaly().getDecidedByID()) {
				return ((R4EUIAnomalyExtended) getElement()).getAnomaly().getDecidedByID();
			}
			return "";
		} else if (ANOMALY_FIXED_BY_ID.equals(aId)) {
			if (null != ((R4EUIAnomalyExtended) getElement()).getAnomaly().getFixedByID()) {
				return ((R4EUIAnomalyExtended) getElement()).getAnomaly().getFixedByID();
			}
			return "";
		} else if (ANOMALY_FOLLOWUP_BY_ID.equals(aId)) {
			if (null != ((R4EUIAnomalyExtended) getElement()).getAnomaly().getFollowUpByID()) {
				return ((R4EUIAnomalyExtended) getElement()).getAnomaly().getFollowUpByID();
			}
			return "";
		}
		return null;
	}
	//NOTE:  Since state management for anomalies is complex, the value are only editable using the tabbed properties view
}
