package application;
import java.util.concurrent.TimeUnit;
import javafx.stage.*;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Group;

import java.util.Optional;
import java.util.Random;
import java.util.Vector;
import javafx.scene.Parent;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
public class simpletoot extends Application {
    public SimpleObjectProperty<Color> playerColorProperty = new SimpleObjectProperty<Color>(Color.RED);
   // public SimpleObjectProperty<Text> playerTextProperty = new SimpleObjectProperty<Text>("T");
    public static int r = 4;
    public static int c = 6;
    public int row;
    public int column;
    public String toot = "T";
    public Alert setConfirm = new Alert(AlertType.INFORMATION);
    public static int[][] multi = new int[4][6];
    //public static boolean AIPlay = true;
    public static int mode = 1;
    public double sceneWidth;
    public double nn;
    public StackPane regretStack;
    public int regretRow;
    public int regretCol;
    public int regretIndex;
    public StackPane regretStackAI;
    public int AIregretRow;
    public int AIregretCol;
    public int AIregretIndex;
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public Circle getdiskFromIndex(int index,GridPane gridpane) {
    	Circle node = null;
    	if (gridpane.getChildren().get(index) instanceof StackPane) {
      	   StackPane stack1 = (StackPane) gridpane.getChildren().get(index);
      	   ObservableList<Node> childs = stack1.getChildren();
      	
      	      // Top Component
      		   if (childs.get(childs.size()-1) instanceof Circle) {
      			   node = (Circle)childs.get(childs.size()-1);
      			   
      			   }
    	}
    	return node;	   
    }
    public Circle getRegdiskFromIndex(int index,GridPane gridpane) {
    	Circle node = null;
    	if (gridpane.getChildren().get(index) instanceof StackPane) {
      	   StackPane stack1 = (StackPane) gridpane.getChildren().get(index);
      	   ObservableList<Node> childs = stack1.getChildren();
      	
      	      // Top Component
      		   if (childs.get(childs.size()-2) instanceof Circle) {
      			   node = (Circle)childs.get(childs.size()-2);
      			   
      			   }
    	}
    	return node;	   
    }
    public StackPane getSPFromIndex(int index,GridPane gridpane) {
    	StackPane stack1 = null;
    	if (gridpane.getChildren().get(index) instanceof StackPane) {
      	   stack1 = (StackPane) gridpane.getChildren().get(index);
      	   
    	}
    	return stack1;	   
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        final BorderPane root = new BorderPane();
        final GridPane gridpane = new GridPane();
        primaryStage.setTitle("JavaFX TOOT");
        primaryStage.setResizable(true);
        final Button addCellButton = new Button("Add Grids");
        gridpane.setTranslateY(20); //图形y方向位置
        gridpane.setAlignment(Pos.CENTER); //居中
        Scene scene = new Scene(root, 1000,1000, true);
        sceneWidth = scene.widthProperty().get();
        nn = (sceneWidth-350)/c;
        gridpane.getColumnConstraints().addAll(new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE));
                
        gridpane.getRowConstraints().addAll(new RowConstraints(nn,nn,Double.MAX_VALUE),
                new RowConstraints(nn,nn,Double.MAX_VALUE),
                new RowConstraints(nn,nn,Double.MAX_VALUE),
                new RowConstraints(nn,nn,Double.MAX_VALUE));
                
        createGrids(gridpane);
        root.setCenter(gridpane);
        DropShadow effect = new DropShadow();
        effect.setColor(Color.BLUE);
        addCellButton.setEffect(effect);
        addCellButton.setTranslateY(10); //the position of the addcellbutton
        addCellButton.setTranslateX(20);
        root.setTop(addCellButton);
        
        Group group1 = new Group();
        Button rb1 = new Button("play with a person");
		Button rb2 = new Button("play with a random AI");
		//Button rb3 = new Button("play with a smart AI");
		Button rb7 = new Button("reset");
		rb1.setEffect(effect);
		rb1.setLayoutX(50);
		rb1.setLayoutY(10);
		rb2.setEffect(effect);
		rb2.setLayoutX(50);
		rb2.setLayoutY(50);
		//rb3.setEffect(effect);
		//rb3.setLayoutX(50);
		//rb3.setLayoutY(90);
		rb7.setEffect(effect);
		rb7.setLayoutX(50);
		rb7.setLayoutY(90);
		group1.getChildren().addAll(rb1,rb2,rb7);
		group1.setTranslateY(10); //the position of the addcellbutton
		group1.setTranslateX(10);
		root.setLeft(group1);
		
		Group group2 = new Group();
		Button rb4 = new Button("T");
		Button rb5 = new Button("O");
		Button rb6 = new Button("regret");
		rb4.setEffect(effect);
		rb4.setLayoutX(-50);
		rb4.setLayoutY(10);
		rb5.setEffect(effect);
		rb5.setLayoutX(-50);
		rb5.setLayoutY(50);
		rb6.setEffect(effect);
		rb6.setLayoutX(-50);
		rb6.setLayoutY(90);
		group2.getChildren().addAll(rb4,rb5,rb6);
		group2.setTranslateY(10); //the position of the addcellbutton
		group2.setTranslateX(-10);
		root.setRight(group2);
		
		rb1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
                mode = 1;
                createGrids(gridpane);
                System.out.println(mode);
            }
        });
		rb2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	mode = 2;
                createGrids(gridpane);
                System.out.println(mode);
            }
        });
		/*
		rb3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	mode = 3;
                createGrids(gridpane);
                System.out.println(mode);
            }
        });
        */
		rb4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	toot = "T";
            }
        });
		rb5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	toot = "O";
            }
        });
		rb6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	if(mode == 1) {
            	Circle regDisk = getRegdiskFromIndex(regretIndex,gridpane);
            	TranslateTransition translateTranstion = new TranslateTransition(Duration.millis(300), regDisk);
            	if(regDisk.getTranslateY()==0){
                    translateTranstion.setToY(-(nn*(regretRow+1)));
                    translateTranstion.play();
                    if(playerColorProperty.get()==Color.RED){
                    	playerColorProperty.set(Color.YELLOW);
                    }else if(playerColorProperty.get()==Color.YELLOW){
                    	playerColorProperty.set(Color.RED);
                    }
                    multi[regretRow][regretCol] = 0;
                    regretStack.getChildren().remove(3);
                    Circle regDiskTop = getdiskFromIndex(regretIndex,gridpane);
                    regDiskTop.fillProperty().bind(playerColorProperty);
            }
            	}else if(mode == 2 || mode == 3) {
            	Circle regDisk = getRegdiskFromIndex(regretIndex,gridpane);
            	TranslateTransition translateTranstion = new TranslateTransition(Duration.millis(300), regDisk);
            	if(regDisk.getTranslateY()==0){
                    translateTranstion.setToY(-(nn*(regretRow+1)));
                    translateTranstion.play();
                        multi[regretRow][regretCol] = 0;
                	}
            	regretStack.getChildren().remove(3);
            	Circle regDiskTop = getdiskFromIndex(regretIndex,gridpane);
                regDiskTop.fillProperty().bind(playerColorProperty);
              
                Circle AIregDisk = getRegdiskFromIndex(AIregretIndex,gridpane);
                TranslateTransition AItranslateTranstion = new TranslateTransition(Duration.millis(300), AIregDisk);
                if(AIregDisk.getTranslateY()==0){
                   AItranslateTranstion.setToY(-(nn*(AIregretRow+1)));
                   AItranslateTranstion.play();
                   multi[AIregretRow][AIregretCol] = 0;
                }
                regretStackAI.getChildren().remove(3);
                Circle AIregDiskTop = getdiskFromIndex(regretIndex,gridpane);
                AIregDiskTop.fillProperty().bind(playerColorProperty);
            }
            }
        });
		rb7.setOnAction(e->{
			project_main open=new project_main();
			try
			{
				open.start(new Stage());
				primaryStage.hide(); 
				multi = new int[4][6];
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
	
		
        addCellButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
                addGrid(gridpane);
            }
        });
        

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    //Add Column and Row

    private void addGrid(final GridPane gridpane){
    	r = r+1;
    	c = c+1;
    	nn = (sceneWidth-350)/c;
        gridpane.getColumnConstraints().addAll(new ColumnConstraints(nn,nn,Double.MAX_VALUE));
        gridpane.getRowConstraints().addAll(new RowConstraints(nn,nn,Double.MAX_VALUE));
        createGrids(gridpane);
        multi = new int[r][c];
        /*
        System.out.println(r);
        System.out.println(c);
       */
    }

    //Create Grids

    private void createGrids(final GridPane gridpane){
        gridpane.getChildren().clear();
        for(r=0;r<gridpane.getRowConstraints().size(); r++){
            for(c=0; c<gridpane.getColumnConstraints().size(); c++){
            Rectangle rect = new Rectangle(nn,nn);
            Circle circ = new Circle(nn/2-3);
            circ.centerXProperty().set(nn/2); //格子中间的圆形
            circ.centerYProperty().set(nn/2);
            Shape cell = Path.subtract(rect, circ);
            cell.setFill(Color.BLUE);
            cell.setStroke(Color.BLUE);
            cell.setOpacity(.8);
            DropShadow effect = new DropShadow();
            effect.setSpread(.2);
            effect.setRadius(nn/4);
            effect.setColor(Color.BLUE);
            cell.setEffect(effect);
            final Circle diskPreview = new Circle(nn/2-10);
            diskPreview.setOpacity(.8 );
            diskPreview.setFill(Color.TRANSPARENT);
            diskPreview.setOnMouseEntered(new EventHandler<MouseEvent>(){

                @Override

                public void handle(MouseEvent arg0) {
                    diskPreview.setFill(Color.WHITE);
                    if(playerColorProperty.get()==Color.RED){
                        diskPreview.setFill(Color.RED);
                    }else{
                        diskPreview.setFill(Color.YELLOW);
                    }
                    
                    
                }
                
                
                
                

            });

            diskPreview.setOnMouseExited(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent arg0) {
                    diskPreview.setFill(Color.TRANSPARENT);
                }
            });
            final Circle disk = new Circle(nn/2-10);
            disk.fillProperty().bind(playerColorProperty);
            disk.setOpacity(.8);
            disk.setTranslateY(-(nn*(r+1)));
            final TranslateTransition translateTranstion = new TranslateTransition(Duration.millis(300), disk);
         
            disk.setOnMouseEntered(new EventHandler<MouseEvent>(){

                @Override

                public void handle(MouseEvent arg0) {
            
                    diskPreview.setFill(Color.WHITE);
                    if(playerColorProperty.get()==Color.RED){
                        diskPreview.setFill(Color.RED);
                    }else{
                        diskPreview.setFill(Color.YELLOW);
                   }
                    
         
                    
                }
            });

            disk.setOnMouseExited(new EventHandler<MouseEvent>(){

                @Override

                public void handle(MouseEvent arg0) {
                    diskPreview.setFill(Color.TRANSPARENT);
                          
                }
            });
            
            

            disk.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent arg0) {
                	//check if there is winner
                        if(disk.getTranslateY()!=0){
                        translateTranstion.setToY(0);
                        translateTranstion.play();
                        if(playerColorProperty.get()==Color.RED){
                            playerColorProperty.set(Color.YELLOW);
                            disk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.RED));
                        }else{
                            playerColorProperty.set(Color.RED);
                            disk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.YELLOW));
                        }

                  }

                }

            });
            
            if(mode == 1) {
            	diskPreview.setOnMouseClicked(new EventHandler<MouseEvent>(){

                    @Override

                    public void handle(MouseEvent arg0) {
                    	Node node =  (Node)arg0.getSource();
                    	Parent p = node.getParent();

                    	while (p != gridpane) {
                    	    node = p;
                    	    p = p.getParent();
                    	}
                    	Integer rowIndex = GridPane.getRowIndex(node);
                    	Integer colIndex = GridPane.getColumnIndex(node);
                    	regretRow = rowIndex;
                        regretCol = colIndex;
                        regretIndex = regretRow*c+regretCol;
                    	
                    	//gridpane.add(new Text("T"), cc, rr);
                    	//toot加上去的
                    	if (node instanceof StackPane) {
                      	   StackPane stack1 = (StackPane) node;
                      	   stack1.getChildren().add(new Text(toot));
                      	   regretStack = stack1;
                      	
                    	}
                    	//toot加上去的
                    	
                    	/*
                    	System.out.println(rowIndex);
                    	System.out.println(colIndex); //get the position when click
                    	*/
                            if(disk.getTranslateY()!=0){
                            translateTranstion.setToY(0);
                            translateTranstion.play();
                            if(playerColorProperty.get()==Color.RED){
                            	////toot加上去的
                            	if(toot == "T") {
                            		multi[rowIndex][colIndex] = 1;
                            	}else if(toot == "O") {
                            		multi[rowIndex][colIndex] = 2;
                            	}
                            ////toot加上去的
                            	//multi[rowIndex][colIndex] = 1;
                            	//boolean win = winner.judge(1,rowIndex,colIndex);
                            	
                            	boolean redWin = simpletootwinner.redWinTOOT(multi);
                            	boolean yellowWin = simpletootwinner.yellowWinOTTO(multi);
                            	/*
                            	if(win == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		setConfirm.showAndWait();
                            	}
                            	*/
                            	if(redWin == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[4][6];
                            				//System.out.println(multi[2][6]);
                            				redWin = false;
                            				playerColorProperty.set(Color.RED);
                            				//System.out.println(win);
                            			} 
                            			catch (Exception e1)
                            			{
                            				e1.printStackTrace();
                            			}
                            		}
                            	}else if(yellowWin == true) {
                            		System.out.println("yellow win");
                            		setConfirm.setContentText("yellow win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[4][6];
                            				//System.out.println(multi[2][6]);
                            				yellowWin = false;
                            				playerColorProperty.set(Color.RED);
                            				//System.out.println(win);
                            			} 
                            			catch (Exception e1)
                            			{
                            				e1.printStackTrace();
                            			}
                            		}
                            	}
                            	
                                playerColorProperty.set(Color.YELLOW);
                                disk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.RED));
                              //gridpane.add(new Text("T"), cc, rr);
                             //   disk.setFill(Color.YELLOW);
                            }else{
                            ////toot加上去的
                            	if(toot == "T") {
                            		multi[rowIndex][colIndex] = 1;
                            	}else if(toot == "O") {
                            		multi[rowIndex][colIndex] = 2;
                            	}
                            ////toot加上去的
                            	///multi[rowIndex][colIndex] = 2;
                            	//boolean win = winner.judge(2,rowIndex,colIndex);
                            	
                            	boolean redWin = simpletootwinner.redWinTOOT(multi);
                            	boolean yellowWin = simpletootwinner.yellowWinOTTO(multi);
                            	
                            	/*
                            	if(win == true) {
                            		System.out.println("yellow win");
                            		setConfirm.setContentText("yellow win");
                            		setConfirm.showAndWait();
                            	}
                            	*/
                            	if(redWin == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[4][6];
                            				//System.out.println(multi[2][6]);
                            				redWin = false;
                            				playerColorProperty.set(Color.RED);
                            				//System.out.println(win);
                            			} 
                            			catch (Exception e1)
                            			{
                            				e1.printStackTrace();
                            			}
                            		}
                            	}else if(yellowWin == true) {
                            		System.out.println("yellow win");
                            		setConfirm.setContentText("yellow win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[4][6];
                            				//System.out.println(multi[2][6]);
                            				yellowWin = false;
                            				playerColorProperty.set(Color.RED);
                            				//System.out.println(win);
                            			} 
                            			catch (Exception e1)
                            			{
                            				e1.printStackTrace();
                            			}
                            		}
                            	}
                            	
                                playerColorProperty.set(Color.RED);
                              disk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.YELLOW));
                             // gridpane.add(new Text("T"), cc, rr);
                             //   disk.setFill(Color.RED);
                            }
                            
                       }
                                   
                    }

                });
            	
            }
            

            if(mode == 2) {
            	diskPreview.setOnMouseClicked(new EventHandler<MouseEvent>(){

                    @Override

                    public void handle(MouseEvent arg0) {
                    	Node node =  (Node)arg0.getSource();
                    	Parent p = node.getParent();

                    	while (p != gridpane) {
                    	    node = p;
                    	    p = p.getParent();
                    	}
                    	Integer rowIndex = GridPane.getRowIndex(node);
                    	Integer colIndex = GridPane.getColumnIndex(node);
                    	regretRow = rowIndex;
                    	regretCol = colIndex;
                    	regretIndex = regretRow * c + regretCol;
                    	
                    	if (node instanceof StackPane) {
                       	   StackPane stack1 = (StackPane) node;
                       	   stack1.getChildren().add(new Text(toot));
                       	   regretStack = stack1;
                     	}
                    	//red is person,yellow is AI
                            if(disk.getTranslateY()!=0){
                            
                            translateTranstion.setToY(0);
                            translateTranstion.play();
                        
                            if(playerColorProperty.get()==Color.RED){
                                	if(toot == "T") {
                                		multi[rowIndex][colIndex] = 1;
                                	}else if(toot == "O") {
                                		multi[rowIndex][colIndex] = 2;
                                	}
                                	boolean redWin = simpletootwinner.redWinTOOT(multi);
                                	boolean yellowWin = simpletootwinner.yellowWinOTTO(multi);
                                	/*
                                	if(win == true) {
                                		System.out.println("red win");
                                		setConfirm.setContentText("red win");
                                		setConfirm.showAndWait();
                                	}
                                	*/
                                	if(redWin == true) {
                                		System.out.println("red win");
                                		setConfirm.setContentText("red win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[4][6];
                                				//System.out.println(multi[2][6]);
                                				redWin = false;
                                				playerColorProperty.set(Color.RED);
                                				//System.out.println(win);
                                			} 
                                			catch (Exception e1)
                                			{
                                				e1.printStackTrace();
                                			}
                                		}
                                	}else if(yellowWin == true) {
                                		System.out.println("AI win");
                                		setConfirm.setContentText("AI win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[4][6];
                                				//System.out.println(multi[2][6]);
                                				yellowWin = false;
                                				playerColorProperty.set(Color.RED);
                                				//System.out.println(win);
                                			} 
                                			catch (Exception e1)
                                			{
                                				e1.printStackTrace();
                                			}
                                		}
                                	}
                            	
                                playerColorProperty.set(Color.YELLOW);
                                disk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.RED));
                               
                             //   disk.setFill(Color.YELLOW);
                                int AIindex = simpletootrandomai.position(multi);
                                int AIletter = simpletootrandomai.letter();
                                int AIrow = AIindex/c;
                                int AIcol = AIindex%c;
                                AIregretRow = AIrow;
                                AIregretCol = AIcol;
                                AIregretIndex = AIindex;
                                if(AIletter == 0) {
                                	toot = "T";
                                }else if(AIletter == 1) {
                                	toot = "O";
                                }
                                
                                Circle AIdisk = getdiskFromIndex(AIindex,gridpane);
                                StackPane stackAI = getSPFromIndex(AIindex,gridpane);
                                
                                if(AIdisk.getTranslateY()!=0){
                                	try {
                                    	TimeUnit.SECONDS.sleep(1);
                                    	} catch (InterruptedException e) {
                                    	// TODO Auto-generated catch block
                                    	e.printStackTrace();
                                    	}
                                	
                                	TranslateTransition translateTranstionAI = new TranslateTransition(Duration.millis(300), AIdisk);
                                    translateTranstionAI.setToY(0);
                                    translateTranstionAI.play();
                                    stackAI.getChildren().add(new Text(toot));
                                    regretStackAI = stackAI;
                                    if(toot == "T") {
                                		multi[AIrow][AIcol] = 1;
                                	}else if(toot == "O") {
                                		multi[AIrow][AIcol] = 2;
                                	}
                                    boolean AIredWin = simpletootwinner.redWinTOOT(multi);
                                	boolean AIyellowWin = simpletootwinner.yellowWinOTTO(multi);
                                	
                                	if(AIredWin == true) {
                                		System.out.println("red win");
                                		setConfirm.setContentText("red win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[4][6];
                                				//System.out.println(multi[2][6]);
                                				AIredWin = false;
                                				playerColorProperty.set(Color.RED);
                                				//System.out.println(win);
                                			} 
                                			catch (Exception e1)
                                			{
                                				e1.printStackTrace();
                                			}
                                		}
                                	}else if(AIyellowWin == true) {
                                		System.out.println("AI win");
                                		setConfirm.setContentText("AI win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[4][6];
                                				//System.out.println(multi[2][6]);
                                				AIyellowWin = false;
                                				playerColorProperty.set(Color.RED);
                                				//System.out.println(win);
                                			} 
                                			catch (Exception e1)
                                			{
                                				e1.printStackTrace();
                                			}
                                		}
                                	}
                                    playerColorProperty.set(Color.RED);
                                    AIdisk.fillProperty().bind(new SimpleObjectProperty<Color>(Color.YELLOW));
                                
                                }
                                
                            }
                            
                       }
                                   
                    }

                });
            }
            
           
            
            StackPane stack = new StackPane();
            stack.getChildren().addAll(cell, diskPreview, disk);
            gridpane.add(stack, c, r);
            
           
                if(r==gridpane.getColumnConstraints().size()-1){
                    stack.setEffect(new Reflection());
                }
            }

             

        }

    }
    
   
}

