package application;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
public class main extends Application {
    public SimpleObjectProperty<Color> playerColorProperty = new SimpleObjectProperty<Color>(Color.RED);
    public static int r = 6;
    public static int c = 7;
    public int row;
    public int column;
    public int regretRow;
    public int regretCol;
    public int regretIndex;
    public int AIregretRow;
    public int AIregretCol;
    public int AIregretIndex;
    public double sceneWidth;
    public double nn;
    public boolean win;
    public Stage primaryStage = new Stage();
    private Image image = new Image("file:time.jpg");
    private ImageView iv = new ImageView();
    public Alert setConfirm = new Alert(AlertType.INFORMATION);
    public static int[][] multi = new int[6][7];
    public static int mode = 1;
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
    
    
    /*
     public boolean judge(int color, int x, int y) {
		boolean flag = false;
		if (checkCount(color, x, y, 1, 0) >= 4) {
			flag = true;
		}else if (checkCount(color, x, y, 0, 1) >= 4) {
			flag = true;
		}else if (checkCount(color, x, y, 1, -1) >= 4) {
			flag = true;
		}else if (checkCount(color, x, y, 1, 1) >= 4) {
			flag = true;
		}
		return flag;
	}
	
    //check the connection
    public int checkCount(int color, int x, int y, int xChange, int yChange) {
		int count = 1;
		int tempX = xChange;
		int tempY = yChange;
		
		while (x + xChange >= 0 && x + xChange < r && y + yChange >= 0 && y + yChange < c) {
				if(multi[x + xChange][y + yChange] == color) {
			count++;
			if (xChange != 0)
				xChange++;
			if (yChange != 0) {
				if (yChange > 0)
					yChange++;
				else
					yChange--;
			}
		}else {
			break;
		}
		}
		xChange = tempX;
		yChange = tempY;
 
		while (x - xChange >= 0 && x - xChange < r && y - yChange >= 0 && y - yChange < c) {
			if(multi[x - xChange][y - yChange] == color) {
			count++;
			if (xChange != 0)
				xChange++;
			if (yChange != 0) {
				if (yChange > 0)
					yChange++;
				else
					yChange--;
			}
			}else {
				break;
			}
		}
		return count;
	}
    */
   
    
    @Override
    public void start(Stage primaryStage) {
    	final BorderPane root = new BorderPane();
        final GridPane gridpane = new GridPane();
        primaryStage.setTitle("JavaFX Connect 4");
        primaryStage.setResizable(true);
        final Button addCellButton = new Button("Add Grids");
        gridpane.setTranslateY(20); 
        gridpane.setAlignment(Pos.CENTER); 
        Scene scene = new Scene(root, 1000, 1000, true);  //750,680
       sceneWidth = scene.widthProperty().get();
       
        nn = (sceneWidth-350)/c;
        gridpane.getColumnConstraints().addAll(new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE),
                new ColumnConstraints(nn,nn,Double.MAX_VALUE));
                
        gridpane.getRowConstraints().addAll(new RowConstraints(nn,nn,Double.MAX_VALUE),
                new RowConstraints(nn,nn,Double.MAX_VALUE),
                new RowConstraints(nn,nn,Double.MAX_VALUE),
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
		Button rb3 = new Button("play with a smart AI");
		Button rb5 = new Button("reset");
		rb1.setEffect(effect);
		rb1.setLayoutX(50);
		rb1.setLayoutY(10);
		rb2.setEffect(effect);
		rb2.setLayoutX(50);
		rb2.setLayoutY(50);
		rb3.setEffect(effect);
		rb3.setLayoutX(50);
		rb3.setLayoutY(90);
		rb5.setEffect(effect);
		rb5.setLayoutX(50);
		rb5.setLayoutY(130);
		group1.getChildren().addAll(rb1,rb2,rb3,rb5);
		group1.setTranslateY(10); 
		group1.setTranslateX(10);
		root.setLeft(group1);
		
		Group group2 = new Group();
		Button rb4 = new Button("regret");
		rb4.setEffect(effect);
		rb4.setLayoutX(-50);
		rb4.setLayoutY(10);
		group2.getChildren().addAll(rb4);
		group2.setTranslateY(10);
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
		rb3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	mode = 3;
                createGrids(gridpane);
                System.out.println(mode);
            }
        });
		rb4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
            	if(mode == 1) {
            	Circle regDisk = getdiskFromIndex(regretIndex,gridpane);
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
            }
            	}else if(mode == 2 || mode == 3) {
            		Circle regDisk = getdiskFromIndex(regretIndex,gridpane);
                	TranslateTransition translateTranstion = new TranslateTransition(Duration.millis(300), regDisk);
                	if(regDisk.getTranslateY()==0){
                        translateTranstion.setToY(-(nn*(regretRow+1)));
                        translateTranstion.play();
                        multi[regretRow][regretCol] = 0;
                	}
            		
                	Circle AIregDisk = getdiskFromIndex(AIregretIndex,gridpane);
                	TranslateTransition AItranslateTranstion = new TranslateTransition(Duration.millis(300), AIregDisk);
                	if(AIregDisk.getTranslateY()==0){
                		AItranslateTranstion.setToY(-(nn*(AIregretRow+1)));
                		AItranslateTranstion.play();
                        multi[AIregretRow][AIregretCol] = 0;
                }
            }
            }
        });
		
		rb5.setOnAction(e->{
			project_main open=new project_main();
			try
			{
				open.start(new Stage());
				primaryStage.close();
				multi = new int[6][7];
				//System.out.println(multi[2][6]);
				win = false;
				playerColorProperty.set(Color.RED);
				//System.out.println(win);
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
            Rectangle rect = new Rectangle(nn,nn); //100
            Circle circ = new Circle(nn/2-3); //47
            circ.centerXProperty().set(nn/2); //50格子中间的圆形
            circ.centerYProperty().set(nn/2);
            Shape cell = Path.subtract(rect, circ);
            cell.setFill(Color.BLUE);
            cell.setStroke(Color.BLUE);
            cell.setOpacity(.8);
            DropShadow effect = new DropShadow();
            effect.setSpread(.2);  //.2
            effect.setRadius(nn/4);  //25 //nn/4
            effect.setColor(Color.BLUE);
            cell.setEffect(effect);
            final Circle diskPreview = new Circle(nn/2-10);//40
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
            final Circle disk = new Circle(nn/2-10); //40
            disk.fillProperty().bind(playerColorProperty);
            disk.setOpacity(.8);
            disk.setTranslateY(-(nn*(r+1)));  //-(100*(r+1))
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
                    	regretIndex = regretRow * c + regretCol;
                    	/*
                    	System.out.println(rowIndex);
                    	System.out.println(colIndex); //get the position when click
                    	*/
                            if(disk.getTranslateY()!=0){
                            translateTranstion.setToY(0);
                            translateTranstion.play();
                            if(playerColorProperty.get()==Color.RED){
                            	multi[rowIndex][colIndex] = 1;
                            	System.out.println(multi[2][6]);
                            	win = connect4winner.redWin(multi);
                            	/*
                            	boolean redWin = tootWinner.redWinTOOT(multi);
                            	boolean yellowWin = tootWinner.yellowWinOTTO(multi);
                            	*/
                            	
                            	if(win == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[6][7];
                            				//System.out.println(multi[2][6]);
                            				win = false;
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
                              
                            }else{
                            
                            	multi[rowIndex][colIndex] = 2;
                            	win = connect4winner.yellowWin(multi);
                            	/*
                            	boolean redWin = tootWinner.redWinTOOT(multi);
                            	boolean yellowWin = tootWinner.yellowWinOTTO(multi);
                            	*/
                            	
                            	if(win == true) {
                            		System.out.println("yellow win");
                            		setConfirm.setContentText("yellow win");
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[6][7];
                            				//System.out.println(multi[2][6]);
                            				win = false;
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
                    	//red is person,yellow is AI
                            if(disk.getTranslateY()!=0){
                            
                            translateTranstion.setToY(0);
                            translateTranstion.play();
                        
                            if(playerColorProperty.get()==Color.RED){
                            	multi[rowIndex][colIndex] = 1;
                            	win = connect4winner.redWin(multi);
                            	if(win == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[6][7];
                            				//System.out.println(multi[2][6]);
                            				win = false;
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
                                int AIindex = randomai.AI(multi);
                                int AIrow = AIindex/c;
                                int AIcol = AIindex%c;
                                AIregretRow = AIrow;
                                AIregretCol = AIcol;
                                AIregretIndex = AIindex;
                                Circle AIdisk = getdiskFromIndex(AIindex,gridpane);
                                if(AIdisk.getTranslateY()!=0){
                                	/*
                                	try {
                                    	TimeUnit.SECONDS.sleep(1);
                                    	} catch (InterruptedException e) {
                                    	// TODO Auto-generated catch block
                                    	e.printStackTrace();
                                    	}
                                	*/
                                	TranslateTransition translateTranstionAI = new TranslateTransition(Duration.millis(300), AIdisk);
                                    translateTranstionAI.setToY(0);
                                    translateTranstionAI.play();
                                    multi[AIrow][AIcol] = 2;
                                    boolean AIwin = connect4winner.yellowWin(multi);
                                    if(AIwin == true) {
                                		System.out.println("AI win");
                                		setConfirm.setContentText("AI win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[6][7];
                                				//System.out.println(multi[2][6]);
                                				win = false;
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
            
            if(mode == 3) {
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
                    	//red is person,yellow is AI
                            if(disk.getTranslateY()!=0){
                            
                            translateTranstion.setToY(0);
                            translateTranstion.play();
                        
                            if(playerColorProperty.get()==Color.RED){
                            	multi[rowIndex][colIndex] = 1;
                            	win = connect4winner.redWin(multi);
                            	if(win == true) {
                            		System.out.println("red win");
                            		setConfirm.setContentText("red win");
                            		//setConfirm.showAndWait();
                            		Optional<ButtonType> result = setConfirm.showAndWait();
                            		if(result.get() == ButtonType.OK){
                            			project_main open=new project_main();
                            			try
                            			{
                            				open.start(new Stage());
                            				multi = new int[6][7];
                            				win = false;
                            				playerColorProperty.set(Color.RED);
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
                                int AIindex = smartai.AI(multi);
                                int AIrow = AIindex/c;
                                int AIcol = AIindex%c;
                                AIregretRow = AIrow;
                                AIregretCol = AIcol;
                                AIregretIndex = AIindex;
                                Circle AIdisk = getdiskFromIndex(AIindex,gridpane);
                                if(AIdisk.getTranslateY()!=0){
                                	TranslateTransition translateTranstionAI = new TranslateTransition(Duration.millis(300), AIdisk);
                                    translateTranstionAI.setToY(0);
                                    translateTranstionAI.play();
                                    multi[AIrow][AIcol] = 2;
                                    boolean AIwin = connect4winner.yellowWin(multi);
                                    if(AIwin == true) {
                                		System.out.println("AI win");
                                		setConfirm.setContentText("AI win");
                                		//setConfirm.showAndWait();
                                		Optional<ButtonType> result = setConfirm.showAndWait();
                                		if(result.get() == ButtonType.OK){
                                			project_main open=new project_main();
                                			try
                                			{
                                				open.start(new Stage());
                                				multi = new int[6][7];
                                				//System.out.println(multi[2][6]);
                                				win = false;
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
           // stack.getChildren().add(iv);
            gridpane.add(stack, c, r);
            
            /*
            if(gridpane.getChildren().size() == 16) {
            	System.out.println(gridpane.getChildren().get(15));
                if (gridpane.getChildren().get(15) instanceof StackPane) {
             	   StackPane stack1 = (StackPane) gridpane.getChildren().get(15);
             	   ObservableList<Node> childs = stack1.getChildren();
             	   if (childs.size() > 1) {
             	      // Top Component
             		   if (childs.get(childs.size()-1) instanceof Circle) {
             			   Circle topNode = (Circle)childs.get(childs.size()-1);
             			   Color c = (Color)topNode.getFill();
             			   System.out.println(c);
             		   }
             	     
             	   }
                }
            }
          */
                if(r==gridpane.getColumnConstraints().size()-1){
                    stack.setEffect(new Reflection());
                }
            }

             

        }

    }
    
   
}
