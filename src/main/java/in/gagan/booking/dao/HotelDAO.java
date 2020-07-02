package in.gagan.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import in.gagan.base.framework.dao.AbstractBaseDAO;
import in.gagan.booking.model.Hotel;

/**
 * This class is used to CRUD operations on the Hotel table using DAO pattern
 * 
 * @author gaganthind
 *
 */
@Repository
public class HotelDAO extends AbstractBaseDAO<Hotel, Long> {

	/**
	 * Fetch all hotels
	 * 
	 * @return
	 */
	public List<Hotel> findAllHotels() {
		return (List<Hotel>) super.findAll();
	}

	/**
	 * Fetch all details of a hotel 
	 * 
	 * @param id
	 * @return
	 */
	public Hotel findAllDetailsByHotelId(Long id) {
		return super.findById(id);
	}
	
}
