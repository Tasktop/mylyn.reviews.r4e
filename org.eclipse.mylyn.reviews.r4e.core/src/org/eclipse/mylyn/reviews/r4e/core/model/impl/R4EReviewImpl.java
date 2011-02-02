/**
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
package org.eclipse.mylyn.reviews.r4e.core.model.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.mylyn.reviews.frame.core.model.impl.ReviewImpl;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EAnomaly;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EID;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EIDComponent;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReview;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewDecision;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewType;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EUser;
import org.eclipse.mylyn.reviews.r4e.core.model.RModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>R4E Review</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getEntryCriteria <em>Entry Criteria</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getExtraNotes <em>Extra Notes</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getObjectives <em>Objectives</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getReferenceMaterial <em>Reference Material</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getDecision <em>Decision</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getXmlVersion <em>Xml Version</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getAnomalyTemplate <em>Anomaly Template</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getUsersMap <em>Users Map</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.eclipse.mylyn.reviews.r4e.core.model.impl.R4EReviewImpl#getIdsMap <em>Ids Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class R4EReviewImpl extends ReviewImpl implements R4EReview {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected String project = PROJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<String> components;

	/**
	 * The default value of the '{@link #getEntryCriteria() <em>Entry Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCriteria()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_CRITERIA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryCriteria() <em>Entry Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCriteria()
	 * @generated
	 * @ordered
	 */
	protected String entryCriteria = ENTRY_CRITERIA_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtraNotes() <em>Extra Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTRA_NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtraNotes() <em>Extra Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraNotes()
	 * @generated
	 * @ordered
	 */
	protected String extraNotes = EXTRA_NOTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectives() <em>Objectives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectives()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECTIVES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectives() <em>Objectives</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectives()
	 * @generated
	 * @ordered
	 */
	protected String objectives = OBJECTIVES_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferenceMaterial() <em>Reference Material</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMaterial()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_MATERIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceMaterial() <em>Reference Material</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMaterial()
	 * @generated
	 * @ordered
	 */
	protected String referenceMaterial = REFERENCE_MATERIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDecision() <em>Decision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecision()
	 * @generated
	 * @ordered
	 */
	protected R4EReviewDecision decision;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXmlVersion() <em>Xml Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmlVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String XML_VERSION_EDEFAULT = "1.0.0";

	/**
	 * The cached value of the '{@link #getXmlVersion() <em>Xml Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmlVersion()
	 * @generated
	 * @ordered
	 */
	protected String xmlVersion = XML_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnomalyTemplate() <em>Anomaly Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnomalyTemplate()
	 * @generated
	 * @ordered
	 */
	protected R4EAnomaly anomalyTemplate;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final R4EReviewType TYPE_EDEFAULT = R4EReviewType.R4E_REVIEW_TYPE_BASIC;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected R4EReviewType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsersMap() <em>Users Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsersMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, R4EUser> usersMap;

	/**
	 * The cached value of the '{@link #getCreatedBy() <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
	protected R4EUser createdBy;

	/**
	 * The cached value of the '{@link #getIdsMap() <em>Ids Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<R4EID, R4EIDComponent> idsMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected R4EReviewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RModelPackage.Literals.R4E_REVIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(String newProject) {
		String oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__PROJECT, oldProject, project));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getComponents() {
		if (components == null) {
			components = new EDataTypeUniqueEList<String>(String.class, this, RModelPackage.R4E_REVIEW__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryCriteria() {
		return entryCriteria;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryCriteria(String newEntryCriteria) {
		String oldEntryCriteria = entryCriteria;
		entryCriteria = newEntryCriteria;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__ENTRY_CRITERIA, oldEntryCriteria, entryCriteria));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtraNotes() {
		return extraNotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtraNotes(String newExtraNotes) {
		String oldExtraNotes = extraNotes;
		extraNotes = newExtraNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__EXTRA_NOTES, oldExtraNotes, extraNotes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectives() {
		return objectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectives(String newObjectives) {
		String oldObjectives = objectives;
		objectives = newObjectives;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__OBJECTIVES, oldObjectives, objectives));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceMaterial() {
		return referenceMaterial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceMaterial(String newReferenceMaterial) {
		String oldReferenceMaterial = referenceMaterial;
		referenceMaterial = newReferenceMaterial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__REFERENCE_MATERIAL, oldReferenceMaterial, referenceMaterial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EReviewDecision getDecision() {
		if (decision != null && decision.eIsProxy()) {
			InternalEObject oldDecision = (InternalEObject)decision;
			decision = (R4EReviewDecision)eResolveProxy(oldDecision);
			if (decision != oldDecision) {
				InternalEObject newDecision = (InternalEObject)decision;
				NotificationChain msgs = oldDecision.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__DECISION, null, null);
				if (newDecision.eInternalContainer() == null) {
					msgs = newDecision.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__DECISION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RModelPackage.R4E_REVIEW__DECISION, oldDecision, decision));
			}
		}
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EReviewDecision basicGetDecision() {
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDecision(R4EReviewDecision newDecision, NotificationChain msgs) {
		R4EReviewDecision oldDecision = decision;
		decision = newDecision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__DECISION, oldDecision, newDecision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecision(R4EReviewDecision newDecision) {
		if (newDecision != decision) {
			NotificationChain msgs = null;
			if (decision != null)
				msgs = ((InternalEObject)decision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__DECISION, null, msgs);
			if (newDecision != null)
				msgs = ((InternalEObject)newDecision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__DECISION, null, msgs);
			msgs = basicSetDecision(newDecision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__DECISION, newDecision, newDecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmlVersion() {
		return xmlVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmlVersion(String newXmlVersion) {
		String oldXmlVersion = xmlVersion;
		xmlVersion = newXmlVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__XML_VERSION, oldXmlVersion, xmlVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EAnomaly getAnomalyTemplate() {
		if (anomalyTemplate != null && anomalyTemplate.eIsProxy()) {
			InternalEObject oldAnomalyTemplate = (InternalEObject)anomalyTemplate;
			anomalyTemplate = (R4EAnomaly)eResolveProxy(oldAnomalyTemplate);
			if (anomalyTemplate != oldAnomalyTemplate) {
				InternalEObject newAnomalyTemplate = (InternalEObject)anomalyTemplate;
				NotificationChain msgs = oldAnomalyTemplate.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, null, null);
				if (newAnomalyTemplate.eInternalContainer() == null) {
					msgs = newAnomalyTemplate.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, oldAnomalyTemplate, anomalyTemplate));
			}
		}
		return anomalyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EAnomaly basicGetAnomalyTemplate() {
		return anomalyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnomalyTemplate(R4EAnomaly newAnomalyTemplate, NotificationChain msgs) {
		R4EAnomaly oldAnomalyTemplate = anomalyTemplate;
		anomalyTemplate = newAnomalyTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, oldAnomalyTemplate, newAnomalyTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnomalyTemplate(R4EAnomaly newAnomalyTemplate) {
		if (newAnomalyTemplate != anomalyTemplate) {
			NotificationChain msgs = null;
			if (anomalyTemplate != null)
				msgs = ((InternalEObject)anomalyTemplate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, null, msgs);
			if (newAnomalyTemplate != null)
				msgs = ((InternalEObject)newAnomalyTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, null, msgs);
			msgs = basicSetAnomalyTemplate(newAnomalyTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE, newAnomalyTemplate, newAnomalyTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EReviewType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(R4EReviewType newType) {
		R4EReviewType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, R4EUser> getUsersMap() {
		if (usersMap == null) {
			usersMap = new EcoreEMap<String,R4EUser>(RModelPackage.Literals.MAP_TO_USERS, MapToUsersImpl.class, this, RModelPackage.R4E_REVIEW__USERS_MAP);
		}
		return usersMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<R4EID, R4EIDComponent> getIdsMap() {
		if (idsMap == null) {
			idsMap = new EcoreEMap<R4EID,R4EIDComponent>(RModelPackage.Literals.MAP_ID_TO_COMPONENT, MapIDToComponentImpl.class, this, RModelPackage.R4E_REVIEW__IDS_MAP);
		}
		return idsMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EUser getCreatedBy() {
		if (createdBy != null && createdBy.eIsProxy()) {
			InternalEObject oldCreatedBy = (InternalEObject)createdBy;
			createdBy = (R4EUser)eResolveProxy(oldCreatedBy);
			if (createdBy != oldCreatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RModelPackage.R4E_REVIEW__CREATED_BY, oldCreatedBy, createdBy));
			}
		}
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R4EUser basicGetCreatedBy() {
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedBy(R4EUser newCreatedBy) {
		R4EUser oldCreatedBy = createdBy;
		createdBy = newCreatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RModelPackage.R4E_REVIEW__CREATED_BY, oldCreatedBy, createdBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RModelPackage.R4E_REVIEW__DECISION:
				return basicSetDecision(null, msgs);
			case RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE:
				return basicSetAnomalyTemplate(null, msgs);
			case RModelPackage.R4E_REVIEW__USERS_MAP:
				return ((InternalEList<?>)getUsersMap()).basicRemove(otherEnd, msgs);
			case RModelPackage.R4E_REVIEW__IDS_MAP:
				return ((InternalEList<?>)getIdsMap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RModelPackage.R4E_REVIEW__NAME:
				return getName();
			case RModelPackage.R4E_REVIEW__CREATION_DATE:
				return getCreationDate();
			case RModelPackage.R4E_REVIEW__PROJECT:
				return getProject();
			case RModelPackage.R4E_REVIEW__COMPONENTS:
				return getComponents();
			case RModelPackage.R4E_REVIEW__ENTRY_CRITERIA:
				return getEntryCriteria();
			case RModelPackage.R4E_REVIEW__EXTRA_NOTES:
				return getExtraNotes();
			case RModelPackage.R4E_REVIEW__OBJECTIVES:
				return getObjectives();
			case RModelPackage.R4E_REVIEW__REFERENCE_MATERIAL:
				return getReferenceMaterial();
			case RModelPackage.R4E_REVIEW__DECISION:
				if (resolve) return getDecision();
				return basicGetDecision();
			case RModelPackage.R4E_REVIEW__START_DATE:
				return getStartDate();
			case RModelPackage.R4E_REVIEW__END_DATE:
				return getEndDate();
			case RModelPackage.R4E_REVIEW__XML_VERSION:
				return getXmlVersion();
			case RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE:
				if (resolve) return getAnomalyTemplate();
				return basicGetAnomalyTemplate();
			case RModelPackage.R4E_REVIEW__TYPE:
				return getType();
			case RModelPackage.R4E_REVIEW__USERS_MAP:
				if (coreType) return getUsersMap();
				else return getUsersMap().map();
			case RModelPackage.R4E_REVIEW__CREATED_BY:
				if (resolve) return getCreatedBy();
				return basicGetCreatedBy();
			case RModelPackage.R4E_REVIEW__IDS_MAP:
				if (coreType) return getIdsMap();
				else return getIdsMap().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RModelPackage.R4E_REVIEW__NAME:
				setName((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case RModelPackage.R4E_REVIEW__PROJECT:
				setProject((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends String>)newValue);
				return;
			case RModelPackage.R4E_REVIEW__ENTRY_CRITERIA:
				setEntryCriteria((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__EXTRA_NOTES:
				setExtraNotes((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__OBJECTIVES:
				setObjectives((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__REFERENCE_MATERIAL:
				setReferenceMaterial((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__DECISION:
				setDecision((R4EReviewDecision)newValue);
				return;
			case RModelPackage.R4E_REVIEW__START_DATE:
				setStartDate((Date)newValue);
				return;
			case RModelPackage.R4E_REVIEW__END_DATE:
				setEndDate((Date)newValue);
				return;
			case RModelPackage.R4E_REVIEW__XML_VERSION:
				setXmlVersion((String)newValue);
				return;
			case RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE:
				setAnomalyTemplate((R4EAnomaly)newValue);
				return;
			case RModelPackage.R4E_REVIEW__TYPE:
				setType((R4EReviewType)newValue);
				return;
			case RModelPackage.R4E_REVIEW__USERS_MAP:
				((EStructuralFeature.Setting)getUsersMap()).set(newValue);
				return;
			case RModelPackage.R4E_REVIEW__CREATED_BY:
				setCreatedBy((R4EUser)newValue);
				return;
			case RModelPackage.R4E_REVIEW__IDS_MAP:
				((EStructuralFeature.Setting)getIdsMap()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RModelPackage.R4E_REVIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__PROJECT:
				setProject(PROJECT_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__COMPONENTS:
				getComponents().clear();
				return;
			case RModelPackage.R4E_REVIEW__ENTRY_CRITERIA:
				setEntryCriteria(ENTRY_CRITERIA_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__EXTRA_NOTES:
				setExtraNotes(EXTRA_NOTES_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__OBJECTIVES:
				setObjectives(OBJECTIVES_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__REFERENCE_MATERIAL:
				setReferenceMaterial(REFERENCE_MATERIAL_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__DECISION:
				setDecision((R4EReviewDecision)null);
				return;
			case RModelPackage.R4E_REVIEW__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__XML_VERSION:
				setXmlVersion(XML_VERSION_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE:
				setAnomalyTemplate((R4EAnomaly)null);
				return;
			case RModelPackage.R4E_REVIEW__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case RModelPackage.R4E_REVIEW__USERS_MAP:
				getUsersMap().clear();
				return;
			case RModelPackage.R4E_REVIEW__CREATED_BY:
				setCreatedBy((R4EUser)null);
				return;
			case RModelPackage.R4E_REVIEW__IDS_MAP:
				getIdsMap().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RModelPackage.R4E_REVIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RModelPackage.R4E_REVIEW__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case RModelPackage.R4E_REVIEW__PROJECT:
				return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
			case RModelPackage.R4E_REVIEW__COMPONENTS:
				return components != null && !components.isEmpty();
			case RModelPackage.R4E_REVIEW__ENTRY_CRITERIA:
				return ENTRY_CRITERIA_EDEFAULT == null ? entryCriteria != null : !ENTRY_CRITERIA_EDEFAULT.equals(entryCriteria);
			case RModelPackage.R4E_REVIEW__EXTRA_NOTES:
				return EXTRA_NOTES_EDEFAULT == null ? extraNotes != null : !EXTRA_NOTES_EDEFAULT.equals(extraNotes);
			case RModelPackage.R4E_REVIEW__OBJECTIVES:
				return OBJECTIVES_EDEFAULT == null ? objectives != null : !OBJECTIVES_EDEFAULT.equals(objectives);
			case RModelPackage.R4E_REVIEW__REFERENCE_MATERIAL:
				return REFERENCE_MATERIAL_EDEFAULT == null ? referenceMaterial != null : !REFERENCE_MATERIAL_EDEFAULT.equals(referenceMaterial);
			case RModelPackage.R4E_REVIEW__DECISION:
				return decision != null;
			case RModelPackage.R4E_REVIEW__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case RModelPackage.R4E_REVIEW__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case RModelPackage.R4E_REVIEW__XML_VERSION:
				return XML_VERSION_EDEFAULT == null ? xmlVersion != null : !XML_VERSION_EDEFAULT.equals(xmlVersion);
			case RModelPackage.R4E_REVIEW__ANOMALY_TEMPLATE:
				return anomalyTemplate != null;
			case RModelPackage.R4E_REVIEW__TYPE:
				return type != TYPE_EDEFAULT;
			case RModelPackage.R4E_REVIEW__USERS_MAP:
				return usersMap != null && !usersMap.isEmpty();
			case RModelPackage.R4E_REVIEW__CREATED_BY:
				return createdBy != null;
			case RModelPackage.R4E_REVIEW__IDS_MAP:
				return idsMap != null && !idsMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", project: ");
		result.append(project);
		result.append(", components: ");
		result.append(components);
		result.append(", entryCriteria: ");
		result.append(entryCriteria);
		result.append(", extraNotes: ");
		result.append(extraNotes);
		result.append(", objectives: ");
		result.append(objectives);
		result.append(", referenceMaterial: ");
		result.append(referenceMaterial);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", xmlVersion: ");
		result.append(xmlVersion);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}
} //R4EReviewImpl