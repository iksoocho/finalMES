package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PassWordEncodeTest {
	
	@Test
	public void 암호화() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode("4444");
		System.out.println(result);
		assertTrue(encoder.matches("4444", result));
	}
}
