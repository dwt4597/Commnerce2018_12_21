package com.biz.commerce.vo;

public class cmcVO {
	//mimc
	private String strDate; //거래일자
	private String strPCode; //상품코드
	private String strIO; //거래구분
	private int intPrice; //단가
	private int intQuan; //수량
	
	//jpjb
	private String strName; //상품명
	private String strTex; //과세
	private int intIPrice; //매입단가
	private int intOPrice; //매출단가
	private String strPum; //품목
	private String strDept; //주매입처
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrPCode() {
		return strPCode;
	}
	public void setStrPCode(String strPCode) {
		this.strPCode = strPCode;
	}
	public String getStrIO() {
		return strIO;
	}
	public void setStrIO(String strIO) {
		this.strIO = strIO;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntQuan() {
		return intQuan;
	}
	public void setIntQuan(int intQuan) {
		this.intQuan = intQuan;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrTex() {
		return strTex;
	}
	public void setStrTex(String strTex) {
		this.strTex = strTex;
	}
	public int getIntIPrice() {
		return intIPrice;
	}
	public void setIntIPrice(int intIPrice) {
		this.intIPrice = intIPrice;
	}
	public int getIntOPrice() {
		return intOPrice;
	}
	public void setIntOPrice(int intOPrice) {
		this.intOPrice = intOPrice;
	}
	public String getStrPum() {
		return strPum;
	}
	public void setStrPum(String strPum) {
		this.strPum = strPum;
	}
	public String getStrDept() {
		return strDept;
	}
	public void setStrDept(String strDept) {
		this.strDept = strDept;
	}
	@Override
	public String toString() {
		return "cmcVO [strDate=" + strDate + ", strPCode=" + strPCode + ", strIO=" + strIO + ", intPrice=" + intPrice
				+ ", intQuan=" + intQuan + ", strName=" + strName + ", strTex=" + strTex + ", intIPrice=" + intIPrice
				+ ", intOPrice=" + intOPrice + ", strPum=" + strPum + ", strDept=" + strDept + "]";
	}
	
	
	
}
