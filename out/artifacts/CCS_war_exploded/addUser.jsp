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

<title>添加用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="updatepassword.css" rel="stylesheet" type="text/css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
<script type="text/javascript" src="createAjax.js"></script>
<script type="text/javascript">
  function check_username(){
  
  var myXmlHttpRequest=createAjax();
  if(myXmlHttpRequest){
    
  //采用post()方法发送
    var url="/CCS/checkusername.servlet";
    var data="username="+getElement("new_username").value;
    myXmlHttpRequest.open("post",url,true);
    //下面这句话必不可少，无需更改
    myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    myXmlHttpRequest.onreadystatechange=function (){
    	if(myXmlHttpRequest.readyState==4){
    		if(myXmlHttpRequest.status==200){
    			var result = myXmlHttpRequest.responseText;
    			if(result == -1){
    				getElement("new_username_td").style.color="RED";
					getElement("new_username_td").style.fontSize="10pt";
    				getElement("new_username_td").innerHTML="请填写帐号";
    			}else if(result==0){
    				getElement("new_username_td").style.color="GREEN";
					getElement("new_username_td").style.fontSize="10pt";
    				getElement("new_username_td").innerHTML="账号可使用";
    			}else{
    				getElement("new_username_td").style.color="RED";
					getElement("new_username_td").style.fontSize="10pt";
    				getElement("new_username_td").innerHTML="账号已存在";
    			}
    		}
    	}
    };
    //如果是post请求，则填入实际的数据
    myXmlHttpRequest.send(data);
  }

  }
  function match_password(){
	var password_text1=getElement("new_password").value;
	var password_text2=getElement("checkpassword").value;
	if(password_text1!=password_text2){
		getElement("password_td").style.color="RED";
		getElement("password_td").style.fontSize="10pt";
		getElement("password_td").innerHTML="密码不匹配";
	}else{
		getElement("password_td").style.color="GREEN";
		getElement("password_td").style.fontSize="10pt";
		getElement("password_td").innerHTML="密码匹配";
	}
}
function Is_submint(){
	var str1=getElement("new_username_td").value;
	var str2=getElement("password_td").value;
	var str3=getElement("quanxian").value;
	var str4=getElement("new_password").value;
	if(str2=="密码不匹配"||str1=="账号已存在"||str3=="--添加权限--"
		||str1==""||str2==""||str4==""){
		return false;
	}else{
	    if(str3=="管理员"){
	    	getElement("quanxian_1").value="0";
	    }
	    if(str3=="下料员"){
	    	getElement("quanxian_1").value="1";
	    }
	    return true;
	}
	
}
  </script>
</head>

<body>
	<%
		/*5月8日增加：用户权限判定*/
		if (request.getHeader("Referer") == null) {
			out.println("请求非法，请通过点击“添加使用者”进入此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		} else if (!"管理员".equals(session.getAttribute("style"))) {
			out.println("您不是管理员，无权访问此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		} else {
	%>
	<div class="head"></div>
	<div class="div1" style="border:1px solid#CCC">
		<form action="/CCS/adduser.servlet" method="post"
			onsubmit="return Is_submint();">
			<table width="401" height="199px" border="1">
				<tr>
					<td class="td1" width="132">用户账号：</td>
					<td width="170"><label> <input class="input_text"
							type="text" onblur="check_username()" id="new_username"
							name="new_username" /> </label>
					</td>
					<td id="new_username_td"></td>
				</tr>
				<tr>
					<td class="td1" width="132">密 码：</td>
					<td width="170"><label> <input class="input_text"
							type="password" id="new_password" name="password" /> </label>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="td1">确认密码：</td>
					<td width="170"><input class="input_text" id="checkpassword"
						type="password" onblur="match_password()" name="checkpassword" />
					</td>
					<td id="password_td"></td>
				</tr>
				<tr>
					<td class="td1">选择权限：</td>
					<td width="170"><select id="quanxian"
						style="width:155px;height:25px;font-size:15px;">
							<option>--添加权限--</option>
							<option>管理员</option>
							<option>下料员</option>
					</select></td>
					<td><input type="hidden" name="quanxian_1" id="quanxian_1" />
					</td>
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
		if ("succeed".equals(result)) {
	%>
	<script type="text/javascript">
  	var value=confirm("添加用户成功！"+'\n'+"如要继续添加请点击“确定”！"+'\n'+"点击“取消”将返回主界面");
  	if(value==true){
  	window.location.href="addUser.jsp?backurl="+window.location.href;
  	}else{
  	window.location.href="mainform.jsp?backurl="+window.location.href;	
  	}
  	</script>
	<%
		}
	%>
	<%
		if ("fail".equals(result)) {
	%>
	<script type="text/javascript">
  	alert("添加用户失败！");
  	</script>
	<%
		}
		}
	%>

</body>
</html>
