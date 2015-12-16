package de.alpharogroup.resource.system.application.model;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ResourceModel.
 *
 * @author Asterios Raptis
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
	private byte[] content;

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
	 * Return the value associated with the column: deletedFlag.
	 *
	 * @return A Date object (this.deletedFlag)
	 */
	public Boolean isDeletedFlag() {
		return deletedFlag;
	}

}
