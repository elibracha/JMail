package module;

import javafx.beans.property.SimpleBooleanProperty;

public abstract class AbstractTableItem {

	private SimpleBooleanProperty read;

	
	public AbstractTableItem(boolean read) {
		super();
		setRead(read);
	}
	
	public SimpleBooleanProperty getReadProperty() {
		return read;
	}
	
	public boolean isRead() {
		return read.get();
	}

	public void setRead(boolean read) {
		this.read = new SimpleBooleanProperty(read);
	}
	
	
}
