<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>下料情况记录</title>
<link href="charger_sheet_query.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="date.css" />
<script type="text/javascript" src="date_re.js"></script>
<!-- 导入jQuery -->
<script type="text/javascript" src="jquery-1.4.min.js"></script> 
<!-- 导入异步查询文件 -->
<script type="text/javascript" src="ajaxQuery_2.js"></script>
<script type="text/javascript">
	//是否可以增加记录
	function Is_add() {
		select();
		document.getElementById("text1").value = document
				.getElementById("text1_").value;
		document.getElementById("text2").value = document
				.getElementById("text2_").value;
		document.getElementById("text3").value = document
				.getElementById("text3_").value;
		document.getElementById("text5").value = document
				.getElementById("text5_").value;
		document.getElementById("text7").value = document
				.getElementById("text7_").value;
		document.getElementById("text9").value = document
				.getElementById("text9_").value;
		var text1 = document.getElementById("text1").value;
		var text2 = document.getElementById("text2").value;
		var text3 = document.getElementById("text3").value;
		var text4 = document.getElementById("text4").value;
		var text5 = document.getElementById("text5").value;
		var text6 = document.getElementById("text6").value;
		var text7 = document.getElementById("text7").value;
		var text8 = document.getElementById("text8").value;
		var text9 = document.getElementById("text9").value;
		var text10 = document.getElementById("text10").value;
		var text11 = document.getElementById("text11").value;
		var text12 = document.getElementById("text12").value;
		var text13 = document.getElementById("text13").value;
		var text14 = document.getElementById("text14").value;
		var text15 = document.getElementById("text15").value;
		var text16 = document.getElementById("text16").value;
		var text17 = document.getElementById("text17").value;
		var text18 = document.getElementById("text18").value;
		var text19 = document.getElementById("text19").value;
		var text20 = document.getElementById("text20").value;
		var text21 = document.getElementById("text21").value;
		var text22 = document.getElementById("text22").value;
		var text26 = document.getElementById("text26").value;
		var text27 = document.getElementById("text27").value;
		var text28 = document.getElementById("text28").value;
		var text29 = document.getElementById("text29").value;
		var text30 = document.getElementById("text30").value;
		var text31 = document.getElementById("text31").value;
		var texth11 = document.getElementById("texth11").value;
		var texth12 = document.getElementById("texth12").value;
        var texth13 = document.getElementById("texth13").value;
        var texth14 = document.getElementById("texth14").value;
        var texth15 = document.getElementById("texth15").value;
		var lastgrade = document.getElementById("textlastgrade").value;
		var oxypur = document.getElementById("textoxypur").value;
		var oxyconc = document.getElementById("textoxyconc").value;
		if(parseInt(lastgrade) > 10 || parseInt(lastgrade) < 1){
			alert("上次熔炼情况评分范围必须在1~10之间！");
			return false;
		}
		if (text1 == "" || text2 == "" || text3 == "" || text4 == ""
				|| text5 == "" || text6 == "" || text7 == "" || text8 == ""
				|| text9 == "" || text10 == "" || text11 == "" || text12 == ""
				|| text13 == "" || text14 == "" || text15 == "" || text16 == ""
				|| text17 == "" || text18 == "" || text19 == "" || text20 == ""
				|| text21 == "" || text22 == "" || text26 == "" || text27 == ""
				|| text28 == "" || text29 == "" || text30 == "" || text31 == ""
				|| texth11 == "" || texth12 == "" || texth13 == "" || texth14 == "" || texth15 == ""
				|| oxypur == "" || oxyconc == "") {
			alert("操作失败！" + '\n' + "请确认所有数据已填写！");
			return false;
		} else if(lastgrade == ""){
			if(text2 > 1){
				alert("操作失败！" + '\n' + "请填写上次熔炼状况评分！")
				return false;
			}
		}else{
			return true;
		}
	}
	//是否可以修改记录
	function Is_update() {
		select_();
		// 7月11日增加：修改记录可以绕过样号直接修改导致错误
		var sampleNo = $("#sampleNo_").find("option:selected").text();
		if (sampleNo == "" || isNaN(sampleNo)) {
			alert("请选择一个样号！");
			return false;
		}
		var text1 = document.getElementById("text_01").value;
		var text2 = document.getElementById("text_02").value;
		var text3 = document.getElementById("text_03").value;
		var text4 = document.getElementById("text_04").value;
		var text5 = document.getElementById("text_05").value;
		var text6 = document.getElementById("text_06").value;
		var text7 = document.getElementById("text_07").value;
		var text8 = document.getElementById("text_08").value;
		var text9 = document.getElementById("text_09").value;
		var text10 = document.getElementById("text_10").value;
		var text11 = document.getElementById("text_11").value;
		var text12 = document.getElementById("text_12").value;
		var text13 = document.getElementById("text_13").value;
		var text14 = document.getElementById("text_14").value;
		var text15 = document.getElementById("text_15").value;
		var text16 = document.getElementById("text_16").value;
		var text17 = document.getElementById("text_17").value;
		var text18 = document.getElementById("text_18").value;
		var text19 = document.getElementById("text_19").value;
		var text20 = document.getElementById("text_20").value;
		var text21 = document.getElementById("text_21").value;
		var text22 = document.getElementById("text_22").value;
		var text26 = document.getElementById("text_26").value;
		var text27 = document.getElementById("text_27").value;
		var text28 = document.getElementById("text_28").value;
		var text29 = document.getElementById("text_29").value;
		var text30 = document.getElementById("text_30").value;
		var text31 = document.getElementById("text_31").value;
		var texth11 = document.getElementById("text_h11").value;
		var texth12 = document.getElementById("text_h12").value;
        var texth13 = document.getElementById("text_h13").value;
        var texth14 = document.getElementById("text_h14").value;
        var texth15 = document.getElementById("text_h15").value;
		var textgrade = document.getElementById("text_grade").value;
		var oxypur = document.getElementById("text_oxypur").value;
		var oxyconc = document.getElementById("text_oxyconc").value;
		// 熔炼情况评分字段范围判定
		if(parseInt(textgrade) > 10 || parseInt(textgrade) < 1){
			alert("熔炼情况评分范围必须在1~10之间！");
			return false;
		}
		if (text1 == "" || text2 == "" || text3 == "" || text4 == ""
				|| text5 == "" || text6 == "" || text7 == "" || text8 == ""
				|| text9 == "" || text10 == "" || text11 == "" || text12 == ""
				|| text13 == "" || text14 == "" || text15 == "" || text16 == ""
				|| text17 == "" || text18 == "" || text19 == "" || text20 == ""
				|| text21 == "" || text22 == "" || text26 == "" || text27 == ""
				|| text28 == "" || text29 == "" || text30 == "" || text31 == ""
				|| texth11 == "" || texth12 == "" || textgrade == ""
            	|| texth13 == "" || texth14 == "" || texth15 == ""
				|| oxypur == "" || oxyconc == "") {
			alert("操作失败！" + '\n' + "请确认所有数据已填写");
			return false;
		} else
			return true;
	}
	function select() {
		document.getElementById("text11").value = document
				.getElementById("magnetic_force").value;
		document.getElementById("text12").value = document
				.getElementById("drum_hole").value;
		document.getElementById("text13").value = document
				.getElementById("color").value;

	}
	function select_() {
		document.getElementById("text_11").value = document
				.getElementById("magnetic_force_").value;
		document.getElementById("text_12").value = document
				.getElementById("drum_hole_").value;
		document.getElementById("text_13").value = document
				.getElementById("color_").value;

	}
	function checkNum(value) {
		if (isNaN(document.getElementById(value).value)) {
			alert("填入的信息有错误！" + '\n' + "该信息只能填写数字");
			document.getElementById(value).value = "";
		} else {

		}
	}
</script>
</head>

<body style="background-image: url('img/bg_02.jpg');">
	<%
		if (session.getAttribute("username") == null) {
			out.println("您还没有登录，无权访问此页面！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/index.jsp'> ");
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
					<td id="newuser"><a href="addUser.jsp">添加使用者</a></td>
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
					<td><a href="/CCS/mainform.jsp">配料单查询</a></td>
					<td width="10px">&nbsp;</td>
					<td style="font-weight:bold">下料情况记录</td>
				</tr>
			</table>
		</div>
	</div>
	<hr width="1100px" />
	<div class="title">下料情况记录</div>
	<div class="query" style="background-color:#87CEEB;">
		<div style="float:left;width:1100px;text-align:center;">
			<form action="/CCS/DownLoadProductionExcel.servlet"
				onsubmit="return getNumber();">
				日期：<input type="text" name="date" class="tcal" id="date" /> 配料单号：<select
					style="width:150px" id="numid" name="numid"></select> <input
					type="hidden" name="number" id="number" /> <b>&nbsp;</b><input
					type="button" name="search" value="查询"
					style="width:60px;height:25px" onclick="getProduction()" /> <b>&nbsp;</b>
				<input type="submit" name="excel" value="导出Excel"
					style="width:100px;height:25px" />
			</form>
		</div>
	</div>
	<hr width="1100px" />
	<div
		style="margin:0 auto; width:1100px; height:310px; overflow:auto; margin-top:15px; margin-bottom:10px">
		<table width="2200" border="1" height="300" id="production">
			<tr id="productionhead">
				<td>添加时间</td>
				<td>当班人</td>
				<td>班次</td>
				<td>样号</td>
				<td>目标冰铜品位</td>
				<td>实际冰铜品位</td>
				<td>目标磁性铁</td>
				<td>实际化验室磁性铁</td>
				<td>目标硅铁比</td>
				<td>实际硅铁比</td>
				<td>目标硅钙比</td>
				<td>实际硅钙比</td>
				<td>渣样磁条磁力大小</td>
				<td>断面气泡孔</td>
				<td>渣样颜色</td>
				<td>喷枪端压</td>
				<td>取样时氧料比</td>
				<td>取样时小时料量</td>
				<td>排放时间</td>
				<td>测样时的风量</td>
				<td>氧气纯度</td>
				<td>富氧浓度</td>
				<td>测样时料仓1#下料量</td>
				<td>2#</td>
				<td>3#</td>
				<td>4#</td>
				<td>5#钙辅料仓</td>
				<td>6#沙辅料仓</td>
				<td>7#煤辅料仓</td>
				<td>8#</td>
				<td>9#</td>
				<td>10#</td>
				<td>11#</td>
				<td>12#</td>
				<td>13#</td>
				<td>14#</td>
				<td>15#</td>
				<td>熔炼状况评分</td>
			</tr>
			<tr id="prow1">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow2">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow3">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow4">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow5">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow6">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow7">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow8">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr id="prow9">
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
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<hr width="1100px" />
	<div style="margin:0 auto; width:1100px; margin-top:10px" id="div_id">
		<fieldset style="width:1100px;">
			<legend>删除/修改记录</legend>
			配料单号：<select style="width:150px" id="numid_" name="numid"></select>
			样号：<select style="width:150px" id="sampleNo_" name="sampleNo"
				onchange="getOneData()"></select>
			<hr />
			<form action="/CCS/updateRecordToProduction.servlet"
				onsubmit="return Is_update();">
				<div style="width:1000px;overflow:auto;float:left;border:groove">
					<table width="2200" border="1">
						<tr>
							<td style="text-align: center;">配料单号</td>
							<td style="text-align: center;">当班人</td>
							<td style="text-align: center;">班次</td>
							<td style="text-align: center;">样号</td>
							<td style="text-align: center;">目标冰铜品位</td>
							<td style="text-align: center;">实际冰铜品位</td>
							<td style="text-align: center;">目标磁性铁</td>
							<td style="text-align: center;">实际化验室磁性铁</td>
							<td style="text-align: center;">目标硅铁比</td>
							<td style="text-align: center;">实际硅铁比</td>
							<td style="text-align: center;">目标硅钙比</td>
							<td style="text-align: center;">实际硅钙比</td>
							<td style="text-align: center;">渣样磁条磁力大小</td>
							<td style="text-align: center;">断面气泡孔</td>
							<td style="text-align: center;">渣样颜色</td>
							<td style="text-align: center;">喷枪端压</td>
							<td style="text-align: center;">取样时氧料比</td>
							<td style="text-align: center;">取样时小时料量</td>
							<td style="text-align: center;">排放时间</td>
							<td style="text-align: center;">测样时的风量</td>
							<td style="text-align: center;">氧气纯度</td>
							<td style="text-align: center;">富氧浓度</td>
							<td style="text-align: center;">测样时料仓1#下料量</td>
							<td style="text-align: center;">2#</td>
							<td style="text-align: center;">3#</td>
							<td style="text-align: center;">4#</td>
							<td style="text-align: center;">5#钙辅料仓</td>
							<td style="text-align: center;">6#沙辅料仓</td>
							<td style="text-align: center;">7#煤辅料仓</td>
							<td style="text-align: center;">8#</td>
							<td style="text-align: center;">9#</td>
							<td style="text-align: center;">10#</td>
							<td style="text-align: center;">11#</td>
							<td style="text-align: center;">12#</td>
							<td style="text-align: center;">13#</td>
							<td style="text-align: center;">14#</td>
							<td style="text-align: center;">15#</td>
							<td style="text-align: center;">熔炼状况评分</td>
						</tr>
						<tr>
							<td style="text-align: center;"><input id="text_01"
								type="text" style="width:90px" name="number" readonly="readonly" />
								<input id="text_29" type="hidden" style="width:90px" name="date"
								readonly="readonly" />
							</td>
							<td><input id="text_30" type="text" style="width:90px"
								name="produceNo" />
							</td>
							<td><input id="text_31" type="text" style="width:90px"
								name="duty" />
							</td>
							<td style="text-align: center;"><input id="text_02"
								type="text" style="width:35px" name="sampleNo"
								readonly="readonly" />
							</td>
							<td style="text-align: center;"><input id="text_03"
								type="text" style="width:90px" name="targetMatte"
								readonly="readonly" onblur="checkNum('text_03')" />
							</td>
							<td style="text-align: center;"><input id="text_04"
								type="text" style="width:90px" name="factMatte"
								onblur="checkNum('text_04')" />
							</td>
							<td style="text-align: center;"><input id="text_05"
								type="text" style="width:90px" name="targetMagIron"
								readonly="readonly" onblur="checkNum('text_05')" />
							</td>
							<td style="text-align: center;"><input id="text_06"
								type="text" style="width:90px" name="factMagIron"
								onblur="checkNum('text_06')" />
							</td>
							<td style="text-align: center;"><input id="text_07"
								type="text" style="width:90px" name="targetSiO2Fe"
								readonly="readonly" onblur="checkNum('text_07')" />
							</td>
							<td style="text-align: center;"><input id="text_08"
								type="text" style="width:90px" name="factSiO2Fe"
								onblur="checkNum('text_08')" />
							</td>
							<td style="text-align: center;"><input id="text_09"
								type="text" style="width:90px" name="targetSiO2CaO"
								readonly="readonly" onblur="checkNum('text_09')" />
							</td>
							<td style="text-align: center;"><input id="text_10"
								type="text" style="width:90px" name="factSiO2CaO"
								onblur="checkNum('text_10')" />
							</td>
							<td style="text-align: center;"><input id="text_11"
								type="hidden" style="width:90px" name="magnetic_force" /> <select
								id="magnetic_force_">
									<option>没有磁力</option>
									<option>弱磁力</option>
									<option>中等磁力</option>
									<option>较强磁力</option>
									<option>强磁力</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text_12"
								type="hidden" style="width:90px" name="drum_hole" /> <select
								id="drum_hole_">
									<option>没有</option>
									<option>较少</option>
									<option>少</option>
									<option>适中</option>
									<option>多</option>
									<option>较多</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text_13"
								type="hidden" style="width:90px" name="color" /> <select
								id="color_">
									<option>白色</option>
									<option>红色</option>
									<option>黑色</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text_14"
								type="text" style="width:90px" name="nozzle_pressure"
								onblur="checkNum('text_14')" />
							</td>
							<td style="text-align: center;"><input id="text_15"
								type="text" style="width:90px" name="fuel_ratio"
								onblur="checkNum('text_15')" />
							</td>
							<td style="text-align: center;"><input id="text_16"
								type="text" style="width:90px" name="amountPerHour"
								onblur="checkNum('text_16')" />
							</td>
							<td style="text-align: center;"><input id="text_17"
								type="text" style="width:90px" name="time"
								onblur="checkNum('text_17')" />
							</td>
							<td style="text-align: center;"><input id="text_18"
								type="text" style="width:90px" name="air_volume"
								onblur="checkNum('text_18')" />
							</td>
							<td style="text-align: center;"><input id="text_oxypur"
								type="text" style="width:90px" name="oxypur"
								onblur="checkNum('text_oxypur')" />
							</td>
							<td style="text-align: center;"><input id="text_oxyconc"
								type="text" style="width:90px" name="oxyconc"
								onblur="checkNum('text_oxyconc')" />
							</td>
							<td style="text-align: center;"><input id="text_19"
								type="text" style="width:90px" name="h1used"
								onblur="checkNum('text_19')" />
							</td>
							<td style="text-align: center;"><input id="text_20"
								type="text" style="width:90px" name="h2used"
								onblur="checkNum('text_20')" />
							</td>
							<td style="text-align: center;"><input id="text_21"
								type="text" style="width:90px" name="h3used"
								onblur="checkNum('text_21')" />
							</td>
							<td style="text-align: center;"><input id="text_22"
								type="text" style="width:90px" name="h4used"
								onblur="checkNum('text_22')" />
							</td>
							<td style="text-align: center;"><input id="text_23"
								type="text" style="width:90px" name="h5used"
								onblur="checkNum('text_23')" />
							</td>
							<td style="text-align: center;"><input id="text_24"
								type="text" style="width:90px" name="h6used"
								onblur="checkNum('text_24')" />
							</td>
							<td style="text-align: center;"><input id="text_25"
								type="text" style="width:90px" name="h7used"
								onblur="checkNum('text_25')" />
							</td>
							<td style="text-align: center;"><input id="text_26"
								type="text" style="width:90px" name="h8used"
								onblur="checkNum('text_26')" />
							</td>
							<td style="text-align: center;"><input id="text_27"
								type="text" style="width:90px" name="h9used"
								onblur="checkNum('text_27')" />
							</td>
							<td style="text-align: center;"><input id="text_28"
								type="text" style="width:90px" name="h10used"
								onblur="checkNum('text_28')" />
							</td>
							<td style="text-align: center;"><input id="text_h11"
								type="text" style="width:90px" name="h11used"
								onblur="checkNum('text_h11')" />
							</td>
							<td style="text-align: center;"><input id="text_h12"
								type="text" style="width:90px" name="h12used"
								onblur="checkNum('text_h12')" />
							</td>
							<td style="text-align: center;"><input id="text_h13"
																   type="text" style="width:90px" name="h13used"
																   onblur="checkNum('text_h13')" />
							</td>
							<td style="text-align: center;"><input id="text_h14"
																   type="text" style="width:90px" name="h14used"
																   onblur="checkNum('text_h14')" />
							</td>
							<td style="text-align: center;"><input id="text_h15"
																   type="text" style="width:90px" name="h15used"
																   onblur="checkNum('text_h15')" />
							</td>
							<td style="text-align: center;"><input id="text_grade"
								type="text" style="width:90px" name="grade"
								onblur="checkNum('text_grade')" />
							</td>
						</tr>
					</table>
				</div>
				<div align="center" style=" padding:10px; ">
					<input type="button" value="删除记录" style="height:30px"
						onclick="deleteRecord()" />
					<p></p>
					<input type="submit" value="修改记录" style="height:30px" />
				</div>
			</form>
		</fieldset>
	</div>
	<hr width="1100px" />
	<div style="margin:0 auto; width:1100px; margin-top:10px">
		<fieldset style="width:1100px;">
			<legend>增加记录</legend>
			<form action="/CCS/insertToproduction.servlet"
				onsubmit="return Is_add();">
				<div style="width:1000px;overflow:auto;float:left;border:groove">

					<table width="2200" border="1">
						<tr>
							<td style="text-align: center;">配料单号</td>
							<td style="text-align: center;">当班人</td>
							<td style="text-align: center;">班次</td>
							<td style="text-align: center;">样号</td>
							<td style="text-align: center;">目标冰铜品位</td>
							<td style="text-align: center;">实际冰铜品位</td>
							<td style="text-align: center;">目标磁性铁</td>
							<td style="text-align: center;">实际化验室磁性铁</td>
							<td style="text-align: center;">目标硅铁比</td>
							<td style="text-align: center;">实际硅铁比</td>
							<td style="text-align: center;">目标硅钙比</td>
							<td style="text-align: center;">实际硅钙比</td>
							<td style="text-align: center;">渣样磁条磁力大小</td>
							<td style="text-align: center;">断面气泡孔</td>
							<td style="text-align: center;">渣样颜色</td>
							<td style="text-align: center;">喷枪端压</td>
							<td style="text-align: center;">取样时氧料比</td>
							<td style="text-align: center;">取样时小时料量</td>
							<td style="text-align: center;">排放时间</td>
							<td style="text-align: center;">测样时的风量</td>
							<td style="text-align: center;">氧气纯度</td>
							<td style="text-align: center;">富氧浓度</td>
							<td style="text-align: center;">测样时料仓1#下料量</td>
							<td style="text-align: center;">2#</td>
							<td style="text-align: center;">3#</td>
							<td style="text-align: center;">4#</td>
							<td style="text-align: center;">5#钙辅料仓</td>
							<td style="text-align: center;">6#沙辅料仓</td>
							<td style="text-align: center;">7#煤辅料仓</td>
							<td style="text-align: center;">8#</td>
							<td style="text-align: center;">9#</td>
							<td style="text-align: center;">10#</td>
							<td style="text-align: center;">11#</td>
							<td style="text-align: center;">12#</td>
							<td style="text-align: center;">13#</td>
							<td style="text-align: center;">14#</td>
							<td style="text-align: center;">15#</td>
							<td style="text-align: center;">
							<font color = "#FF0000"><b>上次</b></font>熔炼状况评分
							</td>
						</tr>
						<tr>
							<td style="text-align: center;"><input id="text1_"
								type="text" style="width:90px" disabled="disabled" /> <input
								id="text1" type="hidden" style="width:90px" name="number" /> <input
								id="text29" type="hidden" style="width:90px" name="date" />
							</td>
							<td><input id="text30" type="text" style="width:90px"
								name="produceNo" />
							</td>
							<td><input id="text31" type="text" style="width:90px"
								name="duty" />
							</td>
							<td style="text-align: center;"><input id="text2_"
								type="text" style="width:35px" disabled="disabled" /> <input
								id="text2" type="hidden" style="width:35px" name="sampleNo" />
							</td>
							<td style="text-align: center;"><input id="text3_"
								type="text" style="width:90px" disabled="disabled" /> <input
								id="text3" type="hidden" style="width:90px" name="targetMatte" />
							</td>
							<td style="text-align: center;"><input id="text4"
								type="text" style="width:90px" name="factMatte"
								onblur="checkNum('text4')" />
							</td>
							<td style="text-align: center;"><input id="text5_"
								type="text" style="width:90px" disabled="disabled" /> <input
								id="text5" type="hidden" style="width:90px" name="targetMagIron" />
							</td>
							<td style="text-align: center;"><input id="text6"
								type="text" style="width:90px" name="factMagIron"
								onblur="checkNum('text6')" />
							</td>
							<td style="text-align: center;"><input id="text7_"
								type="text" style="width:90px" disabled="disabled" /> <input
								id="text7" type="hidden" style="width:90px" name="targetSiO2Fe" />
							</td>
							<td style="text-align: center;"><input id="text8"
								type="text" style="width:90px" name="factSiO2Fe"
								onblur="checkNum('text8')" />
							</td>
							<td style="text-align: center;"><input id="text9_"
								type="text" style="width:90px" disabled="disabled" /> <input
								id="text9" type="hidden" style="width:90px" name="targetSiO2CaO" />
							</td>
							<td style="text-align: center;"><input id="text10"
								type="text" style="width:90px" name="factSiO2CaO"
								onblur="checkNum('text10')" />
							</td>
							<td style="text-align: center;"><input id="text11"
								type="hidden" style="width:90px" name="magnetic_force" /> <select
								id="magnetic_force">
									<option>没有磁力</option>
									<option>弱磁力</option>
									<option>中等磁力</option>
									<option>较强磁力</option>
									<option>强磁力</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text12"
								type="hidden" style="width:90px" name="drum_hole" /> <select
								id="drum_hole">
									<option>没有</option>
									<option>较少</option>
									<option>少</option>
									<option>适中</option>
									<option>多</option>
									<option>较多</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text13"
								type="hidden" style="width:90px" name="color" /> <select
								id="color">
									<option>白色</option>
									<option>红色</option>
									<option>黑色</option>
							</select>
							</td>
							<td style="text-align: center;"><input id="text14"
								type="text" style="width:90px" name="nozzle_pressure"
								onblur="checkNum('text14')" />
							</td>
							<td style="text-align: center;"><input id="text15"
								type="text" style="width:90px" name="fuel_ratio"
								onblur="checkNum('text15')" />
							</td>
							<td style="text-align: center;"><input id="text16"
								type="text" style="width:90px" name="amountPerHour"
								onblur="checkNum('text16')" />
							</td>
							<td style="text-align: center;"><input id="text17"
								type="text" style="width:90px" name="time"
								onblur="checkNum('text17')" />
							</td>
							<td style="text-align: center;"><input id="text18"
								type="text" style="width:90px" name="air_volume"
								onblur="checkNum('text18')" />
							</td>
							<td style="text-align: center;"><input id="textoxypur"
								type="text" style="width:90px" name="oxypur"
								onblur="checkNum('textoxypur')" />
							</td>
							<td style="text-align: center;"><input id="textoxyconc"
								type="text" style="width:90px" name="oxyconc"
								onblur="checkNum('textoxyconc')" />
							</td>
							<td style="text-align: center;"><input id="text19"
								type="text" style="width:90px" name="h1used"
								onblur="checkNum('text19')" />
							</td>
							<td style="text-align: center;"><input id="text20"
								type="text" style="width:90px" name="h2used"
								onblur="checkNum('text20')" />
							</td>
							<td style="text-align: center;"><input id="text21"
								type="text" style="width:90px" name="h3used"
								onblur="checkNum('text21')" />
							</td>
							<td style="text-align: center;"><input id="text22"
								type="text" style="width:90px" name="h4used"
								onblur="checkNum('text22')" />
							</td>
							<td style="text-align: center;"><input id="text23"
								type="text" style="width:90px" name="h5used"
								onblur="checkNum('text23')" />
							</td>
							<td style="text-align: center;"><input id="text24"
								type="text" style="width:90px" name="h6used"
								onblur="checkNum('text24')" />
							</td>
							<td style="text-align: center;"><input id="text25"
								type="text" style="width:90px" name="h7used"
								onblur="checkNum('text25')" />
							</td>
							<td style="text-align: center;"><input id="text26"
								type="text" style="width:90px" name="h8used"
								onblur="checkNum('text26')" />
							</td>
							<td style="text-align: center;"><input id="text27"
								type="text" style="width:90px" name="h9used"
								onblur="checkNum('text27')" />
							</td>
							<td style="text-align: center;"><input id="text28"
								type="text" style="width:90px" name="h10used"
								onblur="checkNum('text28')" />
							</td>
							<td style="text-align: center;"><input id="texth11"
								type="text" style="width:90px" name="h11used"
								onblur="checkNum('texth11')" />
							</td>
							<td style="text-align: center;"><input id="texth12"
								type="text" style="width:90px" name="h12used"
								onblur="checkNum('texth12')" />
							</td>
							<td style="text-align: center;"><input id="texth13" 
								type="text" style="width:90px" name="h13used"
								onblur="checkNum('texth13')" />
							</td>
							<td style="text-align: center;"><input id="texth14"
																   type="text" style="width:90px" name="h14used"
																   onblur="checkNum('texth14')" />
							</td>
							<td style="text-align: center;"><input id="texth15"
																   type="text" style="width:90px" name="h15used"
																   onblur="checkNum('texth15')" />
							</td>
							<td style="text-align: center;"><input id="textlastgrade"
								type="text" style="width:90px" name="lastgrade"
								onblur="checkNum('textlastgrade')" />
							</td>
						</tr>
					</table>
				</div>
				<div align="center" style=" padding:10px; ">
					<p></p>
					<input type="submit" value="新增记录" style="height:30px" />
				</div>
			</form>
			<!-- 从JSP得到Servlet中传来的数值 -->
			<%
				String result = (String) request.getAttribute("result");
					String userstyle = (String) session.getAttribute("style");
					String result_ = (String) request.getAttribute("Result");
			%>
			<%
				if ("Update is OK".equals(result_)) {
			%>
			<script type="text/javascript">
				alert("修改记录成功！" + '\n' + "请重新查询记录！");
				window.location.href = "material_records.jsp";
			</script>
			<%
				}
			%>
			<%
				if ("Insert is OK".equals(result)) {
			%>
			<script type="text/javascript">
				alert("增加记录成功！" + '\n' + "请重新查询记录！");
				window.location.href = "material_records.jsp";
			</script>
			<%
				}
			%>
			<%
				if ("The user is not logged in".equals(result)) {
			%>
			<script type="text/javascript">
				alert("对不起！你还没有登录，无权进行该操作！" + '\n' + "点击“确定”按钮，返回登陆界面。");
				url = "index.jsp?backurl=" + window.location.href;
				setTimeout("window.location.href=url", 0);
			</script>
			<%
				}
					// 下料员登录，隐藏无权操作的按钮和链接
					if ("下料员".equals(userstyle)) {
			%>
			<script type="text/javascript">
				$("#newform").hide();
				$("#newuser").hide();
				$("#div_id").hide();
			</script>
		</fieldset>
	</div>
	<%
		}
		}
	%>
</body>
</html>

