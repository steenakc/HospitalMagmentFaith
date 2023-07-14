package com.faith.app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.User;

@Repository
public interface LoginRepositry extends CrudRepository<User, Integer> {

	@Query("from User WHERE user_name=?1 and password=?2")
	public User findUserByNameAndPassword(String userName, String password);

	@Query(value = "select image  from user_image ui where ui.user_Id=?1 limit 1;", nativeQuery = true)
	public byte[] getUserImage(int userId);

	@Query(value = "select coalesce(d.doctor_name,s.staff_name,'') as userName" + 
			" from user u left join doctor d on d.user_Id=u.user_Id" + 
			" left join staff s on s.staff_id=u.user_Id where u.user_Id=:userId", nativeQuery = true)
	public String getUserName(@Param("userId") int userId);

	

}
