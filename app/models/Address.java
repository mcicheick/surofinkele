/*
 * An address representing a place in the country. 
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;

/**
 *
 * @author Elay
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "T_ADDRESSES")
public class Address extends Standard {

     /**
     * The region in which the bribe took place
     */
    @Required(message = "required.address.region")
    @Column(name = "REGION")
    public String region;
    
    /**
     * The circle in which the bribe took place
     */
    @Required(message = "required.address.circle")
    @Column(name = "CIRCLE")
    public String circle;

    
    /**
     * The city in which the bribe took place
     */
    @Required(message = "required.address.city")
    @Column(name = "CITY")
    public String city;

    /**
     * The neighborhood in which the bribe took place
     */
    @Required(message = "required.address.borough")
    @Column(name = "BOROUGH")
    public String borough;
    
    public Address(){
        super();
    }

}
