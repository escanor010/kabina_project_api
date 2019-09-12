package Kabina.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Kabina.Repository.UserRepository;
import Kabina.Model.BusinessUnit;
import Kabina.Model.Shelf;
import Kabina.Model.User;
import Kabina.DTO.BusinessUnitShelves;
import Kabina.DTO.SecurityUser;
import Kabina.DTO.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new SecurityUser(user.getId(),user.getUsername(), user.getPassword(), user.getRole());
	}
	
	public boolean save(UserDTO user){ 
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		userRepository.save(newUser);
		return true;
	}
	
	public Map<String,Object>  getBusinessUnitShelvesByUserId(long id) {
		User user = userRepository.findById(id);
		BusinessUnit businessUnit = new BusinessUnit();
		businessUnit = user.getBusinessUnit();
		Map<String,Object> mapResponse = new HashMap<String,Object>();
		if(user.getBusinessUnit()!=null) {
			businessUnit = user.getBusinessUnit();
			List<Shelf> shelves = businessUnit.getShelves();
			long businessUnitId = businessUnit.getId();
			String businessUnitName = businessUnit.getName();
			mapResponse.put("BusinessUnitID", businessUnitId);
			mapResponse.put("BusinessUnitName", businessUnitName);
			mapResponse.put("Shelves", shelves);
		}
		return mapResponse;		
	}

}
