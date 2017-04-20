/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
public interface ResourcesResource extends RestfulResource<Integer, Resource>
{

	/**
	 * Gets a {@link StreamingOutput} from the given name of a {@link Resource}.
	 *
	 * @param name
	 *            the name
	 * @return the resource
	 */
	@GET
	@Path("/download/file/by/name/{name}/")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response download(@PathParam("name") String name);

	/**
	 * Gets a {@link StreamingOutput} from the given id of a {@link Resource}.
	 *
	 * @param id
	 *            the id
	 * @return the resource
	 */
	@GET
	@Path("/download/file/by/id/{id}/")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadById(@PathParam("id") Integer id);

	/**
	 * Uploads the given {@link Attachment} object and saves it to the database.
	 *
	 * @param attachment
	 *            the attachment
	 * @return the response
	 */
	@POST
	@Path("/upload/file")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(Attachment attachment);

}
