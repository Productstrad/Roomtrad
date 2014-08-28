<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Chomo" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script src="js/prototype.lite.js" type="text/javascript"></script> 
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript" ></script>
<script src="js/layer/layer.min.js" type="text/javascript" ></script>
<title>div框架布局 </title>
</head>
<body>
<div class="frametop" id="head">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="frametopbg">
  <tr>
    <td  valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="frametoptxt" align="right"><b>admin</b> 您好,感谢登录使用！</td>
        <td width="22%"><a href="#" target="_self" onClick="logout();"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</div>
<div class="frameside" id="leftmenu">
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">系统管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/systemPermission/index.jsp" target="framemain">系统权限管理</a></li>
          <li><a href="/RolePermission/index.jsp" target="framemain">角色权限管理</a></li>
          <li><a href="/OperateLog/index.jsp" target="framemain">系统日志管理</a></li>
          <li><a href="/Menus/index.jsp" target="framemain">菜单管理</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">组织架构管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="Department/index.html" target="framemain">部门管理</a></li>
          <li><a href="/tradeuser/list.do" target="framemain">用户管理</a></li>
          <li><a href="/role/index.jsp" target="framemain">角色管理</a></li>
        </ul>
      </div>
	  <h1 class="type"><a href="javascript:void(0)">我的订单</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="Department/index.html" target="framemain">淘宝订单管理</a></li>
          <li><a href="/user/index.jsp" target="framemain">平台订单管理</a></li>

        </ul>
      </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[1]);
	</script>
      </td>
  </tr>
</table>
</div>
<div class="framemain" id="framecontent">
<iframe name="framemain" frameborder="0" src="main.html"></iframe>
主内容区
</div>
<div class="framebottom" id="framefooter">页脚区页脚区</div>
<script type="text/javascript">
//弹出添加或者编辑层
function popustyle(url,titlemsg)
{
	$.layer({
        type: 2,
        title: [
            titlemsg, 
            'background:#2B2E37; height:40px; color:#fff; border:none;' //自定义标题样式
        ], 
        border:[0],
        area: ['50%', '60%'],
        iframe: {src: url}
    })
}
</script>
</body>
</html>