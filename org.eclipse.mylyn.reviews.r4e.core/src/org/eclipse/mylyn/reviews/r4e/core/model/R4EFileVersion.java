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
 * Alvaro Sanchez-Leon  - Initial API and implementation
 * 
 */
package org.eclipse.mylyn.reviews.r4e.core.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>R4E File Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getPlatformURI <em>Platform URI</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getVersionID <em>Version ID</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getRepositoryPath <em>Repository Path</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion()
 * @model
 * @generated
 */
public interface R4EFileVersion extends EObject {

	/**
	 * Returns the value of the '<em><b>Platform URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform URI</em>' attribute.
	 * @see #setPlatformURI(String)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion_PlatformURI()
	 * @model
	 * @generated
	 */
	String getPlatformURI();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getPlatformURI <em>Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform URI</em>' attribute.
	 * @see #getPlatformURI()
	 * @generated
	 */
	void setPlatformURI(String value);

	/**
	 * Returns the value of the '<em><b>Version ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version ID</em>' attribute.
	 * @see #setVersionID(String)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion_VersionID()
	 * @model
	 * @generated
	 */
	String getVersionID();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getVersionID <em>Version ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version ID</em>' attribute.
	 * @see #getVersionID()
	 * @generated
	 */
	void setVersionID(String value);

	/**
	 * Returns the value of the '<em><b>Repository Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Path</em>' attribute.
	 * @see #setRepositoryPath(String)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion_RepositoryPath()
	 * @model
	 * @generated
	 */
	String getRepositoryPath();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getRepositoryPath <em>Repository Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Path</em>' attribute.
	 * @see #getRepositoryPath()
	 * @generated
	 */
	void setRepositoryPath(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(IResource)
	 * @see org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage#getR4EFileVersion_Resource()
	 * @model dataType="org.eclipse.mylyn.reviews.r4e.core.model.IResource" transient="true" derived="true"
	 * @generated
	 */
	IResource getResource();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.r4e.core.model.R4EFileVersion#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(IResource value);
} // R4EFileVersion
