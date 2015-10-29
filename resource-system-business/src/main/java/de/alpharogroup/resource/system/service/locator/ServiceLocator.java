package de.alpharogroup.resource.system.service.locator;

import de.alpharogroup.resource.system.service.api.ResourcesService;

public interface ServiceLocator {

	/**
	 * Gets the resources service.
	 * 
	 * @return the resources service
	 */
	ResourcesService getResourcesService();

	/**
	 * Sets the ResourcesService.
	 * 
	 * @param resourcesService
	 *            the new ResourcesService
	 */
	void setResourcesService(ResourcesService resourcesService);

}
