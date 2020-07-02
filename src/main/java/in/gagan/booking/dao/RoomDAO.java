package in.gagan.booking.dao;

import org.springframework.stereotype.Repository;

import in.gagan.base.framework.dao.AbstractBaseDAO;
import in.gagan.booking.model.Room;

/**
 * This class is used to CRUD operations on the Room table using DAO pattern
 * 
 * @author gaganthind
 *
 */
@Repository
public class RoomDAO extends AbstractBaseDAO<Room, Long> {

}
