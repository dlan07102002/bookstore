package model;

import java.sql.Date;

public class Customer {
	private String customerId;
	private String username;
	private String password;
	private String name;
	private boolean sex;
	private String address;
	private String ordAddress;
	private String shipTo;
	private Date birthDate;
	private String phoneNumber;
	private String email;
	private boolean isUseMsgService;
	private String imgPath;

	public Customer() {

	}
	
	public Customer(String customerId) {
		this.customerId = customerId;
	}
	

	public Customer(String customerId, String username, String password, String name, boolean sex, String address,
			String ordAddress, String shipTo, Date birthDate, String phoneNumber, String email, boolean isUseMsgService,
			String imgPath) {
	
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.ordAddress = ordAddress;
		this.shipTo = shipTo;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isUseMsgService = isUseMsgService;
		this.imgPath = imgPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Customer(String customerId, String username, String password, String name, boolean sex, String address,
			String ordAddress, String shipTo, Date birthDate, String phoneNumber, String email,
			boolean isUseMsgService) {

		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.ordAddress = ordAddress;
		this.shipTo = shipTo;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isUseMsgService = isUseMsgService;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrdAddress() {
		return ordAddress;
	}

	public void setOrdAddress(String ordAddress) {
		this.ordAddress = ordAddress;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUseMsgService() {
		return isUseMsgService;
	}

	public void setUseMsgService(boolean isUseMsgService) {
		this.isUseMsgService = isUseMsgService;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", name="
				+ name + ", sex=" + sex + ", address=" + address + ", ordAddress=" + ordAddress + ", shipTo=" + shipTo
				+ ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", isUseMsgService=" + isUseMsgService + "]";
	}

}
