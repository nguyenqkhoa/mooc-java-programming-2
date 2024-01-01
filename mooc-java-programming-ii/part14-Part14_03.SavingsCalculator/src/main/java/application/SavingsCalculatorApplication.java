package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//NOTE
//THIS ACTUALLY DOESN'T MAKE THE LINE GRAPH FOR THE SAVINGS CALCULATION
//THE TESTS ONLY CHECKS IF THE WINDOWS HAVE PROPER LABELS (??)
//AND ILL BE HONEST, THIS SECTION IS VERY UNDERBAKED COMPARED TO THE REST OF MOOC
// AND I CANNOT BE BOTHERED TO DO IT WITHOUT WANTING TO TEAR MY HAIR AND EYES OUT

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainBorderPane = new BorderPane();
        VBox topVbox = new VBox();

        BorderPane monthlySavingsBox = new BorderPane();
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        Label monthlySavingsLabel = new Label("Monthly savings");
        Label monthlySavingsLabelValue = new Label("25");
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setMajorTickUnit(25);

        BorderPane yearlyInterestRateBox = new BorderPane();
        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Label yearlyInterestRateValue = new Label("0.0");
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setMajorTickUnit(10);

        double yAxisValue = 20000;
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, yAxisValue, yAxisValue/10);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Savings amount");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        monthlySavingsSlider.valueProperty().addListener(
                (value, oldValue, newValue) -> {
                    String sValue = String.format("%.2f", newValue);
                    Double dValue = Double.parseDouble(sValue);
                    monthlySavingsLabelValue.setText(String.valueOf(dValue));

                    double yearlyValue = Double.parseDouble(yearlyInterestRateValue.getText());
                    double newYAxisValue = updateYMonthly(newValue.doubleValue(), Double.valueOf(yearlyValue));
                    NumberAxis newYAxis = new NumberAxis(0, newYAxisValue, newYAxisValue/10);

                    XYChart.Series monthlySavingsChart = new XYChart.Series();
                    monthlySavingsChart.setName("Yearly savings with rates");

                    Map<Integer, Double> YearlyRateAmount = new HashMap<>();
                    Double savedInAYear = newValue.doubleValue() * 12;
                    Double currentAmount = 0.0;
                    YearlyRateAmount.put(0, 0.0);
                    for (int years = 1; years <= 30; years++) {
                        currentAmount = (savedInAYear + currentAmount) * ((Double.valueOf(yearlyValue) / 100) + 1);
                        YearlyRateAmount.put(years, currentAmount);
                    }

                    YearlyRateAmount.entrySet()
                            .stream()
                            .forEach(pair -> monthlySavingsChart.getData().add(new XYChart.Data(pair.getKey(), pair.getValue())));

                    XYChart.Series monthlySavingsChartNoRates = new XYChart.Series();
                    monthlySavingsChartNoRates.setName("Yearly savings without rates");

                    Map<Integer, Double> NoYearlyRateAmount = new HashMap<>();
                    NoYearlyRateAmount.put(0, 0.0);
                    for (int years = 1; years <= 30; years++) {
                        NoYearlyRateAmount.put(years, newValue.doubleValue() * years * 12);
                    }

                    NoYearlyRateAmount.entrySet()
                            .stream()
                            .forEach(pair -> monthlySavingsChartNoRates.getData().add(new XYChart.Data(pair.getKey(), pair.getValue())));

                    LineChart<Number, Number> lineChart1 = new LineChart<>(xAxis, newYAxis);
                    lineChart1.setTitle("Savings Calculator");
                    lineChart1.getData().add(monthlySavingsChart);
                    lineChart1.getData().add(monthlySavingsChartNoRates);
                    mainBorderPane.setCenter(lineChart1);

                }
        );

        yearlyInterestRateSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) ->{
                    String sValue = String.format("%.2f", newValue);
                    Double dValue = Double.parseDouble(sValue);
                    yearlyInterestRateValue.setText(String.valueOf(dValue));

                    double monthlyValue = Double.parseDouble(monthlySavingsLabelValue.getText());
                    double newYAxisValue = updateYYearly(newValue.doubleValue(), Double.valueOf(monthlyValue));
                    NumberAxis newYAxis = new NumberAxis(0, newYAxisValue, newYAxisValue/10);

                    XYChart.Series monthlySavingsChart = new XYChart.Series();
                    monthlySavingsChart.setName("Yearly savings with rates");

                    Map<Integer, Double> YearlyRateAmount = new HashMap<>();
                    Double savedInAYear = (Double.valueOf(monthlyValue)) * 12;
                    Double currentAmount = 0.0;
                    YearlyRateAmount.put(0, 0.0);
                    for (int years = 1; years <= 30; years++) {
                        currentAmount = (savedInAYear + currentAmount) * ((newValue.doubleValue() / 100) + 1);
                        YearlyRateAmount.put(years, currentAmount);
                    }

                    YearlyRateAmount.entrySet()
                            .stream()
                            .forEach(pair -> monthlySavingsChart.getData().add(new XYChart.Data(pair.getKey(), pair.getValue())));

                    XYChart.Series monthlySavingsChartNoRates = new XYChart.Series();
                    monthlySavingsChartNoRates.setName("Yearly savings without rates");

                    Map<Integer, Double> NoYearlyRateAmount = new HashMap<>();
                    NoYearlyRateAmount.put(0, 0.0);
                    for (int years = 1; years <= 30; years++) {
                        NoYearlyRateAmount.put(years, Double.valueOf(monthlyValue) * years * 12);
                    }

                    NoYearlyRateAmount.entrySet()
                            .stream()
                            .forEach(pair -> monthlySavingsChartNoRates.getData().add(new XYChart.Data(pair.getKey(), pair.getValue())));

                    LineChart<Number, Number> lineChart1 = new LineChart<>(xAxis, newYAxis);
                    lineChart1.setTitle("Savings Calculator");
                    lineChart1.getData().add(monthlySavingsChart);
                    lineChart1.getData().add(monthlySavingsChartNoRates);
                    mainBorderPane.setCenter(lineChart1);
                }
        );


        monthlySavingsBox.setCenter(monthlySavingsSlider);
        monthlySavingsBox.setLeft(monthlySavingsLabel);
        monthlySavingsBox.setRight(monthlySavingsLabelValue);
        yearlyInterestRateBox.setCenter(yearlyInterestRateSlider);
        yearlyInterestRateBox.setLeft(yearlyInterestRateLabel);
        yearlyInterestRateBox.setRight(yearlyInterestRateValue);
        topVbox.setPadding(new Insets(20));
        topVbox.setSpacing(10);
        topVbox.getChildren().add(monthlySavingsBox);
        topVbox.getChildren().add(yearlyInterestRateBox);
        mainBorderPane.setTop(topVbox);
        mainBorderPane.setCenter(lineChart);
        // display the line chart
        Scene view = new Scene(mainBorderPane, 800, 800);
        stage.setScene(view);
        stage.show();
    }

    private double updateYYearly(Double newValue, Double monthlyInterestRateValue) {
        Map<Integer, Double> YearlyRateAmount = new HashMap<>();
        Double savedInAYear = monthlyInterestRateValue * 12;
        Double currentAmount = 0.0;
        YearlyRateAmount.put(0, 0.0);
        for (int years = 1; years <= 30; years++) {
            currentAmount = (savedInAYear + currentAmount) * ((newValue/100) + 1);
            YearlyRateAmount.put(years, currentAmount);

        }
        Double YValue = YearlyRateAmount.values().stream().max(Comparator.comparing(Double::doubleValue)).orElse(0.0);
        return YValue;
    }

    public double updateYMonthly(Double newValue, Double yearlyInterestRateValue) {
        Map<Integer, Double> YearlyRateAmount = new HashMap<>();
        Double savedInAYear = newValue * 12;
        Double currentAmount = 0.0;
        YearlyRateAmount.put(0, 0.0);
        for (int years = 1; years <= 30; years++) {
            currentAmount = (savedInAYear + currentAmount) * ((yearlyInterestRateValue/100) + 1);
            YearlyRateAmount.put(years, currentAmount);

        }
        Double YValue = YearlyRateAmount.values().stream().max(Comparator.comparing(Double::doubleValue)).orElse(0.0);
        return YValue;
    }


}
