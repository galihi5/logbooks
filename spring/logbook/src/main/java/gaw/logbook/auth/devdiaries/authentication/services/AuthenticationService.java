package gaw.logbook.auth.devdiaries.authentication.services;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
//import java.util.Enumeration;

import static java.util.Collections.emptyList;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 60_000;// 3600_000; //ms
	static final String SIGNINGKEY = "signingKey";
	static final String BEARER_PREFIX = "Bearer";

	static public void addJWTToken(HttpServletResponse response, String userid) {
		String jwtToken = Jwts.builder().setSubject(userid)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
		System.out.println("=== AuthenticationService.addJWTToken " + userid + " : " + jwtToken);
		response.addHeader("Authorization", BEARER_PREFIX + " " + jwtToken);
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
	}

	static public Authentication getAuthentication(HttpServletRequest request) {
		System.out.println("=== AuthenticationService.getAuthentication ");
		String token = request.getHeader("Authorization");
		
//		Enumeration<String> enume = request.getHeaderNames();
//		String header;
//		while (enume.hasMoreElements()) {
//			header = enume.nextElement();
//			System.out.println("+++ "+header);
//		}
		
		if (token != null) {
			String user = null;
			try {
				user = Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(BEARER_PREFIX, ""))
						.getBody().getSubject();
			} catch (ExpiredJwtException eje) {
				System.out.println(eje.getMessage());
			}

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
			} else {
//				throw new RuntimeException("Authentication failed");
				System.out.println("Authentication failed");
			}
		} else {
			System.out.println("token is null");
		}
		return null;
	}
}
