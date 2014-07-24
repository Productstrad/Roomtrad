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
	<tr><td>id</td><td>userName</td><td>passWord</td><td>trueName</td><td>telePhone</td><td>mobileTel</td><td>email</td><td>levelType</td><td>sex</td><td>idcard</td><td>playType</td><td>createdDate</td><td>departid</td><td>status</td></tr>	
	<c:forEach items="${list}" var="vo">
	<tr>
	<td>${vo.id }</td>
	<td>${vo.userName }</td>
	<td>${vo.passWord }</td>
	<td>${vo.trueName }</td>
	<td>${vo.telePhone }</td>
	<td>${vo.mobileTel }</td>
	<td>${vo.email }</td>
	<td>${vo.levelType }</td>
	<td>${vo.sex }</td>
	<td>${vo.idcard }</td>
	<td>${vo.playType }</td>
	<td>${vo.createdDate }</td>
	<td>${vo.departid }</td>
	<td>${vo.status }</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="/template/common/page.jsp" %>
</body>
</html>