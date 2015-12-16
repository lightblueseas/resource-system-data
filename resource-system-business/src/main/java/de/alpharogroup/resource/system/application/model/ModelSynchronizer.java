package de.alpharogroup.resource.system.application.model;

import java.io.File;

import de.alpharogroup.date.ConvertDateExtensions;
import de.alpharogroup.file.checksum.Algorithm;
import de.alpharogroup.file.checksum.ChecksumExtensions;
import de.alpharogroup.file.read.ReadFileExtensions;
import de.alpharogroup.lang.ObjectExtensions;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.factories.ResourceSystemFactory;

/**
 * The class {@link ModelSynchronizer}.
 */
public class ModelSynchronizer {

	/**
	 * Synchronize the given objects.
	 *
	 * @param toSynchronize the to synchronize
	 * @param withImage the with image
	 */
	public static void synchronize(final Resources toSynchronize, final Resources withImage) {
		ObjectExtensions.copyQuietly(toSynchronize, withImage);
	}

	/**
	 * Convert the given FileModel object to an Resources object.
	 *
	 * @param resourcesModel
	 *            the upload file model
	 * @return the resources
	 */
	public static Resources convert(final ResourcesModel resourcesModel) {
		final Resources resources = ResourceSystemFactory.getInstance().
			newResources(
				resourcesModel.getDescription(), resourcesModel.getFilename(),
				resourcesModel.getFilesize(), resourcesModel.getContentType(),
				resourcesModel.getContent(), resourcesModel.getCreated(), resourcesModel.isDeletedFlag(), resourcesModel.getChecksum());
		return resources;
	}

	/**
	 * Equalizes the given image with the resourcesModel object so the resourcesModel
	 * object sets the values from resources object.
	 *
	 * @param resources
	 *            the resources
	 * @param resourcesModel
	 *            the file model
	 */
	public static void equalise(final Resources resources, final ResourcesModel resourcesModel) {
		resources.setChecksum(resourcesModel.getChecksum());
		resources.setContent(resourcesModel.getContent());
		resources.setContentType(resourcesModel.getContentType());
		resources.setCreated(resourcesModel.getCreated());
		resources.setDeletedFlag(resourcesModel.isDeletedFlag());
		resources.setDescription(resourcesModel.getDescription());
		resources.setFilename(resourcesModel.getFilename());
		resources.setFilesize(resourcesModel.getFilesize());
	}

	/**
	 * Converts the given File object to a ResourceModel object.
	 *
	 * @param file the file
	 * @param contentType the content type
	 * @param description the description
	 * @return the ResourceModel
	 */
	public static ResourcesModel toResourceModel(final File file, final String contentType, final String description) {
		final ResourcesModel resourcesModel = new ResourcesModel();
		resourcesModel.setContent(ReadFileExtensions.toByteArray(file));
		resourcesModel.setContentType(contentType);
		resourcesModel.setDescription(description);
		resourcesModel.setFilename(file.getName());
		resourcesModel.setFilesize(file.length()+"");
		resourcesModel.setChecksum(ChecksumExtensions.getChecksumQuietly(file, Algorithm.SHA_256));
		resourcesModel.setCreated(ConvertDateExtensions.toDate(file.lastModified()));
		resourcesModel.setDeletedFlag(Boolean.FALSE);
		return resourcesModel;
	}

}
