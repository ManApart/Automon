package org.iceburg.coregear.main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXConsole extends Application {
	private TextArea taOutput;
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void launch(){
		String[] args = new String[0];
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Coregear");
		
		
		
		Label lbl = new Label("Test Label:");
		
		
		Button btn = new Button("Test button");
		btn.setOnAction(e -> {
				System.out.println("test");
			}
		);
		StringBuilder longString = new StringBuilder();
		for (int i =0; i< 50; i++){
			longString.append("more text");
		}
		taOutput = new TextArea(longString.toString());
		taOutput.setEditable(false);
		taOutput.setWrapText(true);
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(lbl, taOutput, btn);
		
		Scene scene = new Scene(layout, 1200,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void display(String message){
		System.out.println("updating output");
		taOutput.setText(message);
	}
	

}
