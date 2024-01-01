
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            if (command.equals("end")){
                break;
            }
            int toCube = Integer.valueOf(command);
            int cubed = toCube * toCube * toCube;
            System.out.println(cubed);
        }
    }
}
