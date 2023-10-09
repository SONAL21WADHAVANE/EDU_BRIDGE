/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package home;

/**
 *
 * @author Sonal
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class ScientificCalculator extends Application {
    private TextArea display;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scientific Calculator");

        // Create the display area
        display = new TextArea();
        display.setEditable(false);
        display.setPrefRowCount(3);
        display.setMaxWidth(500);
        display.setStyle("-fx-allignment: CENTRE;");

        // Create a grid for buttons
        GridPane grid = createButtonGrid();

        // Create a VBox to hold the display and grid
        VBox vbox = new VBox(30);
        vbox.setStyle("-fx-padding:10; -fx-allignment:CENTRE ;-fx-max-size: 500 500" );
        vbox.getChildren().addAll(display, grid);

        // Create the scene and set it on the stage
        Scene scene = new Scene(vbox, 500, 600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Define calculator buttons
        String[][] buttonLabels = {
                {"7", "8", "9", "/", "sqrt"},
                {"4", "5", "6", "*", "pow"},
                {"1", "2", "3", "-", "sin"},
                {"0", ".", "=", "+", "cos"},
                {"(", ")", "C", "log", "tan"}
                // Add more buttons here as needed
        };

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                Button button = new Button(buttonLabels[row][col]);
                button.setPrefSize(80, 80);
                button.setOnAction(e -> handleButtonClick(button.getText()));
                grid.add(button, col, row);
            }
        }

        return grid;
    }

    private void handleButtonClick(String text) {
        if (text.equals("=")) {
            try {
                String expression = display.getText();
                double result = evaluateExpression(expression);
                display.setText(formatResult(result));
            } catch (Exception e) {
                display.setText("Error");
            }
        } else if (text.equals("C")) {
            display.clear();
        } else if (text.equals("sqrt")) {
            // Handle square root
            try {
                String expression = display.getText();
                double operand = Double.parseDouble(expression);
                if (operand < 0) {
                    display.setText("Error");
                } else {
                    double result = Math.sqrt(operand);
                    display.setText(formatResult(result));
                }
            } catch (NumberFormatException e) {
                display.setText("Error");
            }
        } else if (text.equals("sin") || text.equals("cos") || text.equals("tan")) {
            // Handle trigonometric functions
            try {
                String expression = display.getText();
                double operand = Double.parseDouble(expression);
                double result = 0.0;

                if (text.equals("sin")) {
                    result = Math.sin(Math.toRadians(operand));
                } else if (text.equals("cos")) {
                    result = Math.cos(Math.toRadians(operand));
                } else if (text.equals("tan")) {
                    result = Math.tan(Math.toRadians(operand));
                }

                display.setText(formatResult(result));
            } catch (NumberFormatException e) {
                display.setText("Error");
            }
        } else if (text.equals("log")) {
            // Handle logarithm
            try {
                String expression = display.getText();
                double operand = Double.parseDouble(expression);
                if (operand <= 0) {
                    display.setText("Error");
                } else {
                    double result = Math.log10(operand);
                    display.setText(formatResult(result));
                }
            } catch (NumberFormatException e) {
                display.setText("Error");
            }
        } else {
            display.appendText(text);
        }
    }

    private double evaluateExpression(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object result = engine.eval(expression);
            if (result instanceof Number) {
                return ((Number) result).doubleValue();
            } else {
                throw new IllegalArgumentException("Invalid expression");
            }
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    private String formatResult(double result) {
        // Format the result with up to 10 decimal places and remove trailing zeros
        BigDecimal bd = BigDecimal.valueOf(result).setScale(10, RoundingMode.HALF_UP).stripTrailingZeros();
        return bd.toPlainString();
    }
}