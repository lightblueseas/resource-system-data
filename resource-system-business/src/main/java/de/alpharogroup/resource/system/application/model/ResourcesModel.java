package de.alpharogroup.resource.system.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

/**
 * The Class ResourceModel.
 * 
 * @author Asterios Raptis
 */
public class ResourcesModel implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The technical primary key. */
	private Integer id;

	/** The description. */
	private String description;

	/** The filename. */
	private String filename;

	/** The content type. */
	private String contentType;

	/** The content as byte array. */
	private Byte[] content;

	/** The size from this resource. */
	private String filesize;
	/** The checksum from this resource. */
	private String checksum;

	/** The date when this resource is saved to the database. */
	private Date created;
	/**
	 * A flag that indicates that the resource is deleted from the user. Will be deleted in batch process.
	 */
	private Boolean deletedFlag;	

	/**
	 * Instantiates a new resource model.
	 */
	public ResourcesModel() {
	}
	
	/**
	 * Return the value associated with the column: checksum.
	 * 
	 * @return A String object (this.checksum)
	 */
	@Column(name = "checksum")
	public String getChecksum() {
		return checksum;
	}

	/**
	 * Set the value related to the column: checksum
	 * 
	 * @param checksum
	 *            the checksum value you wish to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	/**
	 * Return the value associated with the column: id.
	 *
	 * @return A Integer object (this.id)
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set the value related to the column: id.
	 *
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Return the value associated with the column: deletedFlag.
	 * 
	 * @return A Date object (this.deletedFlag)
	 */
	public Boolean isDeletedFlag() {
		return deletedFlag;
	}

	/**
	 * Set the value related to the column: deletedFlag.
	 *
	 * @param deletedFlag            the deletedFlag value you wish to set
	 */
	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	/**
	 * Return the value associated with the column: saved.
	 * 
	 * @return A Date object (this.saved)
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the date when created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the filename.
	 * 
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the filename.
	 * 
	 * @param filename
	 *            the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Gets the content type.
	 * 
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type.
	 * 
	 * @param contentType
	 *            the new content type
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public Byte[] getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(Byte[] content) {
		this.content = content;
	}
	
	/**
	 * Gets the filesize.
	 *
	 * @return the filesize
	 */
	public String getFilesize() {
		return filesize;
	}



	/**
	 * Sets the filesize.
	 *
	 * @param filesize the filesize
	 */
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

}
