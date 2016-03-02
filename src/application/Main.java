package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	Stage window;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
		Scene scene = new Scene(root, 1000, 500);
		
		window.setTitle("Adult TaskFinder");
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
