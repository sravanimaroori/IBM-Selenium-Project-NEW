package com.training.bean;

public class LoginBean {
	private String userName;
	private String password;
	private String prdct_name;
	private String meta;
	private String model;
	private String price;
	private String quantity;
	private String category;
	public LoginBean() {
	}

	public LoginBean(String userName, String password, String prdct_name, String meta, String model, String price, String quantity, String category) {
		super();
		this.userName = userName;
		this.password = password;
		this.prdct_name = prdct_name;
		this.meta = meta;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getprdct_name() {
		return prdct_name;
	}

	public void setprdct_name(String prdct_name) {
		this.prdct_name = prdct_name;
	}
	
	public String getmeta() {
		return meta;
	}

	public void setmeta(String meta) {
		this.meta = meta;
	}
	
	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + ", prdct_name=" + prdct_name + ", meta=" + meta + ", model=" + model + ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}
}
