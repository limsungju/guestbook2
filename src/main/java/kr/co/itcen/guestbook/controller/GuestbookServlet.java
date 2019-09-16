package kr.co.itcen.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.itcen.guestbook.dao.GuestbookDao;
import kr.co.itcen.guestbook.vo.GuestbookVo;

public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("a");
		if ("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("contents");

			GuestbookVo guesetVo = new GuestbookVo();
			guesetVo.setName(name);
			guesetVo.setPassword(password);
			guesetVo.setContents(contents);

			new GuestbookDao().insert(guesetVo);

			response.sendRedirect(request.getContextPath() + "/gb");

		} else if ("deleteform".equals(action)) {
			
			// forwarding
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		} else if ("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			GuestbookVo guestVo = new GuestbookVo();
			guestVo.setNo(Long.parseLong(no));
			guestVo.setPassword(password);
			
			new GuestbookDao().delete(guestVo);
			
			response.sendRedirect(request.getContextPath() + "/gb");
		} else {
			/* index(list) */
			List<GuestbookVo> list = new GuestbookDao().getList();
			request.setAttribute("list", list);

			// forwarding
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
