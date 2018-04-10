/*时间：2015.04.24
 * 内容：1.添加了readCookie(HttpServletRequest request)函数，读取本地cookie文件中的用户账号名
 *	2.添加了checknewpassword(String str1,String str2)函数，比较用户两次输入的新密码是否匹配
 * 	3.添加了MatchOldPassword(String username,String oldpassword)函数，比较用输入的旧密码是否正确
 * 	4.添加了startUpdatePassword(String username,String newpassword)函数，开始修改用户密码，返回修改结果
 * */
package com.ccs.biz;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.ccs.dao.AccountDAO;
import com.ccs.entity.User;

public class UpdatePassword {
	//开始修改用户的密码，并返回修改结果
		public boolean startUpdatePassword(String username,String newpassword){
			int res = new AccountDAO().UpdatePassword(username, newpassword);
			if(res == 0){
				return false;
			}else{
				return true;
			}
		}
}
