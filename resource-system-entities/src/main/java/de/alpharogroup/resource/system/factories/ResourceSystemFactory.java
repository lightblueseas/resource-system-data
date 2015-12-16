package de.alpharogroup.resource.system.factories;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.ArrayUtils;

import de.alpharogroup.resource.system.entities.Resources;

public final class ResourceSystemFactory implements Serializable {

	private ResourceSystemFactory() {
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** The Constant instance. */
	private static final ResourceSystemFactory instance = new ResourceSystemFactory();

    public static ResourceSystemFactory getInstance() {
		return instance;
	}

	/**
	 * Factory method for create an Resources object.
	 *
	 * @param id the id
	 * @param description the description
	 * @param filename the filename
	 * @param filesize the filesize
	 * @param filetype the filetype
	 * @param content the content
	 * @param created the created
	 * @param deletedFlag the deleted flag
	 * @param checksum the checksum
	 * @return Resources A Resources object
	 */
    public Resources newResources(final Integer id, final String description, final String filename,
            final String filesize, final String filetype, final Byte [] content, final Date created, final Boolean deletedFlag, final String checksum ) {

        return newResources(id, description, filename, filesize, filetype, ArrayUtils.toPrimitive(content), created, deletedFlag, checksum);
    }
	/**
	 * Factory method for create an Resources object.
	 *
	 * @param id the id
	 * @param description the description
	 * @param filename the filename
	 * @param filesize the filesize
	 * @param filetype the filetype
	 * @param content the content
	 * @param created the created
	 * @param deletedFlag the deleted flag
	 * @param checksum the checksum
	 * @return Resources A Resources object
	 */
    public Resources newResources(final Integer id, final String description, final String filename,
            final String filesize, final String filetype, final byte [] content, final Date created, final Boolean deletedFlag, final String checksum ) {
    	final Resources resources = new Resources();
        resources.setDescription( description );
        resources.setFilename( filename );
        resources.setFilesize( filesize );
        resources.setContentType( filetype );
        resources.setId( id );
        resources.setContent(content);
        resources.setCreated(created);
        resources.setChecksum(checksum);
        resources.setDeletedFlag(deletedFlag);
        return resources;
    }

    /**
     * Factory method for create an Resources object.
     *
     * @param description the description
     * @param filename the filename
     * @param filesize the filesize
     * @param filetype the filetype
     * @param content the content
     * @param saved the saved
     * @param deletedFlag the deleted flag
     * @param checksum the checksum
     * @return Resources A Resources object
     */
    public Resources newResources(final String description, final String filename,
            final String filesize, final String filetype, final Byte [] content, final Date saved, final Boolean deletedFlag, final String checksum ) {
        return newResources(null, description, filename, filesize, filetype, content, saved, deletedFlag, checksum);
    }

    /**
     * Factory method for create an Resources object.
     *
     * @param description the description
     * @param filename the filename
     * @param filesize the filesize
     * @param filetype the filetype
     * @param content the content
     * @param saved the saved
     * @param deletedFlag the deleted flag
     * @param checksum the checksum
     * @return Resources A Resources object
     */
    public Resources newResources(final String description, final String filename,
            final String filesize, final String filetype, final byte [] content, final Date saved, final Boolean deletedFlag, final String checksum ) {
        return newResources(null, description, filename, filesize, filetype, content, saved, deletedFlag, checksum);
    }

}
