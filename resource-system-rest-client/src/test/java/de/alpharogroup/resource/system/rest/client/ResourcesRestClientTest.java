package de.alpharogroup.resource.system.rest.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.core.Response;

import org.testng.annotations.Test;

public class ResourcesRestClientTest {

	@Test
	public void testGetResourcesResource() throws FileNotFoundException, IOException {
		final ResourcesRestClient restClient = new ResourcesRestClient();
		final Response response = restClient.getResourcesResource().getImage("man_placeholder.jpg");
		final Object obj = response.getEntity();
		final ByteArrayInputStream result=(ByteArrayInputStream)response.getEntity();
		final ByteArrayOutputStream baos=new ByteArrayOutputStream();
//		  result.write(baos);
//		  baos.writeTo(new FileOutputStream("man_placeholder.jpg"));
//		IOUtils.copy(is, new FileOutputStream("man_placeholder.jpg"));
	}

}
