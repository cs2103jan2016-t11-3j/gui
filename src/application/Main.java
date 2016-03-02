package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	
	Stage window;
	TableView<String> table;
	static String input;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,550,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		window.setTitle("Adult TaskFinder");
		window.setScene(scene);
		window.show();
		
		addTitleTop(root);
		addTextBox(root);
		addCenterPage(root);
	}
	
	private void addTitleTop(BorderPane root) {
		Label title = new Label("Adult TaskFinder");
		title.setFont(new Font("Cambria",28));
		title.setAlignment(Pos.CENTER);
		VBox topPane = new VBox(200);
		topPane.getChildren().add(title);
		topPane.setPadding(new Insets(10,10,10,10));
		root.setTop(topPane);
	}

	private void addCenterPage(BorderPane root) {
		TableColumn<String, String> indexColumn = new TableColumn<>("Index");
		indexColumn.setMinWidth(50);
		indexColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));

		TableColumn<String, String> nameColumn = new TableColumn<>("Task Name");
		nameColumn.setMinWidth(300);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		TableColumn<String, String> dateColumn = new TableColumn<>("Date Due");
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
		
		table = new TableView<>();
		table.getColumns().addAll(indexColumn, nameColumn, dateColumn);
		
		table.setPadding(new Insets(10,10,10,10));
		root.setCenter(table);
	}

	private void addTextBox(BorderPane root) {
		TextField userInput = new TextField();
		userInput.setPromptText("input command");
		userInput.setPrefWidth(455);
		Button button1 = new Button("Enter");
		button1.setOnAction( e -> {
			input = userInput.getText();
			System.out.println(userInput.getText());
		});
		HBox bottomPane = new HBox();
		bottomPane.getChildren().addAll(userInput,button1);
		bottomPane.setPadding(new Insets(20,20,20,20));
		bottomPane.setSpacing(10);
		root.setBottom(bottomPane);
	}

	public static String getInput() {
		return input;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
