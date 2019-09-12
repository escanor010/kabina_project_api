package Kabina.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Kabina.Model.User;
import Kabina.Repository.UserRepository;
import Kabina.Service.JwtUserDetailsService;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users/{userId}")
	public User getUser(@PathVariable(value = "userId") long userId) {
		return userRepository.findById(userId);
	}
	
	@RequestMapping(value="/user/{id}/shelves", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<?> getBusinessUnitShelvesByUserId(@PathVariable("id") long id) {
		Map<String,Object> mapResponse = jwtUserDetailsService.getBusinessUnitShelvesByUserId(id);
		return ResponseEntity.ok(mapResponse);
	}
}
