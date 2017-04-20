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
package de.alpharogroup.resource.system.service.api;

import java.util.List;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.service.domain.DomainService;

/**
 * The interface {@link ResourceService}.
 */
public interface ResourceService extends DomainService<Integer, Resource>
{

	/**
	 * Finds a list of {@link Resource} objects from the given arguments.
	 *
	 * @param description
	 *            the description
	 * @param filename
	 *            the filename
	 * @param filesize
	 *            the filesize
	 * @param contentType
	 *            the content type
	 * @return the list of {@link Resource} objects
	 */
	List<Resource> find(String description, String filename, String filesize, String contentType);

	/**
	 * Finds the {@link Resource} object by description.
	 *
	 * @param description
	 *            the description
	 * @return the resource
	 */
	Resource findByDescription(String description);

	/**
	 * Finds the {@link Resource} object by filename.
	 *
	 * @param filename
	 *            the filename
	 * @return the resource
	 */
	Resource findByName(String filename);

	/**
	 * Gets the default placeholder.
	 *
	 * @return the default placeholder
	 */
	Resource getDefaultPlaceholder();

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
}
