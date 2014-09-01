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
<tr><td>权限ID:</td><td><input name="permissionID_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>权限操作:</td><td><input name="permissionAction_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>权限名称:</td><td><input name="permissionName_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>排序:</td><td><input name="sort_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否有效，1是，0否:</td><td><input name="isVisible_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>脚本:</td><td><input name="script_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>图标:</td><td><input name="icon_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>权限控制器:</td><td><input name="permissionController_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>权限描述:</td><td><input name="description_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否按钮，1=是，0=否:</td><td><input name="isButton_set" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>父ID:</td><td><input name="parentID_set" type="text" size="60" maxlength="50" value="" /></td></tr>
	
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