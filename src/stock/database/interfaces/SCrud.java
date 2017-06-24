package stock.database.interfaces;
import javafx.collections.ObservableList;
import model.EmployeeTable;
import model.Stock;
public interface SCrud {
	
	public void addInStock(Stock s);
	public void updateStock(Stock s);
	public Stock getAllEntries(Stock s);

}
