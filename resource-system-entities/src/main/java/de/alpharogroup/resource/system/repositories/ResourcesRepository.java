package de.alpharogroup.resource.system.repositories;

import org.springframework.stereotype.Repository;

import de.alpharogroup.db.repository.AbstractRepository;
import de.alpharogroup.resource.system.entities.Resources;

@Repository("resourcesRepository")
public class ResourcesRepository extends AbstractRepository<Resources, java.lang.Integer>
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
