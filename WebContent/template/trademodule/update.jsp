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
<tr><td>模块id:</td><td><input name="moduleID" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>模块名称:</td><td><input name="moduleName" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>模块url链接:</td><td><input name="moduleLinkUrl" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>模块图标:</td><td><input name="moduleIcon" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>父模块号:</td><td><input name="parentNo" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>排序:</td><td><input name="sort" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否有效:</td><td><input name="isVisible" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否叶子结点:</td><td><input name="isLeaf" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否菜单:</td><td><input name="isMenu" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>是否删除:</td><td><input name="isDeleted" type="text" size="60" maxlength="50" value="" /></td></tr>
<tr><td>模块控制器:</td><td><input name="moduleController" type="text" size="60" maxlength="50" value="" /></td></tr>
	
<tr><td colspan="2" align="center"><input name="submit" type="submit" value="保存" /></td></tr>
</table>
</form>
</div>
</body>
</html>