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
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	
	public Provider() {
	}

	public Provider(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	@ManyToMany
	@JoinTable(name="provider_backpack",
	joinColumns=@JoinColumn(name="provider_id"),
	inverseJoinColumns=@JoinColumn(name="backpack_id"))
	private List<Backpack> backpacks;
	
	
	@ManyToMany
	@JoinTable(name="provider_map",
	joinColumns=@JoinColumn(name="provider_id"),
	inverseJoinColumns=@JoinColumn(name="map_id"))
	private List<Map> maps;
	
	
	@ManyToMany
	@JoinTable(name="provider_sleepingBag",
	joinColumns=@JoinColumn(name="provider_id"),
	inverseJoinColumns=@JoinColumn(name="sleepingBag_id"))
	private List<SleepingBag> sleepingBags;
	
	@ManyToMany
	@JoinTable(name="provider_tent",
	joinColumns=@JoinColumn(name="provider_id"),
	inverseJoinColumns=@JoinColumn(name="tent_id"))
	private List<Tent> tents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Backpack> getBackpacks() {
		return backpacks;
	}

	public void setBackpacks(List<Backpack> backpacks) {
		this.backpacks = backpacks;
	}

	public List<Map> getMaps() {
		return maps;
	}

	public void setMaps(List<Map> maps) {
		this.maps = maps;
	}

	public List<SleepingBag> getSleepingBags() {
		return sleepingBags;
	}

	public void setSleepingBags(List<SleepingBag> sleepingBags) {
		this.sleepingBags = sleepingBags;
	}

	public List<Tent> getTents() {
		return tents;
	}

	public void setTents(List<Tent> tents) {
		this.tents = tents;
	}
	
	
}
