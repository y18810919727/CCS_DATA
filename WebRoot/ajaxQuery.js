// Powered By GaoYuxing
// 2015-04-26
var jsonStock;// 存储stock的json数据用
var mrowcount = 13;// mineral表的行数
var curdate;
// 使用AJAX实现异步数据传输，后台访问servlet，通过JSON传递集合数据
function getNum(calvalue) {
	// 存储当前选择的日期
	curdate = calvalue;
	$.ajax({
		url : '/CCS/getstock.servlet',// 后台访问目标
		data : {
			date : calvalue
		// 要传输到后台的数据
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据
			$("#numid").empty();// 清空下拉框中的所有内容
			jsonStock = data;// 全局变量存储取回的stock表的Json
			// 外层遍历：取出数组中的每一个对象
			$.each(data, function(index, obj) {
				// 内层遍历：取出对象中的所有值
				$.each(obj, function(key, value) {
					if (key == "number") {
						// 只将单号加载到下拉框中
						var str = "<option value ='" + index + "'>" + value
								+ "</option>";
						$("#numid").append(str);
					}
				});
			});
		},
		error : function() {
			alert("获取单号发生异常，请刷新页面后重试！");
		}
	});
}
function showStock() {
	// 获取select的选择值
	var num = $("#numid").val();
	// 获取已经选择的select的option上的text
	var numtxt = $("#numid").find("option:selected").text();
	if (num == null) {
		alert("当前日期下没有查询到数据!");
		return;
	}
	// 重绘表格
	$("#stocklm").remove();
	$("#stocktm").remove();
	$("#stockcur").remove();
	var i = 1;
	var str = "<tr id='stocklm'>";
	$.each(jsonStock[num],
			function(key, value) {
				if (key != "number" && key != "date") {
					if (i == 1) {
						str = str + "<td>" + value + "月计划库存</td>";
					} else if (i == 14) {
						str = str + "</tr><tr id='stocktm'><td>" + value
								+ "月计划采购</td>";
					} else if (i == 27) {
						str = str + "</tr><tr id='stockcur'><td>目前库存</td><td>"
								+ value + "</td>";
					} else {
						str = str + "<td>" + value + "</td>";
					}
					i = i + 1;
				}
			});
	str = str + "</tr>";
	$("#stock").append(str);
	getMineral(numtxt);// 接着调用getMineral函数获取矿石数据
}
function getMineral(number) {
	$.ajax({
		url : '/CCS/getingredient.servlet',// 后台访问目标
		data : {
			number : number
		// 要传输到后台的数据
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据
			for ( var i = 1; i <= mrowcount; i = i + 1) {
				$("#mrow" + i).remove();
			}
			var str = "";// 准备拼接表格
			var i = 1;// 生成每一行的序号并记录行数
			// 外层遍历：取出数组中的每一个对象
			console.log(data.length);
            console.log(data);

			$.each(data, function(index, obj) {
                console.log(index);
                if(index == data.length-1)
                    return false;
				str = str + "<tr id='mrow" + i + "'>";


				// 内层遍历：取出对象中的所有值
				$.each(obj, function(key, value) {
					str = str + "<td>" + value + "</td>";
				});
				str = str + "</tr>";
				i = i + 1;
			});
			is_used = data[data.length-1]["is_used"];
			if(is_used)
            	$("#isUsedID" ).val("是");
			else
                $("#isUsedID" ).val("否");
			mrowcount = i - 1;
			$("#mineral").append(str);
		},
		error : function() {
			alert("获取精矿信息发生异常，请联系管理员！");
		}
	});
	getSummary(number);
}
function getSummary(number) {
	$.ajax({
		url : '/CCS/getsummary.servlet',// 后台访问目标
		data : {
			number : number
		// 要传输到后台的数据
		},
		type : 'get',// 访问方式：get/post
		cache : false,// 关闭cache
		dataType : 'json',// 数据类型：JSON
		success : function(data) {// 访问成功后，data中放入的是servlet写回的数据
			// each遍历：取出json对象中的所有值
			$.each(data, function(key, value) {
				if (value != null)
					$("#" + key).val(value);
				else
					$("#" + key).val("0");
			});
		},
		error : function() {
			alert("获取记录总表信息发生异常，请联系管理员！");
		}
	});
}

function newform() {
	var url = "/CCS/initnewform.servlet";
	window.location.href = url;
}

function updateform() {
	var date = curdate;
	// 获取select的选择值
	var num = $("#numid").val();
	// 获取已经选择的select的option上的text
	var number = $("#numid").find("option:selected").text();
	if (number == "" || number == null) {
		alert("请选择一个单号！");
		return;
	}
	var url = "/CCS/updateform.servlet?date=" + date + "&number=" + number;
	window.location.href = url;
}

function deleteform() {
	var date = curdate;
	// 获取select的选择值
	var num = $("#numid").val();
	// 获取已经选择的select的option上的text
	var number = $("#numid").find("option:selected").text();
	if (number == "" || number == null) {
		alert("请选择一个单号！");
		return;
	}
	var besure = confirm("警告：删除此配料单后，其对应的所有\n该单号的下料情况记录将全部被删除！\n您确认要删除吗？");
	if (besure) {
		var url = "/CCS/doDeleteMain.servlet?number=" + number;
		window.location.href = url;
	} else
		return;
}