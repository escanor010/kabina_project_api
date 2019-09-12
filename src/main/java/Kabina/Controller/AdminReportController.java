package Kabina.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Kabina.DTO.BusinessUnitShelves;
import Kabina.DTO.FloorShelves;
import Kabina.Service.ShelfService;

@RestController
public class AdminReportController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminReportController.class);
	
	@Autowired
	private ShelfService shelfService;
	
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/admin/shelvesReport", method = RequestMethod.GET)
	public ResponseEntity<?> getShelvesReport() {
		Map<String,Object> mapResponse = new HashMap<String,Object>();
		mapResponse = shelfService.analyzeShelves();
		return ResponseEntity.ok(mapResponse);
	}
	
}
