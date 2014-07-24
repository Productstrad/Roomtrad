<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr><td>id</td><td>favoriteTitle</td><td>favoriteContent</td><td>favoriteAddTime</td><td>userID</td><td>url</td><td>icon</td><td>status</td></tr>	
	<c:forEach items="${list}" var="vo">
	<tr>
	<td>${vo.id }</td>
	<td>${vo.favoriteTitle }</td>
	<td>${vo.favoriteContent }</td>
	<td>${vo.favoriteAddTime }</td>
	<td>${vo.userID }</td>
	<td>${vo.url }</td>
	<td>${vo.icon }</td>
	<td>${vo.status }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>