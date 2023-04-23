package jp.co.axa.apidemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void TestBCryptPasswordEncoder(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("1234");
		System.out.println(encode);

	}


}
