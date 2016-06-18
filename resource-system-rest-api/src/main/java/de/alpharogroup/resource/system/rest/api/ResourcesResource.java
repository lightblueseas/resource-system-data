package de.alpharogroup.resource.system.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    /**
     * Gets a {@link StreamingOutput} from the given name of a {@link Resource}.
     *
     * @param name the name
     * @return the resource
     */
    @GET
    @Path("/download/file/by/name/{name}/")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("name") String name);

    /**
     * Gets a {@link StreamingOutput} from the given id of a {@link Resource}.
     *
     * @param id the id
     * @return the resource
     */
    @GET
    @Path("/download/file/by/id/{id}/")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadById(@PathParam("id") Integer id);

    /**
     * Uploads the given {@link Attachment} object and saves it to the database.
     *
     * @param attachment the attachment
     * @return the response
     */
    @POST
    @Path("/upload/file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(Attachment attachment);

}
