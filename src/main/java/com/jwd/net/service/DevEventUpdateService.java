package com.jwd.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.model.DevEventUpdateDao;

@Service
public class DevEventUpdateService
{
	private	final	static	int	PAGESIZE	=	6;
	
	@Autowired
	private DevEventUpdateDao devEventUpdateDao;

	public void save(DevEventUpdate devEventUpdate)
	{
		devEventUpdateDao.save(devEventUpdate);
	}

	public DevEventUpdate getLatestDevEvent()
	{
		return devEventUpdateDao.findFirstByOrderByAddedDesc();
	}

	public Page<DevEventUpdate> getPage(int pageNumber)
	{
		PageRequest	request	=	new	PageRequest (pageNumber - 1, PAGESIZE, Sort.Direction.DESC, "added");
		
		return	devEventUpdateDao.findAll(request);

	}
}
