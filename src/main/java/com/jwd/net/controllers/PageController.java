package com.jwd.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
	@RequestMapping("/")
	String home()
	{
		return	"app.homepage";
	}
	
	@RequestMapping("/about")
	String about()
	{
		return	"app.about";
	}
	
	@RequestMapping("/addnews")
	String addNews()
	{
		return	"app.addNews";
	}
}
