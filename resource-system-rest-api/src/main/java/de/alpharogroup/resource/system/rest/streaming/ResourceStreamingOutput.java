package de.alpharogroup.resource.system.rest.streaming;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import de.alpharogroup.check.Check;
import de.alpharogroup.resource.system.domain.Resource;

/**
 * The class {@link ResourceStreamingOutput}.
 */
public class ResourceStreamingOutput implements StreamingOutput {

	/** The resource. */
	private final Resource resource;

	/**
	 * Instantiates a new {@link ResourceStreamingOutput}.
	 *
	 * @param resource the resource
	 */
	public ResourceStreamingOutput(final Resource resource) {
		Check.get().notNull(resource, "resource");
		this.resource = resource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(final OutputStream output) throws IOException, WebApplicationException {
    	output.write(this.resource.getContent());
    	output.flush();
	}

}
