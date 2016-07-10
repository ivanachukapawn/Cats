package com.jwd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jwd.net.CatsApp;

import	static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CatsApp.class)
@WebAppConfiguration
public class DevEventTest
{
	@Test
	public	void testDummy ()
	{
		Long	value	=	7L;
		
		assertNotNull("should not be null", value);
	}

}
