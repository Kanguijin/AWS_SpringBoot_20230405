package com.web.study.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.web.study.security.PrincipalUserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int user_id;
	private String username;
	private String password;
	private String name;
	private String email;
	
	private List<Authority> authorities;
	
	public PrincipalUserDetails toPrincipal() {
		
		List<String> roles = new ArrayList<>();
		
		authorities.forEach(authority -> {
			roles.add(authority.getRole().getRole_name());
		});
		
		return PrincipalUserDetails.builder()
				.userId(user_id)
				.username(username)
				.password(password)
				.roles(roles)
				.build();
	}
}
