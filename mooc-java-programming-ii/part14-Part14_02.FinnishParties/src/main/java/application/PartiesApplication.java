package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(PartiesApplication.class);
    }

    private List<String> readFile() {
        List<String> file = new ArrayList<>();
        try {
            file = Files.lines(Paths.get("partiesdata.tsv")).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return file;
    }

    private Double returnAsDouble(String scoreAsString) {
        try {
            return Double.valueOf(scoreAsString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private Map<Integer, Double> getMapYearScore(String partyName) {
        Map<Integer, Double> yearScore = new HashMap<>();

        String yearsAsString[] = readFile().get(0).split("\t");
        int yearsWithOutPartyText = yearsAsString.length - 1;
        int[] years = new int[yearsWithOutPartyText];

        for (int i = 0; i < years.length; i++) {
            years[i] = Integer.parseInt(yearsAsString[i + 1]);
        }

        readFile().stream()
                .map(row -> row.split("\t"))
                .forEach(row -> {
                    if (row[0].equals(partyName)) {
                        for (int i = 1; i < row.length; i++) {
                            yearScore.put(years[i - 1], returnAsDouble(row[i]));
                        }
                    }
                });
        return yearScore;
    }

    private Map<String, Map<Integer, Double>> mapInfo(){
        List<String> file = readFile();
        Map<String, Map<Integer, Double>> mappedInfo = new HashMap<>();

        file.stream().map(row -> row.split("\t"))
                .forEach(row -> mappedInfo.putIfAbsent(row[0], getMapYearScore(row[0])));
        mappedInfo.remove("Party");

        return mappedInfo;
    }

    @Override
    public void start(Stage stage) throws Exception {

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        Map<String, Map<Integer, Double>> values = mapInfo();

        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
}
