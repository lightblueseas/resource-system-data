package de.alpharogroup.resource.system.application.util;

import java.util.ArrayList;
import java.util.List;

import de.alpharogroup.lang.ObjectExtensions;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;

public class ModelConverter {
	
	public static List<ResourcesModel> toResourcesModel(List<Resources> resources) {
		List<ResourcesModel> rml = new ArrayList<ResourcesModel>();
		for (Resources resource : resources) {
			rml.add(toResourcesModel(resource));
		}
		return rml;
	}
	
	public static ResourcesModel toResourcesModel(Resources resource) {
		return ObjectExtensions.copyQuietly(new ResourcesModel(), resource);
	}
}
