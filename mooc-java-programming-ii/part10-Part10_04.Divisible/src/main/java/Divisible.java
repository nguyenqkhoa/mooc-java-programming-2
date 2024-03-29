
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Divisible {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);

        ArrayList<Integer> divisible = divisible(numbers);

        divisible.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        int[] divisors = {2, 3, 5};

        ArrayList<Integer> twoThreeOrFive = new ArrayList<>();
        twoThreeOrFive = (ArrayList<Integer>) numbers
                .stream()
                .filter(value -> IntStream.of(divisors).anyMatch(d -> value % d ==0))
                .collect(Collectors.toCollection(ArrayList::new));

        return twoThreeOrFive;
    }

}
