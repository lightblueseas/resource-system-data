package de.alpharogroup.resource.system.application.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import de.alpharogroup.lang.ObjectExtensions;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;

/**
 * The class {@link ModelConverter}.
 */
public class ModelConverter {

	/**
	 * To resources model.
	 *
	 * @param resources the resources
	 * @return the list
	 */
	public static List<ResourcesModel> toResourcesModel(final List<Resources> resources) {
		final List<ResourcesModel> rml = new ArrayList<ResourcesModel>();
		for (final Resources resource : resources) {
			rml.add(toResourcesModel(resource));
		}
		return rml;
	}

	/**
	 * To resources model.
	 *
	 * @param resource the resource
	 * @return the resources model
	 */
	public static ResourcesModel toResourcesModel(final Resources resource) {
		return ObjectExtensions.copyQuietly(new ResourcesModel(), resource);
	}

	/**
	 * Converts the given array of {@link Byte} objects to a primitive {@code byte} array.
	 *
	 * @param array the array
	 * @return the primitive {@code byte} array
	 */
	public static byte[] toByteArray(final Byte[] array) {
		return ArrayUtils.toPrimitive(array);
	}

	/**
	 * Converts the given primitive {@code byte} array to an array of {@link Byte} objects.
	 *
	 * @param array the array
	 * @return the array of {@link Byte} objects.
	 */
	public static Byte[] toObject(final byte[] array) {
		return ArrayUtils.toObject(array);
	}
}
