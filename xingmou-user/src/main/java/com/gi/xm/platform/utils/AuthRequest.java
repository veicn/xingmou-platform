package com.gi.xm.platform.utils;

import com.galaxyinternet.framework.core.utils.PWDUtils;
import com.galaxyinternet.model.auth.AuthResult;
import com.gi.xm.platform.pojo.UserResult;
import com.galaxyinternet.model.resource.PlatformResource;
import com.gi.xm.platform.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AuthRequest implements EnvironmentAware {
	private static final Logger logger = LoggerFactory.getLogger(AuthRequest.class);

	private String authURI;

	private RestTemplate template = new RestTemplate();
	
	public UserResult login(String userName, String password)
	{
		String uri = authURI + "/login/userLogin";
		Map<String, String> urlVariables = new HashMap<>();
		userName = PWDUtils.decodePasswordByBase64(userName);
		password = PWDUtils.decodePasswordByBase64(password);
		urlVariables.put("userName", userName);
		urlVariables.put("passWord", password);
		urlVariables.put("productType", "0");
		if(logger.isDebugEnabled())
		{
			logger.debug(String.format("Request URI:%s, Params:%s", uri, urlVariables));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> request = new HttpEntity<>(urlVariables, headers);
		ResponseEntity<UserResult> rtn = template.postForEntity(uri, request, UserResult.class);
		return rtn.getBody();
	}
	public AuthResult updatePwd(Long uid, String password)
	{
		String uri = authURI + "/user/updatePwd";
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("userId", uid+"");
		urlVariables.put("password", password);
		if(logger.isDebugEnabled())
		{
			logger.debug(String.format("Request URI:%s, Params:%s", uri, urlVariables));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> request = new HttpEntity<>(urlVariables, headers);
		ResponseEntity<AuthResult> rtn = template.postForEntity(uri, request, AuthResult.class);
		return rtn.getBody();
	}
//	public User getUserById(Long id)
//	{
//		String uri = authURI + "/user/getUserById";
//		Map<String, String> urlVariables = new HashMap<>();
//		urlVariables.put("userId", id+"");
//		if(logger.isDebugEnabled())
//		{
//			logger.debug(String.format("Request URI:%s, Params:%s", uri, urlVariables));
//		}
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Map<String, String>> request = new HttpEntity<>(urlVariables, headers);
//		ResponseEntity<UserResult> rtn = template.postForEntity(uri, request, UserResult.class);
//		return rtn.getBody().getValue();
//	}
//
//	public List<PlatformResource> getUserResource(PlatformResource entity)
//	{
//		String uri = authURI + "/user/getUserResource";
//		ParameterizedTypeReference<ArrayList<PlatformResource>> ref = new ParameterizedTypeReference<ArrayList<PlatformResource>>() {};
//		ResponseEntity<ArrayList<PlatformResource>> rtn = template.exchange(uri, HttpMethod.POST, new HttpEntity<>(entity), ref);
//		return rtn.getBody();
//	}
//	public List<PlatformResource> getResources(PlatformResource entity)
//	{
//		String uri = authURI + "/user/getResources";
//		ParameterizedTypeReference<ArrayList<PlatformResource>> ref = new ParameterizedTypeReference<ArrayList<PlatformResource>>() {};
//		ResponseEntity<ArrayList<PlatformResource>> rtn = template.exchange(uri, HttpMethod.POST, new HttpEntity<>(entity), ref);
//		return rtn.getBody();
//	}
//	public List<PlatformResource> getScope(PlatformResource entity)
//	{
//		String uri = authURI + "/user/getUserScope";
//		ParameterizedTypeReference<ArrayList<PlatformResource>> ref = new ParameterizedTypeReference<ArrayList<PlatformResource>>() {};
//		ResponseEntity<ArrayList<PlatformResource>> rtn = template.exchange(uri, HttpMethod.POST, new HttpEntity<>(entity), ref);
//		return rtn.getBody();
//	}
//
//	public List<Long> selectRoleIdByUserId(Long userId,String companyId)
//	{
//		String uri = authURI + "/role/selectRoleIdByUserId?userId="+userId+"&companyId="+companyId;
//		ParameterizedTypeReference<ArrayList<Long>> ref = new ParameterizedTypeReference<ArrayList<Long>>() {};
//		ResponseEntity<ArrayList<Long>> rtn = template.exchange(uri, HttpMethod.GET, new HttpEntity<>(null), ref);
//		return rtn.getBody();
//	}
//
	public List<Long> selectRoleCodeByUserId(Long userId)
	{
		String uri = authURI + "/role/selectRoleCodeByUserId?userId="+userId;
		ParameterizedTypeReference<ArrayList<Long>> ref = new ParameterizedTypeReference<ArrayList<Long>>() {};
		ResponseEntity<ArrayList<Long>> rtn = template.exchange(uri, HttpMethod.GET, new HttpEntity<>(null), ref);
		return rtn.getBody();
	}

	public Long selectDepIdByUserId (Long userId){
		String uri = authURI + "/brain/selectDepIdByUserId?userId="+userId;
		ParameterizedTypeReference<Long> ref = new ParameterizedTypeReference<Long>() {};
		ResponseEntity<Long> rtn = template.exchange(uri, HttpMethod.GET, new HttpEntity<>(null), ref);
		return rtn.getBody();
	}

	public String getAuthURI() {
		return authURI;
	}

	public void setAuthURI(String authURI) {
		this.authURI = authURI;
	}

	@Override
	public void setEnvironment(Environment environment) {
		authURI = environment.getProperty("authURI");
		System.out.println("authURI:" + authURI );
	}
	
	public Object checkUserExists(String nickName) {
		String uri = authURI + "/user/isExitUser";
		Map<String, String> urlVariables = new HashMap<>();
		nickName = PWDUtils.decodePasswordByBase64(nickName);
		urlVariables.put("userName", nickName);
		if(logger.isDebugEnabled())
		{
			logger.debug(String.format("Request URI:%s, Params:%s", uri, urlVariables));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> request = new HttpEntity<>(urlVariables, headers);
		ResponseEntity<Object> rtn = template.postForEntity(uri, request, Object.class);
		return rtn.getBody();
	}
	

}
