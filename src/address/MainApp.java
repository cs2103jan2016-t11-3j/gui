package address;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;


public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Adult TaskFinder");
		initRootLayout();
		showATFDisplay();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initRootLayout() {
		try {
			// Load root layout from RootLayout.fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void showATFDisplay() {
		try {
			// Load Adult TaskFinder
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ATFDisplay.fxml"));
            AnchorPane adultTaskFinder = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(adultTaskFinder);
        } catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
}
