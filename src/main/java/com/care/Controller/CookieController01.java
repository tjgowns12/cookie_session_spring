package com.care.Controller;

import javax.jws.WebParam.Mode;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController01 {
	@RequestMapping("popup")
	public String pop() {
		
		return "popup";
	}
	
	@RequestMapping("cook")
	public String myCookie(HttpServletResponse response, Model model,
			@CookieValue(value="myCookie",required=false) Cookie cook){
		if(cook != null )
			model.addAttribute("cook",cook.getValue());
		
		Cookie cookie = new Cookie("myCookie","쿠키생성");
		cookie.setMaxAge(5);
		response.addCookie(cookie);
		
		System.out.println(cook);
		return "cookie";
	}
	
}
