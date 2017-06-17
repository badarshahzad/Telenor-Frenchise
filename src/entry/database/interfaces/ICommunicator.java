package entry.database.interfaces;

import model.Entry;

public interface ICommunicator
{

	public void saveEntry(Entry entry);
	public void editEntry(Entry entry);
}

