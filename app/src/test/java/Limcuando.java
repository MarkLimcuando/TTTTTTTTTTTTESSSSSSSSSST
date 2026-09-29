
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Limcuando {
    private static Map<String, Scheduleplanner> database = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to Schedule Planner ---");
            System.out.println("1. Create Schedule");
            System.out.println("2. Check Schedule ");
            System.out.println("3. Close Schedule Planner");
            System.out.println("--- Choose an option ---");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CreateSchedule(scanner);
                    break;
                case 2:
                    CheckSchedule();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choic.e");

            }

        }
        scanner.close();
    }
    private static void CreateSchedule(Scanner scanner) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            System.out.println("Enter new Schedule (dd-MM-yyyy): ");
            String scheduleInput = scanner.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(scheduleInput, formatter);
                String schedule = date.format(formatter);
                if (database.containsKey(schedule)) {
                    System.out.println("That Schedule is already set!");
                    return;
                }
                Scheduleplanner newSchedule =
                        new Scheduleplanner(schedule);
                database.put(schedule, newSchedule);
                System.out.println("Schedule Set!");
                return;
            } catch (DateTimeParseException e) {
                System.out.println(
                        "Invalid date. Please enter a valid date in dd-MM-yyyy format."
                );
            }
        }
    }

    private static void CheckSchedule() {
        if (database.isEmpty()) {
            System.out.println("No Schedule Set");
            return;
        }
        System.out.println("Schedules Set!");
        for (String Schedule : database.keySet()) {
            System.out.println(Schedule);
        }
    }
}
//test this shit big boy//

