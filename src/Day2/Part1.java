package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		List<String> data = new ArrayList<>();
		
		while (scan.hasNextLine()) {
			data.add(scan.nextLine());
		}
		
		scan.close();
		
		getAnswer(data);
	}

	
	public static void getAnswer(List<String> data) {
		int counter = 0;
		for (int i=0; i<data.size(); i++) {
			
			String full = data.get(i);
			String[] spacesSeparated = full.split(" ");
			
			// find min-max
			String fullMinMax = spacesSeparated[0];
			String[] fullMinMaxSep = fullMinMax.split("-");
			int min = Integer.parseInt(fullMinMaxSep[0]);
			int max = Integer.parseInt(fullMinMaxSep[1]);
			
			// symbol
			char symbol = spacesSeparated[1].charAt(0);
			
			//password
			String pass = spacesSeparated[2];
			
			char[] charArr = pass.toCharArray();
			for (int j = 0; j<charArr.length; j++) {
				if (charArr[j] == symbol) {
					int count = getCharCount(pass, symbol);
					if ((count >= min) && (count <= max)) {
						counter++;
						break;
					}
				}
			}
		}
		
		System.out.println(counter);
	}
	
	public static int getCharCount(String str, char letter) {
		int counter = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == letter) {
				counter++;
			}
		}
		
		return counter;
	}
}
