package com.faith.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.common.APIResponse;
import com.faith.app.entity.User;
import com.faith.app.repo.LoginRepositry;
import com.faith.app.util.Jwt;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	LoginRepositry loginrepo;

	@Autowired
	private Jwt jwUtil;

	@Override
	public APIResponse findUserByNameAndPassword(Map<String, Object> loginMap) {
		try {

			String userName = loginMap.get("email").toString();
			String password = loginMap.get("password").toString();

			User user = null;
			try {
				user = loginrepo.findUserByNameAndPassword(userName, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/*
			 * username or password wrong
			 */
			if (user == null || user.getUserId() <= 0) {
				return new APIResponse(false, "You have entered a wrong username or password");
			}
			/*
			 * 
			 */
//			if (!user.getIsActive()) {
//				return new APIResponse(404, "The account is deactivated. Contact Admin for assistance");
//			}
			/*
			 * 
			 */
			String userFullName = "dummy name";
			switch (user.getRole().getRoleId()) {
			case 1: // doctor
//			Doctor doctor=doctorRepo.getDoctorByUserId(user.getUserId());
//				userFullName=doctor.getName();
				break;
			default:
//				Staff staff=staffRepo.getStaffByUserId(user.getUserId());
//				userFullName=staff.getName();
				break;
			}

			// credentials are valid generate token
			String token = jwUtil.generateJwt(user);

			// storing more details and token
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("accessToken", token);
			data.put("roleId", user.getRole().getRoleId());
			data.put("userName", user.getUserName());
			data.put("userFullName", userFullName);
			data.put("userId", user.getUserId());

			System.out.println("logged user data: " + data);
			return new APIResponse(true, null, data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new APIResponse(false, "Something went wrong.");

	}

	@Override
	public byte[] getUserImage(int userId) {
		try {
			return loginrepo.getUserImage(userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
