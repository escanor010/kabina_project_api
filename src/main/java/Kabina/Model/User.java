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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	@Column
	private String password;

	@Column
	private String fullName;

	@Column
	private String shortName;

	@Column
	private String email;

	@Column
	private String avatar;

	@Column
	private String phone;

	@Column
	private boolean status;
	
	@Column
	private String role;

//	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name = "businessUnitId")
	private BusinessUnit businessUnit;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL) //?
    private User_Shelf user_Shelf;

	public User() {
		super();
	}
	
	public User(long id, @NotNull String username, @NotNull String password, String fullName, String shortName,
			String email, String avatar, String phone, boolean status, String role, BusinessUnit businessUnit) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.shortName = shortName;
		this.email = email;
		this.avatar = avatar;
		this.phone = phone;
		this.status = status;
		this.role = role;
		this.businessUnit = businessUnit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}
}
