package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class HeadControllers  {

	BorderPane bpane = new BorderPane();

	public BorderPane getBpane() {
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

		return bpane;
	}

	public void setBpane(BorderPane bpane) {
		this.bpane = bpane;
	}

	JFXTabPane tabPane = new JFXTabPane();

	Tab stockTab = new Tab("Transaction");
	Tab entryTab = new Tab("Stock");


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
