
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array){
        String string = "";
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                string = string + String.valueOf(array[row][column]);
            }
            string = string + "\n";
        }
        return string;
    }

}
