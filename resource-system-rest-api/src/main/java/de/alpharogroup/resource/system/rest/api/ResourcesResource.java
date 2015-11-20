package de.alpharogroup.resource.system.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.service.rs.RestfulResource;

/**
 * The interface {@link ResourcesResource} provides methods for resolving resources.
 */
@Path("/resource/")
public interface ResourcesResource extends RestfulResource<Integer, Resource> {

	@GET
	@Path("/pdf/{name}")
	@Produces("image/jpg")
	public StreamingOutput getPdf(final @PathParam("name") String name);
	
    @GET
    @Path("/image/{name}")
    @Produces("image/jpg")
    public Response getImage(@PathParam("name") String name);
	
}
