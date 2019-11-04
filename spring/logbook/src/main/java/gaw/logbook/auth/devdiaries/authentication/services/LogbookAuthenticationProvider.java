package gaw.logbook.auth.devdiaries.authentication.services;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import gaw.logbook.auth.devdiaries.authentication.domain.UserDaoService;
import gaw.logbook.auth.devdiaries.authentication.domain.User;

@Component
public class LogbookAuthenticationProvider implements AuthenticationProvider {
	private UserDaoService service=new UserDaoService();
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userid = authentication.getName();
		String password = authentication.getCredentials().toString();

//        if (shouldAuthenticateAgainstThirdPartySystem()) {

		// use the credentials
		// and authenticate against the third-party system
		System.out.println("====== LogbookAuthenticationProvider");
		User user=service.getUserRoles(userid);
		
		if (user==null) {
			System.out.println(userid+"/"+password+" : Invalid user/password");
			return null;
		}else {
			System.out.println("--------------------------------------");
			System.out.println("| userid 	: "+user.getUserid());
			System.out.println("| username 	: "+user.getUsername());
			System.out.println("| password	: "+user.getPassword());
			System.out.println("| cabang	: "+user.getKodeCabang());
			System.out.println("| roles		: "+user.getRoles());
			System.out.println("--------------------------------------");
		}
		return new UsernamePasswordAuthenticationToken(userid, password, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
