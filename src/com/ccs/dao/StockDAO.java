package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Stock;
import com.ccs.util.DBUtil;

/*
 * 配料库存表数据库操作对象。 可进行增删改查。4月23日完成。
 * 
 * 5月27日进行修改，根据Stock实体类的变化，修改了相应的增删改查语句
 * 
 * 7月修改需求，已经增加了必要字段
 * 
 */
public class StockDAO {
	/**
	 * 查询配料库存表所有记录
	 * 
	 * @return List<Stock> 一个包含stock表全部记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Stock> FindAll() throws SQLException {
		List<Stock> list = new ArrayList<Stock>();
		String sql = "select * from stock";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Stock s = new Stock();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setLm_LUANSHYA(rs.getString(4));
			s.setLm_KANSANSHI(rs.getString(5));
			s.setLm_LUMWANA(rs.getString(6));
			s.setLm_CHIBULUMA(rs.getString(7));
			s.setLm_ENRC(rs.getString(8));
			s.setLm_TF(rs.getString(9));
			s.setLm_COLD(rs.getString(10));
			s.setLm_REVERTS(rs.getString(11));
			s.setLm_LUBAMBE(rs.getString(12));
			s.setLm_NFCA(rs.getString(13));
			s.setTm_LUANSHYA(rs.getString(14));
			s.setTm_KANSANSHI(rs.getString(15));
			s.setTm_LUMWANA(rs.getString(16));
			s.setTm_CHIBULUMA(rs.getString(17));
			s.setTm_ENRC(rs.getString(18));
			s.setTm_TF(rs.getString(19));
			s.setTm_COLD(rs.getString(20));
			s.setTm_REVERTS(rs.getString(21));
			s.setTm_LUBAMBE(rs.getString(22));
			s.setTm_NFCA(rs.getString(23));
			s.setCur_LUANSHYA(rs.getString(24));
			s.setCur_KANSANSHI(rs.getString(25));
			s.setCur_LUMWANA(rs.getString(26));
			s.setCur_CHIBULUMA(rs.getString(27));
			s.setCur_ENRC(rs.getString(28));
			s.setCur_TF(rs.getString(29));
			s.setCur_COLD(rs.getString(30));
			s.setCur_REVERTS(rs.getString(31));
			s.setCur_LUBAMBE(rs.getString(32));
			s.setCur_NFCA(rs.getString(33));
			s.setLm_value(rs.getString(34));
			s.setTm_value(rs.getString(35));
			s.setLm_BOLO(rs.getString(36));
			s.setLm_CCS(rs.getString(37));
			s.setTm_BOLO(rs.getString(38));
			s.setTm_CCS(rs.getString(39));
			s.setCur_BOLO(rs.getString(40));
			s.setCur_CCS(rs.getString(41));
			list.add(s);
		}
		return list;
	}

	/**
	 * 按日期查询配料库存表相关记录
	 * 
	 * @return List<Stock> 一个包含指定日期的stock表记录的集合
	 * @param date
	 *            要查找的日期
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Stock> FindByDate(String date) throws SQLException {
		List<Stock> list = new ArrayList<Stock>();
		String sql = "select * from stock where date='" + date + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Stock s = new Stock();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setLm_LUANSHYA(rs.getString(4));
			s.setLm_KANSANSHI(rs.getString(5));
			s.setLm_LUMWANA(rs.getString(6));
			s.setLm_CHIBULUMA(rs.getString(7));
			s.setLm_ENRC(rs.getString(8));
			s.setLm_TF(rs.getString(9));
			s.setLm_COLD(rs.getString(10));
			s.setLm_REVERTS(rs.getString(11));
			s.setLm_LUBAMBE(rs.getString(12));
			s.setLm_NFCA(rs.getString(13));
			s.setTm_LUANSHYA(rs.getString(14));
			s.setTm_KANSANSHI(rs.getString(15));
			s.setTm_LUMWANA(rs.getString(16));
			s.setTm_CHIBULUMA(rs.getString(17));
			s.setTm_ENRC(rs.getString(18));
			s.setTm_TF(rs.getString(19));
			s.setTm_COLD(rs.getString(20));
			s.setTm_REVERTS(rs.getString(21));
			s.setTm_LUBAMBE(rs.getString(22));
			s.setTm_NFCA(rs.getString(23));
			s.setCur_LUANSHYA(rs.getString(24));
			s.setCur_KANSANSHI(rs.getString(25));
			s.setCur_LUMWANA(rs.getString(26));
			s.setCur_CHIBULUMA(rs.getString(27));
			s.setCur_ENRC(rs.getString(28));
			s.setCur_TF(rs.getString(29));
			s.setCur_COLD(rs.getString(30));
			s.setCur_REVERTS(rs.getString(31));
			s.setCur_LUBAMBE(rs.getString(32));
			s.setCur_NFCA(rs.getString(33));
			s.setLm_value(rs.getString(34));
			s.setTm_value(rs.getString(35));
			s.setLm_BOLO(rs.getString(36));
			s.setLm_CCS(rs.getString(37));
			s.setTm_BOLO(rs.getString(38));
			s.setTm_CCS(rs.getString(39));
			s.setCur_BOLO(rs.getString(40));
			s.setCur_CCS(rs.getString(41));
			list.add(s);
		}
		return list;
	}

	/**
	 * 按日期查询配料库存表相关记录（4月28日添加）
	 * 
	 * @return Stock 一条包含指定单号的stock表记录
	 * @param number
	 *            要查找的日期
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public Stock FindByNum(String number) throws SQLException {
		Stock s = null;
		String sql = "select * from stock where number='" + number + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			s = new Stock();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setLm_LUANSHYA(rs.getString(4));
			s.setLm_KANSANSHI(rs.getString(5));
			s.setLm_LUMWANA(rs.getString(6));
			s.setLm_CHIBULUMA(rs.getString(7));
			s.setLm_ENRC(rs.getString(8));
			s.setLm_TF(rs.getString(9));
			s.setLm_COLD(rs.getString(10));
			s.setLm_REVERTS(rs.getString(11));
			s.setLm_LUBAMBE(rs.getString(12));
			s.setLm_NFCA(rs.getString(13));
			s.setTm_LUANSHYA(rs.getString(14));
			s.setTm_KANSANSHI(rs.getString(15));
			s.setTm_LUMWANA(rs.getString(16));
			s.setTm_CHIBULUMA(rs.getString(17));
			s.setTm_ENRC(rs.getString(18));
			s.setTm_TF(rs.getString(19));
			s.setTm_COLD(rs.getString(20));
			s.setTm_REVERTS(rs.getString(21));
			s.setTm_LUBAMBE(rs.getString(22));
			s.setTm_NFCA(rs.getString(23));
			s.setCur_LUANSHYA(rs.getString(24));
			s.setCur_KANSANSHI(rs.getString(25));
			s.setCur_LUMWANA(rs.getString(26));
			s.setCur_CHIBULUMA(rs.getString(27));
			s.setCur_ENRC(rs.getString(28));
			s.setCur_TF(rs.getString(29));
			s.setCur_COLD(rs.getString(30));
			s.setCur_REVERTS(rs.getString(31));
			s.setCur_LUBAMBE(rs.getString(32));
			s.setCur_NFCA(rs.getString(33));
			s.setLm_value(rs.getString(34));
			s.setTm_value(rs.getString(35));
			s.setLm_BOLO(rs.getString(36));
			s.setLm_CCS(rs.getString(37));
			s.setTm_BOLO(rs.getString(38));
			s.setTm_CCS(rs.getString(39));
			s.setCur_BOLO(rs.getString(40));
			s.setCur_CCS(rs.getString(41));
		}
		return s;
	}

	/**
	 * 查询配料库存表指定日期下的记录数量（4月26日添加）
	 * 
	 * @return int 包含该日期的记录条数
	 * @param date
	 *            要查找的日期
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public int FindCountByDate(String date) throws SQLException {
		int count = 0;
		String sql = "select count(*) from stock where date ='" + date + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	/**
	 * 向配料库存表中插入一条记录
	 * 
	 * @param s
	 *            一个配料库存记录实体
	 * @return boolean 插入记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Stock s) throws SQLException {
		String exe = "insert into stock ";
		String col = "(number,date,lm_LUANSHYA,lm_KANSANSHI,lm_LUMWANA,"
				+ "lm_CHIBULUMA,lm_ENRC,lm_TF,lm_COLD,lm_REVERTS,lm_LUBAMBE,"
				+ "lm_NFCA,tm_LUANSHYA,tm_KANSANSHI,tm_LUMWANA,tm_CHIBULUMA,"
				+ "tm_ENRC,tm_TF,tm_COLD,tm_REVERTS,tm_LUBAMBE,tm_NFCA,"
				+ "cur_LUANSHYA,cur_KANSANSHI,cur_LUMWANA,cur_CHIBULUMA,"
				+ "cur_ENRC,cur_TF,cur_COLD,cur_REVERTS,cur_LUBAMBE,"
				+ "cur_NFCA,lm_value,tm_value,lm_BOLO,lm_CCS,tm_BOLO,tm_CCS,"
				+ "cur_BOLO,cur_CCS) ";
		String val = "values('" + s.getNumber() + "','" + s.getDate() + "','"
				+ s.getLm_LUANSHYA() + "','" + s.getLm_KANSANSHI() + "','"
				+ s.getLm_LUMWANA() + "','" + s.getLm_CHIBULUMA() + "','"
				+ s.getLm_ENRC() + "','" + s.getLm_TF() + "','"
				+ s.getLm_COLD() + "','" + s.getLm_REVERTS() + "','"
				+ s.getLm_LUBAMBE() + "','" + s.getLm_NFCA() + "','"
				+ s.getTm_LUANSHYA() + "','" + s.getTm_KANSANSHI() + "','"
				+ s.getTm_LUMWANA() + "','" + s.getTm_CHIBULUMA() + "','"
				+ s.getTm_ENRC() + "','" + s.getTm_TF() + "','"
				+ s.getTm_COLD() + "','" + s.getTm_REVERTS() + "','"
				+ s.getTm_LUBAMBE() + "','" + s.getTm_NFCA() + "','"
				+ s.getCur_LUANSHYA() + "','" + s.getCur_KANSANSHI() + "','"
				+ s.getCur_LUMWANA() + "','" + s.getCur_CHIBULUMA() + "','"
				+ s.getCur_ENRC() + "','" + s.getCur_TF() + "','"
				+ s.getCur_COLD() + "','" + s.getCur_REVERTS() + "','"
				+ s.getCur_LUBAMBE() + "','" + s.getCur_NFCA() + "','"
				+ s.getLm_value() + "','" + s.getTm_value() + "','"
				+ s.getLm_BOLO() + "','" + s.getLm_CCS() + "','"
				+ s.getTm_BOLO() + "','" + s.getTm_CCS() + "','"
				+ s.getCur_BOLO() + "','" + s.getCur_CCS() + "')";
		String sql = exe + col + val;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料库存表中修改一条记录
	 * 
	 * @param s
	 *            一个配料库存记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Stock s) throws SQLException {
		String exe = "update stock set ";
		String col = "date='" + s.getDate() + "',lm_LUANSHYA='"
				+ s.getLm_LUANSHYA() + "',lm_KANSANSHI='" + s.getLm_KANSANSHI()
				+ "',lm_LUMWANA='" + s.getLm_LUMWANA() + "',lm_CHIBULUMA='"
				+ s.getLm_CHIBULUMA() + "',lm_ENRC='" + s.getLm_ENRC()
				+ "',lm_TF='" + s.getLm_TF() + "',lm_COLD='" + s.getLm_COLD()
				+ "',lm_REVERTS='" + s.getLm_REVERTS() + "',lm_LUBAMBE='"
				+ s.getLm_LUBAMBE() + "',lm_NFCA='" + s.getLm_NFCA()
				+ "',tm_LUANSHYA='" + s.getTm_LUANSHYA() + "',tm_KANSANSHI='"
				+ s.getTm_KANSANSHI() + "',tm_LUMWANA='" + s.getTm_LUMWANA()
				+ "',tm_CHIBULUMA='" + s.getTm_CHIBULUMA() + "',tm_ENRC='"
				+ s.getTm_ENRC() + "',tm_TF='" + s.getTm_TF() + "',tm_COLD='"
				+ s.getTm_COLD() + "',tm_REVERTS='" + s.getTm_REVERTS()
				+ "',tm_LUBAMBE='" + s.getTm_LUBAMBE() + "',tm_NFCA='"
				+ s.getTm_NFCA() + "',cur_LUANSHYA='" + s.getCur_LUANSHYA()
				+ "',cur_KANSANSHI='" + s.getCur_KANSANSHI()
				+ "',cur_LUMWANA='" + s.getCur_LUMWANA() + "',cur_CHIBULUMA='"
				+ s.getCur_CHIBULUMA() + "',cur_ENRC='" + s.getCur_ENRC()
				+ "',cur_TF='" + s.getCur_TF() + "',cur_COLD='"
				+ s.getCur_COLD() + "',cur_REVERTS='" + s.getCur_REVERTS()
				+ "',cur_LUBAMBE='" + s.getCur_LUBAMBE() + "',cur_NFCA='"
				+ s.getCur_NFCA() + "',lm_value='" + s.getLm_value()
				+ "',tm_value='" + s.getTm_value() + "',lm_BOLO='"
				+ s.getLm_BOLO() + "',lm_CCS='" + s.getLm_CCS() + "',tm_BOLO='"
				+ s.getTm_BOLO() + "',tm_CCS='" + s.getTm_CCS()
				+ "',cur_BOLO='" + s.getCur_BOLO() + "',cur_CCS='"
				+ s.getCur_CCS() + "'";
		String cond = " where number='" + s.getNumber() + "'";
		String sql = exe + col + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料库存表中删除一条记录
	 * 
	 * @param number
	 *            一个配料库存实体的编号
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(String number) throws SQLException {
		String exe = "delete from stock ";
		String cond = "where number='" + number + "'";
		String sql = exe + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}
}
