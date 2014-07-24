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
<form action="/trade_user/addpost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" /></td></tr>
		<tr><td>userName</td><td><input name="userName" id="userName" type="text" /></td></tr>
		<tr><td>passWord</td><td><input name="passWord" id="passWord" type="text" /></td></tr>
		<tr><td>trueName</td><td><input name="trueName" id="trueName" type="text" /></td></tr>
		<tr><td>telePhone</td><td><input name="telePhone" id="telePhone" type="text" /></td></tr>
		<tr><td>mobileTel</td><td><input name="mobileTel" id="mobileTel" type="text" /></td></tr>
		<tr><td>email</td><td><input name="email" id="email" type="text" /></td></tr>
		<tr><td>levelType</td><td><input name="levelType" id="levelType" type="text" /></td></tr>
		<tr><td>sex</td><td><input name="sex" id="sex" type="text" /></td></tr>
		<tr><td>idcard</td><td><input name="idcard" id="idcard" type="text" /></td></tr>
		<tr><td>playType</td><td><input name="playType" id="playType" type="text" /></td></tr>
		<tr><td>createdDate</td><td><input name="createdDate" id="createdDate" type="text" /></td></tr>
		<tr><td>departid</td><td><input name="departid" id="departid" type="text" /></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" /></td></tr>		
		<tr><td colspan="2"><input type="submit" value="新 增" /></td></tr>
	</table>
</form>
</body>
</html>