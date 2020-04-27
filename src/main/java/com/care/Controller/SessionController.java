package com.care.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@RequestMapping("/session/makeSession")
	public String makeSession(HttpServletRequest request) {
		//reqest를 통해 세션을 받아오지만, 25번 라인처럼 그냥 바로 생성 가능
		HttpSession session = request.getSession();
		//세션 만드는 방법이 2가지 있다.
		session.setAttribute("id", "홍길동");
		session.setAttribute("age", "20");
		session.setAttribute("addr", "산골짜기");
		return "/session/makeSession";
	}
	@RequestMapping("/session/resultSession")
	public String resultSession() {return "/session/resultSession";}
	
	@RequestMapping("/session/delSession")
	public String delSession(HttpSession session) {
		session.removeAttribute("id");
		//session.invalidate();
		return "/session/delSession";
	}
}
