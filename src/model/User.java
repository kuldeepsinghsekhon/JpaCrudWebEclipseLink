package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIV_DATE")
	private Date activDate;

	private BigDecimal activation;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_LOGIN")
	private Date lastLogin;

	private String name;

	private String password;

	@Column(name="\"ROLE\"")
	private String role;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getActivDate() {
		return this.activDate;
	}

	public void setActivDate(Date activDate) {
		this.activDate = activDate;
	}

	public BigDecimal getActivation() {
		return this.activation;
	}

	public void setActivation(BigDecimal activation) {
		this.activation = activation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}