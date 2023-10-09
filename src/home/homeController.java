/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package home;
//package TodoListApp.java;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 *
 * @author Sonal
 */
public class homeController implements Initializable {
    
    @FXML
    private Button calculatorBtn;

    @FXML
    private Button quizeBtn;

    @FXML
    private Button todoBtn;

    @FXML
    void openLink1(ActionEvent event) {
       
    }

    @FXML
    void openLink2(ActionEvent event) {
        TodoListApp list = new TodoListApp();
        try {
            list.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    void openLink3(ActionEvent event) {
        
    }
    
    @FXML
    private Label label;
    
 
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
