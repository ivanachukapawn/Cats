package com.jwd.net.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jwd.net.model.DevEventUpdate;

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
	ModelAndView addNews(ModelAndView modelAndView)
	{
		modelAndView.setViewName("app.addNews");
		
		DevEventUpdate	devEventUpdate	=	new	DevEventUpdate();
		
		modelAndView.getModel().put("devEventUpdate", devEventUpdate);
		
		return	modelAndView;
	}
}
