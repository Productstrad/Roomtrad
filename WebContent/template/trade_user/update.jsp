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
<form action="/trade_user/updatepost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" value="${vo.id }"/></td></tr>
		<tr><td>userName</td><td><input name="userName" id="userName" type="text" value="${vo.userName }"/></td></tr>
		<tr><td>passWord</td><td><input name="passWord" id="passWord" type="text" value="${vo.passWord }"/></td></tr>
		<tr><td>trueName</td><td><input name="trueName" id="trueName" type="text" value="${vo.trueName }"/></td></tr>
		<tr><td>telePhone</td><td><input name="telePhone" id="telePhone" type="text" value="${vo.telePhone }"/></td></tr>
		<tr><td>mobileTel</td><td><input name="mobileTel" id="mobileTel" type="text" value="${vo.mobileTel }"/></td></tr>
		<tr><td>email</td><td><input name="email" id="email" type="text" value="${vo.email }"/></td></tr>
		<tr><td>levelType</td><td><input name="levelType" id="levelType" type="text" value="${vo.levelType }"/></td></tr>
		<tr><td>sex</td><td><input name="sex" id="sex" type="text" value="${vo.sex }"/></td></tr>
		<tr><td>idcard</td><td><input name="idcard" id="idcard" type="text" value="${vo.idcard }"/></td></tr>
		<tr><td>playType</td><td><input name="playType" id="playType" type="text" value="${vo.playType }"/></td></tr>
		<tr><td>createdDate</td><td><input name="createdDate" id="createdDate" type="text" value="${vo.createdDate }"/></td></tr>
		<tr><td>departid</td><td><input name="departid" id="departid" type="text" value="${vo.departid }"/></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" value="${vo.status }"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="修 改" /></td></tr>
	</table>
</form>
</body>
</html>