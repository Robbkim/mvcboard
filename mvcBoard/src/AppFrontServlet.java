import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppFrontServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String uri = req.getRequestURI();
		String path =req.getContextPath();
		String cmd = uri.substring(path.length()); //cmd���� �ּҷ� ���ϱ�
		//PrintWriter pw = resp.getWriter();
		//pw.println("<h2>uri =" + uri + "</h2>");
		//pw.println("<h2>path =" + path + "</h2>"); //path ������� �Ҷ� ����
		//pw.println("<h2>cmd =" + cmd + "</h2>");
		String nextPage = null;
		switch(cmd) {
		case "/member.do" : nextPage = "index.mem"; break; //member�� �����ϴ� servlet
		case "/login.do" :	  nextPage = path + "/login/login.jsp"; break; //login page�� �̵�
		case "/shop.do" :	  nextPage = "mail.shop"; break;	// ���θ��� �����ϴ� servlet���� �̵�
		case "/board.do" : 	  nextPage = "list.board"; break;	// �Խ����� �����ϴ� servlet���� �̵�
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}
