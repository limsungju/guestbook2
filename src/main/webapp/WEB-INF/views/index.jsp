<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.itcen.guestbook.dao.GuestbookDao" %>
<%@ page import="kr.co.itcen.guestbook.vo.GuestbookVo" %>
<%@ page import="java.util.List" %>
<%
	List<GuestbookVo> list = new GuestbookDao().getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/gb" method="post">
	<input type='hidden' name='a' value='add'>
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="contents" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" value="등록 "></td>
		</tr>
	</table>
	</form>
	
	<%
		int count = list.size();
		int index = 0;
		for(GuestbookVo guestVo : list) {
	%>
	<br>
		<table width=510 border=1>
			<tr>
				<td><%= count-index++ %></td>
				<td><%= guestVo.getName() %></td>
				<td><%= guestVo.getRegDate() %></td>
				<td><a href="<%=request.getContextPath() %>/gb?a=deleteform&no=<%= guestVo.getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%= guestVo.getContents().replaceAll("\n", "<br>") %></td>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>