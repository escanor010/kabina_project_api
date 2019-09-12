package Kabina.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Kabina.Model.Users;
import Kabina.Service.impl.UserServiceImpl;
import Kabina.Validator.UsersValidator;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kabina")
public class UsersController {

	@Autowired
	private UserServiceImpl usersService;

	@Autowired
	private UsersValidator usersValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(usersValidator);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Users> getUsers() {
		return (List<Users>) usersService.findAll();
	}
}
