package com.care.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	@RequestMapping("log")
	public String log(@CookieValue(value="myCookie",required=false) Cookie cook,Model model) {
		if(cook != null)
		model.addAttribute("cook",cook.getName());
		return "Quiz/login";
	}
	
	
	@RequestMapping("chk")
	public String chkUser(HttpServletRequest request) {
		String id="test" ,pwd="123", nickName="홍길동";
		String reId=request.getParameter("id");
		String rePwd=request.getParameter("pwd");
		HttpSession session=null;				
		if(id.equals(reId)&&pwd.equals(rePwd)) {
			
			session=request.getSession();
			session.setAttribute("user", nickName);		
			return "Quiz/main";
			
		}else {return "redirect:login";}
	}
	@RequestMapping("out")
	public String out(HttpSession session) {
		session.invalidate();		
		return "redirect:log";
	}
	
	@RequestMapping("Mcook")
	public String myCookie(HttpServletResponse response,Model model
			){
		
		Cookie cookie = new Cookie("myCookie","쿠키생성");
		cookie.setPath("/");
		response.addCookie(cookie);
		//model.addAttribute(cookie.getName());
		model.addAttribute("cook",cookie.getName());
		
		
		
		System.out.println(cookie.getName());
		return "Quiz/close_pop";
	}
	@RequestMapping("pop")
	public String pop() {
		return "Quiz/popup";
	}
	
}
