/**
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
 *    Alvaro Sanchez-Leon - Initial API and implementation
 * 
 */
package org.eclipse.mylyn.reviews.r4e.core.model.drules;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>R4E Design Rule Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleCollection#getAreas <em>Areas</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleCollection#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleCollection#getFilePaths <em>File Paths</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.reviews.r4e.core.model.drules.DRModelPackage#getR4EDesignRuleCollection()
 * @model
 * @generated
 */
public interface R4EDesignRuleCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Areas</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleArea}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Areas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Areas</em>' containment reference list.
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.drules.DRModelPackage#getR4EDesignRuleCollection_Areas()
	 * @model containment="true"
	 * @generated
	 */
	EList<R4EDesignRuleArea> getAreas();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.drules.DRModelPackage#getR4EDesignRuleCollection_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleCollection#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>File Paths</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Paths</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Paths</em>' attribute list.
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.drules.DRModelPackage#getR4EDesignRuleCollection_FilePaths()
	 * @model
	 * @generated
	 */
	EList<String> getFilePaths();

} // R4EDesignRuleCollection