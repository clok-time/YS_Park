package com.park.project2.movie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.park.project2.Member.MemberDAO;

@Controller
public class MovieController {
	@Autowired
	MemberDAO mDAO;
	@RequestMapping(value = "/movie.go", method = RequestMethod.GET)
	public String goMovieRank(HttpServletRequest req) {
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "movie/movieRank.jsp");
		
		return"index";
	}
	@RequestMapping(value = "/movie.rank", method = RequestMethod.GET)
	public String movieRank(HttpServletRequest req) {
		mDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "movie/movieRank.jsp");
		
		return"index";
	}
}
