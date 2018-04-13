package module;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmailMessageBean extends AbstractTableItem{

	public static final int KB = 1024;
	public static final int MB = 1048576;
	public static Map<String, Integer> map = new HashMap<>();
	
	private SimpleStringProperty from;
	private SimpleStringProperty subject;
	private SimpleIntegerProperty size;
	private SimpleStringProperty date;
	private SimpleStringProperty content;
	
	public EmailMessageBean(String from, String subject, int size, String date, String content, boolean isRead) {
		super(isRead);
		this.from = new SimpleStringProperty(from);
		this.subject = new SimpleStringProperty(subject);
		this.size = new SimpleIntegerProperty(size);
		this.date = new SimpleStringProperty(date);
		this.content = new SimpleStringProperty(content);
	}

	public String getFrom() {
		return from.get();
	}

	public String getSubject() {
		return subject.get();
	}

	public String getSize() {
		return formatSize(size.get());
	}

	public String getDate() {
		return date.get();
	}
	
	
	public String getContent() {
		return content.get();
	}

	private String formatSize(int size) {
		
		String result;
		
		if(size <= KB) {
			result = String.valueOf(size).concat("B");
		}else if(size <= MB){
			result = String.valueOf(size/1024).concat("KB");
		}else {
			result = String.valueOf(size/1048576).concat("MB");
		}
		
		map.put(result, size);
		
		return result;
	}
	
}
