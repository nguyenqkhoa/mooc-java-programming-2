import java.util.ArrayList;

public class Pipe <T>{
    private ArrayList<T> pipeValues;

    public Pipe(){
        this.pipeValues = new ArrayList<>();
    }

    public void putIntoPipe(T Value){
        pipeValues.add(Value);
    }

    public T takeFromPipe(){
        if(!pipeValues.isEmpty()){
            T toReturn = pipeValues.get(0);
            pipeValues.remove(0);
            return toReturn;
        }
        else {
            return null;
        }
    }

    public boolean isInPipe(){
        if(!pipeValues.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }


}
