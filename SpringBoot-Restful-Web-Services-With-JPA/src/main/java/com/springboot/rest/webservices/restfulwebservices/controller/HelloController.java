package com.springboot.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservices.restfulwebservices.hellobean.HelloBean;

//Controller
@RestController
public class HelloController {

	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello")
	public String hello() {
		return "Hello Welcome to Spring Boot using GetMapping!!!";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloBean helloBean() {
		return new HelloBean("HelloBean class");
	}
	
	@GetMapping(path="/hello-bean/path-variable/{name}")
	public HelloBean helloBeanPathVariable(@PathVariable String name) {
		return new HelloBean(String.format("HelloBean class, %s",name));
	}
	
	/*@GetMapping("/hello-internationalization")
	public String helloInternationalization(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null,locale);
	}*/
	@GetMapping("/hello-internationalization")
	public String helloInternationalization() {
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
}
