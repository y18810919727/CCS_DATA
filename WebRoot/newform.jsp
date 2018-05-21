<%@page import="com.ccs.entity.Summary"%>

<%@page import="com.ccs.entity.Mineral"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>新建配料单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="charger_sheet_query.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="date.css" />

<!-- 导入日历控件 -->
<script type="text/javascript" src="date.js"></script>
<!-- 导入jQuery -->
<script type="text/javascript" src="jquery-1.4.min.js"></script>
<!-- 导入本页面必须的所有js脚本 -->
<script type="text/javascript" src="calcscript.js"></script>
<!-- 设置stock类风格 -->
<style type="text/css">
.stock {
	width: 100%
}
</style>
</head>

<body style="background-image: url('img/bg_02.jpg');">
	<%
		/*4月30日增加：用户权限判定*/
		if (request.getHeader("Referer") == null) {
			out.println("请求非法，请通过点击“新建”按钮进入此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		} else if (!"管理员".equals(session.getAttribute("style"))) {
			out.println("您不是管理员，无权访问此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		} else {
	%>
	<div style="margin:0 auto; width:1100px">
		<div style="width:550px; float:left">
			<table>
				<tr>
					<td style="font-weight:bold">${sessionScope.username
						}(${sessionScope.style })</td>
					<td width="10px">&nbsp;</td>
					<td><a onclick="javascript:return confirm('确认退出？')"
						href="/CCS/LogoutServlet.servlet">退出</a></td>
					<td width="10px">&nbsp;</td>
					<td><a href="updatepassword.jsp">修改密码</a>
					</td>
					<td width="10px">&nbsp;</td>
					<td><a href="addUser.jsp">添加使用者</a></td>
				</tr>
			</table>
		</div>
		<div style="width:550px; float:left">
			<table>
				<tr>
					<td width="100px">&nbsp;</td>
					<td style="font-weight:bold">新建配料单</td>
					<td width="10px">&nbsp;</td>
					<td><a href="/CCS/mainform.jsp">配料单查询</a></td>
					<td width="10px">&nbsp;</td>
					<td><a href="material_records.jsp">下料情况记录</a></td>
				</tr>
			</table>
		</div>
	</div>
	<hr width="1100px" />
	<div class="title">新增配料单</div>
	<form method="post" action="/CCS/createnewform.servlet"
		onsubmit="return IsAllFilled()">
		<div class="query">
			日期：<input type="text" name="date" value="${requestScope.date }"
				readonly="readonly"> 配料单号：<input style="width:150px"
				name="number" id="numid" value="${requestScope.number }"
				readonly="readonly">
		</div>
		<div style="margin:0 auto; width:1100px">
			<table border="1" class="table1" id="stock">
				<tr id="stockhead">
					<td width="125">单位（吨）</td>
					<td width="70">LUANSHYA</td>
					<td width="70">KANSANSHI</td>
					<td width="70">LUMWANA</td>
					<td width="66">CHIBULUMA</td>
					<td width="80">ENRC矿</td>
					<td width="85">TF矿</td>
					<td width="66">COLD冷料</td>
					<td width="76">REVERTS</td>
					<td width="73">LUBAMBE</td>
					<td width="73">NFCA</td>
					<td width="73">BOLO</td>
					<td width="73">CCS矿</td>
				</tr>
				<tr id="stocklm">
					<td><input id="lmtext" type="hidden" style="width:90px"
						name="lmval" /><select id="lmval">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
					</select>月计划库存</td>
					<td><input type="text" class="stock" name="lm1" id="lm1"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm2" id="lm2"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm3" id="lm3"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm4" id="lm4"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm5" id="lm5"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm6" id="lm6"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm7" id="lm7"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm8" id="lm8"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm9" id="lm9"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="lm10" id="lm10"
						onblur="calcTotal()" value="0"/></td>
					<td><input type="text" class="stock" name="lm11" id="lm11"
						onblur="calcTotal()" value="0"/></td>
					<td><input type="text" class="stock" name="lm12" id="lm12"
						onblur="calcTotal()" value="0"/></td>
				</tr>
				<tr id="stocktm">
					<td><input id="tmtext" type="hidden" style="width:90px"
						name="tmval" /><select id="tmval">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
					</select>月计划采购</td>
					<td><input type="text" class="stock" name="tm1" id="tm1"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm2" id="tm2"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm3" id="tm3"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm4" id="tm4"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm5" id="tm5"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm6" id="tm6"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm7" id="tm7"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm8" id="tm8"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm9" id="tm9"
						onblur="calcTotal()" value="0"/>
					</td>
					<td><input type="text" class="stock" name="tm10" id="tm10"
						onblur="calcTotal()" value="0"/></td>
					<td><input type="text" class="stock" name="tm11" id="tm11"
						onblur="calcTotal()" value="0"/></td>
					<td><input type="text" class="stock" name="tm12" id="tm12"
						onblur="calcTotal()" value="0"/></td>
				</tr>
				<tr id="stockcur">
					<td>目前库存</td>
					<td><input type="text" class="stock" id="cur1" name="cur1"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur2" name="cur2"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur3" name="cur3"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur4" name="cur4"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur5" name="cur5"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur6" name="cur6"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur7" name="cur7"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur8" name="cur8"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur9" name="cur9"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur10" name="cur10"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur11" name="cur11"
						value="0" readonly="readonly" />
					</td>
					<td><input type="text" class="stock" id="cur12" name="cur12"
						value="0" readonly="readonly" />
					</td>
				</tr>
			</table>
		</div>
		<div style="margin:0 auto; width:1100px">
			<table class="table1" width="750" border="1" id="mineral">
				<tr>
					<td>仓号</td>
					<td>精矿名称copper material name</td>
					<td>Cu</td>
					<td>Fe</td>
					<td>S</td>
					<td>SiO2</td>
					<td>CaO</td>
					<td>MgO</td>
					<td>Al2O3</td>
					<td>Co</td>
					<td>用量dosage</td>
				</tr>
				<tr>
					<td>1</td>
					<td><input id="NO1_val" type="hidden" style="width:90px"
						name="NO1_name" /><select id="NO1_name" onchange="AutoZero(1)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select></td>
					<td><input type="text" name="NO1_Cu" id="NO1_Cu"
						style="width:80px" onblur="checkNum('NO1_Cu')" />
					</td>
					<td><input type="text" name="NO1_Fe" id="NO1_Fe"
						style="width:80px" onblur="checkNum('NO1_Fe')" />
					</td>
					<td><input type="text" name="NO1_S" id="NO1_S"
						style="width:80px" onblur="checkNum('NO1_S')" />
					</td>
					<td><input type="text" name="NO1_SiO2" id="NO1_SiO2"
						style="width:80px" onblur="checkNum('NO1_SiO2')" />
					</td>
					<td><input type="text" name="NO1_CaO" id="NO1_CaO"
						style="width:80px" onblur="checkNum('NO1_CaO')" />
					</td>
					<td><input type="text" name="NO1_MgO" id="NO1_MgO"
						style="width:80px" onblur="checkNum('NO1_MgO')" />
					</td>
					<td><input type="text" name="NO1_Al2O3" id="NO1_Al2O3"
						style="width:80px" onblur="checkNum('NO1_Al2O3')" />
					</td>
					<td><input type="text" name="NO1_Co" id="NO1_Co"
						style="width:80px" onblur="checkNum('NO1_Co')" />
					</td>
					<td><input type="text" name="dosage1" id="dosage1"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>2</td>
					<td><input id="NO2_val" type="hidden" style="width:90px"
						name="NO2_name" /><select id="NO2_name" onchange="AutoZero(2)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO2_Cu" id="NO2_Cu"
						style="width:80px" onblur="checkNum('NO2_Cu')" />
					</td>
					<td><input type="text" name="NO2_Fe" id="NO2_Fe"
						style="width:80px" onblur="checkNum('NO2_Fe')" />
					</td>
					<td><input type="text" name="NO2_S" id="NO2_S"
						style="width:80px" onblur="checkNum('NO2_S')" />
					</td>
					<td><input type="text" name="NO2_SiO2" id="NO2_SiO2"
						style="width:80px" onblur="checkNum('NO2_SiO2')" />
					</td>
					<td><input type="text" name="NO2_CaO" id="NO2_CaO"
						style="width:80px" onblur="checkNum('NO2_CaO')" />
					</td>
					<td><input type="text" name="NO2_MgO" id="NO2_MgO"
						style="width:80px" onblur="checkNum('NO2_MgO')" />
					</td>
					<td><input type="text" name="NO2_Al2O3" id="NO2_Al2O3"
						style="width:80px" onblur="checkNum('NO2_Al2O3')" />
					</td>
					<td><input type="text" name="NO2_Co" id="NO2_Co"
						style="width:80px" onblur="checkNum('NO2_Co')" />
					</td>
					<td><input type="text" name="dosage2" id="dosage2"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>3</td>
					<td><input id="NO3_val" type="hidden" style="width:90px"
						name="NO3_name" /><select id="NO3_name" onchange="AutoZero(3)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO3_Cu" id="NO3_Cu"
						style="width:80px" onblur="checkNum('NO3_Cu')" />
					</td>
					<td><input type="text" name="NO3_Fe" id="NO3_Fe"
						style="width:80px" onblur="checkNum('NO3_Fe')" />
					</td>
					<td><input type="text" name="NO3_S" id="NO3_S"
						style="width:80px" onblur="checkNum('NO3_S')" />
					</td>
					<td><input type="text" name="NO3_SiO2" id="NO3_SiO2"
						style="width:80px" onblur="checkNum('NO3_SiO2')" />
					</td>
					<td><input type="text" name="NO3_CaO" id="NO3_CaO"
						style="width:80px" onblur="checkNum('NO3_CaO')" />
					</td>
					<td><input type="text" name="NO3_MgO" id="NO3_MgO"
						style="width:80px" onblur="checkNum('NO3_MgO')" />
					</td>
					<td><input type="text" name="NO3_Al2O3" id="NO3_Al2O3"
						style="width:80px" onblur="checkNum('NO3_Al2O3')" />
					</td>
					<td><input type="text" name="NO3_Co" id="NO3_Co"
						style="width:80px" onblur="checkNum('NO3_Co')" />
					</td>
					<td><input type="text" name="dosage3" id="dosage3"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>4</td>
					<td><input id="NO4_val" type="hidden" style="width:90px"
						name="NO4_name" /><select id="NO4_name" onchange="AutoZero(4)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO4_Cu" id="NO4_Cu"
						style="width:80px" onblur="checkNum('NO4_Cu')" />
					</td>
					<td><input type="text" name="NO4_Fe" id="NO4_Fe"
						style="width:80px" onblur="checkNum('NO4_Fe')" />
					</td>
					<td><input type="text" name="NO4_S" id="NO4_S"
						style="width:80px" onblur="checkNum('NO4_S')" />
					</td>
					<td><input type="text" name="NO4_SiO2" id="NO4_SiO2"
						style="width:80px" onblur="checkNum('NO4_SiO2')" />
					</td>
					<td><input type="text" name="NO4_CaO" id="NO4_CaO"
						style="width:80px" onblur="checkNum('NO4_CaO')" />
					</td>
					<td><input type="text" name="NO4_MgO" id="NO4_MgO"
						style="width:80px" onblur="checkNum('NO4_MgO')" />
					</td>
					<td><input type="text" name="NO4_Al2O3" id="NO4_Al2O3"
						style="width:80px" onblur="checkNum('NO4_Al2O3')" />
					</td>
					<td><input type="text" name="NO4_Co" id="NO4_Co"
						style="width:80px" onblur="checkNum('NO4_Co')" />
					</td>
					<td><input type="text" name="dosage4" id="dosage4"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>8</td>
					<td><input id="NO8_val" type="hidden" style="width:90px"
						name="NO8_name" /><select id="NO8_name" onchange="AutoZero(8)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO8_Cu" id="NO8_Cu"
						style="width:80px" onblur="checkNum('NO8_Cu')" />
					</td>
					<td><input type="text" name="NO8_Fe" id="NO8_Fe"
						style="width:80px" onblur="checkNum('NO8_Fe')" />
					</td>
					<td><input type="text" name="NO8_S" id="NO8_S"
						style="width:80px" onblur="checkNum('NO8_S')" />
					</td>
					<td><input type="text" name="NO8_SiO2" id="NO8_SiO2"
						style="width:80px" onblur="checkNum('NO8_SiO2')" />
					</td>
					<td><input type="text" name="NO8_CaO" id="NO8_CaO"
						style="width:80px" onblur="checkNum('NO8_CaO')" />
					</td>
					<td><input type="text" name="NO8_MgO" id="NO8_MgO"
						style="width:80px" onblur="checkNum('NO8_MgO')" />
					</td>
					<td><input type="text" name="NO8_Al2O3" id="NO8_Al2O3"
						style="width:80px" onblur="checkNum('NO8_Al2O3')" />
					</td>
					<td><input type="text" name="NO8_Co" id="NO8_Co"
						style="width:80px" onblur="checkNum('NO8_Co')" />
					</td>
					<td><input type="text" name="dosage8" id="dosage8"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>9</td>
					<td><input id="NO9_val" type="hidden" style="width:90px"
						name="NO9_name" /><select id="NO9_name" onchange="AutoZero(9)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO9_Cu" id="NO9_Cu"
						style="width:80px" onblur="checkNum('NO9_Cu')" />
					</td>
					<td><input type="text" name="NO9_Fe" id="NO9_Fe"
						style="width:80px" onblur="checkNum('NO9_Fe')" />
					</td>
					<td><input type="text" name="NO9_S" id="NO9_S"
						style="width:80px" onblur="checkNum('NO9_S')" />
					</td>
					<td><input type="text" name="NO9_SiO2" id="NO9_SiO2"
						style="width:80px" onblur="checkNum('NO9_SiO2')" />
					</td>
					<td><input type="text" name="NO9_CaO" id="NO9_CaO"
						style="width:80px" onblur="checkNum('NO9_CaO')" />
					</td>
					<td><input type="text" name="NO9_MgO" id="NO9_MgO"
						style="width:80px" onblur="checkNum('NO9_MgO')" />
					</td>
					<td><input type="text" name="NO9_Al2O3" id="NO9_Al2O3"
						style="width:80px" onblur="checkNum('NO9_Al2O3')" />
					</td>
					<td><input type="text" name="NO9_Co" id="NO9_Co"
						style="width:80px" onblur="checkNum('NO9_Co')" />
					</td>
					<td><input type="text" name="dosage9" id="dosage9"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>10</td>
					<td><input id="NO10_val" type="hidden" style="width:90px"
						name="NO10_name" /><select id="NO10_name" onchange="AutoZero(10)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO10_Cu" id="NO10_Cu"
						style="width:80px" onblur="checkNum('NO10_Cu')" />
					</td>
					<td><input type="text" name="NO10_Fe" id="NO10_Fe"
						style="width:80px" onblur="checkNum('NO10_Fe')" />
					</td>
					<td><input type="text" name="NO10_S" id="NO10_S"
						style="width:80px" onblur="checkNum('NO10_S')" />
					</td>
					<td><input type="text" name="NO10_SiO2" id="NO10_SiO2"
						style="width:80px" onblur="checkNum('NO10_SiO2')" />
					</td>
					<td><input type="text" name="NO10_CaO" id="NO10_CaO"
						style="width:80px" onblur="checkNum('NO10_CaO')" />
					</td>
					<td><input type="text" name="NO10_MgO" id="NO10_MgO"
						style="width:80px" onblur="checkNum('NO10_MgO')" />
					</td>
					<td><input type="text" name="NO10_Al2O3" id="NO10_Al2O3"
						style="width:80px" onblur="checkNum('NO10_Al2O3')" />
					</td>
					<td><input type="text" name="NO10_Co" id="NO10_Co"
						style="width:80px" onblur="checkNum('NO10_Co')" />
					</td>
					<td><input type="text" name="dosage10" id="dosage10"
						style="width:80px" /></td>
				</tr>
				<tr>
					<td>11</td>
					<td><input id="NO11_val" type="hidden" style="width:90px"
						name="NO11_name" /><select id="NO11_name" onchange="AutoZero(11)">
							<option>LUANSHYA</option>
							<option>KANSANSHI</option>
							<option>LUMWANA</option>
							<option>CHIBULUMA</option>
							<option>ENRC矿</option>
							<option>TF矿</option>
							<option>COLD冷料</option>
							<option>REVERTS</option>
							<option>LUBAMBE</option>
							<option>NFCA</option>
							<option>BOLO</option>
							<option>CCS矿</option>
							<option>SCM</option>
							<option>RONGBO</option>
							<option>KML</option>
                            <option>NST</option>
                            <option>HRC</option>
                            <option>GREATSTONE</option>
                            <option>LUNA</option>
                            <option>KCM</option>
                            <option>COMILU</option>
                            <option>MOPANI</option>
							<option>LUANSHYA渣精矿</option>
							<option>CCS-CT</option>
							<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO11_Cu" id="NO11_Cu"
						style="width:80px" onblur="checkNum('NO11_Cu')" />
					</td>
					<td><input type="text" name="NO11_Fe" id="NO11_Fe"
						style="width:80px" onblur="checkNum('NO11_Fe')" />
					</td>
					<td><input type="text" name="NO11_S" id="NO11_S"
						style="width:80px" onblur="checkNum('NO11_S')" />
					</td>
					<td><input type="text" name="NO11_SiO2" id="NO11_SiO2"
						style="width:80px" onblur="checkNum('NO11_SiO2')" />
					</td>
					<td><input type="text" name="NO11_CaO" id="NO11_CaO"
						style="width:80px" onblur="checkNum('NO11_CaO')" />
					</td>
					<td><input type="text" name="NO11_MgO" id="NO11_MgO"
						style="width:80px" onblur="checkNum('NO11_MgO')" />
					</td>
					<td><input type="text" name="NO11_Al2O3" id="NO11_Al2O3"
						style="width:80px" onblur="checkNum('NO11_Al2O3')" />
					</td>
					<td><input type="text" name="NO11_Co" id="NO11_Co"
						style="width:80px" onblur="checkNum('NO11_Co')" />
					</td>
					<td><input type="text" name="dosage11" id="dosage11"
						style="width:80px" /></td>
				</tr>
				<tr>
				<td>12</td>
				<td><input id="NO12_val" type="hidden" style="width:90px"
						   name="NO12_name" /><select id="NO12_name" onchange="AutoZero(12)">
					<option>LUANSHYA</option>
					<option>KANSANSHI</option>
					<option>LUMWANA</option>
					<option>CHIBULUMA</option>
					<option>ENRC矿</option>
					<option>TF矿</option>
					<option>COLD冷料</option>
					<option>REVERTS</option>
					<option>LUBAMBE</option>
					<option>NFCA</option>
					<option>BOLO</option>
					<option>CCS矿</option>
					<option>SCM</option>
					<option>RONGBO</option>
					<option>KML</option>
					<option>NST</option>
					<option>HRC</option>
					<option>GREATSTONE</option>
					<option>LUNA</option>
					<option>KCM</option>
					<option>COMILU</option>
					<option>MOPANI</option>
					<option>LUANSHYA渣精矿</option>
					<option>CCS-CT</option>
					<option>(无矿)</option>
				</select>
				</td>
				<td><input type="text" name="NO12_Cu" id="NO12_Cu"
						   style="width:80px" onblur="checkNum('NO12_Cu')" />
				</td>
				<td><input type="text" name="NO12_Fe" id="NO12_Fe"
						   style="width:80px" onblur="checkNum('NO12_Fe')" />
				</td>
				<td><input type="text" name="NO12_S" id="NO12_S"
						   style="width:80px" onblur="checkNum('NO12_S')" />
				</td>
				<td><input type="text" name="NO12_SiO2" id="NO12_SiO2"
						   style="width:80px" onblur="checkNum('NO12_SiO2')" />
				</td>
				<td><input type="text" name="NO12_CaO" id="NO12_CaO"
						   style="width:80px" onblur="checkNum('NO12_CaO')" />
				</td>
				<td><input type="text" name="NO12_MgO" id="NO12_MgO"
						   style="width:80px" onblur="checkNum('NO12_MgO')" />
				</td>
				<td><input type="text" name="NO12_Al2O3" id="NO12_Al2O3"
						   style="width:80px" onblur="checkNum('NO12_Al2O3')" />
				</td>
				<td><input type="text" name="NO12_Co" id="NO12_Co"
						   style="width:80px" onblur="checkNum('NO12_Co')" />
				</td>
				<td><input type="text" name="dosage12" id="dosage12"
						   style="width:80px" /></td>
				</tr>
				<tr>
					<td>13</td>
					<td><input id="NO13_val" type="hidden" style="width:90px"
							   name="NO13_name" /><select id="NO13_name" onchange="AutoZero(13)">
						<option>LUANSHYA</option>
						<option>KANSANSHI</option>
						<option>LUMWANA</option>
						<option>CHIBULUMA</option>
						<option>ENRC矿</option>
						<option>TF矿</option>
						<option>COLD冷料</option>
						<option>REVERTS</option>
						<option>LUBAMBE</option>
						<option>NFCA</option>
						<option>BOLO</option>
						<option>CCS矿</option>
						<option>SCM</option>
						<option>RONGBO</option>
						<option>KML</option>
						<option>NST</option>
						<option>HRC</option>
						<option>GREATSTONE</option>
						<option>LUNA</option>
						<option>KCM</option>
						<option>COMILU</option>
						<option>MOPANI</option>
						<option>LUANSHYA渣精矿</option>
						<option>CCS-CT</option>
						<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO13_Cu" id="NO13_Cu"
							   style="width:80px" onblur="checkNum('NO13_Cu')" />
					</td>
					<td><input type="text" name="NO13_Fe" id="NO13_Fe"
							   style="width:80px" onblur="checkNum('NO13_Fe')" />
					</td>
					<td><input type="text" name="NO13_S" id="NO13_S"
							   style="width:80px" onblur="checkNum('NO13_S')" />
					</td>
					<td><input type="text" name="NO13_SiO2" id="NO13_SiO2"
							   style="width:80px" onblur="checkNum('NO13_SiO2')" />
					</td>
					<td><input type="text" name="NO13_CaO" id="NO13_CaO"
							   style="width:80px" onblur="checkNum('NO13_CaO')" />
					</td>
					<td><input type="text" name="NO13_MgO" id="NO13_MgO"
							   style="width:80px" onblur="checkNum('NO13_MgO')" />
					</td>
					<td><input type="text" name="NO13_Al2O3" id="NO13_Al2O3"
							   style="width:80px" onblur="checkNum('NO13_Al2O3')" />
					</td>
					<td><input type="text" name="NO13_Co" id="NO13_Co"
							   style="width:80px" onblur="checkNum('NO13_Co')" />
					</td>
					<td><input type="text" name="dosage13" id="dosage13"
							   style="width:80px" /></td>
				</tr>
				<tr>
					<td>14</td>
					<td><input id="NO14_val" type="hidden" style="width:90px"
							   name="NO14_name" /><select id="NO14_name" onchange="AutoZero(14)">
						<option>LUANSHYA</option>
						<option>KANSANSHI</option>
						<option>LUMWANA</option>
						<option>CHIBULUMA</option>
						<option>ENRC矿</option>
						<option>TF矿</option>
						<option>COLD冷料</option>
						<option>REVERTS</option>
						<option>LUBAMBE</option>
						<option>NFCA</option>
						<option>BOLO</option>
						<option>CCS矿</option>
						<option>SCM</option>
						<option>RONGBO</option>
						<option>KML</option>
						<option>NST</option>
						<option>HRC</option>
						<option>GREATSTONE</option>
						<option>LUNA</option>
						<option>KCM</option>
						<option>COMILU</option>
						<option>MOPANI</option>
						<option>LUANSHYA渣精矿</option>
						<option>CCS-CT</option>
						<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO14_Cu" id="NO14_Cu"
							   style="width:80px" onblur="checkNum('NO14_Cu')" />
					</td>
					<td><input type="text" name="NO14_Fe" id="NO14_Fe"
							   style="width:80px" onblur="checkNum('NO14_Fe')" />
					</td>
					<td><input type="text" name="NO14_S" id="NO14_S"
							   style="width:80px" onblur="checkNum('NO14_S')" />
					</td>
					<td><input type="text" name="NO14_SiO2" id="NO14_SiO2"
							   style="width:80px" onblur="checkNum('NO14_SiO2')" />
					</td>
					<td><input type="text" name="NO14_CaO" id="NO14_CaO"
							   style="width:80px" onblur="checkNum('NO14_CaO')" />
					</td>
					<td><input type="text" name="NO14_MgO" id="NO14_MgO"
							   style="width:80px" onblur="checkNum('NO14_MgO')" />
					</td>
					<td><input type="text" name="NO14_Al2O3" id="NO14_Al2O3"
							   style="width:80px" onblur="checkNum('NO14_Al2O3')" />
					</td>
					<td><input type="text" name="NO14_Co" id="NO14_Co"
							   style="width:80px" onblur="checkNum('NO14_Co')" />
					</td>
					<td><input type="text" name="dosage14" id="dosage14"
							   style="width:80px" /></td>
				</tr>
				<tr>
					<td>15</td>
					<td><input id="NO15_val" type="hidden" style="width:90px"
							   name="NO15_name" /><select id="NO15_name" onchange="AutoZero(15)">
						<option>LUANSHYA</option>
						<option>KANSANSHI</option>
						<option>LUMWANA</option>
						<option>CHIBULUMA</option>
						<option>ENRC矿</option>
						<option>TF矿</option>
						<option>COLD冷料</option>
						<option>REVERTS</option>
						<option>LUBAMBE</option>
						<option>NFCA</option>
						<option>BOLO</option>
						<option>CCS矿</option>
						<option>SCM</option>
						<option>RONGBO</option>
						<option>KML</option>
						<option>NST</option>
						<option>HRC</option>
						<option>GREATSTONE</option>
						<option>LUNA</option>
						<option>KCM</option>
						<option>COMILU</option>
						<option>MOPANI</option>
						<option>LUANSHYA渣精矿</option>
						<option>CCS-CT</option>
						<option>(无矿)</option>
					</select>
					</td>
					<td><input type="text" name="NO15_Cu" id="NO15_Cu"
							   style="width:80px" onblur="checkNum('NO15_Cu')" />
					</td>
					<td><input type="text" name="NO15_Fe" id="NO15_Fe"
							   style="width:80px" onblur="checkNum('NO15_Fe')" />
					</td>
					<td><input type="text" name="NO15_S" id="NO15_S"
							   style="width:80px" onblur="checkNum('NO15_S')" />
					</td>
					<td><input type="text" name="NO15_SiO2" id="NO15_SiO2"
							   style="width:80px" onblur="checkNum('NO15_SiO2')" />
					</td>
					<td><input type="text" name="NO15_CaO" id="NO15_CaO"
							   style="width:80px" onblur="checkNum('NO15_CaO')" />
					</td>
					<td><input type="text" name="NO15_MgO" id="NO15_MgO"
							   style="width:80px" onblur="checkNum('NO15_MgO')" />
					</td>
					<td><input type="text" name="NO15_Al2O3" id="NO15_Al2O3"
							   style="width:80px" onblur="checkNum('NO15_Al2O3')" />
					</td>
					<td><input type="text" name="NO15_Co" id="NO15_Co"
							   style="width:80px" onblur="checkNum('NO15_Co')" />
					</td>
					<td><input type="text" name="dosage15" id="dosage15"
							   style="width:80px" /></td>
				</tr>
				<tr>
					<td>-</td>
					<td>模块输入成分concentrate</td>
					<td><input type="text" id="C1" style="width:80px"
						readonly="readonly" name="Con_Cu"/>
					</td>
					<td><input type="text" id="C2" style="width:80px"
						readonly="readonly"  name="Con_Fe"/></td>
					<td><input type="text" id="C3" style="width:80px"
						readonly="readonly"  name="Con_S"/></td>
					<td><input type="text" id="C4" style="width:80px"
						readonly="readonly"  name="Con_SiO2"/></td>
					<td><input type="text" id="C5" style="width:80px"
						readonly="readonly"  name="Con_CaO"/></td>
					<td><input type="text" id="C6" style="width:80px"
						readonly="readonly"  name="Con_MgO"/></td>
					<td><input type="text" id="C7" style="width:80px"
						readonly="readonly"  name="Con_Al2O3"/></td>
					<td><input type="text" id="C8" style="width:80px"
						readonly="readonly"  name="Con_Co"/></td>
					<td><input type="text" id="C9" style="width:80px"
						readonly="readonly"  name="Con_dosage"/></td>
				</tr>
			</table>
		</div>
		<div style="margin:0 auto; width:1500px; padding-left:8%;">
			<fieldset style="width:500px; float:left">
				<legend>换料后 after change</legend>
				<table width="400" border="0" style="text-align:center">
					<tr style="height:115px">
						<td>富氧浓度(%)oxygen in lance</td>
						<td><input type="text" id="oxyconc" name="oxyconc" /></td>
						<td>目标冰铜品位(%)target control matte grade</td>
						<td><input type="text" id="real_Matte" name="real_Matte" />
						</td>
					</tr>
					<tr>
						<td>数模(%)target matte grade</td>
						<td><input type="text" id="digifax" name="digifax" /></td>
						<td>目标Fe3O4 target magnetic iron</td>
						<td><input type="text" id="real_Fe3O4" name="real_Fe3O4" />
						</td>
					</tr>
					<tr>
						<td>氧料比oxygen/material ratio</td>
						<td><input type="text" id="fuelratio" name="fuelratio" /></td>
						<td>目标SiO2/Fe target SiO2/Fe</td>
						<td><input type="text" id="real_SiO2Fe" name="real_SiO2Fe" />
						</td>
					</tr>
					<tr>
						<td>风量blow wind</td>
						<td><input type="text" id="airvolume" name="airvolume" /></td>
						<td>目标SiO2/CaO target SiO2/CaO</td>
						<td><input type="text" id="real_SiO2CaO" name="real_SiO2CaO" />
						</td>
					</tr>
					<tr>
						<td>补SiO2(T/h)</td>
						<td><input type="text" id="sup_SiO2" name="sup_SiO2" /></td>
						<td>补入CaO(T/h)</td>
						<td><input type="text" id="sup_CaO" name="sup_CaO" /></td>
					</tr>
				</table>
			</fieldset>
			<%
				// 获得最后一条记录.修改需求后不需要此语句
					//Summary s = (Summary) request.getAttribute("lastsummary");
			%>
			<fieldset style="width:500px; float:left">
				<legend>换料前 before change</legend>
				<table width="400" border="0" style="text-align:center">
					<tr style="height:115px">
						<td>富氧浓度(%)oxygen in lance</td>
						<td><input type="text" id="pre_oxyconc" name="pre_oxyconc" />
						</td>
						<td>实际冰铜品位(%)reality matte grade</td>
						<td><input type="text" id="pre_real_matte"
							name="pre_real_matte" /></td>
					</tr>
					<tr>
						<td>数模(%)target matte grade</td>
						<td><input type="text" id="pre_digifax" name="pre_digifax"/>
						</td>
						<td>实际Fe3O4 reality magnetic iron</td>
						<td><input type="text" id="pre_real_Fe3O4"
							name="pre_real_Fe3O4" /></td>
					</tr>
					<tr>
						<td>氧料比oxygen/material ratio</td>
						<td><input type="text" id="pre_fuelratio"
							name="pre_fuelratio"/>
						</td>
						<td>实际SiO2/Fe reality SiO2/Fe</td>
						<td><input type="text" id="pre_real_SiO2Fe"
							name="pre_real_SiO2Fe" /></td>
					</tr>
					<tr>
						<td>风量blow wind</td>
						<td><input type="text" id="pre_airvolume"
							name="pre_airvolume" />
						</td>
						<td>实际SiO2/CaO SiO2/CaO reality</td>
						<td><input type="text" id="pre_real_SiO2CaO"
							name="pre_real_SiO2CaO" /></td>
					</tr>
					<tr>
						<td>补SiO2(T/h)</td>
						<td><input type="text" id="pre_sup_SiO2" name="pre_sup_SiO2" />
						</td>
						<td>补入CaO(T/h)</td>
						<td><input type="text" id="pre_sup_CaO" name="pre_sup_CaO" />
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="margin:0 auto; width:1100px">
			<table width=100% border="0" style="text-align:center">
				<tr>
					<td><input type="submit" value="确认提交"
						style="width:auto;height:35px;font-size:15px" /></td>
				</tr>
			</table>
		</div>
	</form>
	<%
		}
	%>
</body>
</html>
