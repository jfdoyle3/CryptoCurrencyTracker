package com.cryptocurrency.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	private static Random rand = new Random();
	private static List<String> encodedList = new ArrayList<>();

	public static String encodePassword(String password) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		for (int idx = 1; idx < 10; idx++) {
			String encodedString = encoder.encode(password);
			encodedList.add(encodedString);
		}
		String encryptedPassword = encodedList.get(rand.nextInt(11));
		System.out.format("returning: %s", encryptedPassword.length());
		encodedList.clear();
		return encryptedPassword;

	}
}
