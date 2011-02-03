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
 * This class encapsulates the properties for the Selection UI model element
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.properties;

import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUISelection;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class SelectionProperties extends ModelElementProperties {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------
	
	/**
	 * Field SELECTION_POSITION_ID. (value is ""selectionElement.position"")
	 */
	private static final String SELECTION_POSITION_ID = "selectionElement.position";

	/**
	 * Field SELECTION_POSITION_PROPERTY_DESCRIPTOR.
	 */
	private static final PropertyDescriptor SELECTION_POSITION_PROPERTY_DESCRIPTOR = new PropertyDescriptor(
			SELECTION_POSITION_ID, R4EUIConstants.POSITION_LABEL);
	
	/**
	 * Field DESCRIPTORS.
	 */
	private static final IPropertyDescriptor[] DESCRIPTORS = { SELECTION_POSITION_PROPERTY_DESCRIPTOR };
	
	
	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------
	
	/**
	 * Constructor for SelectionProperties.
	 * @param aElement R4EUIModelElement
	 */
	public SelectionProperties(R4EUIModelElement aElement) {
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
		if (SELECTION_POSITION_ID.equals(aId)) {
			return ((R4EUISelection)getElement()).getPosition().toString();
		}
		return null;
	}
}
