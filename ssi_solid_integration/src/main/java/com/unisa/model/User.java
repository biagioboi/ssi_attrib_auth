package com.unisa.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class User implements UserDetails {
	private String username ;
	private String password;
	private Set<Ruolo> roles = new HashSet<>();


	public User(String username, String password, Set<Ruolo> ruoli) {
		this.username = username;
		this.password = password;
		this.roles = ruoli;
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
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

	public Set<Ruolo> getRoles() {
		return roles;
	}

	public void setRoles(Set<Ruolo> roles) {
		this.roles = roles;
	}

	public void addRole(Ruolo role) {
		this.roles.add(role);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Ruolo role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return authorities;
	}

}