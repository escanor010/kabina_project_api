package Kabina;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import Kabina.Model.BusinessUnit;
import Kabina.Model.User;
import Kabina.Repository.BusinessUnitRepository;
import Kabina.Repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
public class KabinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KabinaApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BusinessUnitRepository busRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	BusinessUnit bus = new BusinessUnit(1, "Healthcare", "Duong Nguyen");
	    	busRepository.save(bus);
	        userRepository.save(new User(1, "chile", bcryptEncoder.encode("123"), "chi le van", "chile", "chilevan@gmail.com", "", "0395669219", true, "User",bus));
	   
	     };
	}
}

