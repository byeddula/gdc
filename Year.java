/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yalam
 */
public class Year {
    
    
     Year(int whichYear){
		yearNo = whichYear;
     }
    
    private int yearNo = -1;
    private int totalMonthInYear = 12;
    private Map<Integer,Month> months = new HashMap<>();
	
	
	
	public void addMonths(Integer monthNo , Month months){
		if(this.months.size() != totalMonthInYear){
			this.months.put(monthNo,months);
		}
	}
	
	public Map<Integer,Month> retrieveMonths(){
		return months;
	}
	
	public Month getMonth(Integer monthNo){
		return this.months.get(monthNo);
	}
	
	public int getYearNo(){
		return yearNo;
	}
}
