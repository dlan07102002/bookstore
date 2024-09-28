package model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}

	private String orderId;
	private Customer customer;
	private String ordAddress;
	private String shipTo;
	private String status;
	private String formOfPayment;
	private String statusOfPayment;
	private double purchased;
	private double remainingAmount;
	private Date ordDate;
	private Date shipDate;

	public Order() {
	}
	
	public Order(String orderId) {
		this.orderId = orderId;
	}

	public Order(String orderId, Customer customer, String ordAddress, String shipTo, String status,
			String formOfPayment, String statusOfPayment, double purchased, double remainingAmount, Date ordDate,
			Date shipDate) {
		this.orderId = orderId;
		this.customer = customer;
		this.ordAddress = ordAddress;
		this.shipTo = shipTo;
		this.status = status;
		this.formOfPayment = formOfPayment;
		this.statusOfPayment = statusOfPayment;
		this.purchased = purchased;
		this.remainingAmount = remainingAmount;
		this.ordDate = ordDate;
		this.shipDate = shipDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public String getStatusOfPayment() {
		return statusOfPayment;
	}

	public void setStatusOfPayment(String statusOfPayment) {
		this.statusOfPayment = statusOfPayment;
	}

	public double getPurchased() {
		return purchased;
	}

	public void setPurchased(double purchased) {
		this.purchased = purchased;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", ordAddress=" + ordAddress + ", shipTo="
				+ shipTo + ", status=" + status + ", formOfPayment=" + formOfPayment + ", statusOfPayment="
				+ statusOfPayment + ", purchased=" + purchased + ", remainingAmount=" + remainingAmount + ", ordDate="
				+ ordDate + ", shipDate=" + shipDate + "]";
	}
	
	

}
