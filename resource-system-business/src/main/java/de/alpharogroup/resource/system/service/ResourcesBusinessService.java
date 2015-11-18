package de.alpharogroup.resource.system.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.resource.system.daos.ResourcesDao;
import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.resource.system.service.util.HqlStringCreator;

@Transactional
@Service("resourcesService")
public class ResourcesBusinessService extends AbstractBusinessService<Resources, Integer, ResourcesDao> implements ResourcesService {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setResourcesDao(ResourcesDao ResourcesDao) {
		setDao(ResourcesDao);
	}
	
	public Resources getManPlaceholder() {
		final List<Resources> Resources = find("default profile photo for male users", "man_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);		
	}
	
	public Resources getWomanPlaceholder() {
		final List<Resources> Resources = find("default profile photo for female users", "woman_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);		
	}
	
	public Resources getDefaultPlaceholder() {
		final List<Resources> Resources = find("default profile photo for default users", "default_placeholder.jpg", null, null);
		return ListExtensions.getFirst(Resources);		
	}
	
	public Resources findByName(String filename) {
		final List<Resources> Resources = find(null, filename, null, null);
		return ListExtensions.getFirst(Resources);		
	}
	
	public Resources findByDescription(String description) {
		final List<Resources> Resources = find(description, null, null, null);
		return ListExtensions.getFirst(Resources);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Resources> find(String description, String filename,
			String filesize, String contentType) {
		String hqlString = HqlStringCreator.forResources(description, filename, filesize, contentType);
		final Query query = getQuery(hqlString);
		if(description != null && !description.isEmpty()){
			query.setParameter("description", description);
		}
		if(filename != null && !filename.isEmpty()){
			query.setParameter("filename", filename);
		}
		if(filesize != null && !filesize.isEmpty()){
			query.setParameter("filesize", filesize);			
		}
		if(contentType != null && !contentType.isEmpty()){
			query.setParameter("contentType", contentType);			
		}
		final List<Resources> Resources = query.getResultList();
		return Resources;
	}
	
	

}