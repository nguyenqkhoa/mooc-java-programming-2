import java.util.ArrayList;
import java.util.stream.Collectors;

public class Herd implements Movable{

    private ArrayList<Organism> herd;

    public Herd(){
        this.herd = new ArrayList<>();
    }

    @Override
    public String toString() {
        String string = herd.stream().map(s -> s.toString()).collect(Collectors.joining(("\n")));
        return string;
    }

    public void addToHerd(Movable movable){
        herd.add((Organism) movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Organism organism: herd){
            organism.move(dx, dy);
        }
    }
}
