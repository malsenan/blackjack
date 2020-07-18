package blackjack;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Driver extends Application {
	
	public static void main(String [ ] args) {
		
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Cracking Blackjack");
		final CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Hit if...");
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Win Rate (%)");
		final BarChart<String,Number> chart = new BarChart<String,Number>(xAxis,yAxis);
		chart.setTitle("Cracking Blackjack");
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("Win Rate");
		
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("Blackjack Rate");
		
		for (int i = 2; i <= 20; i++) {
			String max = "<=" + i;
			Game game = new Game();
			game.play1500000(i);
			game.printData();
			series1.getData().add(new XYChart.Data(max, (int) Math.round(game.winrate)));
			series2.getData().add(new XYChart.Data(max, (int) Math.round(game.bjRate)));
		}
		chart.getData().addAll(series1, series2);
		Scene scene = new Scene(chart, 1200, 900);
		stage.setScene(scene);
		stage.show();
	}
}
