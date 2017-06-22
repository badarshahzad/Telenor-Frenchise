package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
	
	public Connection connection ;
	public PreparedStatement prepStmt;
	
	public void openConnection(String CREATE_TABLE) {

		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:History.db");
			//stmt = connection.createStatement();
			prepStmt = connection.prepareStatement(CREATE_TABLE);
			prepStmt.executeUpdate();
			
			System.out.println(">>> Successfully driver attach and table created.");
		}catch(Exception e){
			System.out.println("*** Error: Database Driver is not working and Statment is not executed. ");
		}
	}
}
