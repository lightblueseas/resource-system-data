package de.alpharogroup.resource.system.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.service.rs.RestfulResource;

/**
 * The interface {@link ResourcesResource} provides methods for resolving resources.
 */
@Path("/resource/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResourcesResource extends RestfulResource<Integer, Resource> {

}
