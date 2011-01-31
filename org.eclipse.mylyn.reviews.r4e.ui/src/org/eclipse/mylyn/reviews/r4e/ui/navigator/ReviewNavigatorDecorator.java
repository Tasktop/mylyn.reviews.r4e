// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, useForLoop, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class implements a label decorator for the Review Navigator View.  
 * It is used to modify the label text and icons based on various criteria
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.navigator;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontDecorator;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.mylyn.reviews.r4e.ui.model.IR4EUIModelElement;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIReview;
import org.eclipse.mylyn.reviews.r4e.ui.utils.OverlayImageIcon;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;


/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class ReviewNavigatorDecorator implements ILabelDecorator, IFontDecorator {

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method addListener.
	 * @param listener ILabelProviderListener
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Method dispose.
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Method isLabelProperty.
	 * @param element Object
	 * @param property String
	 * @return boolean
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(Object, String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * Method removeListener.
	 * @param listener ILabelProviderListener
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Method decorateImage.
	 * @param aBaseImage Image
	 * @param element Object
	 * @return Image
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(Image, Object)
	 */
	public Image decorateImage(Image aBaseImage, Object element) { // $codepro.audit.disable
			 
		if (((IR4EUIModelElement)element).isReviewed()) {
			final OverlayImageIcon overlayIcon = new OverlayImageIcon(aBaseImage, ((IR4EUIModelElement)element).getReviewedImage() , OverlayImageIcon.BOTTOM_RIGHT); 
			return overlayIcon.getImage();	
		}
		return null;
	}

	/**
	 * Method decorateText.
	 * @param aText String
	 * @param aElement Object
	 * @return String
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(String, Object)
	 */
	public String decorateText(String aText, Object aElement) {
		if (isMyReview((IR4EUIModelElement)aElement) && aElement instanceof R4EUIReview) {
			return "> " + aText;
		}
		return null;
	}

	/**
	 * Method decorateFont.
	 * @param aElement Object
	 * @return Font
	 * @see org.eclipse.jface.viewers.IFontDecorator#decorateFont(Object)
	 */
	public Font decorateFont(Object aElement) { // $codepro.audit.disable
		if (isMyReview((IR4EUIModelElement)aElement)) {
		   return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
		}
		return null;
	}
	
	/**
	 * Verifies whether this element in a Review element and, if so, if we are part of it
	 * @param aElement - the model element
	 * @return - true if this is a review and we are part of it, false otherwise
	 */
	private boolean isMyReview(IR4EUIModelElement aElement) {
		
		IR4EUIModelElement currentElement = aElement;
		while (null != currentElement) {
			if (currentElement instanceof R4EUIReview) {
				if (((R4EUIReview)currentElement).isParticipant(R4EUIModelController.getReviewer())) {
					return true;
				}
			}
			currentElement = currentElement.getParent();
		}
		return false;
	}
}
