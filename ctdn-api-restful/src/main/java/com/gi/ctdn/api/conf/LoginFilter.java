package com.gi.ctdn.api.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxyinternet.model.user.User;
import com.gi.ctdn.utils.BeanContextUtils;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements  Filter{

	@Value("${loginUrl}")
	private  String loginUrl;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
	    boolean isFilter = false; //默认不拦截

	    StringRedisTemplate stringRedisTemplate = BeanContextUtils.getBean(StringRedisTemplate.class);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String urlPatterns = BeanContextUtils.getUrlPatterns();
		String reqUrl = req.getRequestURI();
		//System.out.println("filter = " + stringRedisTemplate + " ,reqUrl = " +  reqUrl + " ,urlPatterns = " + urlPatterns);
		if(urlPatterns !=null && urlPatterns.trim().length() !=0){
			String[] includeUrls = urlPatterns.split(",");
			for(String url : includeUrls){
				if(reqUrl.indexOf(url) != -1){ //需要登录
					isFilter = true; //拦截
					break;
				}
			}
		}
		if(!isFilter){
			chain.doFilter(request, response);
			return;
		}
		Cookie[] cookies = req.getCookies();
		String _uid_ = null; // sessionId
		String s_ = null; //来源（ctdn）
		if (cookies != null && cookies.length > 0)
		{
			for (Cookie cookie : cookies)
			{
				String name = cookie.getName();
				if("_uid_".equals(name)){
					_uid_ = cookie.getValue();
					continue;
				}
				if("s_".equals(name)){
					s_ = cookie.getValue();
					continue;
				}
			}
		}
		if(_uid_ != null && _uid_.trim().length()!=0  && s_ !=null && s_.trim().length()!=0 ){
			String key = "ctdn:" + s_ + ":" + _uid_;
			String userJson  = stringRedisTemplate.opsForValue().get(key);
			if(userJson == null){
				//未登录
				try {
					writeLoginMsg(req, res, "用户未登录或已过期,请重新登录");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				chain.doFilter(request, response);
				return;
			}
		}else{
			//未登录
			try {
				writeLoginMsg(req, res, "用户未登录或已过期,请重新登录");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}



	private void writeLoginMsg(HttpServletRequest req, HttpServletResponse res, String msg) throws Exception {
		MessageInfo data = new MessageInfo<>();
		data.setStatus(MessageStatus.NO_LOGIN);
		data.setMessage(MessageStatus.NO_LOGIN_MESSAGE);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(data);
		res.setHeader("Content-type", "application/json;charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(result);
	}

	@Override
	public void destroy() {

	}

}
