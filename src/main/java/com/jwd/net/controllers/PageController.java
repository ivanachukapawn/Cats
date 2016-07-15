package com.jwd.net.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.service.DevEventUpdateService;

@Controller
public class PageController
{
	

	@RequestMapping("/")
	String home()
	{
		return "app.homepage";
	}

	@RequestMapping("/about")
	String about()
	{
		return "app.about";
	}

	
}
