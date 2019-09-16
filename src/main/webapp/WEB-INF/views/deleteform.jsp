<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.itcen.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.co.itcen.guestbook.vo.GuestbookVo" %>
<%
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<h2>방명록을 삭제하시려면 비밀번호 입력 후 확인 버튼을 눌러주세요.</h2>
	<br/>
	<form method="post" action="<%=request.getContextPath()%>/gb">
	<input type='hidden' name="a" value="delete">
	<input type='hidden' name="no" value="<%=no %>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="<%=request.getContextPath() %>/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>