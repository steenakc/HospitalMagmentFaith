package com.faith.app.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.faith.app.common.APIResponse;

@Service
public interface LoginService {
	public APIResponse findUserByNameAndPassword(Map<String, Object> loginMap);

}
