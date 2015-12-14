package de.alpharogroup.resource.system.rest.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

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
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImage(@PathParam("name") String name);

    @POST
    @Path("/upload/file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(Attachment attachment, @Context HttpServletRequest request);

}
