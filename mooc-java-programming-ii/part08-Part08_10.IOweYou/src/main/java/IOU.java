import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> IOU;

    public IOU(){
        this.IOU = new HashMap<>();
    }

    public void setSum(String toWhom, double amount){
        this.IOU.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        if(IOU.containsKey(toWhom)){
            return IOU.get(toWhom);
        }
        return 0;
    }


}
