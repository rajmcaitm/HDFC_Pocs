package com.hdfc.dto;

public class CustomerResponse {
	Long acc_num;
	String acc_name;
	String custaddr1;
	String custaddr2;
	String emailid;
	Long iec;
	Long mobileno;
	String pannumber;
	String custname;
	public Long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(Long acc_num) {
		this.acc_num = acc_num;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public String getCustaddr1() {
		return custaddr1;
	}
	public void setCustaddr1(String custaddr1) {
		this.custaddr1 = custaddr1;
	}
	public String getCustaddr2() {
		return custaddr2;
	}
	public void setCustaddr2(String custaddr2) {
		this.custaddr2 = custaddr2;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Long getIec() {
		return iec;
	}
	public void setIec(Long iec) {
		this.iec = iec;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public CustomerResponse() {;
	}
	
	
	public CustomerResponse(Long acc_num, String acc_name, String custaddr1, String custaddr2, String emailid, Long iec,
			Long mobileno, String pannumber, String custname) {
		super();
		this.acc_num = acc_num;
		this.acc_name = acc_name;
		this.custaddr1 = custaddr1;
		this.custaddr2 = custaddr2;
		this.emailid = emailid;
		this.iec = iec;
		this.mobileno = mobileno;
		this.pannumber = pannumber;
		this.custname = custname;
	}
	@Override
	public String toString() {
		return "CustomerResponse [acc_num=" + acc_num + ", acc_name=" + acc_name + ", custaddr1=" + custaddr1
				+ ", custaddr2=" + custaddr2 + ", emailid=" + emailid + ", iec=" + iec + ", mobileno=" + mobileno
				+ ", pannumber=" + pannumber + ", custname=" + custname + "]";
	}
	
	
	
	
}