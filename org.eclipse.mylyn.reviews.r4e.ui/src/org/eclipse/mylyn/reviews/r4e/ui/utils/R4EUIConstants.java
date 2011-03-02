// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.analysis.deserializeabilitySecurity, com.instantiations.assist.eclipse.analysis.enforceCloneableUsageSecurity
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
 * This class defines various constants used in the R4E UI plugin
 * 
 * Contributors:
 *   Sebastien Dubois - Created for Mylyn Review R4E project
 *   
 ******************************************************************************/
package org.eclipse.mylyn.reviews.r4e.ui.utils;

/**
 * @author lmcdubo
 * @version $Revision: 1.0 $
 */
public class R4EUIConstants { // $codepro.audit.disable convertClassToInterface

	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------
	
	/**
	 * Field R4E_PROPERTIES_VIEW_NAME.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.properties.R4EPropertiesView"")
	 */
	public static final String R4E_PROPERTIES_VIEW_NAME = "org.eclipse.mylyn.reviews.r4e.ui.properties.R4EPropertiesView"; // $codepro.audit.disable constantNamingConvention
	
	/**
	 * Field GROUP_FILE_SUFFIX.
	 * (value is ""_group_root.xrer"")
	 */
	public static final String GROUP_FILE_SUFFIX = "_group_root.xrer";
	
	/**
	 * Field VALUE_TRUE_STR.
	 * (value is ""true"")
	 */
	public static final String VALUE_TRUE_STR = "true";
	
	/**
	 * Field NO_OFFSET.
	 * (value is 0)
	 */
	public static final int NO_OFFSET = 0;
	
	/**
	 * Field LINE_OFFSET.
	 * (value is 1)
	 */
	public static final int LINE_OFFSET = 1;
	
	/**
	 * Field REVIEW_GROUP_PATHS_LENGTH.
	 * (value is 128)
	 */
	public static final int REVIEW_GROUP_PATHS_LENGTH = 128;
	
	/**
	 * Field TOOLTIP_CONTENTS_LENGTH.
	 * (value is 25)
	 */
	public static final int TOOLTIP_CONTENTS_LENGTH = 25;

	/**
	 * Field INVALID_VALUE.
	 * (value is -1)
	 */
	public static final int INVALID_VALUE = -1;
	
	/**
	 * Field SELECTIONS_LABEL_NAME.
	 * (value is ""Selections"")
	 */
	public static final String SELECTIONS_LABEL_NAME = "Selections";
	
	/**
	 * Field ANOMALIES_LABEL_NAME.
	 * (value is ""Anomalies"")
	 */
	public static final String ANOMALIES_LABEL_NAME = "Anomalies";
	
	/**
	 * Field GLOBAL_ANOMALIES_LABEL_NAME.
	 * (value is ""Global Anomalies"")
	 */
	public static final String  GLOBAL_ANOMALIES_LABEL_NAME = "Global Anomalies";
	
	/**
	 * Field PARTICIPANTS_LABEL_NAME.
	 * (value is ""Participants"")
	 */
	public static final String PARTICIPANTS_LABEL_NAME = "Participants";
	
	/**
	 * Field LINE_TAG.
	 * (value is ""Line "")
	 */
	public static final String LINE_TAG = "Line ";
	
	/**
	 * Field LINES_TAG.
	 * (value is ""Lines "")
	 */
	public static final String LINES_TAG = "Lines ";
	
	/**
	 * Field DEFAULT_LINE_TAG_LENGTH.
	 * (value is 28)
	 */
	public static final int DEFAULT_LINE_TAG_LENGTH = 28;
	
	/**
	 * Field DIALOG_TITLE_ERROR.
	 * (value is ""R4E Error"")
	 */
	public static final String DIALOG_TITLE_ERROR = "R4E Error";
	
	/**
	 * Field DIALOG_TITLE_WARNING.
	 * (value is ""R4E Warning"")
	 */
	public static final String DIALOG_TITLE_WARNING = "R4E Warning";
	
	/**
	 * Field DIALOG_TITLE_INFO.
	 * (value is ""R4E Info"")
	 */
	public static final String DIALOG_TITLE_INFO = "R4E Info";
	
	/**
	 * Field SHOW_DISABLED_FILTER_NAME.
	 * (value is ""Show disabled elements"")
	 */
	public static final String SHOW_DISABLED_FILTER_NAME = "Show Disabled Elements";
	
	/**
	 * Field DIALOG_DEFAULT_HEIGHT.
	 * (value is 500)
	 */
	public static final int DIALOG_DEFAULT_HEIGHT = 600;
	
	/**
	 * Field DIALOG_DEFAULT_WIDTH.
	 * (value is 500)
	 */
	public static final int DIALOG_DEFAULT_WIDTH = 500;
	
	
	//Tooltips
	
	/**
	 * Field TOOLTIP_DISPLAY_DELAY.
	 * (value is 250)
	 */
	public static final int TOOLTIP_DISPLAY_DELAY = 250; //milliseconds
	
	/**
	 * Field TOOLTIP_DISPLAY_TIME.
	 * (value is 10000)
	 */
	public static final int TOOLTIP_DISPLAY_TIME = 10000; //milliseconds
	
	/**
	 * Field TOOLTIP_DISPLAY_OFFSET_X.
	 * (value is 5)
	 */
	public static final int TOOLTIP_DISPLAY_OFFSET_X = 5;   //pixels
	
	/**
	 * Field TOOLTIP_DISPLAY_OFFSET_Y.
	 * (value is 5)
	 */
	public static final int TOOLTIP_DISPLAY_OFFSET_Y = 5;   //pixels
	
	/**
	 * Field DIALOG_YES.
	 * (value is 0)
	 */
	public static final int DIALOG_YES = 0;
	
	/**
	 * Field DIALOG_NO.
	 * (value is 1)
	 */
	public static final int DIALOG_NO = 1;
	
	
	//Icons
	
	/**
	 * Field fReviewGroupFile.
	 * (value is ""icons/obj16/revgrp_obj.gif"")
	 */
	public static final String REVIEW_GROUP_ICON_FILE = "icons/obj16/revgrp_obj.gif";
	

	//Properties
	
	/**
	 * Field AVAILABLE_PROJECTS_LABEL.
	 * (value is ""Available Projects: "")
	 */
	public static final String AVAILABLE_PROJECTS_LABEL = "Available Projects: ";
	
	/**
	 * Field AVAILABLE_COMPONENTS_LABEL.
	 * (value is ""Available Components: "")
	 */
	public static final String AVAILABLE_COMPONENTS_LABEL = "Available Components: ";
	
	/**
	 * Field DEFAULT_ENTRY_CRITERIA_LABEL.
	 * (value is ""Default Entry Criteria: "")
	 */
	public static final String DEFAULT_ENTRY_CRITERIA_LABEL = "Default Entry Criteria: ";
	
	/**
	 * Field TABBED_PROPERTY_LABEL_WIDTH.
	 * (value is 105)
	 */
	public static final int TABBED_PROPERTY_LABEL_WIDTH = 150;   //pixels
	
	/**
	 * Field TABBED_PROPERTY_TEXT_HEIGHT_DEFAULT.
	 * (value is 50)
	 */
	public static final int TABBED_PROPERTY_TEXT_HEIGHT_DEFAULT = 50;   //pixels
	
	/**
	 * Field NAME_LABEL.
	 * (value is ""Name: "")
	 */
	public static final String NAME_LABEL = "Name: ";
	
	/**
	 * Field FOLDER_LABEL.
	 * (value is ""Folder: "")
	 */
	public static final String FOLDER_LABEL = "Folder: ";
	
	/**
	 * Field DESCRIPTION_LABEL.
	 * (value is ""Description: "")
	 */
	public static final String DESCRIPTION_LABEL = "Description: ";
	
	/**
	 * Field COMPONENTS_LABEL.
	 * (value is ""Components: "")
	 */
	public static final String COMPONENTS_LABEL = "Components: ";
	
	/**
	 * Field ENTRY_CRITERIA_LABEL.
	 * (value is ""Entry Criteria: "")
	 */
	public static final String ENTRY_CRITERIA_LABEL = "Entry Criteria: ";
	
	/**
	 * Field OBJECTIVES_LABEL.
	 * (value is ""Objectives: "")
	 */
	public static final String OBJECTIVES_LABEL = "Objectives: ";
	
	/**
	 * Field REFERENCE_MATERIAL_LABEL.
	 * (value is ""Reference Material: "")
	 */
	public static final String REFERENCE_MATERIAL_LABEL = "Reference Material: ";
	
	/**
	 * Field CREATION_DATE_LABEL.
	 * (value is ""Created: "")
	 */
	public static final String CREATION_DATE_LABEL = "Created: ";
	
	/**
	 * Field START_DATE_LABEL.
	 * (value is ""Started: "")
	 */
	public static final String START_DATE_LABEL = "Started: ";
	
	/**
	 * Field END_DATE_LABEL.
	 * (value is ""Completed: "")
	 */
	public static final String END_DATE_LABEL = "Completed: ";
	
	/**
	 * Field TIME_SPENT_CURRENT_LABEL.
	 * (value is ""Time Spent (current): "")
	 */
	public static final String TIME_SPENT_DETAILED_LABEL = "Time Spent (detailed): ";
	
	/**
	 * Field TIME_SPENT_TOTAL_LABEL.
	 * (value is ""Time Spent (total): "")
	 */
	public static final String TIME_SPENT_TOTAL_LABEL = "Time Spent (total): ";
	
	/**
	 * Field TIME_SPENT_CURRENT_LABEL.
	 * (value is ""Time Spent (current): "")
	 */
	public static final String ROLES_LABEL = "Roles: ";
	
	/**
	 * Field FOCUS_AREA_LABEL.
	 * (value is ""Focus Area: "")
	 */
	public static final String FOCUS_AREA_LABEL = "Focus Area: ";
	
	/**
	 * Field AUTHOR_LABEL.
	 * (value is ""Added by: "")
	 */
	public static final String AUTHOR_LABEL = "Added By: ";
	
	/**
	 * Field ID_LABEL.
	 * (value is ""Id: "")
	 */
	public static final String ID_LABEL = "Id: ";
	
	/**
	 * Field NUM_ITEMS_LABEL.
	 * (value is ""Review Items Added: "")
	 */
	public static final String NUM_ITEMS_LABEL = "Review Items Added: ";
	
	/**
	 * Field NUM_ANOMALIES_LABEL.
	 * (value is ""Anomalies Added: "")
	 */
	public static final String NUM_ANOMALIES_LABEL = "Anomalies Added: ";
	
	/**
	 * Field NUM_COMMENTS_LABEL.
	 * (value is ""Comments Added: "")
	 */
	public static final String NUM_COMMENTS_LABEL = "Comments Added: ";
	
	/**
	 * Field GIT_INVALID_VERSION_ID.
	 * (value is ""0000000000000000000000000000000000000000"")
	 */
	public static final String GIT_INVALID_VERSION_ID = "0000000000000000000000000000000000000000";
	
	/**
	 * Field NO_VERSION_PROPERTY_MESSAGE.
	 * (value is ""(Not present)"")
	 */
	public static final String NO_VERSION_PROPERTY_MESSAGE = "(Not Present)";
	
	/**
	 * Field PROJECT_ID_LABEL.
	 * (value is ""Project Id: "")
	 */
	public static final String PROJECT_LABEL = "Project Id: ";
	
	/**
	 * Field PATH_LABEL.
	 * (value is ""Path: "")
	 */
	public static final String PATH_LABEL = "Path: ";
	
	/**
	 * Field VERSION_LABEL.
	 * (value is ""Version: "")
	 */
	public static final String VERSION_LABEL = "Version: ";
	
	/**
	 * Field POSITION_LABEL.
	 * (value is ""Position: "")
	 */
	public static final String POSITION_LABEL = "Position: ";
	
	/**
	 * Field TITLE_LABEL.
	 * (value is ""Title: "")
	 */
	public static final String TITLE_LABEL = "Title: ";
	
	/**
	 * Field GLOBAL_ANOMALY_PROPERTY_VALUE.
	 * (value is ""(Global review anomaly)"")
	 */
	public static final String GLOBAL_ANOMALY_PROPERTY_VALUE = "(Global Review Anomaly)";
	
	/**
	 * Field FILE_NOT_IN_VERSION_CONTROL_MSG.
	 * (value is ""(Not version controlled)"")
	 */
	public static final String FILE_NOT_IN_VERSION_CONTROL_MSG = "(Not Version Controlled)";
	
	/**
	 * Field IN_PROGRESS_MSG.
	 * (value is ""(In Progress)"")
	 */
	public static final String IN_PROGRESS_MSG = "(In Progress)";
	
	/**
	 * Field STATE_LABEL.
	 * (value is ""State: "")
	 */
	public static final String STATE_LABEL = "State: ";
	
	/**
	 * Field DUE_DATE_LABEL.
	 * (value is ""Due Date: "")
	 */
	public static final String DUE_DATE_LABEL = "Due Date: ";
	
	/**
	 * Field RANK_LABEL.
	 * (value is ""Rank: "")
	 */
	public static final String RANK_LABEL = "Rank: ";
	
	/**
	 * Field NOT_ACCEPTED_REASON_LABEL.
	 * (value is ""Not Accepted Reason: "")
	 */
	public static final String NOT_ACCEPTED_REASON_LABEL = "Not Accepted Reason: ";
	
	/**
	 * Field DECIDED_BY_LABEL.
	 * (value is ""Decided by: "")
	 */
	public static final String DECIDED_BY_LABEL = "Decided by: ";
	
	/**
	 * Field FIXED_BY_LABEL.
	 * (value is ""Fixed by: "")
	 */
	public static final String FIXED_BY_LABEL = "Fixed by: ";
	
	/**
	 * Field FOLLOWUP_BY_LABEL.
	 * (value is ""Follow-up by: "")
	 */
	public static final String FOLLOWUP_BY_LABEL = "Follow-up by: ";
	
	
	//Review types
	
	/**
	 * Field REVIEW_TYPE_BASIC.
	 * (value is ""Basic"")
	 */
	public static final String REVIEW_TYPE_BASIC = "Basic";
	
	/**
	 * Field REVIEW_TYPE_INFORMAL.
	 * (value is ""Informal"")
	 */
	public static final String REVIEW_TYPE_INFORMAL = "Informal";
	
	/**
	 * Field REVIEW_TYPE_FORMAL.
	 * (value is ""Formal"")
	 */
	public static final String REVIEW_TYPE_FORMAL = "Formal";
	
	
	//Review item types
	
	/**
	 * Field REVIEW_ITEM_TYPE_RESOURCE.
	 * (value is 0)
	 */
	public static final int REVIEW_ITEM_TYPE_RESOURCE = 0;
	
	/**
	 * Field REVIEW_ITEM_TYPE_COMMIT.
	 * (value is 1)
	 */
	public static final int REVIEW_ITEM_TYPE_COMMIT = 1;
	
	
	//User Roles
	
	/**
	 * Field USER_ROLE_LEAD.
	 * (value is ""Lead"")
	 */
	public static final String USER_ROLE_LEAD = "Lead";
	
	/**
	 * Field USER_ROLE_AUTHOR.
	 * (value is ""Author"")
	 */
	public static final String USER_ROLE_AUTHOR = "Author";
	
	/**
	 * Field USER_ROLE_REVIEWER.
	 * (value is ""Reviewer"")
	 */
	public static final String USER_ROLE_REVIEWER = "Reviewer";
	
	
	//Commands
	
	/**
	 * Field TOGGLE_STATE_COMMAND_KEY.
	 * (value is ""org.eclipse.ui.commands.toggleState"")
	 */
	public static final String TOGGLE_STATE_COMMAND_KEY = "org.eclipse.ui.commands.toggleState";
	
	/**
	 * Field LINK_EDITOR_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.LinkEditor"")
	 */
	public static final String LINK_EDITOR_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.LinkEditor";
	
	/**
	 * Field LINK_PROPERTIES_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.LinkProperties"")
	 */
	public static final String LINK_PROPERTIES_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.LinkProperties";
	
	/**
	 * Field ALPHA_SORTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.DefaultSort"")
	 */
	public static final String ALPHA_SORTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.DefaultSort";
	
	/**
	 * Field ALPHA_SORTER_ICON_FILE.
	 * (value is ""icons/elcl16/defsort_menu.gif"")
	 */
	public static final String ALPHA_SORTER_ICON_FILE = "icons/elcl16/defsort_menu.gif";
	
	/**
	 * Field ALPHA_SORTER_NAME.
	 * (value is ""Element name"")
	 */
	public static final String ALPHA_SORTER_NAME = "Element Name";
	
	/**
	 * Field ALPHA_SORTER_TOOLTIP.
	 * (value is ""Sort alphabetically"")
	 */
	public static final String ALPHA_SORTER_TOOLTIP = "Sort Alphabetically";
	
	/**
	 * Field ALPHA_SORTER_MNEMONIC.
	 * (value is ""s"")
	 */
	public static final String ALPHA_SORTER_MNEMONIC = "s";
	
	/**
	 * Field CURRENT_REVIEW_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.CurrentReview"")
	 */
	public static final String CURRENT_REVIEW_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.CurrentReview";
	
	/**
	 * Field CURRENT_REVIEW_FILTER_NAME.
	 * (value is ""Show current review"")
	 */
	public static final String CURRENT_REVIEW_FILTER_NAME = "Show Current Review";
	
	/**
	 * Field CURRENT_REVIEW_FILTER_TOOLTIP.
	 * (value is ""Only show the currently open review"")
	 */
	public static final String CURRENT_REVIEW_FILTER_TOOLTIP = "Only Show the Currently Open Review";
	
	/**
	 * Field CURRENT_REVIEW_FILTER_MNEMONIC.
	 * (value is ""c"")
	 */
	public static final String CURRENT_REVIEW_FILTER_MNEMONIC = "c";
	
	/**
	 * Field REVIEWS_ONLY_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsOnly"")
	 */
	public static final String REVIEWS_ONLY_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsOnly";
	
	/**
	 * Field REVIEWS_ONLY_FILTER_NAME.
	 * (value is ""Show reviews only"")
	 */
	public static final String REVIEWS_ONLY_FILTER_NAME = "Show Reviews Only";
	
	/**
	 * Field REVIEWS_ONLY_FILTER_TOOLTIP.
	 * (value is ""Only show reviews"")
	 */
	public static final String REVIEWS_ONLY_FILTER_TOOLTIP = "Only Show Review Elements";
	
	/**
	 * Field REVIEWS_ONLY_FILTER_MNEMONIC.
	 * (value is ""o"")
	 */
	public static final String REVIEWS_ONLY_FILTER_MNEMONIC = "o";
	
	/**
	 * Field REVIEWS_MY_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsMy"")
	 */
	public static final String REVIEWS_MY_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsMy";
	
	/**
	 * Field REVIEWS_MY_FILTER_NAME.
	 * (value is ""Show my reviews"")
	 */
	public static final String REVIEWS_MY_FILTER_NAME = "Show My Reviews";
	
	/**
	 * Field REVIEWS_MY_FILTER_TOOLTIP.
	 * (value is ""Show reviews I am participating in"")
	 */
	public static final String REVIEWS_MY_FILTER_TOOLTIP = "Show Reviews I am Participating In";
	
	/**
	 * Field REVIEWS_MY_FILTER_MNEMONIC.
	 * (value is ""m"")
	 */
	public static final String REVIEWS_MY_FILTER_MNEMONIC = "m";
	
	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsParticipant"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsParticipant";
	
	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_NAME.
	 * (value is ""Show reviews for participant... "")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_NAME = "Show Reviews for Participant... ";
	
	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_TOOLTIP.
	 * (value is ""Show reviews the given participant is participating in"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_TOOLTIP = "Show Reviews the Given Participant is Participating In";
	
	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_MNEMONIC.
	 * (value is ""p"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_MNEMONIC = "p";
	
	/**
	 * Field ANOMALIES_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.Anomalies"")
	 */
	public static final String ANOMALIES_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.Anomalies";
	
	/**
	 * Field ANOMALIES_FILTER_NAME.
	 * (value is ""Hide selections"")
	 */
	public static final String ANOMALIES_FILTER_NAME = "Hide Selections";
	
	/**
	 * Field ANOMALIES_FILTER_TOOLTIP.
	 * (value is ""Hide selections and only show anomalies"")
	 */
	public static final String ANOMALIES_FILTER_TOOLTIP = "Hide Selections and Only Show Anomalies";
	
	/**
	 * Field ANOMALIES_FILTER_MNEMONIC.
	 * (value is ""a"")
	 */
	public static final String ANOMALIES_FILTER_MNEMONIC = "a";
	
	/**
	 * Field REVIEWED_ELEMS_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewedElems"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewedElems";
	
	/**
	 * Field REVIEWED_ELEMS_FILTER_NAME.
	 * (value is ""Hide reviewed elements"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_NAME = "Hide Reviewed Elements";
	
	/**
	 * Field REVIEWED_ELEMS_FILTER_TOOLTIP.
	 * (value is ""Hide reviewed elements"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_TOOLTIP = "Hide Reviewed Elements";
	
	/**
	 * Field REVIEWED_ELEMS_FILTER_MNEMONIC.
	 * (value is ""e"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_MNEMONIC = "e";
	
	/**
	 * Field REMOVE_ALL_FILTER_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.RemoveAll"")
	 */
	public static final String REMOVE_ALL_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.RemoveAll";
	
	/**
	 * Field REMOVE_ALL_FILTER_NAME.
	 * (value is ""Remove all filters"")
	 */
	public static final String REMOVE_ALL_FILTER_NAME = "Remove All Filters";
	
	/**
	 * Field REMOVE_ALL_FILTER_TOOLTIP.
	 * (value is ""Remove all applied filters"")
	 */
	public static final String REMOVE_ALL_FILTER_TOOLTIP = "Remove All Applied Filters";
	
	/**
	 * Field REMOVE_ALL_FILTER_MNEMONIC.
	 * (value is ""r"")
	 */
	public static final String REMOVE_ALL_FILTER_MNEMONIC = "r";
	
	/**
	 * Field ADD_LINKED_ANOMALY_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.addLinkedAnomaly"")
	 */
	public static final String ADD_LINKED_ANOMALY_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.addLinkedAnomaly";
	
	/**
	 * Field ADD_LINKED_ANOMALY_NAME.
	 * (value is ""Add linked anomaly"")
	 */
	public static final String ADD_LINKED_ANOMALY_NAME = "Add Linked Anomaly";
	
	/**
	 * Field ADD_LINKED_ANOMALY_TOOLTIP.
	 * (value is ""Add a new anomaly that is linked to this selection"")
	 */
	public static final String ADD_LINKED_ANOMALY_TOOLTIP = "Add a New Anomaly that is Linked to this Selection";
	
	/**
	 * Field ADD_LINKED_ANOMALY_MNEMONIC.
	 * (value is ""l"")
	 */
	public static final String ADD_LINKED_ANOMALY_MNEMONIC = "l";
	
	/**
	 * Field OPEN_EDITOR_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.openEditor"")
	 */
	public static final String OPEN_EDITOR_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.openEditor";
	
	/**
	 * Field OPEN_EDITOR_ICON_FILE.
	 * (value is ""icons/elcl16/openfile_menu.gif"")
	 */
	public static final String OPEN_EDITOR_ICON_FILE = "icons/elcl16/openfile_menu.gif";
	
	/**
	 * Field OPEN_EDITOR_COMMAND_NAME.
	 * (value is ""Open file in editor"")
	 */
	public static final String OPEN_EDITOR_COMMAND_NAME = "Open File in Editor";
	
	/**
	 * Field OPEN_EDITOR_COMMAND_TOOLTIP.
	 * (value is ""Open the parent file with the matching editor and locate element"")
	 */
	public static final String OPEN_EDITOR_COMMAND_TOOLTIP = "Open the Parent File with the Matching Editor and Locate Element";
	
	/**
	 * Field OPEN_EDITOR_COMMAND_MNEMONIC.
	 * (value is ""e"")
	 */
	public static final String OPEN_EDITOR_COMMAND_MNEMONIC = "e";

	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.changeReviewState"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.changeReviewState";
	
	/**
	 * Field CHANGE_REVIEW_STATE_ICON_FILE.
	 * (value is ""icons/obj16/done_tsk.gif"")
	 */
	public static final String CHANGE_REVIEW_STATE_ICON_FILE = "icons/obj16/done_tsk.gif";
	
	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_NAME.
	 * (value is ""Mark/Unmark as completed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_NAME = "Mark/Unmark as Completed";
	
	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_TOOLTIP.
	 * (value is ""Mark/Unmark this element as reviewed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_TOOLTIP = "Mark/Unmark this Element as Reviewed";
	
	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_MNEMONIC.
	 * (value is ""c"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_MNEMONIC = "c";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.openElement"")
	 */
	public static final String OPEN_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.openElement";
	
	/**
	 * Field OPEN_ELEMENT_ICON_FILE.
	 * (value is ""icons/obj16/open_tsk.gif"")
	 */
	public static final String OPEN_ELEMENT_ICON_FILE = "icons/obj16/open_tsk.gif";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND_NAME.
	 * (value is ""Open element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_NAME = "Open Element";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Open and load data for this element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_TOOLTIP = "Open and Load Data for this Element";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""o"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_MNEMONIC = "o";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.closeElement"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.closeElement";
	
	/**
	 * Field CLOSE_ELEMENT_ICON_FILE.
	 * (value is ""icons/obj16/close_tsk.gif"")
	 */
	public static final String CLOSE_ELEMENT_ICON_FILE = "icons/obj16/close_tsk.gif";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND_NAME.
	 * (value is ""Close element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_NAME = "Close Element";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Close and unload data for this element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_TOOLTIP = "Close and Unload Data for this Element";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""c"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_MNEMONIC = "c";
	
	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.addChildElement"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.addChildElement";
	
	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_NAME.
	 * (value is ""Add review group"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_NAME = "Add Review Group";
	
	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Add a new review group"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_TOOLTIP = "Add a New Review Group";
	
	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""a"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_MNEMONIC = "a";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.removeElement"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.removeElement";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND_NAME.
	 * (value is ""Remove element"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_NAME = "Disable Element";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Remove this element"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_TOOLTIP = "Disable (and Optionally Remove) this Element";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""r"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_MNEMONIC = "x";
	
	/**
	 * Field RESTORE_ELEMENT_COMMAND.
	 * (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.restoreElement"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.restoreElement";
	
	/**
	 * Field RESTORE_ELEMENT_COMMAND_NAME.
	 * (value is ""Restore element"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_NAME = "Restore Element";
	
	/**
	 * Field RESTORE_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Restore this disabled element"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_TOOLTIP = "Restore this Disabled Element";
	
	/**
	 * Field RESTORE_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""r"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_MNEMONIC = "r";
}
