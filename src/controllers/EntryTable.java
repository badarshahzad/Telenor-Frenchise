package controllers;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class EntryTable extends RecursiveTreeObject<EntryTable> {
	
	ObservableValue<Number> entry1;
	StringProperty date1;
	StringProperty name1; 
	ObservableValue<Number> hlr1;
	ObservableValue<Number> sim1;
	ObservableValue<Number> card1;
	ObservableValue<Number> easyLoad1;
	ObservableValue<Number> easyLoadReturn1;
	ObservableValue<Number> easyPaisa1;
	ObservableValue<Number> easyPaisaReturn1;
	ObservableValue<Number> cash1;
	ObservableValue<Number> expenses1;
	StringProperty comment1;
	
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

