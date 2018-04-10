package com.ccs.entity;

/*
 * 5月27日，需求变动。此实体类已被修改！
 * 
 * 6月30日，需求变动，此实体类再次被修改！
 * 
 */

public class Stock {
	private int id;
	private String number;
	private String date;
	private String lm_LUANSHYA;
	private String lm_KANSANSHI;
	private String lm_LUMWANA;
	private String lm_CHIBULUMA;
	private String lm_ENRC;
	private String lm_TF;
	private String lm_COLD;
	private String lm_REVERTS;
	private String lm_LUBAMBE;
	private String lm_NFCA;
	private String lm_BOLO;
	private String lm_CCS;
	private String tm_LUANSHYA;
	private String tm_KANSANSHI;
	private String tm_LUMWANA;
	private String tm_CHIBULUMA;
	private String tm_ENRC;
	private String tm_TF;
	private String tm_COLD;
	private String tm_REVERTS;
	private String tm_LUBAMBE;
	private String tm_NFCA;
	private String tm_BOLO;
	private String tm_CCS;
	private String cur_LUANSHYA;
	private String cur_KANSANSHI;
	private String cur_LUMWANA;
	private String cur_CHIBULUMA;
	private String cur_ENRC;
	private String cur_TF;
	private String cur_COLD;
	private String cur_REVERTS;
	private String cur_LUBAMBE;
	private String cur_NFCA;
	private String cur_BOLO;
	private String cur_CCS;
	// 7月9日添加
	private String lm_value;
	private String tm_value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLm_LUANSHYA() {
		return lm_LUANSHYA;
	}

	public void setLm_LUANSHYA(String lm_LUANSHYA) {
		this.lm_LUANSHYA = lm_LUANSHYA;
	}

	public String getLm_KANSANSHI() {
		return lm_KANSANSHI;
	}

	public void setLm_KANSANSHI(String lm_KANSANSHI) {
		this.lm_KANSANSHI = lm_KANSANSHI;
	}

	public String getLm_LUMWANA() {
		return lm_LUMWANA;
	}

	public void setLm_LUMWANA(String lm_LUMWANA) {
		this.lm_LUMWANA = lm_LUMWANA;
	}

	public String getLm_CHIBULUMA() {
		return lm_CHIBULUMA;
	}

	public void setLm_CHIBULUMA(String lm_CHIBULUMA) {
		this.lm_CHIBULUMA = lm_CHIBULUMA;
	}

	public String getLm_ENRC() {
		return lm_ENRC;
	}

	public void setLm_ENRC(String lm_ENRC) {
		this.lm_ENRC = lm_ENRC;
	}

	public String getLm_TF() {
		return lm_TF;
	}

	public void setLm_TF(String lm_TF) {
		this.lm_TF = lm_TF;
	}

	public String getLm_COLD() {
		return lm_COLD;
	}

	public void setLm_COLD(String lm_COLD) {
		this.lm_COLD = lm_COLD;
	}

	public String getLm_REVERTS() {
		return lm_REVERTS;
	}

	public void setLm_REVERTS(String lm_REVERTS) {
		this.lm_REVERTS = lm_REVERTS;
	}

	public String getLm_LUBAMBE() {
		return lm_LUBAMBE;
	}

	public void setLm_LUBAMBE(String lm_LUBAMBE) {
		this.lm_LUBAMBE = lm_LUBAMBE;
	}

	public String getLm_NFCA() {
		return lm_NFCA;
	}

	public void setLm_NFCA(String lm_NFCA) {
		this.lm_NFCA = lm_NFCA;
	}

	public String getLm_BOLO() {
		return lm_BOLO;
	}

	public void setLm_BOLO(String lm_BOLO) {
		this.lm_BOLO = lm_BOLO;
	}

	public String getLm_CCS() {
		return lm_CCS;
	}

	public void setLm_CCS(String lm_CCS) {
		this.lm_CCS = lm_CCS;
	}

	public String getTm_LUANSHYA() {
		return tm_LUANSHYA;
	}

	public void setTm_LUANSHYA(String tm_LUANSHYA) {
		this.tm_LUANSHYA = tm_LUANSHYA;
	}

	public String getTm_KANSANSHI() {
		return tm_KANSANSHI;
	}

	public void setTm_KANSANSHI(String tm_KANSANSHI) {
		this.tm_KANSANSHI = tm_KANSANSHI;
	}

	public String getTm_LUMWANA() {
		return tm_LUMWANA;
	}

	public void setTm_LUMWANA(String tm_LUMWANA) {
		this.tm_LUMWANA = tm_LUMWANA;
	}

	public String getTm_CHIBULUMA() {
		return tm_CHIBULUMA;
	}

	public void setTm_CHIBULUMA(String tm_CHIBULUMA) {
		this.tm_CHIBULUMA = tm_CHIBULUMA;
	}

	public String getTm_ENRC() {
		return tm_ENRC;
	}

	public void setTm_ENRC(String tm_ENRC) {
		this.tm_ENRC = tm_ENRC;
	}

	public String getTm_TF() {
		return tm_TF;
	}

	public void setTm_TF(String tm_TF) {
		this.tm_TF = tm_TF;
	}

	public String getTm_COLD() {
		return tm_COLD;
	}

	public void setTm_COLD(String tm_COLD) {
		this.tm_COLD = tm_COLD;
	}

	public String getTm_REVERTS() {
		return tm_REVERTS;
	}

	public void setTm_REVERTS(String tm_REVERTS) {
		this.tm_REVERTS = tm_REVERTS;
	}

	public String getTm_LUBAMBE() {
		return tm_LUBAMBE;
	}

	public void setTm_LUBAMBE(String tm_LUBAMBE) {
		this.tm_LUBAMBE = tm_LUBAMBE;
	}

	public String getTm_NFCA() {
		return tm_NFCA;
	}

	public void setTm_NFCA(String tm_NFCA) {
		this.tm_NFCA = tm_NFCA;
	}

	public String getTm_BOLO() {
		return tm_BOLO;
	}

	public void setTm_BOLO(String tm_BOLO) {
		this.tm_BOLO = tm_BOLO;
	}

	public String getTm_CCS() {
		return tm_CCS;
	}

	public void setTm_CCS(String tm_CCS) {
		this.tm_CCS = tm_CCS;
	}

	public String getCur_LUANSHYA() {
		return cur_LUANSHYA;
	}

	public void setCur_LUANSHYA(String cur_LUANSHYA) {
		this.cur_LUANSHYA = cur_LUANSHYA;
	}

	public String getCur_KANSANSHI() {
		return cur_KANSANSHI;
	}

	public void setCur_KANSANSHI(String cur_KANSANSHI) {
		this.cur_KANSANSHI = cur_KANSANSHI;
	}

	public String getCur_LUMWANA() {
		return cur_LUMWANA;
	}

	public void setCur_LUMWANA(String cur_LUMWANA) {
		this.cur_LUMWANA = cur_LUMWANA;
	}

	public String getCur_CHIBULUMA() {
		return cur_CHIBULUMA;
	}

	public void setCur_CHIBULUMA(String cur_CHIBULUMA) {
		this.cur_CHIBULUMA = cur_CHIBULUMA;
	}

	public String getCur_ENRC() {
		return cur_ENRC;
	}

	public void setCur_ENRC(String cur_ENRC) {
		this.cur_ENRC = cur_ENRC;
	}

	public String getCur_TF() {
		return cur_TF;
	}

	public void setCur_TF(String cur_TF) {
		this.cur_TF = cur_TF;
	}

	public String getCur_COLD() {
		return cur_COLD;
	}

	public void setCur_COLD(String cur_COLD) {
		this.cur_COLD = cur_COLD;
	}

	public String getCur_REVERTS() {
		return cur_REVERTS;
	}

	public void setCur_REVERTS(String cur_REVERTS) {
		this.cur_REVERTS = cur_REVERTS;
	}

	public String getCur_LUBAMBE() {
		return cur_LUBAMBE;
	}

	public void setCur_LUBAMBE(String cur_LUBAMBE) {
		this.cur_LUBAMBE = cur_LUBAMBE;
	}

	public String getCur_NFCA() {
		return cur_NFCA;
	}

	public void setCur_NFCA(String cur_NFCA) {
		this.cur_NFCA = cur_NFCA;
	}

	public String getCur_BOLO() {
		return cur_BOLO;
	}

	public void setCur_BOLO(String cur_BOLO) {
		this.cur_BOLO = cur_BOLO;
	}

	public String getCur_CCS() {
		return cur_CCS;
	}

	public void setCur_CCS(String cur_CCS) {
		this.cur_CCS = cur_CCS;
	}

	public String getLm_value() {
		return lm_value;
	}

	public void setLm_value(String lm_value) {
		this.lm_value = lm_value;
	}

	public String getTm_value() {
		return tm_value;
	}

	public void setTm_value(String tm_value) {
		this.tm_value = tm_value;
	}

}
