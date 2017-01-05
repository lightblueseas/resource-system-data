package de.alpharogroup.resource.system.rest.client;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import lombok.Getter;

/**
 * The class {@link ResourcesRestClient}.
 */
public class ResourcesRestClient extends AbstractRestClient {

	/**
	 * The {@link ResourcesResource}.
	 */
	@Getter
	private final ResourcesResource resourcesResource;

	/**
	 * Instantiates a new {@link ResourcesRestClient} with the default base url.
	 */
	public ResourcesRestClient() {
		this(DEFAULT_BASE_HTTP_URL);
	}
	/**
	 * Instantiates a new {@link ResourcesRestClient}.
	 *
	 * @param baseUrl the base url
	 */
	public ResourcesRestClient(final String baseUrl) {
		super(baseUrl);
        resourcesResource  = newResource(ResourcesResource.class);
	}
}
