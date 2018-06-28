package ua.com.travel.dto;

public class MapDto {

	private String nameLacality;
	private double scale;
	private double price;
	
	public MapDto() {
	}

	public MapDto(String nameLacality, double scale, double price) {
		super();
		this.nameLacality = nameLacality;
		this.scale = scale;
		this.price = price;
	}

	public String getNameLacality() {
		return nameLacality;
	}

	public void setNameLacality(String nameLacality) {
		this.nameLacality = nameLacality;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
