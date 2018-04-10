package com.ccs.entity;

public class Mineral {
	private int id;
	private String mine_number;
	private String date;
	private int housenum;
	private String name;
	private double Cu;
	private double Fe;
	private double S;
	private double SiO2;
	private double CaO;
	private double MgO;
	private double Al2O3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMine_number() {
		return mine_number;
	}

	public void setMine_number(String mine_number) {
		this.mine_number = mine_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHousenum() {
		return housenum;
	}

	public void setHousenum(int housenum) {
		this.housenum = housenum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCu() {
		return Cu;
	}

	public void setCu(double cu) {
		Cu = cu;
	}

	public double getFe() {
		return Fe;
	}

	public void setFe(double fe) {
		Fe = fe;
	}

	public double getS() {
		return S;
	}

	public void setS(double s) {
		S = s;
	}

	public double getSiO2() {
		return SiO2;
	}

	public void setSiO2(double siO2) {
		SiO2 = siO2;
	}

	public double getCaO() {
		return CaO;
	}

	public void setCaO(double caO) {
		CaO = caO;
	}

	public double getMgO() {
		return MgO;
	}

	public void setMgO(double mgO) {
		MgO = mgO;
	}

	public double getAl2O3() {
		return Al2O3;
	}

	public void setAl2O3(double al2o3) {
		Al2O3 = al2o3;
	}
}
