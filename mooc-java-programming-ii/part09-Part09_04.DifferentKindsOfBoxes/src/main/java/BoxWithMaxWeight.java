import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{

    private final ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity){
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    private int currentWeight(){
        return items.stream().mapToInt(value -> value.getWeight()).sum();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() + currentWeight() <= capacity){
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.stream().anyMatch(value -> value.equals(item));
    }
}
