package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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
			int firstIndex = Integer.parseInt(fullMinMaxSep[0]) - 1;
			int SecondIndex = Integer.parseInt(fullMinMaxSep[1]) - 1;
			
			// symbol
			char symbol = spacesSeparated[1].charAt(0);
			
			//password
			String pass = spacesSeparated[2];
			
			char[] charArr = pass.toCharArray();
			if ((charArr[firstIndex] == symbol) ^ (charArr[SecondIndex] == symbol)) {
				counter++;
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
