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
	<tr><td>用户id:</td><td><input name="userID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>用户名:</td><td><input name="userName" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>用户口令:</td><td><input name="userPassword" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>角色ID:</td><td><input name="roleID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>部门ID:</td><td><input name="deptID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>联系电话:</td><td><input name="phone" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>传真号码:</td><td><input name="fax" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>email地址:</td><td><input name="email" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>qQ号码:</td><td><input name="qQ" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>昵称:</td><td><input name="nickName" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>地址:</td><td><input name="address" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>真实姓名:</td><td><input name="realName" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>性别:</td><td><input name="sex" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>是否有效:</td><td><input name="enabled" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>最后登录时间:</td><td><input name="lastLoginTime" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>创建用户ID:</td><td><input name="createUserID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>创建时间:</td><td><input name="createDate" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>修改用户ID:</td><td><input name="modifyUserID" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>编辑时间:</td><td><input name="modifyDate" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>状态:</td><td><input name="recordStatus" type="text" size="60" maxlength="50" /></td></tr>
	<tr><td>是否删除，1=是，0=否:</td><td><input name="isDeleted" type="text" size="60" maxlength="50" /></td></tr>
	
	<tr><td colspan="2" align="center"><input name="submit" type="submit" value="保存" /></td></tr>
</table>
</form>
</div>
</body>
</html>