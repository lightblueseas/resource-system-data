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

	/** The Constant DEFAULT_HTTP_PORT. */
	public static final int DEFAULT_HTTP_PORT = 8080;

	/** The Constant BASE_URL_PREFIX. */
	public static final String BASE_URL_PREFIX = "http://localhost";

	/** The Constant DEFAULT_BASE_URL. */
	public static final String DEFAULT_BASE_URL = BASE_URL_PREFIX + ":" + DEFAULT_HTTP_PORT;
	

	/**
	 * Gets the resources resource.
	 *
	 * @return the resources resource
	 */
	@Getter
	private final ResourcesResource resourcesResource;

	/**
	 * Instantiates a new {@link ResourcesRestClient} with the default base url.
	 */
	public ResourcesRestClient() {
		this(DEFAULT_BASE_URL);
	}
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
