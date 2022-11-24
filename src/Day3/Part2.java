package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
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
		
		int x = 0;
		int maxY = data.size();
		int maxX = data.get(0).length();
		int counter = 0;
		for (int y=2; y<maxY; y=y+2) {
			x = x + 1;
			
			if (x >= maxX) {
				x -= maxX;
			}
			
			if (data.get(y).charAt(x) == '#') {
				counter++;
			}
		}
		
		System.out.println(counter);


		
	}
	

}
