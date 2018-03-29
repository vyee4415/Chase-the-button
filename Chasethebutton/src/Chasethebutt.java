import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Chasethebutt extends Application {
	private int num = 0;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("You've got 10 seconds!");
        Button btn = new Button();
        btn.setText("Click me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setLayoutX((int)(Math.random()*500));
                btn.setLayoutY((int)(Math.random()*500));
            }
        });
        
        long timeStep = System.nanoTime() + 10000000000L;
        new AnimationTimer() {
        	public void handle(long now) {
        		if(now < timeStep) {
        	        btn.setText("Click me!");
        		}
        		if(now > timeStep) {
        			btn.setText(Integer.toString(num));
        		}
        	}
        }.start();
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}.