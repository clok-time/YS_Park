package com.park.project2.movie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class MovieRankDAO {
	public void movieRankSearch(HttpServletRequest req) {
		String search = req.getParameter("movieDate");
		
		
	}
}
