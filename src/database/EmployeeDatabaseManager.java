package database;

public class EmployeeDatabaseManager extends DatabaseConnection{

	private static final String CREATE_Employee_TABLE = "CREATE TABLE if not exists empTable"
			+ "(empId INTEGER PRIMARY KEY,"
			+ "empName varchar(50),"
			+ "empStatus varchar (50),"
			+ "empCNIC int,"
			+ "empCellNumber int, "
			+ "empAddress int,"
			+ "empSalary int)";
	
	
	public EmployeeDatabaseManager(){
		openConnection(CREATE_Employee_TABLE);
	}
}

