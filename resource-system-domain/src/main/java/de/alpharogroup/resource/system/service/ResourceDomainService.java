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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.lang.object.CopyObjectExtensions;
import de.alpharogroup.resource.system.daos.ResourcesDao;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.mapper.ResourcesMapper;
import de.alpharogroup.resource.system.service.api.ResourceService;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.service.domain.AbstractDomainService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link ResourceDomainService}.
 */
@Transactional
@Service("resourceDomainService")
public class ResourceDomainService
	extends
		AbstractDomainService<Integer, Resource, Resources, ResourcesDao, ResourcesMapper>
	implements
		ResourceService
{

	/** The {@link ResourcesService}. */
	@Autowired
	@Getter
	@Setter
	private ResourcesService resourcesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource create(final Resource domainObject)
	{
		final Resources resources = CopyObjectExtensions.copyQuietly(domainObject, new Resources());
		domainObject.setId(getDao().save(resources));
		return domainObject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Resource> find(final String description, final String filename,
		final String filesize, final String contentType)
	{
		final List<Resource> resourcesDomainObjects = new ArrayList<>();
		final List<Resources> resourcesEntities = resourcesService.find(description, filename,
			filesize, contentType);
		for (final Resources resources : resourcesEntities)
		{
			final Resource resource = Resource.builder().build();
			CopyObjectExtensions.copyQuietly(resources, resource);
			resourcesDomainObjects.add(resource);
		}
		return resourcesDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByDescription(final String description)
	{
		final Resources resources = resourcesService.findByDescription(description);
		final Resource resource = Resource.builder().build();
		CopyObjectExtensions.copyQuietly(resources, resource);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByName(final String filename)
	{
		final Resources resources = resourcesService.findByName(filename);
		final Resource resource = Resource.builder().build();
		CopyObjectExtensions.copyQuietly(resources, resource);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getDefaultPlaceholder()
	{
		final Resources resources = resourcesService.getDefaultPlaceholder();
		final Resource resource = Resource.builder().build();
		CopyObjectExtensions.copyQuietly(resources, resource);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getManPlaceholder()
	{
		final Resources resources = resourcesService.getManPlaceholder();
		final Resource resource = Resource.builder().build();
		CopyObjectExtensions.copyQuietly(resources, resource);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getWomanPlaceholder()
	{
		final Resources resources = resourcesService.getWomanPlaceholder();
		final Resource resource = Resource.builder().build();
		CopyObjectExtensions.copyQuietly(resources, resource);
		return resource;
	}

	@Override
	public Resource read(final Integer id)
	{
		final Resources resources = getDao().get(id);
		final Resource resource = CopyObjectExtensions.copyQuietly(resources, new Resource());
		return resource;
	}

	/**
	 * Sets the specific {@link ResourcesDao}.
	 *
	 * @param resourcesDao
	 *            the new {@link ResourcesDao}.
	 */
	@Autowired
	public void setResourcesDao(final ResourcesDao resourcesDao)
	{
		setDao(resourcesDao);
	}

	/**
	 * Sets the specific {@link ResourcesMapper}.
	 *
	 * @param mapper
	 *            the new {@link ResourcesMapper}.
	 */
	@Autowired
	public void setResourcesMapper(ResourcesMapper mapper)
	{
		setMapper(mapper);
	}

	@Override
	public Resource update(final Resource domainObject)
	{
		Resources resources = getDao().get(domainObject.getId());
		CopyObjectExtensions.copyQuietly(domainObject, resources);
		resources = getDao().merge(resources);
		return domainObject;
	}

}
