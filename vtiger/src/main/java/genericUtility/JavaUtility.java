package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {

	Date dateObj;
	SimpleDateFormat sim;
	@Test
	public int randomNumb()
	{
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
	public String startDate()
	{
		 dateObj = new Date();
		 sim = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateObj);
		return actDate;
		
	}
	
	public String endDate()
	{
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateReq = sim.format(cal.getTime());
		return dateReq;
	}
}
