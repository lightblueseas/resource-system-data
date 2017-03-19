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
 * The entity class {@link Resources} is keeping the information for the
 * resources from users like logos, files, images etc.
 */
@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
public class Resources extends BaseEntity<Integer> implements Cloneable {

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The checksum from this resource. */
	@Column(name = "checksum")
	private String checksum;
	/** The binary data from this resource. */
	@Column(name = "content", columnDefinition = "BYTEA")
	private byte[] content;
	/** The content type from this resource. */
	@Column(name = "contentType", length = 64)
	private String contentType;
	/** The date when this resource is created in the database. */
	@Column(name = "created")
	private Date created;
	/**
	 * A flag that indicates that the resource is deleted from the user. Will be
	 * deleted in batch process.
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
