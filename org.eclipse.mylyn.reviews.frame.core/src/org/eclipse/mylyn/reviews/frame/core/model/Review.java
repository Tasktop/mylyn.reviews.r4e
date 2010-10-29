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
 *   Alvaro Sanchez-Leon - Initial Implementation and API
 *******************************************************************************/
package org.eclipse.mylyn.reviews.frame.core.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Review</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getTopics <em>Topics</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getReview_items <em>Review items</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getReviewTask <em>Review Task</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.reviews.frame.core.model.ModelPackage#getReview()
 * @model
 * @generated
 */
public interface Review extends ReviewComponent {
	/**
	 * Returns the value of the '<em><b>Topics</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.mylyn.reviews.frame.core.model.Topic}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.mylyn.reviews.frame.core.model.Topic#getReview <em>Review</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topics</em>' reference list.
	 * @see org.eclipse.mylyn.reviews.frame.core.model.ModelPackage#getReview_Topics()
	 * @see org.eclipse.mylyn.reviews.frame.core.model.Topic#getReview
	 * @model opposite="review" transient="true" derived="true"
	 * @generated
	 */
	EList<Topic> getTopics();

	/**
	 * Returns the value of the '<em><b>Review items</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.mylyn.reviews.frame.core.model.Item}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.mylyn.reviews.frame.core.model.Item#getReview <em>Review</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Review items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Review items</em>' reference list.
	 * @see org.eclipse.mylyn.reviews.frame.core.model.ModelPackage#getReview_Review_items()
	 * @see org.eclipse.mylyn.reviews.frame.core.model.Item#getReview
	 * @model opposite="review" transient="true" derived="true"
	 * @generated
	 */
	EList<Item> getReview_items();

	/**
	 * Returns the value of the '<em><b>Review Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Review Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Review Task</em>' containment reference.
	 * @see #setReviewTask(TaskReference)
	 * @see org.eclipse.mylyn.reviews.frame.core.model.ModelPackage#getReview_ReviewTask()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	TaskReference getReviewTask();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getReviewTask <em>Review Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Review Task</em>' containment reference.
	 * @see #getReviewTask()
	 * @generated
	 */
	void setReviewTask(TaskReference value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference.
	 * @see #setState(ReviewState)
	 * @see org.eclipse.mylyn.reviews.frame.core.model.ModelPackage#getReview_State()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ReviewState getState();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.reviews.frame.core.model.Review#getState <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' containment reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(ReviewState value);

} // Review
