package de.alpharogroup.resource.system.rest;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import de.alpharogroup.resource.system.service.api.ResourceService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

/**
 * The class {@link ResourcesRestResource} provides an implementation of the inteface {@link ResourcesResource}.
 */
public class ResourcesRestResource extends AbstractRestfulResource<Integer, Resource, ResourceService>
implements ResourcesResource {

}
