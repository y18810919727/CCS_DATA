// Powered By GaoYuxing
// 2015-04-26
var jsonStock;// 存储stock的json数据用
var prowcount = 9;// production表的行数
var number_array = {};
var n=0;// 记录数组中有几个元素
var j;
var m;
var date;
var data1;

function getNum2(calvalue) {
	date=calvalue;
	$("#text_29").attr("value",date);
	$.ajax({
		url : '/CCS/getallproduction.servlet',// 后台访问目标
		data : {
			date : calvalue
		// 要传输到后台的数据
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据
			$("#numid").empty();// 清空下拉框中的所有内容
			$("#numid_").empty();
			
			jsonStock = data;// 全局变量存储取回的stock表的Json
			// 外层遍历：取出数组中的每一个对象
			$.each(data, function(index, obj) {
				// 内层遍历：取出对象中的所有值
				$.each(obj, function(key, value) {
					if (key == "number" ) {
						if(CheckNumber(value)){
						// 只将单号加载到下拉框中，其他数据保留
						var str = "<option value ='" + index + "'>" + value
								+ "</option>";
						$("#numid").append(str);
						$("#numid_").append(str);
						}
					}
				});
			});
		},
		error : function() {
			alert("获取单号发生异常，请联系管理员！");
		}
	});
}
// 检查number是否重复
function CheckNumber(value){
		for(j=0;j<n;j++){
			if(number_array[j]==value){
				return false;
			}
		}
		number_array[n]=value;
		n++;
		return true;
}
function getProduction() {
	var str=null;
	var str_1=null;
	m=0;
	$("#sampleNo_").empty();
	str_1 = "<option >---请选择样号---</option>";
	// 获取已经选择的select的option上的text
	var number = $("#numid").find("option:selected").text();
	if (number == "") {
		alert("当前日期下没有查询到数据!");
		return;
	}
	$.ajax({
		url : '/CCS/getproductiondata.servlet',// 后台访问目标
		data : {
			number : number,
			date : date
		// 要传输到后台的数据
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据
			for ( var i = 1; i <= prowcount; i = i + 1) {
				$("#prow" + i).remove();
			}
			// 将data的值赋给data1
			data1 = data;
			var length = getJsonObjLength(data);
			getsampleNo(data);
			var str = "";// 准备拼接表格
			var i = 1;// 生成每一行的序号并记录行数
			if(length>=9){
				// 外层遍历：取出数组中的每一个对象
				$.each(data, function(index, obj) {
					if(m==0){
						addRecords(obj);
						m=1;
					}
					str = str + "<tr id='prow" + i + "'>";
					// 内层遍历：取出对象中的所有值
					$.each(obj, function(key, value) {
						if(key!="number"){
							if(key == "sampleNo"){
								if(value != "0"){
									str_1 = "<option value ='" + index + "'>" + value
									+ "</option>";
								}
							}
						str = str + "<td>" + value + "</td>";
						} 
					});
					str = str + "</tr>";
					i = i + 1;
					$("#sampleNo_").append(str_1);
				});
				}else {
					// 外层遍历：取出数组中的每一个对象
					$.each(data, function(index, obj) {
						if(m==0){
							addRecords(obj);
							m=1;
						}
						str = str + "<tr id='prow" + i + "'>";
						// 内层遍历：取出对象中的所有值
						$.each(obj, function(key, value) {
							if(key!="number"){
								if(key == "sampleNo"){
									if(value != "0"){
										str_1 = "<option value ='" + index + "'>" + value
										+ "</option>";
									}
								}
							str = str + "<td>" + value + "</td>";
							}
						});
						str = str + "</tr>";
						i = i + 1;
						$("#sampleNo_").append(str_1);
					});
					for(var j=1;j<=10-length;j++){
						str = str + "<tr id='prow" + i + "'>";
						for(var k=1;k<=35;k++){
							str = str + "<td>" + "&nbsp;" + "</td>";
						}
						str = str + "</tr>";
						i = i + 1;
					}
				}
			prowcount=i-1;
			$("#production").append(str);
			$("#prow1").remove();
		},
		error : function() {
			alert("获取下料记录信息发生异常，请联系管理员！");
		}
	});
}
function deleteRecord(){
	var number = $("#numid_").find("option:selected").text();
	var sampleNo = $("#sampleNo_").find("option:selected").text();
	// 7月11日增加：删除记录可以绕过样号提交导致错误
	if(sampleNo=="" || isNaN(sampleNo)){
		alert("请选择一个样号！");
		return false;
	}
	if(confirm("你确认要删除该项记录吗？") == false){
		return false;
	}
	$.ajax({
		url : '/CCS/deleteFromProduction.servlet',// 后台访问目标
		data : {
			number : number,
			sampleNo : sampleNo
		// 要传输到后台的数据(使用request.getParameter()提取)
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据

				$.each(data, function(key, value) {
					if(value == "delete successfully"){
						alert("删除记录成功！" + '\n' + "请重新查询记录！");
						location.href='material_records.jsp';
					}
				});
		},
		error : function() {
			alert("获取单号发生异常，请联系管理员！");
		}
	});
}
function getsampleNo(data){
	var sampleNo="0";
	$.each(data, function(index, obj) {
		// 内层遍历：取出对象中的所有值
		$.each(obj, function(key, value) {
			// 8月5日修改，修复样号不能超过10的bug
			if(key=="sampleNo"){
				if(parseInt(value) >= parseInt(sampleNo)){
					sampleNo = value;
				}
			}
		});
	});
	// 新的sampleNo是查找到的最大的sampleNo加1
	var num = parseInt(sampleNo) +1;
	var str = String(num);
	$("#text2_").attr("value",str);
}
function addRecords(obj){
	// 获取已经选择的select的option上的text
	var number = $("#numid").find("option:selected").text();
	$("#text1_").attr("value",number);
	$("#text29").attr("value",date);
	$.each(obj, function(key, value) {
		if(key=="targetMatte"){
			$("#text3_").attr("value",value);
		}if(key=="targetMagIron"){
			$("#text5_").attr("value",value);
		}if(key=="targetSiO2Fe"){
			$("#text7_").attr("value",value);
		}if(key=="targetSiO2CaO"){
			$("#text9_").attr("value",value);
		}	
	});
}
function getNumber(){
	// 获取已经选择的select的option上的text
	var number = $("#numid").find("option:selected").text();
	$("#number").attr("value",number);
	return true;
}
// 获取json对象的长度
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
      Length++;
    }
    return Length;
 }
function getOneData(){
	var number = $("#numid_").find("option:selected").text();
	var sampleNo = $("#sampleNo_").find("option:selected").text();
	var produceNo = null;
	var sampleNo_ = null;
	var text03 = null; var text04 = null; var text05 = null; var text06 = null;
	var text07 = null; var text08 = null; var text09 = null; var text10 = null;
	var text11 = null; var text12 = null; var text13 = null; var text14 = null;
	var text15 = null; var text16 = null; var text17 = null; var text18 = null;
	var text19 = null; var text20 = null; var text21 = null; var text22 = null;
	var text23 = null; var text24 = null; var text25 = null; var text26 = null; 
	var text27 = null; var text28 = null; var texth11 = null; var texth12 = null; 
	var textgrade = null; var textoxypur = null; var textoxyconc = null;
	$("#text_01").attr("value",number);
	$.each(data1, function(index, obj) {
		// 内层遍历：取出对象中的所有值
		$.each(obj, function(key, value) {
			if(key == "produceNo"){
				produceNo = value;
			}if(key == "duty"){
				duty = value;
			}if(key == "sampleNo"){
				sampleNo_ = value;
			}if(key == "targetMatte"){
				text03 = value;
			}if(key == "factMatte"){
				text04 = value;
			}if(key == "targetMagIron"){
				text05 = value;
			}if(key == "factMagIron"){
				text06 = value;
			}if(key == "targetSiO2Fe"){
				text07 = value;
			}if(key == "factSiO2Fe"){
				text08 = value;
			}if(key == "targetSiO2CaO"){
				text09 = value;
			}if(key == "factSiO2CaO"){
				text10 = value;
			}if(key == "magnetic_force"){
				text11 = value;
			}if(key == "drum_hole"){
				text12 = value;
			}if(key == "color"){
				text13 = value;
			}if(key == "nozzle_pressure"){
				text14 = value;
			}if(key == "fuel_ratio"){
				text15 = value;
			}if(key == "amountPerHour"){
				text16 = value;
			}if(key == "time"){
				text17 = value;
			}if(key == "air_volume"){
				text18 = value;
			}if(key == "h1used"){
				text19 = value;
			}if(key == "h2used"){
				text20 = value;
			}if(key == "h3used"){
				text21 = value;
			}if(key == "h4used"){
				text22 = value;
			}if(key == "h5used"){
				text23 = value;
			}if(key == "h6used"){
				text24 = value;
			}if(key == "h7used"){
				text25 = value;
			}if(key == "h8used"){
				text26 = value;
			}if(key == "h9used"){
				text27 = value;
			}if(key == "h10used"){
				text28 = value;
			}if(key == "h11used"){
				texth11 = value;
			}if(key == "h12used"){
				texth12 = value;
			}if(key == "grade"){
				textgrade = value;
			}if(key == "oxypur"){
				textoxypur = value;
			}if(key == "oxyconc"){
				textoxyconc = value;
			}
		});
		if(sampleNo_ == sampleNo){
			$("#text_30").attr("value",produceNo);
			$("#text_31").attr("value",duty);
			$("#text_02").attr("value",sampleNo_);
			$("#text_03").attr("value",text03);
			$("#text_04").attr("value",text04);
			$("#text_05").attr("value",text05);
			$("#text_06").attr("value",text06);
			$("#text_07").attr("value",text07);
			$("#text_08").attr("value",text08);
			$("#text_09").attr("value",text09);
			$("#text_10").attr("value",text10);
			changeSelected("magnetic_force_",text11);
			changeSelected("drum_hole_",text12);
			changeSelected("color_",text13);
			// 下面注释掉的代码在IE是不兼容的！
			// $("#magnetic_force_").attr("value",text11);
			// $("#drum_hole_").attr("value",text12);
			// $("#color_").attr("value",text13);
			$("#text_14").attr("value",text14);
			$("#text_15").attr("value",text15);
			$("#text_16").attr("value",text16);
			$("#text_17").attr("value",text17);
			$("#text_18").attr("value",text18);
			$("#text_19").attr("value",text19);
			$("#text_20").attr("value",text20);
			$("#text_21").attr("value",text21);
			$("#text_22").attr("value",text22);
			$("#text_23").attr("value",text23);
			$("#text_24").attr("value",text24);
			$("#text_25").attr("value",text25);
			$("#text_26").attr("value",text26);
			$("#text_27").attr("value",text27);
			$("#text_28").attr("value",text28);
			$("#text_h11").attr("value",texth11);
			$("#text_h12").attr("value",texth12);
			if(isNaN(textgrade))
				$("#text_grade").attr("value","");
			else
				$("#text_grade").attr("value",textgrade);
			if(isNaN(textoxypur))
				$("#text_oxypur").attr("value","");
			else
				$("#text_oxypur").attr("value",textoxypur);
			if(isNaN(textoxyconc))
				$("#text_oxyconc").attr("value","");
			else
				$("#text_oxyconc").attr("value",textoxyconc);
		}
	});
}
function changeSelected(id, value) {
	// 获得下拉列表的id
	var select = document.getElementById(id);
	// 获得下拉列表的所有option
	var options = select.options;
	// 循环获得对应的节点
	for (var i = 0; i < options.length; i++) {
		// 获得节点的值和后台传来的值进行比较
		if (options[i].value == value) {
			// 如果当前节点与后台传来的值一致，则将当前节点设置为选中状态，并跳出循环
			options[i].selected = true;
			break;
		}
	}
}

