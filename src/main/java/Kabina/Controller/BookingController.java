package Kabina.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Kabina.DTO.BookingDTO;
import Kabina.Service.BookingService;

@RestController
public class BookingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/user/booking/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<?> getBookingListByUserId(@PathVariable("id") long id) {
		List<BookingDTO> bookingList = bookingService.getBookingListByUserId(id);
		return ResponseEntity.ok(bookingList);
	}
	
}
