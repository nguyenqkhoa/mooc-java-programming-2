
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List<String> myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        int index = myList.indexOfValue("hello");
        System.out.println(index);
        System.out.println(myList.value(index));
        myList.remove("hello");
        System.out.println(myList.contains("hello"));
        List<String> mySecondList = new List<>();
        mySecondList.add("hello");
        mySecondList.add("world");

        for(int i = 0; i < mySecondList.size(); i++) {
            System.out.println(mySecondList.value(i));
        }

    }

}
