package Kabina.Service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import Kabina.Repository.BookingRepository;
import Kabina.DTO.BookingDTO;
import Kabina.Model.Booking;
import Kabina.Model.BusinessUnit;
import Kabina.Model.Shelf;
import Kabina.Model.User;

@RunWith(SpringRunner.class)
public class BookingServiceTest {
	
	@TestConfiguration
    static class BookingServiceTestContextConfiguration {
  
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }
	
	@Autowired
    private BookingService bookingService;
 
    @MockBean
    private BookingRepository bookingRepository;
    
    @Before
    public void setUp() {
    	BusinessUnit businessUnit = new BusinessUnit(1,"Insurance","Nguyen Van A");
    	Shelf shelf = new Shelf(1,12,"010","Available",businessUnit);
    	User user = new User(1,"mquan","123","","","","","",false,"User",businessUnit);
    	Booking booking = new Booking(1,user,shelf,new Date(new Date(0).getTime()),new Date(new Date(0).getTime()));
    	List<Booking> bookingDaoList = new ArrayList<>();
    	bookingDaoList.add(booking);
        Mockito.when(bookingRepository.findBookingByUserId(1)).thenReturn(bookingDaoList);
    }
    
    @Test
    public void whenValidUserID_thenUserBookingListShouldBeFound() {
        long userID = 1;
        List<BookingDTO> bookingDtoList = bookingService.getBookingListByUserId(userID);  
        assertEquals(1,bookingDtoList.get(0).getBookingId());
        assertEquals(12,bookingDtoList.get(0).getFloor());
        assertEquals("010",bookingDtoList.get(0).getPositionNumber());
     }
}
