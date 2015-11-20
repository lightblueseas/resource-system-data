package de.alpharogroup.resource.system.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import de.alpharogroup.resource.system.service.api.ResourceService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

/**
 * The class {@link ResourcesRestResource} provides an implementation of the inteface {@link ResourcesResource}.
 */
public class ResourcesRestResource extends AbstractRestfulResource<Integer, Resource, ResourceService>
implements ResourcesResource {


	@Override
	public StreamingOutput getPdf(String name) {
		final Resource resource = getDomainService().findByName(name);		
		return getResourceStreamingOutput(resource);
	}
	
	
	private StreamingOutput getResourceStreamingOutput(final Resource resource) {
		return new ResourceStreamingOutput(resource);
	}


	@Override
	public Response getImage(String name) {
		final Resource resource = getDomainService().findByName(name);
		return Response.ok(getResourceStreamingOutput(resource)).build();
	}

}
