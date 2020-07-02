package in.gagan.booking.dao;

import org.springframework.stereotype.Repository;

import in.gagan.base.framework.dao.AbstractBaseDAO;
import in.gagan.booking.model.Address;

/**
 * This class is used to CRUD operations on the Address table using DAO pattern
 * 
 * @author gaganthind
 *
 */
@Repository
public class AddressDAO extends AbstractBaseDAO<Address, Long> {

}
