package de.alpharogroup.resource.system.rest.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import de.alpharogroup.check.Check;

/**
 * The class {@link InputStreamStreamingOutput}.
 */
public class InputStreamStreamingOutput implements StreamingOutput {
        
        /** The input stream. */
        private final  InputStream inputStream;

        /**
         * Instantiates a new {@link InputStreamStreamingOutput}.
         *
         * @param input the input
         */
        public InputStreamStreamingOutput(InputStream input) {
    		Check.get().notNull(input, "InputStream");
            this.inputStream = input;
        }

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void write(OutputStream output) throws IOException, WebApplicationException {
            int bytesRead; 
            byte[] buffer = new byte[4096]; 
            while ((bytesRead = this.inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

    }