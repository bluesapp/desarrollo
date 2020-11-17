/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

import java.util.List;

/**
 *
 * @author MarioF
 */
public class EAuthenticateLdap {
    
    	private String username;
	private String displayName;
	private String email;
	private String phone;
	private boolean blocked;
	private List<String> groups;
	private List<String> roles;	
	
	public EAuthenticateLdap() { }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "EAuthenticateLdap [username=" + username + ", displayName=" + displayName + ", email=" + email
				+ ", phone=" + phone + ", blocked=" + blocked + ", groups=" + groups + ", roles=" + roles + "]";
	}

}
