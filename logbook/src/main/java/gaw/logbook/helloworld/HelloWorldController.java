package gaw.logbook.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world-1")
	public String helloWorld1() {
		return "Hello World 1";
	}
	
	@GetMapping(path="/hello-world-2")
	public String helloWorld2() {
		return "Hello World 2";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String hellowWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}

