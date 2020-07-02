package in.gagan.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import in.gagan.base.framework.model.AbstractBaseModel;
import in.gagan.base.framework.model.User;

/**
 * Model/Entity representing the Address table 
 * 
 * @author gaganthind
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends AbstractBaseModel {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 3134308337880180947L;

	@Id
	private long addressId;

	@Column(name="ADDRESS_FOR", nullable = false)
	private char addressFor;

	@Column(name = "FLAT_NO_AND_STREET", nullable = false, length = 20)
	private String flatNoAndStreet;

	@Column(name = "ADDRESS_LINE", nullable = false, length = 100)
	private String addressLine;

	@Column(name = "CITY", nullable = false, length = 50)
	private String city;

	@Column(name = "STATE", nullable = false, length = 50)
	private String state;

	@Column(name = "PINCODE", nullable = false)
	private long pincode;

	@Column(name = "ADDRESS_MAP_LINK", nullable = true, length = 400)
	private String addressMapLink;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@MapsId
	@JoinColumn(name = "ADDRESS_ID")
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private User userAddrss;
	
	public String getFlatNoAndStreet() {
		return flatNoAndStreet;
	}

	public void setFlatNoAndStreet(String flatNoAndStreet) {
		this.flatNoAndStreet = flatNoAndStreet;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getMapLink() {
		return addressMapLink;
	}

	public void setMapLink(String addressMapLink) {
		this.addressMapLink = addressMapLink;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public char getAddressFor() {
		return addressFor;
	}

	public void setAddressFor(char addressFor) {
		this.addressFor = addressFor;
	}

	public void setUser(User userAddrss) {
		this.userAddrss = userAddrss;
	}
	
	public User getUser() {
		return userAddrss;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (addressId ^ (addressId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj == null) {
			return false;
		} else if(getClass() != obj.getClass()) {
			return false;
		}
		
		Address other = (Address) obj;
		
		return addressId == other.addressId;
	}
	
}
