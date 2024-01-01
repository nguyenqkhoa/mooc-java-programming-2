import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory(){
        this.history = new ArrayList<Double>();
    }

    public void add(double status){
        history.add(status);
    }

    public void clear(){
        history.clear();
    }

    public String toString(){
        return history.toString();
    }
    
    public double maxValue(){
        double maxValue = 0.0;
        if (history.isEmpty()){
            return 0.0;
        }else {
            maxValue = Collections.max(history);
            return maxValue;
        }
    }

    public double minValue(){
        double minValue = 0.0;
        if (history.isEmpty()){
            return 0.0;
        }else {
            minValue = Collections.min(history);
            return minValue;
        }
    }

    public double average(){
        double average = 0.0;
        if (history.isEmpty()){
            return 0.0;
        }else {
            for(Double hist : history){
                average += hist;
            }
            return average / history.size();
        }
    }

}
