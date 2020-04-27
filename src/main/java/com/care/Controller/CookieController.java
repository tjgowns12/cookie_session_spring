package com.care.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("cookie")
	public String myCookie(HttpServletResponse response,
			@CookieValue(value="myCookie",required = false)Cookie cook,
			//required = false 해당하는 값이 있으면 넣어주고 없으면 그냥 진행하라는 뜻	
			HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c:cookies)
				System.out.println(c.getName()+":"+c.getValue());
		}
		
		
		System.out.println("cook:"+cook);
		Cookie cookie = new Cookie("myCookie", "쿠키생성");
		//name과 value 설정
		cookie.setMaxAge(5);
		//5초가 지나면 쿠키가 사라짐
		response.addCookie(cookie);
		//쿠키 셋팅
		return "cookie";
	}
	
}
