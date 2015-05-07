package com.sds.icto.guestbook2.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException,
			ServletException {
	
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.fetchlist();
		request.setAttribute("list", list);
		WebUtil.forward("/view/index.jsp", request, response);
		
		
		

	}

}
