package application;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class project_main extends Application{
	public static void main(String[] args)
	{
		launch(args);
	}
 
	@Override
	public void start(Stage stage) throws Exception
	{
		StackPane pane=new StackPane();
		DropShadow effect = new DropShadow();
	    effect.setColor(Color.BLUE);
		
		Button button1=new Button("Play Connect4");
		button1.setEffect(effect);
		button1.setLayoutX(50);
		button1.setLayoutY(10);
		button1.setCursor(Cursor.HAND);
		button1.setOnAction(e->{
			main open=new main();
			try
			{
			    open.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		Button button2=new Button("Play TOOT");
		button2.setEffect(effect);
		button2.setLayoutX(50);
		button2.setLayoutY(50);
		button2.setCursor(Cursor.HAND);
		button2.setOnAction(e->{
			simpletoot open=new simpletoot();
			try
			{
				open.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		
		Button button3=new Button("Play TOOT_2");
		button3.setEffect(effect);
		button3.setLayoutX(50);
		button3.setLayoutY(90);
		button3.setCursor(Cursor.HAND);
		button3.setOnAction(e->{
			mainfortoot open=new mainfortoot();
			try
			{
				open.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		Button button4=new Button("Play Connect5");
		button4.setEffect(effect);
		button4.setLayoutX(50);
		button4.setLayoutY(130);
		button4.setCursor(Cursor.HAND);
		button4.setOnAction(e->{
			connect5 open=new connect5();
			try
			{
				open.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		Button button5=new Button("exit");
		button5.setEffect(effect);
		button5.setLayoutX(50);
		button5.setLayoutY(170);
		button5.setCursor(Cursor.HAND);
		button5.setOnAction(e->{
			System.exit(-1);
			
		});
		Group group = new Group();
		group.getChildren().addAll(button1,button2,button3,button4,button5);
		pane.getChildren().add(group);
		
		Scene scene=new Scene(pane,300,300);
		
		stage.setScene(scene);
		stage.setTitle("Start");
		stage.show();
		
	}


}

/*
 * Some explanations for my game system:

There are four games in all: connect4, TOOT, TOOT2 and connect5. 
(TOOT and TOOT2 are almost the same. I was not very clear about the TOOT rule, 
so I wrote them with two different rules.)

“project_main.java” is the entry for all the games.

“main.java”, “connect4winner.java”, “randomai.java” and “smartai.java” are for 
the game “connect4”

“simpletoot.java”, “simpletootwinner.java” and “simpletootrandomai.java” are for 
the game “TOOT”. (The rule is: when there is “TOOT” on the board, red wins; when 
there is “OTTO” on the board, yellow wins.)

“mainfortoot.java”, “tootwinner.java”, “randomaitoot.java” are for 
the game “TOOT2”. (The rule is: when there is “TOOT” on the board with red color, 
red wins; when there is “OTTO” on the board with yellow color, yellow wins.)

“connect5.java”, “connect5winner.java” and “randomaiconnect5.java” are for 
the game “connect5”.(The difference from connet4 is: player can put chess piece 
in any place of the board, and need to connect five chess pieces.)
*/
