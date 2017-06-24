package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.EntryController;
import javafx.collections.ObservableList;
import model.EntryTable;
import model.Stock;
import stock.database.interfaces.SCrud;

public class StockDatabase extends DatabaseConnection implements SCrud {
	
	private static final String CREATE_Employee_TABLE = "CREATE TABLE if not exists stockTable"
			+ "(hlr int, "
			+ "sim int,"
			+ "card int,"
			+ "easyL int,"
			+ "easyLR int,"
			+ "easyP int,"
			+ "easyPR int,"
			+ "cash int)";
	
	
	
	public StockDatabase(){
		openConnection(CREATE_Employee_TABLE);
	}



	@Override
	public void addInStock(Stock s) {
		// TODO Auto-generated method stub
	
	}



	@Override
	public void updateStock(Stock s) {
		// TODO Auto-generated method stub

		try {
	          String sql = "INSERT or Replace into stockTable (hlr,sim,card,easyL,easyLR,easyP,easyPR,cash) "
	          		+ "VALUES (?,?,?,?,?,?,?,?)";
	          
	          prepStmt = connection.prepareStatement(sql);
	          prepStmt.setInt(1, s.getHlr());
	          prepStmt.setInt(2, s.getSim());
	          prepStmt.setInt(3, s.getCard());
	          prepStmt.setInt(4, s.getEasyLoad());
	          prepStmt.setInt(5, s.getEasyLoadReturn());
	          prepStmt.setInt(6, s.getEasyPaisa());
	          prepStmt.setInt(7, s.getEasyPaisaReturn());
	          prepStmt.setInt(8,s.getCash());
	        		  
	          prepStmt.executeUpdate();
	          

	         System.out.println(">>> Successfully insert query working"); 
	     } catch (SQLException ex) {
       
	    	 System.out.println("*** Error: insert query is not working");
	    	 ex.printStackTrace();
	    	 
	       }
		
		
	}



	@Override
	public Stock getAllEntries(Stock tableData) {
		// TODO Auto-generated method stub
		
	String sql = "SELECT * from stockTable";
		
		try {
			
			prepStmt = connection.prepareStatement(sql);
			ResultSet rs = 	prepStmt.executeQuery();
			
			int entryNumber = 0;
			while(rs.next()){
		
				tableData.setHlr(rs.getInt("hlr"));
				tableData.setSim(rs.getInt("sim"));
				tableData.setCard(rs.getInt("card"));
				tableData.setEasyLoad(rs.getInt("easyL"));
				tableData.setEasyLoadReturn(rs.getInt("easyLR"));
				tableData.setEasyPaisa(rs.getInt("easyP"));
				tableData.setEasyPaisaReturn(rs.getInt("easyPR"));
				tableData.setCash(rs.getInt("cash"));
			}
			prepStmt.close();
			
			return tableData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("*** Error: Getting all entries of result set query not working.");
		}
		return tableData;
		
	}

}
