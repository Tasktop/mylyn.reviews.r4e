/**
 * Copyright (c) 2011, 2012 Ericsson AB and others.
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ericsson AB - Initial implementation SMTP mail
 * 
 */
package org.eclipse.mylyn.reviews.r4e.mail.smtp;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Jacques Bouthillier
 *
 * @version $Revision: 1.0 $
 */

/**
 * The activator class controls the plug-in life cycle
 */
public class SmtpPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String FPLUGIN_ID = "org.eclipse.mylyn.reviews.r4e.mail.smtp"; //$NON-NLS-1$

	// The shared instance
	private static SmtpPlugin fPlugin = null;

	/**
	 * The constructor
	 */
	public SmtpPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		fPlugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		fPlugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static SmtpPlugin getDefault() {
		return fPlugin;
	}

}
