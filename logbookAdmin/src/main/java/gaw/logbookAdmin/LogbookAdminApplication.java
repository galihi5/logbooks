package gaw.logbookAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class LogbookAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogbookAdminApplication.class, args);
	}
}
