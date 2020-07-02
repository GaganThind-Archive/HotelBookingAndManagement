package in.gagan.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import in.gagan.base.framework.model.AbstractBaseModel;

/**
 * Model/Entity representing the Room table 
 * 
 * @author gaganthind
 *
 */
@Entity
@Table(name = "ROOMS")
public class Room extends AbstractBaseModel {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7513469798213177917L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROOM_ID", nullable = false, unique = true)
	private long roomId;
	
	@Column(name = "ROOM_NUMBER", nullable = false, unique = true)
	private long roomNumber;

	@Column(name = "FLOOR_NUMBER", nullable = false)
	private long floorNumber;

	@Column(name = "ROOM_TYPE", nullable = false, length = 10)
	private String roomType;

	@Column(name = "OCCUPIED", nullable = false)
	private char occupied;

	@Column(name = "ACTIVE_SW", nullable = false)
	private char activeSw;
	
	@ManyToOne
	@JoinColumn(name="HOTEL_ROOM_ID", nullable = false)
	private Hotel roomsHotel;

	public long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public char isOccupied() {
		return occupied;
	}

	public void setOccupied(char occupied) {
		this.occupied = occupied;
	}

	public long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	public void setHotelRoom(Hotel hotel) {
		this.roomsHotel = hotel;
	}
	
	public Hotel getRoomsHotel() {
		return roomsHotel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
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
		
		Room other = (Room) obj;
		
		return roomId == other.roomId;
	}

}
