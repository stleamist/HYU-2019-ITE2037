import java.util.Scanner;

public class TimeTableApp {
    public static void main(String[] args) {
        TimeTable table = new TimeTable();
        
        Scanner sc = new Scanner(System.in);
        int selectedPrimaryMenu;
        
        String name, tutor, room, day;
        int period;
        
        while (true) {
            System.out.println(
                "============== Main Menu ==============\n" +
                "(1) Add a class to my time table\n" +
                "(2) View the class\n" +
                "(3) Print the entire time table\n" +
                "(4) Exit the program"
            );
            
            selectedPrimaryMenu = sc.nextInt();
            switch (selectedPrimaryMenu) {
                case 1:
                    System.out.print("Day : ");
                    day = sc.next().toUpperCase();
                    System.out.print("Period : ");
                    period = sc.nextInt();
                    System.out.print("Name : ");
                    name = sc.next();
                    System.out.print("Tutor : ");
                    tutor = sc.next();
                    System.out.print("Room : ");
                    room = sc.next();

                    table.setSchedule(day, period, name, tutor, room);
                    break;
                case 2:
                    System.out.println(
                        "============ View the Class ===========\n" +
                        "(1) At a specific period\n" +
                        "(2) By subject title"
                    );
                    
                    int selectedSecondaryMenu = sc.nextInt();
                    switch (selectedSecondaryMenu) {
                        case 1:
                            System.out.print("Day : ");
                            day = sc.next().toUpperCase();
                            System.out.print("Period : ");
                            period = sc.nextInt();
                            Subject sbj = table.getSchedule(day, period);
                            if (sbj == null) {
                                System.out.println("Class was NOT successfully found");
                            } else {
                                System.out.println("At that time you have:");
                                System.out.println(table.getSchedule(day, period).getDetails());
                            }
                            break;
                        case 2:
                            System.out.println(
                                "=========== By subject title ==========\n" +
                                "(1) Specific title\n" +
                                "(2) View all subjects"
                            );
                            
                            int selectedTertiaryMenu = sc.nextInt();
                            switch (selectedTertiaryMenu) {
                                case 1: {
                                        System.out.print("Title : ");
                                        name = sc.next();
                                        Subject subj = table.getSubjectByTitle(name);
                                        if (subj == null) {
                                            System.out.println("It doesn't exist");
                                        } else {
                                            System.out.println(subj.getDetails());
                                        }
                                        break;
                                    }
                                case 2: {
                                        for (Subject subj : table.getAllSubjects()) {
                                            System.out.println("------------");
                                            System.out.println(subj.getDetails());
                                            System.out.println("------------");
                                        }
                                        break;
                                    }
                                default:
                                    System.out.println("Inert 1 ~ 2");
                            }
                            break;
                        default:
                            System.out.println("Inert 1 ~ 2");
                    }
                    break;
                case 3:
                    table.printTimeTable();
                    break;
                case 4:
                    System.out.println("Exit the application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Inert 1 ~ 4");
                    break;
            }
        }
    }
}