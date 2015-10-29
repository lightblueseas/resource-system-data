package de.alpharogroup.resource.system.service.util;

public class HqlStringCreator {
	public static String forResources(String description, String filename,
			String filesize, String contentType) {
		StringBuilder sb = new StringBuilder();
		sb.append("select r from Resources r");
		boolean descriptionIsNotNull = description != null && !description.isEmpty();
		if (descriptionIsNotNull) {
			sb.append(" ");
			sb.append("where r.description=:description");
		}
		boolean filenameIsNotNull = filename != null && !filename.isEmpty();
		if (filenameIsNotNull) {
			sb.append(" ");
			if (descriptionIsNotNull) {
				sb.append("and r.filename=:filename");
			} else {
				sb.append("where r.filename=:filename");
			}
		}
		boolean filesizeIsNotNull = filesize != null && !filesize.isEmpty();
		if(filesizeIsNotNull) {
			sb.append(" ");
			if(!descriptionIsNotNull && !filenameIsNotNull) {
				sb.append("where r.filesize=:filesize");				
			} else {
				sb.append("and r.filesize=:filesize");					
			}			
		}
		boolean contentTypeIsNotNull = contentType != null && !contentType.isEmpty();
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