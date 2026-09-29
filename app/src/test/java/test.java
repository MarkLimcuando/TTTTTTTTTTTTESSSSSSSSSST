import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;

        while (date == null) {
            System.out.print("Enter a date (dd-MM-yyyy): ");
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input, formatter);
                System.out.println("Valid date accepted: " + date);
            } catch (Exception e) {
                System.out.println("Invalid date or format. Try again.");
            }
        }

        scanner.close();
    }
}