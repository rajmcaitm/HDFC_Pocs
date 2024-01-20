package com.hdfc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "User_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Transient
	private String captcha;
	
	@Transient
	private String hiddenCaptcha;
	
	@Transient
	private String realCaptcha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getHiddenCaptcha() {
		return hiddenCaptcha;
	}

	public void setHiddenCaptcha(String hiddenCaptcha) {
		this.hiddenCaptcha = hiddenCaptcha;
	}

	public String getRealCaptcha() {
		return realCaptcha;
	}

	public void setRealCaptcha(String realCaptcha) {
		this.realCaptcha = realCaptcha;
	}

	public User(Integer id, String name, String email, String captcha, String hiddenCaptcha, String realCaptcha) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.captcha = captcha;
		this.hiddenCaptcha = hiddenCaptcha;
		this.realCaptcha = realCaptcha;
	}
	
	public User() {
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", captcha=" + captcha + ", hiddenCaptcha="
				+ hiddenCaptcha + ", realCaptcha=" + realCaptcha + "]";
	}
	
	
}