package de.alpharogroup.resource.system.rest.client;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.testng.annotations.Test;

public class ResourcesRestClientTest {

	@Test
	public void testGetResourcesResource() throws FileNotFoundException, IOException {
		ResourcesRestClient restClient = new ResourcesRestClient();
		Response response = restClient.getResourcesResource().getImage("man_placeholder.jpg");
		final StreamingOutput result=(StreamingOutput)response.getEntity();
		final ByteArrayOutputStream baos=new ByteArrayOutputStream();
		  result.write(baos);
		  baos.writeTo(new FileOutputStream("man_placeholder.jpg"));
//		IOUtils.copy(is, new FileOutputStream("man_placeholder.jpg"));
	}

}
