<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- deleteForm.jsp -->
<html>
<head>
	<title>�ۻ���</title>
</head>
<body>
	<div align="center">
		<b>�ۻ���</b>
		<form name="f" action="deletePro.board" method="post">
			<input type="hidden" name="num" value="${param.num}"/>
			<table border="1" width="300">
				<tr bgcolor="yellow">
					<th>��й�ȣ�� �Է����ּ���</th>
				</tr>
				<tr>
					<td align="center">��й�ȣ : <input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td align="center">
						<input type="submit" value="�ۻ���">
						<input type="button" value="�۸��" onclick="window.location='list.board'">
					</td>
				</tr>
			</table>
		</form>
 	</div>
 </body>
 </html>