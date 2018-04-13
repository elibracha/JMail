package views;

import controllers.AbstractController;
import controllers.DetailsController;
import controllers.MainController;
import controllers.ModelAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewFactory {

	private final String DEFAULT_CSS = "/css/style.css";
	private final String EMAIL_DETAILS_FXML = "/views/DetailsDocument.fxml";
	private final String MAIN_SCREEN_FXML = "/views/MainDocument.fxml";

	private static ViewFactory factory = null;
	private ModelAccess modelAccess = new ModelAccess();
	private MainController mainController;
	private DetailsController emailDetailsController;
	

	private  ViewFactory() {};
	
	public static ViewFactory getInstance() {
		if(factory == null) {
			factory = new ViewFactory();
		}
		return factory;
	}
	
	public Scene getMainScene(){
		mainController = new MainController(modelAccess);
		return initializeScene(MAIN_SCREEN_FXML, mainController);
		
	}
	
	public Scene getDetailsScene(){
		emailDetailsController = new DetailsController(modelAccess);
		return initializeScene(EMAIL_DETAILS_FXML, emailDetailsController);		
	}
	
	
	public Node resolveIcon(int treeItemValue){
		ImageView returnIcon = null;
			try {
				switch(treeItemValue){
					case 1:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/profile.png")));
						break;
					case 2:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/sent.png")));
						break;
					case 3:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/spam.png")));
						break;
					case 4:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/inbox.png")));
						break;
					case 5:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/drafts.png")));
						break;
					case 6:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/allmail.png")));
						break;
					case 7:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/important.png")));
						break;
					case 8:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/trash.png")));
						break;
					case 9:
						returnIcon= new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("images/starred.png")));
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				returnIcon = new ImageView();
			}
			
			if(returnIcon != null) {
				returnIcon.setFitHeight(16);
				returnIcon.setFitWidth(16);
			}

		return returnIcon;
	}
	
	private Scene initializeScene(String fxmlPath, AbstractController controller){
		FXMLLoader loader;
		Parent parent;
		Scene scene;
		try {
			loader = new FXMLLoader(getClass().getResource(fxmlPath));
			loader.setController(controller);
			parent = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS).toExternalForm());
		return scene;
	}

}
