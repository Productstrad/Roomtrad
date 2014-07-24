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
<form action="/trade_operatelog/updatepost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" value="${vo.id }"/></td></tr>
		<tr><td>processName</td><td><input name="processName" id="processName" type="text" value="${vo.processName }"/></td></tr>
		<tr><td>processDesc</td><td><input name="processDesc" id="processDesc" type="text" value="${vo.processDesc }"/></td></tr>
		<tr><td>methodName</td><td><input name="methodName" id="methodName" type="text" value="${vo.methodName }"/></td></tr>
		<tr><td>userID</td><td><input name="userID" id="userID" type="text" value="${vo.userID }"/></td></tr>
		<tr><td>userName</td><td><input name="userName" id="userName" type="text" value="${vo.userName }"/></td></tr>
		<tr><td>iPAddress</td><td><input name="iPAddress" id="iPAddress" type="text" value="${vo.iPAddress }"/></td></tr>
		<tr><td>description</td><td><input name="description" id="description" type="text" value="${vo.description }"/></td></tr>
		<tr><td>createDate</td><td><input name="createDate" id="createDate" type="text" value="${vo.createDate }"/></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" value="${vo.status }"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="修 改" /></td></tr>
	</table>
</form>
</body>
</html>