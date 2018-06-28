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
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameLacality;
	private double scale;
	private double price;

	@ManyToMany
	@JoinTable(name = "user_map", joinColumns = @JoinColumn(name = "map_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "provider_map", joinColumns = @JoinColumn(name = "map_id"), 
	inverseJoinColumns = @JoinColumn(name = "provider_id"))
	private List<Provider> providers;

	public Map() {
	}

	public Map(String nameLacality, double scale, double price) {
		super();
		this.nameLacality = nameLacality;
		this.scale = scale;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
