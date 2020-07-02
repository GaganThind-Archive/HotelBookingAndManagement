package in.gagan.booking.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.gagan.base.framework.dao.RoleDAO;
import in.gagan.base.framework.dao.UserDAO;
import in.gagan.base.framework.dao.UserSecurityDAO;
import in.gagan.base.framework.model.Role;
import in.gagan.base.framework.model.User;
import in.gagan.base.framework.model.UserSecurity;
import in.gagan.booking.dao.AddressDAO;
import in.gagan.booking.model.Address;

@Transactional
@Service
public class HomePageService {
	
	@Autowired
	public UserDAO userDAO;
	
	@Autowired
	public AddressDAO addressDAO;
	
	@Autowired
	public RoleDAO roleDAO;
	
	@Autowired
	public UserSecurityDAO userSecurityDAO;

	public List<User> fetchAllUsers() {
		return (List<User>) userDAO.findAll();
	}
	
	public void deleteAddress() {
		
		//Helper
		List<Address> addrList = (List<Address>) addressDAO.findAll();
		User user = addrList.get(0).getUser();
		//long count = addressDAO.count();
		System.out.println("============================================================ \n \n");
		/*boolean exists = addressDAO.existsById(2L);
		
		//Find
		List<Address> addrList = (List<Address>) addressDAO.findAll();
		List<Address> addrListIds = (List<Address>) addressDAO.findAllById(Arrays.asList(3L, 4L, 5L));
		Address addr1 = addressDAO.findById(1L);
		Address addr6 = addressDAO.findById(6L);
		Address addr7 = addressDAO.findById(7L);
		Address addr8 = addressDAO.findById(8L);
		
		//Delete
		addressDAO.delete(addr6);
		addressDAO.deleteAll(Arrays.asList(addr7, addr8));
		addressDAO.deleteById(9L);
		addressDAO.deleteAll();
		
		//Hard Delete
		addressDAO.hardDelete(addr1);
		addressDAO.hardDeleteAll(addrListIds);
		addressDAO.hardDeleteById(2L);
		addressDAO.hardDeleteAll();*/
		
	}
	public void deleteUser() {
		
		long count = userDAO.count();
		System.out.println("============================================================ \n \n");
	}
	
	public void deleteUserSecurity() {
		List<UserSecurity> addrList = (List<UserSecurity>) userSecurityDAO.findAll();
		Set<Role> roles = addrList.get(0).getUserRole();
		User user = addrList.get(0).getUser();
		Address address = addressDAO.findById(user.getUserId());
		System.out.println("============================================================ \n \n");
	}
	
	public void deleteRole() {
		long count = roleDAO.count();
		System.out.println("============================================================ \n \n");
	}
	
	public void createData(String email) {
		User user = new User();
		user.setActiveSw('Y');
		user.setDob(LocalDateTime.of(2019, Month.MARCH, 28, 0, 0, 0, 0));
		user.setEmail(email);
		user.setFirstName("A");
		user.setGender('M');
		user.setLastName("MM");
		user.setCreateUserId("System");
		userDAO.save(user);
		
		createAddress(user);
		createUserSecurity(user);
	}
	
	public void createAddress(User user) {
		Address hotelAddress = new Address();
		hotelAddress.setActiveSw('Y');
		hotelAddress.setAddressFor('H');
		hotelAddress.setAddressLine("Domlur");
		hotelAddress.setCity("Bengaluru");
		hotelAddress.setFlatNoAndStreet("201, SriShailam");
		hotelAddress.setPincode(560071);
		hotelAddress.setState("Karnataka");
		hotelAddress.setCreateUserId("System");
		hotelAddress.setUser(user);
		addressDAO.save(hotelAddress);
	}
	
	public void createUserSecurity(User user) {
		UserSecurity userSecurity = new UserSecurity();
		userSecurity.setAccountLocked('N');
		userSecurity.setFailedLoginAttempts((short) 0);
		userSecurity.setPassword("test");
		userSecurity.setCreateUserId("System");
		userSecurity.setUser(user);
		userSecurity.addRole(createRole(userSecurity, "Admin"));
		userSecurityDAO.save(userSecurity);
		userSecurity.addRole(createRole(userSecurity, "Normal"));
		userSecurityDAO.save(userSecurity);
	}
	
	public Role createRole(UserSecurity userSecurity, String roleName) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setCreateUserId("System");
		role.setUserSecurity(userSecurity);
		return role;
	}

}
