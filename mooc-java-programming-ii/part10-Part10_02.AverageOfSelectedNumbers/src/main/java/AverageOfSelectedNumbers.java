
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
                String np = scanner.nextLine();
                if (np.equals("n")) {
                    double negAverage = inputs.stream()
                            .mapToInt(s -> Integer.valueOf(s))
                            .filter(number -> number < 0)
                            .average()
                            .getAsDouble();
                    System.out.println("Average of the negative numbers: " + negAverage);
                }
                else {
                    double posAverage = inputs.stream()
                            .mapToInt(s -> Integer.valueOf(s))
                            .filter(number -> number > 0)
                            .average()
                            .getAsDouble();
                    System.out.println("Average of the positive numbers: " + posAverage);
                }
                break;
            }

            inputs.add(row);
        }
    }

}
