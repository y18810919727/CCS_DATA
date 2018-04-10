package com.ccs.util;

import java.sql.SQLException;

import com.ccs.dao.MineralDAO;
import com.ccs.dao.ProductionDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.dao.WarehouseDAO;
import com.ccs.entity.Mineral;
import com.ccs.entity.Production;
import com.ccs.entity.Stock;
import com.ccs.entity.Summary;
import com.ccs.entity.Warehouse;

/*
 * 数据库功能测试类。用于开发人员进行数据库连接性能等测试。
 */
public class DBTestUtil {
	public static void main(String[] args) {
		// try {
		// int m = new StockDAO().FindCountByDate("2015-04-19");
		// System.out.println(m);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Mineral m = new Mineral();
		// m.setName("SHIA");
		// m.setMine_number("HIHIHI");
		// m.setDate("2015-08-23");
		// m.setHousenum("14");
		// m.setCu(15.88);
		// m.setFe(13.22);
		// m.setS(7.66);
		// m.setSiO2(9.54);
		// m.setCaO(3.54);
		// m.setMgO(13.33);
		// m.setAl2O3(5.732);
		// try {
		// boolean res = new MineralDAO().UpdateOne(m);
		// System.out.println(res);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Production p = new Production();
		// p.setDate("2014-05-21");
		// p.setNumber("12313123123");
		// p.setColor("red");
		// try {
		// boolean res = new ProductionDAO().UpdateOne(p);
		// System.out.println(res);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Stock s = new Stock();
		// s.setNumber("11111");
		// s.setDate("2015-03-04");
		// s.setLm_REVERTS("15.55");
		// s.setCur_CCS_SC("ABCDEFG");
		// try{
		// boolean res = new StockDAO().InsertOne(s);
		// System.out.println(res);
		// }catch (SQLException e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// Summary s = new Summary();
		// s.setNumber("2015041902");
		// s.setDate("2015-08-08");
		// s.setHouse1(1);
		// try {
		// boolean res = new SummaryDAO().InsertOne(s);
		// System.out.println(res);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Warehouse w = new Warehouse();
		// w.setId(1);
		// w.setHouse1("3");
		// w.setHouse2("4");
		// w.setHouse3("5");
		// try {
		// boolean res = new WarehouseDAO().UpdateOne(w);
		// System.out.println(res);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// System.out.println(new WarehouseDAO().DeleteOne(1));
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
