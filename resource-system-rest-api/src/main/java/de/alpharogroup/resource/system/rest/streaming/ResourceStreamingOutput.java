package de.alpharogroup.resource.system.rest.streaming;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.lang3.ArrayUtils;

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
	public ResourceStreamingOutput(Resource resource) {
		Check.get().notNull(resource, "resource");
		this.resource = resource;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(OutputStream output) throws IOException, WebApplicationException {
    	final byte[] byteArrayData = ArrayUtils.toPrimitive(this.resource.getContent());
    	output.write(byteArrayData);
    	output.flush();
	}

}
