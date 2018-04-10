<!--时间：2015.04.24 
	内容：CCS数据采集系用的修改密码界面布局以及功能实现：实现用户修改密码的请求。
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

<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="updatepassword.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//自动关闭提示框    
function Alert(str) {    
    var msgw,msgh,bordercolor;    
    msgw=350;//提示窗口的宽度    
    msgh=80;//提示窗口的高度    
    titleheight=25 //提示窗口标题高度    
    bordercolor="#336699";//提示窗口的边框颜色    
    titlecolor="#99CCFF";//提示窗口的标题颜色    
    var sWidth,sHeight;    
    //获取当前窗口尺寸    
    sWidth = document.body.offsetWidth;    
    sHeight = document.body.offsetHeight;    
//    //背景div    
    var bgObj=document.createElement("div");    
    bgObj.setAttribute('id','alertbgDiv');    
    bgObj.style.position="absolute";    
    bgObj.style.top="0";    
    bgObj.style.background="#E8E8E8";    
    bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";    
    bgObj.style.opacity="0.6";    
    bgObj.style.left="0";    
    bgObj.style.width = sWidth + "px";    
    bgObj.style.height = sHeight + "px";    
    bgObj.style.zIndex = "10000";    
    document.body.appendChild(bgObj);    
    //创建提示窗口的div    
    var msgObj = document.createElement("div")    
    msgObj.setAttribute("id","alertmsgDiv");    
    msgObj.setAttribute("align","center");    
    msgObj.style.background="white";    
    msgObj.style.border="1px solid " + bordercolor;    
    msgObj.style.position = "absolute";    
    msgObj.style.left = "50%";    
    msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";    
    //窗口距离左侧和顶端的距离     
    msgObj.style.marginLeft = "-225px";    
    //窗口被卷去的高+（屏幕可用工作区高/2）-150    
    msgObj.style.top = document.body.scrollTop+(window.screen.availHeight/2)-150 +"px";    
    msgObj.style.width = msgw + "px";    
    msgObj.style.height = msgh + "px";    
    msgObj.style.textAlign = "center";    
    msgObj.style.lineHeight ="25px";    
    msgObj.style.zIndex = "10001";    
    document.body.appendChild(msgObj);    
    //提示信息标题    
    var title=document.createElement("h4");    
    title.setAttribute("id","alertmsgTitle");    
    title.setAttribute("align","left");    
    title.style.margin="0";    
    title.style.padding="3px";    
    title.style.background = bordercolor;    
    title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";    
    title.style.opacity="0.75";    
    title.style.border="1px solid " + bordercolor;    
    title.style.height="18px";    
    title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";    
    title.style.color="white";    
    title.innerHTML="提示信息";    
    document.getElementById("alertmsgDiv").appendChild(title);    
    //提示信息    
    var txt = document.createElement("p");    
    txt.setAttribute("id","msgTxt");    
    txt.style.margin="16px 0";    
    txt.innerHTML = str;    
    document.getElementById("alertmsgDiv").appendChild(txt);    
       
}    
function closewin() {    
    document.body.removeChild(document.getElementById("alertbgDiv"));    
    document.getElementById("alertmsgDiv").removeChild(document.getElementById("alertmsgTitle"));    
    document.body.removeChild(document.getElementById("alertmsgDiv"));    
}  
function match_oldpassword(){
	var password_session=<%=session.getAttribute("password")%>
	var password_text=document.getElementById("oldpassword").value;
	if(password_text!=password_session){
		document.getElementById("oldpassword_td").style.color="RED";
		document.getElementById("oldpassword_td").style.fontSize="10pt";
		document.getElementById("oldpassword_td").innerHTML="密码错误";
	}else{
		document.getElementById("oldpassword_td").style.color="GREEN";
		document.getElementById("oldpassword_td").style.fontSize="10pt";
		document.getElementById("oldpassword_td").innerHTML="密码正确";
	}
}
function match_password(){
	var password_text1=document.getElementById("newpassword").value;
	var password_text2=document.getElementById("checkpassword").value;
	if(password_text1!=password_text2){
		document.getElementById("newpassword_td").style.color="RED";
		document.getElementById("newpassword_td").style.fontSize="10pt";
		document.getElementById("newpassword_td").innerHTML="密码不匹配";
	}else{
		document.getElementById("newpassword_td").style.color="GREEN";
		document.getElementById("newpassword_td").style.fontSize="10pt";
		document.getElementById("newpassword_td").innerHTML="密码匹配";
	}
}
function Is_submint(){
	var str1=document.getElementById("newpassword_td").innerHTML;
	var str2=document.getElementById("oldpassword_td").innerHTML;
	if(str2=="密码错误"||str1=="密码不匹配"){
		return false;
	}else{
		return true;
	}
}
	</script>
</head>

<body>
	<%
		if (request.getHeader("Referer") == null
				&& request.getAttribute("result") == null) {
			out.println("请求非法，请通过点击“修改密码”进入此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		} else if (session.getAttribute("username") == null
				&& request.getAttribute("result") == null) {
			out.println("您还没有登录，无权访问此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/index.jsp'> ");
		} else {
	%>
	<div class="head"></div>
	<div class="div1" style="border:1px solid#CCC">
		<form action="/CCS/UpdatePasswordServlet.servlet" method="post"
			onsubmit="return Is_submint();">
			<table width="401" height="199px" border="1">
				<tr>
					<td class="td1" width="132">用户密码：</td>
					<td width="170"><label> <input class="input_text"
							type="password" id="oldpassword" onblur="match_oldpassword()"
							name="oldpassword" /> </label>
					</td>
					<td id="oldpassword_td"></td>
				</tr>
				<tr>
					<td class="td1" width="132">新密码：</td>
					<td width="170"><label> <input class="input_text"
							type="password" id="newpassword" name="newpassword" /> </label>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="td1">确认密码：</td>
					<td width="170"><input class="input_text" id="checkpassword"
						type="password" onkeyup="match_password()" name="checkpassword" />
					</td>
					<td id="newpassword_td"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="提交"
						class="buttom" style="margin-left:20px" />
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 从JSP得到Servlet中传来的数值 -->
	<%
		String result = (String) request.getAttribute("result");
	%>
	<%
		if ("The user is not logged in".equals(result)) {
	%>
	<script type="text/javascript">
  	alert("对不起！你还没有登录，无权进行该操作！"+'\n'+"点击“确定”按钮，返回登陆界面。");
  	url="index.jsp?backurl="+window.location.href;
  	setTimeout("window.location.href=url", 0);
  	</script>
	<%
		}
	%>
	<%
		if ("Updating password succeed".equals(result)) {
	%>
	<script type="text/javascript">
  	Alert("修改密码成功！3秒后自动跳转到登入界面，请稍等......");
  	//设置关闭时间    
    window.setTimeout("closewin()",3000);  
  	url="index.jsp?backurl="+window.location.href;
  	setTimeout("window.location.href=url", 3000);
  	</script>
	<%
		}
	%>
	<%
		if ("Updating password failed".equals(result)) {
	%>
	<script type="text/javascript">
  	alert("数据库操作失败！"+'\n'+"请重新进入该页面！");
  	</script>
	<%
		}
		}
	%>
</body>
</html>
