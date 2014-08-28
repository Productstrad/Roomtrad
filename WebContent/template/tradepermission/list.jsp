<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>列表页</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/button.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="Container">
<div id="Header" align="right"><a class="button add" onclick="parent.popustyle('tradepermission/add.do','添加')">添加</a></div> 
<div id="Content">
<table class="table" align="center" width="100%" >
	<tr><th scope="col">权限ID</th><th scope="col">权限操作</th><th scope="col">权限名称</th><th scope="col">排序</th><th scope="col">是否有效，1是，0否</th><th scope="col">脚本</th><th scope="col">图标</th><th scope="col">权限控制器</th><th scope="col">权限描述</th><th scope="col">是否按钮，1=是，0=否</th><th scope="col">父ID</th><th>操  作</th></tr>
<c:forEach items="${list}" var="vo">
	<tr onmouseover="this.className='altrow'" onmouseout="this.className=''">
	<td>${vo.permissionID }</td>
	<td>${vo.permissionAction }</td>
	<td>${vo.permissionName }</td>
	<td>${vo.sort }</td>
	<td>${vo.isVisible }</td>
	<td>${vo.script }</td>
	<td>${vo.icon }</td>
	<td>${vo.permissionController }</td>
	<td>${vo.description }</td>
	<td>${vo.isButton }</td>
	<td>${vo.parentID }</td>
	
	<td ><a class="button edit" onclick="parent.popustyle('tradepermission/update.do?id=${vo.id}','编辑')">编辑</a> <a class="button delete">删除</a></td>
	</tr>
</c:forEach>
</table>
<%@ include file="/template/common/page.jsp" %>
</div>
<div id="Footer" align="center">
 
</div>
</div>
</body>
</html>