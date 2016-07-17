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
public class DevEventController
{
	@Autowired
	private DevEventUpdateService devEventUpdateService;

	@RequestMapping(value = "/editevent", method = RequestMethod.GET)
	ModelAndView editEvent(ModelAndView modelAndView, @RequestParam(value = "id") Integer id)
	{
		DevEventUpdate devEventUpdate = devEventUpdateService.get(id);

		modelAndView.getModel().put("devEventUpdate", devEventUpdate);

		modelAndView.setViewName("app.editEvent");

		return modelAndView;
	}

	@RequestMapping(value = "/editevent", method = RequestMethod.POST)
	ModelAndView editEvent(ModelAndView modelAndView, @Valid DevEventUpdate devEventUpdate, BindingResult result)
	{
		modelAndView.setViewName("app.editEvent");

		if (!result.hasErrors())
		{
			devEventUpdateService.save(devEventUpdate);
			modelAndView.setViewName("redirect:/viewDevEvents");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/deleteevent")
	ModelAndView deleteEvent(ModelAndView modelAndView, @RequestParam(name = "id") Integer id)
	{
		devEventUpdateService.delete(id);

		modelAndView.setViewName("redirect:/viewDevEvents");

		return modelAndView;
	}

	@RequestMapping(value = "/addnews", method = RequestMethod.GET)
	ModelAndView addNews(ModelAndView modelAndView, @ModelAttribute("devEventUpdate") DevEventUpdate devEventUpdate)
	{
		modelAndView.setViewName("app.addNews");

		DevEventUpdate latestDevEvent = devEventUpdateService.getLatestDevEvent();

		Date latestAdded = latestDevEvent.getAdded();
		String latestText = latestDevEvent.getText();

		modelAndView.getModel().put("latestAdded", latestAdded);
		modelAndView.getModel().put("latestText", latestText);

		modelAndView.getModel().put("latestDevEvent", latestDevEvent);

		return modelAndView;
	}

	@RequestMapping(value = "/addnews", method = RequestMethod.POST)
	ModelAndView addNews(ModelAndView modelAndView, @Valid DevEventUpdate devEventUpdate, BindingResult result)
	{
		modelAndView.setViewName("app.addNews");

		if (!result.hasErrors())
		{
			devEventUpdateService.save(devEventUpdate);
			modelAndView.getModel().put("devEventUpdate", new DevEventUpdate());
			modelAndView.setViewName("redirect:/viewDevEvents");
		}

		DevEventUpdate latestDevEvent = devEventUpdateService.getLatestDevEvent();

		Date latestAdded = latestDevEvent.getAdded();
		String latestText = latestDevEvent.getText();

		modelAndView.getModel().put("latestAdded", latestAdded);
		modelAndView.getModel().put("latestText", latestText);

		modelAndView.getModel().put("latestDevEvent", latestDevEvent);

		return modelAndView;
	}

	@RequestMapping(value = "/viewDevEvents", method = RequestMethod.GET)
	ModelAndView viewDevEvents(ModelAndView modelAndView, @RequestParam(name = "p", defaultValue = "1") int pageNumber)
	{

		Page<DevEventUpdate> page = devEventUpdateService.getPage(pageNumber);

		modelAndView.getModel().put("page", page);

		modelAndView.setViewName("app.viewDevEvents");

		return modelAndView;
	}
}
