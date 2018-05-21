function IsAllFilled() {
	var lm1 = document.getElementById("lm1").value;
	var lm2 = document.getElementById("lm2").value;
	var lm3 = document.getElementById("lm3").value;
	var lm4 = document.getElementById("lm4").value;
	var lm5 = document.getElementById("lm5").value;
	var lm6 = document.getElementById("lm6").value;
	var lm7 = document.getElementById("lm7").value;
	var lm8 = document.getElementById("lm8").value;
	var lm9 = document.getElementById("lm9").value;
	var lm10 = document.getElementById("lm10").value;
	var lm11 = document.getElementById("lm11").value;
	var lm12 = document.getElementById("lm12").value;
	var tm1 = document.getElementById("tm1").value;
	var tm2 = document.getElementById("tm2").value;
	var tm3 = document.getElementById("tm3").value;
	var tm4 = document.getElementById("tm4").value;
	var tm5 = document.getElementById("tm5").value;
	var tm6 = document.getElementById("tm6").value;
	var tm7 = document.getElementById("tm7").value;
	var tm8 = document.getElementById("tm8").value;
	var tm9 = document.getElementById("tm9").value;
	var tm10 = document.getElementById("tm10").value;
	var tm11 = document.getElementById("tm11").value;
	var tm12 = document.getElementById("tm12").value;
	var cur1 = document.getElementById("cur1").value;
	var cur2 = document.getElementById("cur2").value;
	var cur3 = document.getElementById("cur3").value;
	var cur4 = document.getElementById("cur4").value;
	var cur5 = document.getElementById("cur5").value;
	var cur6 = document.getElementById("cur6").value;
	var cur7 = document.getElementById("cur7").value;
	var cur8 = document.getElementById("cur8").value;
	var cur9 = document.getElementById("cur9").value;
	var cur10 = document.getElementById("cur10").value;
	var cur11 = document.getElementById("cur11").value;
	var cur12 = document.getElementById("cur12").value;
	// 获得ingredient表对应的填写信息
	var NO1_Cu = document.getElementById("NO1_Cu").value;
	var NO1_Fe = document.getElementById("NO1_Fe").value;
	var NO1_S = document.getElementById("NO1_S").value;
	var NO1_Co = document.getElementById("NO1_Co").value;
	var NO1_SiO2 = document.getElementById("NO1_SiO2").value;
	var NO1_CaO = document.getElementById("NO1_CaO").value;
	var NO1_MgO = document.getElementById("NO1_MgO").value;
	var NO1_Al2O3 = document.getElementById("NO1_Al2O3").value;
	var NO2_Cu = document.getElementById("NO2_Cu").value;
	var NO2_Fe = document.getElementById("NO2_Fe").value;
	var NO2_S = document.getElementById("NO2_S").value;
	var NO2_Co = document.getElementById("NO2_Co").value;
	var NO2_SiO2 = document.getElementById("NO2_SiO2").value;
	var NO2_CaO = document.getElementById("NO2_CaO").value;
	var NO2_MgO = document.getElementById("NO2_MgO").value;
	var NO2_Al2O3 = document.getElementById("NO2_Al2O3").value;
	var NO3_Cu = document.getElementById("NO3_Cu").value;
	var NO3_Fe = document.getElementById("NO3_Fe").value;
	var NO3_S = document.getElementById("NO3_S").value;
	var NO3_Co = document.getElementById("NO3_Co").value;
	var NO3_SiO2 = document.getElementById("NO3_SiO2").value;
	var NO3_CaO = document.getElementById("NO3_CaO").value;
	var NO3_MgO = document.getElementById("NO3_MgO").value;
	var NO3_Al2O3 = document.getElementById("NO3_Al2O3").value;
	var NO4_Cu = document.getElementById("NO4_Cu").value;
	var NO4_Fe = document.getElementById("NO4_Fe").value;
	var NO4_S = document.getElementById("NO4_S").value;
	var NO4_Co = document.getElementById("NO4_Co").value;
	var NO4_SiO2 = document.getElementById("NO4_SiO2").value;
	var NO4_CaO = document.getElementById("NO4_CaO").value;
	var NO4_MgO = document.getElementById("NO4_MgO").value;
	var NO4_Al2O3 = document.getElementById("NO4_Al2O3").value;
	var NO8_Cu = document.getElementById("NO8_Cu").value;
	var NO8_Fe = document.getElementById("NO8_Fe").value;
	var NO8_S = document.getElementById("NO8_S").value;
	var NO8_Co = document.getElementById("NO8_Co").value;
	var NO8_SiO2 = document.getElementById("NO8_SiO2").value;
	var NO8_CaO = document.getElementById("NO8_CaO").value;
	var NO8_MgO = document.getElementById("NO8_MgO").value;
	var NO8_Al2O3 = document.getElementById("NO8_Al2O3").value;
	var NO9_Cu = document.getElementById("NO9_Cu").value;
	var NO9_Fe = document.getElementById("NO9_Fe").value;
	var NO9_S = document.getElementById("NO9_S").value;
	var NO9_Co = document.getElementById("NO9_Co").value;
	var NO9_SiO2 = document.getElementById("NO9_SiO2").value;
	var NO9_CaO = document.getElementById("NO9_CaO").value;
	var NO9_MgO = document.getElementById("NO9_MgO").value;
	var NO9_Al2O3 = document.getElementById("NO9_Al2O3").value;
	var NO10_Cu = document.getElementById("NO10_Cu").value;
	var NO10_Fe = document.getElementById("NO10_Fe").value;
	var NO10_S = document.getElementById("NO10_S").value;
	var NO10_Co = document.getElementById("NO10_Co").value;
	var NO10_SiO2 = document.getElementById("NO10_SiO2").value;
	var NO10_CaO = document.getElementById("NO10_CaO").value;
	var NO10_MgO = document.getElementById("NO10_MgO").value;
	var NO10_Al2O3 = document.getElementById("NO10_Al2O3").value;
	var NO11_Cu = document.getElementById("NO11_Cu").value;
	var NO11_Fe = document.getElementById("NO11_Fe").value;
	var NO11_S = document.getElementById("NO11_S").value;
	var NO11_Co = document.getElementById("NO11_Co").value;
	var NO11_SiO2 = document.getElementById("NO11_SiO2").value;
	var NO11_CaO = document.getElementById("NO11_CaO").value;
	var NO11_MgO = document.getElementById("NO11_MgO").value;
	var NO11_Al2O3 = document.getElementById("NO11_Al2O3").value;
	var NO12_Cu = document.getElementById("NO12_Cu").value;
	var NO12_Fe = document.getElementById("NO12_Fe").value;
	var NO12_S = document.getElementById("NO12_S").value;
	var NO12_Co = document.getElementById("NO12_Co").value;
	var NO12_SiO2 = document.getElementById("NO12_SiO2").value;
	var NO12_CaO = document.getElementById("NO12_CaO").value;
	var NO12_MgO = document.getElementById("NO12_MgO").value;
	var NO12_Al2O3 = document.getElementById("NO12_Al2O3").value;
    var NO13_Cu = document.getElementById("NO13_Cu").value;
    var NO13_Fe = document.getElementById("NO13_Fe").value;
    var NO13_S = document.getElementById("NO13_S").value;
    var NO13_Co = document.getElementById("NO13_Co").value;
    var NO13_SiO2 = document.getElementById("NO13_SiO2").value;
    var NO13_CaO = document.getElementById("NO13_CaO").value;
    var NO13_MgO = document.getElementById("NO13_MgO").value;
    var NO13_Al2O3 = document.getElementById("NO13_Al2O3").value;
    var NO14_Cu = document.getElementById("NO14_Cu").value;
    var NO14_Fe = document.getElementById("NO14_Fe").value;
    var NO14_S = document.getElementById("NO14_S").value;
    var NO14_Co = document.getElementById("NO14_Co").value;
    var NO14_SiO2 = document.getElementById("NO14_SiO2").value;
    var NO14_CaO = document.getElementById("NO14_CaO").value;
    var NO14_MgO = document.getElementById("NO14_MgO").value;
    var NO14_Al2O3 = document.getElementById("NO14_Al2O3").value;
    var NO15_Cu = document.getElementById("NO15_Cu").value;
    var NO15_Fe = document.getElementById("NO15_Fe").value;
    var NO15_S = document.getElementById("NO15_S").value;
    var NO15_Co = document.getElementById("NO15_Co").value;
    var NO15_SiO2 = document.getElementById("NO15_SiO2").value;
    var NO15_CaO = document.getElementById("NO15_CaO").value;
    var NO15_MgO = document.getElementById("NO15_MgO").value;
    var NO15_Al2O3 = document.getElementById("NO15_Al2O3").value;
	// -----我是分割线-----
	var oxyconc = document.getElementById("oxyconc").value;
	var real_Matte = document.getElementById("real_Matte").value;
	var digifax = document.getElementById("digifax").value;
	var real_Fe3O4 = document.getElementById("real_Fe3O4").value;
	var fuelratio = document.getElementById("fuelratio").value;
	var real_SiO2Fe = document.getElementById("real_SiO2Fe").value;
	var airvolume = document.getElementById("airvolume").value;
	var real_SiO2CaO = document.getElementById("real_SiO2CaO").value;
	var sup_SiO2 = document.getElementById("sup_SiO2").value;
	var sup_CaO = document.getElementById("sup_CaO").value;
	var pre_oxyconc = document.getElementById("pre_oxyconc").value;
	var pre_real_matte = document.getElementById("pre_real_matte").value;
	var pre_digifax = document.getElementById("pre_digifax").value;
	var pre_real_Fe3O4 = document.getElementById("pre_real_Fe3O4").value;
	var pre_fuelratio = document.getElementById("pre_fuelratio").value;
	var pre_real_SiO2Fe = document.getElementById("pre_real_SiO2Fe").value;
	var pre_airvolume = document.getElementById("pre_airvolume").value;
	var pre_real_SiO2CaO = document.getElementById("pre_real_SiO2CaO").value;
	var pre_sup_SiO2 = document.getElementById("pre_sup_SiO2").value;
	var pre_sup_CaO = document.getElementById("pre_sup_CaO").value;
	var dosage1 = document.getElementById("dosage1").value;
	var dosage2 = document.getElementById("dosage2").value;
	var dosage3 = document.getElementById("dosage3").value;
	var dosage4 = document.getElementById("dosage4").value;
	var dosage8 = document.getElementById("dosage8").value;
	var dosage9 = document.getElementById("dosage9").value;
	var dosage10 = document.getElementById("dosage10").value;
	var dosage11 = document.getElementById("dosage11").value;
	var dosage12 = document.getElementById("dosage12").value;
    var dosage13 = document.getElementById("dosage13").value;
    var dosage14 = document.getElementById("dosage14").value;
    var dosage15 = document.getElementById("dosage15").value;
	if (lm1 == "" || lm2 == "" || lm3 == "" || lm4 == "" || lm5 == ""
			|| lm6 == "" || lm7 == "" || lm8 == "" || lm9 == "" || lm10 == ""
			|| lm11 == "" || lm12 == "" || tm1 == "" || tm2 == "" || tm3 == ""
			|| tm4 == "" || tm5 == "" || tm6 == "" || tm7 == "" || tm8 == ""
			|| tm9 == "" || tm10 == "" || tm11 == "" || tm12 == ""
			|| cur1 == "" || cur2 == "" || cur3 == "" || cur4 == ""
			|| cur5 == "" || cur6 == "" || cur7 == "" || cur8 == ""
			|| cur9 == "" || cur10 == "" || cur11 == "" || cur12 == ""
			|| oxyconc == "" || real_Matte == "" || digifax == ""
			|| real_Fe3O4 == "" || fuelratio == "" || real_SiO2Fe == ""
			|| airvolume == "" || real_SiO2CaO == "" || sup_SiO2 == ""
			|| sup_CaO == "" || pre_oxyconc == "" || pre_real_matte == ""
			|| pre_digifax == "" || pre_real_Fe3O4 == "" || pre_fuelratio == ""
			|| pre_real_SiO2Fe == "" || pre_airvolume == ""
			|| pre_real_SiO2CaO == "" || pre_sup_SiO2 == ""
			|| pre_sup_CaO == "" || NO1_Cu == "" || NO1_Fe == "" || NO1_S == ""
			|| NO1_Co == "" || NO1_SiO2 == "" || NO1_CaO == "" || NO1_MgO == ""
			|| NO1_Al2O3 == "" || NO2_Cu == "" || NO2_Fe == "" || NO2_S == ""
			|| NO2_Co == "" || NO2_SiO2 == "" || NO2_CaO == "" || NO2_MgO == ""
			|| NO2_Al2O3 == "" || NO3_Cu == "" || NO3_Fe == "" || NO3_S == ""
			|| NO3_Co == "" || NO3_SiO2 == "" || NO3_CaO == "" || NO3_MgO == ""
			|| NO3_Al2O3 == "" || NO4_Cu == "" || NO4_Fe == "" || NO4_S == ""
			|| NO4_Co == "" || NO4_SiO2 == "" || NO4_CaO == "" || NO4_MgO == ""
			|| NO4_Al2O3 == "" || NO8_Cu == "" || NO8_Fe == "" || NO8_S == ""
			|| NO8_Co == "" || NO8_SiO2 == "" || NO8_CaO == "" || NO8_MgO == ""
			|| NO8_Al2O3 == "" || NO9_Cu == "" || NO9_Fe == "" || NO9_S == ""
			|| NO9_Co == "" || NO9_SiO2 == "" || NO9_CaO == "" || NO9_MgO == ""
			|| NO9_Al2O3 == "" || NO10_Cu == "" || NO10_Fe == ""
			|| NO10_S == "" || NO10_Co == "" || NO10_SiO2 == ""
			|| NO10_CaO == "" || NO10_MgO == "" || NO10_Al2O3 == ""
			|| NO11_Cu == "" || NO11_Fe == "" || NO11_S == "" || NO11_Co == ""
			|| NO11_SiO2 == "" || NO11_CaO == "" || NO11_MgO == ""
			|| NO11_Al2O3 == "" || NO12_Cu == "" || NO12_Fe == ""
			|| NO12_S == "" || NO12_Co == "" || NO12_SiO2 == ""
			|| NO12_CaO == "" || NO12_MgO == "" || NO12_Al2O3 == ""
			|| NO13_Cu == "" || NO13_Fe == ""
			|| NO13_S == "" || NO13_Co == "" || NO13_SiO2 == ""
			|| NO13_CaO == "" || NO13_MgO == "" || NO13_Al2O3 == ""
			|| NO14_Cu == "" || NO14_Fe == ""
			|| NO14_S == "" || NO14_Co == "" || NO14_SiO2 == ""
			|| NO14_CaO == "" || NO14_MgO == "" || NO14_Al2O3 == ""
			|| NO15_Cu == "" || NO15_Fe == ""
			|| NO15_S == "" || NO15_Co == "" || NO15_SiO2 == ""
			|| NO15_CaO == "" || NO15_MgO == "" || NO15_Al2O3 == ""
			|| dosage1 == "" || dosage2 == "" || dosage3 == "" || dosage4 == ""
			|| dosage8 == "" || dosage9 == "" || dosage10 == ""
			|| dosage11 == "" || dosage12 == "" || dosage13 == "" || dosage14 == "" || dosage14 == "") {
		alert("操作失败！" + '\n' + "请确认所有数据已填写");
		return false;
	}
	if (isNaN(lm1) || isNaN(lm2) || isNaN(lm3) || isNaN(lm4) || isNaN(lm5)
			|| isNaN(lm6) || isNaN(lm7) || isNaN(lm8) || isNaN(lm9)
			|| isNaN(lm10) || isNaN(tm1) || isNaN(tm2) || isNaN(tm3)
			|| isNaN(tm4) || isNaN(tm5) || isNaN(tm6) || isNaN(tm7)
			|| isNaN(tm8) || isNaN(tm9) || isNaN(tm10) || isNaN(cur1)
			|| isNaN(cur2) || isNaN(cur3) || isNaN(cur4) || isNaN(cur5)
			|| isNaN(cur6) || isNaN(cur7) || isNaN(cur8) || isNaN(cur9)
			|| isNaN(cur10) || isNaN(oxyconc) || isNaN(real_Matte)
			|| isNaN(digifax) || isNaN(real_Fe3O4) || isNaN(fuelratio)
			|| isNaN(real_SiO2Fe) || isNaN(airvolume) || isNaN(real_SiO2CaO)
			|| isNaN(sup_SiO2) || isNaN(sup_CaO) || isNaN(pre_oxyconc)
			|| isNaN(pre_real_matte) || isNaN(pre_digifax)
			|| isNaN(pre_real_Fe3O4) || isNaN(pre_fuelratio)
			|| isNaN(pre_real_SiO2Fe) || isNaN(pre_airvolume)
			|| isNaN(pre_real_SiO2CaO) || isNaN(pre_sup_SiO2)
			|| isNaN(pre_sup_CaO) || isNaN(dosage1) || isNaN(dosage2)
			|| isNaN(dosage3) || isNaN(dosage4) || isNaN(dosage8)
			|| isNaN(dosage9) || isNaN(dosage10)|| isNaN(dosage11)
			|| isNaN(dosage12)|| isNaN(dosage13)|| isNaN(dosage14)|| isNaN(dosage15)) {
		alert("操作失败！" + '\n' + "所填写的内容必须为数字！");
		return false;
	}
	var d1 = parseFloat(dosage1);
	var d2 = parseFloat(dosage2);
	var d3 = parseFloat(dosage3);
	var d4 = parseFloat(dosage4);
	var d8 = parseFloat(dosage8);
	var d9 = parseFloat(dosage9);
	var d10 = parseFloat(dosage10);
	var d11 = parseFloat(dosage11);
	var d12 = parseFloat(dosage12);
    var d13 = parseFloat(dosage13);
    var d14 = parseFloat(dosage14);
    var d15 = parseFloat(dosage15);
	if (d1 > 60 || d1 < 0) {
		alert("1号仓用量超过规定范围！(0~60)" + '\n' + "请重新填写！");
		// document.getElementById("dosage1").style.backgroundColor = "#FFB5B5";
		return false;
	}
	if (d2 > 60 || d2 < 0) {
		alert("2号仓用量超过规定范围！(0~60)" + '\n' + "请重新填写！");
		return false;
	}
	if (d3 > 60 || d3 < 0) {
		alert("3号仓用量超过规定范围！(0~60)" + '\n' + "请重新填写！");
		return false;
	}
	if (d4 > 40 || d4 < 0) {
		alert("4号仓用量超过规定范围！(0~40)" + '\n' + "请重新填写！");
		return false;
	}
	if (d8 > 20 || d8 < 0) {
		alert("8号仓用量超过规定范围！(0~20)" + '\n' + "请重新填写！");
		return false;
	}
	if (d9 > 50 || d9 < 0) {
		alert("9号仓用量超过规定范围！(0~50)" + '\n' + "请重新填写！");
		return false;
	}
	if (d10 > 50 || d10 < 0) {
		alert("10号仓用量超过规定范围！(0~50)" + '\n' + "请重新填写！");
		return false;
	}
	if (d11 > 25 || d11 < 0) {
		alert("11号仓用量超过规定范围！(0~25)" + '\n' + "请重新填写！");
		return false;
	}
	if (d12 > 25 || d12 < 0) {
		alert("12号仓用量超过规定范围！(0~25)" + '\n' + "请重新填写！");
		return false;
	}
    if (d13 > 25 || d13 < 0) {
        alert("13号仓用量超过规定范围！(0~25)" + '\n' + "请重新填写！");
        return false;
    }
    if (d14 > 25 || d14 < 0) {
        alert("14号仓用量超过规定范围！(0~25)" + '\n' + "请重新填写！");
        return false;
    }
    if (d15 > 25 || d15 < 0) {
        alert("15号仓用量超过规定范围！(0~25)" + '\n' + "请重新填写！");
        return false;
    }
	
	select();
	// 提交前对所有应该计算的部分进行计算，防止记录的数据错误
	calcConcentrate();
	calcTotal();
	return true;
}

function checkNum(value) {
	if (isNaN(document.getElementById(value).value)) {
		alert("填入的信息有错误！" + '\n' + "该信息只能填写数字");
		document.getElementById(value).value = "";
	} else {
		calcConcentrate();
	}
}
function select() {
	document.getElementById("lmtext").value = document.getElementById("lmval").value;
	document.getElementById("tmtext").value = document.getElementById("tmval").value;
	document.getElementById("NO1_val").value = document
			.getElementById("NO1_name").value;
	document.getElementById("NO2_val").value = document
			.getElementById("NO2_name").value;
	document.getElementById("NO3_val").value = document
			.getElementById("NO3_name").value;
	document.getElementById("NO4_val").value = document
			.getElementById("NO4_name").value;
	document.getElementById("NO8_val").value = document
			.getElementById("NO8_name").value;
	document.getElementById("NO9_val").value = document
			.getElementById("NO9_name").value;
	document.getElementById("NO10_val").value = document
			.getElementById("NO10_name").value;
	document.getElementById("NO11_val").value = document
			.getElementById("NO11_name").value;
	document.getElementById("NO12_val").value = document
			.getElementById("NO12_name").value;
    document.getElementById("NO13_val").value = document
        .getElementById("NO13_name").value;
    document.getElementById("NO14_val").value = document
        .getElementById("NO14_name").value;
    document.getElementById("NO15_val").value = document
        .getElementById("NO15_name").value;
}
function calcTotal() {
	var lm1 = document.getElementById("lm1").value;
	var lm2 = document.getElementById("lm2").value;
	var lm3 = document.getElementById("lm3").value;
	var lm4 = document.getElementById("lm4").value;
	var lm5 = document.getElementById("lm5").value;
	var lm6 = document.getElementById("lm6").value;
	var lm7 = document.getElementById("lm7").value;
	var lm8 = document.getElementById("lm8").value;
	var lm9 = document.getElementById("lm9").value;
	var lm10 = document.getElementById("lm10").value;
	var lm11 = document.getElementById("lm11").value;
	var lm12 = document.getElementById("lm12").value;
	var tm1 = document.getElementById("tm1").value;
	var tm2 = document.getElementById("tm2").value;
	var tm3 = document.getElementById("tm3").value;
	var tm4 = document.getElementById("tm4").value;
	var tm5 = document.getElementById("tm5").value;
	var tm6 = document.getElementById("tm6").value;
	var tm7 = document.getElementById("tm7").value;
	var tm8 = document.getElementById("tm8").value;
	var tm9 = document.getElementById("tm9").value;
	var tm10 = document.getElementById("tm10").value;
	var tm11 = document.getElementById("tm11").value;
	var tm12 = document.getElementById("tm12").value;
	if (lm1 == "")
		lm1 = 0;
	if (lm2 == "")
		lm2 = 0;
	if (lm3 == "")
		lm3 = 0;
	if (lm4 == "")
		lm4 = 0;
	if (lm5 == "")
		lm5 = 0;
	if (lm6 == "")
		lm6 = 0;
	if (lm7 == "")
		lm7 = 0;
	if (lm8 == "")
		lm8 = 0;
	if (lm9 == "")
		lm9 = 0;
	if (lm10 == "")
		lm10 = 0;
	if (lm11 == "")
		lm11 = 0;
	if (lm12 == "")
		lm12 = 0;
	if (tm1 == "")
		tm1 = 0;
	if (tm2 == "")
		tm2 = 0;
	if (tm3 == "")
		tm3 = 0;
	if (tm4 == "")
		tm4 = 0;
	if (tm5 == "")
		tm5 = 0;
	if (tm6 == "")
		tm6 = 0;
	if (tm7 == "")
		tm7 = 0;
	if (tm8 == "")
		tm8 = 0;
	if (tm9 == "")
		tm9 = 0;
	if (tm10 == "")
		tm10 = 0;
	if (tm11 == "")
		tm11 = 0;
	if (tm12 == "")
		tm12 = 0;
	// total值自动计算
	var tt1val = parseFloat(lm1) + parseFloat(tm1);
	var tt2val = parseFloat(lm2) + parseFloat(tm2);
	var tt3val = parseFloat(lm3) + parseFloat(tm3);
	var tt4val = parseFloat(lm4) + parseFloat(tm4);
	var tt5val = parseFloat(lm5) + parseFloat(tm5);
	var tt6val = parseFloat(lm6) + parseFloat(tm6);
	var tt7val = parseFloat(lm7) + parseFloat(tm7);
	var tt8val = parseFloat(lm8) + parseFloat(tm8);
	var tt9val = parseFloat(lm9) + parseFloat(tm9);
	var tt10val = parseFloat(lm10) + parseFloat(tm10);
	var tt11val = parseFloat(lm11) + parseFloat(tm11);
	var tt12val = parseFloat(lm12) + parseFloat(tm12);
	document.getElementById("cur1").value = tt1val;
	document.getElementById("cur2").value = tt2val;
	document.getElementById("cur3").value = tt3val;
	document.getElementById("cur4").value = tt4val;
	document.getElementById("cur5").value = tt5val;
	document.getElementById("cur6").value = tt6val;
	document.getElementById("cur7").value = tt7val;
	document.getElementById("cur8").value = tt8val;
	document.getElementById("cur9").value = tt9val;
	document.getElementById("cur10").value = tt10val;
	document.getElementById("cur11").value = tt11val;
	document.getElementById("cur12").value = tt12val;
}
function AutoZero(num) {
	var text = document.getElementById("NO" + num + "_name").value;
	if (text == "(无矿)") {
		document.getElementById("NO" + num + "_Cu").value = 0;
		document.getElementById("NO" + num + "_Fe").value = 0;
		document.getElementById("NO" + num + "_S").value = 0;
		document.getElementById("NO" + num + "_Co").value = 0;
		document.getElementById("NO" + num + "_SiO2").value = 0;
		document.getElementById("NO" + num + "_CaO").value = 0;
		document.getElementById("NO" + num + "_MgO").value = 0;
		document.getElementById("NO" + num + "_Al2O3").value = 0;
		document.getElementById("dosage" + num).value = 0;
	} else {
		document.getElementById("NO" + num + "_Cu").value = "";
		document.getElementById("NO" + num + "_Fe").value = "";
		document.getElementById("NO" + num + "_S").value = "";
		document.getElementById("NO" + num + "_Co").value = "";
		document.getElementById("NO" + num + "_SiO2").value = "";
		document.getElementById("NO" + num + "_CaO").value = "";
		document.getElementById("NO" + num + "_MgO").value = "";
		document.getElementById("NO" + num + "_Al2O3").value = "";
		document.getElementById("dosage" + num).value = "";
	}
}
// 计算模块输入成分
function calcConcentrate() {
	// 获得ingredient表对应的填写信息
	var NO1_Cu = document.getElementById("NO1_Cu").value;
	var NO1_Fe = document.getElementById("NO1_Fe").value;
	var NO1_S = document.getElementById("NO1_S").value;
	var NO1_Co = document.getElementById("NO1_Co").value;
	var NO1_SiO2 = document.getElementById("NO1_SiO2").value;
	var NO1_CaO = document.getElementById("NO1_CaO").value;
	var NO1_MgO = document.getElementById("NO1_MgO").value;
	var NO1_Al2O3 = document.getElementById("NO1_Al2O3").value;
	var NO2_Cu = document.getElementById("NO2_Cu").value;
	var NO2_Fe = document.getElementById("NO2_Fe").value;
	var NO2_S = document.getElementById("NO2_S").value;
	var NO2_Co = document.getElementById("NO2_Co").value;
	var NO2_SiO2 = document.getElementById("NO2_SiO2").value;
	var NO2_CaO = document.getElementById("NO2_CaO").value;
	var NO2_MgO = document.getElementById("NO2_MgO").value;
	var NO2_Al2O3 = document.getElementById("NO2_Al2O3").value;
	var NO3_Cu = document.getElementById("NO3_Cu").value;
	var NO3_Fe = document.getElementById("NO3_Fe").value;
	var NO3_S = document.getElementById("NO3_S").value;
	var NO3_Co = document.getElementById("NO3_Co").value;
	var NO3_SiO2 = document.getElementById("NO3_SiO2").value;
	var NO3_CaO = document.getElementById("NO3_CaO").value;
	var NO3_MgO = document.getElementById("NO3_MgO").value;
	var NO3_Al2O3 = document.getElementById("NO3_Al2O3").value;
	var NO4_Cu = document.getElementById("NO4_Cu").value;
	var NO4_Fe = document.getElementById("NO4_Fe").value;
	var NO4_S = document.getElementById("NO4_S").value;
	var NO4_Co = document.getElementById("NO4_Co").value;
	var NO4_SiO2 = document.getElementById("NO4_SiO2").value;
	var NO4_CaO = document.getElementById("NO4_CaO").value;
	var NO4_MgO = document.getElementById("NO4_MgO").value;
	var NO4_Al2O3 = document.getElementById("NO4_Al2O3").value;
	var NO8_Cu = document.getElementById("NO8_Cu").value;
	var NO8_Fe = document.getElementById("NO8_Fe").value;
	var NO8_S = document.getElementById("NO8_S").value;
	var NO8_Co = document.getElementById("NO8_Co").value;
	var NO8_SiO2 = document.getElementById("NO8_SiO2").value;
	var NO8_CaO = document.getElementById("NO8_CaO").value;
	var NO8_MgO = document.getElementById("NO8_MgO").value;
	var NO8_Al2O3 = document.getElementById("NO8_Al2O3").value;
	var NO9_Cu = document.getElementById("NO9_Cu").value;
	var NO9_Fe = document.getElementById("NO9_Fe").value;
	var NO9_S = document.getElementById("NO9_S").value;
	var NO9_Co = document.getElementById("NO9_Co").value;
	var NO9_SiO2 = document.getElementById("NO9_SiO2").value;
	var NO9_CaO = document.getElementById("NO9_CaO").value;
	var NO9_MgO = document.getElementById("NO9_MgO").value;
	var NO9_Al2O3 = document.getElementById("NO9_Al2O3").value;
	var NO10_Cu = document.getElementById("NO10_Cu").value;
	var NO10_Fe = document.getElementById("NO10_Fe").value;
	var NO10_S = document.getElementById("NO10_S").value;
	var NO10_Co = document.getElementById("NO10_Co").value;
	var NO10_SiO2 = document.getElementById("NO10_SiO2").value;
	var NO10_CaO = document.getElementById("NO10_CaO").value;
	var NO10_MgO = document.getElementById("NO10_MgO").value;
	var NO10_Al2O3 = document.getElementById("NO10_Al2O3").value;
	var NO11_Cu = document.getElementById("NO11_Cu").value;
	var NO11_Fe = document.getElementById("NO11_Fe").value;
	var NO11_S = document.getElementById("NO11_S").value;
	var NO11_Co = document.getElementById("NO11_Co").value;
	var NO11_SiO2 = document.getElementById("NO11_SiO2").value;
	var NO11_CaO = document.getElementById("NO11_CaO").value;
	var NO11_MgO = document.getElementById("NO11_MgO").value;
	var NO11_Al2O3 = document.getElementById("NO11_Al2O3").value;
	var NO12_Cu = document.getElementById("NO12_Cu").value;
	var NO12_Fe = document.getElementById("NO12_Fe").value;
	var NO12_S = document.getElementById("NO12_S").value;
	var NO12_Co = document.getElementById("NO12_Co").value;
	var NO12_SiO2 = document.getElementById("NO12_SiO2").value;
	var NO12_CaO = document.getElementById("NO12_CaO").value;
	var NO12_MgO = document.getElementById("NO12_MgO").value;
	var NO12_Al2O3 = document.getElementById("NO12_Al2O3").value;
    var NO13_Cu = document.getElementById("NO13_Cu").value;
    var NO13_Fe = document.getElementById("NO13_Fe").value;
    var NO13_S = document.getElementById("NO13_S").value;
    var NO13_Co = document.getElementById("NO13_Co").value;
    var NO13_SiO2 = document.getElementById("NO13_SiO2").value;
    var NO13_CaO = document.getElementById("NO13_CaO").value;
    var NO13_MgO = document.getElementById("NO13_MgO").value;
    var NO13_Al2O3 = document.getElementById("NO13_Al2O3").value;
    var NO14_Cu = document.getElementById("NO14_Cu").value;
    var NO14_Fe = document.getElementById("NO14_Fe").value;
    var NO14_S = document.getElementById("NO14_S").value;
    var NO14_Co = document.getElementById("NO14_Co").value;
    var NO14_SiO2 = document.getElementById("NO14_SiO2").value;
    var NO14_CaO = document.getElementById("NO14_CaO").value;
    var NO14_MgO = document.getElementById("NO14_MgO").value;
    var NO14_Al2O3 = document.getElementById("NO14_Al2O3").value;
    var NO15_Cu = document.getElementById("NO15_Cu").value;
    var NO15_Fe = document.getElementById("NO15_Fe").value;
    var NO15_S = document.getElementById("NO15_S").value;
    var NO15_Co = document.getElementById("NO15_Co").value;
    var NO15_SiO2 = document.getElementById("NO15_SiO2").value;
    var NO15_CaO = document.getElementById("NO15_CaO").value;
    var NO15_MgO = document.getElementById("NO15_MgO").value;
    var NO15_Al2O3 = document.getElementById("NO15_Al2O3").value;
	var dosage1 = document.getElementById("dosage1").value;
	var dosage2 = document.getElementById("dosage2").value;
	var dosage3 = document.getElementById("dosage3").value;
	var dosage4 = document.getElementById("dosage4").value;
	var dosage8 = document.getElementById("dosage8").value;
	var dosage9 = document.getElementById("dosage9").value;
	var dosage10 = document.getElementById("dosage10").value;
	var dosage11 = document.getElementById("dosage11").value;
	var dosage12 = document.getElementById("dosage12").value;
    var dosage13 = document.getElementById("dosage13").value;
    var dosage14 = document.getElementById("dosage14").value;
    var dosage15 = document.getElementById("dosage15").value;
	if (NO1_Cu == "")
		NO1_Cu = 0;
	if (NO1_Fe == "")
		NO1_Fe = 0;
	if (NO1_S == "")
		NO1_S = 0;
	if (NO1_SiO2 == "")
		NO1_SiO2 = 0;
	if (NO1_CaO == "")
		NO1_CaO = 0;
	if (NO1_MgO == "")
		NO1_MgO = 0;
	if (NO1_Al2O3 == "")
		NO1_Al2O3 = 0;
	if (NO1_Co == "")
		NO1_Co = 0;
	if (NO2_Cu == "")
		NO2_Cu = 0;
	if (NO2_Fe == "")
		NO2_Fe = 0;
	if (NO2_S == "")
		NO2_S = 0;
	if (NO2_SiO2 == "")
		NO2_SiO2 = 0;
	if (NO2_CaO == "")
		NO2_CaO = 0;
	if (NO2_MgO == "")
		NO2_MgO = 0;
	if (NO2_Al2O3 == "")
		NO2_Al2O3 = 0;
	if (NO2_Co == "")
		NO2_Co = 0;
	if (NO3_Cu == "")
		NO3_Cu = 0;
	if (NO3_Fe == "")
		NO3_Fe = 0;
	if (NO3_S == "")
		NO3_S = 0;
	if (NO3_SiO2 == "")
		NO3_SiO2 = 0;
	if (NO3_CaO == "")
		NO3_CaO = 0;
	if (NO3_MgO == "")
		NO3_MgO = 0;
	if (NO3_Al2O3 == "")
		NO3_Al2O3 = 0;
	if (NO3_Co == "")
		NO3_Co = 0;
	if (NO4_Cu == "")
		NO4_Cu = 0;
	if (NO4_Fe == "")
		NO4_Fe = 0;
	if (NO4_S == "")
		NO4_S = 0;
	if (NO4_SiO2 == "")
		NO4_SiO2 = 0;
	if (NO4_CaO == "")
		NO4_CaO = 0;
	if (NO4_MgO == "")
		NO4_MgO = 0;
	if (NO4_Al2O3 == "")
		NO4_Al2O3 = 0;
	if (NO4_Co == "")
		NO4_Co = 0;
	if (NO8_Cu == "")
		NO8_Cu = 0;
	if (NO8_Fe == "")
		NO8_Fe = 0;
	if (NO8_S == "")
		NO8_S = 0;
	if (NO8_SiO2 == "")
		NO8_SiO2 = 0;
	if (NO8_CaO == "")
		NO8_CaO = 0;
	if (NO8_MgO == "")
		NO8_MgO = 0;
	if (NO8_Al2O3 == "")
		NO8_Al2O3 = 0;
	if (NO8_Co == "")
		NO8_Co = 0;
	if (NO9_Cu == "")
		NO9_Cu = 0;
	if (NO9_Fe == "")
		NO9_Fe = 0;
	if (NO9_S == "")
		NO9_S = 0;
	if (NO9_SiO2 == "")
		NO9_SiO2 = 0;
	if (NO9_CaO == "")
		NO9_CaO = 0;
	if (NO9_MgO == "")
		NO9_MgO = 0;
	if (NO9_Al2O3 == "")
		NO9_Al2O3 = 0;
	if (NO9_Co == "")
		NO9_Co = 0;
	if (NO10_Cu == "")
		NO10_Cu = 0;
	if (NO10_Fe == "")
		NO10_Fe = 0;
	if (NO10_S == "")
		NO10_S = 0;
	if (NO10_SiO2 == "")
		NO10_SiO2 = 0;
	if (NO10_CaO == "")
		NO10_CaO = 0;
	if (NO10_MgO == "")
		NO10_MgO = 0;
	if (NO10_Al2O3 == "")
		NO10_Al2O3 = 0;
	if (NO10_Co == "")
		NO10_Co = 0;
	if (NO11_Cu == "")
		NO11_Cu = 0;
	if (NO11_Fe == "")
		NO11_Fe = 0;
	if (NO11_S == "")
		NO11_S = 0;
	if (NO11_SiO2 == "")
		NO11_SiO2 = 0;
	if (NO11_CaO == "")
		NO11_CaO = 0;
	if (NO11_MgO == "")
		NO11_MgO = 0;
	if (NO11_Al2O3 == "")
		NO11_Al2O3 = 0;
	if (NO11_Co == "")
		NO11_Co = 0;
	if (NO12_Cu == "")
		NO12_Cu = 0;
	if (NO12_Fe == "")
		NO12_Fe = 0;
	if (NO12_S == "")
		NO12_S = 0;
	if (NO12_SiO2 == "")
		NO12_SiO2 = 0;
	if (NO12_CaO == "")
		NO12_CaO = 0;
	if (NO12_MgO == "")
		NO12_MgO = 0;
	if (NO12_Al2O3 == "")
		NO12_Al2O3 = 0;
	if (NO12_Co == "")
		NO12_Co = 0;
    if (NO13_Cu == "")
        NO13_Cu = 0;
    if (NO13_Fe == "")
        NO13_Fe = 0;
    if (NO13_S == "")
        NO13_S = 0;
    if (NO13_SiO2 == "")
        NO13_SiO2 = 0;
    if (NO13_CaO == "")
        NO13_CaO = 0;
    if (NO13_MgO == "")
        NO13_MgO = 0;
    if (NO13_Al2O3 == "")
        NO13_Al2O3 = 0;
    if (NO13_Co == "")
        NO13_Co = 0;
    if (NO13_Cu == "")
        NO13_Cu = 0;
    if (NO13_Fe == "")
        NO13_Fe = 0;
    if (NO13_S == "")
        NO13_S = 0;
    if (NO13_SiO2 == "")
        NO13_SiO2 = 0;
    if (NO13_CaO == "")
        NO13_CaO = 0;
    if (NO13_MgO == "")
        NO13_MgO = 0;
    if (NO13_Al2O3 == "")
        NO13_Al2O3 = 0;
    if (NO13_Co == "")
        NO13_Co = 0;
    if (NO14_Cu == "")
        NO14_Cu = 0;
    if (NO14_Fe == "")
        NO14_Fe = 0;
    if (NO14_S == "")
        NO14_S = 0;
    if (NO14_SiO2 == "")
        NO14_SiO2 = 0;
    if (NO14_CaO == "")
        NO14_CaO = 0;
    if (NO14_MgO == "")
        NO14_MgO = 0;
    if (NO14_Al2O3 == "")
        NO14_Al2O3 = 0;
    if (NO14_Co == "")
        NO14_Co = 0;
    if (NO15_Cu == "")
        NO15_Cu = 0;
    if (NO15_Fe == "")
        NO15_Fe = 0;
    if (NO15_S == "")
        NO15_S = 0;
    if (NO15_SiO2 == "")
        NO15_SiO2 = 0;
    if (NO15_CaO == "")
        NO15_CaO = 0;
    if (NO15_MgO == "")
        NO15_MgO = 0;
    if (NO15_Al2O3 == "")
        NO15_Al2O3 = 0;
    if (NO15_Co == "")
        NO15_Co = 0;
	if (dosage1 == "")
		dosage1 = 0;
	if (dosage2 == "")
		dosage2 = 0;
	if (dosage3 == "")
		dosage3 = 0;
	if (dosage4 == "")
		dosage4 = 0;
	if (dosage8 == "")
		dosage8 = 0;
	if (dosage9 == "")
		dosage9 = 0;
	if (dosage10 == "")
		dosage10 = 0;
	if (dosage11 == "")
		dosage11 = 0;
	if (dosage12 == "")
		dosage12 = 0;
    if (dosage13 == "")
        dosage13 = 0;
    if (dosage14 == "")
        dosage14 = 0;
    if (dosage15 == "")
        dosage15 = 0;
	var total_Cu = parseFloat(NO1_Cu) * parseFloat(dosage1)
			+ parseFloat(NO2_Cu) * parseFloat(dosage2) + parseFloat(NO3_Cu)
			* parseFloat(dosage3) + parseFloat(NO4_Cu) * parseFloat(dosage4)
			+ parseFloat(NO8_Cu) * parseFloat(dosage8) + parseFloat(NO9_Cu)
			* parseFloat(dosage9) + parseFloat(NO10_Cu) * parseFloat(dosage10)
			+ parseFloat(NO11_Cu) * parseFloat(dosage11) + parseFloat(NO12_Cu)
			* parseFloat(dosage12)+ parseFloat(NO13_Cu) * parseFloat(dosage13)+ parseFloat(NO14_Cu) * parseFloat(dosage14)+ parseFloat(NO15_Cu) * parseFloat(dosage15);
	var total_Fe = parseFloat(NO1_Fe) * parseFloat(dosage1)
			+ parseFloat(NO2_Fe) * parseFloat(dosage2) + parseFloat(NO3_Fe)
			* parseFloat(dosage3) + parseFloat(NO4_Fe) * parseFloat(dosage4)
			+ parseFloat(NO8_Fe) * parseFloat(dosage8) + parseFloat(NO9_Fe)
			* parseFloat(dosage9) + parseFloat(NO10_Fe) * parseFloat(dosage10)
			+ parseFloat(NO11_Fe) * parseFloat(dosage11) + parseFloat(NO12_Fe)
			* parseFloat(dosage12)+ parseFloat(NO13_Fe) * parseFloat(dosage13)+ parseFloat(NO14_Fe) * parseFloat(dosage14)+ parseFloat(NO15_Fe) * parseFloat(dosage15);
	var total_S = parseFloat(NO1_S) * parseFloat(dosage1) + parseFloat(NO2_S)
			* parseFloat(dosage2) + parseFloat(NO3_S) * parseFloat(dosage3)
			+ parseFloat(NO4_S) * parseFloat(dosage4) + parseFloat(NO8_S)
			* parseFloat(dosage8) + parseFloat(NO9_S) * parseFloat(dosage9)
			+ parseFloat(NO10_S) * parseFloat(dosage10) + parseFloat(NO11_S)
			* parseFloat(dosage11) + parseFloat(NO12_S) * parseFloat(dosage12)
			+ parseFloat(NO13_S) * parseFloat(dosage13)+ parseFloat(NO14_S) * parseFloat(dosage14)+ parseFloat(NO15_S) * parseFloat(dosage15);
	var total_SiO2 = parseFloat(NO1_SiO2) * parseFloat(dosage1)
			+ parseFloat(NO2_SiO2) * parseFloat(dosage2) + parseFloat(NO3_SiO2)
			* parseFloat(dosage3) + parseFloat(NO4_SiO2) * parseFloat(dosage4)
			+ parseFloat(NO8_SiO2) * parseFloat(dosage8) + parseFloat(NO9_SiO2)
			* parseFloat(dosage9) + parseFloat(NO10_SiO2)
			* parseFloat(dosage10) + parseFloat(NO11_SiO2)
			* parseFloat(dosage11) + parseFloat(NO12_SiO2)
			* parseFloat(dosage12)
        	+ parseFloat(NO13_SiO2) * parseFloat(dosage13)+ parseFloat(NO14_SiO2) * parseFloat(dosage14)+ parseFloat(NO15_SiO2) * parseFloat(dosage15);
	var total_CaO = parseFloat(NO1_CaO) * parseFloat(dosage1)
			+ parseFloat(NO2_CaO) * parseFloat(dosage2) + parseFloat(NO3_CaO)
			* parseFloat(dosage3) + parseFloat(NO4_CaO) * parseFloat(dosage4)
			+ parseFloat(NO8_CaO) * parseFloat(dosage8) + parseFloat(NO9_CaO)
			* parseFloat(dosage9) + parseFloat(NO10_CaO) * parseFloat(dosage10)
			+ parseFloat(NO11_CaO) * parseFloat(dosage11)
			+ parseFloat(NO12_CaO) * parseFloat(dosage12)
        	+ parseFloat(NO13_CaO) * parseFloat(dosage13)+ parseFloat(NO14_CaO) * parseFloat(dosage14)+ parseFloat(NO15_CaO) * parseFloat(dosage15);
	var total_MgO = parseFloat(NO1_MgO) * parseFloat(dosage1)
			+ parseFloat(NO2_MgO) * parseFloat(dosage2) + parseFloat(NO3_MgO)
			* parseFloat(dosage3) + parseFloat(NO4_MgO) * parseFloat(dosage4)
			+ parseFloat(NO8_MgO) * parseFloat(dosage8) + parseFloat(NO9_MgO)
			* parseFloat(dosage9) + parseFloat(NO10_MgO) * parseFloat(dosage10)
			+ parseFloat(NO11_MgO) * parseFloat(dosage11)
			+ parseFloat(NO12_MgO) * parseFloat(dosage12);
    		+ parseFloat(NO13_MgO) * parseFloat(dosage13)+ parseFloat(NO14_MgO) * parseFloat(dosage14)+ parseFloat(NO15_MgO) * parseFloat(dosage15);
	var total_Al2O3 = parseFloat(NO1_Al2O3) * parseFloat(dosage1)
			+ parseFloat(NO2_Al2O3) * parseFloat(dosage2)
			+ parseFloat(NO3_Al2O3) * parseFloat(dosage3)
			+ parseFloat(NO4_Al2O3) * parseFloat(dosage4)
			+ parseFloat(NO8_Al2O3) * parseFloat(dosage8)
			+ parseFloat(NO9_Al2O3) * parseFloat(dosage9)
			+ parseFloat(NO10_Al2O3) * parseFloat(dosage10)
			+ parseFloat(NO11_Al2O3) * parseFloat(dosage11)
			+ parseFloat(NO12_Al2O3) * parseFloat(dosage12);
   	 		+ parseFloat(NO13_Al2O3) * parseFloat(dosage13)+ parseFloat(NO14_Al2O3) * parseFloat(dosage14)+ parseFloat(NO15_Al2O3) * parseFloat(dosage15);
	var total_Co = parseFloat(NO1_Co) * parseFloat(dosage1)
			+ parseFloat(NO2_Co) * parseFloat(dosage2) + parseFloat(NO3_Co)
			* parseFloat(dosage3) + parseFloat(NO4_Co) * parseFloat(dosage4)
			+ parseFloat(NO8_Co) * parseFloat(dosage8) + parseFloat(NO9_Co)
			* parseFloat(dosage9) + parseFloat(NO10_Co) * parseFloat(dosage10)
			+ parseFloat(NO11_Co) * parseFloat(dosage11) + parseFloat(NO12_Co)
			* parseFloat(dosage12);
    		+ parseFloat(NO13_Co) * parseFloat(dosage13)+ parseFloat(NO14_Co) * parseFloat(dosage14)+ parseFloat(NO15_Co) * parseFloat(dosage15);
	var total_dosage = parseFloat(dosage1) + parseFloat(dosage2)
			+ parseFloat(dosage3) + parseFloat(dosage4) + parseFloat(dosage8)
			+ parseFloat(dosage9) + parseFloat(dosage10) + parseFloat(dosage11)
			+ parseFloat(dosage12) + parseFloat(dosage13) + parseFloat(dosage14) + parseFloat(dosage15);
	// 计算结果实时显示
	document.getElementById("C1").value = total_Cu / total_dosage;
	document.getElementById("C2").value = total_Fe / total_dosage;
	document.getElementById("C3").value = total_S / total_dosage;
	document.getElementById("C4").value = total_SiO2 / total_dosage;
	document.getElementById("C5").value = total_CaO / total_dosage;
	document.getElementById("C6").value = total_MgO / total_dosage;
	document.getElementById("C7").value = total_Al2O3 / total_dosage;
	document.getElementById("C8").value = total_Co / total_dosage;
	document.getElementById("C9").value = total_dosage;
}

function changeSelected(id, value) {
	// 获得下拉列表的id
	var select = document.getElementById(id);
	// 获得下拉列表的所有option
	var options = select.options;
	// 循环获得对应的节点
	for ( var i = 0; i < options.length; i++) {
		// 获得节点的值和后台传来的值进行比较
		if (options[i].value == value) {
			// 如果当前节点与后台传来的值一致，则将当前节点设置为选中状态，并跳出循环
			options[i].selected = true;
			break;
		}
	}
}