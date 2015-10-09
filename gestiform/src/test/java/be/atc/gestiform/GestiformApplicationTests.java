package be.atc.gestiform;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import be.atc.gestiform.util.WeekendQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GestiformApplication.class)
@WebAppConfiguration
public class GestiformApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void check_if_date_is_weekend () {
	    LocalDate date = LocalDate.of(2015, 01, 03); // samedi
	    
	    Boolean workDay = date.query(new WeekendQuery());

	    assertTrue(workDay);
	}

}
