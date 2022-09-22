import java.io.*;
import java.util.Scanner;

public class ReadingFromFileExample {
	
	public static void main(String [] args) {

		String fileName = "pg100.txt";
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				System.out.println(line);
//				String[] words = line.split("\\s+"); //scan each line and turn it into individual words
//				for(String word: words) { //for each word in the words list
//					word = word.replaceAll(":", ""); //getting rid of colon
//					word = word.replaceAll(",", ""); //getting rid of commas
//					System.out.println(word);
//				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}


