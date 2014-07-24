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
<form action="/trade_department/updatepost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" value="${vo.id }"/></td></tr>
		<tr><td>deptName</td><td><input name="deptName" id="deptName" type="text" value="${vo.deptName }"/></td></tr>
		<tr><td>deptDescription</td><td><input name="deptDescription" id="deptDescription" type="text" value="${vo.deptDescription }"/></td></tr>
		<tr><td>parentID</td><td><input name="parentID" id="parentID" type="text" value="${vo.parentID }"/></td></tr>
		<tr><td>createDate</td><td><input name="createDate" id="createDate" type="text" value="${vo.createDate }"/></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" value="${vo.status }"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="修 改" /></td></tr>
	</table>
</form>
</body>
</html>