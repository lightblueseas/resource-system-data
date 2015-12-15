package de.alpharogroup.resource.system.rest;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;

import de.alpharogroup.date.CreateDateExtensions;
import de.alpharogroup.email.messages.Mimetypes;
import de.alpharogroup.file.checksum.Algorithm;
import de.alpharogroup.file.checksum.ChecksumExtensions;
import de.alpharogroup.io.StreamExtensions;
import de.alpharogroup.resource.system.domain.Resource;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import de.alpharogroup.resource.system.rest.streaming.ResourceStreamingOutput;
import de.alpharogroup.resource.system.service.api.ResourceService;
import de.alpharogroup.service.rs.AbstractRestfulResource;

/**
 * The class {@link ResourcesRestResource} provides an implementation of the inteface
 * {@link ResourcesResource}.
 */
public class ResourcesRestResource
	extends
		AbstractRestfulResource<Integer, Resource, ResourceService>
	implements ResourcesResource
{

	/** The logger constant. */
	private static final Logger LOG = Logger.getLogger(ResourcesRestResource.class.getName());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response download(final String name)
	{
		final Resource resource = getDomainService().findByName(name);
		return Response.ok(getResourceStreamingOutput(resource)).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response downloadById(final Integer id)
	{
		final Resource resource = getDomainService().read(id);
		return Response.ok(getResourceStreamingOutput(resource)).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response upload(final Attachment attachment)
	{
		final DataHandler dataHandler = attachment.getDataHandler();
		InputStream inputStream = null;
		try
		{
			// get filename
			final String fileName = getFileName(attachment);
			final String description = getElementFromContentDisposition(attachment, "description");
			inputStream = dataHandler.getInputStream();
			final String contentType = Mimetypes.getExtension(fileName);
			final byte[] byteArray = IOUtils.toByteArray(inputStream);
			final Resource resource = Resource.builder()
				.filename(fileName)
				.description(description)
				.contentType(contentType)
				.content(byteArray)
				.filesize(byteArray.length + "")
				.created(CreateDateExtensions.now()).checksum(ChecksumExtensions
					.getChecksumQuietly(byteArray, Algorithm.SHA_256.getAlgorithm()))
				.deletedFlag(false)
				.build();
			getDomainService().create(resource);
		}
		catch (final Exception e)
		{
			LOG.error("Error occured by upload attachment.", e);
		}
		finally
		{
			if (inputStream != null)
			{
				try
				{
					StreamExtensions.close(inputStream);
				}
				catch (final IOException e)
				{
					LOG.error("Error occured by close inputstream.", e);
				}
			}
		}
		return Response.ok("upload success").build();
	}

	/**
	 * Gets the file name from the given {@link Attachment} object.
	 *
	 * @param attachment
	 *            the attachment
	 * @return the file name
	 */
	private String getFileName(final Attachment attachment)
	{
		final String element = getElementFromContentDisposition(attachment, "filename");
		if (element != null)
		{
			final String filename = element.replaceAll("\"", "");
			return filename;
		}
		return null;
	}

	/**
	 * Gets an element from the given {@link Attachment} object.
	 *
	 * @param attachment            the attachment
	 * @param element the element
	 * @return the element or null if not found.
	 */
	private String getElementFromContentDisposition(final Attachment attachment,
		final String element)
	{
		final MultivaluedMap<String, String> multivaluedMap = attachment.getHeaders();
		final String[] contentDispositions = multivaluedMap.getFirst("Content-Disposition")
			.split(";");
		for (final String contentDisposition : contentDispositions)
		{

			if ((contentDisposition.trim().startsWith(element)))
			{
				final String[] keyValue = contentDisposition.split("=");
				final String value = keyValue[1].trim();
				return value;
			}
		}
		return null;
	}

	/**
	 * Gets a {@link ResourceStreamingOutput} from the given {@link Resource} object.
	 *
	 * @param resource the {@link Resource} object
	 * @return the {@link ResourceStreamingOutput} object.
	 */
	private StreamingOutput getResourceStreamingOutput(final Resource resource)
	{
		return new ResourceStreamingOutput(resource);
	}

}
