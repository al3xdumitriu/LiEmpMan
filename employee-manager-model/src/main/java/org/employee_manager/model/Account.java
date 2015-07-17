package org.employee_manager.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

	@Id
	@Column(name="ACCOUNT_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_ACCOUNT")
	@SequenceGenerator(name = "SEQ_GEN_ACCOUNT", sequenceName = "account_id_sequence", allocationSize = 10)
	private long id;

	@OneToMany(mappedBy="accountId")
    private Set<Role> roles;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
}
