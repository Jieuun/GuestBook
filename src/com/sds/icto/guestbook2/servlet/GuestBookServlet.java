package com.sds.icto.guestbook2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook2.action.IndexAction;
import com.sds.icto.web.Action;
import com.sds.icto.web.AddAction;
import com.sds.icto.web.DeleteAction;

/**
 * Servlet implementation class GuestBookServlet
 */
@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			String a = request.getParameter("a");

			Action action = null;

			if ("add".equals(a)) {
				action = new AddAction();
				action.execute(request, response);
			} else if ("delete".equals(a)) {
				action = new DeleteAction();
				action.execute(request, response);
			}
			if (action == null) {
				action = new IndexAction();
				action.execute(request, response);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
