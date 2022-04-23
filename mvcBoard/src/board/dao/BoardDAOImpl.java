package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	
	Connection con;  			
	PreparedStatement ps;		
	ResultSet rs;					
	
	static DataSource ds;
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			ds = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(NamingException e) {
			System.err.println("Connection 설정시 오류 발생!!");
			e.printStackTrace();
		}
	}
	protected List<BoardDTO> makeList(ResultSet rs) throws SQLException {
		List<BoardDTO> list = new ArrayList<>();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			list.add(dto);
		}
		return list;
	}
	@Override
	public List<BoardDTO> listBoard() {
		try {
		con = ds.getConnection();
		String sql = "select * from board order by num desc";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		List<BoardDTO> list = makeList(rs);
		return list;
	}catch(SQLException e) {
		System.out.println("list 메소드 실행 중 오류 발생!!");
		e.printStackTrace();
	}finally {
		try {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}catch(SQLException e) {}
	}
		return null;
}
	protected void plusReadcount(int num) {
		try {
			con = ds.getConnection();
			String sql = "update board set readcount = readcount  + 1 where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("plusReadcount 메소드 실행 중 오류 발생!");
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch(SQLException e) {}
		}
	}
	@Override
	public BoardDTO getBoard(int num, String mode) {
		if(mode.equals("content")) {
				plusReadcount(num);
		}
		try {
			con = ds.getConnection();
			String sql = "select * from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list.get(0);
		}catch(SQLException e) {
			System.out.println("getBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch(SQLException e) {}
		}
		return null;
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		try {
			con = ds.getConnection();
			String sql = "insert into board values(board_seq.nextval, ?,?,?,?,sysdate,0,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insert 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}

	protected boolean isPassword(int num, String passwd) {
		BoardDTO dto = getBoard(num, "password");
		if (dto.getPasswd().equals(passwd)) {
			return true;
		}
		return false;
	}
	@Override
	public int deleteBoard(int num, String passwd) {
		if(!isPassword(num, passwd)) { // 비밀번호가 틀렸다면!!
			return -1;
			
		}
		try {
			con = ds.getConnection();
			String sql = "delete from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("delete 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		if(!isPassword(dto.getNum(), dto.getPasswd())) {
			return -1;
		}
		try {
			con = ds.getConnection();
			String sql = "update board set writer=?, email=?, subject=?, content=?, ip=? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getIp());
			ps.setInt(6, dto.getNum());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("update 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}

}
