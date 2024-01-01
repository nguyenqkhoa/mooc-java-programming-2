import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> shoppingCart;

    public ShoppingCart(){
        this.shoppingCart = new HashMap<>();
    }

    public void add(String product, int price){
        Item item = new Item(product, price);
        if(shoppingCart.containsKey(product)){
            shoppingCart.get(product).increaseQuantity();
        } else {
            shoppingCart.put(product, item);
        }
    }

    public int price(){
        int sum = 0;
        for (String key : shoppingCart.keySet()){
            sum += shoppingCart.get(key).price();
        }
        return sum;
    }

    public void print(){
        for (String key : shoppingCart.keySet()){
            System.out.println(shoppingCart.get(key));
        }
    }
}
