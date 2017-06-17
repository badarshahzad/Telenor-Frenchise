package database;


import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;

import controllers.EntryTable;
import entry.database.interfaces.ICrud;
import model.Entry;
import javafx.collections.ObservableList;

public class EntryDatabaseManager implements ICrud{
	
	
	private static final String JDBC_DRIVER = "org.sqlite.JDBC";
	private static final String DB_URL = "jdbc:sqlite:~/History.db";
	private Connection connection;
	private Statement stmt;
	private PreparedStatement prepStmt ;
	
	private static final String CREATE_TABLE = "CREATE TABLE if not exists entryTable"
			+ "(entryId INTEGER PRIMARY KEY,"
			+ "empName varchar (30),"
			+ "hlr int, "
			+ "sim int,"
			+ "card int,"
			+ "easyL int,"
			+ "easyLR int,"
			+ "easyP int,"
			+ "easyPR int,"
			+ "cash int,"
			+ "expenses int)";
			
	public EntryDatabaseManager(){
		openConnection();
	}
	
	public void openConnection() {

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
	
	@Override
	public void addEntry(Entry entry) {
		// TODO Auto-generated method stub
		try {
	          String sql = "INSERT INTO entryTable (empName,hlr,sim,card,easyL,easyLR,easyP,easyPR,cash,expenses) "
	          		+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	          
	          prepStmt = connection.prepareStatement(sql);
	          prepStmt.setString(1, entry.getSelectedEmployee());
	          prepStmt.setInt(2, entry.getHrl());
	          prepStmt.setInt(3, entry.getSim());
	          prepStmt.setInt(4, entry.getCard());
	          prepStmt.setInt(5, entry.getEasyLoad());
	          prepStmt.setInt(6, entry.getEasyLoadReturn());
	          prepStmt.setInt(7, entry.getEasyPaisa());
	          prepStmt.setInt(8, entry.getEasyPaisaReturn());
	          prepStmt.setInt(9, entry.getCash());
	          prepStmt.setInt(10, entry.getExpenses()
	        		  );
	          prepStmt.executeUpdate();
	          

	         System.out.println(">>> Successfully insert query working"); 
	     } catch (SQLException ex) {
         
	    	 System.out.println("*** Error: insert query is not working");
	    	 ex.printStackTrace();
	    	 
	       }
		
	}

	@Override
	public void removeEntry(String keyword) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<EntryTable> getAllEntries(ObservableList<EntryTable> tableDataList) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * from entryTable";
		
		try {
			
			prepStmt = connection.prepareStatement(sql);
			ResultSet rs = 	prepStmt.executeQuery();
			
			while(rs.next()){
		
				tableDataList.add(new EntryTable(rs.getInt("entryId"),rs.getString("empName"),rs.getInt("hlr"),rs.getInt("sim"),rs.getInt("card")
						,rs.getInt("easyL"),rs.getInt("easyLR"),rs.getInt("easyP"),rs.getInt("easyPR")
						,rs.getInt("cash"),rs.getInt("expenses")));
				
				

			}
			prepStmt.close();
			
			
			
			return tableDataList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("*** Error: Getting all entries of result set query not working.");
		}
		return tableDataList;
		
	}

	@Override
	public void updateEntry(Entry entry) {
		// TODO Auto-generated method stub
		
		String sql = "Insert or Replace into entryTable (entryId,empName,hlr,sim,card,easyL,easyLR,easyP,easyPR,cash,expenses) "
	          		+ "VALUES (?,?,?,?,?,?,?,?,?,? ,( SELECT entryId FROM entryTable WHERE entryId = ?))";
				
		
		try {

			 prepStmt = connection.prepareStatement(sql);
			 prepStmt.setInt(1, entry.getEntryNumber());
	          prepStmt.setString(2, entry.getSelectedEmployee());
	          prepStmt.setInt(3, entry.getHrl());
	          prepStmt.setInt(4, entry.getSim());
	          prepStmt.setInt(5, entry.getCard());
	          prepStmt.setInt(6, entry.getEasyLoad());
	          prepStmt.setInt(7, entry.getEasyLoadReturn());
	          prepStmt.setInt(8, entry.getEasyPaisa());
	          prepStmt.setInt(9, entry.getEasyPaisaReturn());
	          prepStmt.setInt(10, entry.getCash());
	          prepStmt.setInt(11, entry.getExpenses());
	        		  
	          prepStmt.executeUpdate();
	          
	         
	          
	          System.out.println("Selected employee values"+ entry.getSelectedEmployee());

	         System.out.println(">>> Successfully update query working");
	          } catch (SQLException e) {
					// TODO Auto-generated catch block
	        	  System.out.println("*** Error : update query working");
					e.printStackTrace();
				}
		
	}

	@Override
	public boolean search(String keyword) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
