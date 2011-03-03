package org.eclipse.mylyn.reviews.r4e.ui.properties.tabbed;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EParticipant;
import org.eclipse.mylyn.reviews.r4e.core.model.R4EUserRole;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.OutOfSyncException;
import org.eclipse.mylyn.reviews.r4e.core.model.serial.impl.ResourceHandlingException;
import org.eclipse.mylyn.reviews.r4e.ui.Activator;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIModelController;
import org.eclipse.mylyn.reviews.r4e.ui.model.R4EUIParticipant;
import org.eclipse.mylyn.reviews.r4e.ui.utils.EditableListWidget;
import org.eclipse.mylyn.reviews.r4e.ui.utils.IEditableListListener;
import org.eclipse.mylyn.reviews.r4e.ui.utils.R4EUIConstants;
import org.eclipse.mylyn.reviews.r4e.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class ParticipantExtraTabPropertySection extends ModelElementTabPropertySection implements IEditableListListener {

	// ------------------------------------------------------------------------
	// Member variables
	// ------------------------------------------------------------------------
	
	/**
	 * Field fAvailableComponents.
	 */
	protected EditableListWidget fTimeSpentDetailedList = null;
	
	/**
	 * Field FTimeSpentTotalText.
	 */
	private Text fTimeSpentTotalText = null;
	
	/**
	 * Field FFocusArea.
	 */
	private List fRolesList = null;
	
	/**
	 * Field FFocusArea.
	 */
	private Text fFocusAreaText = null;
	
	
	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	
	/**
	 * Method createControls.
	 * @param parent Composite
	 * @param aTabbedPropertySheetPage TabbedPropertySheetPage
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(Composite, TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final TabbedPropertySheetWidgetFactory widgetFactory = aTabbedPropertySheetPage.getWidgetFactory();
	    FormData data = null;
	    Composite mainForm = widgetFactory.createFlatFormComposite(parent);
	    
	    //Time Spent (detailed)
		data = new FormData();
		data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
		data.top = new FormAttachment(mainForm, ITabbedPropertyConstants.VSPACE);
		fTimeSpentDetailedList = new EditableListWidget(widgetFactory, mainForm, data, this, 1, Date.class, null);

	    final CLabel timeSpentDetailedLabel = widgetFactory.createCLabel(mainForm, R4EUIConstants.TIME_SPENT_DETAILED_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fTimeSpentDetailedList.getComposite(), -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fTimeSpentDetailedList.getComposite(), 0, SWT.CENTER);
	    timeSpentDetailedLabel.setLayoutData(data);
	    
	    //Time Spent (total - read only)
	    fTimeSpentTotalText = widgetFactory.createText(mainForm, "", SWT.READ_ONLY);	
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fTimeSpentDetailedList.getComposite(), ITabbedPropertyConstants.VSPACE);
	    fTimeSpentTotalText.setLayoutData(data);
	    
	    final CLabel timeSpentLabel = widgetFactory.createCLabel(mainForm, R4EUIConstants.TIME_SPENT_TOTAL_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fTimeSpentTotalText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fTimeSpentTotalText, 0, SWT.CENTER);
	    timeSpentLabel.setLayoutData(data);
	    
	    //Roles
	    fRolesList = widgetFactory.createList(mainForm, SWT.READ_ONLY);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fTimeSpentTotalText, ITabbedPropertyConstants.VSPACE);
	    fRolesList.setLayoutData(data);

	    final CLabel rolesLabel = widgetFactory.createCLabel(mainForm, R4EUIConstants.ROLES_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fRolesList, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fRolesList, 0, SWT.CENTER);
	    rolesLabel.setLayoutData(data);
	    
	    //Focus Area (read-only)
	    fFocusAreaText = widgetFactory.createText(mainForm, "", SWT.READ_ONLY);
	    data = new FormData();
	    data.left = new FormAttachment(0, R4EUIConstants.TABBED_PROPERTY_LABEL_WIDTH);
	    data.right = new FormAttachment(100, 0); // $codepro.audit.disable numericLiterals
	    data.top = new FormAttachment(fRolesList, ITabbedPropertyConstants.VSPACE);
	    fFocusAreaText.setLayoutData(data);

	    final CLabel focusAreaLabel = widgetFactory.createCLabel(mainForm, R4EUIConstants.FOCUS_AREA_LABEL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(fFocusAreaText, -ITabbedPropertyConstants.HSPACE);
	    data.top = new FormAttachment(fFocusAreaText, 0, SWT.CENTER);
	    focusAreaLabel.setLayoutData(data);
	}
	
	/**
	 * Method refresh.
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	@Override
	public void refresh() {
		fRefreshInProgress = true;
		final R4EParticipant modelUser = ((R4EUIParticipant)fProperties.getElement()).getParticipant();
		int numTimeEntries = modelUser.getTimeLog().size();
		fTimeSpentDetailedList.clearAll();
		int totalTimeSpent = 0;
		for (int i = 0; i < numTimeEntries; i++) {
			Entry<Date, Integer> timeEntry = modelUser.getTimeLog().get(i);
			Item item;
			if (i >= fTimeSpentDetailedList.getItemCount()) {
				item = fTimeSpentDetailedList.addItem(); 
			} else {
				item = fTimeSpentDetailedList.getItem(i);
				if (null == item) item = fTimeSpentDetailedList.addItem(); 
			}
			String[] data = { timeEntry.getValue().toString(), timeEntry.getKey().toString() };
			((TableItem)item).setText(data);
			totalTimeSpent +=timeEntry.getValue().intValue();
		}
		fTimeSpentTotalText.setText(Integer.toString(totalTimeSpent));
		
		EList<R4EUserRole> roles = modelUser.getRoles();
		for (R4EUserRole role : roles) {
	    	//Review type (no validation needed as this is a read-only combo box
			if (role.getValue() == R4EUserRole.R4E_ROLE_LEAD_VALUE) fRolesList.add(R4EUIConstants.USER_ROLE_LEAD);
			else if (role.getValue() == R4EUserRole.R4E_ROLE_AUTHOR_VALUE) fRolesList.add(R4EUIConstants.USER_ROLE_AUTHOR);
			else if (role.getValue() == R4EUserRole.R4E_ROLE_REVIEWER_VALUE) fRolesList.add(R4EUIConstants.USER_ROLE_REVIEWER);
		}
		if (null != modelUser.getFocusArea()) fFocusAreaText.setText(modelUser.getFocusArea());
		setEnabledFields();
		fRefreshInProgress = false;
	}
	
	/**
	 * Method setEnabledFields.
	 */
	@Override
	protected void setEnabledFields() {
		if (R4EUIModelController.isDialogOpen()) {
			fTimeSpentDetailedList.setEnabled(false);
			fTimeSpentTotalText.setEnabled(false);
			fRolesList.setEnabled(false);
			fFocusAreaText.setEnabled(false);
		} else {
			fTimeSpentDetailedList.setEnabled(true);
			fTimeSpentTotalText.setEnabled(true);
			fRolesList.setEnabled(true);
			fFocusAreaText.setEnabled(true);
		}
	}

	public void itemsUpdated(Item[] aItems, int aInstanceId) {		
		try {
			final R4EParticipant modelGroup = ((R4EUIParticipant)fProperties.getElement()).getParticipant();
			final String currentUser = R4EUIModelController.getReviewer();
			final Long bookNum = R4EUIModelController.FResourceUpdater.checkOut(modelGroup, currentUser);
			EMap<Date, Integer> timeMap = modelGroup.getTimeLog();
			DateFormat format = DateFormat.getDateInstance();
			for (Item item : aItems) {
				try {
					timeMap.put(format.parse(((TableItem)item).getText(1)), 
									Integer.valueOf(((TableItem)item).getText(0)));
				} catch (NumberFormatException e) {
					//skip this entry
					Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
					Activator.getDefault().logWarning("Exception: " + e.toString(), e);
					continue;
				} catch (ParseException e) {
					//skip this entry
					Activator.Ftracer.traceWarning("Exception: " + e.toString() + " (" + e.getMessage() + ")");
					Activator.getDefault().logWarning("Exception: " + e.toString(), e);
					continue;
				}
			}
			R4EUIModelController.FResourceUpdater.checkIn(bookNum);
		} catch (ResourceHandlingException e1) {
			UIUtils.displayResourceErrorDialog(e1);
		} catch (OutOfSyncException e1) {
			UIUtils.displaySyncErrorDialog(e1);
		}
	}
}
