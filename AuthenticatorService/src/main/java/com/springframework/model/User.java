package com.springframework.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    private int custId;
    private String password;

    public User() {
    }

    public User(int custId, String password) {
        this.custId = custId;
        this.password = password;
    }

    public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
