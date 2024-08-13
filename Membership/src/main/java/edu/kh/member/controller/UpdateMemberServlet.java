package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.dto.Member;
import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update/member")
public class UpdateMemberServlet extends HttpServlet{
	
	// 회원 정보 수정 화면 응답
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int index = Integer.parseInt(req.getParameter("index"));
			
			MemberService service = new MemberServiceImpl();
			Member member = service.getMember(index);
			
			req.setAttribute("member", member);
			
			String path = "/WEB-INF/views/updateMember.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 회원 정보 수정 후 redirect
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int index = Integer.parseInt(req.getParameter("index"));
			String phone = req.getParameter("phone");
			
			MemberService service = new MemberServiceImpl();
			boolean result = service.updateMember(index, phone);
			
			HttpSession session = req.getSession();
			session.setAttribute("messge", "회원 정보 수정 성공");
			
			resp.sendRedirect("/selectList");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
