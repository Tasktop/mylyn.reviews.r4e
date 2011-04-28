// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.constructorsOnlyInvokeFinalMethods, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class represents a preference page that is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows
 * us to create a page that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can be accessed directly via the preference store.
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 *******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.preferences;

import java.io.IOException;

import javax.naming.NamingException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EReviewGroup;
import org.eclipse.mylyn.reviews.r4e.core.model.drules.R4EDesignRuleCollection;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.editors.FilePathEditor;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.userSearch.query.IQueryUser;
import org.eclipse.mylyn.reviews.userSearch.query.QueryUserFactory;
import org.eclipse.mylyn.reviews.userSearch.userInfo.IUserInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class R4EPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------
	
	/**
	 * Field PREFS_CONTAINER_DATA_SPAN.
	 * (value is 1)
	 */
	private static final int PREFS_CONTAINER_DATA_SPAN = 1;
	
	/**
	 * Field R4E_PREFS_CONTAINER_DATA_SPAN.
	 * (value is 2)
	 */
	private static final int GROUP_PREFS_CONTAINER_DATA_SPAN = 2; // $codepro.audit.disable constantNamingConvention
	
	
	// ------------------------------------------------------------------------
	// Member Variables
	// ------------------------------------------------------------------------
	
	/**
	 * Field fGroupNameText.
	 */
	private Text fGroupNameText = null;
	
	/**
	 * Field fGroupDescriptionText.
	 */
	private Text fGroupDescriptionText = null;
	
	/**
	 * Field fRuleSetNameText.
	 */
	private Text fRuleSetNameText = null;
	
	/**
	 * Field fGRuleSetVersionText.
	 */
	private Text fRuleSetVersionText = null;
	
	/**
	 * Field fReviewShowDisabledButton.
	 */
	private Button fReviewShowDisabledButton = null;
	
	/**
	 * Field fReviewsOnlyFilterButton.
	 */
	private Button fReviewsOnlyFilterButton = null;
	
	/**
	 * Field fReviewCurrentFilterButton.
	 */
	private Button fReviewCurrentFilterButton = null;
	
	/**
	 * Field fReviewMyFilterButton.
	 */
	private Button fReviewMyFilterButton = null;
	
	/**
	 * Field fParticipantFilterButton.
	 */
	private Button fParticipantFilterButton = null;
	
	/**
	 * Field fAnomaliesFilterButton.
	 */
	private Button fAnomaliesFilterButton = null;
	
	/**
	 * Field fReviewedItemsFilterButton.
	 */
	private Button fReviewedItemsFilterButton = null;
	
	/**
	 * Field fHideRuleSetsFilterButton.
	 */
	private Button fHideRuleSetsFilterButton = null;
	
	/**
	 * Field fParticipantIdText.
	 */
	private Text fParticipantIdText = null;
	
	
	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------
	
	/**
	 * Constructor for R4EPreferencePage.
	 */
	public R4EPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(PreferenceConstants.P_DESC);
	}
	
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	
	@Override
	public void dispose() {
		
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	public void createFieldEditors() {

		Activator.Ftracer.traceInfo("Build R4E Preference page");

		//The Main preferences composite
		final Composite prefsContainer = new Composite(getFieldEditorParent(),SWT.NONE);
		final GridData prefsContainerData = new GridData(GridData.FILL, GridData.FILL, true, false);
		prefsContainerData.horizontalSpan = PREFS_CONTAINER_DATA_SPAN;
		prefsContainer.setLayoutData(prefsContainerData);
		final GridLayout prefsLayout = new GridLayout(PREFS_CONTAINER_DATA_SPAN, false);
		prefsContainer.setLayout(prefsLayout);
		
		final TabFolder tabFolder = new TabFolder(prefsContainer, SWT.TOP);
		final GridData tabFolderData = new GridData(GridData.FILL, GridData.FILL, true, true);
		tabFolder.setLayoutData(tabFolderData);
		
		createUserPreferencesTab(tabFolder);
		createGroupPreferencesTab(tabFolder);
		createRuleSetsPreferencesTab(tabFolder);
		createFiltersPreferencesTab(tabFolder);
	}
	
	/**
	 * Method createUserPreferencesTab.
	 * @param aParent Composite
	 */
	private void createUserPreferencesTab(TabFolder aParent) {
		
		final TabItem tabItem = new TabItem(aParent, SWT.NONE);
		tabItem.setText("User");
		
		// Create a Group to hold R4E user preferences
		final Group r4EUserPrefsGroup = new Group(aParent, SWT.BORDER_SOLID);
		tabItem.setControl(r4EUserPrefsGroup);
		final GridData r4eUserPrefsGroupData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4eUserPrefsGroupData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4EUserPrefsGroup.setText("User Preferences");
		r4EUserPrefsGroup.setLayoutData(r4eUserPrefsGroupData);
		r4EUserPrefsGroup.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));

		//dummy spacer label
		final Label r4EUserPrefsSpacer = new Label(r4EUserPrefsGroup, SWT.FILL);
		final GridData r4EUserPrefsSpacerData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4EUserPrefsSpacerData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4EUserPrefsSpacer.setLayoutData(r4EUserPrefsSpacerData);
		
		final StringFieldEditor userIdFieldEditor = new StringFieldEditor(PreferenceConstants.P_USER_ID, PreferenceConstants.P_USER_ID_LABEL,
				StringFieldEditor.UNLIMITED, r4EUserPrefsGroup);
		addField(userIdFieldEditor);
		if (R4EUIModelController.isDialogOpen()) {
			userIdFieldEditor.setEnabled(false, r4EUserPrefsGroup);
		} else {
			userIdFieldEditor.setEnabled(true, r4EUserPrefsGroup);
		}
		
		final StringFieldEditor userEmailFieldEditor = new StringFieldEditor(PreferenceConstants.P_USER_EMAIL, PreferenceConstants.P_USER_EMAIL_LABEL,
				StringFieldEditor.UNLIMITED, r4EUserPrefsGroup);
		addField(userEmailFieldEditor);
		if (R4EUIModelController.isDialogOpen()) {
			userEmailFieldEditor.setEnabled(false, r4EUserPrefsGroup);
		} else {
			userEmailFieldEditor.setEnabled(true, r4EUserPrefsGroup);
		}
	}

	/**
	 * Method createGroupPreferencesTab.
	 * @param aParent Composite
	 */
	private void createGroupPreferencesTab(TabFolder aParent) {

		final TabItem tabItem = new TabItem(aParent, SWT.NONE);
		tabItem.setText("Groups");
		
		// Create a Group to hold R4E Group preferences
		final Group r4EGroupPrefsGroup = new Group(aParent, SWT.BORDER_SOLID);
		tabItem.setControl(r4EGroupPrefsGroup);
		final GridData r4EGroupPrefsGroupData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4EGroupPrefsGroupData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4EGroupPrefsGroup.setText("Group Preferences");
		r4EGroupPrefsGroup.setLayoutData(r4EGroupPrefsGroupData);
		r4EGroupPrefsGroup.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));

		//dummy spacer label
		Label r4EGroupPrefsSpacer = new Label(r4EGroupPrefsGroup, SWT.FILL); // $codepro.audit.disable variableUsage
		final GridData r4EGroupPrefsSpacerData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4EGroupPrefsSpacerData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4EGroupPrefsSpacer.setLayoutData(r4EGroupPrefsSpacerData);
		
		// File Path Editor for Review Groups
        final String[] extensions = { PreferenceConstants.P_GROUP_FILE_EXT };
        final FilePathEditor groupFilesEditor = new FilePathEditor(PreferenceConstants.P_GROUP_FILE_PATH, PreferenceConstants.P_GROUP_FILE_PATH_LABEL, extensions, 
				r4EGroupPrefsGroup);
		addField(groupFilesEditor);
		if (R4EUIModelController.isDialogOpen()) {
			groupFilesEditor.setEnabled(false, r4EGroupPrefsGroup);
		} else { 
			groupFilesEditor.setEnabled(true, r4EGroupPrefsGroup);
		}
		final List filesList = groupFilesEditor.getListControl(r4EGroupPrefsGroup);
		filesList.addSelectionListener(new SelectionListener() {

			@SuppressWarnings("synthetic-access")
			public void widgetSelected(SelectionEvent aEvent) {
				final String selectedGroupFile = groupFilesEditor.getSelection();
				try {
					final R4EReviewGroup group = R4EUIModelController.peekReviewGroup(selectedGroupFile);
					fGroupNameText.setText(group.getName());
					fGroupDescriptionText.setText(group.getDescription());
					R4EUIModelController.FModelExt.closeR4EReviewGroup(group);

				} catch (ResourceHandlingException e) {
	    			Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
	    			Activator.getDefault().logWarning("Exception: " + e.toString(), e);
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { // $codepro.audit.disable emptyMethod
				//No implementation
			}
		});
		
		//Group details
		final Composite groupDetailsContainer = new Composite(r4EGroupPrefsGroup,SWT.NONE);
		final GridData groupDetailsLayoutData = new GridData(GridData.FILL, GridData.FILL, false, false);
		groupDetailsContainer.setLayoutData(groupDetailsLayoutData);
		groupDetailsContainer.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));
		
		final Label groupNameLabel = new Label(groupDetailsContainer, SWT.FILL);
		final GridData groupNameLabelData = new GridData(GridData.FILL, GridData.FILL, false, false);
		groupNameLabel.setText(R4EUIConstants.NAME_LABEL);
		groupNameLabel.setLayoutData(groupNameLabelData);

		fGroupNameText = new Text(groupDetailsContainer, SWT.FILL);
		final GridData groupNameTextData = new GridData(GridData.FILL, GridData.FILL, true, false);
		fGroupNameText.setEnabled(true);	
		fGroupNameText.setEditable(false);
		fGroupNameText.setLayoutData(groupNameTextData);
		
		final Label groupDescriptionLabel = new Label(groupDetailsContainer, SWT.NONE);
		final GridData groupDescriptionLabelData = new GridData(GridData.FILL, GridData.FILL, false, false);
		groupDescriptionLabel.setText(R4EUIConstants.DESCRIPTION_LABEL);
		groupDescriptionLabel.setLayoutData(groupDescriptionLabelData);

		fGroupDescriptionText = new Text(groupDetailsContainer, SWT.NONE);
		final GridData groupDescriptionTextData = new GridData(GridData.FILL, GridData.FILL, true, false);
		fGroupDescriptionText.setEnabled(true);	
		fGroupDescriptionText.setEditable(false);
		fGroupDescriptionText.setLayoutData(groupDescriptionTextData);
	}
	
	/**
	 * Method createRuleSetsPreferencesTab.
	 * @param aParent Composite
	 */
	private void createRuleSetsPreferencesTab(TabFolder aParent) {
		
		final TabItem tabItem = new TabItem(aParent, SWT.NONE);
		tabItem.setText("Rule Sets");
		
		// Create a Group to hold R4E Rule Set preferences
		final Group r4ERuleSetPrefsGroup = new Group(aParent, SWT.BORDER_SOLID);
		tabItem.setControl(r4ERuleSetPrefsGroup);
		final GridData r4ERuleSetPrefsGroupData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4ERuleSetPrefsGroupData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4ERuleSetPrefsGroup.setText("Rule Sets Preferences");
		r4ERuleSetPrefsGroup.setLayoutData(r4ERuleSetPrefsGroupData);
		r4ERuleSetPrefsGroup.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));

		//dummy spacer label
		Label r4ERuleSetPrefsSpacer = new Label(r4ERuleSetPrefsGroup, SWT.FILL); // $codepro.audit.disable variableUsage
		final GridData r4ERuleSetPrefsSpacerData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4ERuleSetPrefsSpacerData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4ERuleSetPrefsSpacer.setLayoutData(r4ERuleSetPrefsSpacerData);
		
		// File Path Editor for Rule Sets
        final String[] ruleSetsExtensions = { PreferenceConstants.P_RULE_SET_FILE_EXT };
        final FilePathEditor ruleSetFilesEditor = new FilePathEditor(PreferenceConstants.P_RULE_SET_FILE_PATH, 
        		PreferenceConstants.P_RULE_SET_FILE_PATH_LABEL, ruleSetsExtensions, r4ERuleSetPrefsGroup);
		addField(ruleSetFilesEditor);
		if (R4EUIModelController.isDialogOpen()) {
			ruleSetFilesEditor.setEnabled(false, r4ERuleSetPrefsGroup);
		} else { 
			ruleSetFilesEditor.setEnabled(true, r4ERuleSetPrefsGroup);
		}
		final List ruleSetfilesList = ruleSetFilesEditor.getListControl(r4ERuleSetPrefsGroup);
		ruleSetfilesList.addSelectionListener(new SelectionListener() {

			@SuppressWarnings("synthetic-access")
			public void widgetSelected(SelectionEvent aEvent) {
				final String selectedRuleSetFile = ruleSetFilesEditor.getSelection();
				try {
					final R4EDesignRuleCollection ruleSet = R4EUIModelController.peekRuleSet(selectedRuleSetFile);
					fRuleSetNameText.setText(ruleSet.getName());
					fRuleSetVersionText.setText(ruleSet.getVersion());
					R4EUIModelController.FModelExt.closeR4EDesignRuleCollection(ruleSet);
				} catch (ResourceHandlingException e) {
	    			Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
	    			Activator.getDefault().logWarning("Exception: " + e.toString(), e);
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { // $codepro.audit.disable emptyMethod
				//No implementation
			}
		});
		
		//Group details
		final Composite ruleSetDetailsContainer = new Composite(r4ERuleSetPrefsGroup,SWT.NONE);
		final GridData ruleSetDetailsLayoutData = new GridData(GridData.FILL, GridData.FILL, false, false);
		ruleSetDetailsContainer.setLayoutData(ruleSetDetailsLayoutData);
		ruleSetDetailsContainer.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));
		
		final Label ruleSetNameLabel = new Label(ruleSetDetailsContainer, SWT.FILL);
		final GridData ruleSetNameLabelData = new GridData(GridData.FILL, GridData.FILL, false, false);
		ruleSetNameLabel.setText(R4EUIConstants.NAME_LABEL);
		ruleSetNameLabel.setLayoutData(ruleSetNameLabelData);

		fRuleSetNameText = new Text(ruleSetDetailsContainer, SWT.FILL);
		final GridData ruleSetNameTextData = new GridData(GridData.FILL, GridData.FILL, true, false);
		fRuleSetNameText.setEnabled(true);	
		fRuleSetNameText.setEditable(false);
		fRuleSetNameText.setLayoutData(ruleSetNameTextData);
		
		final Label ruleSetVersionLabel = new Label(ruleSetDetailsContainer, SWT.NONE);
		final GridData ruleSetVersionLabelData = new GridData(GridData.FILL, GridData.FILL, false, false);
		ruleSetVersionLabel.setText(R4EUIConstants.DESCRIPTION_LABEL);
		ruleSetVersionLabel.setLayoutData(ruleSetVersionLabelData);

		fRuleSetVersionText = new Text(ruleSetDetailsContainer, SWT.NONE);
		final GridData ruleSetVersionTextData = new GridData(GridData.FILL, GridData.FILL, true, false);
		fRuleSetVersionText.setEnabled(true);	
		fRuleSetVersionText.setEditable(false);
		fRuleSetVersionText.setLayoutData(ruleSetVersionTextData);
	}
	
	/**
	 * Method createFiltersPreferencesTab.
	 * @param aParent Composite
	 */
	private void createFiltersPreferencesTab(TabFolder aParent) {
		
		final TabItem tabItem = new TabItem(aParent, SWT.NONE);
		tabItem.setText("Filters");
		
		// Create a Group to hold R4E Navigator view default filters
		final Group r4EFilterPrefsGroup = new Group(aParent, SWT.BORDER_SOLID);
		tabItem.setControl(r4EFilterPrefsGroup);
		final GridData r4EFilterPrefsGroupData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4EFilterPrefsGroupData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4EFilterPrefsGroup.setText("Default Filters");
		r4EFilterPrefsGroup.setLayoutData(r4EFilterPrefsGroupData);
		r4EFilterPrefsGroup.setLayout(new GridLayout(GROUP_PREFS_CONTAINER_DATA_SPAN, false));

		//dummy spacer label
		Label r4ERuleSetPrefsSpacer = new Label(r4EFilterPrefsGroup, SWT.FILL); // $codepro.audit.disable variableUsage
		final GridData r4ERuleSetPrefsSpacerData = new GridData(GridData.FILL, GridData.FILL, true, false);
		r4ERuleSetPrefsSpacerData.horizontalSpan = GROUP_PREFS_CONTAINER_DATA_SPAN;
		r4ERuleSetPrefsSpacer.setLayoutData(r4ERuleSetPrefsSpacerData);
		
		//Filers checkboxes
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		fReviewShowDisabledButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fReviewShowDisabledButton.setText(R4EUIConstants.SHOW_DISABLED_FILTER_NAME);
		fReviewShowDisabledButton.setLayoutData(r4EFilterPrefsGroupData);
		fReviewShowDisabledButton.setSelection(store.getBoolean(PreferenceConstants.P_SHOW_DISABLED));
		
		fReviewsOnlyFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fReviewsOnlyFilterButton.setText(R4EUIConstants.REVIEWS_ONLY_FILTER_NAME);
		fReviewsOnlyFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fReviewsOnlyFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_REVIEWS_ONLY_FILTER));

		fReviewMyFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fReviewMyFilterButton.setText(R4EUIConstants.REVIEWS_MY_FILTER_NAME);
		fReviewMyFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fReviewMyFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_REVIEWS_MY_FILTER));
		
		fParticipantFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fParticipantFilterButton.setText(R4EUIConstants.REVIEWS_PARTICIPANT_FILTER_NAME);
		fParticipantIdText = new Text(r4EFilterPrefsGroup, SWT.NONE);
		fParticipantIdText.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		if (store.getString(PreferenceConstants.P_PARTICIPANT_FILTER).equals("")) {
			fParticipantFilterButton.setSelection(false);
			fParticipantFilterButton.setEnabled(false);
			fParticipantIdText.setText("");
		} else {
			fParticipantFilterButton.setSelection(true);				
			fParticipantIdText.setText(store.getString(PreferenceConstants.P_PARTICIPANT_FILTER));
		}
		fParticipantIdText.addModifyListener(new ModifyListener() {		
			@SuppressWarnings("synthetic-access")
			public void modifyText(ModifyEvent e) {
				if (fParticipantIdText.getCharCount() > 0) {
					fParticipantFilterButton.setEnabled(true);
				} else {
					fParticipantFilterButton.setEnabled(false);
				}
			}
		});

		fAnomaliesFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fAnomaliesFilterButton.setText(R4EUIConstants.ANOMALIES_FILTER_NAME);
		fAnomaliesFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fAnomaliesFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_ANOMALIES_ALL_FILTER));
		
		fReviewCurrentFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fReviewCurrentFilterButton.setText(R4EUIConstants.ANOMALIES_MY_FILTER_NAME);
		fReviewCurrentFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fReviewCurrentFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_ANOMALIES_MY_FILTER));
		
		fReviewedItemsFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fReviewedItemsFilterButton.setText(R4EUIConstants.REVIEWED_ELEMS_FILTER_NAME);
		fReviewedItemsFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fReviewedItemsFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_REVIEWED_ITEMS_FILTER));
		
		fHideRuleSetsFilterButton = new Button(r4EFilterPrefsGroup, SWT.CHECK);
		fHideRuleSetsFilterButton.setText(R4EUIConstants.HIDE_RULE_SETS_FILTER_NAME);
		fHideRuleSetsFilterButton.setLayoutData(r4EFilterPrefsGroupData);
		fHideRuleSetsFilterButton.setSelection(store.getBoolean(PreferenceConstants.P_HIDE_RULE_SETS_FILTER));
	}
	
	/**
	 * Method init.
	 * @param workbench IWorkbench
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(IWorkbench)
	 */
	public void init(IWorkbench workbench) { // $codepro.audit.disable emptyMethod
	}
	
    /**
     * Method performOk.
     * @return boolean
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     */
    @Override
	public boolean performOk() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();

        //Set preferences for default filters and apply them
    	store.setValue(PreferenceConstants.P_SHOW_DISABLED, fReviewShowDisabledButton.getSelection());
    	store.setValue(PreferenceConstants.P_REVIEWS_ONLY_FILTER, fReviewsOnlyFilterButton.getSelection());
    	store.setValue(PreferenceConstants.P_ANOMALIES_MY_FILTER, fReviewCurrentFilterButton.getSelection());
    	store.setValue(PreferenceConstants.P_REVIEWS_MY_FILTER, fReviewMyFilterButton.getSelection());
    	if (fParticipantFilterButton.getSelection()) {
        	final String filterUserId = fParticipantIdText.getText();
        	if (filterUserId.equals(store.getString(PreferenceConstants.P_USER_ID))) {
        		//Set my filter instead
        		store.setValue(PreferenceConstants.P_REVIEWS_MY_FILTER, true);
        	} else {
        		store.setValue(PreferenceConstants.P_PARTICIPANT_FILTER, filterUserId);
        	}
    	} else {
        	store.setValue(PreferenceConstants.P_PARTICIPANT_FILTER, "");
			fParticipantIdText.setText("");
    	}
    	store.setValue(PreferenceConstants.P_ANOMALIES_ALL_FILTER, fAnomaliesFilterButton.getSelection());
    	store.setValue(PreferenceConstants.P_REVIEWED_ITEMS_FILTER, fReviewedItemsFilterButton.getSelection());
    	store.setValue(PreferenceConstants.P_HIDE_RULE_SETS_FILTER, fHideRuleSetsFilterButton.getSelection());

    	if (null != R4EUIModelController.getNavigatorView()) {
    		R4EUIModelController.getNavigatorView().applyDefaultFilters();
    	}
    	if ("".equals(store.getString(PreferenceConstants.P_USER_EMAIL))) {
			final String userId = store.getString(PreferenceConstants.P_USER_ID);

    		//If not email preferences are set, try to retrieve it from the external DB
        	if (null != userId && R4EUIModelController.isUserQueryAvailable()) {
        		try {
        			//Get detailed info from DB if available
        			final IQueryUser query = new QueryUserFactory().getInstance();
        			final java.util.List<IUserInfo> userInfos = query.searchByUserId(userId);
        			if (userInfos.size() > 0) {
        				store.setValue(PreferenceConstants.P_USER_EMAIL, userInfos.get(0).getEmail());
        				//TODO:  Why is this not setting the preferences correctly???
        			}
        		} catch (NamingException e) {
        			Activator.Ftracer.traceError("Exception: " + e.toString() + " (" + e.getMessage() + ")");
        		} catch (IOException e) {
        			Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
        		}
        	}
    	}
    	
        //For field editors
    	return super.performOk();
    }
}