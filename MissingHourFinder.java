/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author yalam
 */
public class MissingHourFinder {
    
    private List<Integer> hours = IntStream.rangeClosed(0, 23)
		    .boxed().collect(Collectors.toList());

	public void findInfo(String fileRepo) throws IOException {
                
                Path path = Paths.get(fileRepo);
                Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
               
		Map<Integer, CompositeInfo> map = new HashMap<>();
                Pattern pattern = Pattern.compile("(2018)(\\d{2})(\\d{2})(\\d{2})");
		lines.
                        forEach(line -> {
							Matcher matcher = pattern.matcher(line);
                                                        if(matcher.find()){
							int year = Integer.valueOf(matcher.group(1));
							int month = Integer.valueOf(matcher.group(2));
							int day = Integer.valueOf(matcher.group(3));
							int hour = Integer.valueOf(matcher.group(4));
							// System.out.println(hourMonthString +" "+year +
							// " "+ month + " "+ day +" "+ hour);

							CompositeInfo info = map.get(year);
							if (info == null) {
								info = new CompositeInfo();
								map.put(year, info);
							}
							info.addInfo(year, month, day, hour);
                                                       }
						});

		// 2 Iterate and print the missing hours ...
		map.forEach((year, info) -> {
			Year years = info.getYears();
			Map<Integer, Month> months = years.retrieveMonths();
			months.forEach((monNo, month) -> {
				Map<Integer, Day> days = month.retrieveDays();
				Set<Integer> missingHours = new TreeSet<>(hours);
				days.forEach((dayNo, day) -> {
					Set<Integer> hours = day.retrieveHours();
					missingHours.removeAll(hours);
					if (missingHours.size() != 0) {
						missingHours.forEach(hour -> {
							System.out.println("Missing file for Year :" + year
									+ " month :" + monNo + " day :" + dayNo
									+ " hour :" + hour);
						});
					}
				});
				
				
				Set<Integer> missingDays = month.getMissedDays();
				if (missingDays.size() != 0) {
					missingDays.forEach(day -> {
						System.out.println("Missing file for Year :" + year
								+ " month :" + monNo + " day :" + day);
					});
				}
			});
		});
	}

}
