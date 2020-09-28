package com.massiltech.auth;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtilService {

	@Value("${app.secret}")
	private String secret;

	// 1.genarate token
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuer("MassiTech")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();

	}

	// 2
	public Claims getClaims(String token) {

		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

	// 3
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

	// 4
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	// 5

	public boolean isTokenExpired(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));

	}

//6
	public boolean validateToken(String token, String username) {
		String tokenUsername = getUsername(token);
		return (username.equals(tokenUsername) && !isTokenExpired(token));
	}

}
