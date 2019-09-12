package Kabina.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "user_shelf")
public class User_Shelf extends AuditModel {
	
	private static final long serialVersionUID = 3523072751737158553L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToOne
    @MapsId
    private User user;
    
    @OneToOne
    @MapsId
    private Shelf shelf;
	
	@ColumnDefault("false")
	private boolean actived;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
//
//	public Shelf getShelf() {
//		return shelf;
//	}
//
//	public void setShelf(Shelf shelf) {
//		this.shelf = shelf;
//	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}


	
}
