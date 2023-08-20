package com.park.project2.sns;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.project2.SiteOption;
import com.park.project2.Member.Member;

@Service
public class SNSDAO {
	@Autowired
	SqlSession ss;
	@Autowired
	SiteOption so;
	private int allMsgCount;
	private String[] colors;

	public SNSDAO() {
		colors = new String[] {"#F44336", "#43A047", "#FF9800", "#795548", "#E91E63", "#009688","#F48FB1"};
	}

	public void countAllMsg() {
		allMsgCount = ss.getMapper(SNSMapper.class).getAllMsgCount();
		System.out.println(allMsgCount);
	}

	public void getMsg(int page, HttpServletRequest req) {
		
		req.setAttribute("curPage", page);
		String search = (String) req.getSession().getAttribute("search"); // 검색어
		int msgCount = 0;
		if (search == null) { // 전체조회
			msgCount = allMsgCount;
			search = "";
		} else {//검색
			SNSSelector sSel2 = new SNSSelector(search, 0, 0);
			msgCount = ss.getMapper(SNSMapper.class).getSearchMsgCount(sSel2);
		}
		int allPageCount = (int) Math.ceil((double) msgCount / so.getSnsMsgPerPage());
		req.setAttribute("allPageCount", allPageCount);

		int start = (page - 1) * so.getSnsMsgPerPage() + 1;
		int end = (page == allPageCount) ? msgCount : start + so.getSnsMsgPerPage() - 1;
		SNSSelector sSel = new SNSSelector(search, start, end);
		List<SNSMsg> snsMsgs = ss.getMapper(SNSMapper.class).getMsg(sSel);
		for (SNSMsg snsMsg : snsMsgs) {
			snsMsg.setP_replys(ss.getMapper(SNSMapper.class).getReply(snsMsg));
			System.out.println(snsMsg.getP_txt());
		}
		req.setAttribute("msgs", snsMsgs);
		
	}

	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", "");
	}

	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}

	public void updateMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).updateMsg(sm) == 1) {
				req.setAttribute("r", "글수정성공");
			} else {
				req.setAttribute("r", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글수정실패");
		}
	}

	public void writeMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
			String token = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글쓰기실패(새로고침)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			sm.setP_owner(m.getP_id());
			sm.setP_color(colors[new Random().nextInt(colors.length)]);
			String txt = sm.getP_txt();
			txt = txt.replace("\r\n", "<br>");
			
			System.out.println("txt테스트"+txt);
			sm.setP_txt(txt);

			if (ss.getMapper(SNSMapper.class).writeMsg(sm) == 1) {
				req.setAttribute("r", "글쓰기성공");
				req.getSession().setAttribute("st", token);
				allMsgCount++;
			} else {
				req.setAttribute("r", "글쓰기실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "글쓰기실패");
		}
	}

	public void writeReply(SNSReply sr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "댓글쓰기실패(새로고침)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setPr_owner(m.getP_id());
			System.out.println(sr.getPr_txt()+"asdasdfasdf");
			if (ss.getMapper(SNSMapper.class).writeReply(sr) == 1) {
				req.setAttribute("r", "댓글쓰기성공");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "댓글쓰기실패");
			}

		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "댓글쓰기실패");
			e.printStackTrace();
		}
	}

	public void deleteMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).deleteMsg(sm) == 1) {
				req.setAttribute("r", "글삭제성공");
				allMsgCount--;
			} else {
				req.setAttribute("r", "글삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글삭제실패");
		}
	}

	public void deleteReply(SNSReply sr, HttpServletRequest req) {
		try {
			System.out.println(sr.getPr_no());
			if (ss.getMapper(SNSMapper.class).deleteReply(sr) == 1) {
				req.setAttribute("r", "댓글삭제성공");
			} else {
				req.setAttribute("r", "댓글삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글삭제실패");
		}
	}
}
