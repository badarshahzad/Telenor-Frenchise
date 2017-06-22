package employee.database.interfaces;

import javafx.collections.ObservableList;
import model.Entry;
import model.EntryTable;
import model.Employee;
import model.EmployeeTable;

public interface EmpCrud {

	
	public void addEmp(Employee entry);
	public void removeEmp(Employee keyword);
	public ObservableList<EmployeeTable> getAllEntries(ObservableList<EmployeeTable> tableDataList);
	public void updateEntry(Employee entry);
	public boolean search(String keyword);
	
}
