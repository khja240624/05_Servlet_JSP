package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;
import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectList")
public class SelectListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			MemberService service = new MemberServiceImpl();
			List<Member> memberList = service.getMemberList();
			
			req.setAttribute("memberList", memberList);
			
			String path = "/WEB-INF/views/selectList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
