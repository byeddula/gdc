/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author yalam
 */
public class Month {
    
    private int monthno = -1;
	private int totalDaysInMonth = -1;
	private Map<Integer,Day> days = new HashMap<>();
	
	Month(int whichMonth, int howManyDays){
		this.monthno = whichMonth;
		this.totalDaysInMonth = howManyDays;
	}
	
	public void addDays(int dayNo,Day d){
		if(days.size() != totalDaysInMonth){
			days.put(dayNo,d);
		}
	}
	
	public Map<Integer,Day> retrieveDays(){
		return days;
	}
	
	public Day getDay(Integer d){
		return this.days.get(d);
	}
	
	public Set<Integer> getMissedDays(){
		List<Integer> totalDaysMissing = IntStream.rangeClosed(1, totalDaysInMonth)
			    .boxed().collect(Collectors.toList());
		totalDaysMissing.removeAll(days.keySet());
		return new TreeSet<>(totalDaysMissing);
	}
}
