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
	<tr><td>id</td><td>moduleName</td><td>moduleLinkUrl</td><td>moduleIcon</td><td>sort</td><td>moduleController</td><td>isLeaf</td><td>isMenu</td><td>parentID</td><td>createDate</td><td>status</td></tr>	
	<c:forEach items="${list}" var="vo">
	<tr>
	<td>${vo.id }</td>
	<td>${vo.moduleName }</td>
	<td>${vo.moduleLinkUrl }</td>
	<td>${vo.moduleIcon }</td>
	<td>${vo.sort }</td>
	<td>${vo.moduleController }</td>
	<td>${vo.isLeaf }</td>
	<td>${vo.isMenu }</td>
	<td>${vo.parentID }</td>
	<td>${vo.createDate }</td>
	<td>${vo.status }</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="/template/common/page.jsp" %>
</body>
</html>