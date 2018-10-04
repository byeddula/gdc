/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.time.YearMonth;

/**
 *
 * @author yalam
 */
public class CompositeInfo {
    
        private Year years = null;
	
	public void addInfo(int y,int m,int d,int h) {
		if(years == null){
			years = new Year(y);
		}
		
		Month month = years.getMonth(m);
		if(month == null){
			YearMonth yearMonthObject = YearMonth.of(years.getYearNo(), m);
			int daysInMonth = yearMonthObject.lengthOfMonth(); 
			month = new Month(m,daysInMonth);
		}
		
		Day days = month.getDay(d);
		if(days == null){
			days = new Day(d);
		}
		
		days.addHours(h);
		month.addDays(d,days);
		years.addMonths(m, month);
	}
	
	public Year getYears(){
		return years;
	}
    
}
