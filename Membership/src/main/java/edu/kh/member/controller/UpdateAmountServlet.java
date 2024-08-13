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

@WebServlet("/update/amount")
public class UpdateAmountServlet extends HttpServlet {

	// 금액 누적 화면 응답
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int index = Integer.parseInt(req.getParameter("index"));

			MemberService service = new MemberServiceImpl();
			Member member = service.getMember(index);

			req.setAttribute("member", member);

			String path = "/WEB-INF/views/updateAmount.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 금액 누적 후 redirect
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int index = Integer.parseInt(req.getParameter("index"));
			int amount = Integer.parseInt(req.getParameter("amount"));

			MemberService service = new MemberServiceImpl();
			int result = service.updateAmount(index, amount);

			HttpSession session = req.getSession();
			String message = null;
			
			switch(result) {
			case 4 : message = "금액이 변경 되었습니다"; break;
			case 0 : message = "등급이 [일반]으로 변경 되었습니다"; break;
			case 1 : message = "등급이 [골드]로 변경 되었습니다"; break;
			case 2 : message = "등급이 [다이아몬드]로 변경 되었습니다"; break;
			}
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/selectList");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
