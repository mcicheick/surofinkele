package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.binding.NoBinding;
import play.data.validation.Required;
import play.db.jpa.JPABase;

/**
 * 
 * @author Cheick Mahady SISSOKO
 * @date 6 nov. 2014 12:14:30
 * 
 * @since djammadev v1
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "T_ATTACHEMENTS")
public class Attachment extends Standard {

	@Column(name = "ATTACHMENT_TYPE")
	@Required(message = "required.attachment.attachmentType")
	public String attachmentType;

	@Column(name = "TITLE")
	@Required(message = "required.attachment.title")
	public String title;

	@Column(name = "DATA")
	@Required(message = "required.attachment.data")
	public Data data;
	
	@ManyToOne
	public User author;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="attachment")
	public List<BribeAttachment> bribes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="attachment")
	public List<PostAttachment> posts;

	/**
	 * 
	 */
	public Attachment() {
		super();
	}

	public String url() {
		if (data != null) {
			return data.url();
		}
		return null;
	}

	@Override
	public <T extends JPABase> T delete() {
		if (data != null) {
			data.delete();
		}
		return super.delete();
	}
}
