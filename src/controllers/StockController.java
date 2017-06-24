package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import database.StockDatabase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Stock;

public class StockController implements Initializable {

	@FXML
	private Label hlrLbl;

	@FXML
	private Label simLbl;

	@FXML
	private Label cardLbl;

	@FXML
	private Label easyLoadLbl;

	@FXML
	private Label easyLoadReturnLbl;

	@FXML
	private Label easyPaisaLbl;

	@FXML
	private Label easyPaisaReturnLbl;

	@FXML
	private Label cashLbl;

	@FXML
	private AnchorPane fieldsAnchor;

	@FXML
	private TextField stockHlrField;

	@FXML
	private TextField stockSimField;

	@FXML
	private TextField stockCardField;

	@FXML
	private TextField stockEasyloadField;

	@FXML
	private TextField stockEasyloadReturnField;

	@FXML
	private TextField stockEasypaisaField;

	@FXML
	private TextField stockEasypaisaReturnField;

	@FXML
	private TextField stockCashField;

	@FXML
	private JFXButton newBt;

	@FXML
	private JFXButton clearBt;

	int hlr = 0, sim = 0, card = 0, easyLoad = 0, easyLoadReturn = 0, easyPaisa = 0, easyPaisaReturn = 0, cash = 0;

	public StockDatabase stockDatabase;

	public StockController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		stockDatabase = new StockDatabase();

		setFieldsValueZero();
		updateStockValues();

		newBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			try {
				stockDatabase.updateStock(stockUpdated());

				// stockSimField,stockCardField,stockEasyloadField,stockEasyloadReturnField
				// stockEasypaisaField,stockEasypaisaReturnField,stockCashField

				hlrLbl.setText("Hlr:	" + hlr);
				simLbl.setText("Sim:	" + sim);
				cardLbl.setText("Card:	" + card);
				easyLoadLbl.setText("EasyLoad:	" + easyLoad);
				easyLoadReturnLbl.setText("EasyLoad Return:	" + easyLoadReturn);
				easyPaisaLbl.setText("EasyPaisa:	" + easyPaisa);
				easyPaisaReturnLbl.setText("EasyPaisaReturn:	" + easyPaisaReturn);
				cashLbl.setText("Cash:	" + cash);

				setFieldsValueZero();

				// stockSimField,stockCardField,stockEasyloadField,stockEasyloadReturnField
				// stockEasypaisaField,stockEasypaisaReturnField,stockCashField

				// entryDatabaseManager.addEntry(setFieldsValue());
				// addListTable();

			} catch (Exception ex) {

				Notifications.create().title("Entry Failed ").text("Please enter valid values.\n" + "  ")
						.hideAfter(Duration.seconds(5)).showWarning();

			}

		});

		clearBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

			setFieldsValueZero();
			updateStockValues();

		});

	}

	private Stock stockUpdated() {
		// TODO Auto-generated method stub

		Stock stock = new Stock();

		hlr = Integer.parseInt(hlrLbl.getText().replaceAll("[^0-9]", ""));
		sim = Integer.parseInt(simLbl.getText().replaceAll("[^0-9]", ""));
		card = Integer.parseInt(cardLbl.getText().replaceAll("[^0-9]", ""));
		easyLoad = Integer.parseInt(easyLoadLbl.getText().replaceAll("[^0-9]", ""));
		easyLoadReturn = Integer.parseInt(easyLoadReturnLbl.getText().replaceAll("[^0-9]", ""));
		easyPaisa = Integer.parseInt(easyPaisaLbl.getText().replaceAll("[^0-9]", ""));
		easyPaisaReturn = Integer.parseInt(easyPaisaReturnLbl.getText().replaceAll("[^0-9]", ""));
		cash = Integer.parseInt(cashLbl.getText().replaceAll("[^0-9]", ""));

		hlr = Integer.parseInt(stockHlrField.getText()) + hlr;
		sim = Integer.parseInt(stockSimField.getText()) + sim;
		card = Integer.parseInt(stockCardField.getText()) + card;
		easyLoad = Integer.parseInt(stockEasyloadField.getText()) + easyLoad;
		easyLoadReturn = Integer.parseInt(stockEasyloadReturnField.getText()) + easyLoadReturn;
		easyPaisa = Integer.parseInt(stockEasypaisaField.getText()) + easyPaisa;
		easyPaisaReturn = Integer.parseInt(stockEasypaisaReturnField.getText()) + easyPaisaReturn;
		cash = Integer.parseInt(stockCashField.getText()) + cash;

		stock.setHlr(hlr);
		stock.setSim(sim);
		stock.setCard(card);
		stock.setEasyLoad(easyLoad);
		stock.setEasyLoadReturn(easyLoadReturn);
		stock.setEasyPaisa(easyPaisa);
		stock.setEasyPaisaReturn(easyPaisaReturn);
		stock.setCash(cash);

		return stock;
	}

	public void setFieldsValueZero() {

		stockHlrField.setText("0");
		stockSimField.setText("0");
		stockCardField.setText("0");
		stockEasyloadField.setText("0");
		stockEasyloadReturnField.setText("0");
		stockEasypaisaField.setText("0");
		stockEasypaisaReturnField.setText("0");
		stockCashField.setText("0");

	}

	public void updateStockValues() {

		Stock stock = new Stock();

		stockDatabase.getAllEntries(stock);

		hlrLbl.setText("Hlr:");
		simLbl.setText("Sim:");
		cardLbl.setText("Card:");
		easyLoadLbl.setText("EasyLoad:");
		easyLoadReturnLbl.setText("EasyLoad Return:");
		easyPaisaLbl.setText("EasyPaisa:");
		easyPaisaReturnLbl.setText("EasyPaisaReturn:");
		cashLbl.setText("Cash:");

		System.out.println("Hlr updated value: " + stock.getHlr());

		hlrLbl.setText("Hlr:	" + stock.getHlr());
		simLbl.setText("Sim:	" + stock.getSim());
		cardLbl.setText("Card:	" + stock.getCard());
		easyLoadLbl.setText("EasyLoad:	" + stock.getEasyLoad());
		easyLoadReturnLbl.setText("EasyLoad Return:	" + stock.getEasyLoadReturn());
		easyPaisaLbl.setText("EasyPaisa:	" + stock.getEasyPaisa());
		easyPaisaReturnLbl.setText("EasyPaisaReturn:	" + stock.getEasyPaisaReturn());
		cashLbl.setText("Cash:	" + stock.getCash());

	}

	public JFXButton getClearBt() {
		return clearBt;
	}

	public void setClearBt(JFXButton clearBt) {
		this.clearBt = clearBt;
	}
}
