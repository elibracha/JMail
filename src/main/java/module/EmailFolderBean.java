package module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import views.ViewFactory;

public class EmailFolderBean<T> extends TreeItem<String>  {

	private boolean topElement  = false;
	private int unreadMessageCount;
	private String name;
	@SuppressWarnings("unused")
	private String completeName;
	private ObservableList<EmailMessageBean> data = FXCollections.observableArrayList();
	
	/**
	 * Constructor for top elements
	 * @param value
	 */
	
	public EmailFolderBean(String value, int icon){
		super(value, ViewFactory.getInstance().resolveIcon(icon));
		this.name = value;
		this.completeName = value;
		data = null;
		topElement = true;
		this.setExpanded(true);
	}
	
	public EmailFolderBean(String value, int icon, String compleName){
		super(value, ViewFactory.getInstance().resolveIcon(icon));
		this.name = value;
		this.completeName = compleName;
	}
	
	private void updateValue(){
		if(unreadMessageCount > 0){
			this.setValue((String)(name + "(" + unreadMessageCount + ")"));
		}else{
			this.setValue(name);
		}
	}
	
	public void incrementUnreadMessagesCount(int newMessages){
		unreadMessageCount = unreadMessageCount + newMessages;
		updateValue();
	}
	
	public void decrementUnreadMessagesCount(){
		unreadMessageCount--;
		updateValue();
	}
	
	public void addEmail(EmailMessageBean message){
		data.add(message);
		if(!message.isRead()){
			incrementUnreadMessagesCount(1);
		}
	}
	
	public boolean isTopElement(){
		return topElement;
	}
	
	public ObservableList<EmailMessageBean> getData(){
		return data;
	}
	
	
	
}
