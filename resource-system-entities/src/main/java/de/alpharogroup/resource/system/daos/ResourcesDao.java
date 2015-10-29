package de.alpharogroup.resource.system.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Repository;

import de.alpharogroup.db.dao.jpa.JpaEntityManagerDao;
import de.alpharogroup.resource.system.entities.Resources;


@Repository("resourcesDao")
public class ResourcesDao extends JpaEntityManagerDao<Resources, Integer>{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@PersistenceContext 
	private EntityManager entityManager;
}
