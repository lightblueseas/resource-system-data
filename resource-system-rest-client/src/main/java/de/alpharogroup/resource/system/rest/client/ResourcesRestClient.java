package de.alpharogroup.resource.system.rest.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import lombok.Getter;

/**
 * The class {@link ResourcesRestClient}.
 */
public class ResourcesRestClient {


	/**
	 * Gets the resources resource.
	 *
	 * @return the resources resource
	 */
	@Getter
	private final ResourcesResource resourcesResource;


	/**
	 * Instantiates a new {@link ResourcesRestClient}.
	 *
	 * @param baseUrl the base url
	 */
	public ResourcesRestClient(final String baseUrl) {

        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        
        resourcesResource  = JAXRSClientFactory.create(baseUrl, ResourcesResource.class, providers);
        WebClient.client(resourcesResource).accept(MediaType.APPLICATION_JSON);
        WebClient.client(resourcesResource).type(MediaType.APPLICATION_JSON);
	}
}
