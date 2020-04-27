package com.care.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("login")
	public String loginGet() {
		return "login/login";
	}
	
	@PostMapping("chkUser")
	public String chkUser(HttpServletRequest request) {
		String id="1",pwd="1",nickName="홍길동";
		String reqId=request.getParameter("id");
		String reqPwd=request.getParameter("pwd");
		HttpSession session=null;
		if(id.equals(reqId)&&pwd.equals(reqPwd)){
			session=request.getSession();
			session.setAttribute("loginUser", nickName);
			return "login/main";
			
		}else {return "redirect:login";}
		
	}
//	@GetMapping("logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "login/logout";
//	}

}
