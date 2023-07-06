package com.faith.app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.User;

@Repository
public interface LoginRepositry extends CrudRepository<User, Integer> {

	@Query("from User WHERE user_name=?1 and password=?2")
	public User findUserByNameAndPassword(String userName, String password);

}
