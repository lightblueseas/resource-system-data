package de.alpharogroup.resource.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void setResourcesDao(ResourcesDao resourcesDao){
		setDao(resourcesDao);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByName(String filename) {
		return getMapper().toDomainObject(resourcesService.findByName(filename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource findByDescription(String description) {
		return getMapper().toDomainObject(resourcesService.findByDescription(description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Resource> find(String description, String filename, String filesize, String contentType) {
		return getMapper().toDomainObjects(resourcesService.find(description, filename, filesize, contentType));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getManPlaceholder() {
		return getMapper().toDomainObject(resourcesService.getManPlaceholder());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getWomanPlaceholder() {
		return getMapper().toDomainObject(resourcesService.getWomanPlaceholder());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Resource getDefaultPlaceholder() {
		return getMapper().toDomainObject(resourcesService.getDefaultPlaceholder());
	}

}
