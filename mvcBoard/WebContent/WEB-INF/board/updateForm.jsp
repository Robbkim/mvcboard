<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.dto.*"%>
<!-- updateForm.jsp -->
<html>
<head>
	<title>�ۼ���</title>
</head>
<body>
	<div align="center">
		<form name="f" action="updatePro.board" method="post">
			<input type="hidden" name="num" value="${getBoard.num}"/>
			<table border="1" width="500">
				<tr bgcolor="yellow">
					<td align="center" colspan="2">
						�� �� ��
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">�� ��</td>
					<td><input type="text" name="writer" value="${getBoard.writer}"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">�� ��</td>
					<td><input type="text" name="subject" size="50" value="${getBoard.subject}"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">Email</td>
					<td><input type="text" name="email" size="50" value="${getBoard.email}"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">�� ��</td>
					<td><textarea name="content" rows="11" cols="50" >${getBoard.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">��й�ȣ</td>
					<td><input type="password" name="password"></td> 
				</tr>
				<tr>
					<td bgcolor="yellow" colspan="3" align="center">
						<input type="submit" value="�ۼ���">
						<input type="reset" value="�ٽ��ۼ�">
						<input type="button" value="��Ϻ���" onclick="window.location='list.board'">
					<td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>