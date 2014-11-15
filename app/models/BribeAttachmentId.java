/**
 * 
 */
package models;

import java.io.Serializable;

/**
 * @author Cheick Mahady SISSOKO
 * @date 8 nov. 2014 21:07:38
 */
@SuppressWarnings("serial")
public class BribeAttachmentId implements Serializable {

	final long bribe_id;
	final long attachment_id;

	/**
	 * @param bribe_id
	 * @param attachment_id
	 */
	public BribeAttachmentId(long bribe_id, long attachment_id) {
		this.bribe_id = bribe_id;
		this.attachment_id = attachment_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (attachment_id ^ (attachment_id >>> 32));
		result = prime * result + (int) (bribe_id ^ (bribe_id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BribeAttachmentId other = (BribeAttachmentId) obj;
		if (attachment_id != other.attachment_id)
			return false;
		if (bribe_id != other.bribe_id)
			return false;
		return true;
	}

}
