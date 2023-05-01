package user;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Unique;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private long id;
	
	private String username;
	
	private String password;
	
	private String direccion;
	
	private Integer telephone;
	
	private String email;

	@Unique
	private Long token;

	public User(String username, String password, String direccion, Integer telephone, String email, Long token) {
		this.username = username;
		this.password = password;
		this.direccion = direccion;
		this.telephone = telephone;
		this.email = email;
		this.token = token;
	}

	public User() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

}