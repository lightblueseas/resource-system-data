package de.alpharogroup.resource.system.rest;

import java.io.InputStream;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import de.alpharogroup.resource.system.rest.streaming.ResourceStreamingOutput;
import de.alpharogroup.resource.system.service.api.ResourceService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

/**
 * The class {@link ResourcesRestResource} provides an implementation of the inteface {@link ResourcesResource}.
 */
public class ResourcesRestResource extends AbstractRestfulResource<Integer, Resource, ResourceService>
implements ResourcesResource {


	@Override
	public StreamingOutput getPdf(final String name) {
		final Resource resource = getDomainService().findByName(name);
		return getResourceStreamingOutput(resource);
	}


	private StreamingOutput getResourceStreamingOutput(final Resource resource) {
		return new ResourceStreamingOutput(resource);
	}

	@Override
	public Response getImage(final String name) {
		final Resource resource = getDomainService().findByName(name);
		return Response
			.ok(getResourceStreamingOutput(resource))
			.build();
	}


	@Override
	public Response upload(final Attachment attachment, final HttpServletRequest request)
	{
        final DataHandler dataHandler = attachment.getDataHandler();
        try{
            // get filename
            final String fileName = getFileName(attachment);

            final InputStream inputStream = dataHandler.getInputStream();
            final byte[] byteArray = IOUtils.toByteArray(inputStream);
            final Resource resource = Resource.builder()
            	.filename(fileName)
            	.content(ArrayUtils.toObject(byteArray))
            	.build();
            getDomainService().create(resource);
        }
        catch(final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // release resources, if any
        }
            return Response.ok("upload success").build();
	}

       /**
        * Gets the file name from the given {@link Attachment} object.
        *
        * @param attachment the attachment
        * @return the file name
        */
       private String getFileName(final Attachment attachment) {
    	   final MultivaluedMap<String, String> multivaluedMap = attachment.getHeaders();
           final String[] contentDisposition = multivaluedMap.getFirst("Content-Disposition").split(";");
           for (final String filename : contentDisposition) {

               if ((filename.trim().startsWith("filename"))) {
                   final String[] name = filename.split("=");
                   final String exactFileName = name[1].trim().replaceAll("\"", "");
                   return exactFileName;
               }
           }
           return null;
       }
}
