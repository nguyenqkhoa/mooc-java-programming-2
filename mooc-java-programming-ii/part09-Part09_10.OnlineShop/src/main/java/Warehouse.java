import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> warehousePrices;
    private Map<String, Integer> warehouseStocks;


    public Warehouse(){
        this.warehousePrices = new HashMap<>();
        this.warehouseStocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock){
        warehousePrices.put(product, price);
        warehouseStocks.put(product, stock);
    }

    public int price (String product){
        if(warehousePrices.containsKey(product)){
            return warehousePrices.get(product);
        }
        return -99;
    }

    public int stock(String product){
        if(warehouseStocks.containsKey(product)){
            return warehouseStocks.get(product);
        }
        return 0;
    }

    public boolean take(String product){
        if(warehouseStocks.containsKey(product)){
            if(warehouseStocks.get(product) > 0) {
                warehouseStocks.put(product, warehouseStocks.get(product) - 1);
                return true;
            }
        }
        return  false;
    }

    public Set<String> products(){
        return warehousePrices.keySet();
    }
}
