// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.constructorsOnlyInvokeFinalMethods, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.disallowReturnMutable, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity, explicitThisUsage
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
 * This class implements the dialog used to fill-in the Review Group element 
 * details.  This is a modal dialog
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/

package org.eclipse.mylyn.reviews.r4e.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.utils.EditableListWidget;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class ReviewGroupInputDialog extends FormDialog {

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------

	/**
	 * Field ADD_REVIEW_GROUP_DIALOG_TITLE.
	 * (value is ""Enter Review Group details"")
	 */
	private static final String ADD_REVIEW_GROUP_DIALOG_TITLE = "Enter Review Group Details";
	
	/**
	 * Field ADD_REVIEW_GROUP_NAME_DIALOG_VALUE.
	 * (value is ""Enter the Review Group Name:"")
	 */
	private static final String ADD_REVIEW_GROUP_NAME_DIALOG_VALUE = "Group Name:";
	
	/**
	 * Field ADD_REVIEW_GROUP_FOLDER_DIALOG_VALUE.
	 * (value is ""Enter the Review Group Folder:"")
	 */
	private static final String ADD_REVIEW_GROUP_FOLDER_DIALOG_VALUE = "Group Folder:";
	
	/**
	 * Field ADD_REVIEW_GROUP_DESCRIPTION_DIALOG_VALUE.
	 * (value is ""Enter the Review Group Description:"")
	 */
	private static final String ADD_REVIEW_GROUP_DESCRIPTION_DIALOG_VALUE = "Group Description:";
	
	/**
	 * Field ADD_REVIEW_GROUP_AVAILABLE_PROJECTS_DIALOG_VALUE.
	 * (value is ""Available Projects:"")
	 */
	private static final String ADD_REVIEW_GROUP_AVAILABLE_PROJECTS_DIALOG_VALUE = "Available Projects:";
	
	/**
	 * Field ADD_REVIEW_GROUP_AVAILABLE_COMPONENTS_DIALOG_VALUE.
	 * (value is ""Available Components:"")
	 */
	private static final String ADD_REVIEW_GROUP_AVAILABLE_COMPONENTS_DIALOG_VALUE = "Available Components:";
	
	/**
	 * Field ADD_REVIEW_GROUP_ENTRY_CRITERIA_DIALOG_VALUE.
	 * (value is ""Default Entry Criteria:"")
	 */
	private static final String ADD_REVIEW_GROUP_ENTRY_CRITERIA_DIALOG_VALUE = "Default Entry Criteria:";
	
	/**
	 * Field BASIC_PARAMS_HEADER_MSG.
	 * (value is ""Enter the mandatory basic parameters for this Review Group"")
	 */
	private static final String BASIC_PARAMS_HEADER_MSG = "Enter the mandatory basic parameters for this Review Group";
	
	/**
	 * Field EXTRA_PARAMS_HEADER_MSG.
	 * (value is ""Enter the optional extra parameters for this Review Group"")
	 */
	private static final String EXTRA_PARAMS_HEADER_MSG = "Enter the optional extra parameters for this Review Group";
	
	
	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------
    
    /**
     * The input value; the empty string by default.
     */
    private String fGroupNameValue = "";
    
    /**
     * Input text widget.
     */
    private Text fGroupNameInputTextField;
	
	/**
	 * Field fGroupFolderValue.
	 */
	private String fGroupFolderValue = "";
	
	/**
	 * Field fGroupFolderInputTextField.
	 */
	private Text fGroupFolderInputTextField = null;
	
	/**
	 * Field fGroupDescriptionValue.
	 */
	private String fGroupDescriptionValue = "";
	
	/**
	 * Field fGroupDescriptionInputTextField.
	 */
	private Text fGroupDescriptionInputTextField = null;

	/**
	 * Field fAvailableProjectsValues.
	 */
	private String[] fAvailableProjectsValues = null;
	
	/**
	 * Field fAvailableProjects.
	 */
	private EditableListWidget fAvailableProjects = null;
	
	/**
	 * Field fAvailableComponentsValues.
	 */
	private String[] fAvailableComponentsValues = null;
	
	/**
	 * Field fAvailableComponents.
	 */
	private EditableListWidget fAvailableComponents = null;
	
	/**
	 * Field fDefaultEntryCriteriaValue.
	 */
	private String fDefaultEntryCriteriaValue = "";
	
	/**
	 * Field fDefaultEntryCriteriaTextField.
	 */
	private Text fDefaultEntryCriteriaTextField = null;
    
    /**
     * The input validator, or <code>null</code> if none.
     */
    private final IInputValidator fValidator;
    

    
	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------
    
	/**
	 * Constructor for R4EReviewGroupInputDialog.
	 * @param aParentShell Shell
	 */
	public ReviewGroupInputDialog(Shell aParentShell) {
		super(aParentShell);
    	setBlockOnOpen(true);
		fValidator = new R4EInputValidator();
	}
	
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
    /**
     * Method buttonPressed.
     * @param buttonId int
     * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
     */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			this.getShell().setCursor(this.getShell().getDisplay().getSystemCursor(SWT.CURSOR_WAIT));
			//Validate Name
			String validateResult = validateEmptyInput(fGroupNameInputTextField);
			if (null != validateResult) {
				//Validate of input failed
				final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "No input given for Group Name",
						new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, validateResult, null), IStatus.ERROR);
				dialog.open();
				this.getShell().setCursor(this.getShell().getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
				return;
			} 

			//Validate Folder
			validateResult = validateFolderInput(fGroupFolderInputTextField);
			if (null != validateResult) {
				//Validate of input failed
				final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Invalid input folder",
						new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, validateResult, null), IStatus.ERROR);
				dialog.open();
				this.getShell().setCursor(this.getShell().getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
				return;
			}

			validateResult = validateGroupExists(fGroupFolderInputTextField);
			if (null != validateResult) {
				//Validate of input failed
				final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_ERROR, "Invalid input folder",
						new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, validateResult, null), IStatus.ERROR);
				dialog.open();
				this.getShell().setCursor(this.getShell().getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
				return;
			} 

			//Validate Description
			validateResult = validateEmptyInput(fGroupDescriptionInputTextField);
			if (null != validateResult) {
				//Validate of input failed
				final ErrorDialog dialog = new ErrorDialog(null, R4EUIConstants.DIALOG_TITLE_WARNING, "No input given for Group Description",
						new Status(IStatus.WARNING, Activator.PLUGIN_ID, 0, validateResult, null), IStatus.WARNING);
				dialog.open();
			}
			
        	//Validate Projects (optional)
        	final ArrayList<String> projectsValues = new ArrayList<String>();
			for (Item item : fAvailableProjects.getItems()) {	
	        	validateResult = validateEmptyInput(item.getText());
	        	if (null == validateResult) {
	        		projectsValues.add(item.getText());
	        	}
			}
        	fAvailableProjectsValues = projectsValues.toArray(new String[projectsValues.size()]);
			
        	//Validate Components (optional)
        	final ArrayList<String> componentsValues = new ArrayList<String>();
			for (Item item : fAvailableComponents.getItems()) {
	        	validateResult = validateEmptyInput(item.getText());
	        	if (null == validateResult) {
	        		componentsValues.add(item.getText());
	        	}
			}
        	fAvailableComponentsValues = componentsValues.toArray(new String[componentsValues.size()]);
        	
        	//Validate Entry Criteria (optional)
        	validateResult = validateEmptyInput(fDefaultEntryCriteriaTextField);
        	if (null == validateResult) {
        		fDefaultEntryCriteriaValue = fDefaultEntryCriteriaTextField.getText();
        	}
        	
			fGroupNameValue = fGroupNameInputTextField.getText();
			fGroupFolderValue = fGroupFolderInputTextField.getText();
			fGroupDescriptionValue = fGroupDescriptionInputTextField.getText();
		} else {
			fGroupNameValue = null;
			fGroupFolderValue = null;
			fGroupDescriptionValue = null;
			fDefaultEntryCriteriaValue = null;
		}
		this.getShell().setCursor(this.getShell().getDisplay().getSystemCursor(SWT.CURSOR_ARROW));
		super.buttonPressed(buttonId);
	}

    /**
     * Method configureShell.
     * @param shell Shell
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
	protected void configureShell(Shell shell) {
        super.configureShell(shell);
			shell.setText(ADD_REVIEW_GROUP_DIALOG_TITLE);
    }
    
	/**
	 * Configures the dialog form and creates form content. Clients should
	 * override this method.
	 * 
	 * @param mform
	 *            the dialog form
	 */
	@Override
	protected void createFormContent(final IManagedForm mform) {

		final FormToolkit toolkit = mform.getToolkit();
		final ScrolledForm sform = mform.getForm();
		sform.setExpandVertical(true);
		final Composite composite = sform.getBody();
		final GridLayout layout = new GridLayout(4, false);
		composite.setLayout(layout);
		
        //Grid data values
        final GridData labelData = new GridData(GridData.BEGINNING, GridData.BEGINNING, false, false);
        final GridData textSingleData = new GridData(GridData.FILL, GridData.FILL, true, false);
        textSingleData.horizontalSpan = 3;
        final GridData textMultiData = new GridData(GridData.FILL, GridData.FILL, true, false);
        textMultiData.horizontalSpan = 3;
        final GridData buttonData = new GridData(GridData.BEGINNING, GridData.BEGINNING, false, false);
        buttonData.horizontalSpan = 1;
        
		//Basic parameters section
        final Section basicSection = toolkit.createSection(composite, Section.DESCRIPTION | ExpandableComposite.TITLE_BAR |
        		  ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED);
        final GridData basicSectionGridData = new GridData(GridData.FILL, GridData.FILL, true, false);
        basicSectionGridData.horizontalSpan = 4;
        basicSection.setLayoutData(basicSectionGridData);
        basicSection.setText(R4EUIConstants.BASIC_PARAMS_HEADER);
        basicSection.setDescription(BASIC_PARAMS_HEADER_MSG);
        basicSection.addExpansionListener(new ExpansionAdapter()
		{
			@Override
			public void expansionStateChanged(ExpansionEvent e){
				getShell().setSize(getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT));
				sform.reflow(true);
			}
		});
        
        final Composite basicSectionClient = toolkit.createComposite(basicSection);
        basicSectionClient.setLayout(layout);
        basicSection.setClient(basicSectionClient);
        
        //Review Group Name
        Label label = toolkit.createLabel(basicSectionClient, ADD_REVIEW_GROUP_NAME_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fGroupNameInputTextField = toolkit.createText(basicSectionClient, "", SWT.SINGLE);
        fGroupNameInputTextField.setLayoutData(textSingleData);
        
        //Group Folder
        label = toolkit.createLabel(basicSectionClient, ADD_REVIEW_GROUP_FOLDER_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fGroupFolderInputTextField = toolkit.createText(basicSectionClient, "", SWT.SINGLE);
        final GridData folderTextData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
        folderTextData.horizontalSpan = 2;
        fGroupFolderInputTextField.setLayoutData(folderTextData);
        final Button folderButton = toolkit.createButton(basicSectionClient, "", SWT.NONE);
        folderButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER).createImage()); // $codepro.audit.disable methodChainLength
        folderButton.setLayoutData(buttonData);
        folderButton.addSelectionListener(new SelectionAdapter() { // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.avoidInnerClasses
			@SuppressWarnings("synthetic-access")
			@Override
			public void widgetSelected(SelectionEvent event) {
				final String result = folderButtonPressed();
				if (null == result) {
					fGroupFolderInputTextField.setText("");
				}
				else {
					fGroupFolderInputTextField.setText(result);
				}
			}
		});
        
        //Group Description
        label = toolkit.createLabel(basicSectionClient, ADD_REVIEW_GROUP_DESCRIPTION_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fGroupDescriptionInputTextField = toolkit.createText(basicSectionClient, "", SWT.MULTI | SWT.V_SCROLL);
        textMultiData.heightHint = fGroupNameInputTextField.getLineHeight() * 3;
        fGroupDescriptionInputTextField.setLayoutData(textMultiData);
        
        //Extra parameters section
        final Section extraSection = toolkit.createSection(composite, Section.DESCRIPTION | ExpandableComposite.TITLE_BAR |
        		  ExpandableComposite.TWISTIE);
        final GridData extraSectionGridData = new GridData(GridData.FILL, GridData.FILL, true, false);
        extraSectionGridData.horizontalSpan = 4;
        extraSection.setLayoutData(extraSectionGridData);
        extraSection.setText(R4EUIConstants.EXTRA_PARAMS_HEADER);
        extraSection.setDescription(EXTRA_PARAMS_HEADER_MSG);
        extraSection.addExpansionListener(new ExpansionAdapter()
		{
			@Override
			public void expansionStateChanged(ExpansionEvent e){
				getShell().setSize(getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT));
				sform.reflow(true);
			}
		});
        
        final Composite extraSectionClient = toolkit.createComposite(extraSection);
        extraSectionClient.setLayout(layout);
        extraSection.setClient(extraSectionClient);
        
		//Available Projects
        label = toolkit.createLabel(extraSectionClient, ADD_REVIEW_GROUP_AVAILABLE_PROJECTS_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fAvailableProjects = new EditableListWidget(toolkit, extraSectionClient, textSingleData, null, 0, Text.class, null);
        
		//Available Components
        label = toolkit.createLabel(extraSectionClient, ADD_REVIEW_GROUP_AVAILABLE_COMPONENTS_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fAvailableComponents = new EditableListWidget(toolkit, extraSectionClient, textSingleData, null, 0, Text.class, null);
        
        // Default Entry Criteria
        label = toolkit.createLabel(extraSectionClient, ADD_REVIEW_GROUP_ENTRY_CRITERIA_DIALOG_VALUE);
        label.setLayoutData(labelData);
        fDefaultEntryCriteriaTextField = toolkit.createText(extraSectionClient, "", SWT.MULTI | SWT.V_SCROLL);
        fDefaultEntryCriteriaTextField.setLayoutData(textMultiData);
	}
	
    /**
     * Method folderButtonPressed.
     * @return String
     */
    protected String folderButtonPressed() {
    	//Open folder dialog
        final DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.SHEET);
        dialog.setMessage("Select Folder...");
        String dir = dialog.open();
        if (null != dir) {
            dir = dir.trim();
            if (0 == dir.length()) {
				return null;
			}
        }
        return dir;
    }
    
	/**
	 * Method isResizable.
	 * @return boolean
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 */
	@Override
	protected boolean isResizable() {
		return true;
	}
    
    /**
     * Returns the string typed into this input dialog.
     * @return the group name input string
     */
    public String getGroupNameValue() {
        return fGroupNameValue;
    }
    
    /**
     * Returns the string typed into this input dialog.
     * @return the group folder input string
     */
    public String getGroupFolderValue() {
        return fGroupFolderValue;
    }
    
    /**
     * Returns the string typed into this input dialog.
     * @return the group description input string
     */
    public String getGroupDescriptionValue() {
        return fGroupDescriptionValue;
    }
    
    /**
     * Returns the strings typed into this input dialog.
     * @return the Available projects input strings
     */
    public String[] getAvailableProjectsValues() {
        return fAvailableProjectsValues;
    }
    
    /**
     * Returns the strings typed into this input dialog.
     * @return the Available components input strings
     */
    public String[] getAvailableComponentsValues() {
        return fAvailableComponentsValues;
    }
    
    /**
     * Returns the string typed into this input dialog.
     * @return the Default entry criteria input string
     */
    public String getDefaultEntryCriteriaValue() {
        return fDefaultEntryCriteriaValue;
    }
    
    /**
     * Validates the input.
     * <p>
     * The default implementation of this framework method delegates the request
     * to the supplied input validator object; if it finds the input invalid,
     * the error message is displayed in the dialog's message line. This hook
     * method is called whenever the text changes in the input field.
     * </p>
     * @param aText Text
     * @return String
     */
    protected String validateFolderInput(Text aText) {
    	return ((R4EInputValidator) fValidator).isFolderValid(aText.getText());
    }
    
    /**
     * Method validateGroupExists.
     * @param aText Text
     * @return String
     */
    private String validateGroupExists(Text aText) {
    	return ((R4EInputValidator) fValidator).isFileExists(aText.getText());
    }
    
    /**
     * Method validateEmptyInput.
     * @param aText Text
     * @return String
     */
    private String validateEmptyInput(Text aText) {
        return fValidator.isValid(aText.getText());
    }
    
    /**
     * Method validateEmptyInput.
     * @param aString String
     * @return String
     */
    private String validateEmptyInput(String aString) {
    	return fValidator.isValid(aString);
    }
}
