<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑</title>
</head>

<body>
<div align="center">
<form action="updatepost.do" method="post" name="myfrom">
<table align="center" border="0">
<tr><td align="center" colspan="2"><font size="+4">编辑</font></td></tr>
<tr><td>收藏id:</td><td><input name="favoriteID_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>标题:</td><td><input name="favoriteTitle_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>添加时间:</td><td><input name="favoriteAddTime_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>收藏内容:</td><td><input name="favoriteContent_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>用户id:</td><td><input name="userID_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>url地址:</td><td><input name="url_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>图标地址:</td><td><input name="icon_set" type="text" size="60" maxlength="50" value="" /></td></tr>
	
<tr>
	<td colspan="2" align="center">
		<input name="submit" type="submit" value="保存" />
	</td>
</tr>
</table>
</form>
</div>
</body>
</html>