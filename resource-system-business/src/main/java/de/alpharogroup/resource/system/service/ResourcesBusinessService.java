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
package de.alpharogroup.resource.system.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.service.AbstractBusinessService;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.repositories.ResourcesRepository;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.resource.system.service.util.HqlStringCreator;

/**
 * The service class {@link ResourcesBusinessService}.
 */
@Transactional
@Service("resourcesService")
public class ResourcesBusinessService
	extends
		AbstractBusinessService<Resources, java.lang.Integer, ResourcesRepository>
	implements
		ResourcesService
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	@SuppressWarnings("unchecked")
	public List<Resources> find(String description, String filename, String filesize,
		String contentType)
	{
		final String hqlString = HqlStringCreator.forResources(description, filename, filesize,
			contentType);
		final Query query = getQuery(hqlString);
		if (description != null && !description.isEmpty())
		{
			query.setParameter("description", description);
		}
		if (filename != null && !filename.isEmpty())
		{
			query.setParameter("filename", filename);
		}
		if (filesize != null && !filesize.isEmpty())
		{
			query.setParameter("filesize", filesize);
		}
		if (contentType != null && !contentType.isEmpty())
		{
			query.setParameter("contentType", contentType);
		}
		final List<Resources> Resources = query.getResultList();
		return Resources;
	}

	@Override
	public Resources findByDescription(String description)
	{
		final List<Resources> Resources = find(description, null, null, null);
		return ListExtensions.getFirst(Resources);
	}

	@Override
	public Resources findByName(String filename)
	{
		final List<Resources> Resources = find(null, filename, null, null);
		return ListExtensions.getFirst(Resources);
	}

	@Override
	public Resources getDefaultPlaceholder()
	{
		final List<Resources> Resources = find("default profile photo for default users",
			"default_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);
	}

	@Override
	public Resources getManPlaceholder()
	{
		final List<Resources> Resources = find("default profile photo for male users",
			"man_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);
	}

	@Override
	public Resources getWomanPlaceholder()
	{
		final List<Resources> Resources = find("default profile photo for female users",
			"woman_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);
	}

	/**
	 * Sets the repository.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public void setResourcesRepository(ResourcesRepository repository) {
		setRepository(repository);
	}

}