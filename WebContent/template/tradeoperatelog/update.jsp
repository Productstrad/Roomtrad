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
<tr><td>日志ID:</td><td><input name="iD_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>应用名:</td><td><input name="processName_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>应用描述:</td><td><input name="processDesc_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>方法名:</td><td><input name="methodName_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>用户id:</td><td><input name="userID_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>用户名称:</td><td><input name="userName_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>ip地址:</td><td><input name="iPAddress_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>操作描述:</td><td><input name="description_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>创建时间:</td><td><input name="createDate_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>方法描述:</td><td><input name="methodDesc_set" type="text" size="60" maxlength="50" value="" /></td></tr>
	
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