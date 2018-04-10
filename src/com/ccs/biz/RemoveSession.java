/*时间：2015.04.25
 * 内容：添加函数removeSession（String key），用来移除session中不需要的属性
 * 作者：yepengfei
 * */
package com.ccs.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RemoveSession {
	public void removeSession(String key,HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute(key);
	}
}
