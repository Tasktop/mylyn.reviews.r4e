/*******************************************************************************
 * Copyright (c) 2010 Ericsson
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Description:
 * 
 * Contributors:
 *   Alvaro Sanchez-Leon - Initial Implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.mylyn.reviews.r4e.core.model.serial.impl;
/**
 * @author lmcalvs
 * 
 */
public class CompatibilityException extends Exception {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------
	/**
	 * @param message
	 */
	public CompatibilityException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param chainedExc
	 *            - Original chained Exception
	 */
	public CompatibilityException(String message, Throwable chainedExc) {
		super(message, chainedExc);
	}

	/**
	 * @param chainedExc
	 *            Original chained Exception
	 */
	CompatibilityException(Throwable chainedExc) {
		super(chainedExc);
	}

}
