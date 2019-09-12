package Kabina.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kabina.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
	User findById(long id);
}
