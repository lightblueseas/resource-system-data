package de.alpharogroup.resource.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.resource.system.entities.Resources;
import de.alpharogroup.resource.system.service.api.ResourcesService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ResourcesBusinessServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ResourcesService resourcesService;
	
	@Test(enabled = true)
	public void testFindByName() {
		Resources resources = resourcesService.findByName("man_placeholder.jpg");
		AssertJUnit.assertEquals(resources.getChecksum(), "ae7768338af5ac9036c06c2e414509ae8fc465a216e08cae133299cf5291cc39");
	}
}
