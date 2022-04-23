package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

public class ContentCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao =new BoardDAOImpl();
		String num = req.getParameter("num");
		BoardDTO dto = dao.getBoard(Integer.parseInt(num), "content");
		req.setAttribute("getBoard", dto);
		return "WEB-INF/board/content.jsp";

	}

}
