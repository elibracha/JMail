package module.beans;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmailMessageBean {

	private SimpleStringProperty from;
	private SimpleStringProperty subject;
	private SimpleDoubleProperty size;
	private SimpleStringProperty date;
	
	public EmailMessageBean(String from, String subject, double size, String date) {
		this.from = new SimpleStringProperty(from);
		this.subject = new SimpleStringProperty(subject);
		this.size = new SimpleDoubleProperty(size);
		this.date = new SimpleStringProperty(date);
	}

	public String getFrom() {
		return from.get();
	}

	public String getSubject() {
		return subject.get();
	}

	public double getSize() {
		return size.get();
	}

	public String getDate() {
		return date.get();
	}
	
	
}
