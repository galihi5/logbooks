package gaw.logbook;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class LogbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogbookApplication.class, args);
	}

	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
//	@Configuration
//	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter{
//		@Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests().anyRequest().permitAll()  
//	            .and().csrf().disable();
//	    }
//	}
}