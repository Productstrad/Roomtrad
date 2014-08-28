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
<div id="Header" align="right"><a class="button add" onclick="parent.popustyle('tradeoperatelog/add.do','添加')">添加</a></div> 
<div id="Content">
<table class="table" align="center" width="100%" >
	<tr><th scope="col">日志ID</th><th scope="col">应用名</th><th scope="col">应用描述</th><th scope="col">方法名</th><th scope="col">用户id</th><th scope="col">用户名称</th><th scope="col">ip地址</th><th scope="col">操作描述</th><th scope="col">创建时间</th><th scope="col">方法描述</th><th>操  作</th></tr>
<c:forEach items="${list}" var="vo">
	<tr onmouseover="this.className='altrow'" onmouseout="this.className=''">
	<td>${vo.iD }</td>
	<td>${vo.processName }</td>
	<td>${vo.processDesc }</td>
	<td>${vo.methodName }</td>
	<td>${vo.userID }</td>
	<td>${vo.userName }</td>
	<td>${vo.iPAddress }</td>
	<td>${vo.description }</td>
	<td>${vo.createDate }</td>
	<td>${vo.methodDesc }</td>
	
	<td ><a class="button edit" onclick="parent.popustyle('tradeoperatelog/update.do?id=${vo.id}','编辑')">编辑</a> <a class="button delete">删除</a></td>
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