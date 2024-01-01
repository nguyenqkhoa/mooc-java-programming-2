package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{

    private boolean sensor;
    private int sensorValue;

    public TemperatureSensor(){
        this.sensor = false;
        this.sensorValue = 0;
    }

    @Override
    public boolean isOn() {
        return sensor;
    }

    @Override
    public void setOn() {
        this.sensor = true;
    }

    @Override
    public void setOff() {
        this.sensor = false;
    }

    @Override
    public int read() {
        if(true){
            sensorValue = new Random().nextInt(61) - 30;
            return sensorValue;
        }
        else {
            throw new IllegalStateException("Not true!");
        }
    }
}
