import java.util.ArrayList;

public class Box implements Packable{

    private double capacity;
    private final ArrayList<Packable> packable;

    public Box(double capacity){
        this.capacity = capacity;
        this.packable = new ArrayList<>();
    }

    public void add(Packable packable){
        if (packable.weight() + weight() <= capacity){
            this.packable.add(packable);
        }
    }

    @Override
    public double weight(){
        double weight = 0;
        weight = packable.stream().mapToDouble(value -> value.weight()).sum();
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + packable.size() + " items, total weight " + weight() + " kg";
    }

}
