
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 0){
                break;
            }
            if (input > 0){
                numbers.add((input));
            }
        }
        if (!numbers.isEmpty()){
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            double avg = (1.0)*sum/numbers.size();
            System.out.println(avg);
        } else{
            System.out.println("Cannot calculate the average");
        }
    }
}
