package com.jwd.net.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessController
{
	@RequestMapping("/humans")
	String humans()
	{
		return	"humans";
	}

}
