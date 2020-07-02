package in.gagan.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import in.gagan.booking.dao.HotelDAO;
import in.gagan.booking.model.Address;
import in.gagan.booking.model.Hotel;
import in.gagan.booking.model.Room;

@Service
public class HotelRoomSearchService {
	
	@Autowired
	private HotelDAO hotelDAO;
	
	public List<Hotel> fetchAllHotels() {
		List<Hotel> allHotels = hotelDAO.findAllHotels();
		return CollectionUtils.isEmpty(allHotels) ? new ArrayList<>() : allHotels;
	}
	
	public Hotel fetchHotelDetails(long hotelId) {
		return hotelDAO.findAllDetailsByHotelId(hotelId);
	}
	
	public Set<Room> fetchHotelRooms(long hotelId) {
		Hotel hotel = fetchHotelDetails(hotelId);
		return null != hotel ? hotel.getRooms() : null;
	}
	
	public Address fetchHotelAddress(long hotelId) {
		Hotel hotel = fetchHotelDetails(hotelId);
		return null != hotel ? hotel.getHotelAddress() : null;
	}
	
	public void saveHotel(Hotel hotel) {
		hotelDAO.save(createHotel());
	}
	
	public Hotel createHotel() {
		Hotel hotel = createNewHotel();
		Address hotelAddress = createAddress();
		Room hotelRoom = createRoom();
		Room hotelRoom2 = createRoom();
		
		hotel.setHotelAddress(hotelAddress);
		hotel.addRoom(hotelRoom);
		hotel.addRoom(hotelRoom2);
		return hotel;
	}
	
	public Address createAddress() {
		Address hotelAddress = new Address();
		hotelAddress.setActiveSw('Y');
		hotelAddress.setAddressFor('H');
		hotelAddress.setAddressLine("Domlur");
		hotelAddress.setCity("Bengaluru");
		hotelAddress.setFlatNoAndStreet("201, SriShailam");
		hotelAddress.setPincode(560071);
		hotelAddress.setState("Karnataka");
		hotelAddress.setCreateUserId("System");
		return hotelAddress;
	}

	public Room createRoom() {
		Room room = new Room();
		room.setActiveSw('Y');
		room.setFloorNumber(1);
		room.setOccupied('Y');
		room.setRoomNumber(101);
		room.setRoomType("Normal");
		room.setCreateUserId("System");
		return room;
	}

	public Hotel createNewHotel() {
		Hotel hotel = new Hotel();
		hotel.setActiveSw('Y');
		hotel.setBasicInfo("sdfsdfsf");
		hotel.setName("Hotel Decent");
		hotel.setRatings(4.22);
		hotel.setCreateUserId("System");
		return hotel;
	}
	
}
