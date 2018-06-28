package ua.com.travel.dto;

public class TentDto {

	private String brand;
	private int copacity;
	private double weight;
	private double price;
	
	public TentDto() {
	}

	public TentDto(String brand, int copacity, double weight, double price) {
		super();
		this.brand = brand;
		this.copacity = copacity;
		this.weight = weight;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCopacity() {
		return copacity;
	}

	public void setCopacity(int copacity) {
		this.copacity = copacity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
