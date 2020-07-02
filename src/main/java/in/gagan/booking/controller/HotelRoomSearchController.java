package in.gagan.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gagan.base.framework.controller.BaseController;
import in.gagan.booking.model.Hotel;
import in.gagan.booking.service.HotelRoomSearchService;

@RestController
@RequestMapping("/hotels")
public class HotelRoomSearchController implements BaseController {
	
	@Autowired
	private HotelRoomSearchService hotelRoomSearchSvc;
	
	@GetMapping("/searchByLocation/{state}/{city}")
	public List<Hotel> fetchAllHotelsForLocation(@PathVariable("state") String state,
			@PathVariable("city") String city) {
		return null;//hotelRoomSearchSvc.fetchHotelsBasedOnLocation(state, city);
	}

	@GetMapping("/searchByHotel/{hotelId}")
	public List<Hotel> fetchSpecificHotel(@PathVariable("hotelId") int hotelId) {
		return null;//hotelRoomSearchSvc.fetchHotelsBasedOnHotelId(hotelId);
	}
	 

}
