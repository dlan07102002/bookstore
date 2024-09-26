package model;

public class OrderDetail {
	private String orderDetailId;
	private Order order;
	private Product product;
	private double quantity;
	private double orgPrice;
	private double salePercent;
	private double vat;
	private double amount;

	public OrderDetail(String orderDetailId, Order order, Product product, double quantity, double orgPrice,
			double salePercent, double vat, double amount) {

		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.orgPrice = orgPrice;
		this.salePercent = salePercent;
		this.vat = vat;
		this.amount = amount;
	}

	public OrderDetail() {

	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getOrgPrice() {
		return orgPrice;
	}

	public void setOrgPrice(double orgPrice) {
		this.orgPrice = orgPrice;
	}

	public double getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(double salePercent) {
		this.salePercent = salePercent;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
