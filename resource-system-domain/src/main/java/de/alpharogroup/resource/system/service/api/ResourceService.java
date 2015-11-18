package de.alpharogroup.resource.system.service.api;

import java.util.List;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.service.domain.DomainService;

/**
 * The interface {@link ResourceService}.
 */
public interface ResourceService extends DomainService<Integer, Resource> {
	
	/**
	 * Finds the {@link Resource} object by filename.
	 *
	 * @param filename the filename
	 * @return the resource
	 */
	Resource findByName(String filename);
	
	/**
	 * Finds the {@link Resource} object by description.
	 *
	 * @param description the description
	 * @return the resource
	 */
	Resource findByDescription(String description);

	/**
	 * Finds a list of {@link Resource} objects from the given arguments.
	 *
	 * @param description the description
	 * @param filename the filename
	 * @param filesize the filesize
	 * @param contentType the content type
	 * @return the list of {@link Resource} objects
	 */
	List<Resource> find(String description, String filename, String filesize,
			String contentType);

	/**
	 * Gets the man placeholder.
	 *
	 * @return the man placeholder
	 */
	Resource getManPlaceholder();

	/**
	 * Gets the woman placeholder.
	 *
	 * @return the woman placeholder
	 */
	Resource getWomanPlaceholder();
	
	/**
	 * Gets the default placeholder.
	 *
	 * @return the default placeholder
	 */
	Resource getDefaultPlaceholder();
}
