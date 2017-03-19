/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.resource.system.application.model;

import java.io.File;

import de.alpharogroup.date.ConvertDateExtensions;
import de.alpharogroup.file.checksum.Algorithm;
import de.alpharogroup.file.checksum.ChecksumExtensions;
import de.alpharogroup.file.read.ReadFileExtensions;
import de.alpharogroup.lang.object.CopyObjectExtensions;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.factories.ResourceSystemFactory;

/**
 * The class {@link ModelSynchronizer}.
 */
public class ModelSynchronizer {

	/**
	 * Convert the given FileModel object to an Resources object.
	 *
	 * @param resourcesModel
	 *            the upload file model
	 * @return the resources
	 */
	public static Resources convert(final ResourcesModel resourcesModel) {
		final Resources resources = ResourceSystemFactory.getInstance().newResources(resourcesModel.getDescription(),
				resourcesModel.getFilename(), resourcesModel.getFilesize(), resourcesModel.getContentType(),
				resourcesModel.getContent(), resourcesModel.getCreated(), resourcesModel.isDeletedFlag(),
				resourcesModel.getChecksum());
		return resources;
	}

	/**
	 * Equalizes the given image with the resourcesModel object so the
	 * resourcesModel object sets the values from resources object.
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
	 * Synchronize the given objects.
	 *
	 * @param toSynchronize
	 *            the to synchronize
	 * @param withImage
	 *            the with image
	 */
	public static void synchronize(final Resources toSynchronize, final Resources withImage) {
		CopyObjectExtensions.copyQuietly(withImage, toSynchronize);
	}

	/**
	 * Converts the given File object to a ResourceModel object.
	 *
	 * @param file
	 *            the file
	 * @param contentType
	 *            the content type
	 * @param description
	 *            the description
	 * @return the ResourceModel
	 */
	public static ResourcesModel toResourceModel(final File file, final String contentType, final String description) {
		final ResourcesModel resourcesModel = new ResourcesModel();
		resourcesModel.setContent(ReadFileExtensions.toByteArray(file));
		resourcesModel.setContentType(contentType);
		resourcesModel.setDescription(description);
		resourcesModel.setFilename(file.getName());
		resourcesModel.setFilesize(file.length() + "");
		resourcesModel.setChecksum(ChecksumExtensions.getChecksumQuietly(file, Algorithm.SHA_256));
		resourcesModel.setCreated(ConvertDateExtensions.toDate(file.lastModified()));
		resourcesModel.setDeletedFlag(Boolean.FALSE);
		return resourcesModel;
	}

}
