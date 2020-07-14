package com.cryptocurrency.backend;

public class BCryptEncoderTest {

	public static void main(String[] args) {

		String encode = PasswordEncoder.encodePassword("p");
		System.out.format("encoded: %s", encode);
	}

}
