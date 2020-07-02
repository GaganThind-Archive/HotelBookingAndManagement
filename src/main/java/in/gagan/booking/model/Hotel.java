package in.gagan.booking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import in.gagan.base.framework.model.AbstractBaseModel;


/**
 * Model/Entity representing the Hotel table 
 * 
 * @author gaganthind
 *
 */
@Entity
@Table(name = "HOTELS")
public class Hotel extends AbstractBaseModel {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1046419166070251739L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOTEL_ID", nullable = false, unique = true)
	private long hotelId;

	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@Column(name = "RATINGS", nullable = true)
	private double ratings;

	@Column(name = "BASIC_INFO", nullable = true, length = 50)
	private String basicInfo;

	@Column(name = "ACTIVE_SW", nullable = false)
	private char activeSw;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="HOTEL_ADDRESS_ID", nullable = false)
	private Address hotelAddress;
	
	@OneToMany(mappedBy = "roomsHotel", cascade = CascadeType.PERSIST) 
	private Set<Room> rooms = new HashSet<>();

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}
	
	public Address getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(Address hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	
	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room room) {
		room.setHotelRoom(this);
		this.rooms.add(room);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (hotelId ^ (hotelId >>> 32));
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
		
		Hotel other = (Hotel) obj;
		
		return hotelId == other.hotelId;
	}

}
