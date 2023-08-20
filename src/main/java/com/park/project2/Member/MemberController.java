package com.park.project2.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Autowired
	MemberDAO mDAO;

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest req) {
		mDAO.loginCheck(req);//join으로 이동
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.join", method = RequestMethod.POST)
	public String memberJoin(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody Members memberIdCheck(Member m) {
		
		return mDAO.memberIdCheck(m);
	}
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {//로그인한 상태
			//주소 나누기
			mDAO.divideAddr(req);
			req.setAttribute("contentPage", "member/info.jsp");
			
		}else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/member.info", method = RequestMethod.POST)
	public String memberInfo(Member m, HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	//update
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.update(m, req);
			mDAO.divideAddr(req);
			req.setAttribute("contentPage", "home.jsp");
		}else {
			req.setAttribute("contentPage", "info.jsp");
		}
		
		return "index";
	}
	//signout
	@RequestMapping(value = "/member.signout", method = RequestMethod.GET)
	public String memberSignOut(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.signOut(req);
			mDAO.logout(req);
			mDAO.loginCheck(req);
		}else {
			req.setAttribute("contentPage", "info.jsp");
		}
		
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
}
 