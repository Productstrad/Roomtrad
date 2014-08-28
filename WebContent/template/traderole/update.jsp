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
<tr><td>角色ID:</td><td><input name="roleID" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>角色编号:</td><td><input name="roleNo" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>角色名称:</td><td><input name="roleName" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>角色描述:</td><td><input name="description" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>排序:</td><td><input name="sort" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否有效，1=是，0=否:</td><td><input name="isVisible" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>创建用户ID:</td><td><input name="createUserID" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>创建时间:</td><td><input name="createDate" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>编辑用户ID:</td><td><input name="modifyUserID" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>编辑时间:</td><td><input name="modifyDate" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>状态:</td><td><input name="recordStatus" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否删除，1=是，0=否:</td><td><input name="isDeleted" type="text" size="60" maxlength="50" value="" /></td></tr>
	
<tr><td colspan="2" align="center"><input name="submit" type="submit" value="保存" /></td></tr>
</table>
</form>
</div>
</body>
</html>