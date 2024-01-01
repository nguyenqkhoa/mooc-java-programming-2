package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ShanghaiApplication extends Application {

    private Map<Integer, Integer> dataSet;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ShanghaiApplication.class);
    }

    public ShanghaiApplication(){
        this.dataSet = new HashMap<>();
        dataSet.put(2007, 73);
        dataSet.put(2008, 68);
        dataSet.put(2009, 72);
        dataSet.put(2010, 72);
        dataSet.put(2011, 74);
        dataSet.put(2012, 73);
        dataSet.put(2013, 76);
        dataSet.put(2014, 73);
        dataSet.put(2015, 67);
        dataSet.put(2016, 56);
        dataSet.put(2017, 56);

    }


    @Override
    public void start(Stage stage) {

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("University of Helsinki");

        dataSet.entrySet()
                .stream()
                .forEach(pair -> rankingData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue())));

        lineChart.getData().add(rankingData);

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();


    }

}
