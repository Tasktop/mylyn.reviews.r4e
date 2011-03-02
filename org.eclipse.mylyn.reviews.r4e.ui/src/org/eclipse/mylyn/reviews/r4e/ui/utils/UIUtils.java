// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class provides general utility methods used in the UI implementation
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.core.versions.ReviewVersionsException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class UIUtils {
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
    /**
     * Load the current image and add it to the image registry
     * @param url - the localtion of the image to load
     * @return Image
     */
    public static Image loadIcon(String url) {
    	final Activator plugin = Activator.getDefault();
        Image icon = plugin.getImageRegistry().get(url);
        if (null == icon) {
            final URL imageURL = plugin.getBundle().getEntry(url);
            final ImageDescriptor descriptor = ImageDescriptor.createFromURL(imageURL);
            icon = descriptor.createImage();
            plugin.getImageRegistry().put(url, icon);
        }
        return icon;
    }
    
    /**
     * Method displayResourceErrorDialog.
     * @param e ResourceHandlingException
     */
    public static void displayResourceErrorDialog(ResourceHandlingException e) {
		Activator.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
		Activator.getDefault().logError("Exception: " + e.toString(), e);
		final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Resource Error Detected",
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
		dialog.open();
    }
    
    /**
     * Method displaySyncErrorDialog.
     * @param e OutOfSyncException
     */
    public static void displaySyncErrorDialog(OutOfSyncException e) {
		Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
		final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Synchronization Error Detected" +
				"Please refresh the review navigator view and try the command again",
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
		dialog.open();
		// TODO later we will want to do this automatically
    }
    
    /**
     * Method displayVersionErrorDialog.
     * @param e ReviewVersionsException
     */
    public static void displayVersionErrorDialog(ReviewVersionsException e) {
    	Activator.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
    	Activator.getDefault().logError("Exception: " + e.toString(), e);
    	final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Version Error Detected",
    			new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e), IStatus.ERROR);
    	dialog.open();
    }
    
    /**
     * Method isFilterPreferenceSet.
     * @param aFilterSet Object
     * @return boolean
     */
    public static boolean isFilterPreferenceSet(Object aFilterSet) {
    	if (null != aFilterSet && aFilterSet.toString().equals(R4EUIConstants.VALUE_TRUE_STR)) return true;
    	return false;
    }
    
    /**
     * Method parseStringList.
     * @param aStringList String
     * @return List<String>
     */
    public static List<String> parseStringList(String aStringList) {
        final List<String> stringArray = new ArrayList<String>();
        if (null != aStringList) {
        	final StringTokenizer st = new StringTokenizer(aStringList, File.pathSeparator + 
        			System.getProperty("line.separator"));
        	while (st.hasMoreElements()) {
        		stringArray.add((String)st.nextElement());
        	}
        }
        return stringArray;
	}
    
    /**
     * Method addTabbedPropertiesTextResizeListener.
     * 	Resizes a Text widget in a ScrolledComposite to fit the text being typed.  It also adds scrollbars to the composite as needed
     * @param aText Text - The Text widget
     * @return none
     */
    //TODO this only works for flatFormComposites and not vanilla ones.  For now this is not a big deal, but we will want to review it later
    //A new auto-resizable text widget class should be created for this eventually
    public static void addTabbedPropertiesTextResizeListener(final Text aText) {
    	aText.addModifyListener(new ModifyListener() {
	    	public void modifyText(ModifyEvent e) {
	    		//compute new Text field size
	    	    final Point newSize = aText.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	    	    final Point oldSize = aText.getSize();
	    	    int heightDiff = newSize.y - oldSize.y;
	    	    if (heightDiff != 0) {
	    	    	aText.setSize(newSize);
	    	    	aText.getParent().layout();
	    	    	
	    	    	//Set scrollable height so that scrollbar appear if needed
	    	    	ScrolledComposite scrolledParent = (ScrolledComposite) aText.getParent().getParent().getParent().getParent().getParent().getParent();
	    	    	scrolledParent.setMinSize(aText.getParent().computeSize(SWT.DEFAULT, SWT.DEFAULT));
	    	    	
	    	    	//If the text falls outside of the display scroll down to reposition
	    	    	if ((aText.getLocation().y + aText.getCaretLocation().y + aText.getLineHeight()) >
	    	    		(scrolledParent.getClientArea().y + scrolledParent.getClientArea().height)) {
		    	    	
		    	    	Point origin = scrolledParent.getOrigin();
		    	    	origin.y += heightDiff;
		    	    	
		    	    	scrolledParent.setOrigin(origin);
	    	    	}
	    	    }    
	    	}
	    });
    }
}
