package com.jwd.net.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.service.DevEventUpdateService;

@Controller
public class PageController
{
	@Autowired
	private DevEventUpdateService devEventUpdateService;
	

	@RequestMapping("/")
	ModelAndView home(ModelAndView modelAndView)
	{
		DevEventUpdate	devEventUpdate	=	devEventUpdateService.getLatestDevEvent();
		
		modelAndView.getModel().put("devEventUpdate", devEventUpdate);
		
		modelAndView.setViewName("app.homepage");
		
		return modelAndView;
	}

	@RequestMapping("/about")
	String about()
	{
		return "app.about";
	}

	
}
