
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.add(1, "Cupa");
        hashMap.add(2, "is");
        hashMap.add(3, "best");
        hashMap.add(4, "girl");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(4));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }

}
