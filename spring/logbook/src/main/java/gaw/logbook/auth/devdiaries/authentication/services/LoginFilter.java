package gaw.logbook.auth.devdiaries.authentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import gaw.logbook.auth.devdiaries.authentication.domain.UserCredentials;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
	public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		System.out.println("=== LoginFilter");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException {
		UserCredentials userCredentials = new ObjectMapper().readValue(req.getInputStream(), UserCredentials.class);
		System.out.println("=== LoginFilter.attemptAuthentication : "+userCredentials.getUserid()+" | "+userCredentials.getPassword());

//		return getAuthenticationManager().authenticate(authentication)
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUserid(), userCredentials.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) {
		System.out.println("=== LoginFilter.successfulAuthentication");
		AuthenticationService.addJWTToken(res, auth.getName());
	}
}
