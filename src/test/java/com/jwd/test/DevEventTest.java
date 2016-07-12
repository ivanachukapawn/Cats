package com.jwd.test;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jwd.net.CatsApp;
import com.jwd.net.model.DevEventUpdate;
import com.jwd.net.model.DevEventUpdateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CatsApp.class)
@WebAppConfiguration
@Transactional
public class DevEventTest
{
	@Autowired
	private DevEventUpdateDao devEventUpdateDao;

	@Test
	public void testSave()
	{
		DevEventUpdate devEventUpdate = new DevEventUpdate("test update text");

		devEventUpdateDao.save(devEventUpdate);

		Assert.assertNotNull("non-null Id", devEventUpdate.getId());
		Assert.assertNotNull("non-null Date", devEventUpdate.getAdded());

		DevEventUpdate retrieved = devEventUpdateDao.findOne(devEventUpdate.getId());

		Assert.assertEquals("matching devEventUpdates", devEventUpdate, retrieved);
	}

	@Test
	public void testFindLatest()
	{
		DevEventUpdate	lastEventUpdate	=	null;
		
		Calendar	calendar	=	Calendar.getInstance();
		for (int i = 0; i < 10; i++)
		{
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			DevEventUpdate	devEventUpdate	=	new	DevEventUpdate("event update # " + i, calendar.getTime());

			devEventUpdateDao.save(devEventUpdate);
			
			lastEventUpdate	=	devEventUpdate;
			
			
		}
		
		DevEventUpdate	eventRetrieved	=	devEventUpdateDao.findFirstByOrderByAddedDesc();
		
		Assert.assertEquals("latest event ", lastEventUpdate, eventRetrieved);
		
		System.out.println("retrieved event = " + eventRetrieved);
		System.out.println("last event saved = " + lastEventUpdate);
		

	}

}
