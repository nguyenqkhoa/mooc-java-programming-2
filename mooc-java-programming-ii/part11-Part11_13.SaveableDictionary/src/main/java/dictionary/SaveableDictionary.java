package dictionary;

import com.sun.tools.jdeprscan.scan.Scan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private File file;

    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file){
        this.dictionary = new HashMap<>();
        this.file = new File(file);
    }

    public void add(String word, String translation){
        this.dictionary.putIfAbsent(word, translation);

    }

    public String translate(String word){
        for (String translation : this.dictionary.keySet()) {
            if (this.dictionary.get(translation).equals(word)) {
                return translation;
            } else if (this.dictionary.get(word) != null) {
                return this.dictionary.get(word);
            }
        }
        return null;

    }

    public void delete(String word){
        if (dictionary.remove(word) == null) {
            dictionary.values().removeIf(translation -> translation.contains(word));
        }
        this.dictionary.remove(word);
    }

    public boolean load(){
        try{
            Scanner fileReader = new Scanner(Paths.get(this.file.getName()));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");   // split the line based on the ':' character
                add(parts[0], parts[1]);
                //System.out.println(parts[0]);     // part of line before :
                //System.out.println(parts[1]);     // part of line after :
            }
            return true;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save(){
        try {
            PrintWriter printWriter = new PrintWriter(this.file.getName());
            for (String toAdd : this.dictionary.keySet()) {
                String word = toAdd;
                String translation = this.dictionary.get(toAdd);
                printWriter.println(word + ":" + translation);
            }
            printWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
