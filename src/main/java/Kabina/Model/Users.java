package Kabina.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@GeneratedValue(generator = "userId", strategy = GenerationType.IDENTITY)
	private String userId;
	
	@NotBlank
	@Column(name = "userName")
	private String userName;

	@NotBlank
	@Column(name = "userShortName")
	private String userShortName;
	

	public Users() {

	}

	public Users(String userName, String userShortName) {
		this.userName = userName;
		this.userShortName = userShortName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserShortName() {
		return userShortName;
	}

	public void setUserShortName(String userShortName) {
		this.userShortName = userShortName;
	}
	
	


}
