package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;

public class DeleteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd");
		
		BoardDAO dao = new BoardDAOImpl();
		int res = dao.deleteBoard(Integer.parseInt(num), passwd);
		String msg = null, url = null;
		if(res>0) { // 삭제 성공!!
			msg = "글삭제 성공!! 글목록페이지로 이동합니다.";
			url = "list.board";
		}else if(res<0) {	// 비밀번호가 틀렸다!!
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요!!";
			url = "deleteForm.board?num=" + num;
		}else { //비밀번호는 맞으나 , 삭제엔 실패!!
			msg = "글삭제 실패!! 글내용보기 페이지로 이동합니다.";
			url = "content.board?num=" +num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
