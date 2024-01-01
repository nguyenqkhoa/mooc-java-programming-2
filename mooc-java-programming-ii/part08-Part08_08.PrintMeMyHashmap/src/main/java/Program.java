
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printKeys(HashMap<String,String> hashMap){
        System.out.println(hashMap.keySet());
        /*
        for(String keys : hashMap.keySet()){
            System.out.println(hashMap.get(keys));
        }
         */
    }

    public static void printKeysWhere(HashMap<String, String> hashMap, String text){
        for(String keys : hashMap.keySet()){
            if(keys.contains(text)){
                System.out.println(keys);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String,String> hashMap, String text){
        for(String keys : hashMap.keySet()){
            if(keys.contains(text)) {
                System.out.println(hashMap.get(keys));
            }
        }
    }

}
