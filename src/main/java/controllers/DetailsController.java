package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import module.EmailMessageBean;

public class DetailsController extends AbstractController implements Initializable {

	public DetailsController(ModelAccess modelAccess) {
		super(modelAccess);
	}
	
	@FXML
	private WebView webView;
	
	@FXML
	private Label subject, from;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		EmailMessageBean message = getModelAccess().getSelectedMessage();
		subject.setText(subject.getText().concat(message.getSubject()));
		from.setText(from.getText().concat(message.getFrom()));
		webView.getEngine().loadContent(message.getContent());
	}

}
