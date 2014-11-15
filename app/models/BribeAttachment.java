/**
 * 
 */
package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Cheick Mahady SISSOKO
 * @date 8 nov. 2014 20:57:05
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AS_BRIBE_ATTACHMENTS")
@IdClass(BribeAttachmentId.class)
public class BribeAttachment extends Association {

	@Id
	@Column(name = "BRIBE_ID")
	public long bribe_id;
	@Id
	@Column(name = "ATTACHMENT_ID")
	public long attachment_id;
	/**
	 * The bribe to which the attachment is attached
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "bribe_id", updatable = false, insertable = false, referencedColumnName = "id")
	public Bribe bribe;

	/**
	 * The attachment attached to
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attachment_id", updatable = false, insertable = false, referencedColumnName = "id")
	public Attachment attachment;

	/**
	 * 
	 */
	public BribeAttachment() {
		super();
	}

	@Override
	public String toString() {
		return "BribeAttachment[" + bribe_id + ", " + attachment_id + "]";
	}
}
