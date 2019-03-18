import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name and filename: ");
        String input = scanner.nextLine();
        
        String[] splittedInput = input.split(",");
        String name = splittedInput[0].trim();
        String filename = splittedInput[1].trim();
        
        String[] nameParts = name.split(" ");
        String[] filenameParts = filename.split("\\.");

        int nameLength = nameParts.length;

        String shortenedName = String.format(
            "%s.%s. %s",
            nameParts[1].substring(0, 1).toUpperCase(),
            nameParts[2].substring(0, 1).toUpperCase(),
            nameParts[0].substring(0, 1).toUpperCase() + nameParts[0].substring(1)
        );

        String convertedFilename = String.format("%s.%s", filenameParts[0], "pdf");

        System.out.printf("Name Length (Korean): %d\n", nameLength);
        System.out.printf("%s submitted %s\n", shortenedName, convertedFilename);
    }
}