package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

public class UpdateProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAOImpl();
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		
		int res = dao.updateBoard(dto);
		String msg = null, url = null;
		if(res>0) { // 삭제 성공!!
			msg = "글수정 성공!! 글목록페이지로 이동합니다.";
			url = "list.board";
		}else if(res<0) {	// 비밀번호가 틀렸다!!
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요!!";
			url = "updateForm.board?num=" + dto.getNum();
		}else { //비밀번호는 맞으나 , 삭제엔 실패!!
			msg = "글삭제 실패!! 글내용보기 페이지로 이동합니다.";
			url = "content.board?num=" +dto.getNum();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
