package com.example.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	private static final String secret = "qwertyuiopasdfghjklzxcvbnmpoiuytrewqlkjhgfdsa1234567890ujntgv";
	
	private static final SecretKey KEY = Keys.hmacShaKeyFor(secret.getBytes());
	
	public static String generateToken(int id, String name) {
		return Jwts.builder()
				.claim("id", id)
				.claim("name", name)
				.setIssuedAt(new Date())
				.setExpiration(new Date( System.currentTimeMillis() + 1000*60*60))
				.signWith(KEY)
				.compact();
	}
	
	public static Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public static boolean validate(String token) {
		
		try {
			getClaims(token);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
