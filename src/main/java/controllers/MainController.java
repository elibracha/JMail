package controllers;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import module.beans.EmailMessageBean;

public class MainController implements Initializable {

	@FXML
	private WebView webRender;

	@FXML
	private TableColumn<EmailMessageBean, String> subjectCol, senderCol, dateCol;

	@FXML
	private TableColumn<EmailMessageBean, Double> sizeCol;

	@FXML
	private TableView<EmailMessageBean> tableView;

	final ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
			new EmailMessageBean("aaa@yahoo.com", "Hello from Sefu!!!", 5000, Calendar.getInstance().getTime().toString()),
			new EmailMessageBean("bbb@yahoo.com", "Hello from Barosanu", 200, Calendar.getInstance().getTime().toString()),
			new EmailMessageBean( "ccc@yahoo.com", "Hello from Sefu!!!asdas", 10, Calendar.getInstance().getTime().toString()),
			new EmailMessageBean("ddd@yahoo.com", "Hello from Barosanuasdasas", 6300,Calendar.getInstance().getTime().toString())

	);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("subject"));
		senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("from"));
		dateCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("date"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, Double>("size"));
		
		tableView.setItems(data);
	}

}
