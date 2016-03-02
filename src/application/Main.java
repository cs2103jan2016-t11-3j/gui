package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	Stage window;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Label title = new Label("Adult TaskFinder");
		window.setTitle("Adult TaskFinder");
		window.setScene(scene);
		window.show();
		
		root.setTop(title);
		addTextBox(root);
		addCenterPage(root);
	}
	
	/**private void addCenterPage(BorderPane root) {
		ListView<String> listView = new ListView<String>();
		listView.getItems().addAll("first task", "second task");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		root.setCenter(listView);
	}
	*/
	private void addCenterPage(BorderPane root) {
		TreeView<String> taskLists = new TreeView<String>();
		TreeItem<String> taskType, tasks;
		
		//root
		taskType = new TreeItem<String>();
		taskType.setExpanded(true);
			
		//branch
		tasks = makeBranch("first task", taskType);
		makeBranch("task2", tasks);
		makeBranch("task3", tasks);
		taskLists = new TreeView<>(taskType);
		taskLists.setShowRoot(false);
		
		root.setCenter(taskLists);
	}

	public TreeItem<String> makeBranch(String listView, TreeItem<String> taskType) {
		TreeItem<String> item = new TreeItem<>(listView);
		item.setExpanded(true);
		taskType.getChildren().add(item);
		return item;
	}

	private void addTextBox(BorderPane root) {
		TextField userInput = new TextField();
		userInput.setPromptText("input command");
		userInput.setPrefWidth(300);
		Button button1 = new Button("Enter");
		button1.setOnAction( e -> System.out.println(userInput.getText()));
		HBox bottomPane = new HBox();
		bottomPane.getChildren().addAll(userInput,button1);
		bottomPane.setPadding(new Insets(20,20,20,20));
		root.setBottom(bottomPane);
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
