package com.mani;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TEST {
	protected static String SQL_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

	public static void main(String[] args) {
			long e = new Long(1603903502);
			Date date = new Date(e*1000);
			SimpleDateFormat formatter = null;
			formatter = new SimpleDateFormat(SQL_DATE_FORMAT);
				System.out.print(formatter.format(date));
			
	}

}
