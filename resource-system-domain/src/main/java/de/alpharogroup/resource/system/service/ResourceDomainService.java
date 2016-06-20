package de.alpharogroup.resource.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.lang.ObjectExtensions;
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
public class ResourceDomainService extends
		AbstractDomainService<Integer, Resource, Resources, ResourcesDao, ResourcesMapper> implements ResourceService {



	/** The {@link ResourcesService}. */
	@Autowired
	@Getter
	@Setter
	private ResourcesService resourcesService;

	/**
	 * Sets the specific {@link ResourcesDao}.
	 *
	 * @param resourcesDao
	 *            the new {@link ResourcesDao}.
	 */
	@Autowired
	public void setResourcesDao(final ResourcesDao resourcesDao){
		setDao(resourcesDao);
	}

	/**
	 * Sets the specific {@link ResourcesMapper}.
	 *
	 * @param mapper
	 *            the new {@link ResourcesMapper}.
	 */
	@Autowired
	public void setResourcesMapper(ResourcesMapper mapper) {
		setMapper(mapper);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource create(final Resource domainObject)
	{
		final Resources resources = ObjectExtensions.copyQuietly(new Resources(), domainObject);
		domainObject.setId(getDao().save(resources));
		return domainObject;
	}

	@Override
	public Resource read(final Integer id)
	{
		final Resources resources = getDao().get(id);
		final Resource resource = ObjectExtensions.copyQuietly(new Resource(), resources);
		return resource;
	}

	@Override
	public void update(final Resource domainObject)
	{
		final Resources resources = getDao().get(domainObject.getId());
		ObjectExtensions.copyQuietly(resources, domainObject);
		getDao().merge(resources);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByName(final String filename) {
		final Resources resources = resourcesService.findByName(filename);
		final Resource resource = Resource.builder().build();
		ObjectExtensions.copyQuietly(resource, resources);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByDescription(final String description) {
		final Resources resources = resourcesService.findByDescription(description);
		final Resource resource = Resource.builder().build();
		ObjectExtensions.copyQuietly(resource, resources);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Resource> find(final String description, final String filename, final String filesize, final String contentType) {
		final List<Resource> resourcesDomainObjects = new ArrayList<>();
		final List<Resources> resourcesEntities = resourcesService.find(description, filename, filesize, contentType);
		for (final Resources resources : resourcesEntities)
		{
			final Resource resource = Resource.builder().build();
			ObjectExtensions.copyQuietly(resource, resources);
			resourcesDomainObjects.add(resource);
		}
		return resourcesDomainObjects;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getManPlaceholder() {
		final Resources resources = resourcesService.getManPlaceholder();
		final Resource resource = Resource.builder().build();
		ObjectExtensions.copyQuietly(resource, resources);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getWomanPlaceholder() {
		final Resources resources = resourcesService.getWomanPlaceholder();
		final Resource resource = Resource.builder().build();
		ObjectExtensions.copyQuietly(resource, resources);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getDefaultPlaceholder() {
		final Resources resources = resourcesService.getDefaultPlaceholder();
		final Resource resource = Resource.builder().build();
		ObjectExtensions.copyQuietly(resource, resources);
		return resource;
	}

}
