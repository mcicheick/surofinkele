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
@Table(name = "AS_BRIBE_COMMENTS")
@IdClass(BribeCommentId.class)
public class BribeComment extends Association {

	@Id
	@Column(name = "BRIBE_ID")
	public long bribe_id;
	@Id
	@Column(name = "COMMENT_ID")
	public long comment_id;
	/**
	 * The bribe to which the comment is attached
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "bribe_id", updatable = false, insertable = false, referencedColumnName = "id")
	public Bribe bribe;

	/**
	 * The comment attached to
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comment_id", updatable = false, insertable = false, referencedColumnName = "id")
	public Comment comment;

	/**
	 * 
	 */
	public BribeComment() {
		super();
	}

	@Override
	public String toString() {
		return "BribeAttachment[" + bribe_id + ", " + comment_id + "]";
	}

}
