/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author yalam
 */
public class Day {
    
    private int dayno = -1;
	private int totalHoursInDay = 24;
	private Set<Integer> hour = new TreeSet<>();
	
	Day(int dayNo){
		this.dayno = dayNo;
	}
	
	public void addHours(int hourNo){
		if(hour.size() != totalHoursInDay){
			hour.add(hourNo);
		}
	}
	
	public Set<Integer> retrieveHours(){
		return hour;
	}
}
