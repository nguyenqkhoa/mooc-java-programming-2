
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file){
        List<Book> Books = new ArrayList<>();
        try {
            // reading the "presidents.txt" file line by line
            Files.lines(Paths.get(file))
                    // splitting the row into parts on the ";" character
                    .map(row -> row.split(","))
                    // deleting the split rows that have less than two parts (we want the rows to always contain both the name and the birth year)
                    .filter(parts -> parts.length >= 4)
                    // creating persons from the parts
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    // and finally add the persons to the list
                    .forEach(book -> Books.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Books;
    }

}
