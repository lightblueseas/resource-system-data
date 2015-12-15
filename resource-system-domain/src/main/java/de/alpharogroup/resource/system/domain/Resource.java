package de.alpharogroup.resource.system.domain;

import java.util.Date;

import de.alpharogroup.domain.BaseDomainObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link Resource}.
 */
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resource extends BaseDomainObject<Integer> {
	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The checksum from this resource. */
	private String checksum;
	/** The binary data from this resource. */
	private byte[] content;
	/** The content type from this resource. */
	private String contentType;
	/** The date when this resource is created in the database. */
	private Date created;
	/**
	 * A flag that indicates that the resource is deleted from the user. Will be deleted in batch process.
	 */
	private Boolean deletedFlag;
	/** A description for this resource. */
	private String description;
	/** The filename from this resource. */
	private String filename;
	/** The size from this resource. */
	private String filesize;
}
