package Kabina.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Repository.BookingRepository;
import Kabina.DTO.BookingDTO;
import Kabina.Model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<BookingDTO> getBookingListByUserId(long userId) {
		List<BookingDTO> bookingList = new ArrayList<>();
		List<Booking> bookingDaoList = bookingRepository.findBookingByUserId(userId);
		
		for(int i=0; i<bookingDaoList.size();i++) {
			Booking daoBooking = bookingDaoList.get(i);
			BookingDTO bookingTemp = new BookingDTO(daoBooking.getId(),daoBooking.getShelf().getFloor(), daoBooking.getShelf().getPositionNumber(),new Date(daoBooking.getCreatedAt().getTime()),new Date(daoBooking.getBookingDate().getTime()));
			bookingList.add(bookingTemp);
		}
		
		return bookingList;
	}
}
