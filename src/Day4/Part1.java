package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Part1 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).split("\r\n\r\n");
		int counter = 0;
		for (String str : arr) {
			boolean allOk = true;
			allOk = allOk && Pattern.compile("byr:").matcher(str).find();
			allOk = allOk && Pattern.compile("iyr:").matcher(str).find();
			allOk = allOk && Pattern.compile("eyr:").matcher(str).find();
			allOk = allOk && Pattern.compile("hgt:").matcher(str).find();
			allOk = allOk && Pattern.compile("hcl:").matcher(str).find();
			allOk = allOk && Pattern.compile("ecl:").matcher(str).find();
			allOk = allOk && Pattern.compile("pid:").matcher(str).find();

			counter += allOk ? 1 : 0;
		}
		
		System.out.println(counter);
	}
	

}
