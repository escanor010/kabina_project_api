package Kabina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kabina.Model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>, JpaRepository<Users, String> {

}
