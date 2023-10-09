package home;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TodoListApp extends Application {

    private ListView<String> todoListView;
    private TextField taskInputField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TODO List");

        todoListView = new ListView<>();
        todoListView.setStyle("-fx-pref-height:400;-fx-max-width:100");
        todoListView.setStyle("-fx-font-size:20px");
        taskInputField = new TextField();
        taskInputField.setStyle("-fx-max-width:800;-fx-font-size:20px");
        Button addButton = new Button("Add Task");
        addButton.setStyle("-fx-background-color: #22a33e;-fx-max-width:150");
        Button deleteButton = new Button("Delete Task");
        deleteButton.setStyle("-fx-background-color: #f85454;-fx-max-width:150");
        Button completeButton = new Button("Mark Complete");
        completeButton.setStyle("-fx-background-color: #52c1e9;-fx-max-width:150");

        // Add a task to the list
        addButton.setOnAction(event -> {
            String task = taskInputField.getText();
            if (!task.isEmpty()) {
                todoListView.getItems().add(task);
                taskInputField.clear();
                
            }
        });

        // Delete the selected task
        deleteButton.setOnAction(event -> {
            int selectedIndex = todoListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                todoListView.getItems().remove(selectedIndex);
            }
        });

       //Complete the selected task
        completeButton.setOnAction(event -> {
            int selectedIndex = todoListView.getSelectionModel().getSelectedIndex();
        
            if (selectedIndex >= 0) {
                String task = todoListView.getItems().get(selectedIndex);
                if (!task.endsWith("(Completed)")) {
                    String completedTask = task + " (Completed)";
                    todoListView.getItems().set(selectedIndex, completedTask);
                }
            }
        });
                

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        //vbox.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setStyle("-fx-background-image: url('aa.jpg'); " + "-fx-background-size: cover;-fx-padding :0 200 0 200");
        vbox.getChildren().addAll(taskInputField, addButton, deleteButton, completeButton, todoListView);

        Scene scene = new Scene(vbox, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
