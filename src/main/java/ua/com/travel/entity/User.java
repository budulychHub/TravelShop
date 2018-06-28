package ua.com.travel.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ua.com.travel.entity.Role;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;

	private String pathImage;
	private boolean enabled;
	private String UUID;

	@Enumerated
	private Role role;

	public User() {
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name = "user_backpack", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "backpack_id"))
	private List<Backpack> backpacks;

	@ManyToMany
	@JoinTable(name = "user_map", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "map_id"))
	private List<Map> maps;

	@ManyToMany
	@JoinTable(name = "user_sleepingBag", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "sleepingBag_id"))
	private List<SleepingBag> sleepingBags;

	@ManyToMany
	@JoinTable(name = "user_tent", joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "tent_id"))
	private List<Tent> tents;

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

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return null;
	}

	public String getUsername() {
		return String.valueOf(id);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}

}
