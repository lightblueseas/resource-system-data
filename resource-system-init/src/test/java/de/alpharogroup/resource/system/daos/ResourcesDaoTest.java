package de.alpharogroup.resource.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.resource.system.daos.ResourcesDao;
import de.alpharogroup.resource.system.entities.Resources;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ResourcesDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ResourcesDao resourcesDao;
	@Test
	public void testFindAll() {
		List<Resources> all = resourcesDao.findAll();
		System.out.println(all);		
	}

}
