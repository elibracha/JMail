package main;

import javafx.application.Application;
import javafx.stage.Stage;
import views.ViewFactory;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(ViewFactory.getInstance().getMainScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
