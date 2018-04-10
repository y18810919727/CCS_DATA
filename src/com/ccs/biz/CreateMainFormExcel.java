package com.ccs.biz;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.ccs.dao.IngredientDAO;
import com.ccs.dao.MineralDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Ingredient;
import com.ccs.entity.Mineral;
import com.ccs.entity.Stock;
import com.ccs.entity.Summary;

/**
 * 此类用于生成配料单的Excel文件。2015.4.28.Powered By GaoYuxing
 * 
 * 2015.6.15做出EXCEL表格调整。
 * 
 * */
public class CreateMainFormExcel {
	public void onCreate(String date, String number, OutputStream out) {
		Stock s = null;
		Ingredient ingre = null;
		Summary sum = null;
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("配料比通知单");
		// 设置表格默认列宽度
		sheet.setDefaultColumnWidth(5);
		// 创建单元格格式
		HSSFCellStyle style = wb.createCellStyle();
		// 创建一个水平居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 创建一个垂直居中格式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 设置自动换行
		style.setWrapText(true);
		// 创建一个字体
		HSSFFont font = wb.createFont();
		// 设置字体名称
		font.setFontName("宋体");
		// 将字体加入style
		style.setFont(font);
		// 创建另一种单元格格式
		HSSFCellStyle style2 = wb.createCellStyle();
		// 创建一个垂直居中格式
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 设置自动换行
		style2.setWrapText(true);
		// 创建一个字体
		HSSFFont font2 = wb.createFont();
		// 设置字体名称
		font2.setFontName("宋体");
		// 将字体加入style
		style2.setFont(font2);
		// 创建一个38行14列的Excel表格
		HSSFRow row;
		HSSFCell cell;
		for (int i = 0; i < 38; i++) {
			row = sheet.createRow((int) i);
			for (int j = 0; j < 14; j++) {
				cell = row.createCell((short) j);
			}
		}
		// 设置单元格格式，合并单元格并填充数据
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 6));
		sheet.getRow(0).getCell(0).setCellValue("致：艾萨主控室 control room");
		sheet.getRow(0).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(0, (short) 8, 0, (short) 13));
		sheet.getRow(0).getCell(8).setCellValue("自：艾萨工段 smelter-ISA");
		sheet.getRow(0).getCell(8).setCellStyle(style);
		sheet.addMergedRegion(new Region(1, (short) 0, 1, (short) 6));
		sheet.getRow(1).getCell(0).setCellValue("抄送：生产技术部 cctv");
		sheet.getRow(1).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(1, (short) 8, 1, (short) 11));
		sheet.getRow(1).getCell(8).setCellValue("日期 using date：");
		sheet.getRow(1).getCell(8).setCellStyle(style);
		sheet.addMergedRegion(new Region(1, (short) 12, 1, (short) 13));
		sheet.getRow(1).getCell(12).setCellValue(date);
		sheet.getRow(1).getCell(12).setCellStyle(style);
		sheet.addMergedRegion(new Region(2, (short) 0, 2, (short) 6));
		sheet.getRow(2).getCell(0).setCellValue("主题：熔炼分厂艾萨工段配料比通知单");
		sheet.getRow(2).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(2, (short) 8, 2, (short) 11));
		sheet.getRow(2).getCell(8).setCellValue("单号 notification number：");
		sheet.getRow(2).getCell(8).setCellStyle(style);
		sheet.addMergedRegion(new Region(2, (short) 12, 2, (short) 13));
		sheet.getRow(2).getCell(12).setCellValue(number);
		sheet.getRow(2).getCell(12).setCellStyle(style);
		sheet.addMergedRegion(new Region(3, (short) 0, 4, (short) 13));
		sheet.getRow(3)
				.getCell(0)
				.setCellValue(
						"熔炼分厂艾萨工段配料比通知单 smelter ISA change material notification");
		sheet.getRow(3).getCell(0).setCellStyle(style);
		// ingredient表
		sheet.addMergedRegion(new Region(5, (short) 0, 5, (short) 1));
		sheet.getRow(5).getCell(0).setCellValue("单位(吨)");
		sheet.getRow(5).getCell(0).setCellStyle(style);
		sheet.getRow(5).getCell(2).setCellValue("LUANSHYA");
		sheet.getRow(5).getCell(2).setCellStyle(style);
		sheet.getRow(5).getCell(3).setCellValue("KANSANSHI");
		sheet.getRow(5).getCell(3).setCellStyle(style);
		sheet.getRow(5).getCell(4).setCellValue("LUMWANA");
		sheet.getRow(5).getCell(4).setCellStyle(style);
		sheet.getRow(5).getCell(5).setCellValue("CHIBULUMA");
		sheet.getRow(5).getCell(5).setCellStyle(style);
		sheet.getRow(5).getCell(6).setCellValue("ENRC矿");
		sheet.getRow(5).getCell(6).setCellStyle(style);
		sheet.getRow(5).getCell(7).setCellValue("TF矿");
		sheet.getRow(5).getCell(7).setCellStyle(style);
		sheet.getRow(5).getCell(8).setCellValue("COLD冷料");
		sheet.getRow(5).getCell(8).setCellStyle(style);
		sheet.getRow(5).getCell(9).setCellValue("REVERTS");
		sheet.getRow(5).getCell(9).setCellStyle(style);
		sheet.getRow(5).getCell(10).setCellValue("LUBAMBE");
		sheet.getRow(5).getCell(10).setCellStyle(style);
		sheet.getRow(5).getCell(11).setCellValue("NFCA");
		sheet.getRow(5).getCell(11).setCellStyle(style);
		sheet.getRow(5).getCell(12).setCellValue("BOLO");
		sheet.getRow(5).getCell(12).setCellStyle(style);
		sheet.getRow(5).getCell(13).setCellValue("CCS矿");
		sheet.getRow(5).getCell(13).setCellStyle(style);
		sheet.addMergedRegion(new Region(8, (short) 0, 8, (short) 1));
		sheet.getRow(8).getCell(0).setCellValue("目前库存");
		sheet.getRow(8).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(9, (short) 0, 10, (short) 13));
		// stock表
		sheet.getRow(11).setHeight((short) 700);
		sheet.getRow(11).getCell(0).setCellValue("仓号");
		sheet.getRow(11).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(11, (short) 1, 11, (short) 3));
		sheet.getRow(11).getCell(1).setCellValue("精矿名称 copper material name");
		sheet.getRow(11).getCell(1).setCellStyle(style);
		sheet.getRow(11).getCell(4).setCellValue("Cu");
		sheet.getRow(11).getCell(4).setCellStyle(style);
		sheet.getRow(11).getCell(5).setCellValue("Fe");
		sheet.getRow(11).getCell(5).setCellStyle(style);
		sheet.getRow(11).getCell(6).setCellValue("S");
		sheet.getRow(11).getCell(6).setCellStyle(style);
		sheet.getRow(11).getCell(7).setCellValue("SiO2");
		sheet.getRow(11).getCell(7).setCellStyle(style);
		sheet.getRow(11).getCell(8).setCellValue("CaO");
		sheet.getRow(11).getCell(8).setCellStyle(style);
		sheet.getRow(11).getCell(9).setCellValue("MgO");
		sheet.getRow(11).getCell(9).setCellStyle(style);
		sheet.getRow(11).getCell(10).setCellValue("Al2O3");
		sheet.getRow(11).getCell(10).setCellStyle(style);
		sheet.getRow(11).getCell(11).setCellValue("Co");
		sheet.getRow(11).getCell(11).setCellStyle(style);
		sheet.addMergedRegion(new Region(11, (short) 12, 11, (short) 13));
		sheet.getRow(11).getCell(12).setCellValue("用量 dosage");
		sheet.getRow(11).getCell(12).setCellStyle(style);
		sheet.getRow(12).getCell(0).setCellValue("1");
		sheet.getRow(12).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(12, (short) 1, 12, (short) 3));
		sheet.getRow(13).getCell(0).setCellValue("2");
		sheet.getRow(13).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(13, (short) 1, 13, (short) 3));
		sheet.getRow(14).getCell(0).setCellValue("3");
		sheet.getRow(14).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(14, (short) 1, 14, (short) 3));
		sheet.getRow(15).getCell(0).setCellValue("4");
		sheet.getRow(15).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(15, (short) 1, 15, (short) 3));
		sheet.getRow(16).getCell(0).setCellValue("8");
		sheet.getRow(16).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(16, (short) 1, 16, (short) 3));
		sheet.getRow(17).getCell(0).setCellValue("9");
		sheet.getRow(17).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(17, (short) 1, 17, (short) 3));
		sheet.getRow(18).getCell(0).setCellValue("10");
		sheet.getRow(18).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(18, (short) 1, 18, (short) 3));
		sheet.getRow(19).getCell(0).setCellValue("11");
		sheet.getRow(19).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(19, (short) 1, 19, (short) 3));
		sheet.getRow(20).getCell(0).setCellValue("12");
		sheet.getRow(20).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(20, (short) 1, 20, (short) 3));
		// 合并“用量”的单元格
		sheet.addMergedRegion(new Region(12, (short) 12, 12, (short) 13));
		sheet.addMergedRegion(new Region(13, (short) 12, 13, (short) 13));
		sheet.addMergedRegion(new Region(14, (short) 12, 14, (short) 13));
		sheet.addMergedRegion(new Region(15, (short) 12, 15, (short) 13));
		sheet.addMergedRegion(new Region(16, (short) 12, 16, (short) 13));
		sheet.addMergedRegion(new Region(17, (short) 12, 17, (short) 13));
		sheet.addMergedRegion(new Region(18, (short) 12, 18, (short) 13));
		sheet.addMergedRegion(new Region(19, (short) 12, 19, (short) 13));
		sheet.addMergedRegion(new Region(20, (short) 12, 20, (short) 13));
		sheet.addMergedRegion(new Region(21, (short) 12, 21, (short) 13));
		sheet.getRow(21).setHeight((short) 700);
		sheet.addMergedRegion(new Region(21, (short) 0, 21, (short) 3));
		sheet.getRow(21).getCell(0).setCellValue("模块输入成分 concentrate");
		sheet.getRow(21).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(22, (short) 0, 22, (short) 13));
		// summary表
		sheet.addMergedRegion(new Region(23, (short) 0, 23, (short) 13));
		sheet.getRow(23).getCell(0).setCellValue("控制参数 control parameter");
		sheet.getRow(23).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(24, (short) 0, 24, (short) 6));
		sheet.getRow(24).getCell(0).setCellValue("换料后 after change");
		sheet.getRow(24).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(24, (short) 7, 24, (short) 13));
		sheet.getRow(24).getCell(7).setCellValue("换料前 before change");
		sheet.getRow(24).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(25, (short) 0, 25, (short) 1));
		sheet.getRow(25).getCell(0).setCellValue("富氧浓度% oxygen in lance");
		sheet.getRow(25).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(25, (short) 3, 25, (short) 5));
		sheet.getRow(25).getCell(3)
				.setCellValue("目标冰铜品位% target control matte grade");
		sheet.getRow(25).getCell(3).setCellStyle(style);
		sheet.addMergedRegion(new Region(25, (short) 7, 25, (short) 8));
		sheet.getRow(25).getCell(7).setCellValue("富氧浓度% oxygen in lance");
		sheet.getRow(25).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(25, (short) 10, 25, (short) 12));
		sheet.getRow(25).getCell(10)
				.setCellValue("实际冰铜品位% reality matte grade");
		sheet.getRow(25).getCell(10).setCellStyle(style);
		sheet.addMergedRegion(new Region(26, (short) 0, 26, (short) 1));
		sheet.getRow(26).getCell(0).setCellValue("数模%target matte grade");
		sheet.getRow(26).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(26, (short) 3, 26, (short) 5));
		sheet.getRow(26).getCell(3)
				.setCellValue("目标Fe3O4 target magnetic iron");
		sheet.getRow(26).getCell(3).setCellStyle(style);
		sheet.addMergedRegion(new Region(26, (short) 7, 26, (short) 8));
		sheet.getRow(26).getCell(7).setCellValue("数模% target matte grade");
		sheet.getRow(26).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(26, (short) 10, 26, (short) 12));
		sheet.getRow(26).getCell(10)
				.setCellValue("实际Fe3O4 reality magnetic iron");
		sheet.getRow(26).getCell(10).setCellStyle(style);
		sheet.addMergedRegion(new Region(27, (short) 0, 27, (short) 1));
		sheet.getRow(27).getCell(0).setCellValue("氧料比oxygen/material ratio");
		sheet.getRow(27).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(27, (short) 3, 27, (short) 5));
		sheet.getRow(27).getCell(3).setCellValue("目标SiO2/Fe target SiO2/Fe");
		sheet.getRow(27).getCell(3).setCellStyle(style);
		sheet.addMergedRegion(new Region(27, (short) 7, 27, (short) 8));
		sheet.getRow(27).getCell(7).setCellValue("氧料比 oxygen/material ratio");
		sheet.getRow(27).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(27, (short) 10, 27, (short) 12));
		sheet.getRow(27).getCell(10).setCellValue("实际SiO2/Fe reality SiO2/Fe");
		sheet.getRow(27).getCell(10).setCellStyle(style);
		sheet.addMergedRegion(new Region(28, (short) 0, 28, (short) 1));
		sheet.getRow(28).getCell(0).setCellValue("风量 blow wind");
		sheet.getRow(28).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(28, (short) 3, 28, (short) 5));
		sheet.getRow(28).getCell(3).setCellValue("目标SiO2/CaO target SiO2/CaO");
		sheet.getRow(28).getCell(3).setCellStyle(style);
		sheet.addMergedRegion(new Region(28, (short) 7, 28, (short) 8));
		sheet.getRow(28).getCell(7).setCellValue("风量 blow wind");
		sheet.getRow(28).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(28, (short) 10, 28, (short) 12));
		sheet.getRow(28).getCell(10)
				.setCellValue("实际SiO2/CaO reality SiO2/CaO");
		sheet.getRow(28).getCell(10).setCellStyle(style);
		sheet.addMergedRegion(new Region(29, (short) 0, 29, (short) 1));
		sheet.getRow(29).getCell(0).setCellValue("补硅t/h");
		sheet.getRow(29).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(29, (short) 3, 29, (short) 5));
		sheet.getRow(29).getCell(3).setCellValue("补钙t/h");
		sheet.getRow(29).getCell(3).setCellStyle(style);
		sheet.addMergedRegion(new Region(29, (short) 7, 29, (short) 8));
		sheet.getRow(29).getCell(7).setCellValue("补硅t/h");
		sheet.getRow(29).getCell(7).setCellStyle(style);
		sheet.addMergedRegion(new Region(29, (short) 10, 29, (short) 12));
		sheet.getRow(29).getCell(10).setCellValue("补钙t/h");
		sheet.getRow(29).getCell(10).setCellStyle(style);
		sheet.addMergedRegion(new Region(30, (short) 0, 32, (short) 13));
		sheet.getRow(30).getCell(0).setCellValue("班组换料反馈:");
		sheet.getRow(30).getCell(0).setCellStyle(style2);
		sheet.addMergedRegion(new Region(33, (short) 0, 34, (short) 6));
		sheet.getRow(33).getCell(0).setCellValue("编制：");
		sheet.getRow(33).getCell(0).setCellStyle(style2);
		sheet.addMergedRegion(new Region(33, (short) 7, 34, (short) 13));
		sheet.getRow(33).getCell(7).setCellValue("审核：");
		sheet.getRow(33).getCell(7).setCellStyle(style2);
		sheet.addMergedRegion(new Region(35, (short) 0, 37, (short) 1));
		sheet.getRow(35).getCell(0).setCellValue("change time换料时间：");
		sheet.getRow(35).getCell(0).setCellStyle(style2);
		sheet.addMergedRegion(new Region(35, (short) 2, 37, (short) 6));
		sheet.getRow(35).getCell(2).setCellStyle(style2);
		sheet.addMergedRegion(new Region(35, (short) 7, 37, (short) 9));
		sheet.getRow(35).getCell(7)
				.setCellValue("change material shift换料班组签字确认矿:");
		sheet.getRow(35).getCell(7).setCellStyle(style2);
		sheet.addMergedRegion(new Region(35, (short) 10, 37, (short) 13));
		sheet.getRow(35).getCell(10).setCellStyle(style2);
		try {
			// 从数据库中取出记录
			ingre = new IngredientDAO().FindOneByNum(number);
			s = new StockDAO().FindByNum(number);
			sum = new SummaryDAO().FindOneByNum(number);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// 补全stock表中未填写的信息
		sheet.addMergedRegion(new Region(6, (short) 0, 6, (short) 1));
		sheet.getRow(6).getCell(0).setCellValue(s.getLm_value() + "月计划库存");
		sheet.getRow(6).getCell(0).setCellStyle(style);
		sheet.addMergedRegion(new Region(7, (short) 0, 7, (short) 1));
		sheet.getRow(7).getCell(0).setCellValue(s.getTm_value() + "月计划采购");
		sheet.getRow(7).getCell(0).setCellStyle(style);
		// 初始化stock表数据
		if (s != null) {
			// 获取所有声明的字段
			Field[] fields = s.getClass().getDeclaredFields();
			// 从第4个声明的字段开始
			short k = 3;
			// 行遍历
			for (int i = 6; i <= 8; i++) {
				// 列遍历
				for (int j = 2; j <= 13; j++) {
					// 依次获取声明的变量名
					String fieldName = fields[k].getName();
					// 生成get方法名
					String getMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					try {
						// 通过反射生成类对象生成实例方法直接执行
						String value = s.getClass()
								.getMethod(getMethodName, new Class[] {})
								.invoke(s, new Object[] {}).toString();
						Double dvalue = Double.parseDouble(value);
						sheet.getRow(i).getCell(j)
								.setCellValue(String.format("%.2f", dvalue));
						sheet.getRow(i).getCell(j).setCellStyle(style);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 如果没遍历完所有声明，就继续增加k
					if (k < fields.length - 1)
						k++;
				}
			}
		}
		if (ingre != null) {
			// 初始化ingredient表
			try {
				// 获取所有声明的字段
				Field[] fields = Class.forName("com.ccs.entity.Ingredient")
						.getDeclaredFields();
				// 用于存储双精度数据进行计算
				// double[] sum2 = new double[11];
				// 从第4个声明的字段开始
				short k = 3;
				// 行遍历
				for (int i = 12; i <= 21; i++) {
					// 列遍历
					for (int j = 3; j <= 11; j++) {
						String fieldName = fields[k].getName();
						// 生成get方法名
						String getMethodName = "get"
								+ fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
						String value = ingre.getClass()
								.getMethod(getMethodName, new Class[] {})
								.invoke(ingre, new Object[] {}).toString();
						if (j == 3) {
							// 设置精矿名称
							// i为21时是模块输入成分，不需要设置名字
							if (i == 21)
								continue;
							sheet.getRow(i).getCell(j - 2).setCellValue(value);
							sheet.getRow(i).getCell(j - 2).setCellStyle(style);
						} else {
							if (!"".equals(value)) {
								Double dvalue = Double.parseDouble(value);
								// sum2[j] += dvalue;
								sheet.getRow(i)
										.getCell(j)
										.setCellValue(
												String.format("%.2f", dvalue));
								sheet.getRow(i).getCell(j).setCellStyle(style);
							}
						}
						// 如果没遍历完所有声明，就继续增加k
						if (k < fields.length - 1)
							k++;
					}
				}
				// 单独设置“模块输入成分”的“总用量”
				Double dosage = Double.parseDouble(ingre.getCon_dosage());
				sheet.getRow(21).getCell(12)
						.setCellValue(String.format("%.2f", dosage));
				sheet.getRow(21).getCell(12).setCellStyle(style);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sum != null) {
			try {
				// 获取summary表中的dosage字段来填充
				// 获取所有声明的字段
				Field[] fields = sum.getClass().getDeclaredFields();
				// 从第14个声明的字段开始
				short k = 13;
				// 计算用量总和
				// double sum3 = 0;
				// 第12-20行填写精矿用量(2017.2.15)
				for (int i = 12; i <= 20; i++) {
					// 不需要5、6、7号仓，直接跳过
					if (k == 17)
						k = 20;
					// 依次获取声明的变量名
					String fieldName = fields[k].getName();
					// 生成get方法名
					String getMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					String value = sum.getClass()
							.getMethod(getMethodName, new Class[] {})
							.invoke(sum, new Object[] {}).toString();
					// 2017.2.16更新：防止空串导致错误!
					if (!"".equals(value)) {
						Double dvalue = Double.parseDouble(value);
						// sum3 += dvalue;
						sheet.getRow(i).getCell(12)
								.setCellValue(String.format("%.2f", dvalue));
						sheet.getRow(i).getCell(12).setCellStyle(style);
					}
					k++;// 最后一次完成后，k应该为25
				}
				int[] col = { 2, 6, 9, 13 };
				// 初始化summary表
				for (int j = 0; j < 4; j++) {
					// 需要填写第25~29行
					for (int i = 25; i <= 29; i++) {
						// 依次获取声明的变量名
						String fieldName = fields[k].getName();
						// 生成get方法名
						String getMethodName = "get"
								+ fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
						String value = sum.getClass()
								.getMethod(getMethodName, new Class[] {})
								.invoke(sum, new Object[] {}).toString();
						Double dvalue = Double.parseDouble(value);
						// 设置行高度
						sheet.getRow(i).setHeight((short) 700);
						sheet.getRow(i).getCell(col[j])
								.setCellValue(String.format("%.2f", dvalue));
						sheet.getRow(i).getCell(col[j]).setCellStyle(style);
						if (k < fields.length - 1)
							k++;
					}
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 文件输出
		try {
			wb.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
