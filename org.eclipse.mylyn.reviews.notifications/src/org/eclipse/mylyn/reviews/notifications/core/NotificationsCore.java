/**
 * Copyright (c) 2011 Ericsson and others.
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ericsson Research Canada - Initial API and implementation
 * 
 */
package org.eclipse.mylyn.reviews.notifications.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.commons.core.StatusHandler;
import org.eclipse.mylyn.reviews.notifications.spi.NotificationsConnector;
import org.eclipse.osgi.util.NLS;

/**
 * @author Alvaro Sanchez-Leon
 * 
 */
public class NotificationsCore {
	// ------------------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------------------
	public static final String	PLUGIN_ID	= "org.eclipse.mylyn.reviews.notifications";	//$NON-NLS-1$

	// ------------------------------------------------------------------------
	// Methods
	// ------------------------------------------------------------------------
	/**
	 * @return
	 */
	public static List<String> getConnectorIds() {
		List<String> connectorIds = new ArrayList<String>();

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint connectorsExtensionPoint = registry.getExtensionPoint(PLUGIN_ID + ".connectors"); //$NON-NLS-1$
		IExtension[] extensions = connectorsExtensionPoint.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				connectorIds.add(element.getAttribute("id"));
			}
		}

		return connectorIds;
	}

	/**
	 * Get the first connector with status Enabled attempting the ids in the order of appearance within the provided
	 * array
	 * 
	 * @param ids
	 * @return
	 */
	public static NotificationsConnector getFirstEnabled(String[] ids) {
		Assert.isNotNull(ids);
		MultiStatus result = new MultiStatus(PLUGIN_ID, 0, "Notifications connectors failed to load.", null); //$NON-NLS-1$

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint connectorsExtensionPoint = registry.getExtensionPoint(PLUGIN_ID + ".connectors"); //$NON-NLS-1$
		IExtension[] extensions = connectorsExtensionPoint.getExtensions();

		Map<String, IConfigurationElement> configElements = new HashMap<String, IConfigurationElement>();

		// Build a map of ids
		for (IExtension extension : extensions) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				configElements.put(element.getAttribute("id"), element);
			}
		}

		// scan for the id in the order provided by the array
		IConfigurationElement dConfigElement = null;
		for (int i = 0; i < ids.length; i++) {
			dConfigElement = configElements.get(ids[i]);
			if (dConfigElement != null) {
				// make sure it's enabled
				NotificationsConnector connector = loadElement(dConfigElement, result);
				if (connector != null && connector.isEnabled()) {
					return connector;
				}
			}
		}

		if (!result.isOK()) {
			StatusHandler.log(result);
		}

		return null;
	}

	private static NotificationsConnector loadElement(IConfigurationElement aElement, MultiStatus aStatus) {
		try {
			Object object = aElement.createExecutableExtension("core"); //$NON-NLS-1$
			if (object instanceof NotificationsConnector) {
				// success
				return (NotificationsConnector) object;
			} else {
				aStatus.add(new Status(
						IStatus.ERROR,
						PLUGIN_ID,
						NLS.bind(
								"Notifications Connector core ''{0}'' does not extend expected class for extension contributed by {1}", //$NON-NLS-1$
								object.getClass().getCanonicalName(), aElement.getContributor().getName())));
			}
		} catch (Throwable e) {
			aStatus.add(new Status(
					IStatus.ERROR,
					PLUGIN_ID,
					NLS.bind(
							"Notifications Connector core failed to load for extension contributed by {0}", aElement.getContributor().getName()), e)); //$NON-NLS-1$
		}

		return null;
	}

	/**
	 * Search for a connector with given id, return it if found
	 * 
	 * @param id
	 * @return
	 */
	public static NotificationsConnector loadConnector(String id) {
		Assert.isNotNull(id);
		MultiStatus result = new MultiStatus(PLUGIN_ID, 0, "Notifications connectors failed to load.", null); //$NON-NLS-1$

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint connectorsExtensionPoint = registry.getExtensionPoint(PLUGIN_ID + ".connectors"); //$NON-NLS-1$
		IExtension[] extensions = connectorsExtensionPoint.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				if (id.equals(element.getAttribute("id"))) { //$NON-NLS-1$
					try {
						Object object = element.createExecutableExtension("core"); //$NON-NLS-1$
						if (object instanceof NotificationsConnector) {
							return (NotificationsConnector) object;
						} else {
							result.add(new Status(
									IStatus.ERROR,
									PLUGIN_ID,
									NLS.bind(
											"Notifications Connector core ''{0}'' does not extend expected class for extension contributed by {1}", //$NON-NLS-1$
											object.getClass().getCanonicalName(), element.getContributor().getName())));
						}
					} catch (Throwable e) {
						result.add(new Status(
								IStatus.ERROR,
								PLUGIN_ID,
								NLS.bind(
										"Notifications Connector core failed to load for extension contributed by {0}", element.getContributor().getName()), e)); //$NON-NLS-1$
					}
				}
			}
		}

		if (!result.isOK()) {
			StatusHandler.log(result);
		}

		return null;
	}
}
