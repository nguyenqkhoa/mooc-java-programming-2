import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility(){
        this.storage = new HashMap<>();
    }

    public void add(String word, String item){
        this.storage.putIfAbsent(word, new ArrayList<>());

        //ArrayList<String> dictionaryTranslation = this.dictionary.get(word);
        //dictionaryTranslation.add(translation);

        this.storage.get(word).add(item);
    }

    public ArrayList<String> contents(String storageUnit){
        return storage.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item){
        this.storage.get(storageUnit).remove(item);
        if (this.storage.get(storageUnit).isEmpty()){
            this.storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> storageUnits = new ArrayList<>();
        for (String s: this.storage.keySet()
             ) {
            storageUnits.add(s);

        }
        return storageUnits;
    }
}
