package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int index = Integer.parseInt(req.getParameter("index"));

			MemberService service = new MemberServiceImpl();
			boolean result = service.deleteMember(index);

			HttpSession session  = req.getSession();
			String message = null;
			
			if(result) message = "탈퇴 되었습니다";
			else	   message = "탈퇴 실패";
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/selectList");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}
