package com.cryptocurrency.backend;


public class BCryptEncoderTest {

	public static void main(String[] args) {

		
	String encode=PasswordEncoder.encodePassword("zyxwvu1!!&&%%");
	System.out.format("\nencoded: %s",encode);	
}

}
