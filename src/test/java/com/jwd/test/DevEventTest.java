package com.jwd.test;

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
	private	DevEventUpdateDao	devEventUpdateDao;
	
	@Test
	public	void testSave()
	{
		DevEventUpdate	devEventUpdate	=	new	DevEventUpdate("test update text");
		
		devEventUpdateDao.save(devEventUpdate);
		
		Assert.assertNotNull("non-null Id", devEventUpdate.getId());
		Assert.assertNotNull("non-null Date", devEventUpdate.getAdded());
		
		DevEventUpdate	retrieved	=	devEventUpdateDao.findOne(devEventUpdate.getId());
		
		Assert.assertEquals("matching devEventUpdates", devEventUpdate,retrieved);
	}

}
