package Kabina.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Shelf", uniqueConstraints = @UniqueConstraint(columnNames = {"floor", "positionNumber"}))
public class Shelf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column
	private long floor;

	@NotNull
	@Column
	private String positionNumber;

	@NotNull
	@Column
	private String status;

	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name = "businessUnitId")
	private BusinessUnit businessUnit;

	@OneToOne(mappedBy = "shelf", cascade = CascadeType.ALL)
    private User_Shelf User_shelf;
	
	
	public Shelf() {
		super();
	}
	
	public Shelf(long id, @NotNull long floor, @NotNull String positionNumber, @NotNull String status,
			BusinessUnit businessUnit) {
		super();
		this.id = id;
		this.floor = floor;
		this.positionNumber = positionNumber;
		this.status = status;
		this.businessUnit = businessUnit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFloor() {
		return floor;
	}

	public void setFloor(long floor) {
		this.floor = floor;
	}

	public String getPositionNumber() {
		return positionNumber;
	}

	public void setPositionNumber(String positionNumber) {
		this.positionNumber = positionNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}

	public User_Shelf getUser_shelf() {
		return User_shelf;
	}

	public void setUser_shelf(User_Shelf user_shelf) {
		User_shelf = user_shelf;
	}
	
}
