package controllers;

import com.jfoenix.controls.JFXTabPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HeadControllers extends Application{

	BorderPane bpane = new BorderPane();

	JFXTabPane tabPane = new JFXTabPane();
	
	Tab stackTab = new Tab("Stack");
	Tab entryTab = new Tab("Entry");

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	
	tabPane.setTabMaxWidth(500);
	tabPane.setTabMaxHeight(50);
	tabPane.setTabMinHeight(50);
	tabPane.setTabMinWidth(300);
	tabPane.setStyle("-fx-background-color:#FFFFFF");
		
		tabPane.getTabs().addAll(entryTab,stackTab);
		
		bpane.setCenter(tabPane);
		
		Scene scene =new Scene(bpane);
		primaryStage.setScene(scene);
		primaryStage.show();
				
		
	}
	
	public static void main(String args[]){
		launch(args);
	}
	


}
