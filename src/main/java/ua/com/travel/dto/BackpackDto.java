package ua.com.travel.dto;

public class BackpackDto {

	private String brand;
	private double volume;
	private double weight;
	private double price;
	
	public BackpackDto() {
	}

	public BackpackDto(String brand, double volume, double weight, double price) {
		super();
		this.brand = brand;
		this.volume = volume;
		this.weight = weight;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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
