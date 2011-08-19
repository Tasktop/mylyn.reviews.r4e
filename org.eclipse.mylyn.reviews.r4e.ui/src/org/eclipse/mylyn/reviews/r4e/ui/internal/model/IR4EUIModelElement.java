// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.disallowReturnMutable, packageJavadoc
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
 * This interface defines the methods used to access and control the UI model
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   Jacques Bouthillier - Add method definition for Report
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.internal.model;

import java.io.FileNotFoundException;

import org.eclipse.mylyn.reviews.frame.core.model.ReviewComponent;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.core.versions.ReviewVersionsException;
import org.eclipse.mylyn.reviews.r4e.ui.internal.navigator.ReviewNavigatorContentProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */

public interface IR4EUIModelElement {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------

	//Attributes

	/**
	 * Method setName.
	 * 
	 * @param aName
	 *            String
	 */
	void setName(String aName);

	/**
	 * Get the element name
	 * 
	 * @return - the element name
	 */
	String getName();

	/**
	 * Method getToolTip.
	 * 
	 * @return String
	 */
	String getToolTip();

	/**
	 * Method setToolTip.
	 * 
	 * @param aToolTip
	 *            String
	 */
	void setToolTip(String aToolTip);

	/**
	 * Get the element image
	 * 
	 * @return - the element image
	 */
	Image getImage();

	/**
	 * Method setImage.
	 * 
	 * @param aLocation
	 *            String
	 */
	void setImage(String aLocation);

	/**
	 * Gets the overlay image that indicate that the element is reviewed
	 * 
	 * @return Image
	 */
	Image getUserReviewedImage();

	/**
	 * Gets the overlay image that indicate that the element is disabled
	 * 
	 * @return Image
	 */
	Image getDisabledImage();

	/**
	 * Gets the reviewed flag. Take note that this is not applicable to all model elements
	 * 
	 * @return true/false
	 */
	boolean isUserReviewed();

	/**
	 * Checks if the corresponding model element is enabled or disabled
	 * 
	 * @return true/false
	 */
	boolean isEnabled();

	/**
	 * Sets the reviewed flag. Take note that this is not applicable to all model elements
	 * 
	 * @param aReviewed
	 *            - the reviewed flag (true/false)
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 */
	void setUserReviewed(boolean aReviewed) throws ResourceHandlingException, OutOfSyncException;

	/**
	 * Sets the enabled flag. Take note that this is not applicable to all model elements
	 * 
	 * @param aEnabled
	 *            - the enable flag (true/false)
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 */
	void setEnabled(boolean aEnabled) throws ResourceHandlingException, OutOfSyncException;

	/**
	 * Set this child reviewed state
	 * 
	 * @param aReviewed
	 *            - the reviewed state
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 */
	void setChildUserReviewed(boolean aReviewed) throws ResourceHandlingException, OutOfSyncException;

	/**
	 * Checks if all the children of this parent are set as reviewed
	 * 
	 * @throws OutOfSyncException
	 * @throws ResourceHandlingException
	 */
	void checkToSetUserReviewed() throws ResourceHandlingException, OutOfSyncException;

	/**
	 * Open the model element (i.e. enable it)
	 * 
	 * @throws ResourceHandlingException
	 * @throws ReviewVersionsException
	 * @throws FileNotFoundException
	 */
	void open() throws ResourceHandlingException, ReviewVersionsException, FileNotFoundException;

	/**
	 * Checks whether an element is open or close
	 * 
	 * @return true if open, false otherwise
	 */
	boolean isOpen();

	/**
	 * Close the model element (i.e. disable it)
	 */
	void close();

	/**
	 * Create a serialization model element object
	 * 
	 * @return the new serialization element object
	 * @throws ResourceHandlingException
	 */
	ReviewComponent createChildModelDataElement() throws ResourceHandlingException;

	/**
	 * Set serialization model data by copying it from the passed-in object
	 * 
	 * @param aModelComponent
	 *            - a serialization model element to copy information from
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 */
	void setModelData(ReviewComponent aModelComponent) throws ResourceHandlingException, OutOfSyncException;

	//Properties

	/**
	 * Method setInput.
	 */
	void setInput();

	//Hierarchy

	/**
	 * Get the element parent
	 * 
	 * @return - the parent
	 */
	IR4EUIModelElement getParent();

	/**
	 * Get the element children
	 * 
	 * @return - the children
	 */
	IR4EUIModelElement[] getChildren();

	/**
	 * Check whether the element has children
	 * 
	 * @return true/false
	 */
	boolean hasChildren();

	/**
	 * Add a new children to the current element
	 * 
	 * @param tempModelComponent
	 *            - the serialization model component object
	 * @return IR4EUIModelElement
	 * @throws ResourceHandlingException
	 * @throws OutOfSyncException
	 */
	IR4EUIModelElement createChildren(ReviewComponent tempModelComponent) throws ResourceHandlingException,
			OutOfSyncException;

	/**
	 * Method addChildren.
	 * 
	 * @param aChildToAdd
	 *            IR4EUIModelElement
	 */
	void addChildren(IR4EUIModelElement aChildToAdd);

	/**
	 * Remove a child from the current element list
	 * 
	 * @param aChildToRemove
	 *            - the child to remove
	 * @param aFileRemove
	 *            - also remove from file (hard remove)
	 * @throws OutOfSyncException
	 * @throws ResourceHandlingException
	 */
	void removeChildren(IR4EUIModelElement aChildToRemove, boolean aFileRemove) throws ResourceHandlingException,
			OutOfSyncException;

	/**
	 * Method removeAllChildren.
	 * 
	 * @param aFileRemove
	 *            boolean
	 * @throws OutOfSyncException
	 * @throws ResourceHandlingException
	 */
	void removeAllChildren(boolean aFileRemove) throws ResourceHandlingException, OutOfSyncException;

	//Listeners

	/**
	 * Add a listener to the current element
	 * 
	 * @param aProvider
	 *            - the treeviewer content provider
	 */
	void addListener(ReviewNavigatorContentProvider aProvider);

	/**
	 * Remove the listener from the current element
	 * 
	 * @param aProvider
	 *            - the treeviewer content provider
	 */
	void removeListener(ReviewNavigatorContentProvider aProvider);

	/**
	 * Remove all listeners from the current element
	 */
	void removeListeners();

	/**
	 * Fire an add event to notify the UI of the model change
	 * 
	 * @param aAdded
	 *            - the added object
	 */
	void fireAdd(Object aAdded);

	/**
	 * Fire a remove event to notify the UI of the model change
	 * 
	 * @param aRemoved
	 *            - the removed object
	 */
	void fireRemove(Object aRemoved);

	/**
	 * Fire a review state changed event to notify the UI of the model change
	 * 
	 * @param aChanged
	 *            - the changed object
	 */
	void fireUserReviewStateChanged(Object aChanged);

	//Commands

	/**
	 * Method isAddLinkedAnomalyCmd.
	 * 
	 * @return boolean
	 */
	boolean isAddLinkedAnomalyCmd();

	/**
	 * Method isOpenEditorCmd.
	 * 
	 * @return boolean
	 */
	boolean isOpenEditorCmd();

	/**
	 * Method isChangeReviewStateCmd.
	 * 
	 * @return boolean
	 */
	boolean isChangeUserReviewStateCmd();

	/**
	 * Method isOpenElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isOpenElementCmd();

	/**
	 * Method getOpenElementCmdName.
	 * 
	 * @return String
	 */
	String getOpenElementCmdName();

	/**
	 * Method getOpenElementCmdTooltip.
	 * 
	 * @return String
	 */
	String getOpenElementCmdTooltip();

	/**
	 * Method isReportElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isReportElementCmd();

	/**
	 * Method getReportElementCmdName.
	 * 
	 * @return String
	 */
	String getReportElementCmdName();

	/**
	 * Method getReportElementCmdTooltip.
	 * 
	 * @return String
	 */
	public String getReportElementCmdTooltip();

	/**
	 * Method isCloseElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isCloseElementCmd();

	/**
	 * Method getCloseElementCmdName.
	 * 
	 * @return String
	 */
	String getCloseElementCmdName();

	/**
	 * Method getCloseElementCmdTooltip.
	 * 
	 * @return String
	 */
	String getCloseElementCmdTooltip();

	/**
	 * Method isRestoreElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isRestoreElementCmd();

	/**
	 * Method getRestoreElementCmdName.
	 * 
	 * @return String
	 */
	String getRestoreElementCmdName();

	/**
	 * Method getRestoreElementCmdTooltip.
	 * 
	 * @return String
	 */
	String getRestoreElementCmdTooltip();

	/**
	 * Method isNewChildElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isNewChildElementCmd();

	/**
	 * Method getNewChildElementCmdName.
	 * 
	 * @return String
	 */
	String getNewChildElementCmdName();

	/**
	 * Method getNewChildElementCmdTooltip.
	 * 
	 * @return String
	 */
	String getNewChildElementCmdTooltip();

	/**
	 * Method isRemoveElementCmd.
	 * 
	 * @return boolean
	 */
	boolean isRemoveElementCmd();

	/**
	 * Method getRemoveElementCmdName.
	 * 
	 * @return String
	 */
	String getRemoveElementCmdName();

	/**
	 * Method getRemoveElementCmdTooltip.
	 * 
	 * @return String
	 */
	String getRemoveElementCmdTooltip();

	/**
	 * Method isSendEmailCmd.
	 * 
	 * @return boolean
	 */
	boolean isSendEmailCmd();

	/**
	 * Method isImportPostponedCmd.
	 * 
	 * @return boolean
	 */
	boolean isImportPostponedCmd();
}
