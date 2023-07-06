package com.faith.app.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.faith.app.common.AccessDeniedException;
import com.faith.app.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Jwt {
	// secret key
	private static String secret = "daad0e27-8038-4732-b807-9e9a0aeb7520";

	// expiration time

	private static long expiryDuration = 60 * 60;

	// generate token:header.payload.signature

	public String generateJwt(User user) {
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		// set issuedTime and ExpiryTime

		Date issuedAt = new Date(milliTime);
		Date expiredAt = new Date(expiryTime);

		// claims
		Claims claim = Jwts.claims().setIssuer(user.getUserId().toString()).setIssuedAt(issuedAt)
				.setExpiration(expiredAt);
		// generate jwt using claims

		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS256, secret).compact();

	}

//checking token valid or access denied
	public Claims verify(String authorization) {
		try {
			Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			return claim;
		} catch (Exception e) {
			throw new AccessDeniedException("Sorry!Access denied!!");
		}
	}

	public int verifyTokenAndGetUserId(String authorization) {
		try {
			Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			int userId = Integer.valueOf(claim.getIssuer());
			return userId;
		} catch (Exception e) {
			throw new AccessDeniedException("Sorry!Access denied!!");
		}
	}
}
