package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		List<Integer> data = new ArrayList<>();
		
		while (scan.hasNextInt()) {
			data.add(scan.nextInt());
		}
		
		getAnswer(data);
		
		scan.close();
	}

	
	public static void getAnswer(List<Integer> data) {
		for (int i=0; i<data.size(); i++) {
			for (int j=i+1; j<data.size(); j++) {
				for (int k = j + 1; k<data.size(); k++) {
					if ((data.get(i) + data.get(j) + data.get(k)) == 2020) {
						System.out.println(data.get(i) * data.get(j) * data.get(k));
						return;
					}
				}

			}
		}
	}
}
