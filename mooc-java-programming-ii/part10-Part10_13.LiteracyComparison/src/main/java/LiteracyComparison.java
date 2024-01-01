
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<Comparison> rows = new ArrayList<>();

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .map(parts -> new Comparison(parts[2].replace("(%)", "").trim(),
                            parts[3],
                            Integer.valueOf(parts[4]),
                            Double.parseDouble(parts[5])))
                    .forEach(row -> rows.add((Comparison) row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        rows.stream().sorted((p1, p2) -> {
            if (p1.getLiterate() > p2.getLiterate()) {
                return 1;
            }
            if (p1.getLiterate() < p2.getLiterate()) {
                return -1;
            }
            return 0;
        }).forEach(p -> System.out.println(p));

    }


}
