package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).split("\r\n\r\n");
		int counter = 0;
		for (String str : arr) {
			boolean allOk = true;
			Matcher byrMatcher = Pattern.compile("byr:(\\d{4})").matcher(str);
			allOk = allOk 	&& byrMatcher.find()
							&& (Integer.parseInt(byrMatcher.group(1)) >= 1920)
							&& (Integer.parseInt(byrMatcher.group(1)) <= 2002);

			Matcher iyrMatcher = Pattern.compile("iyr:(\\d{4})").matcher(str);
			allOk = allOk 	&& iyrMatcher.find()
							&& (Integer.parseInt(iyrMatcher.group(1)) >= 2010)
							&& (Integer.parseInt(iyrMatcher.group(1)) <= 2020);
			
			Matcher eyrMatcher = Pattern.compile("eyr:(\\d{4})").matcher(str);
			allOk = allOk 	&& eyrMatcher.find()
							&& (Integer.parseInt(eyrMatcher.group(1)) >= 2020)
							&& (Integer.parseInt(eyrMatcher.group(1)) <= 2030);
			
			Matcher hgtMatcher = Pattern.compile("hgt:(\\d+)(in|cm)").matcher(str);
			allOk = allOk 	&& hgtMatcher.find()
							&& 
								((hgtMatcher.group(2).equals("in")
										&& (Integer.parseInt(hgtMatcher.group(1)) >= 59)
										&& (Integer.parseInt(hgtMatcher.group(1)) <= 76))
								|| (hgtMatcher.group(2).equals("cm") 
										&& (Integer.parseInt(hgtMatcher.group(1)) >= 150)
										&& (Integer.parseInt(hgtMatcher.group(1)) <= 193)));

			allOk = allOk && Pattern.compile("hcl:#[0-9a-f]{6}").matcher(str).find();
			allOk = allOk && Pattern.compile("ecl:amb|blu|brn|gry|grn|hzl|oth").matcher(str).find();
			
			Matcher pidMatcher = Pattern.compile("pid:(\\d{9})(\\s|$)").matcher(str);
			boolean result = pidMatcher.find();
			allOk = allOk && result; 
			counter += allOk ? 1 : 0;
		}
		
		System.out.println(counter);
	}
	

}
