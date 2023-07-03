package com.web.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.IocAndDi.IocTest;
import com.web.study.IocAndDi.IocTest2;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IoCTestController {
	
	private final IocTest iocTest;
	private final IocTest2 iocTest2;
	
	@GetMapping("/ioc/test")
	public Object test() {
		iocTest.run();
		iocTest2.run();
		return null;
	}
}
