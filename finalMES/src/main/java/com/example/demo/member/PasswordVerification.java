package com.example.demo.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordVerification {
		public boolean verifyUserPassword(String inputPassword, String storedPasswordHash) {
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder.matches(inputPassword, storedPasswordHash);
    }
		
}
