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
<form action="/trade_role/addpost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" /></td></tr>
		<tr><td>roleno</td><td><input name="roleno" id="roleno" type="text" /></td></tr>
		<tr><td>roleName</td><td><input name="roleName" id="roleName" type="text" /></td></tr>
		<tr><td>description</td><td><input name="description" id="description" type="text" /></td></tr>
		<tr><td>sort</td><td><input name="sort" id="sort" type="text" /></td></tr>
		<tr><td>createDate</td><td><input name="createDate" id="createDate" type="text" /></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" /></td></tr>		
		<tr><td colspan="2"><input type="submit" value="新 增" /></td></tr>
	</table>
</form>
</body>
</html>