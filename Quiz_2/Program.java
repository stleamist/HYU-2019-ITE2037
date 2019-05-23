import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	public static void main(String[] args) {
		DictionaryArray dictArr = new DictionaryArray();
		
		Scanner sc = new Scanner(System.in);
		int selectedMenu;
		
		String word;
		String definition;
		
		while (true) {
			System.out.println(
				"============== Main Menu ==============\n" +
				"(1) Add a word to dictionary\n" +
				"(2) Show definition of word\n" +
				"(3) Show word list\n" +
				"(4) Remove word\n" +
				"(5) Print all contents\n" +
				"(6) Exit program\n" +
				"======================================="
			);
			
			System.out.print("choose a menu: ");
			
			selectedMenu = sc.nextInt();
			
			switch (selectedMenu) {
				case 1:
					try {
						System.out.print("word: ");
						word = sc.next();
						System.out.print("definition: ");
						definition = sc.next();
						sc.nextLine();
						
						WordDefinitionPair pair = new WordDefinitionPair(word, definition);
						
						dictArr.insertEntry(word, definition);
					} catch (AlreadyExistInDicException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					try {
						System.out.print("word for searching: ");
						word = sc.next();
						sc.nextLine();
						
						dictArr.getDefinition(word);
					} catch (EmptyException e) {
						System.out.println(e.getMessage());
					} catch (NotInDicException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						dictArr.printWords();
					} catch (EmptyException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						System.out.print("word to remove: ");
						word = sc.next();
						sc.nextLine();
						
						dictArr.removeWord(word);
					} catch (EmptyException e) {
						System.out.println(e.getMessage());
					} catch (NotInDicException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					try {
						dictArr.printAll();
					} catch (EmptyException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					try {
						String filename;
						
						System.out.print("enter a filename: ");
						filename = sc.next();
						sc.nextLine();
						
						
						File file = new File(filename);
						FileWriter writer = new FileWriter(file);
						
						ArrayList<WordDefinitionPair> dicList = dictArr.getDicList();
						
						for (int i = 0; i < dicList.size(); i++) {
							WordDefinitionPair pair = dicList.get(i);
							
							String s = String.format(
								"%d. word: %s\n" +
								"   definition: %s\n",
								i + 1, pair.getWord(), pair.getDefinition());
							
							writer.write(s);
						}
						
						writer.close();
						
						System.out.printf("saved as %s.txt\n", filename);
						
						System.out.println("exit program");
						System.exit(0);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Inert 1 ~ 6");
					break;
			}
		}
	}
}