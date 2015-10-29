package de.alpharogroup.resource.system.factories;

import java.io.Serializable;
import java.util.Date;

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
    public Resources newResources(Integer id, String description, String filename,
            String filesize, String filetype, Byte [] content, Date created, Boolean deletedFlag, String checksum ) {
    	Resources resources = new Resources();
        resources.setDescription( description );
        resources.setFilename( filename );
        resources.setFilesize( filesize );
        resources.setContentType( filetype );
        resources.setId( id );
        resources.setContent(content );
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
    public Resources newResources(String description, String filename,
            String filesize, String filetype, Byte [] content, Date saved, Boolean deletedFlag, String checksum ) {
        return newResources(null, description, filename, filesize, filetype, content, saved, deletedFlag, checksum);
    }
}
