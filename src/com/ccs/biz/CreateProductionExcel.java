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

import com.ccs.dao.ProductionDAO;
import com.ccs.entity.Mineral;
import com.ccs.entity.Production;

/**
 * 此类用于生成配料单的Excel文件。2015.4.28.Powered By GaoYuxing
 * 
 * */
public class CreateProductionExcel {
	public void onCreate(String date, String number, OutputStream out) {
		List<Production> plist = null;
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("下料记录表");
		// 设置表格默认列宽度
		sheet.setDefaultColumnWidth((short) 8);
		// 创建单元格格式
		HSSFCellStyle style = wb.createCellStyle();
		// 创建一个水平居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 创建一个垂直居中格式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
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
		// 创建一个字体
		HSSFFont font2 = wb.createFont();
		// 设置字体名称
		font2.setFontName("宋体");
		// 将字体加入style
		style2.setFont(font2);
		// 创建一个10行32列的Excel表格
		HSSFRow row;
		HSSFCell cell;
		try {
			// 从数据库中取出记录
			plist = new ProductionDAO().FindAllByNumber(number, date);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (int i = 0; i <plist.size()+1; i++) {
			row = sheet.createRow((int) i);
			for (int j = 0; j < 35; j++) {
				cell = row.createCell((short) j);
			}
		}
		sheet.getRow(0).getCell(0).setCellValue("当班人");
		sheet.getRow(0).getCell(0).setCellStyle(style);
		sheet.getRow(0).getCell(1).setCellValue("班次");
		sheet.getRow(0).getCell(1).setCellStyle(style);
		sheet.getRow(0).getCell(2).setCellValue("样号");
		sheet.getRow(0).getCell(2).setCellStyle(style);
		sheet.getRow(0).getCell(3).setCellValue("目标冰铜品位");
		sheet.getRow(0).getCell(3).setCellStyle(style);
		sheet.getRow(0).getCell(4).setCellValue("实际冰铜品位");
		sheet.getRow(0).getCell(4).setCellStyle(style);
		sheet.getRow(0).getCell(5).setCellValue("目标磁性铁");
		sheet.getRow(0).getCell(5).setCellStyle(style);
		sheet.getRow(0).getCell(6).setCellValue("实际化验室磁性铁");
		sheet.getRow(0).getCell(6).setCellStyle(style);
		sheet.getRow(0).getCell(7).setCellValue("目标硅铁比");
		sheet.getRow(0).getCell(7).setCellStyle(style);
		sheet.getRow(0).getCell(8).setCellValue("实际硅铁比");
		sheet.getRow(0).getCell(8).setCellStyle(style);
		sheet.getRow(0).getCell(9).setCellValue("目标硅钙比");
		sheet.getRow(0).getCell(9).setCellStyle(style);
		sheet.getRow(0).getCell(10).setCellValue("实际硅钙比");
		sheet.getRow(0).getCell(10).setCellStyle(style);
		sheet.getRow(0).getCell(11).setCellValue("渣样磁条磁力大小");
		sheet.getRow(0).getCell(11).setCellStyle(style);
		sheet.getRow(0).getCell(12).setCellValue("断面气泡孔");
		sheet.getRow(0).getCell(12).setCellStyle(style);
		sheet.getRow(0).getCell(13).setCellValue("渣样颜色");
		sheet.getRow(0).getCell(13).setCellStyle(style);
		sheet.getRow(0).getCell(14).setCellValue("喷枪端压");
		sheet.getRow(0).getCell(14).setCellStyle(style);
		sheet.getRow(0).getCell(15).setCellValue("取样时氧料比");
		sheet.getRow(0).getCell(15).setCellStyle(style);
		sheet.getRow(0).getCell(16).setCellValue("取样时小时料量");
		sheet.getRow(0).getCell(16).setCellStyle(style);
		sheet.getRow(0).getCell(17).setCellValue("排放时间");
		sheet.getRow(0).getCell(17).setCellStyle(style);
		sheet.getRow(0).getCell(18).setCellValue("测样时的风量");
		sheet.getRow(0).getCell(18).setCellStyle(style);
		sheet.getRow(0).getCell(19).setCellValue("氧气纯度");
		sheet.getRow(0).getCell(19).setCellStyle(style);
		sheet.getRow(0).getCell(20).setCellValue("富氧浓度");
		sheet.getRow(0).getCell(20).setCellStyle(style);
		sheet.getRow(0).getCell(21).setCellValue("测样时料仓1#下料量");
		sheet.getRow(0).getCell(21).setCellStyle(style);
		sheet.getRow(0).getCell(22).setCellValue("2#");
		sheet.getRow(0).getCell(22).setCellStyle(style);
		sheet.getRow(0).getCell(23).setCellValue("3#");
		sheet.getRow(0).getCell(23).setCellStyle(style);
		sheet.getRow(0).getCell(24).setCellValue("4#");
		sheet.getRow(0).getCell(24).setCellStyle(style);
		sheet.getRow(0).getCell(25).setCellValue("5#");
		sheet.getRow(0).getCell(25).setCellStyle(style);
		sheet.getRow(0).getCell(26).setCellValue("6#");
		sheet.getRow(0).getCell(26).setCellStyle(style);
		sheet.getRow(0).getCell(27).setCellValue("7#");
		sheet.getRow(0).getCell(27).setCellStyle(style);
		sheet.getRow(0).getCell(28).setCellValue("8#");
		sheet.getRow(0).getCell(28).setCellStyle(style);
		sheet.getRow(0).getCell(29).setCellValue("9#");
		sheet.getRow(0).getCell(29).setCellStyle(style);
		sheet.getRow(0).getCell(30).setCellValue("10#");
		sheet.getRow(0).getCell(30).setCellStyle(style);
		sheet.getRow(0).getCell(31).setCellValue("11#");
		sheet.getRow(0).getCell(31).setCellStyle(style);
		sheet.getRow(0).getCell(32).setCellValue("12#");
		sheet.getRow(0).getCell(32).setCellStyle(style);
		sheet.getRow(0).getCell(33).setCellValue("添加时间");
		sheet.getRow(0).getCell(33).setCellStyle(style);
		sheet.getRow(0).getCell(34).setCellValue("熔炼状况评分");
		sheet.getRow(0).getCell(34).setCellStyle(style);
		
		if (plist != null) {
			// 初始化production表
			try {
				// 获取所有声明的字段
				Field[] fields = Class.forName("com.ccs.entity.Production")
						.getDeclaredFields();
				// 设置Excel起始行号
				int i = 1;
				for (Production p : plist) {
					if("0".equals(p.getSampleNo())) continue;
					// 从第6个声明的字段开始
					short k = 3;
					for (int j = 0; j <= 34; j++) {
						// 依次获取声明的变量名
						String fieldName = fields[k].getName();
						// 生成get方法名
						String getMethodName = "get"
								+ fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
						String value = p.getClass()
								.getMethod(getMethodName, new Class[] {})
								.invoke(p, new Object[] {}).toString();
							sheet.getRow(i).getCell(j).setCellValue(value);
							sheet.getRow(i).getCell(j).setCellStyle(style);
						// 如果没遍历完所有声明，就继续增加k
						if (k < fields.length - 1)
							k++;
					}
					i++;
				}
				
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
