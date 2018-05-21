/*时间：2015.04.22
 * 内容：创建数据库操作AccountDAO类，添加了FindAllUser(String username)函数，实现数据库的查询功能，
 * 并返回一条用户及记录。
 * 作者：yepengfei
 * */
/*时间：2015.04.24
 * 内容：1.UpdatePassword(String username,String newpassword)，实现更改修改用户密码的数据库操作层的逻辑，
 * 并返回操作结果。
 * 作者：yepengfei
 * */
package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Production;
import com.ccs.entity.User;
import com.ccs.util.DBUtil;

public class AccountDAO {
	//查询数据库，并返回符合要求的一条的用户信息
	public User FindAllUser(String username){
		List<User> account_list = new ArrayList<User>(); 
		User user = null;
		String sql = "select * from account where name="+"'"+username+"'";
		//从DBUtil里获得Connection实例
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pres = connection.prepareStatement(sql);
			ResultSet res =pres.executeQuery();
			if(res.next()){
				user = new User();
				user.setPassword(res.getString(2));
				user.setStyle(res.getString(3));
				user.setName(res.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConnection();
		return user;
	}
	//更新用户密码，并返回操作结果
	public int UpdatePassword(String username,String newpassword){
		int res=0; 
		//设置sql语句
		String sql = "update account set password = "+newpassword+" where name = '"+username+"'";
		//从DBUtil中获得Connection的实例
		Connection connection = DBUtil.getConnection();
		//从Connection实例中得到一个PreparedStatement实例
		try {
			PreparedStatement pres = connection.prepareStatement(sql);
			res =pres.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConnection();
		return res;

	}
	
	public String InsertOne(User user) {
		int result=0;
		String sql = "insert into account (password,style,name) values('"
				+user.getPassword()+"','"+user.getStyle()+"','"+user.getName()+"')";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeConnection();
		if (result > 0)
			return "succeed";
		else
			return "fail";
	}
}
