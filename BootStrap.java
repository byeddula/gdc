/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author yalam
 */
public class BootStrap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
       
		String fileRepo = "C:\\Users\\yalam\\Downloads\\gdc.txt";
		MissingHourFinder finder = new MissingHourFinder();
		finder.findInfo(fileRepo);
	}
    
}
