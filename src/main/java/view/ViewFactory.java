package view;

import javax.naming.OperationNotSupportedException;

import controller.AbstractController;
import controller.EmailDetailsController;
import controller.MainController;
import controller.ModelAccess;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewFactory {
	
	public static ViewFactory defaultFactory = new ViewFactory();
	private static boolean mainViewInitialized = false;
	
	private final String DEFAULT_CSS = "css/style.css";
	private final String EMAIL_DETAILS_FXML = "views/DetailsDocument.fxml";
	private final String MAIN_SCREEN_FXML = "views/MainDocument.fxml";
	
	private ModelAccess modelAccess = new ModelAccess();
	
	private MainController mainController;
	private EmailDetailsController emailDetailsController;
	

	public Scene getMainScene() throws OperationNotSupportedException{
		if (!mainViewInitialized) {
			mainController = new MainController(modelAccess);
			mainViewInitialized = true;
			return initializeScene(MAIN_SCREEN_FXML, mainController);
		} else{
			throw new OperationNotSupportedException("Main Scene allready initialized!!!!");
		}
		
	}
	
	public Scene getEmailDetailsScene(){
		emailDetailsController = new EmailDetailsController(modelAccess);
		return initializeScene(EMAIL_DETAILS_FXML, emailDetailsController);		
	}
	
	
	
	
	public Node resolveIcon(String treeItemValue){
		String lowerCaseTreeItemValue = treeItemValue.toLowerCase();
		ImageView returnIcon;
			try {
				if(lowerCaseTreeItemValue.contains("inbox")){
					returnIcon= new ImageView(new Image(getClass().getResourceAsStream("/images/inbox.png")));
				} else if(lowerCaseTreeItemValue.contains("sent")){
					returnIcon= new ImageView(new Image(getClass().getResourceAsStream("/images/sent2.png")));
				} else if(lowerCaseTreeItemValue.contains("spam")){
					returnIcon= new ImageView(new Image(getClass().getResourceAsStream("/images/spam.png")));
				} else if(lowerCaseTreeItemValue.contains("@")){
					returnIcon= new ImageView(new Image(getClass().getResourceAsStream("/images/email.png")));
				} else{
					returnIcon= new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png")));
				}
			} catch (NullPointerException e) {
				System.out.println("Invalid image location!!!");
				e.printStackTrace();
				returnIcon = new ImageView();
			}
			
			returnIcon.setFitHeight(16);
			returnIcon.setFitWidth(16);

		return returnIcon;
	}
	
	private Scene initializeScene(String fxmlPath, AbstractController controller){
		FXMLLoader loader;
		Parent parent;
		Scene scene;
		try {
			loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
			loader.setController(controller);
			parent = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getClassLoader().getResource(DEFAULT_CSS).toExternalForm());
		return scene;
	}
	
	
	
	
	
	
	
	
	

}
