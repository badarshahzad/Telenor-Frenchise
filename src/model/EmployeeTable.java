package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class EmployeeTable {

	ObservableValue<Number> empId	 ;
	StringProperty empName			 ;
	StringProperty empStatus		 ;
	StringProperty empAddress		 ;
	StringProperty empCNIC				 ;
	StringProperty empCellNumber	 ;
	ObservableValue<Number> empSalary;

	
	public EmployeeTable(int empId,String empName,String empStatus,String empAddress,String empCNIC,
			String empCellNumber, int empSalary){
		
		
		this.empId		= new SimpleIntegerProperty( empId);
		this.empName	= new SimpleStringProperty(empName);
		this.empStatus	= new SimpleStringProperty(empStatus);
		this.empAddress	= new SimpleStringProperty(empAddress);
		this.empCNIC	= new SimpleStringProperty(empCNIC);
		this.empCellNumber = new SimpleStringProperty(empCellNumber);
		this.empSalary 	= new SimpleIntegerProperty(empSalary);
	}

}
