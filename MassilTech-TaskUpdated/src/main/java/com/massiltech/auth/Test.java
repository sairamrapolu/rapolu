package com.massiltech.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ParseException {

		String dates = "i am sairam rapolu 2020-09-03 and rapolu 26-08-1989";
		String[] up = dates.split(" ");
		String[] yr = null;
		List<String> iii = new ArrayList<String>();
		for (String ii : up) {
			// ii.toCharArray();
			if (ii.charAt(0) == '0' || ii.charAt(0) == '1' || ii.charAt(0) == '2' || ii.charAt(0) == '3') {
				yr = ii.split("-");
				iii.add(ii);
			}
			System.out.println(ii);
		}

		for (String out : iii) {

			Date date = new Date();
			String str = "26-08-1989";
			Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse(out);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date11);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date11);

			if (cal.get(Calendar.YEAR) == cal1.get(Calendar.YEAR)) {
				System.out.println(cal.get(Calendar.YEAR)+"Years are equal");
			} else {
				System.out.println("Years not equal");
			}

			System.out.println(out);
		}
	}
}
