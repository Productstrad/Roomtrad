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
<form action="/trade_permission/addpost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" /></td></tr>
		<tr><td>permissionAction</td><td><input name="permissionAction" id="permissionAction" type="text" /></td></tr>
		<tr><td>permissionName</td><td><input name="permissionName" id="permissionName" type="text" /></td></tr>
		<tr><td>sort</td><td><input name="sort" id="sort" type="text" /></td></tr>
		<tr><td>script</td><td><input name="script" id="script" type="text" /></td></tr>
		<tr><td>icon</td><td><input name="icon" id="icon" type="text" /></td></tr>
		<tr><td>permissionController</td><td><input name="permissionController" id="permissionController" type="text" /></td></tr>
		<tr><td>description</td><td><input name="description" id="description" type="text" /></td></tr>
		<tr><td>isButton</td><td><input name="isButton" id="isButton" type="text" /></td></tr>
		<tr><td>parentID</td><td><input name="parentID" id="parentID" type="text" /></td></tr>
		<tr><td>createDate</td><td><input name="createDate" id="createDate" type="text" /></td></tr>
		<tr><td>trad_Permissioncol</td><td><input name="trad_Permissioncol" id="trad_Permissioncol" type="text" /></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" /></td></tr>		
		<tr><td colspan="2"><input type="submit" value="新 增" /></td></tr>
	</table>
</form>
</body>
</html>