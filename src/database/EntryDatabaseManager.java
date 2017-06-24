package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.EntryController;
import entry.database.interfaces.ICrud;
import javafx.collections.ObservableList;
import model.Entry;
import model.EntryTable;

public class EntryDatabaseManager extends DatabaseConnection implements ICrud {

	private static final String CREATE_Entry_TABLE = "CREATE TABLE if not exists entryTable"
			+ "(entryId INTEGER PRIMARY KEY," + "date varchar (30)," + "empName varchar (30)," + "hlr int, "
			+ "sim int," + "card int," + "easyL int," + "easyLR int," + "easyP int," + "easyPR int," + "cash int,"
			+ "expenses int," + "comment text)";

	public EntryDatabaseManager() {
		openConnection(CREATE_Entry_TABLE);
	}

	@Override
	public void addEntry(Entry entry) {
		// TODO Auto-generated method stub

		if (entry == null) {
			System.out.println("Wapis ghar q k khali");
			return;
		}

		try {
			String sql = "INSERT INTO entryTable (date,empName,hlr,sim,card,easyL,easyLR,easyP,easyPR,cash,expenses,comment) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, entry.getDate());
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
			prepStmt.setString(12, entry.getComment());

			prepStmt.executeUpdate();

			System.out.println(">>> Successfully insert query working");
		} catch (SQLException ex) {

			System.out.println("*** Error: insert query is not working");
			ex.printStackTrace();

		}

	}

	@Override
	public void removeEntry(Entry entry) {
		// TODO Auto-generated method stub

		String sql = "DELETE from entryTable WHERE entryId = ?";

		try {

			prepStmt = connection.prepareStatement(sql);
			prepStmt.setInt(1, entry.getEntryNumber());
			prepStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("*** Delete Entry is not working.");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<EntryTable> getAllEntries(ObservableList<EntryTable> tableDataList) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM entryTable ORDER BY entryId DESC";

		try {

			prepStmt = connection.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();

			int entryNumber = 0;
			while (rs.next()) {

				tableDataList.add(new EntryTable(rs.getInt("entryId"), rs.getString("date"), rs.getString("empName"),
						rs.getInt("hlr"), rs.getInt("sim"), rs.getInt("card"), rs.getInt("easyL"), rs.getInt("easyLR"),
						rs.getInt("easyP"), rs.getInt("easyPR"), rs.getInt("cash"), rs.getInt("expenses"),
						rs.getString("comment")));

				// this entryNumber is a variable to remember the last entry and
				// to show on main screen
				entryNumber = rs.getInt("entryId");
			}
			prepStmt.close();

			// the last entry number is setting into main screen
			EntryController.setEntryNumber(String.valueOf(entryNumber));

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

		String sql = "Insert or Replace into entryTable (entryId,date,empName,hlr,sim,card,easyL,easyLR,easyP,easyPR,cash,expenses,comment) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,? ,( SELECT entryId FROM entryTable WHERE entryId = ?))";

		try {

			prepStmt = connection.prepareStatement(sql);
			prepStmt.setInt(1, entry.getEntryNumber());
			prepStmt.setString(2, entry.getDate());
			prepStmt.setString(3, entry.getSelectedEmployee());
			prepStmt.setInt(4, entry.getHrl());
			prepStmt.setInt(5, entry.getSim());
			prepStmt.setInt(6, entry.getCard());
			prepStmt.setInt(7, entry.getEasyLoad());
			prepStmt.setInt(8, entry.getEasyLoadReturn());
			prepStmt.setInt(9, entry.getEasyPaisa());
			prepStmt.setInt(10, entry.getEasyPaisaReturn());
			prepStmt.setInt(11, entry.getCash());
			prepStmt.setInt(12, entry.getExpenses());
			prepStmt.setString(13, entry.getComment());

			prepStmt.executeUpdate();

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
