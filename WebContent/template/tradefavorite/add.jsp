<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加</title>
</head>
<body>
<div align="center">
<form action="addpost.do" method="post" name="myfrom">
<table align="center" border="0">
	<tr><td align="center" colspan="2"><font size="+4">添加</font></td></tr>
	<tr><td>收藏id:</td><td><input name="favoriteID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>标题:</td><td><input name="favoriteTitle" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>添加时间:</td><td><input name="favoriteAddTime" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>收藏内容:</td><td><input name="favoriteContent" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>用户id:</td><td><input name="userID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>url地址:</td><td><input name="url" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>图标地址:</td><td><input name="icon" type="text" size="60" maxlength="50" /></td></tr>
	
	<tr><td colspan="2" align="center"><input name="submit" type="submit" value="保存" /></td></tr>
</table>
</form>
</div>
</body>
</html>