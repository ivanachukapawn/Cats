package com.jwd.net.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.service.DevEventUpdateService;

@Controller
public class PageController
{
	@Autowired
	private	DevEventUpdateService	devEventUpdateService;
	
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
	
	@RequestMapping(value="/addnews",method=RequestMethod.GET)
	ModelAndView addNews(ModelAndView modelAndView,@ModelAttribute("devEventUpdate")DevEventUpdate devEventUpdate)
	{
		modelAndView.setViewName("app.addNews");
		
		DevEventUpdate	latestDevEvent	=	devEventUpdateService.getLatestDevEvent();
		
		Date	latestAdded	=	latestDevEvent.getAdded();
		String	latestText	=	latestDevEvent.getText();
		
		modelAndView.getModel().put("latestAdded", latestAdded);
		modelAndView.getModel().put("latestText", latestText);
		
		modelAndView.getModel().put("latestDevEvent", latestDevEvent);
		
		return	modelAndView;
	}
	
	@RequestMapping(value="/addnews",method=RequestMethod.POST)
	ModelAndView addNews(ModelAndView modelAndView,DevEventUpdate devEventUpdate,String temp)
	{
		modelAndView.setViewName("app.addNews");
		
		devEventUpdateService.save(devEventUpdate);
		
		DevEventUpdate	latestDevEvent	=	devEventUpdateService.getLatestDevEvent();
		
		Date	latestAdded	=	latestDevEvent.getAdded();
		String	latestText	=	latestDevEvent.getText();
		
		
		modelAndView.getModel().put("latestAdded", latestAdded);
		modelAndView.getModel().put("latestText", latestText);
		
		modelAndView.getModel().put("latestDevEvent", latestDevEvent);
		
		modelAndView.getModel().put("devEventUpdate", new DevEventUpdate());
		
		return	modelAndView;
	}
}
