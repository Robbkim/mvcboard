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
		if(res>0) { // ���� ����!!
			msg = "�ۼ��� ����!! �۸���������� �̵��մϴ�.";
			url = "list.board";
		}else if(res<0) {	// ��й�ȣ�� Ʋ�ȴ�!!
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!";
			url = "updateForm.board?num=" + dto.getNum();
		}else { //��й�ȣ�� ������ , ������ ����!!
			msg = "�ۻ��� ����!! �۳��뺸�� �������� �̵��մϴ�.";
			url = "content.board?num=" +dto.getNum();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
