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
package de.alpharogroup.resource.system.service.util;

import de.alpharogroup.resource.system.entities.Resources;

public class HqlStringCreator {
	public static String forResources(final String description, final String filename, final String filesize,
			final String contentType) {
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
		if (filesizeIsNotNull) {
			sb.append(" ");
			if (!descriptionIsNotNull && !filenameIsNotNull) {
				sb.append("where r.filesize=:filesize");
			} else {
				sb.append("and r.filesize=:filesize");
			}
		}
		final boolean contentTypeIsNotNull = contentType != null && !contentType.isEmpty();
		if (contentTypeIsNotNull) {
			sb.append(" ");
			if (!descriptionIsNotNull && !filenameIsNotNull && !filesizeIsNotNull) {
				sb.append("where r.contentType=:contentType");
			} else {
				sb.append("and r.contentType=:contentType");
			}
		}
		return sb.toString();
	}

}