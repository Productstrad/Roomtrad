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
<form action="/trade_favorite/addpost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" /></td></tr>
		<tr><td>favoriteTitle</td><td><input name="favoriteTitle" id="favoriteTitle" type="text" /></td></tr>
		<tr><td>favoriteContent</td><td><input name="favoriteContent" id="favoriteContent" type="text" /></td></tr>
		<tr><td>favoriteAddTime</td><td><input name="favoriteAddTime" id="favoriteAddTime" type="text" /></td></tr>
		<tr><td>userID</td><td><input name="userID" id="userID" type="text" /></td></tr>
		<tr><td>url</td><td><input name="url" id="url" type="text" /></td></tr>
		<tr><td>icon</td><td><input name="icon" id="icon" type="text" /></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" /></td></tr>		
		<tr><td colspan="2"><input type="submit" value="新 增" /></td></tr>
	</table>
</form>
</body>
</html>