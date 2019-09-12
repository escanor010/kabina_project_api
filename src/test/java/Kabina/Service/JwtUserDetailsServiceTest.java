package Kabina.Service;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import Kabina.Repository.UserRepository;
import Kabina.DTO.SecurityUser;
import Kabina.Model.BusinessUnit;
import Kabina.Model.Shelf;
import Kabina.Model.User;

@RunWith(SpringRunner.class)
public class JwtUserDetailsServiceTest {
	
	@TestConfiguration
    static class JwtUserDetailsServiceTestContextConfiguration {
  
        @Bean
        public JwtUserDetailsService jwtUserDetailsService() {
            return new JwtUserDetailsService();
        }
    }
	
	@Autowired
    private JwtUserDetailsService jwtUserDetailsService;
 
    @MockBean
	private UserRepository userRepository;
    
    @MockBean
	private PasswordEncoder bcryptEncoder;
    
    @Test
    public void successfullyLoadUserByUsername() {
    	User user = new User(1,"mquan","123","","","","","",false,"User",null);
        Mockito.when(userRepository.findByUsername("mquan")).thenReturn(user);
        String username = "mquan";
        SecurityUser suser = (SecurityUser) jwtUserDetailsService.loadUserByUsername(username);  
        assertEquals(1,suser.getId());
        assertEquals("mquan",suser.getUsername());
        assertEquals("User",suser.getRole());
     }
    
    @Test(expected = UsernameNotFoundException.class)
    public void failLoadUserByUsername() {
        Mockito.when(userRepository.findByUsername("mquan")).thenReturn(null);
        String username = "mquan";
        SecurityUser suser = (SecurityUser) jwtUserDetailsService.loadUserByUsername(username);  
     }
    
    @Test
    public void whenValidUserId_thenSuccessfullyGetBusinessUnitShelvesByUserId() {
    	BusinessUnit businessUnit = new BusinessUnit();
    	businessUnit.setId(1);
    	businessUnit.setName("Insurance");
    	List<Shelf> shelves = new ArrayList<>();
    	Shelf shelf1 = new Shelf(1,12,"010","Available",businessUnit);
    	Shelf shelf2 = new Shelf(2,20,"027","Booked",businessUnit);
    	Shelf shelf3 = new Shelf(3,30,"033","Available",businessUnit);
    	shelves.add(shelf1);
    	shelves.add(shelf2);
    	shelves.add(shelf3);
    	businessUnit.setShelves(shelves);
    	User user = new User(1,"mquan","123","","","","","",false,"User",businessUnit);
        Mockito.when(userRepository.findById(1)).thenReturn(user);
        Map<String,Object> mapResponse = jwtUserDetailsService.getBusinessUnitShelvesByUserId(1);
        List<Shelf> shelvesTest = (List<Shelf>) mapResponse.get("Shelves");
        
        assertEquals(1,(long)mapResponse.get("BusinessUnitID"));
        assertEquals("Insurance",mapResponse.get("BusinessUnitName"));
        
        assertEquals(12,shelvesTest.get(0).getFloor());
        assertEquals("010",shelvesTest.get(0).getPositionNumber());
        assertEquals("Available",shelvesTest.get(0).getStatus());
        
        assertEquals(20,shelvesTest.get(1).getFloor());
        assertEquals("027",shelvesTest.get(1).getPositionNumber());
        assertEquals("Booked",shelvesTest.get(1).getStatus());
        
        assertEquals(30,shelvesTest.get(2).getFloor());
        assertEquals("033",shelvesTest.get(2).getPositionNumber());
        assertEquals("Available",shelvesTest.get(2).getStatus());
     }
}
