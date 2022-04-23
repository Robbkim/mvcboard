<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeForm.jsp -->
<html>
<head>
	<title>글쓰기</title>
</head>
<body>
	<div align="center">
		<form name="f" action="writePro.board" method="post">
			<table border="1" width="500">
				<tr bgcolor="yellow">
					<td align="center" colspan="2">
						글 쓰 기
					</td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">이 름</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">제 목</td>
					<td><input type="text" name="subject" size="50"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">Email</td>
					<td><input type="text" name="email" size="50"></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">내 용</td>
					<td><textarea name="content" rows="11" cols="50"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="yellow" width="20%" align="center">비밀번호</td>
					<td><input type="password" name="password"></td> 
				</tr>
				<tr>
					<td bgcolor="yellow" colspan="3" align="center">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" onclick="window.location='list.board'">
					<td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>