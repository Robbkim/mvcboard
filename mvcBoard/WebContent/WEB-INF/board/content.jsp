<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!-- content.jsp -->
<html>
<head>
	<title>�۳��뺸��</title>
</head>
<body>
	<div align="center">
		<b>�۳��� ����</b>
		<table border="1" width="600">
			<tr>
				<th bgcolor="yellow" width="20%">�۹�ȣ</th>
				<td>${getBoard.num}</td> <!-- getBoard�� ����� ��ü�� getNum()�޼ҵ� ȣ�� -->
				<th bgcolor="yellow" width="20%">��ȸ��</th>
				<td>${getBoard.readcount }</td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td>${getBoard.writer}</td>
				<th bgcolor="yellow" width="20%">�ۼ���</th>
				<td>${getBoard.reg_date}</td>
			<tr>
				<th bgcolor="yellow" width="20%">������</th>
				<td colspan="3">${getBoard.subject}</td>
			</tr>	
			<tr>	
				<th bgcolor="yellow" width="20%">�۳���</th>
				<td colspan="3">${getBoard.content}</td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan="4" align="right">
					<input type="button" value="�ۼ���" onclick="window.location='updateForm.board?num=${getBoard.num}'">
					<input type="button" value="�ۻ���" onclick="window.location='deleteForm.board?num=${getBoard.num}'">
					<input type="button" value="�۸��" onclick="window.location='list.board'">
				</td>
		</table>
	</div>
</body>
</html>