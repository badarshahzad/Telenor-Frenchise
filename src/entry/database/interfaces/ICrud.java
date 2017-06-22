package entry.database.interfaces;

import javafx.collections.ObservableList;
import model.Entry;
import model.EntryTable;
public interface ICrud {
	
	public void addEntry(Entry entry);
	public void removeEntry(Entry keyword);
	public ObservableList<EntryTable> getAllEntries(ObservableList<EntryTable> tableDataList);
	public void updateEntry(Entry entry);
	public boolean search(String keyword);
	

}
