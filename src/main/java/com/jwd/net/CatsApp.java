package com.jwd.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class CatsApp
{

	public static void main(String[] args)
	{
		SpringApplication.run(CatsApp.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home()
	{
		return	"hello you sassy ragamuffin";
	}

}
