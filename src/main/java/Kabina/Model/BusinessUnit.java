package Kabina.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "BusinessUnit")
public class BusinessUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(unique = true)
	private String name;
	
	@Column
	private String manager;
	
	@JsonBackReference
	@OneToMany(mappedBy = "businessUnit")
	 private List<Shelf> shelves;
	
	@JsonBackReference
	@OneToMany(mappedBy = "businessUnit")
	 private List<User> users;
	
	public BusinessUnit() {
		super();
	}
	
	public BusinessUnit(long id, @NotNull String name,String manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
	}
	
	public BusinessUnit(long id, @NotNull String name,String manager, List<Shelf> shelves, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.shelves = shelves;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	
}
