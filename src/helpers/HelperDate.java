package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class HelperDate {
	
	private String DateToStr;
	private Calendar StrToDate;

	public String getDateToStr(Calendar Data){
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
		DateToStr = fmt.format(Data.getTime());		
		return DateToStr;
	}
	
	public Calendar getStrToDate(String Data) throws ParseException{
		
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(Data);
		StrToDate = Calendar.getInstance();			
		StrToDate.setTime(date);
		return StrToDate;	
	}

}
