package by.htp.laboratories.ATTestingTask.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	
	private static String  formateDate (Date date) {
		String fd = new SimpleDateFormat("dd-mm-yyyy").format(date);
		return fd;
		
	}

	public static String  getNextSaturday() {
		Calendar calendar = Calendar.getInstance();
		while(calendar.get(Calendar.DAY_OF_WEEK) !=7) {
			calendar.add(Calendar.DAY_OF_MONTH,1);
		}
		
		return formateDate(calendar.getTime());
	}
	
	public static String getNextSunday() {
		String saturday=getNextSaturday();
		SimpleDateFormat format= new SimpleDateFormat("dd-mm-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(format.parse(saturday));
			calendar.add(Calendar.DATE, 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formateDate(calendar.getTime());
		
		
	}
}
