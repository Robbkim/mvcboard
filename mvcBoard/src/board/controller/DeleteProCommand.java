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
		if(res>0) { // ���� ����!!
			msg = "�ۻ��� ����!! �۸���������� �̵��մϴ�.";
			url = "list.board";
		}else if(res<0) {	// ��й�ȣ�� Ʋ�ȴ�!!
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!";
			url = "deleteForm.board?num=" + num;
		}else { //��й�ȣ�� ������ , ������ ����!!
			msg = "�ۻ��� ����!! �۳��뺸�� �������� �̵��մϴ�.";
			url = "content.board?num=" +num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
