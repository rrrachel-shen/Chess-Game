package application;

public class smartai {
	public static int[][] multi = main.multi;
	public static int r = main.r;
	public static int c = main.c;
	/*
	class Board{
	    byte[][] board = new byte[6][7];
	    
	    public Board(){
	        board = new byte[][]{
	            {0,0,0,0,0,0,0,},
	            {0,0,0,0,0,0,0,},
	            {0,0,0,0,0,0,0,},
	            {0,0,0,0,0,0,0,},
	            {0,0,0,0,0,0,0,},
	            {0,0,0,0,0,0,0,},    
	        };
	    } 
	    */
	    public static boolean isLegalMove(int column){
	        return multi[0][column]==0;
	    }
	    
	    
	    //Placing a Move on the board
	    public static boolean placeMove(int column, int player){ 
	        if(!isLegalMove(column)) {System.out.println("Illegal move!"); return false;}
	        for(int i=r-1;i>=0;--i){
	            if(multi[i][column] == 0) {
	            	multi[i][column] = player;
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static void undoMove(int column){
	        for(int i=0;i<=r-1;++i){
	            if(multi[i][column] != 0) {
	            	multi[i][column] = 0;
	                break;
	            }
	        }        
	    }
	    
	    
	    /*
	    //Printing the board
	    public void displayBoard(){
	        System.out.println();
	        for(int i=0;i<=5;++i){
	            for(int j=0;j<=6;++j){
	                System.out.print(board[i][j]+" ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	}
*/
	//public class Connect4AI { 
	 //   private Board b;
	 //   private Scanner scan;
	    public static int nextMoveLocation=-1;
	    public static int maxDepth = 3;
	    /*
	    public Connect4AI(Board b){
	        this.b = b;
	        scan = new Scanner(System.in);
	    }
	    */
	    
	    
	    //Opponent's turn
	    
	    /*
	    public void letOpponentMove(){
	        System.out.println("Your move (1-7): ");
	        int move = scan.nextInt();
	        while(move<1 || move > 7 || !b.isLegalMove(move-1)){
	            System.out.println("Invalid move.\n\nYour move (1-7): "); 
	            move = scan.nextInt();
	        }
	        
	        //Assume 2 is the opponent
	        b.placeMove(move-1, (byte)2); 
	    }
	    */
	    
	    
	    //Game Result
	    public static int gameResult(int[][] multi){
	        int aiScore = 0, humanScore = 0;
	        for(int i=r-1;i>=0;--i){
	            for(int j=0;j<=c-1;++j){
	                if(multi[i][j]==0) continue;
	                
	                //Checking cells to the right
	                if(j<=c-4){
	                    for(int k=0;k<4;++k){ 
	                            if(multi[i][j+k]==2) aiScore++;
	                            else if(multi[i][j+k]==1) humanScore++;
	                            else break; 
	                    }
	                    if(aiScore==4)return 2; else if (humanScore==4)return 1;
	                    aiScore = 0; humanScore = 0;
	                } 
	                
	                //Checking cells up
	                if(i>=3){
	                    for(int k=0;k<4;++k){
	                            if(multi[i-k][j]==2) aiScore++;
	                            else if(multi[i-k][j]==1) humanScore++;
	                            else break;
	                    }
	                    if(aiScore==4)return 2; else if (humanScore==4)return 1;
	                    aiScore = 0; humanScore = 0;
	                } 
	                
	                //Checking diagonal up-right
	                if(j<=c-4 && i>= 3){
	                    for(int k=0;k<4;++k){
	                        if(multi[i-k][j+k]==2) aiScore++;
	                        else if(multi[i-k][j+k]==1) humanScore++;
	                        else break;
	                    }
	                    if(aiScore==4)return 2; else if (humanScore==4)return 1;
	                    aiScore = 0; humanScore = 0;
	                }
	                
	                //Checking diagonal up-left
	                if(j>=3 && i>=3){
	                    for(int k=0;k<4;++k){
	                        if(multi[i-k][j-k]==2) aiScore++;
	                        else if(multi[i-k][j-k]==1) humanScore++;
	                        else break;
	                    } 
	                    if(aiScore==4)return 2; else if (humanScore==4)return 1;
	                    aiScore = 0; humanScore = 0;
	                }  
	            }
	        }
	        
	        for(int j=0;j<c;++j){
	            //Game has not ended yet
	            if(multi[0][j]==0)return -1;
	        }
	        //Game draw!
	        return 0;
	    }
	    
	    
	    
	    public static int calculateScore(int aiScore, int moreMoves){   
	        int moveScore = 4 - moreMoves;
	        if(aiScore==0)return 0;
	        else if(aiScore==1)return 1*moveScore;
	        else if(aiScore==2)return 10*moveScore;
	        else if(aiScore==3)return 100*moveScore;
	        else return 1000;
	    }
	    
	    //Evaluate board favorableness for AI
	    public static int evaluateBoard(int[][] multi){
	      
	        int aiScore=1;
	        int score=0;
	        int blanks = 0;
	        int k=0, moreMoves=0;
	        for(int i=r-1;i>=0;--i){
	            for(int j=0;j<=c-1;++j){
	                
	                if(multi[i][j]==0 || multi[i][j]==1) continue; 
	                
	                if(j<=c-4){ 
	                    for(k=1;k<4;++k){
	                        if(multi[i][j+k]==2)aiScore++;
	                        else if(multi[i][j+k]==1){aiScore=0;blanks = 0;break;}
	                        else blanks++;
	                    }
	                     
	                    moreMoves = 0; 
	                    if(blanks>0) 
	                        for(int c=1;c<4;++c){
	                            int column = j+c;
	                            for(int m=i; m<= r-1;m++){
	                             if(multi[m][column]==0)moreMoves++;
	                                else break;
	                            } 
	                        } 
	                    
	                    if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
	                    aiScore=1;   
	                    blanks = 0;
	                } 
	                
	                if(i>=3){
	                    for(k=1;k<4;++k){
	                        if(multi[i-k][j]==2)aiScore++;
	                        else if(multi[i-k][j]==1){aiScore=0;break;} 
	                    } 
	                    moreMoves = 0; 
	                    
	                    if(aiScore>0){
	                        int column = j;
	                        for(int m=i-k+1; m<=i-1;m++){
	                         if(multi[m][column]==0)moreMoves++;
	                            else break;
	                        }  
	                    }
	                    if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
	                    aiScore=1;  
	                    blanks = 0;
	                }
	                 
	                if(j>=3){
	                    for(k=1;k<4;++k){
	                        if(multi[i][j-k]==2)aiScore++;
	                        else if(multi[i][j-k]==1){aiScore=0; blanks=0;break;}
	                        else blanks++;
	                    }
	                    moreMoves=0;
	                    if(blanks>0) 
	                        for(int c=1;c<4;++c){
	                            int column = j- c;
	                            for(int m=i; m<= r-1;m++){
	                             if(multi[m][column]==0)moreMoves++;
	                                else break;
	                            } 
	                        } 
	                    
	                    if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
	                    aiScore=1; 
	                    blanks = 0;
	                }
	                 
	                if(j<=c-4 && i>=3){
	                    for(k=1;k<4;++k){
	                        if(multi[i-k][j+k]==2)aiScore++;
	                        else if(multi[i-k][j+k]==1){aiScore=0;blanks=0;break;}
	                        else blanks++;                        
	                    }
	                    moreMoves=0;
	                    if(blanks>0){
	                        for(int c=1;c<4;++c){
	                            int column = j+c, row = i-c;
	                            for(int m=row;m<=r-1;++m){
	                                if(multi[m][column]==0)moreMoves++;
	                               // else if(multi[m][column]==1);
	                                else break;
	                            }
	                        } 
	                        if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
	                        aiScore=1;
	                        blanks = 0;
	                    }
	                }
	                 
	                if(i>=3 && j>=3){
	                    for(k=1;k<4;++k){
	                        if(multi[i-k][j-k]==2)aiScore++;
	                        else if(multi[i-k][j-k]==1){aiScore=0;blanks=0;break;}
	                        else blanks++;                        
	                    }
	                    moreMoves=0;
	                    if(blanks>0){
	                        for(int c=1;c<4;++c){
	                            int column = j-c, row = i-c;
	                            for(int m=row;m<=r-1;++m){
	                                if(multi[m][column]==0)moreMoves++;
	                                else if(multi[m][column]==1);
	                                else break;
	                            }
	                        } 
	                        if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
	                        aiScore=1;
	                        blanks = 0;
	                    }
	                } 
	            }
	        }
	        return score;
	    } 
	    
	    public static int minimax(int depth, int turn, int alpha, int beta){
	        
	        if(beta<=alpha){if(turn == 2) return Integer.MAX_VALUE; else return Integer.MIN_VALUE; }
	        int gameResult = gameResult(multi);
	        
	        if(gameResult==2)return Integer.MAX_VALUE/2;
	        else if(gameResult==1)return Integer.MIN_VALUE/2;
	        else if(gameResult==0)return 0; 
	        
	        if(depth==maxDepth) {
	        	System.out.println(evaluateBoard(multi));
	        	return evaluateBoard(multi);
	        }
	        
	        int maxScore=Integer.MIN_VALUE, minScore = Integer.MAX_VALUE;
	                
	        for(int j=0;j<=c-1;++j){
	            
	            int currentScore = 0;
	            
	            if(isLegalMove(j) == false) continue; 
	            
	            if(turn==2){
	            	    placeMove(j, 2);
	                    currentScore = minimax(depth+1, 1, alpha, beta);
	                    
	                    if(depth==0){
	                    	System.out.println(j);
	                        System.out.println("Score for location "+j+" = "+currentScore);
	                        if(currentScore > maxScore)nextMoveLocation = j; 
	                        if(currentScore == Integer.MAX_VALUE/2){undoMove(j);break;}
	                    }
	                    
	                    maxScore = Math.max(currentScore, maxScore);
	                    
	                    alpha = Math.max(currentScore, alpha);  
	            } 
	            else if(turn==1){
	                    placeMove(j, 1);
	                    currentScore = minimax(depth+1, 2, alpha, beta);
	                    minScore = Math.min(currentScore, minScore);
	                    
	                    beta = Math.min(currentScore, beta); 
	            }  
	            undoMove(j); 
	            if(currentScore == Integer.MAX_VALUE || currentScore == Integer.MIN_VALUE) break; 
	        }  
	        return turn==2?maxScore:minScore;
	    }
	    
	    public static int getAIMove(){
	        nextMoveLocation = -1;
	        minimax(0, 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        System.out.println(nextMoveLocation);
	        
	        return nextMoveLocation;
	    }
	    
	    
	    public static int AI(int[][] multi) {
	    	int Index = -1;
	    	int moveCol = getAIMove();
	    	for(int i = r-1;i>=0;i--) {
	    		if(multi[i][moveCol] == 0) {
	    			System.out.println(moveCol);
	    			Index = i*c + moveCol;
	    			break;
	    		}
	    	}
	    	return Index;
	    }
	    /*
	    public void playAgainstAIConsole(){
	        int humanMove=-1;
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Would you like to play first? (yes/no) ");
	        String answer = scan.next().trim();
	        
	       if(answer.equalsIgnoreCase("yes")) letOpponentMove();
	        b.displayBoard();
	        b.placeMove(3, 1);
	        b.displayBoard();
	        
	        while(true){ 
	            letOpponentMove();
	            b.displayBoard();
	            
	            int gameResult = gameResult(b);
	            if(gameResult==1){System.out.println("AI Wins!");break;}
	            else if(gameResult==2){System.out.println("You Win!");break;}
	            else if(gameResult==0){System.out.println("Draw!");break;}
	            
	            b.placeMove(getAIMove(), 1);
	            b.displayBoard();
	            gameResult = gameResult(b);
	            if(gameResult==1){System.out.println("AI Wins!");break;}
	            else if(gameResult==2){System.out.println("You Win!");break;}
	            else if(gameResult==0){System.out.println("Draw!");break;}
	        }
	        
	    }
	    
	    public static void main(String[] args) {
	        Board b = new Board();
	        Connect4AI ai = new Connect4AI(b);  
	        ai.playAgainstAIConsole();
	    }
	}
*/


}
