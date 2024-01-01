
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.print("> ");
            System.out.println("First: " + first.toString());
            System.out.println("Second: " + second.toString());

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add") && amount >= 0){
                first.add(amount);
            }
            if (command.equals("move") && amount >= 0){
                if (first.contains() >= amount) {
                    if(second.contains() + amount > 100){
                        second.add(100);
                        first.remove(amount);
                    }
                    else{
                        first.remove(amount);
                        second.add(amount);
                    }
                }
                else{
                    if(second.contains() + first.contains() > 100){
                        second.add(100);
                        first.remove(amount);
                    }
                    else{
                        second.add(first.contains());
                        first.remove(100);
                    }
                }
            }
            if (command.equals("remove") && amount >= 0){
                second.remove(amount);
            }

        }
    }

}
