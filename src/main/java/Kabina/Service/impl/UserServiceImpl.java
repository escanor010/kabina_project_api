package Kabina.Service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Model.Users;
import Kabina.Repository.UsersRepository;
import Kabina.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;

	public  Iterable<Users> findAll() {
		return usersRepository.findAll();
	}
}
