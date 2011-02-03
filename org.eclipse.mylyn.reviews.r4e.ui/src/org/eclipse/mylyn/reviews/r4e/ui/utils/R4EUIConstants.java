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
	 * (value is ""icons/groups.gif"")
	 */
	public static final String REVIEW_GROUP_ICON_FILE = "icons/groups.gif";
	

	//Properties
	
	/**
	 * Field TABBED_PROPERTY_LABEL_WIDTH.
	 * (value is 105)
	 */
	public static final int TABBED_PROPERTY_LABEL_WIDTH = 135;
	
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
	 * Field CREATION_DATE_LABEL.
	 * (value is ""Creation date: "")
	 */
	public static final String CREATION_DATE_LABEL = "Creation date: ";
	
	/**
	 * Field AUTHOR_LABEL.
	 * (value is ""Added by: "")
	 */
	public static final String AUTHOR_LABEL = "Added by: ";
	
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
	public static final String NO_VERSION_PROPERTY_MESSAGE = "(Not present)";
	
	/**
	 * Field PROJECT_ID_LABEL.
	 * (value is ""Project Id: "")
	 */
	public static final String PROJECT_ID_LABEL = "Project Id: ";
	
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
	public static final String GLOBAL_ANOMALY_PROPERTY_VALUE = "(Global review anomaly)";
	
	/**
	 * Field FILE_NOT_IN_VERSION_CONTROL_MSG.
	 * (value is ""(Not version controlled)"")
	 */
	public static final String FILE_NOT_IN_VERSION_CONTROL_MSG = "(Not version controlled)";
	
	
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
	 * (value is ""icons/alpha_sort.gif"")
	 */
	public static final String ALPHA_SORTER_ICON_FILE = "icons/alpha_sort.gif";
	
	/**
	 * Field ALPHA_SORTER_NAME.
	 * (value is ""Element name"")
	 */
	public static final String ALPHA_SORTER_NAME = "Element name";
	
	/**
	 * Field ALPHA_SORTER_TOOLTIP.
	 * (value is ""Sort alphabetically"")
	 */
	public static final String ALPHA_SORTER_TOOLTIP = "Sort alphabetically";
	
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
	public static final String CURRENT_REVIEW_FILTER_NAME = "Show current review";
	
	/**
	 * Field CURRENT_REVIEW_FILTER_TOOLTIP.
	 * (value is ""Only show the currently open review"")
	 */
	public static final String CURRENT_REVIEW_FILTER_TOOLTIP = "Only show the currently open review";
	
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
	public static final String REVIEWS_ONLY_FILTER_NAME = "Show reviews only";
	
	/**
	 * Field REVIEWS_ONLY_FILTER_TOOLTIP.
	 * (value is ""Only show reviews"")
	 */
	public static final String REVIEWS_ONLY_FILTER_TOOLTIP = "Only show reviews";
	
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
	public static final String REVIEWS_MY_FILTER_NAME = "Show my reviews";
	
	/**
	 * Field REVIEWS_MY_FILTER_TOOLTIP.
	 * (value is ""Show reviews I am participating in"")
	 */
	public static final String REVIEWS_MY_FILTER_TOOLTIP = "Show reviews I am participating in";
	
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
	public static final String REVIEWS_PARTICIPANT_FILTER_NAME = "Show reviews for participant... ";
	
	/**
	 * Field REVIEWS_PARTICIPANT_FILTER_TOOLTIP.
	 * (value is ""Show reviews the given participant is participating in"")
	 */
	public static final String REVIEWS_PARTICIPANT_FILTER_TOOLTIP = "Show reviews the given participant is participating in";
	
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
	public static final String ANOMALIES_FILTER_NAME = "Hide selections";
	
	/**
	 * Field ANOMALIES_FILTER_TOOLTIP.
	 * (value is ""Hide selections and only show anomalies"")
	 */
	public static final String ANOMALIES_FILTER_TOOLTIP = "Hide selections and only show anomalies";
	
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
	public static final String REVIEWED_ELEMS_FILTER_NAME = "Hide reviewed elements";
	
	/**
	 * Field REVIEWED_ELEMS_FILTER_TOOLTIP.
	 * (value is ""Hide reviewed elements"")
	 */
	public static final String REVIEWED_ELEMS_FILTER_TOOLTIP = "Hide reviewed elements";
	
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
	public static final String REMOVE_ALL_FILTER_NAME = "Remove all filters";
	
	/**
	 * Field REMOVE_ALL_FILTER_TOOLTIP.
	 * (value is ""Remove all applied filters"")
	 */
	public static final String REMOVE_ALL_FILTER_TOOLTIP = "Remove all applied filters";
	
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
	public static final String ADD_LINKED_ANOMALY_NAME = "Add linked anomaly";
	
	/**
	 * Field ADD_LINKED_ANOMALY_TOOLTIP.
	 * (value is ""Add a new anomaly that is linked to this selection"")
	 */
	public static final String ADD_LINKED_ANOMALY_TOOLTIP = "Add a new anomaly that is linked to this selection";
	
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
	 * (value is ""icons/open_file.gif"")
	 */
	public static final String OPEN_EDITOR_ICON_FILE = "icons/open_file.gif";
	
	/**
	 * Field OPEN_EDITOR_COMMAND_NAME.
	 * (value is ""Open file in editor"")
	 */
	public static final String OPEN_EDITOR_COMMAND_NAME = "Open file in editor";
	
	/**
	 * Field OPEN_EDITOR_COMMAND_TOOLTIP.
	 * (value is ""Open the parent file with the matching editor and locate element"")
	 */
	public static final String OPEN_EDITOR_COMMAND_TOOLTIP = "Open the parent file with the matching editor and locate element";
	
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
	 * (value is ""icons/done.gif"")
	 */
	public static final String CHANGE_REVIEW_STATE_ICON_FILE = "icons/done.gif";
	
	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_NAME.
	 * (value is ""Mark/Unmark as completed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_NAME = "Mark/Unmark as completed";
	
	/**
	 * Field CHANGE_REVIEW_STATE_COMMAND_TOOLTIP.
	 * (value is ""Mark/Unmark this element as reviewed"")
	 */
	public static final String CHANGE_REVIEW_STATE_COMMAND_TOOLTIP = "Mark/Unmark this element as reviewed";
	
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
	 * (value is ""icons/open.gif"")
	 */
	public static final String OPEN_ELEMENT_ICON_FILE = "icons/open.gif";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND_NAME.
	 * (value is ""Open element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_NAME = "Open element";
	
	/**
	 * Field OPEN_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Open and load data for this element"")
	 */
	public static final String OPEN_ELEMENT_COMMAND_TOOLTIP = "Open and load data for this element";
	
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
	 * (value is ""icons/close.gif"")
	 */
	public static final String CLOSE_ELEMENT_ICON_FILE = "icons/close.gif";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND_NAME.
	 * (value is ""Close element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_NAME = "Close element";
	
	/**
	 * Field CLOSE_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Close and unload data for this element"")
	 */
	public static final String CLOSE_ELEMENT_COMMAND_TOOLTIP = "Close and unload data for this element";
	
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
	public static final String ADD_CHILD_ELEMENT_COMMAND_NAME = "Add review group";
	
	/**
	 * Field ADD_CHILD_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Add a new review group"")
	 */
	public static final String ADD_CHILD_ELEMENT_COMMAND_TOOLTIP = "Add a new review group";
	
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
	public static final String REMOVE_ELEMENT_COMMAND_NAME = "Remove element";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND_TOOLTIP.
	 * (value is ""Remove this element"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_TOOLTIP = "Remove this element";
	
	/**
	 * Field REMOVE_ELEMENT_COMMAND_MNEMONIC.
	 * (value is ""r"")
	 */
	public static final String REMOVE_ELEMENT_COMMAND_MNEMONIC = "r";
}
