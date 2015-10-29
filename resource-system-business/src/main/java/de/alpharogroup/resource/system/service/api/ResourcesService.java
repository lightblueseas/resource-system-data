package de.alpharogroup.resource.system.service.api;

import java.util.List;

import de.alpharogroup.db.service.jpa.BusinessService;
import de.alpharogroup.resource.system.entities.Resources;

public interface ResourcesService extends BusinessService<Resources, Integer> {
	Resources findByName(String filename);
	
	Resources findByDescription(String description);

	List<Resources> find(String description, String filename, String filesize,
			String contentType);

	Resources getManPlaceholder();

	Resources getWomanPlaceholder();
	
	Resources getDefaultPlaceholder();
}