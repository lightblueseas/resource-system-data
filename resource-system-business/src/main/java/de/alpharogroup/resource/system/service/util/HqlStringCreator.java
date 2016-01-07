package de.alpharogroup.resource.system.service.util;

import de.alpharogroup.resource.system.entities.Resources;

public class HqlStringCreator {
	public static String forResources(final String description, final String filename,
			final String filesize, final String contentType) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select r from " + Resources.class.getSimpleName() + " r");
		final boolean descriptionIsNotNull = description != null && !description.isEmpty();
		if (descriptionIsNotNull) {
			sb.append(" ");
			sb.append("where r.description=:description");
		}
		final boolean filenameIsNotNull = filename != null && !filename.isEmpty();
		if (filenameIsNotNull) {
			sb.append(" ");
			if (descriptionIsNotNull) {
				sb.append("and r.filename=:filename");
			} else {
				sb.append("where r.filename=:filename");
			}
		}
		final boolean filesizeIsNotNull = filesize != null && !filesize.isEmpty();
		if(filesizeIsNotNull) {
			sb.append(" ");
			if(!descriptionIsNotNull && !filenameIsNotNull) {
				sb.append("where r.filesize=:filesize");
			} else {
				sb.append("and r.filesize=:filesize");
			}
		}
		final boolean contentTypeIsNotNull = contentType != null && !contentType.isEmpty();
		if (contentTypeIsNotNull) {
			sb.append(" ");
			if (!descriptionIsNotNull && !filenameIsNotNull
					&& !filesizeIsNotNull) {
				sb.append("where r.contentType=:contentType");
			} else {
				sb.append("and r.contentType=:contentType");
			}
		}
		return sb.toString();
	}

}