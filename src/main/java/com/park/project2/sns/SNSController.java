package com.park.project2.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.park.project2.TokenMaker;
import com.park.project2.Member.MemberDAO;

@Controller
public class SNSController {
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO sDAO;
	
	private boolean isFirstReq;
	
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (isFirstReq) {
			sDAO.countAllMsg();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		sDAO.searchClear(req);
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String snsDelete(SNSMsg sm, HttpServletRequest req) {
		if(mDAO.loginCheck(req)) {
			sDAO.deleteMsg(sm, req);
		}
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String snsPageChange(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		sDAO.getMsg(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			sDAO.deleteReply(sr, req);
		}
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	
	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.POST )
	public String snsReplyWrite(SNSReply sr, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			sDAO.writeReply(sr, req);
		}
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/sns.search", method = RequestMethod.POST)
	public String snsSearch(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		sDAO.searchMsg(req);
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String snsUpdate(SNSMsg sm,HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			sDAO.updateMsg(sm, req);
		}
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/sns.write", method = RequestMethod.POST)
	public String snsWrite(SNSMsg sm,HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			sDAO.writeMsg(sm, req);
			}
		sDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return"index";
	}
	
	
	
}
