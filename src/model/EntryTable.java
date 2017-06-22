package model;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class EntryTable extends RecursiveTreeObject<EntryTable> {
	
	public ObservableValue<Number> entry1;
	public StringProperty date1;
	public StringProperty name1; 
	public ObservableValue<Number> hlr1;
	public ObservableValue<Number> sim1;
	public ObservableValue<Number> card1;
	public ObservableValue<Number> easyLoad1;
	public ObservableValue<Number> easyLoadReturn1;
	public ObservableValue<Number> easyPaisa1;
	public ObservableValue<Number> easyPaisaReturn1;
	public ObservableValue<Number> cash1;
	public ObservableValue<Number> expenses1;
	public StringProperty comment1;
	
	public EntryTable(int entry,String date, String name,int hlr, int sim, int card, int easyLoad, int easyLoadReturn, int easyPaisa
			,int easyPaisaReturn,int cash, int expenses,String comment) {
		
		
		this.entry1 = new SimpleIntegerProperty( entry);
		this.date1  = new SimpleStringProperty(date);
		this.name1	= new SimpleStringProperty(name);
		this.hlr1	= new SimpleIntegerProperty(hlr);
		this.sim1	= new SimpleIntegerProperty(sim);
		this.card1	= new SimpleIntegerProperty(card);
		this.easyLoad1	= new SimpleIntegerProperty(easyLoad);
		this.easyLoadReturn1 = new SimpleIntegerProperty(easyLoad);
		this.easyPaisa1	= new SimpleIntegerProperty(easyPaisa);
		this.easyPaisaReturn1	= new SimpleIntegerProperty(easyPaisaReturn);
		this.cash1	= new SimpleIntegerProperty(cash);
		this.expenses1	= new SimpleIntegerProperty(expenses);
		this.comment1 = new SimpleStringProperty(comment);
	}


}

