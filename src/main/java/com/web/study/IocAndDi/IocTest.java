package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 의존성을 외부에서 주입하므로 내부에서 서로 의존할 필요가 없다 = DI
@Component
public class IocTest {
	
	@Qualifier("t1")
	@Autowired
	private Test test;
	
//	public IocTest(Test test) {
//		this.test = test;
//	}
	
	public void run() {
		test.printTest();
		System.out.println("IoCTest 출력!");
	}
}
