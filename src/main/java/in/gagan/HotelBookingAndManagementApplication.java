package in.gagan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring boot starter file
 * 
 * @author gaganthind
 *
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class HotelBookingAndManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingAndManagementApplication.class, args);
	}

}
