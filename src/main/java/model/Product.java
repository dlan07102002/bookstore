package model;

public class Product {
	private String productId;
	private String productName;
	private Author author;
	private int namXuatBan;
	private double impPrice;
	private double sellPrice;
	private double orgPrice;
	private int quantity;
	private Category category;
	private String language;
	private String description;

	public Product() {
	}

	public Product(String productId, String productName, Author author, int namXuatBan, double impPrice,
			double sellPrice, double orgPrice, int quantity, Category category, String language, String description) {

		this.productId = productId;
		this.productName = productName;
		this.author = author;
		this.namXuatBan = namXuatBan;
		this.impPrice = impPrice;
		this.sellPrice = sellPrice;
		this.orgPrice = orgPrice;
		this.quantity = quantity;
		this.category = category;
		this.language = language;
		this.description = description;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getImpPrice() {
		return impPrice;
	}

	public void setImpPrice(double impPrice) {
		this.impPrice = impPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getOrgPrice() {
		return orgPrice;
	}

	public void setOrgPrice(double orgPrice) {
		this.orgPrice = orgPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
