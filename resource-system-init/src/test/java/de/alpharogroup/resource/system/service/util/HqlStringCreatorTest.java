package de.alpharogroup.resource.system.service.util;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.resource.system.service.util.HqlStringCreator;

public class HqlStringCreatorTest {

	@Test
	public void testForResources() {
		String actual;
		String expected;

		actual = HqlStringCreator.forResources(null, null, null, null);
		expected = "select r from Resources r";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", null, null, null);
		expected = "select r from Resources r where r.description=:description";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, "bla", null, null);
		expected = "select r from Resources r where r.filename=:filename";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, null, "400", null);
		expected = "select r from Resources r where r.filesize=:filesize";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources(null, null, null, "jpg");
		expected = "select r from Resources r where r.contentType=:contentType";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", null, null);
		expected = "select r from Resources r where r.description=:description and r.filename=:filename";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", "400", null);
		expected = "select r from Resources r where r.description=:description and r.filename=:filename and r.filesize=:filesize";		
		AssertJUnit.assertEquals(expected, actual);

		actual = HqlStringCreator.forResources("bla", "name", "400", "jpg");
		expected = "select r from Resources r where r.description=:description and r.filename=:filename and r.filesize=:filesize and r.contentType=:contentType";		
		AssertJUnit.assertEquals(expected, actual);
	}

}
