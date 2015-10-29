package de.alpharogroup.resource.system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Entity class {@link Resources} is keeping the information for the resources
 * from users like logos, files, images etc.
 */
@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
public class Resources 
extends BaseEntity<Integer>
implements Cloneable {

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The checksum from this resource. */
	@Column(name = "checksum")
	private String checksum;
	/** The binary data from this resource. */
	@Column(name = "content", columnDefinition = "BYTEA")
	private Byte[] content;
	/** The content type from this resource. */
	@Column(name = "contentType",length = 64)
	private String contentType;
	/** The date when this resource is created in the database. */
	@Column(name = "created")
	private Date created;
	/**
	 * A flag that indicates that the resource is deleted from the user. Will be deleted in batch process.
	 */
	@Column(name = "deleted_flag")
	private Boolean deletedFlag;
	/** A description for this resource. */
	@Column(name = "description", length = 1024)
	private String description;
	/** The filename from this resource. */
	@Column(name = "filename", length = 1024)
	private String filename;
	/** The size from this resource. */
	@Column(name = "filesize", length = 64)
	private String filesize;
	
	public boolean isDeletedFlag() {
		return getDeletedFlag();
	}

}
