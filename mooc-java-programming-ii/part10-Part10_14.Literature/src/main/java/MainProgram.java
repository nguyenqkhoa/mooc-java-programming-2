
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books> books = new ArrayList<>();

        while (true) {
            System.out.println("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.println("Input the age recommendation: ");
            int age = Integer.parseInt(scanner.nextLine());
            books.add(new Books(name, age));
            System.out.println("");
        }

        System.out.println("\n" + books.size() + " books in total.\n\nBooks:");

        Comparator<Books> comparator = Comparator.comparing(Books::getAge).thenComparing(Books::getName);
        Collections.sort(books, comparator);
        for(Books b: books){
            System.out.println(b.toString());
        }

    }

}
