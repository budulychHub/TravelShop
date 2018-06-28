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
public class Backpack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private double volume;
	private double weight;
	private double price;

	@ManyToMany
	@JoinTable(name = "user_backpack", joinColumns = @JoinColumn(name = "backpack_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "provider_backpack", joinColumns = @JoinColumn(name = "backpack_id"),
	inverseJoinColumns = @JoinColumn(name = "provider_id"))
	private List<Provider> providers;

	public Backpack() {
	}

	public Backpack(String brand, double volume, double weight, double price) {
		super();
		this.brand = brand;
		this.volume = volume;
		this.weight = weight;
		this.price = price;
	}

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
