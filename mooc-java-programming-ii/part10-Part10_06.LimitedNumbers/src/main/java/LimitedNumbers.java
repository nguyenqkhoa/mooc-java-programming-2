
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();
        while (true) {
            Integer row = scanner.nextInt();
            if (0 > row) {
                break;
            }

            inputs.add(row);
        }
        ArrayList<Integer> betweenOneToFive = inputs.stream()
                .filter(value -> value >= 1 && value <= 5)
                .collect(Collectors.toCollection(ArrayList::new));

        betweenOneToFive.stream()
                .forEach(value -> System.out.println(value));

    }
}
