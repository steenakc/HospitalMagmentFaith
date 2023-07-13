package com.faith.app.rest;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.common.APIResponse;
import com.faith.app.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginservice;

	@PostMapping("/user")
	public ResponseEntity<APIResponse> findUserByNameandPassword(@RequestBody Map<String, Object> loginMap) {
		System.out.println("login controller : " + loginMap);
		APIResponse apiResponse = loginservice.findUserByNameAndPassword(loginMap);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(value = "/userimage", method = RequestMethod.GET)
	public  byte[] getUserImage(@RequestParam("userId") int userId, HttpServletResponse response)
			throws Exception {

		byte[] byteImage =  loginservice.getUserImage(userId);
		response.setContentType("image/png");
		response.flushBuffer();
		return byteImage;
	}

}
