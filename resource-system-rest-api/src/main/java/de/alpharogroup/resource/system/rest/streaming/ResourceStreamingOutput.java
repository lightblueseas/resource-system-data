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
	 * @param resource
	 *            the resource
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
