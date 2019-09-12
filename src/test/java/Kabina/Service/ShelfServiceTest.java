package Kabina.Service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import Kabina.Repository.ShelfRepository;
import Kabina.DTO.BusinessUnitShelves;
import Kabina.DTO.FloorShelves;
import Kabina.Model.BusinessUnit;
import Kabina.Model.Shelf;
import Kabina.Model.User_Shelf;

@RunWith(SpringRunner.class)
public class ShelfServiceTest {
	
	@TestConfiguration
    static class ShelfServiceTestContextConfiguration {
  
        @Bean
        public ShelfService shelfService() {
            return new ShelfService();
        }
    }
	
	@Autowired
    private ShelfService shelfService;
 
    @MockBean
    private ShelfRepository shelfRepository;
    
    @Before
    public void setUp() {
    	BusinessUnit businessUnit = new BusinessUnit(1,"Insurance","Nguyen Van A");
    	User_Shelf user_shelf = new User_Shelf();
    	Shelf shelf1 = new Shelf(1,12,"010","Booked",businessUnit);
    	shelf1.setUser_shelf(user_shelf);
    	Shelf shelf2 = new Shelf(2,12,"015","Booked",businessUnit);
    	shelf2.setUser_shelf(user_shelf);
    	Shelf shelf3 = new Shelf(3,27,"009","Booked",businessUnit);
    	shelf3.setUser_shelf(user_shelf);
    	Shelf shelf4 = new Shelf(4,27,"012","Booked",businessUnit);
    	shelf4.setUser_shelf(user_shelf);
    	Shelf shelf5 = new Shelf(5,30,"021","Available",businessUnit);
    	shelf5.setUser_shelf(null);
    	Shelf shelf6 = new Shelf(6,30,"027","Available",businessUnit);
    	shelf6.setUser_shelf(null);
    	List<Shelf> listShelf = new ArrayList<>();
    	listShelf.add(shelf1);
    	listShelf.add(shelf2);
    	listShelf.add(shelf3);
    	listShelf.add(shelf4);
    	listShelf.add(shelf5);
    	listShelf.add(shelf6);
        Mockito.when(shelfRepository.findAll()).thenReturn(listShelf);
    }
    
    @Test
    public void shelvesShouldBeAnalyzed_IntoAvailableListAndBookedList_FilterByFloorAndBusinessUnit() {
    	Map<String,Object> mapResponse = shelfService.analyzeShelves();
    	List<FloorShelves> listFloorShelves = (List<FloorShelves>) mapResponse.get("FloorReport");
    	List<BusinessUnitShelves> listBusinessUnitShelves = (List<BusinessUnitShelves>) mapResponse.get("BusinessUnitReport");
    	Comparator<FloorShelves> comparedByFloorNumber = (FloorShelves f1, FloorShelves f2) -> new Long(f1.getFloorNumber()).compareTo(f2.getFloorNumber());
    	Collections.sort(listFloorShelves, comparedByFloorNumber);
    	 
        assertEquals(0,listFloorShelves.get(0).getAvailable());
        assertEquals(2,listFloorShelves.get(0).getBooked());
        assertEquals(0,listFloorShelves.get(1).getAvailable());
        assertEquals(2,listFloorShelves.get(1).getBooked());
        assertEquals(0,listFloorShelves.get(1).getAvailable());
        assertEquals(0,listFloorShelves.get(2).getBooked());
        assertEquals(2,listBusinessUnitShelves.get(0).getAvailable());
        assertEquals(4,listBusinessUnitShelves.get(0).getBooked());

     }
}
