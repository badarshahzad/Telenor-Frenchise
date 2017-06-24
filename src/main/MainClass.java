package main;

import controllers.HeadControllers;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Segp-Group 3
 */
public class MainClass extends Application {

	static Stage stage;

	public static Scene sceneCopy;

	private static StackPane pane = new StackPane();

	@Override
	public void start(Stage stage) throws Exception {

		HeadControllers root = new HeadControllers();
		pane.getChildren().add(root.getBpane());

		Scene scene = new Scene(pane);
		// scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
		stage.setTitle("Sudo");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
