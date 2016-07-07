package com.jwd.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CatsApp extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		SpringApplication.run(CatsApp.class, args);
	}

	@RequestMapping("/")
	String home()
	{
		return	"home";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return	builder.sources(CatsApp.class);
	}
	
	

}
