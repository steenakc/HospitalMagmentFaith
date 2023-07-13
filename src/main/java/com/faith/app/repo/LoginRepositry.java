package com.faith.app.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.User;

@Repository
public interface LoginRepositry extends CrudRepository<User, Integer> {

	@Query("from User WHERE user_name=?1 and password=?2")
	public User findUserByNameAndPassword(String userName, String password);

	@Query(value = "select image  from user_image ui where ui.user_Id=?1 limit 1;", nativeQuery = true)
	public byte[] getUserImage(int userId);

	

}
