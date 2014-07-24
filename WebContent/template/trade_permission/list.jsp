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
	<tr><td>id</td><td>permissionAction</td><td>permissionName</td><td>sort</td><td>script</td><td>icon</td><td>permissionController</td><td>description</td><td>isButton</td><td>parentID</td><td>createDate</td><td>trad_Permissioncol</td><td>status</td></tr>	
	<c:forEach items="${list}" var="vo">
	<tr>
	<td>${vo.id }</td>
	<td>${vo.permissionAction }</td>
	<td>${vo.permissionName }</td>
	<td>${vo.sort }</td>
	<td>${vo.script }</td>
	<td>${vo.icon }</td>
	<td>${vo.permissionController }</td>
	<td>${vo.description }</td>
	<td>${vo.isButton }</td>
	<td>${vo.parentID }</td>
	<td>${vo.createDate }</td>
	<td>${vo.trad_Permissioncol }</td>
	<td>${vo.status }</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="/template/common/page.jsp" %>
</body>
</html>