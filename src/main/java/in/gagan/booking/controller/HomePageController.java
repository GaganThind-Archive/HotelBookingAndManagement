package in.gagan.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gagan.base.framework.controller.BaseController;
import in.gagan.base.framework.model.User;
import in.gagan.booking.service.HomePageService;

@RestController
@RequestMapping("/home")
public class HomePageController implements BaseController {

	@Autowired
	private HomePageService homePageService;

	/**
	 * This method returns the home page
	 */
	@GetMapping("/load")
	public List<User> loadHomePage() {
		return homePageService.fetchAllUsers();
	}
	
	/**
	 * This method creates users
	 */
	@GetMapping("/fill")
	public String createDummyData() {
		System.out.println("=========================   Start   ======================== \n \n");
		homePageService.createData("fdg");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg1");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg2");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg3");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg4");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg5");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg6");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg7");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg8");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg9");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg10");
		System.out.println("============================================================ \n \n");
		homePageService.createData("fdg11");
		System.out.println("============================================================ \n \n");
		return "Created User";
	}
	
	@GetMapping("/1")
	public void deleteAddress() {
		homePageService.deleteAddress();
	}
	
	@GetMapping("/2")
	public void deleteUser() {
		homePageService.deleteUser();
	}
	
	@GetMapping("/3")
	public void deleteRole() {
		homePageService.deleteRole();
	}
	
	@GetMapping("/4")
	public void deleteUserSecurity() {
		homePageService.deleteUserSecurity();
	}
	
}
