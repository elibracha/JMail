package controllers;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import module.BoldableRowFactory;
import module.EmailFolderBean;
import module.EmailMessageBean;
import module.SimpleData;
import views.ViewFactory;

public class MainController extends AbstractController implements Initializable {
	
	public MainController(ModelAccess modelAccess) {
		super(modelAccess);
	}

	private MenuItem details = new MenuItem("details...");
	private MenuItem unread = new MenuItem("Mark Unread");
	private MenuItem read = new MenuItem("Mark Read");
	
	@FXML 
	private TreeView<String> treeView;
	
	@FXML
	private WebView webView;

	@FXML
	private TableColumn<EmailMessageBean, String> subjectCol, senderCol, dateCol, sizeCol;


	@FXML
	private TableView<EmailMessageBean> tableView;


	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ViewFactory factory = ViewFactory.getInstance();
		tableView.setRowFactory(new Callback<TableView<EmailMessageBean>, TableRow<EmailMessageBean>>() {
			@Override
			public TableRow<EmailMessageBean> call(TableView<EmailMessageBean> param) {
				return new BoldableRowFactory<>();
			}
		});
		subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("subject"));
		senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("from"));
		dateCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("date"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("size"));
		
		sizeCol.setComparator(new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return EmailMessageBean.map.get(o1).compareTo(EmailMessageBean.map.get(o2));
			}
		});
		
		int i = 0;

		EmailFolderBean<String> root = new EmailFolderBean<String>("", i++);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		
		EmailFolderBean<String> profile = new EmailFolderBean<>("elibracha45@gmail.com", i++, "elibracha45@gmail.com");
		EmailFolderBean<String> sentMail = new EmailFolderBean<>("Sent Mail",i++, "Sent Mail");
		EmailFolderBean<String> spam = new EmailFolderBean<>("Spam", i++, "Spam");
		EmailFolderBean<String> inbox = new EmailFolderBean<>("Inbox",i++, "Inbox");
		EmailFolderBean<String> drafts = new EmailFolderBean<>("Drafts",i++, "Drafts");
		EmailFolderBean<String> allMail = new EmailFolderBean<>("All Mail",i++, "AllMaill");
		EmailFolderBean<String> important = new EmailFolderBean<>("Important",i++, "Important");
		EmailFolderBean<String> trash = new EmailFolderBean<>("Trash",i++, "Trash");
		EmailFolderBean<String> starred = new EmailFolderBean<>("Starred",i++, "Starred");
	
		root.getChildren().add(profile);
		profile.getChildren().addAll(inbox,allMail, sentMail, drafts, important, starred, spam, trash);
		profile.setExpanded(true);
		
		inbox.getData().addAll(SimpleData.Inbox);
		sentMail.getData().addAll(SimpleData.Sent);
		spam.getData().addAll(SimpleData.Spam);
		drafts.getData().addAll(SimpleData.drafts);
		important.getData().addAll(SimpleData.important);
		trash.getData().addAll(SimpleData.trash);
		starred.getData().addAll(SimpleData.starred);
		allMail.getData().addAll(SimpleData.allmail);
		
		treeView.setOnMouseClicked(e ->{
			EmailFolderBean<String> item = (EmailFolderBean<String>)treeView.getSelectionModel().getSelectedItem();
			if(item != null && !item.isTopElement()){
				tableView.setItems(item.getData());
				getModelAccess().setSelectedFolder(item);
				getModelAccess().setSelectedMessage(null);
			}
		});
		tableView.setOnMouseClicked(e->{
			EmailMessageBean message = tableView.getSelectionModel().getSelectedItem();
			if(message != null){
				getModelAccess().setSelectedMessage(message);
				webView.getEngine().loadContent(message.getContent());
			}
		});
		
		tableView.setContextMenu(new ContextMenu(details, read, unread));
		
		details.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = new Stage();
				stage.setScene(factory.getDetailsScene());
				stage.show();
			}
			
		});
		
		unread.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getModelAccess().getSelectedMessage().getReadProperty().set(false);
				EmailMessageBean message = getModelAccess().getSelectedMessage();
		    	if(message != null){
		    		boolean value = message.isRead();
		    		if(!value) {
			    		message.setRead(false);
			    		EmailFolderBean<String> selectedFolder = getModelAccess().getSelectedFolder();
			    		if(selectedFolder != null){
			    			selectedFolder.incrementUnreadMessagesCount(1);
			    		}
		    		}
		    	}
			}
		});
		
		read.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				EmailMessageBean message = getModelAccess().getSelectedMessage();
	    		message.getReadProperty().set(true);
		    	if(message != null){
		    		boolean value = message.isRead();
		    		if(value) {
			    		message.setRead(true);
			    		EmailFolderBean<String> selectedFolder = getModelAccess().getSelectedFolder();
			    		if(selectedFolder != null){
			    			selectedFolder.decrementUnreadMessagesCount();
			    		}
		    		}
		    	}
			}
		});
		
	}
	
}
