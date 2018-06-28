package ua.com.travel.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class SleepingBag {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brand;
	private double weight;
	private double height;
	private double price;
	private String imgBag;
	
	
		
	public String getImgBag() {
		return imgBag;
	}
	public void setImgBag(String imgBag) {
		this.imgBag = imgBag;
	}

	public SleepingBag() {
	}

	public SleepingBag(String brand, double weight, double height, double price) {
		super();
		this.brand = brand;
		this.weight = weight;
		this.height = height;
		this.price = price;
	}
	
	@ManyToMany
	@JoinTable(name="user_sleepingBag",
	joinColumns=@JoinColumn(name="sleepingBag_id"),
	inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name="provider_sleepingBag",
	joinColumns=@JoinColumn(name="sleepingBag_id"),
	inverseJoinColumns=@JoinColumn(name="provider_id"))
	private List<Provider> providers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
	
	
	
}
