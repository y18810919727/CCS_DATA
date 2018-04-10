/*时间：2015.04.2
 * 内容：根据account表创建User实体对象
 * 作者：YPF
 * */
package com.ccs.entity;

public class User {
	private String password;
	private String style;
	private String name;
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getStyle(){
		return style;
	}
	public void setStyle(String style){
		this.style = style;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
