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
public class BribeCommentId implements Serializable {

	final long bribe_id;
	final long comment_id;

	/**
	 * @param bribe_id
	 * @param comment_id
	 */
	public BribeCommentId(long bribe_id, long comment_id) {
		this.bribe_id = bribe_id;
		this.comment_id = comment_id;
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
		result = prime * result + (int) (comment_id ^ (comment_id >>> 32));
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
		BribeCommentId other = (BribeCommentId) obj;
		if (comment_id != other.comment_id)
			return false;
		if (bribe_id != other.bribe_id)
			return false;
		return true;
	}

}
