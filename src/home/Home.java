/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package home;




import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Application {
    
    Button btn_sci = new Button("VIEW");
    
    Button btn_todo = new Button("VIEW");
    Button btn_quize = new Button("VIEW");
    Button btn_about = new Button("Know More");
    @Override
    public void start(Stage stage) throws Exception {
        Scene root = start_0();
        //Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        
        //Scene scene = new Scene(root);
        
        stage.setScene(root);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    Scene start_0(){

        btn_sci.setOnAction(e->openCalculator());
        btn_todo.setOnAction(e->openTodoList());
        btn_quize.setOnAction(e->openQuiz());
        
        btn_about.setOnAction(e ->{
            HostServices hostServices = getHostServices();
            String url = "https://www.core2web.in";
            hostServices.showDocument(url);
        } );

        ImageView logo=new ImageView("core2weblogo.png");
        logo.setPreserveRatio(false);
        logo.setFitHeight(60);
        logo.setFitWidth(60);
        logo.setStyle(" -fx-background-color:red");
        HBox i1=new HBox(new Label("EDUBRIDGE"));
        i1.setStyle("-fx-font-size:40px;-fx-fontFamily:Copperplate Gothic Bold;-fx-Textcolor:black;-fx-Height:213;-fx-width:40 ;-fx-align:CENTER");
        HBox v1 = new HBox(btn_about);
        v1.setLayoutX(900);
        v1.setAlignment(Pos.CENTER_RIGHT);
        v1.setStyle("-fx-alignment : CENTER_RIGHT; -fx-pref-width : 700");
        
       // v1.setAlignment(Pos.TOP_LEFT);
        //.setStyle("-fx-alignment:TOPRIGHT");
        HBox H1=new HBox(20,logo,i1,v1);
        H1.setStyle("-fx-padding : 20 0 0 20;-fx-pref-height:90;-fx-pref-width:200; -fx-background-color:none;");

        
        HBox hb_cal_1 =new HBox(new Label("Scientific Claculator"));
        hb_cal_1.setStyle("-fx-alignment: CENTER;-fx-pref-height:70;-fx-pref-width:249; -fx-background-color:pink;-fx-font-size:24px");
        ImageView logo1=new ImageView("calculator.jpeg");
        logo1.setPreserveRatio(false);
        logo1.setFitHeight(170);
        logo1.setFitWidth(190);
        logo1.setStyle("-fx-pref-height:40;-fx-pref-width:40; -fx-background-color:blue");
        HBox hb_cal_2 =new HBox(logo1);
        hb_cal_2.setStyle("-fx-alignment: CENTER;-fx-pref-height:207;-fx-pref-width:249; -fx-background-color:white;-fx-broder-color:black");
        
        btn_sci.setStyle("-fx-alignment: CENTER;-fx-font-size:18px;-fx-pref-height:54;-fx-pref-width:249; -fx-background-color:green");
        VBox vb_calculator=new VBox(hb_cal_1,hb_cal_2,btn_sci);


        HBox hb_todo_1 =new HBox(new Label("Todo App"));
        hb_todo_1.setStyle("-fx-alignment: CENTER;-fx-pref-height:70;-fx-pref-width:249; -fx-background-color:pink;-fx-font-size:24px");
        ImageView logo2=new ImageView("todolist.jpeg");
        logo2.setPreserveRatio(false);
        logo2.setFitHeight(170);
        logo2.setFitWidth(190);
        logo2.setStyle("-fx-pref-height:40;-fx-pref-width:40; -fx-background-color:blue");
        HBox hb_todo_2 =new HBox(logo2);
        hb_todo_2.setStyle("-fx-alignment: CENTER;-fx-pref-height:207;-fx-pref-width:249; -fx-background-color:white");
        
        btn_todo.setStyle("-fx-alignment: CENTER;-fx-font-size:18px;-fx-pref-height:54;-fx-pref-width:249; -fx-background-color:green");
        VBox vb_todolist=new VBox(hb_todo_1,hb_todo_2,btn_todo);


        HBox hb_quize_1 =new HBox(new Label("Quize App"));
        hb_quize_1.setStyle("-fx-alignment: CENTER;-fx-pref-height:70;-fx-pref-width:249;-fx-font-size:24px; -fx-background-color:pink");
        ImageView logo3=new ImageView("Quiz.jpeg");
        logo3.setPreserveRatio(false);
        logo3.setFitHeight(170);
        logo3.setFitWidth(190);
        logo3.setStyle("-fx-pref-height:40;-fx-pref-width:40; -fx-background-color:blue");
        HBox hb_quize_2 =new HBox(logo3);
        hb_quize_2.setStyle("-fx-alignment: CENTER;-fx-pref-height:207;-fx-pref-width:249; -fx-background-color:white");
    
        btn_quize.setStyle("-fx-alignment: CENTER;-fx-font-size:18px;-fx-pref-height:54;-fx-pref-width:249; -fx-background-color:green");
        VBox vb_quize=new VBox(hb_quize_1,hb_quize_2,btn_quize);
        //vb_quize.setStyle("-fx-border-color:black");
        HBox H2=new HBox(100,vb_calculator,vb_todolist,vb_quize);
        H2.setStyle("-fx-alignment: CENTER;-fx-pref-height:550; -fx-background-color:none ;-fx-padding:120 0 0 0");
        
        VBox vb=new VBox(H1,H2);
        vb.setStyle("-fx-background-image: url('bg2.webp'); " +
                      "-fx-background-size: cover;");
        Scene scene = new Scene(vb,1100,600);
        return scene;

    }

    private void openTodoList() {
        TodoListApp secondApp = new TodoListApp();
        Stage secondStage = new Stage();
        try {
            secondApp.start(secondStage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }erf

    private void openCalculator() {
        ScientificCalculator secondApp = new ScientificCalculator();
        Stage secondStage = new Stage();
        secondApp.start(secondStage);
    }

    private void openQuiz() {
        C2W_Quiz secondApp = new C2W_Quiz();
        Stage secondStage = new Stage();
        secondApp.start(secondStage);
    }

    public void Action(ActionEvent event){

        Object src = event.getSource();

        if(src == btn_sci){



        }

    }
    
}
