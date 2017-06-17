package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.Position;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import database.EntryDatabaseManager;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import model.Entry;

public class MainController implements Initializable{


    @FXML
    private BorderPane mainBpane;

    @FXML
    private VBox paneForChart;

    @FXML
    private JFXComboBox<String> chosedEmployee;
    
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
    
    private JFXTreeTableColumn<EntryTable, Number> entryCol  = new JFXTreeTableColumn<EntryTable,Number>("Entry");
    private JFXTreeTableColumn<EntryTable, String> nameCol = new JFXTreeTableColumn<EntryTable, String>("Name");
    private JFXTreeTableColumn<EntryTable, Number> hlrCol = new JFXTreeTableColumn<EntryTable, Number>("Hlr");
    private JFXTreeTableColumn<EntryTable, Number> simCol = new JFXTreeTableColumn<EntryTable, Number>("Sim");
    private JFXTreeTableColumn<EntryTable, Number> cardCol = new JFXTreeTableColumn<EntryTable, Number>("Card");
    private JFXTreeTableColumn<EntryTable, Number> easyLoadCol = new JFXTreeTableColumn<EntryTable, Number>("Easyload");
    private JFXTreeTableColumn<EntryTable, Number> easyLoadReturnCol = new JFXTreeTableColumn<EntryTable, Number>("Easyload Return");
    private JFXTreeTableColumn<EntryTable, Number> easyPaisaCol = new JFXTreeTableColumn<EntryTable, Number>("Easypaisa");
    private JFXTreeTableColumn<EntryTable, Number> easyPaisaReturnCol = new JFXTreeTableColumn<EntryTable, Number>("Easypaisa Return");
    private JFXTreeTableColumn<EntryTable, Number> cashCol = new JFXTreeTableColumn<EntryTable, Number>("Cash");
    private JFXTreeTableColumn<EntryTable, Number> expensesCol = new JFXTreeTableColumn<EntryTable, Number>("Expenses");
    
    ObservableList<EntryTable> tableDataList = FXCollections.observableArrayList();
    
    
    //Database objects will created 
    
    EntryDatabaseManager entryDatabaseManager ;
	
	Entry entry = new Entry();
    public MainController() {
		// TODO Auto-generated constructor stub
    	
    	entryDatabaseManager = new EntryDatabaseManager();
		tableDataList = entryDatabaseManager.getAllEntries(tableDataList);
		//chosedEmployee.getSelectionModel().select(0);
    	
	}
     
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		setFieldsValueZero();
		addListTable();

		// Buttons listeneres 
		
		newBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
			
		
			try{
			
			entryDatabaseManager.addEntry(setFieldsValue());
			addListTable();
			
			} catch(Exception ex){
				
				Notifications.create()
				.title("Entry Failed ")
				.text("You entry is faild due to invalid input.\n"
						+ "Please give valid input")
				.hideAfter(Duration.seconds(5))
				.showWarning();
			
			}
			
		});
		
		clearBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{

			setFieldsValueZero();
			
		});
		
		editBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
			
			entryDatabaseManager.updateEntry(setFieldsValue());
			addListTable();
		});
		
		deleteBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
		});
		
		searchBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
		});
		
		detailsBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
		});

		refreshBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
		});
		
		excelBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{	
		});
		
		
		// Employee Name selected Combo Box 
		
		chosedEmployee.getSelectionModel().select(0);
		chosedEmployee.setItems(entry.getNameListEmployes());
		
		
		//Table Colums name and values setting
	
		entryCol.setPrefWidth(100);
		entryCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {
			
			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().entry1;
			}
		});
		nameCol.setPrefWidth(100);
		nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<EntryTable, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().name1;
			}
		});
		
		hlrCol.setPrefWidth(100);
		hlrCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().hlr1;
			}
		});
		
		simCol.setPrefWidth(100);
		simCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().sim1;
			}
		});
		
		cardCol.setPrefWidth(100);
		cardCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().card1;
			}
		});
		
	
		easyLoadCol.setPrefWidth(100);
		easyLoadCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().easyLoad1;
			}
		});
		
		easyLoadReturnCol.setPrefWidth(100);
		easyLoadReturnCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().easyLoadReturn1;
			}
		});
		
		easyPaisaCol.setPrefWidth(100);
		easyPaisaCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().easyPaisa1;
			}
		});
		
		easyPaisaReturnCol.setPrefWidth(100);
		easyPaisaReturnCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().easyPaisaReturn1;
			}
		});
		
		cashCol.setPrefWidth(100);
		cashCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().cash1;
			}
		});
		
		
		expensesCol.setPrefWidth(100);
		expensesCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EntryTable,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<EntryTable, Number> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().expenses1;
			}
		});
		
			
		
		search.textProperty().addListener((o,oldVal,newVal )->{
			entryTable.setPredicate(EntryTable -> 	
			EntryTable.getValue().name1.get().contains(newVal));
			});
			
					
		entryTable.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{

			try{
				Number value = entryTable.getSelectionModel().getSelectedItem().getValue().entry1.getValue();

				System.out.println(">>> Selected value:  "+value);
				
				chosedEmployee.setValue(entryTable.getSelectionModel().getSelectedItem().getValue().name1.getValue().toString());
				hlrField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().hlr1.getValue().toString());
				simField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().sim1.getValue().toString());
				cardField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().card1.getValue().toString());
				easyloadField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyLoad1.getValue().toString());
				easyloadReturnField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyLoadReturn1.getValue().toString());
				easypaisaField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyPaisa1.getValue().toString());
				easypaisaReturnField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().easyPaisaReturn1.getValue().toString());
				cashField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().cash1.getValue().toString());
				expensesField.setText(entryTable.getSelectionModel().getSelectedItem().getValue().expenses1.getValue().toString());

			}catch (Exception tableEmpty){

				Notifications.create()
				.title("History ")
				.text("No row has been selected or you have selected \n"
						+ "same row again in history table.")
				.hideAfter(Duration.seconds(3))
				.showWarning();
				return;
			}

		});

					
			
		
		//options.add("Badar");
		//employesList.setItems(options);
		//setEmployesList(employesList);
		
		//table.setItems(list);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void addListTable(){
		
		tableDataList.clear();
		tableDataList = entryDatabaseManager.getAllEntries(tableDataList);
		final TreeItem<EntryTable> root = new RecursiveTreeItem<>(tableDataList,RecursiveTreeObject::getChildren);

		entryTable.getColumns().setAll(
				entryCol,
				nameCol,
				hlrCol,
				simCol,
				cardCol,
				easyLoadCol,
				easyLoadReturnCol,
				easyPaisaCol,
				easyPaisaReturnCol,
				cashCol,
				expensesCol);
		entryTable.setRoot(root);
		entryTable.setShowRoot(false);
		
	}
	
	public void setFieldsValueZero(){
		
		hlrField.setText("0");
		simField.setText("0");
		cardField.setText("0");
		easyloadField.setText("0");
		easyloadReturnField.setText("0");
		easypaisaField.setText("0");
		easypaisaReturnField.setText("0");
		cashField.setText("0");
		expensesField.setText("0");
	}
	
	public Entry setFieldsValue(){
		Entry entry = new Entry();
		
		entry.setEntryNumber((int) entryTable.getSelectionModel().getSelectedItem().getValue().entry1.getValue());
		entry.setSelectedEmployee(chosedEmployee.getSelectionModel().getSelectedItem().toString());
		entry.setHrl(Integer.valueOf(hlrField.getText()));
		entry.setSim(Integer.valueOf(simField.getText()));
		entry.setCard(Integer.valueOf(cardField.getText()));
		entry.setEasyLoad(Integer.valueOf(easyloadField.getText()));
		entry.setEasyLoadReturn(Integer.valueOf(easyloadReturnField.getText()));
		entry.setEasyPaisa(Integer.valueOf(easypaisaField.getText()));
		entry.setEasyPaisaReturn(Integer.valueOf(easypaisaReturnField.getText()));
		entry.setCash(Integer.valueOf(cashField.getText()));
		entry.setExpenses(Integer.valueOf(expensesField.getText()));
		
		return entry;
	}


}



