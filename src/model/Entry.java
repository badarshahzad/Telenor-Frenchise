package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Entry {

	int entryNumber ;
	String selectedEmployee = null;


	int hrl=0,
			sim=0,
			card=0,
			easyLoad=0,
			easyLoadReturn = 0,
			easyPaisa=0,
			easyPaisaReturn=0,
			cash=0,
			expenses=0;

	public ObservableList<String> nameListEmployes =  FXCollections.observableArrayList("sudo1","sudo2","sudo3");
	
	/**
	 * @return the selectedEmployee
	 */
	public String getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * @param selectedEmployee the selectedEmployee to set
	 */
	public void setSelectedEmployee(String selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	
	/**
	 * @return the entryNumber
	 */
	public int getEntryNumber() {
		return entryNumber;
	}
	
	/**
	 * @param entryNumber the entryNumber to set
	 */
	public void setEntryNumber(int entryNumber) {
		this.entryNumber = entryNumber;
	}
	
	/**
	 * @return the hrl
	 */
	
	public int getHrl() {
		return hrl;
	}
	
	/**
	 * @param hrl the hrl to set
	 */
	
	public void setHrl(int hrl) {
		this.hrl = hrl;
	}
	
	/**
	 * @return the sim
	 */
	
	public int getSim() {
		return sim;
	}
	
	/**
	 * @param sim the sim to set
	 */
	
	public void setSim(int sim) {
		this.sim = sim;
	}
	
	/**
	 * @return the card
	 */
	
	public int getCard() {
		return card;
	}
	
	/**
	 * @param card the card to set
	 */
	
	public void setCard(int card) {
		this.card = card;
	}
	
	/**
	 * @return the easyLoad
	 */
	
	public int getEasyLoad() {
		return easyLoad;
	}
	
	/**
	 * @param easyLoad the easyLoad to set
	 */
	
	public void setEasyLoad(int easyLoad) {
		this.easyLoad = easyLoad;
	}
	
	/**
	 * @return the easyLoadReturn
	 */
	public int getEasyLoadReturn() {
		return easyLoadReturn;
	}

	/**
	 * @param easyLoadReturn the easyLoadReturn to set
	 */
	public void setEasyLoadReturn(int easyLoadReturn) {
		this.easyLoadReturn = easyLoadReturn;
	}

	/**
	 * @return the easyPaisa
	 */
	
	public int getEasyPaisa() {
		return easyPaisa;
	}
	
	/**
	 * @param easyPaisa the easyPaisa to set
	 */
	
	public void setEasyPaisa(int easyPaisa) {
		this.easyPaisa = easyPaisa;
	}
	
	/**
	 * @return the easyPaisaReturn
	 */
	
	public int getEasyPaisaReturn() {
		return easyPaisaReturn;
	}
	
	/**
	 * @param easyPaisaReturn the easyPaisaReturn to set
	 */
	
	public void setEasyPaisaReturn(int easyPaisaReturn) {
		this.easyPaisaReturn = easyPaisaReturn;
	}
	
	/**
	 * @return the cash
	 */
	
	public int getCash() {
		return cash;
	}
	
	/**
	 * @param cash the cash to set
	 */
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	/**
	 * @return the expenses
	 */
	
	public int getExpenses() {
		return expenses;
	}
	
	/**
	 * @param expenses the expenses to set
	 */
	
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	
	/**
	 * @return the nameListEmployes
	 */
	
	public ObservableList<String> getNameListEmployes() {
		return nameListEmployes;
	}
	
	/**
	 * @param nameListEmployes the nameListEmployes to set
	 */
	
	public void setNameListEmployes(ObservableList<String> nameListEmployes) {
		this.nameListEmployes = nameListEmployes;
	}
	
}
