package Kabina.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Kabina.Model.Shelf;
import Kabina.Repository.ShelfRepository;
import Kabina.Service.ShelfService;

@RestController
public class ShelfController {
	
	@Autowired
	private ShelfService shelfService ;
	
	@GetMapping("/shelves")
	public List<Shelf> getAllShelves() {
		return shelfService.getAllShelves();
	}

	@GetMapping("/units/{unitId}/shelves")
	public List<Shelf> getAllShelvesByUnitId(@PathVariable(value = "unitId") long id) {
		return shelfService.getAllShelvesByUnitId(id);
		
	}
	
}
