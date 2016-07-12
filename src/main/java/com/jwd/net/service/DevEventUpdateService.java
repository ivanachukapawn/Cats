package com.jwd.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.model.DevEventUpdateDao;

@Service
public class DevEventUpdateService
{
	@Autowired
	private DevEventUpdateDao devEventUpdateDao;

	public void save(DevEventUpdate devEventUpdate)
	{
		devEventUpdateDao.save(devEventUpdate);
	}

	public DevEventUpdate getLatestDevEvent()
	{
		return	devEventUpdateDao.findFirstByOrderByAddedDesc();
	}
}
