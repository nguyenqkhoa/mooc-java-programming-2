package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")){
                break;
            }
            if (command.equals("1")){
                System.out.println("Listing the database contents");
                //database.list();
                this.database.list().stream().forEach(todo -> {
                    System.out.println(todo.toString());
                });
            }
            if (command.equals("2")){
                System.out.println("Enter name");
                String name = this.scanner.nextLine();
                System.out.println("Enter description");
                String description = this.scanner.nextLine();
                Todo newToDo = new Todo(name, description, false);
                database.add(newToDo);
            }
            if (command.equals("3")){
                System.out.println("Which todo should be marked as done (give the id)?");
                database.markAsDone(this.scanner.nextInt());
            }
            if (command.equals("4")){
                System.out.println("Which todo should be removed(give the id)?");
                database.remove(this.scanner.nextInt());
            }

            // implement the functionality here
        }

        System.out.println("Thank you!");
    }

}
