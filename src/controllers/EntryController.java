package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import database.EntryDatabaseManager;
import database.StockDatabase;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import model.Entry;
import model.EntryTable;
import model.Stock;

public class EntryController implements Initializable {

	@FXML
	private BorderPane mainBpane;

	@FXML
	private VBox paneForChart;

	@FXML
	private JFXComboBox<String> chosedEmployee;

	@FXML
	private AnchorPane fieldsAnchor;

	public static TextField entryField = new TextField();

	@FXML
	private TextField hlrField;

	@FXML
	private TextField simField;

	@FXML
	private TextField cardField;

	@FXML
	private TextField easyloadField;

	@FXML
	private TextField easyloadReturnField;

	@FXML
	private TextField easypaisaField;

	@FXML
	private TextField easypaisaReturnField;

	@FXML
	private TextField cashField;

	@FXML
	private TextField expensesField;

	@FXML
	private JFXTextArea commentField;

	@FXML
	private JFXDatePicker date;

	@FXML
	private JFXButton newBt;

	@FXML
	private JFXButton editBt;

	@FXML
	private JFXButton deleteBt;

	@FXML
	private JFXButton clearBt;

	@FXML
	private JFXCheckBox printCheck;

	@FXML
	private JFXTreeTableView<EntryTable> entryTable;

	@FXML
	private JFXTextField search;

	@FXML
	private JFXButton refreshBt;

	@FXML
	private JFXButton excelBt;

	@FXML
	private JFXButton searchBt;

	@FXML
	private JFXButton detailsBt;

	private JFXTreeTableColumn<EntryTable, Number> entryCol = new JFXTreeTableColumn<EntryTable, Number>("Entry");
	private JFXTreeTableColumn<EntryTable, String> dateCol = new JFXTreeTableColumn<EntryTable, String>("Date");
	private JFXTreeTableColumn<EntryTable, String> nameCol = new JFXTreeTableColumn<EntryTable, String>("Name");
	private JFXTreeTableColumn<EntryTable, Number> hlrCol = new JFXTreeTableColumn<EntryTable, Number>("Hlr");
	private JFXTreeTableColumn<EntryTable, Number> simCol = new JFXTreeTableColumn<EntryTable, Number>("Sim");
	private JFXTreeTableColumn<EntryTable, Number> cardCol = new JFXTreeTableColumn<EntryTable, Number>("Card");
	private JFXTreeTableColumn<EntryTable, Number> easyLoadCol = new JFXTreeTableColumn<EntryTable, Number>("Easyload");
	private JFXTreeTableColumn<EntryTable, Number> easyLoadReturnCol = new JFXTreeTableColumn<EntryTable, Number>(
			"Easyload Return");
	private JFXTreeTableColumn<EntryTable, Number> easyPaisaCol = new JFXTreeTableColumn<EntryTable, Number>(
			"Easypaisa");
	private JFXTreeTableColumn<EntryTable, Number> easyPaisaReturnCol = new JFXTreeTableColumn<EntryTable, Number>(
			"Easypaisa Return");
	private JFXTreeTableColumn<EntryTable, Number> cashCol = new JFXTreeTableColumn<EntryTable, Number>("Cash");
	private JFXTreeTableColumn<EntryTable, Number> expensesCol = new JFXTreeTableColumn<EntryTable, Number>("Expenses");
	private JFXTreeTableColumn<EntryTable, String> commentCol = new JFXTreeTableColumn<EntryTable, String>("Comment");

	ObservableList<EntryTable> tableDataList = FXCollections.observableArrayList();

	// Database objects will created

	EntryDatabaseManager entryDatabaseManager;

	Entry entry = new Entry();

	public EntryController() {
		// TODO Auto-generated constructor stub

		// tableDataList = entryDatabaseManager.getAllEntries(tableDataList);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		entryDatabaseManager = new EntryDatabaseManager();

		setFieldsValueZero();
		addListTable();

		newBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			try {

				entryDatabaseManager.addEntry(setFieldsValue());
				addListTable();

			} catch (Exception ex) {

				ex.printStackTrace();
			}

		});

		clearBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			setFieldsValueZero();

		});

		editBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			entryDatabaseManager.updateEntry(setFieldsValue());
			addListTable();
			setFieldsValueZero();
		});

		deleteBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			deleteEntryFromTable();

		});

		searchBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
		});

		detailsBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
		});

		refreshBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
		});

		excelBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
		});

		// Employee Name selected Combo Box

		// chosedEmployee.getSelectionModel().select(0);
		chosedEmployee.setItems(entry.getNameListEmployes());

		// Table Colums name and values setting

		fieldsAnchor.getChildren().add(entryField);
		entryField.setLayoutX(189.0);
		entryField.setLayoutY(426.0);
		entryField.setPrefHeight(26.0);
		entryField.setPrefWidth(72);

		entryCol.setPrefWidth(50);
		entryCol.setMaxWidth(50);
		entryCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().entry1;
					}
				});

		dateCol.setPrefWidth(100);
		dateCol.setMaxWidth(100);
		dateCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EntryTable, String> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().date1;
					}
				});

		nameCol.setPrefWidth(100);
		nameCol.setMaxWidth(250);
		nameCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EntryTable, String> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().name1;
					}
				});

		hlrCol.setPrefWidth(50);
		hlrCol.setMaxWidth(50);
		hlrCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().hlr1;
					}
				});

		simCol.setPrefWidth(50);
		simCol.setMaxWidth(50);
		simCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().sim1;
					}
				});

		cardCol.setPrefWidth(50);
		cardCol.setMaxWidth(50);
		cardCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().card1;
					}
				});

		easyLoadCol.setPrefWidth(80);
		easyLoadCol.setMaxWidth(100);
		easyLoadCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().easyLoad1;
					}
				});

		easyLoadReturnCol.setPrefWidth(100);
		easyLoadReturnCol.setMaxWidth(200);
		easyLoadReturnCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().easyLoadReturn1;
					}
				});

		easyPaisaCol.setPrefWidth(100);
		easyPaisaCol.setMaxWidth(200);
		easyPaisaCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().easyPaisa1;
					}
				});

		easyPaisaReturnCol.setPrefWidth(100);
		easyPaisaReturnCol.setMaxWidth(200);
		easyPaisaReturnCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().easyPaisaReturn1;
					}
				});

		cashCol.setPrefWidth(50);
		cashCol.setMaxWidth(80);
		cashCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().cash1;
					}
				});

		expensesCol.setPrefWidth(100);
		expensesCol.setMaxWidth(100);
		expensesCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, Number>, ObservableValue<Number>>() {

					@Override
					public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().expenses1;
					}
				});

		commentCol.setPrefWidth(300);
		commentCol.setMaxWidth(400);
		commentCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<EntryTable, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<EntryTable, String> param) {
						// TODO Auto-generated method stub
						return param.getValue().getValue().comment1;
					}
				});

		search.textProperty().addListener((o, oldVal, newVal) -> {

			// TODO Auto-generated method stub
			entryTable.setPredicate(EntryTable ->

			EntryTable.getValue().name1.get().contains(newVal)// ||
			// EntryTable.getValue().comment1.get().contains(newVal)
					);

		});

		// Mouse Listener on Entry Table

		entryTable.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			try {

				tableSelectedValue();

			} catch (Exception tableEmpty) {

				// Notifications.create()
				// .title("Entry Table ")
				// .text("No row has been selected.")
				// .hideAfter(Duration.seconds(3))
				// .showWarning();
				return;
			}

		});

		// Key Lisnter on Entry Table

		entryTable.setOnKeyPressed(event -> {

			// Press Enter while moving with arrow keys on table
			if (event.getCode() == KeyCode.ENTER) {

				tableSelectedValue();
			}

			// Ctrl+D to delte entry
			if (event.isControlDown() && event.getCode() == KeyCode.D) {

				deleteEntryFromTable();
			}

		});

	}

	private void deleteEntryFromTable() {

		entryDatabaseManager.removeEntry(setFieldsValue());
		addListTable();
		setFieldsValueZero();

	}

	private void tableSelectedValue() {
		// TODO Auto-generated method stub
		Number value = entryTable.getSelectionModel().getSelectedItem().getValue().entry1.getValue();

		System.out.println(">>> Selected value:  " + value);

		entryField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().entry1.getValue().toString());
		dateCol.setText(entryTable.getSelectionModel().getSelectedItem().getValue().date1.getValue().toString());
		chosedEmployee
		.setValue(entryTable.getSelectionModel().getSelectedItem().getValue().name1.getValue().toString());
		hlrField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().hlr1.getValue().toString());
		simField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().sim1.getValue().toString());
		cardField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().card1.getValue().toString());
		easyloadField
		.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyLoad1.getValue().toString());
		easyloadReturnField.setText(
				entryTable.getSelectionModel().getSelectedItem().getValue().easyLoadReturn1.getValue().toString());
		easypaisaField
		.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyPaisa1.getValue().toString());
		easypaisaReturnField.setText(
				entryTable.getSelectionModel().getSelectedItem().getValue().easyPaisaReturn1.getValue().toString());
		cashField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().cash1.getValue().toString());
		expensesField
		.setText(entryTable.getSelectionModel().getSelectedItem().getValue().expenses1.getValue().toString());
		commentField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().comment1.getValue());

	}

	@SuppressWarnings("unchecked")
	public void addListTable() {

		tableDataList.clear();
		tableDataList = entryDatabaseManager.getAllEntries(tableDataList);
		final TreeItem<EntryTable> root = new RecursiveTreeItem<>(tableDataList, RecursiveTreeObject::getChildren);

		entryTable.getColumns().setAll(entryCol, dateCol, nameCol, hlrCol, simCol, cardCol, easyLoadCol,
				easyLoadReturnCol, easyPaisaCol, easyPaisaReturnCol, cashCol, expensesCol, commentCol);
		entryTable.setRoot(root);
		entryTable.setShowRoot(false);

	}

	public void setFieldsValueZero() {

		// Date todayDate = new Date();
		// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		entryField.setText("0");
		date.setValue(LocalDate.now());
		hlrField.setText("0");
		simField.setText("0");
		cardField.setText("0");
		easyloadField.setText("0");
		easyloadReturnField.setText("0");
		easypaisaField.setText("0");
		easypaisaReturnField.setText("0");
		cashField.setText("0");
		expensesField.setText("0");
		commentField.setText(" ");
	}

	public Entry setFieldsValue() {
		Entry entry = new Entry();

		int hlr = Integer.valueOf(hlrField.getText()), sim = Integer.valueOf(simField.getText()),
				card = Integer.valueOf(cardField.getText()), easyLoad = Integer.valueOf(easyloadField.getText()),
				easyLoadReturn = Integer.valueOf(easyloadReturnField.getText()),
				easyPaisa = Integer.valueOf(easypaisaField.getText()),
				easyPaisaReturn = Integer.valueOf(easypaisaReturnField.getText()),
				cash = Integer.valueOf(cashField.getText());

		entry.setEntryNumber(Integer.valueOf(entryField.getText()));
		entry.setDate(date.getValue().toString());

		if (chosedEmployee.getSelectionModel().getSelectedItem() == null) {
			Notifications.create().title("Entry Failed ").text("Please select the name of Employee.\n" + "  ")
			.hideAfter(Duration.seconds(5)).showWarning();
			return null;

		}

		entry.setSelectedEmployee(chosedEmployee.getSelectionModel().getSelectedItem().toString());
		entry.setHrl(hlr);
		entry.setSim(sim);
		entry.setCard(card);
		entry.setEasyLoad(easyLoad);
		entry.setEasyLoadReturn(easyLoadReturn);
		entry.setEasyPaisa(easyPaisa);
		entry.setEasyPaisaReturn(easyPaisaReturn);
		entry.setCash(cash);
		entry.setExpenses(Integer.valueOf(expensesField.getText()));
		entry.setComment(commentField.getText());

		// When entry will pass to employee the products will be deduct from
		// stock

		StockDatabase stockdbCon = new StockDatabase();

		Stock stock = new Stock();

		stockdbCon.getAllEntries(stock);

		hlr = stock.getHlr() - hlr;
		sim = stock.getSim() - sim;
		card = stock.getCard() - card;
		easyLoad = stock.getEasyLoad() - easyLoad;
		easyLoadReturn = stock.getEasyLoadReturn() - easyLoadReturn;
		easyPaisa = stock.getEasyPaisa() - easyPaisa;
		easyPaisaReturn = stock.getEasyPaisaReturn() - easyPaisaReturn;
		cash = stock.getCash() - cash;

		if (hlr < 0 || sim < 0 || card < 0 || easyLoad < 0 || easyLoadReturn < 0 || easyPaisa < 0 || easyPaisaReturn < 0
				|| cash < 0) {

			Notifications.create().title("Stock ")
			.text("Please check your stock you don't have\n" + "sufficient product to pass entry.")
			.hideAfter(Duration.seconds(5)).showError();

			stock.setHlr(stock.getHlr());
			stock.setSim(stock.getSim());
			stock.setCard(stock.getCard());
			stock.setEasyLoad(stock.getEasyLoad());
			stock.setEasyLoadReturn(stock.getEasyLoadReturn());
			stock.setEasyPaisa(stock.getEasyPaisa());
			stock.setEasyPaisaReturn(stock.getEasyPaisaReturn());
			stock.setCash(stock.getCash());

			stockdbCon.updateStock(stock);

			return null;

		}

		stock.setHlr(hlr);
		stock.setSim(sim);
		stock.setCard(card);
		stock.setEasyLoad(easyLoad);
		stock.setEasyLoadReturn(easyLoadReturn);
		stock.setEasyPaisa(easyPaisa);
		stock.setEasyPaisaReturn(easyPaisaReturn);
		stock.setCash(cash);

		stockdbCon.updateStock(stock);

		return entry;
	}

	public static void setEntryNumber(String entryNumber) {
		entryField.setText(entryNumber);
	}

}
