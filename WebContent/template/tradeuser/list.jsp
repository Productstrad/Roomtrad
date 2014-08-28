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
<div id="Header" align="right"><a class="button add" onclick="parent.popustyle('tradeuser/add.do','添加')">添加</a></div> 
<div id="Content">
<table class="table" align="center" width="100%" >
	<tr><th scope="col">用户id</th><th scope="col">用户名</th><th scope="col">用户口令</th><th scope="col">角色ID</th><th scope="col">部门ID</th><th scope="col">联系电话</th><th scope="col">传真号码</th><th scope="col">email地址</th><th scope="col">qQ号码</th><th scope="col">昵称</th><th scope="col">地址</th><th scope="col">真实姓名</th><th scope="col">性别</th><th scope="col">是否有效</th><th scope="col">最后登录时间</th><th scope="col">创建用户ID</th><th scope="col">创建时间</th><th scope="col">修改用户ID</th><th scope="col">编辑时间</th><th scope="col">状态</th><th scope="col">是否删除，1=是，0=否</th><th>操  作</th></tr>
<c:forEach items="${list}" var="vo">
	<tr onmouseover="this.className='altrow'" onmouseout="this.className=''">
	<td>${vo.userID }</td>
	<td>${vo.userName }</td>
	<td>${vo.userPassword }</td>
	<td>${vo.roleID }</td>
	<td>${vo.deptID }</td>
	<td>${vo.phone }</td>
	<td>${vo.fax }</td>
	<td>${vo.email }</td>
	<td></td>
	<td>${vo.nickName }</td>
	<td>${vo.address }</td>
	<td>${vo.realName }</td>
	<td>${vo.sex }</td>
	<td>${vo.enabled }</td>
	<td>${vo.lastLoginTime }</td>
	<td>${vo.createUserID }</td>
	<td>${vo.createDate }</td>
	<td>${vo.modifyUserID }</td>
	<td>${vo.modifyDate }</td>
	<td>${vo.recordStatus }</td>
	<td>${vo.isDeleted }</td>
	
	<td ><a class="button edit" onclick="parent.popustyle('tradeuser/update.do?id=${vo.userID}','编辑')">编辑</a> <a class="button delete">删除</a></td>
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