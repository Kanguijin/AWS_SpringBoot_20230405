package com.web.study.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

// 인증이 완료된 유저의 정보들을 담고 있다.
@Builder
@Getter
public class PrincipalUserDetails implements UserDetails {

	private static final long serialVersionUID = -1913596722176708482L;
	
	private int userId;
	private String username;
	private String password;
	private List<String> roles;
	
	// 인증된 권한들을 보내주는 역할을 함.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(role -> {
			// SimpleGrantedAuthority에 사용자에게 부여된 권한을 넣어줌.
			authorities.add(new SimpleGrantedAuthority(role));
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
	
		return username;
	}
	// 사용기간 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	// 계정을 잠궈버림
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	// 비밀번호 5회 틀렸을 때
	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}
	// 계정 비활성 상태(이메일 인증을 완료해야하거나, 전화번호 인증을 하지 않았을 때)
	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
