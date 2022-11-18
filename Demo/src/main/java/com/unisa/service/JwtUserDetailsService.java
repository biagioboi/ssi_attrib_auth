package com.unisa.service;

import java.util.ArrayList;
import java.util.Collection;

import com.unisa.issue.Credential;
import com.unisa.issue.CredentialList;
import com.unisa.model.Ruolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service

public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Credential credential = restTemplate.getForEntity("http://localhost:11001/credentials", CredentialList.class)
				.getBody()
				.getResults()
				.get(0);
		String prova =  bcryptEncoder.encode(credential.getAttrs().getPassword());
		String p = bcryptEncoder.encode(credential.getAttrs().getPassword());
//		String p = credential.getAttrs().getPassword();
		//$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi
		if (credential.getAttrs().getUsername().equals(username)) {
			Collection<Ruolo> ruoli = new ArrayList<>();
			Ruolo r = new Ruolo(credential.getAttrs().getRuolo());
			ruoli.add(r);
			return new User(username, p, ruoli);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}