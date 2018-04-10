<!--时间：2015.04.23  
	内容：CCS数据采集系用的登录界面布局以及功能实现：验证用户账号密码，并给出相应的相应。
	作者：yepengfei-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>CSS数据采集系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
.STYLE2 {
	font-size: 18px
}

.STYLE3 {
	color: #E5E5E5
}

.STYLE4 {
	color: #FF0000;
}
table{
  background:#fff url('img/login.jpg') no-repeat left top;
  background-size:1350px 620px;
}
td{
  width:200px
}
-->
</style>
<script type="text/javascript">
	function username() {
		var name = document.getElementById("name_text");
		return name.value;
	}
</script>
</head>

<body>
	
	<%
		// 用户如果已经登录过了，直接跳转
		if (session.getAttribute("username") != null) {
			response.sendRedirect("mainform.jsp");
		}
	%>
	<table width="1350" height="620" border="0" cellpadding="0"
		cellspacing="0">
	<tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <form action="/CCS/LoginServlet.servlet" method="post">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td style="text-align: center;font-size: 20">&nbsp;&nbsp;&nbsp;&nbsp;用户账号</td>
    <td><label> <input type="text"
		id="name_text" class="username" name="username"> </label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td style="text-align: center;font-size: 20">&nbsp;&nbsp;&nbsp;&nbsp;用户密码</td>
    <td><label> <input type="password" class="password" name="password"> </label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><input name="submit" type="submit" class="login" value="登录"
		style="width:70px;height:25px">
    <td>&nbsp;</td>
  </tr>
  </form>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
	
	<!-- 从JSP得到Servlet中传来的数值 -->
	<%
		String result = (String) request.getAttribute("result");
	%>
	<%
		if ("User does not exist".equals(result)) {
	%>
	<script type="text/javascript">
		alert("用户不存在！" + '\n' + "Invalid user name!");
	</script>
	<%
		}
	%>
	<%
		if ("Password is error".equals(result)) {
	%>
	<script type="text/javascript">
		alert("密码错误！" + '\n' + "Password error！");
	</script>
	<%
		}
	%>
	<%
		if ("User can login".equals(result)) {
	%>
	<script type="text/javascript">
		alert("登录成功！" + '\n' + "Login Success！");
		//页面跳转
		window.location.href = "mainform.jsp";
	</script>
	<%
		}
	%>
</body>
</html>
