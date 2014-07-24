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
<form action="/trade_module/updatepost.do" method="post">
	<table>
		<tr><td>id</td><td><input name="id" id="id" type="text" value="${vo.id }"/></td></tr>
		<tr><td>moduleName</td><td><input name="moduleName" id="moduleName" type="text" value="${vo.moduleName }"/></td></tr>
		<tr><td>moduleLinkUrl</td><td><input name="moduleLinkUrl" id="moduleLinkUrl" type="text" value="${vo.moduleLinkUrl }"/></td></tr>
		<tr><td>moduleIcon</td><td><input name="moduleIcon" id="moduleIcon" type="text" value="${vo.moduleIcon }"/></td></tr>
		<tr><td>sort</td><td><input name="sort" id="sort" type="text" value="${vo.sort }"/></td></tr>
		<tr><td>moduleController</td><td><input name="moduleController" id="moduleController" type="text" value="${vo.moduleController }"/></td></tr>
		<tr><td>isLeaf</td><td><input name="isLeaf" id="isLeaf" type="text" value="${vo.isLeaf }"/></td></tr>
		<tr><td>isMenu</td><td><input name="isMenu" id="isMenu" type="text" value="${vo.isMenu }"/></td></tr>
		<tr><td>parentID</td><td><input name="parentID" id="parentID" type="text" value="${vo.parentID }"/></td></tr>
		<tr><td>createDate</td><td><input name="createDate" id="createDate" type="text" value="${vo.createDate }"/></td></tr>
		<tr><td>status</td><td><input name="status" id="status" type="text" value="${vo.status }"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="修 改" /></td></tr>
	</table>
</form>
</body>
</html>