package ua.com.travel.dto;

public class SleepingBagDto {

	private String brand;
	private double weight;
	private double height;
	private double price;
	
	public SleepingBagDto() {
	}

	public SleepingBagDto(String brand, double weight, double height, double price) {
		super();
		this.brand = brand;
		this.weight = weight;
		this.height = height;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
