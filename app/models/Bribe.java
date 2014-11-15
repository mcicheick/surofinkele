/**
 *
 */
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;

/**
 * @author Abdoulaye Maiga & Cheick Mahady SISSOKO
 * @date 8 nov. 2014 20:36:25
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "T_BRIBES")
public class Bribe extends Standard {

	/**
	 * The type of the bribe represents:
	 * <ul>
	 * <li>Paid</li>
	 * <li>Not Paid</li>
	 * <li>Not asked</li>
	 * </ul>
	 */
	@Required(message = "required.bribe.type")
	@Column(name = "TYPE", nullable = false)
	public String type;

	/**
	 * The are of government that was corrupted
	 */
	@Required(message = "required.bribe.area")
	@Column(name = "AREA", nullable = false)
	public String area;

	/**
	 * The amount payed for the bribe
	 */
	@Required(message = "required.bribe.amount")
	@Column(name = "AMOUNT", nullable = true)
	public double amount;

	/**
	 * The user who posted the bribe
	 */
	@Required(message = "required.bribe.author")
	@ManyToOne(cascade = CascadeType.PERSIST)
	public User author;

	/**
	 * The title of the bribe story
	 */
	@Required(message = "required.bribe.title")
	@MaxSize(value = 70, message = "required.bribe.title.max")
	public String title;

	/**
	 * The location where the bribe was paid or demanded
	 */
	//@Required(message = "required.bribe.address")
	@ManyToOne(cascade = CascadeType.PERSIST)
	public Address address;

	/**
	 * The date the bribe took place
	 */
	@Required(message = "required.bribe.date")
	@Column(name = "DATE")
	public Date date;

	/**
	 * A description of how the bribe happened.
	 */
	@Required(message = "required.bribe.description")
	@Column(name = "DESCRIPTION")
	@Lob
	public String description;

	/**
	 * The list of attachments
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bribe")
	public List<BribeAttachment> attachments;

	/**
	 * List of comments
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bribe")
	public List<BribeAttachment> comments;

	/**
     *
     */
	public Bribe() {
		super();
	}

	/**
	 * Find bribes by address
	 * 
	 * @param address
	 * @return List bribes that occurred at the same address
	 */
	public List<Bribe> bribesByAddress(Address address) {
		List<Bribe> bb_city = Bribe
				.find("select distinc b from Bribe b where b.address=? order by b.date desc",
						address).fetch();
		return bb_city;
	}

	/**
	 * find bribes by address attribute: circle, city, borough
	 * 
	 * @param attribute
	 *            the address attribute
	 * @param value
	 *            the value of the given attribute
	 * @return List of bribes which occurred in the same address attribute
	 */
	public List<Bribe> bribesByAddressAttribute(String attribute, String value) {
		List<Bribe> bb_city = Bribe.find(
				"select distinc b from Bribe b where b.address." + attribute
						+ "=? order by b.date desc", value).fetch();
		return bb_city;
	}

	public List<Bribe> paidBribes() {
		List<Bribe> paid_bribes = null;
		return paid_bribes;
	}

	/**
	 * Function returns the sum of all the amounts paid
	 * 
	 * @return
	 */
	public double totalAmount() {
		List<Bribe> paidBribes = null;
		return -1;
	}

}
