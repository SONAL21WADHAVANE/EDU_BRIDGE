/**
 * This class represents a simple quiz application where questions are presented
 * with multiple-choice options, and the user can select an option for each question.
 *
 * The user can submit their answers and view the final score.
 */
package home;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The main application class that extends JavaFX Application and implements the quiz application.
 */

public class C2W_Quiz extends Application {

    private int currentQuestionIndex = 0;
    private int score = 0;

    private Question[] questions = {
            
            new Question("Q1.Automatic type conversion is possible in which of the possible cases?", "Long to Int", "Int to Long", "Byte to Int", "Short to Int", "Int to Long"),
            new Question("Q2.When an array is passed to a method, what does the method receive?", "The reference of the array", "A copy of the array", "Length of the array", "First element of array", "The reference of the array"),
            new Question("Q3.Which keyword is used to implement multiple inheritance in Java?", "extends", "implements", "extends & implements", "Multiple inheritance is not supported in Java", "Multiple inheritance is not supported in Java"),
            new Question("Q4.What is the correct way to create a thread in Java?", "Thread t = new Thread(); t.start()", "Thread t = new Thread(); t.run()", "Thread t = new Thread(); t.execute()", "Thread t = new Thread(); t.begin()", "Thread t = new Thread(); t.start()"),
            new Question("Q5.What is the use of final keyword in Java?", "When a class is made final, a subclass of it can not be created.", "When a method is final, it can not be overridden.", "When a variable is final, it can be assigned value only once.", "All of the above", "All of the above"),
            new Question("Q6.What is the return type of the hashCode() method in the Object class?", "Object", "int", "long", "void", "int"),
            new Question("Q7.What is meant by the classes and objects that dependents on each other?", "Tight Coupling", "Cohesion", "Loose Coupling ", "None of the above", "Tight Coupling"),                
            new Question("Q8.In which of the following is toString() method defined", "java.lang.String", "java.lang.Object", "java.lang.util", "None", "java.lang.Object"),
            new Question("Q9.Identify the modifier which cannot be used for constructor.", "public", "private", "protected", "static", "static"),
            new Question("Q10.When is the finalize() method called?", "Before garbage collection", "Before an object goes out of scope", "Before an variable goes out of scope", "None", "Before garbage collection"),

        };

    private Label questionLabel;
    private RadioButton[] answerRadioButtons;
    private Button submitButton;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quiz Application");

        questionLabel = new Label();
        answerRadioButtons = new RadioButton[4];
        ToggleGroup answerGroup = new ToggleGroup();
        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i] = new RadioButton();
            answerRadioButtons[i].setToggleGroup(answerGroup);
            answerRadioButtons[i].setStyle("-fx-text-fill: white;"); // Set text color

        }

        submitButton = new Button("Submit");
        resultLabel = new Label();
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Button styling

        submitButton.setOnAction(event -> {
            if (answerGroup.getSelectedToggle() != null) {
                RadioButton selectedRadioButton = (RadioButton) answerGroup.getSelectedToggle();
                String selectedAnswer = selectedRadioButton.getText();
                checkAnswer(selectedAnswer);
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion(currentQuestionIndex);
                } else {
                    showResult();
                }
            }
        });

        VBox optionsBox = new VBox(10);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPadding(new Insets(5));
        optionsBox.setStyle("-fx-background-color: #7ad7f0; -fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 3px");
        //optionsBox.setStyle("-fx-background-image: url('Quiz.jpg'); " +"-fx-background-size: cover;");
  
        GridPane optionsGrid = new GridPane();
        optionsGrid.setAlignment(Pos.CENTER);
        optionsGrid.setHgap(10);
        optionsGrid.setVgap(10);

        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i].setStyle("-fx-text-fill: black;");

            optionsGrid.add(answerRadioButtons[i], 0, i);

        }
       
       
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        //layout.setStyle("-fx-background-color: #99CCFF;-fx-border-color: black; -fx-border-width: 1px;");
        layout.setStyle("-fx-background-image: url('Quiz7.jpeg'); " +"-fx-background-size: cover;");
  
        layout.getChildren().addAll(questionLabel, optionsGrid, submitButton, resultLabel);


        Scene scene = new Scene(layout, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Load external CSS

        primaryStage.setScene(scene);
        //resize the size
        primaryStage.setResizable(false);
        loadQuestion(currentQuestionIndex);
        primaryStage.show();
    }

    private void loadQuestion(int index) {
        Question question = questions[index];
        questionLabel.setText(question.getQuestion());
        for (int i = 0; i < 4; i++) {
            answerRadioButtons[i].setText(question.getOptions()[i]);
            answerRadioButtons[i].setSelected(false);
        }
        resultLabel.setText("");
    }

    private void checkAnswer(String selectedAnswer) {
        Question question = questions[currentQuestionIndex];
        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            score++;
        }
    }

    private void showResult() {
        resultLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
        submitButton.setDisable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * Represents a question in the quiz with the question statement, options, and correct answer.
 */

class Question {
    private String question;
    private String[] options;
    
    private String correctAnswer;

    /**
     * Constructs a Question object with the specified question, options, and correct answer.
     *
     * @param question       The question statement.
     * @param option1        The first option for the question.
     * @param option2        The second option for the question.
     * @param option3        The third option for the question.
     * @param option4        The fourth option for the question.
     * @param correctAnswer  The correct answer among the options.
     */

    public Question(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.question = question;
        this.options = new String[]{option1, option2, option3, option4};
        this.correctAnswer = correctAnswer;
    }
     
    /**
     * Gets the question statement.
     *
     * @return The question statement.
     */

    public String getQuestion() {
        return question;
    }

    /**
     * Gets the options for the question.
     *
     * @return An array of options.
     */

    public String[] getOptions() {
        return options;
    }

    /**
     * Gets the correct answer for the question.
     *
     * @return The correct answer.
     */

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
