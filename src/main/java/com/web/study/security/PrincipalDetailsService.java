package com.web.study.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.study.domain.entity.User;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// 사용자정보와 DB의 정보가 맞는지 비교하기 위한 것
// UserDetailsService 불러오면 PrincipalDetailsService를 실행시켜 줌.
// service 어노테이션을 사용해서 IoC로 넘어가기 때문에
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	// authenticate가 실행되면서 받아온 username 값이 매개변수로 들어가게 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
		
		if(userEntity == null) {
			throw new CustomException("사용자 정보를 다시 확인해주세요.");
		}
		
		return userEntity.toPrincipal();
	}
	
}
