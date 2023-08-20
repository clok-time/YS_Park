package com.park.project2.Member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	@Autowired
	SqlSession ss;
	
	public Members memberIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}
	
	public void login(Member inputM, HttpServletRequest req) {
		try {
			List<Member> dbms = ss.getMapper(MemberMapper.class).getMemberById(inputM);
					if (dbms.size()!=0) {//불러오는데 성공 - 일치하는 id 있음
						Member dbM = dbms.get(0);
						for (Member mm : dbms) {
							System.out.println(mm);
						}
						if (dbM.getP_pw().equals(inputM.getP_pw())) { // pw 일치시
							req.getSession().setAttribute("loginMember", dbM); // loginMember Session에 정보 저장
							req.getSession().setMaxInactiveInterval(60*60); //session 유지 시간
							req.setAttribute("r", "로그인 성공");
						}else {
							req.setAttribute("r", "로그인 실패(PW오류)");
						}
					}else {
						req.setAttribute("r", "로그인 실패(미가입ID)");
						
					}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "로그인 실패(DB오류)");
		}
	}
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember"); //세션에서 정보 가져오기
		if (m!= null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		}else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	//logOut
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	public void join(Member m,HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img"); //파일 경로 체크
			
			MultipartRequest mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			m.setP_id(mr.getParameter("p_id"));
			m.setP_pw(mr.getParameter("p_pw"));
			m.setP_name(mr.getParameter("p_name"));
			
			//주소 합치기
			String p_addr1 = mr.getParameter("p_addr1");//우편번호
			String p_addr2 = mr.getParameter("p_addr2");//주소
			String p_addr3 = mr.getParameter("p_addr3");//세부주소
			String p_addr = p_addr1 + "%" +p_addr2 + "%"+p_addr3;
			m.setP_addr(p_addr);
			
			String p_photo = mr.getFilesystemName("p_photo");
			String p_photo_kor = URLEncoder.encode(p_photo, "utf-8").replace("+"," "); // 한글 인코딩
			m.setP_photo(p_photo_kor);
			m.setP_role("회");
			if (ss.getMapper(MemberMapper.class).join(m)==1) { //interface에서 int로 설정한 이유
				//정보가 들어오면 1
				req.setAttribute("r", "가입성공");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "가입실패");
		}
	}

	//주소 나누기
	public void divideAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getP_addr();
		String [] addr2 = addr.split("%");
		req.setAttribute("addr", addr2);
	}
	
	//update
	//파일 안 넣으면 그대로 / 
	public void update(Member m, HttpServletRequest req) {
		//파일 용량:10mb / 이상 > 실패
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10*1024* 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "수정실패(파일 용량초과)");
			return;
		}
		
		//현재 로그인 된 회원 정보 불러오기
		Member lm = (Member) req.getSession().getAttribute("loginMember");
		
		//기존 사진 파일명
		String oldFile = lm.getP_photo();
		
		//새 파일명
		String newFile = mr.getFilesystemName("p_photo");
		
		try {
			String dm_id = mr.getParameter("p_id");
			String dm_pw = mr.getParameter("p_pw");
			String dm_name = mr.getParameter("p_name");
			String dm_addr1 = mr.getParameter("p_addr1");
			String dm_addr2 = mr.getParameter("p_addr2");
			String dm_addr3 = mr.getParameter("p_addr3");
			
			if (newFile == null) { // 사진 수정안하는 경우
				 newFile = oldFile;
			}else {//수정
				newFile = URLEncoder.encode(newFile,"utf-8");
				newFile = newFile.replace("+", " ");
			}
			m.setP_id(dm_id);
			m.setP_pw(dm_pw);
			m.setP_name(dm_name);
			m.setP_addr(dm_addr1+"%"+dm_addr2+"%"+dm_addr3);
			m.setP_photo(newFile);
			
			//DB 수정
			if (ss.getMapper(MemberMapper.class).update(m)==1) {
				req.setAttribute("r", "수정성공");
			//사이트 반영
				req.getSession().setAttribute("loginMember", m);
				
				//프사 바꾸는 상황: 옛날 사진 지우기
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile,"utf-8");
					new File(path + "/" + oldFile).delete();
				}
			}else {
				req.setAttribute("r", "수정실패");
				
				//프사 바꾸는 상황 / 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/"+ newFile).delete();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "수정실패");
			
			// 프사 바꾸는 상황 : 새 프사 지우기
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		
		}
	}
	
	//탈퇴
	public void signOut(HttpServletRequest req) {
		try {
			Member m =(Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).signOut(m)==1) { //변화O
				req.setAttribute("r", "탈퇴성공");
				String dm_photo = m.getP_photo();
				dm_photo = URLDecoder.decode(dm_photo, "utf-8");
				
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				new File(path+"/"+dm_photo).delete(); // 사진 파일 삭제
			}else {
				req.setAttribute("r", "탈퇴 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "탈퇴실패");
		}
	}
}
