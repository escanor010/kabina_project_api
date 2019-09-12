package Kabina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Kabina.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	List<Booking> findBookingByUserId(long userId);
}
