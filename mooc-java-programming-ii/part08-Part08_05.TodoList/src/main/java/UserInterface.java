import java.util.Scanner;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner){
        this.todoList = todoList;
        this.scanner=scanner;
    }

    public void start(){
        while(true){
            String input = scanner.nextLine();
            System.out.println("Command: ");

            if(input.equals("add")){
                System.out.println("To add: ");
                String toAdd = scanner.nextLine();
                todoList.add(toAdd);
            }
            if(input.equals("list")){
                todoList.print();
            }
            if(input.equals("remove")){
                System.out.println("Which one is removed? ");
                int toRemove = scanner.nextInt();
                todoList.remove(toRemove);
            }
            if(input.equals("stop")){
                break;
            }
        }
    }

}
