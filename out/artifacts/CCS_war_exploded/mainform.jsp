<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>查询配料单</title>

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
<!-- 导入异步查询文件 -->
<script type="text/javascript" src="ajaxQuery.js"></script>


</head>

<body style="background-image: url('img/bg_02.jpg');">
	<%
		String curuser = (String) session.getAttribute("username");
		String userstyle = (String) session.getAttribute("style");
		// 判定用户是否已经登录，判定是否通过登录界面跳转此界面
		if (curuser == null || "".equals(curuser)) {
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/index.jsp'> ");
			out.println("你还没有登录，不能访问该页面！");
		} else {
	%>
	<script type="text/javascript">
	// 获取所有有数据的日期号
		getAllDate();
	</script>
	<div style="margin:0 auto; width:1100px">
		<div style="width:550px; float:left">
			<table>
				<tr>
					<td style="font-weight:bold">${sessionScope.username
						}(${sessionScope.style })</td>
					<td width="10px">&nbsp;</td>
					<td><a onclick="javascript:return confirm('确认退出？')"
						href="/CCS/LogoutServlet.servlet">退出</a>
					</td>
					<td width="10px">&nbsp;</td>
					<td><a href="updatepassword.jsp">修改密码</a></td>
					<td width="10px">&nbsp;</td>
					<td id="newuser"><a href="addUser.jsp">添加使用者</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="width:550px; float:left">
			<table>
				<tr>
					<td width="100px">&nbsp;</td>
					<td id="newform"><a href="/CCS/initnewform.servlet">新建配料单</a>
					</td>
					<td width="10px">&nbsp;</td>
					<td style="font-weight:bold">配料单查询</td>
					<td width="10px">&nbsp;</td>
					<td><a href="material_records.jsp">下料情况记录</a></td>
				</tr>
			</table>
		</div>
	</div>
	<hr width="1100px" />
	<div class="title">配料单查询</div>
	<div
		style="width: 1100px;font-size: 14px;margin-top: 10px;height: 35px;padding: 5px;margin-left: auto;margin-right: auto">
		<div
			style="float:left;width:1100px;height:30px;text-align:center;background-color:#87CEEB;">
			<form action="/CCS/DownloadMainExcel.servlet" method="get">
				日期：<input type="text" name="date" class="tcal" id="date">
				配料单号：<select style="width:150px" id="numid" name="numval">
				</select> <input type="button" value="查询" style="width:60px;height:25px"
					onclick="showStock()" /> <input type="submit" value="导出Excel"
					style="width:90px;height:25px" /> <input type="button"
					name="create" id="newformbtn" value="新建"
					style="width:60px;height:25px" onclick="newform()" /> <input
					type="button" name="update" id="updateformbtn" value="修改"
					style="width:60px;height:25px" onclick="updateform()" />
				<!--  <input
					type="button" name="delete" id="deleteformbtn" value="删除"
					style="width:60px;height:25px" onclick="deleteform()" />-->
			</form>
		</div>
	</div>
	<!-- 隐藏“新建”按钮
	<script type="text/javascript">
	$("#newform").hide();
	</script>
	-->
	<div style="margin:0 auto; width:1100px">
		<table width="65%" height="142px" border="1" class="table1" id="stock">
			<tr id="stockhead">
				<td width="96">单位（吨）</td>
				<td width="87">LUANSHYA</td>
				<td width="79">KANSANSHI</td>
				<td width="72">LUMWANA</td>
				<td width="66">CHIBULUMA</td>
				<td width="76">ENRC矿</td>
				<td width="70">TF矿</td>
				<td width="66">COLD冷料</td>
				<td width="76">REVERTS</td>
				<td width="73">LUBAMBE</td>
				<td width="73">NFCA</td>
				<td width="73">BOLO</td>
				<td width="73">CCS矿</td>
			</tr>
			<tr id="stocklm">
				<td>计划库存</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="stocktm">
				<td>计划采购</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="stockcur">
				<td>目前库存</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div style="margin:0 auto; width:1100px">
		<table class="table1" width="750" border="1" id="mineral">
			<tr id="mineralhead">
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
			<tr id="mrow1">
				<td>1</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow2">
				<td>2</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow3">
				<td>3</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow4">
				<td>4</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow5">
				<td>8</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow6">
				<td>9</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow7">
				<td>10</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow8">
				<td>11</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow9">
				<td>12</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="mrow10">
				<td>-</td>
				<td>模块输入成分concentrate</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div style="margin:0 auto; width:1500px; padding-left:8%;">
		<fieldset style="width:500px; float:left">
			<legend>换料后 after change</legend>
			<table width="400" border="0" style="text-align:center">
				<tr style="height:115px">
					<td>富氧浓度(%)oxygen in lance</td>
					<td><input name="after01" type="text" id="oxyconc"
						readonly="readonly" />
					</td>
					<td>目标冰铜品位(%)target control matte grade</td>
					<td><input name="after02" type="text" id="real_Matte"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>数模(%)target matte grade</td>
					<td><input name="after03" type="text" id="digifax"
						readonly="readonly" />
					</td>
					<td>目标Fe3O4 target magnetic iron</td>
					<td><input name="after04" type="text" id="real_Fe3O4"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>氧料比oxygen/material ratio</td>
					<td><input name="after05" type="text" id="fuelratio"
						readonly="readonly" />
					</td>
					<td>目标SiO2/Fe target SiO2/Fe</td>
					<td><input name="after06" type="text" id="real_SiO2Fe"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>风量blow wind</td>
					<td><input name="after07" type="text" id="airvolume"
						readonly="readonly" />
					</td>
					<td>目标SiO2/CaO target SiO2/CaO</td>
					<td><input name="after08" type="text" id="real_SiO2CaO"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>补SiO2(T/h)</td>
					<td><input name="after09" type="text" id="sup_SiO2"
						readonly="readonly" />
					</td>
					<td>补入CaO(T/h)</td>
					<td><input name="after10" type="text" id="sup_CaO"
						readonly="readonly" />
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:500px; float:left">
			<legend>换料前 before change</legend>
			<table width="400" border="0" style="text-align:center">
				<tr style="height:115px">
					<td>富氧浓度(%)oxygen in lance</td>
					<td><input name="before01" type="text" id="pre_oxyconc"
						readonly="readonly" />
					</td>
					<td>实际冰铜品位(%)reality matte grade</td>
					<td><input name="before02" type="text" id="pre_real_matte"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>数模(%)target matte grade</td>
					<td><input name="before03" type="text" id="pre_digifax"
						readonly="readonly" />
					</td>
					<td>实际Fe3O4 reality magnetic iron</td>
					<td><input name="before04" type="text" id="pre_real_Fe3O4"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>氧料比oxygen/material ratio</td>
					<td><input name="before05" type="text" id="pre_fuelratio"
						readonly="readonly" />
					</td>
					<td>实际SiO2/Fe reality SiO2/Fe</td>
					<td><input name="before06" type="text" id="pre_real_SiO2Fe"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>风量blow wind</td>
					<td><input name="before07" type="text" id="pre_airvolume"
						readonly="readonly" />
					</td>
					<td>实际SiO2/CaO SiO2/CaO reality</td>
					<td><input name="before08" type="text" id="pre_real_SiO2CaO"
						readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>补SiO2(T/h)</td>
					<td><input name="before09" type="text" id="pre_sup_SiO2"
						readonly="readonly" />
					</td>
					<td>补入CaO(T/h)</td>
					<td><input name="before10" type="text" id="pre_sup_CaO"
						readonly="readonly" />
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div></div>
	<%
		// 下料员登录，隐藏无权操作的按钮和链接
			if ("下料员".equals(userstyle)) {
	%>
	<script type="text/javascript">
		$("#newform").hide();
		$("#newuser").hide();
		$("#newformbtn").hide();
		$("#updateformbtn").hide();
		$("#deleteformbtn").hide();
	</script>
	<%
		}
		}
	%>
</body>
</html>
