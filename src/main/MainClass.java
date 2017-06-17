package main;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Segp-Group 3
 */
public class MainClass extends Application {

	//MainController object = new MainController();
	static Stage stage;

	public static Scene sceneCopy;

	private static StackPane pane = new StackPane();

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

		// the RootBorder is get to show pin dialoge box that will appear on a
		// screen
		pane.getChildren().add(root);

		Scene scene = new Scene(pane);
	//	scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
		stage.setTitle("Jfx Browser");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {

		System.out.println("xvzd");
		launch(args);
		//System.exit(1);
	}

}
