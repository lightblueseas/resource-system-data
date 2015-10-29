package de.alpharogroup.resource.system.application.model;

import de.alpharogroup.resource.system.entities.Resources;

public class ModelSynchronizer {
	
	public static void synchronize(Resources toSynchronize, Resources withImage){
		toSynchronize.setChecksum(withImage.getChecksum());
		toSynchronize.setContent(withImage.getContent());
		toSynchronize.setContentType(withImage.getContentType());
		toSynchronize.setCreated(withImage.getCreated());
		toSynchronize.setDeletedFlag(withImage.getDeletedFlag());
		toSynchronize.setDescription(withImage.getDescription());
		toSynchronize.setFilename(withImage.getFilename());
		toSynchronize.setFilesize(withImage.getFilesize());
	}

}
