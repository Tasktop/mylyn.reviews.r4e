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
	 * Field R4E_TEMP_PROJECT. (value is ""R4ETemp"")
	 */
	public static final String R4E_TEMP_PROJECT = "R4ETemp";

	/**
	 * Field R4E_TEMP_FOLDER. (value is ""temp"")
	 */
	public static final String R4E_TEMP_FOLDER = "temp";

	/**
	 * Field R4E_PROPERTIES_VIEW_NAME. (value is ""org.eclipse.mylyn.reviews.r4e.ui.properties.R4EPropertiesView"")
	 */
	public static final String R4E_PROPERTIES_VIEW_NAME = "org.eclipse.mylyn.reviews.r4e.ui.properties.R4EPropertiesView"; // $codepro.audit.disable constantNamingConvention

	/**
	 * Field GROUP_FILE_SUFFIX. (value is ""_group_root.xrer"")
	 */
	public static final String GROUP_FILE_SUFFIX = "_group_root.xrer";

	/**
	 * Field RULE_SET_FILE_SUFFIX. (value is ""_rule_set.xrer"")
	 */
	public static final String RULE_SET_FILE_SUFFIX = "_rule_set.xrer";

	/**
	 * Field VALUE_TRUE_STR. (value is ""true"")
	 */
	public static final String VALUE_TRUE_STR = "true";

	/**
	 * Field NO_OFFSET. (value is 0)
	 */
	public static final int NO_OFFSET = 0;

	/**
	 * Field LINE_OFFSET. (value is 1)
	 */
	public static final int LINE_OFFSET = 1;

	/**
	 * Field REVIEW_GROUP_PATHS_LENGTH. (value is 128)
	 */
	public static final int REVIEW_GROUP_PATHS_LENGTH = 128;

	/**
	 * Field TOOLTIP_CONTENTS_LENGTH. (value is 25)
	 */
	public static final int TOOLTIP_CONTENTS_LENGTH = 25;

	/**
	 * Field INVALID_VALUE. (value is -1)
	 */
	public static final int INVALID_VALUE = -1;

	/**
	 * Field SELECTIONS_LABEL. (value is ""Selections"")
	 */
	public static final String SELECTIONS_LABEL = "Selections";

	/**
	 * Field DELTAS_LABEL. (value is ""Deltas"")
	 */
	public static final String DELTAS_LABEL = "Deltas";

	/**
	 * Field ANOMALIES_LABEL_NAME. (value is ""Anomalies"")
	 */
	public static final String ANOMALIES_LABEL = "Anomalies";

	/**
	 * Field GLOBAL_ANOMALIES_LABEL_NAME. (value is ""Global Anomalies"")
	 */
	public static final String GLOBAL_ANOMALIES_LABEL = "Global Anomalies";

	/**
	 * Field PARTICIPANTS_LABEL_NAME. (value is ""Participants"")
	 */
	public static final String PARTICIPANTS_LABEL = "Participants";

	/**
	 * Field LINE_TAG. (value is ""Line "")
	 */
	public static final String LINE_TAG = "Line ";

	/**
	 * Field LINES_TAG. (value is ""Lines "")
	 */
	public static final String LINES_TAG = "Lines ";

	/**
	 * Field DEFAULT_LINE_TAG_LENGTH. (value is 28)
	 */
	public static final int DEFAULT_LINE_TAG_LENGTH = 28;

	/**
	 * Field DIALOG_TITLE_ERROR. (value is ""R4E Error"")
	 */
	public static final String DIALOG_TITLE_ERROR = "R4E Error";

	/**
	 * Field DIALOG_TITLE_WARNING. (value is ""R4E Warning"")
	 */
	public static final String DIALOG_TITLE_WARNING = "R4E Warning";

	/**
	 * Field DIALOG_TITLE_INFO. (value is ""R4E Info"")
	 */
	public static final String DIALOG_TITLE_INFO = "R4E Info";

	/**
	 * Field REVIEW_NOT_COMPLETED_ERROR. (value is ""Review Error"")
	 */
	public static final String REVIEW_NOT_COMPLETED_ERROR = "Review Error";

	/**
	 * Field SHOW_DISABLED_FILTER_NAME. (value is ""Show disabled elements"")
	 */
	public static final String SHOW_DISABLED_FILTER_NAME = "Show Disabled Elements";

	/**
	 * Field DIALOG_DEFAULT_HEIGHT. (value is 500)
	 */
	public static final int DIALOG_DEFAULT_HEIGHT = 600;

	/**
	 * Field DIALOG_DEFAULT_WIDTH. (value is 500)
	 */
	public static final int DIALOG_DEFAULT_WIDTH = 500;

	//Tooltips

	/**
	 * Field TOOLTIP_DISPLAY_DELAY. (value is 250)
	 */
	public static final int TOOLTIP_DISPLAY_DELAY = 250; //milliseconds

	/**
	 * Field TOOLTIP_DISPLAY_TIME. (value is 10000)
	 */
	public static final int TOOLTIP_DISPLAY_TIME = 10000; //milliseconds

	/**
	 * Field TOOLTIP_DISPLAY_OFFSET_X. (value is 5)
	 */
	public static final int TOOLTIP_DISPLAY_OFFSET_X = 5; //pixels

	/**
	 * Field TOOLTIP_DISPLAY_OFFSET_Y. (value is 5)
	 */
	public static final int TOOLTIP_DISPLAY_OFFSET_Y = 5; //pixels

	/**
	 * Field DIALOG_YES. (value is 0)
	 */
	public static final int DIALOG_YES = 0;

	/**
	 * Field DIALOG_NO. (value is 1)
	 */
	public static final int DIALOG_NO = 1;

	//Icons

	/**
	 * Field BUTTON_ADD_LABEL. (value is ""Add"")
	 */
	public static final String BUTTON_ADD_LABEL = "Add";

	/**
	 * Field BUTTON_REMOVE_LABEL. (value is ""Remove"")
	 */
	public static final String BUTTON_REMOVE_LABEL = "Remove";

	//Properties

	/**
	 * Field AVAILABLE_PROJECTS_LABEL. (value is ""Available Projects: "")
	 */
	public static final String AVAILABLE_PROJECTS_LABEL = "Available Projects: ";

	/**
	 * Field AVAILABLE_COMPONENTS_LABEL. (value is ""Available Components: "")
	 */
	public static final String AVAILABLE_COMPONENTS_LABEL = "Available Components: ";

	/**
	 * Field DEFAULT_ENTRY_CRITERIA_LABEL. (value is ""Default Entry Criteria: "")
	 */
	public static final String DEFAULT_ENTRY_CRITERIA_LABEL = "Default Entry Criteria: ";

	/**
	 * Field TABBED_PROPERTY_LABEL_WIDTH. (value is 105)
	 */
	public static final int TABBED_PROPERTY_LABEL_WIDTH = 150; //pixels

	/**
	 * Field TABBED_PROPERTY_TEXT_HEIGHT_DEFAULT. (value is 50)
	 */
	public static final int TABBED_PROPERTY_TEXT_HEIGHT_DEFAULT = 50; //pixels

	/**
	 * Field FILE_LOCATION_LABEL. (value is ""File location: "")
	 */
	public static final String FILE_LOCATION_LABEL = "File Location: ";

	/**
	 * Field NAME_LABEL. (value is ""Name: "")
	 */
	public static final String NAME_LABEL = "Name: ";

	/**
	 * Field FOLDER_LABEL. (value is ""Folder: "")
	 */
	public static final String FOLDER_LABEL = "Folder: ";

	/**
	 * Field DESCRIPTION_LABEL. (value is ""Description: "")
	 */
	public static final String DESCRIPTION_LABEL = "Description: ";

	/**
	 * Field COMPONENTS_LABEL. (value is ""Components: "")
	 */
	public static final String COMPONENTS_LABEL = "Components: ";

	/**
	 * Field ENTRY_CRITERIA_LABEL. (value is ""Entry Criteria: "")
	 */
	public static final String ENTRY_CRITERIA_LABEL = "Entry Criteria: ";

	/**
	 * Field OBJECTIVES_LABEL. (value is ""Objectives: "")
	 */
	public static final String OBJECTIVES_LABEL = "Objectives: ";

	/**
	 * Field REFERENCE_MATERIAL_LABEL. (value is ""Reference Material: "")
	 */
	public static final String REFERENCE_MATERIAL_LABEL = "Reference Material: ";

	/**
	 * Field EXIT_DECISION_LABEL. (value is ""Exit Decision: "")
	 */
	public static final String EXIT_DECISION_LABEL = "Exit Decision: ";

	/**
	 * Field CREATION_DATE_LABEL. (value is ""Created: "")
	 */
	public static final String CREATION_DATE_LABEL = "Creation Date: ";

	/**
	 * Field START_DATE_LABEL. (value is ""Started: "")
	 */
	public static final String START_DATE_LABEL = "Start Date: ";

	/**
	 * Field PREPARATION_DATE_LABEL. (value is ""Preparation Date: "")
	 */
	public static final String PREPARATION_DATE_LABEL = "Preparation Date: ";

	/**
	 * Field DECISION_DATE_LABEL. (value is ""Decision Date: "")
	 */
	public static final String DECISION_DATE_LABEL = "Decision Date: ";

	/**
	 * Field REWORK_DATE_LABEL. (value is ""Rework Date: "")
	 */
	public static final String REWORK_DATE_LABEL = "Rework Date: ";

	/**
	 * Field END_DATE_LABEL. (value is ""CEnd Date: "")
	 */
	public static final String END_DATE_LABEL = "End Date: ";

	/**
	 * Field MEETING_DECISION_LABEL. (value is ""Meeting: "")
	 */
	public static final String DECISION_MEETING_LABEL = "Meeting: ";

	/**
	 * Field DECISION_PARTICIPANTS_LABEL. (value is ""Decision Participants: "")
	 */
	public static final String DECISION_PARTICIPANTS_LABEL = "Decision Participants: ";

	/**
	 * Field DECISION_TIME_SPENT_LABEL. (value is ""Decision Time Spent: "")
	 */
	public static final String DECISION_TIME_SPENT_LABEL = "Decision Time Spent: ";

	/**
	 * Field SUBJECT_LABEL. (value is ""Subject: "")
	 */
	public static final String SUBJECT_LABEL = "Subject: ";

	/**
	 * Field TIME_SPENT_LABEL. (value is ""Time Spent: "")
	 */
	public static final String TIME_SPENT_LABEL = "Time Spent: ";

	/**
	 * Field TIME_SPENT_TOTAL_LABEL. (value is ""Time Spent (total): "")
	 */
	public static final String TIME_SPENT_TOTAL_LABEL = "Time Spent (total): ";

	/**
	 * Field EMAIL_LABEL. (value is ""Email: "")
	 */
	public static final String EMAIL_LABEL = "Email: ";

	/**
	 * Field USER_DETAILS_LABEL. (value is ""User Details: "")
	 */
	public static final String USER_DETAILS_LABEL = "User Details: ";

	/**
	 * Field ROLES_LABEL. (value is ""Roles: "")
	 */
	public static final String ROLES_LABEL = "Roles: ";

	/**
	 * Field FOCUS_AREA_LABEL. (value is ""Focus Area: "")
	 */
	public static final String FOCUS_AREA_LABEL = "Focus Area: ";

	/**
	 * Field PHASE_LABEL. (value is ""Phase: "")
	 */
	public static final String PHASE_LABEL = "Phase: ";

	/**
	 * Field PHASE_INFO_LABEL. (value is ""Phase Information: "")
	 */
	public static final String PHASE_INFO_LABEL = "Phase Information: ";

	/**
	 * Field PHASE_MAP_LABEL. (value is ""Phase Map: "")
	 */
	public static final String PHASE_MAP_LABEL = "Phase Map: ";

	/**
	 * Field PHASE_OWNER_LABEL. (value is ""Owner: "")
	 */
	public static final String PHASE_OWNER_LABEL = "Owner: ";

	/**
	 * Field REVIEW_PHASE_PLANNING. (value is ""PLANNING"")
	 */
	public static final String PHASE_PLANNING_LABEL = "PLANNING";

	/**
	 * Field REVIEW_PHASE_PREPARATION. (value is ""PREPARATION"")
	 */
	public static final String PHASE_PREPARATION_LABEL = "PREPARATION";

	/**
	 * Field REVIEW_PHASE_DECISION. (value is ""DECISION"")
	 */
	public static final String PHASE_DECISION_LABEL = "DECISION";

	/**
	 * Field REVIEW_PHASE_REWORK. (value is ""REWORK"")
	 */
	public static final String PHASE_REWORK_LABEL = "REWORK";

	/**
	 * Field REVIEW_PHASE_COMPLETED. (value is ""COMPLETED"")
	 */
	public static final String PHASE_COMPLETED_LABEL = "COMPLETED";

	/**
	 * Field DECISION_LABEL. (value is ""Decision: "")
	 */
	public static final String DECISION_LABEL = "Decision: ";

	/**
	 * Field DECISION_INFO_LABEL. (value is ""Decision Information: "")
	 */
	public static final String DECISION_INFO_LABEL = "Decision Information: ";

	/**
	 * Field START_TIME_LABEL. (value is ""Starts: "")
	 */
	public static final String START_TIME_LABEL = "Starts: ";

	/**
	 * Field DURATION_LABEL. (value is ""Duration (minutes): "")
	 */
	public static final String DURATION_LABEL = "Duration (minutes): ";

	/**
	 * Field LOCATION_LABEL. (value is ""Location: "")
	 */
	public static final String LOCATION_LABEL = "Location: ";

	/**
	 * Field AUTHOR_LABEL. (value is ""Added by: "")
	 */
	public static final String AUTHOR_LABEL = "Added By: ";

	/**
	 * Field ID_LABEL. (value is ""Id: "")
	 */
	public static final String ID_LABEL = "Id: ";

	/**
	 * Field NUM_ITEMS_LABEL. (value is ""Review Items Added: "")
	 */
	public static final String NUM_ITEMS_LABEL = "Review Items Added: ";

	/**
	 * Field NUM_ANOMALIES_LABEL. (value is ""Anomalies Added: "")
	 */
	public static final String NUM_ANOMALIES_LABEL = "Anomalies Added: ";

	/**
	 * Field NUM_COMMENTS_LABEL. (value is ""Comments Added: "")
	 */
	public static final String NUM_COMMENTS_LABEL = "Comments Added: ";

	/**
	 * Field GIT_INVALID_VERSION_ID. (value is ""0000000000000000000000000000000000000000"")
	 */
	public static final String GIT_INVALID_VERSION_ID = "0000000000000000000000000000000000000000";

	/**
	 * Field NO_VERSION_PROPERTY_MESSAGE. (value is ""(Not present)"")
	 */
	public static final String NO_VERSION_PROPERTY_MESSAGE = "(Not Present)";

	/**
	 * Field PROJECT_ID_LABEL. (value is ""Project Id: "")
	 */
	public static final String PROJECT_LABEL = "Project Id: ";

	/**
	 * Field PATH_LABEL. (value is ""Path: "")
	 */
	public static final String PATH_LABEL = "Path: ";

	/**
	 * Field VERSION_LABEL. (value is ""Version: "")
	 */
	public static final String VERSION_LABEL = "Version: ";

	/**
	 * Field FILE_LABEL. (value is ""File: "")
	 */
	public static final String FILE_LABEL = "File: ";

	/**
	 * Field POSITION_LABEL. (value is ""Position: "")
	 */
	public static final String POSITION_LABEL = "Position: ";

	/**
	 * Field TITLE_LABEL. (value is ""Title: "")
	 */
	public static final String TITLE_LABEL = "Title: ";

	/**
	 * Field GLOBAL_ANOMALY_PROPERTY_VALUE. (value is ""(Global review anomaly)"")
	 */
	public static final String GLOBAL_ANOMALY_PROPERTY_VALUE = "(Global Review Anomaly)";

	/**
	 * Field FILE_NOT_IN_VERSION_CONTROL_MSG. (value is ""(Not version controlled)"")
	 */
	public static final String FILE_NOT_IN_VERSION_CONTROL_MSG = "(Not Version Controlled)";

	/**
	 * Field IN_PROGRESS_MSG. (value is ""(In Progress)"")
	 */
	public static final String IN_PROGRESS_MSG = "(In Progress)";

	/**
	 * Field STATE_LABEL. (value is ""State: "")
	 */
	public static final String STATE_LABEL = "State: ";

	/**
	 * Field DUE_DATE_LABEL. (value is ""Due Date: "")
	 */
	public static final String DUE_DATE_LABEL = "Due Date: ";

	/**
	 * Field CLASS_LABEL. (value is ""Class: "")
	 */
	public static final String CLASS_LABEL = "Class: ";

	/**
	 * Field RANK_LABEL. (value is ""Rank: "")
	 */
	public static final String RANK_LABEL = "Rank: ";

	/**
	 * Field RULE_ID_LABEL. (value is ""Rule ID: "")
	 */
	public static final String RULE_ID_LABEL = "Rule ID: ";

	/**
	 * Field NOT_ACCEPTED_REASON_LABEL. (value is ""Reason for Rejection: "")
	 */
	public static final String NOT_ACCEPTED_REASON_LABEL = "Reason for Rejection: ";

	/**
	 * Field DECIDED_BY_LABEL. (value is ""Decided by: "")
	 */
	public static final String DECIDED_BY_LABEL = "Decided by: ";

	/**
	 * Field FIXED_BY_LABEL. (value is ""Fixed by: "")
	 */
	public static final String FIXED_BY_LABEL = "Fixed by: ";

	/**
	 * Field FOLLOWUP_BY_LABEL. (value is ""Follow-up by: "")
	 */
	public static final String FOLLOWUP_BY_LABEL = "Follow-up by: ";

	/**
	 * Field RULE_SETS_LABEL. (value is ""Applied Rule Sets: "")
	 */
	public static final String RULE_SETS_LABEL = "Applied Rule Sets: ";

	/**
	 * Field DEFAULT_DATE_FORMAT. (value is ""yyyy/MM/dd HH:mm:ss"")
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MMM-dd HH:mm:ss";

	/**
	 * Field SIMPLE_DATE_FORMAT. (value is ""yyyy/MM/dd"")
	 */
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MMM-dd";

	/**
	 * Field SIMPLE_DATE_FORMAT_MINUTES. (value is ""yyyy/MM/dd hh:mm"")
	 */
	public static final String SIMPLE_DATE_FORMAT_MINUTES = "yyyy-MMM-dd HH:mm";

	/**
	 * Field SPENT_TIME_COLUMN_HEADER. (value is ""Time spent (minutes)"")
	 */
	public static final String SPENT_TIME_COLUMN_HEADER = "Time spent (minutes)";

	/**
	 * Field ENTRY_TIME_COLUMN_HEADER. (value is ""Time of entry"")
	 */
	public static final String ENTRY_TIME_COLUMN_HEADER = "Time of entry";

	/**
	 * Field BASIC_PARAMS_HEADER. (value is ""Basic Parameters"")
	 */
	public static final String BASIC_PARAMS_HEADER = "Basic Parameters";

	/**
	 * Field EXTRA_PARAMS_HEADER. (value is ""Extra Parameters"")
	 */
	public static final String EXTRA_PARAMS_HEADER = "Extra Parameters";

	//Review types

	/**
	 * Field REVIEW_TYPE_BASIC. (value is ""Basic"")
	 */
	public static final String REVIEW_TYPE_BASIC = "Basic";

	/**
	 * Field REVIEW_TYPE_INFORMAL. (value is ""Informal"")
	 */
	public static final String REVIEW_TYPE_INFORMAL = "Informal";

	/**
	 * Field REVIEW_TYPE_FORMAL. (value is ""Formal"")
	 */
	public static final String REVIEW_TYPE_FORMAL = "Formal";

	//Review item types

	/**
	 * Field REVIEW_ITEM_TYPE_RESOURCE. (value is 0)
	 */
	public static final int REVIEW_ITEM_TYPE_RESOURCE = 0;

	/**
	 * Field REVIEW_ITEM_TYPE_COMMIT. (value is 1)
	 */
	public static final int REVIEW_ITEM_TYPE_COMMIT = 1;

	//User Roles

	/**
	 * Field USER_ROLE_LEAD. (value is ""Lead"")
	 */
	public static final String USER_ROLE_LEAD = "Lead";

	/**
	 * Field USER_ROLE_AUTHOR. (value is ""Author"")
	 */
	public static final String USER_ROLE_AUTHOR = "Author";

	/**
	 * Field USER_ROLE_REVIEWER. (value is ""Reviewer"")
	 */
	public static final String USER_ROLE_REVIEWER = "Reviewer";

	/**
	 * Field USER_ROLE_ORGANIZER. (value is ""Organizer"")
	 */
	public static final String USER_ROLE_ORGANIZER = "Organizer";

	/**
	 * Field PARTICIPANT_ROLES.
	 */
	public static final String[] PARTICIPANT_ROLES = { R4EUIConstants.USER_ROLE_LEAD, R4EUIConstants.USER_ROLE_AUTHOR,
			R4EUIConstants.USER_ROLE_REVIEWER, USER_ROLE_ORGANIZER };

	//Anomaly Classes & Ranks

	/**
	 * Field ANOMALY_CLASS_ERRONEOUS. (value is ""Erroneous"")
	 */
	public static final String ANOMALY_CLASS_ERRONEOUS = "Erroneous";

	/**
	 * Field ANOMALY_CLASS_SUPERFLUOUS. (value is ""Superfluous"")
	 */
	public static final String ANOMALY_CLASS_SUPERFLUOUS = "Superfluous";

	/**
	 * Field ANOMALY_CLASS_IMPROVEMENT. (value is ""Improvement"")
	 */
	public static final String ANOMALY_CLASS_IMPROVEMENT = "Improvement";

	/**
	 * Field ANOMALY_CLASS_QUESTION. (value is ""Question"")
	 */
	public static final String ANOMALY_CLASS_QUESTION = "Question";

	/**
	 * Field ANOMALY_RANK_NONE. (value is ""NONE"")
	 */
	public static final String ANOMALY_RANK_NONE = "NONE";

	/**
	 * Field ANOMALY_RANK_MINOR. (value is ""MINOR"")
	 */
	public static final String ANOMALY_RANK_MINOR = "MINOR";

	/**
	 * Field ANOMALY_RANK_MAJOR. (value is ""MAJOR"")
	 */
	public static final String ANOMALY_RANK_MAJOR = "MAJOR";

	/**
	 * Field RANK_VALUES.
	 */
	public static final String[] RANK_VALUES = { R4EUIConstants.ANOMALY_RANK_NONE, R4EUIConstants.ANOMALY_RANK_MINOR,
			R4EUIConstants.ANOMALY_RANK_MAJOR }; //NOTE: This has to match R4EAnomalyRank in R4E core plugin

	/**
	 * Field CLASS_VALUES.
	 */
	public static final String[] CLASS_VALUES = { R4EUIConstants.ANOMALY_CLASS_ERRONEOUS,
			R4EUIConstants.ANOMALY_CLASS_SUPERFLUOUS, R4EUIConstants.ANOMALY_CLASS_IMPROVEMENT,
			R4EUIConstants.ANOMALY_CLASS_QUESTION }; //NOTE: This has to match CommentType in R4E core plugin

	/**
	 * Field MESSAGE_TYPE_ITEMS_READY. (value is "0")
	 */
	public static final int MESSAGE_TYPE_ITEMS_READY = 0;

	/**
	 * Field MESSAGE_TYPE_ITEMS_READY. (value is "1")
	 */
	public static final int MESSAGE_TYPE_ITEMS_REMOVED = 1;

	/**
	 * Field MESSAGE_TYPE_ITEMS_READY. (value is "2")
	 */
	public static final int MESSAGE_TYPE_PROGRESS = 2;

	/**
	 * Field MESSAGE_TYPE_ITEMS_READY. (value is "3")
	 */
	public static final int MESSAGE_TYPE_COMPLETION = 3;

	/**
	 * Field MESSAGE_TYPE_ITEMS_READY. (value is "4")
	 */
	public static final int MESSAGE_TYPE_QUESTION = 4;

	//Commands

	/**
	 * Field TOGGLE_STATE_COMMAND_KEY. (value is ""org.eclipse.ui.commands.toggleState"")
	 */
	public static final String TOGGLE_STATE_COMMAND_KEY = "org.eclipse.ui.commands.toggleState";

	/**
	 * Field LINK_EDITOR_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.LinkEditor"")
	 */
	public static final String LINK_EDITOR_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.LinkEditor";

	/**
	 * Field LINK_PROPERTIES_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.LinkProperties"")
	 */
	public static final String LINK_PROPERTIES_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.LinkProperties";

	/**
	 * Field ALPHA_SORTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.AlphaSort"")
	 */
	public static final String ALPHA_SORTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.AlphaSort";

	/**
	 * Field ALPHA_SORTER_ICON_FILE. (value is ""icons/elcl16/alphasort_menu.gif"")
	 */
	public static final String ALPHA_SORTER_ICON_FILE = "icons/elcl16/alphasort_menu.gif";

	/**
	 * Field ALPHA_SORTER_NAME. (value is ""Element name"")
	 */
	public static final String ALPHA_SORTER_NAME = "Element Name";

	/**
	 * Field ALPHA_SORTER_TOOLTIP. (value is ""Sort alphabetically"")
	 */
	public static final String ALPHA_SORTER_TOOLTIP = "Sort Alphabetically";

	/**
	 * Field ALPHA_SORTER_MNEMONIC. (value is ""s"")
	 */
	public static final String ALPHA_SORTER_MNEMONIC = "s";

	/**
	 * Field REVIEW_TYPE_SORTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.AlphaSort"")
	 */
	public static final String REVIEW_TYPE_SORTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.sorters.AlphaSort";

	/**
	 * Field REVIEW_TYPE_SORTER_ICON_FILE. (value is ""icons/elcl16/revtypesort_menu.gif"")
	 */
	public static final String REVIEW_TYPE_SORTER_ICON_FILE = "icons/elcl16/revtypesort_menu.gif";

	/**
	 * Field REVIEW_TYPE_SORTER_NAME. (value is ""Review Type"")
	 */
	public static final String REVIEW_TYPE_SORTER_NAME = "Review Type";

	/**
	 * Field REVIEW_TYPE_SORTER_TOOLTIP. (value is ""Sort Reviews by Review Type"")
	 */
	public static final String REVIEW_TYPE_SORTER_TOOLTIP = "Sort Reviews by Review Type";

	/**
	 * Field REVIEW_TYPE_SORTER_MNEMONIC. (value is ""t"")
	 */
	public static final String REVIEW_TYPE_SORTER_MNEMONIC = "t";

	/**
	 * Field ANOMALIES_MY_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.AnomaliesMy"")
	 */
	public static final String ANOMALIES_MY_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.AnomaliesMy";

	/**
	 * Field ANOMALIES_MY_FILTER_NAME. (value is ""Show My Anomalies"")
	 */
	public static final String ANOMALIES_MY_FILTER_NAME = "Show My Anomalies";

	/**
	 * Field ANOMALIES_MY_FILTER_TOOLTIP. (value is ""Show my Currently Assigned Anomalies"")
	 */
	public static final String ANOMALIES_MY_FILTER_TOOLTIP = "Show My Currently Assigned Anomalies";

	/**
	 * Field ANOMALIES_MY_REVIEW_FILTER_MNEMONIC. (value is ""z"")
	 */
	public static final String ANOMALIES_MY_FILTER_MNEMONIC = "z";

	/**
	 * Field REVIEWS_ONLY_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsOnly"")
	 */
	public static final String REVIEWS_ONLY_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsOnly";

	/**
	 * Field REVIEWS_ONLY_FILTER_NAME. (value is ""Show reviews only"")
	 */
	public static final String REVIEWS_ONLY_FILTER_NAME = "Show Reviews Only";

	/**
	 * Field REVIEWS_ONLY_FILTER_TOOLTIP. (value is ""Only show reviews"")
	 */
	public static final String REVIEWS_ONLY_FILTER_TOOLTIP = "Only Show Review Elements";

	/**
	 * Field REVIEWS_ONLY_FILTER_MNEMONIC. (value is ""o"")
	 */
	public static final String REVIEWS_ONLY_FILTER_MNEMONIC = "o";

	/**
	 * Field REVIEWS_MY_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsMy"")
	 */
	public static final String REVIEWS_MY_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsMy";

	/**
	 * Field REVIEWS_MY_FILTER_NAME. (value is ""Show my reviews"")
	 */
	public static final String REVIEWS_MY_FILTER_NAME = "Show My Reviews";

	/**
	 * Field REVIEWS_MY_FILTER_TOOLTIP. (value is ""Show reviews I am participating in"")
	 */
	public static final String REVIEWS_MY_FILTER_TOOLTIP = "Show Reviews I am Participating In";

	/**
	 * Field REVIEWS_MY_FILTER_MNEMONIC. (value is ""m"")
	 */
	public static final String REVIEWS_MY_FILTER_MNEMONIC = "m";

	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_COMMAND. (value is
	 * ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsParticipant"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewsParticipant";

	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_NAME. (value is ""Show reviews for participant... "")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_NAME = "Show Reviews for Participant... ";

	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_TOOLTIP. (value is ""Show reviews the given participant is participating in"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_TOOLTIP = "Show Reviews the Given Participant is Participating In";

	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_MNEMONIC. (value is ""p"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_MNEMONIC = "p";

	/**
	 * Field ANOMALIES_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.Anomalies"")
	 */
	public static final String ANOMALIES_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.Anomalies";

	/**
	 * Field ANOMALIES_FILTER_NAME. (value is ""Hide selections"")
	 */
	public static final String ANOMALIES_FILTER_NAME = "Show Anomalies Only";

	/**
	 * Field ANOMALIES_FILTER_TOOLTIP. (value is ""Hide selections and only show anomalies"")
	 */
	public static final String ANOMALIES_FILTER_TOOLTIP = "Hide Selections and Only Show Anomalies";

	/**
	 * Field ANOMALIES_FILTER_MNEMONIC. (value is ""a"")
	 */
	public static final String ANOMALIES_FILTER_MNEMONIC = "a";

	/**
	 * Field REVIEWED_ELEMS_FILTER_COMMAND. (value is
	 * ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewedElems"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.ReviewedElems";

	/**
	 * Field REVIEWED_ELEMS_FILTER_NAME. (value is ""Hide reviewed elements"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_NAME = "Hide Reviewed Elements";

	/**
	 * Field REVIEWED_ELEMS_FILTER_TOOLTIP. (value is ""Hide reviewed elements"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_TOOLTIP = "Hide Reviewed Elements";

	/**
	 * Field REVIEWED_ELEMS_FILTER_MNEMONIC. (value is ""e"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_MNEMONIC = "e";

	/**
	 * Field HIDE_RULE_SETS_FILTER_COMMAND. (value is
	 * ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.HideRuleSets"")
	 */
	public static final String HIDE_RULE_SETS_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.HideRuleSets";

	/**
	 * Field HIDE_RULE_SETS_FILTER_NAME. (value is ""Hide Rule Sets"")
	 */
	public static final String HIDE_RULE_SETS_FILTER_NAME = "Hide Rule Sets";

	/**
	 * Field HIDE_RULE_SETS_FILTER_TOOLTIP. (value is ""Hide Rule Sets"")
	 */
	public static final String HIDE_RULE_SETS_FILTER_TOOLTIP = "Hide Rule Sets";

	/**
	 * Field HIDE_RULE_SETS_FILTER_MNEMONIC. (value is ""n"")
	 */
	public static final String HIDE_RULE_SETS_FILTER_MNEMONIC = "n";

	/**
	 * Field SET_FOCUS_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.SetFocus"")
	 */
	public static final String SET_FOCUS_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.SetFocus";

	/**
	 * Field SET_FOCUS_FILTER_NAME. (value is ""Set Focus"")
	 */
	public static final String SET_FOCUS_FILTER_NAME = "Set Focus";

	/**
	 * Field SET_FOCUS_FILTER_TOOLTIP. (value is ""Set Focus on Current Element"")
	 */
	public static final String SET_FOCUS_FILTER_TOOLTIP = "Set Focus on Current Element";

	/**
	 * Field SET_FOCUS_FILTER_MNEMONIC. (value is ""f"")
	 */
	public static final String SET_FOCUS_FILTER_MNEMONIC = "f";

	/**
	 * Field REMOVE_ALL_FILTER_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.filters.RemoveAll"")
	 */
	public static final String REMOVE_ALL_FILTER_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.filters.RemoveAll";

	/**
	 * Field REMOVE_ALL_FILTER_NAME. (value is ""Remove all filters"")
	 */
	public static final String REMOVE_ALL_FILTER_NAME = "Remove All Filters";

	/**
	 * Field REMOVE_ALL_FILTER_TOOLTIP. (value is ""Remove all applied filters"")
	 */
	public static final String REMOVE_ALL_FILTER_TOOLTIP = "Remove All Applied Filters";

	/**
	 * Field REMOVE_ALL_FILTER_MNEMONIC. (value is ""r"")
	 */
	public static final String REMOVE_ALL_FILTER_MNEMONIC = "r";

	/**
	 * Field ADD_LINKED_ANOMALY_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.addLinkedAnomaly"")
	 */
	public static final String ADD_LINKED_ANOMALY_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.addLinkedAnomaly";

	/**
	 * Field ADD_LINKED_ANOMALY_NAME. (value is ""Add linked anomaly"")
	 */
	public static final String ADD_LINKED_ANOMALY_NAME = "Add Linked Anomaly";

	/**
	 * Field ADD_LINKED_ANOMALY_TOOLTIP. (value is ""Add a new anomaly that is linked to this selection"")
	 */
	public static final String ADD_LINKED_ANOMALY_TOOLTIP = "Add a New Anomaly that is Linked to this Selection";

	/**
	 * Field ADD_LINKED_ANOMALY_MNEMONIC. (value is ""l"")
	 */
	public static final String ADD_LINKED_ANOMALY_MNEMONIC = "l";

	/**
	 * Field OPEN_EDITOR_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.openEditor"")
	 */
	public static final String OPEN_EDITOR_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.openEditor";

	/**
	 * Field OPEN_EDITOR_ICON_FILE. (value is ""icons/elcl16/openfile_menu.gif"")
	 */
	public static final String OPEN_EDITOR_ICON_FILE = "icons/elcl16/openfile_menu.gif";

	/**
	 * Field OPEN_EDITOR_COMMAND_NAME. (value is ""Open file in editor"")
	 */
	public static final String OPEN_EDITOR_COMMAND_NAME = "Open File in Editor";

	/**
	 * Field OPEN_EDITOR_COMMAND_TOOLTIP. (value is ""Open the parent file with the matching editor and locate
	 * element"")
	 */
	public static final String OPEN_EDITOR_COMMAND_TOOLTIP = "Open the Parent File with the Matching Editor and Locate Element";

	/**
	 * Field OPEN_EDITOR_COMMAND_MNEMONIC. (value is ""e"")
	 */
	public static final String OPEN_EDITOR_COMMAND_MNEMONIC = "e";

	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.changeReviewState"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.changeReviewState";

	/**
	 * Field CHANGE_REVIEW_STATE_ICON_FILE. (value is ""icons/obj16/done_tsk.gif"")
	 */
	public static final String CHANGE_REVIEW_STATE_ICON_FILE = "icons/obj16/done_tsk.gif";

	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_NAME. (value is ""Mark/Unmark as User Reviewed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_NAME = "Mark/Unmark as User Reviewed";

	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_TOOLTIP. (value is ""Mark/Unmark this element as reviewed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_TOOLTIP = "Mark/Unmark this Element as Reviewed";

	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_MNEMONIC. (value is ""c"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_MNEMONIC = "c";

	/**
	 * Field OPEN_ELEMENT_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.openElement"")
	 */
	public static final String OPEN_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.openElement";

	/**
	 * Field OPEN_ELEMENT_ICON_FILE. (value is ""icons/obj16/open_tsk.gif"")
	 */
	public static final String OPEN_ELEMENT_ICON_FILE = "icons/obj16/open_tsk.gif";

	/**
	 * Field OPEN_ELEMENT_COMMAND_NAME. (value is ""Open element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_NAME = "Open Element";

	/**
	 * Field OPEN_ELEMENT_COMMAND_TOOLTIP. (value is ""Open and load data for this element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_TOOLTIP = "Open and Load Data for this Element";

	/**
	 * Field OPEN_ELEMENT_COMMAND_MNEMONIC. (value is ""o"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_MNEMONIC = "o";

	/**
	 * Field CLOSE_ELEMENT_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.closeElement"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.closeElement";

	/**
	 * Field CLOSE_ELEMENT_ICON_FILE. (value is ""icons/obj16/close_tsk.gif"")
	 */
	public static final String CLOSE_ELEMENT_ICON_FILE = "icons/obj16/close_tsk.gif";

	/**
	 * Field CLOSE_ELEMENT_COMMAND_NAME. (value is ""Close element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_NAME = "Close Element";

	/**
	 * Field CLOSE_ELEMENT_COMMAND_TOOLTIP. (value is ""Close and unload data for this element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_TOOLTIP = "Close and Unload Data for this Element";

	/**
	 * Field CLOSE_ELEMENT_COMMAND_MNEMONIC. (value is ""c"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_MNEMONIC = "c";

	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.addChildElement"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.addChildElement";

	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_NAME. (value is ""Add review group"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_NAME = "Add Child Element";

	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_TOOLTIP. (value is ""Add a new review group"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_TOOLTIP = "Add a New Child Element";

	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_MNEMONIC. (value is ""a"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_MNEMONIC = "a";

	/**
	 * Field REMOVE_ELEMENT_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.removeElement"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.removeElement";

	/**
	 * Field REMOVE_ELEMENT_COMMAND_NAME. (value is ""Remove element"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_NAME = "Disable Element";

	/**
	 * Field REMOVE_ELEMENT_COMMAND_TOOLTIP. (value is ""Remove this element"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_TOOLTIP = "Disable (and Optionally Remove) this Element";

	/**
	 * Field REMOVE_ELEMENT_COMMAND_MNEMONIC. (value is ""r"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_MNEMONIC = "x";

	/**
	 * Field RESTORE_ELEMENT_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.restoreElement"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.restoreElement";

	/**
	 * Field RESTORE_ELEMENT_COMMAND_NAME. (value is ""Restore element"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_NAME = "Restore Element";

	/**
	 * Field RESTORE_ELEMENT_COMMAND_TOOLTIP. (value is ""Restore this disabled element"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_TOOLTIP = "Restore this Disabled Element";

	/**
	 * Field RESTORE_ELEMENT_COMMAND_MNEMONIC. (value is ""r"")
	 */
	public static final String RESTORE_ELEMENT_COMMAND_MNEMONIC = "r";

	/**
	 * Field SEND_EMAIL_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.restoreElement"")
	 */
	public static final String SEND_EMAIL_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.sendNotification";

	/**
	 * Field SEND_EMAIL_ICON_FILE. (value is ""icons/view16/sendmail_tsk.gif"")
	 */
	public static final String SEND_EMAIL_ICON_FILE = "icons/view16/sendmail_tsk.gif";

	/**
	 * Field SEND_EMAIL_COMMAND_NAME. (value is ""Send Email/Notification"")
	 */
	public static final String SEND_EMAIL_COMMAND_NAME = "Send Email/Notification";

	/**
	 * Field SEND_EMAIL_COMMAND_TOOLTIP. (value is ""Restore this disabled element"")
	 */
	public static final String SEND_EMAIL_COMMAND_TOOLTIP = "Send Email or Notification";

	/**
	 * Field SEND_EMAIL_COMMAND_MNEMONIC. (value is ""r"")
	 */
	public static final String SEND_EMAIL_COMMAND_MNEMONIC = "N";

	/**
	 * Field ADD_REVIEW_ITEM_COMMAND. (value is ""org.eclipse.mylyn.reviews.r4e.ui.commands.AddReviewItem"")
	 */
	public static final String ADD_REVIEW_ITEM_COMMAND = "org.eclipse.mylyn.reviews.r4e.ui.commands.AddReviewItem";

	/**
	 * Field START_STRING_INDEX. (value is 0)
	 */
	public static final int START_STRING_INDEX = 0;

	/**
	 * Field END_STRING_NAME_INDEX. (value is 10)
	 */
	public static final int END_STRING_NAME_INDEX = 10;

	//Tooltips for dialogs and property views

	public static final String ANOMALY_TITLE_TOOLTIP = "A Title that Identifies this Anomaly";

	public static final String ANOMALY_DESCRIPTION_TOOLTIP = "A Detailed Description of the Anomaly";

	public static final String ANOMALY_AUTHOR_TOOLTIP = "The Id of the Participant that created this Anomaly";

	public static final String ANOMALY_CREATION_DATE_TOOLTIP = "The Creation Date for this Anomaly";

	public static final String ANOMALY_POSITION_TOOLTIP = "The Position in the Parent File of the Contents for this Anomaly";

	public static final String ANOMALY_STATE_TOOLTIP = "The Current State of the Anomaly";

	public static final String ANOMALY_CLASS_TOOLTIP = "The Class of this Anomaly";

	public static final String ANOMALY_RANK_TOOLTIP = "The Rank (or Severity) of this Anomaly";

	public static final String ANOMALY_RULE_ID_TOOLTIP = "An Identifier for the Design Rule Violation reported by this Anomaly";

	public static final String ANOMALY_DUE_DATE_TOOLTIP = "The Target Date to Address this Anomaly";

	public static final String ANOMALY_DECIDED_BY_TOOLTIP = "The Participant that Analyzed this reported Anomaly";

	public static final String ANOMALY_FIXED_BY_TOOLTIP = "The Participant that Fixed the Issue Reported in this Anomaly";

	public static final String ANOMALY_FOLLOWUP_BY_TOOLTIP = "The Participant that Verified the Fix for the Issue Reported in this Anomaly";

	public static final String ANOMALY_NOT_ACCEPTED_REASON_TOOLTIP = "The Reason why this Anomaly is Rejected";

	public static final String COMMENT_DESCRIPTION_TOOLTIP = "The Comment Description";

	public static final String COMMENT_AUTHOR_TOOLTIP = "The Participant that Adds this Comment";

	public static final String COMMENT_CREATION_DATE_TOOLTIP = "The Creation Time of this Comment";

	public static final String FILECONTEXT_BASE_FILE_NAME_TOOLTIP = "The base (or Reference File) Name for the File to Review";

	public static final String FILECONTEXT_BASE_FILE_PATH_TOOLTIP = "The base (or Reference File) Path for the File to Review";

	public static final String FILECONTEXT_BASE_FILE_VERSION_TOOLTIP = "The base (or Reference File) Version for the File to Review";

	public static final String FILECONTEXT_TARGET_FILE_NAME_TOOLTIP = "The target (or current File) Name for the File to Review";

	public static final String FILECONTEXT_TARGET_FILE_PATH_TOOLTIP = "The target (or current File) Path for the File to Review";

	public static final String FILECONTEXT_TARGET_FILE_VERSION_TOOLTIP = "The target (or current File) Version for the File to Review";

	public static final String PARTICIPANT_ID_TOOLTIP = "A Tag that Identifies this Participant";

	public static final String PARTICIPANT_FIND_USER_TOOLTIP = "Search for Users...";

	public static final String PARTICIPANT_EMAIL_TOOLTIP = "The Email Address for the Participant";

	public static final String PARTICIPANT_DETAILS_TOOLTIP = "Extra Information about this Participant";

	public static final String PARTICIPANT_ROLES_TOOLTIP = "The Roles this Participant holds for the Current Review.  "
			+ "Roles are used to Manage the Actions the Participant can do";

	public static final String PARTICIPANT_FOCUS_AREA_TOOLTIP = "The Focus Area for this Participant.  "
			+ "A Focus Area is Defined by Specific Aspects of the Review this Participant should Focus his Attention to";

	public static final String PARTICIPANT_NUM_ITEMS_TOOLTIP = "Number of Review Items added by this Participant";

	public static final String PARTICIPANT_NUM_ANOMALIES_TOOLTIP = "Number of Anomlaies added by this Participant";

	public static final String PARTICIPANT_NUM_COMMENTS_TOOLTIP = "Number of Comments (other than Anomalies) added by this Participant";

	public static final String PARTICIPANT_TIME_SPENT_TOOLTIP = "The time the Participant spent working on this Review";

	public static final String REVIEW_GROUP_NAME_TOOLTIP = "The Name that Identifies the Review Group";

	public static final String REVIEW_GROUP_FOLDER_TOOLTIP = "Browse Folders...";

	public static final String REVIEW_GROUP_FILE_PATH_TOOLTIP = "The Location (Folder) where the Review Group Information is Stored.  "
			+ "Review Group Information is stored in files that have a _group_root.xrer suffix";

	public static final String REVIEW_GROUP_DESCRIPTION_TOOLTIP = "A Brief Description of ths REview Group";

	public static final String REVIEW_GROUP_PROJECTS_TOOLTIP = "The Projects that are available for Review in this Review Group.  "
			+ "Take Note that these Project can have Arbitrary Names, not only Eclipse Project Names";

	public static final String REVIEW_GROUP_COMPONENTS_TOOLTIP = "The Components (Subsystems, Sub-Projects etc.) that are available for Review in this Review Group.  "
			+ "These can have Arbitrary Names";

	public static final String REVIEW_GROUP_ENTRY_CRITERIA_TOOLTIP = "The Entry Criteria that will be used for all Reviews created under this Review Group";

	public static final String REVIEW_GROUP_RULESET_REFERENCE_TOOLTIP = "The Location of the RuleSet definition Files that can be used for Reviews created under this Review Group";

	public static final String REVIEW_TYPE_TOOLTIP = "The type of the Review:  "
			+ "Basic Reviews are the Simplest and most Flexible ones.  "
			+ "Informal Reviews introduces State Tracking for Anomalies.  "
			+ "Formal Reviews are Structured Reviews that Conforms to the IEEE standard 1028";

	public static final String REVIEW_NAME_TOOLTIP = "A Name that Identifies this Review";

	public static final String REVIEW_DESCRIPTION_TOOLTIP = "A Description of the Review";

	public static final String REVIEW_PROJECT_TOOLTIP = "The Project the Reviewed Code belongs to";

	public static final String REVIEW_COMPONENTS_TOOLTIP = "The Components for the Elements being Reviewed";

	public static final String REVIEW_ENTRY_CRITERIA_TOOLTIP = "The Entry Criteria for this Review.  "
			+ "This is automatically set to the Parent Review Group Default Value";

	public static final String REVIEW_OBJECTIVES_TOOLTIP = "The Objectives of this Review";

	public static final String REVIEW_REFERENCE_MATERIAL_TOOLTIP = "The Reference Materials to be used for This Review";

	public static final String REVIEW_PHASE_TOOLTIP = "The Current Review Phase.  "
			+ "Review Phases are used mainly for Formal Reviews";

	public static final String REVIEW_START_DATE_TOOLTIP = "The Start Date for this Review";

	public static final String REVIEW_END_DATE_TOOLTIP = "The Closing Date for this Review";

	public static final String REVIEW_PHASE_TABLE_TOOLTIP = "The Review Phase Map that show the Review Progression";

	public static final String REVIEW_PHASE_OWNER_TOOLTIP = "The Owner of the Review Phase.  "
			+ "Only the Owner can Change the Current Review Phase";

	public static final String REVIEW_MEETING_TOOLTIP = "The Review Decision Meeting Details, as sent in the Meeting Request Email";

	public static final String REVIEW_MEETING_SUBJECT_TOOLTIP = "The Review Decision Meeting Subject, as sent in the Meeting Request Email";

	public static final String REVIEW_MEETING_UPDATE_TOOLTIP = "Update Meeting Details and re-send the New Meeting Request Email";

	public static final String REVIEW_MEETING_TIME_TOOLTIP = "The Review Decision Meeting Time, as sent in the Meeting Request Email";

	public static final String REVIEW_MEETING_DURATION_TOOLTIP = "The Review Decision Meeting Duration, as sent in the Meeting Request Email";

	public static final String REVIEW_MEETING_LOCATION_TOOLTIP = "The Review Decision Meeting Location, as sent in the Meeting Request Email";

	public static final String REVIEW_EXIT_DECISION_TOOLTIP = "The Exit Decision for this Review";

	public static final String REVIEW_EXIT_DECISION_PARTICIPANTS_TOOLTIP = "The Participants that were part of the Exit Decision";

	public static final String REVIEW_EXIT_DECISION_TIME_SPENT_TOOLTIP = "The Time Spent for the Review Exit Decision";

	public static final String REVIEW_ITEM_AUTHOR_TOOLTIP = "The Participant that Adds this Review Item";

	public static final String REVIEW_ITEM_PROJECT_IDS_TOOLTIP = "The Projects the Children Files of this Review Items belong to";

	public static final String REVIEW_ITEM_DESCRIPTION_TOOLTIP = "A Brief Dexcription of this Review Item.  "
			+ "This can be entered by the User or it could be coming from the Version Control System";

	public static final String RULE_AREA_NAME_TOOLTIP = "The Area covered by the Children Design Rules (e.g. Java, C++ or any arbitrary division)";

	public static final String RULE_ID_TOOLTIP = "An Tag that Identifies this Design Rule";

	public static final String RULE_TITLE_TOOLTIP = "The Design Rule Title";

	public static final String RULE_DESCRIPTION_TOOLTIP = "A Description of the Design Rule";

	public static final String RULE_CLASS_TOOLTIP = "The Class for this Design Rule.  "
			+ "It will be automatically set in Anomalies that refers to this Rule";

	public static final String RULE_RANK_TOOLTIP = "The Rank (or Severity) for this Design Rule.  "
			+ "It will be automatically set in Anomalies that refers to this Rule";

	public static final String RULESET_VERSION_TOOLTIP = "The Version for this Rule Set";

	public static final String RULESET_NAME_TOOLTIP = "A Name that Identifies this Rule Set."
			+ "A Rule Set is a Collection of Related Design Rules bundled together";

	public static final String RULESET_FOLDER_TOOLTIP = "Browse Folders...";

	public static final String RULESET_FILE_PATH_TOOLTIP = "The Location (Folder) where the Rule Set Information is Stored.  "
			+ "Rule Set Information is stored in files that have a _rule_set.xrer suffix";

	public static final String RULE_VIOLATION_NAME_TOOLTIP = "The Violation Highlighted by the Children Design Rules";

	public static final String SELECTION_POSITION_TOOLTIP = "The Position in the Parent File of the Selected Contents";

	public static final String USER_ID_TOOLTIP = "A Tag that Identifies this User";

	public static final String USER_NAME_TOOLTIP = "The Actual Name of this User";

	public static final String USER_OFFICE_TOOLTIP = "The location of this User";

	public static final String USER_COMPANY_TOOLTIP = "The Organization this User is Part of";

	public static final String USER_DEPARTMENT_TOOLTIP = "The Department this User is Part of";

	public static final String USER_CITY_TOOLTIP = "The City where the User's Organization is located";

	public static final String USER_COUNTRY_TOOLTIP = "The Country where the User's Organization is located";

	public static final String USER_SEARCH_TOOLTIP = "Search for Users matching the Criteria(s)";

	public static final String USER_CLEAR_TOOLTIP = "Clear Serach Results";

	public static final String USER_NUM_ENTRIES_TOOLTIP = "Number of Matches Found";

	public static final String NOTIFICATION_COMPLETION_TOOLTIP = "Send an Automatic Email to Report that we are done reviewing the Utems for the Current Review";

	public static final String NOTIFICATION_ITEMS_UPDATED_TOOLTIP = "Send an Automatic Email to Report Modifications to the Items to Review for the Current Review";

	public static final String NOTIFICATION_PROGRESS_TOOLTIP = "Send an Automatic Email to Report about our Progress Reviewing the Items for the Current Review";

	public static final String NOTIFICATION_QUESTION_TOOLTIP = "Send an Automatic Email to ask a Question about the Selected Element or Text";
}
