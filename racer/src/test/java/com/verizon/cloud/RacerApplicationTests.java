package com.verizon.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.verizon.cloud.races.RacerApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RacerApplication.class)
@WebAppConfiguration
public class RacerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
