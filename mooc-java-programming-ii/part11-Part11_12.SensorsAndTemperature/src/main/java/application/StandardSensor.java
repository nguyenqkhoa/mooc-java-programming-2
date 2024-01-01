package application;

public class StandardSensor implements Sensor{

    private int sensorValue;

    public StandardSensor(int sensorValue){
        this.sensorValue = sensorValue;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        //sensor = true;
    }

    @Override
    public void setOff() {
        //sensor = false;
    }

    @Override
    public int read() {
        if(true){
            return sensorValue;
        }
        else {
            throw new IllegalStateException("Not true!");
        }
    }
}
