package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HeadControllers extends Application {

	BorderPane bpane = new BorderPane();

	JFXTabPane tabPane = new JFXTabPane();

	Tab stockTab = new Tab("Transaction");
	Tab entryTab = new Tab("Stock");

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		setTabsViews();

		tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
				// TODO Auto-generated method stub

				setTabsViews();

			}
		});

		tabPane.setTabMaxWidth(500);
		tabPane.setTabMaxHeight(50);
		tabPane.setTabMinHeight(50);
		tabPane.setTabMinWidth(300);
		tabPane.setStyle("-fx-background-color:#FFFFFF");
		tabPane.getTabs().addAll(entryTab, stockTab);

		bpane.setCenter(tabPane);

		Scene scene = new Scene(bpane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}

	public void setTabsViews() {

		try {
			Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Entry.fxml"));
			Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/Stock.fxml"));

			stockTab.setContent(root1);
			entryTab.setContent(root2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
