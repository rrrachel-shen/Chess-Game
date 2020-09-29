package application;

public class connect4winner {
	public static int[][] multi = main.multi;
	public static int r = main.r;
	public static int c = main.c;
	
	public static boolean redWin(int[][] multi) {
		boolean flag = false;
		
        for(int i=r-1;i>=0;--i){
            for(int j=0;j<=c-1;++j){
                if(multi[i][j]==0 || multi[i][j]==2 ) {
                	continue;
                }
                
                //Checking cells to the right
                if(j<=c-4){
                            if(multi[i][j] == 1&&multi[i][j+1] ==1&&
                            		multi[i][j+2] == 1&&multi[i][j+3] == 1) {
                            	flag = true;
                            	return flag;
                            }  
                } 
                
                //Checking cells up
                if(i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j] == 1&&
                    		multi[i-2][j] == 1&&multi[i-3][j] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-4 && i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j+1] == 1&&
                    		multi[i-2][j+2] == 1&&multi[i-3][j+3] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=3 && i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j-1] == 1&&
                    		multi[i-2][j-2] == 1&&multi[i-3][j-3] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                	
                }  
            }
            
        }
   
		return flag;
	}
	
	public static boolean yellowWin(int[][] multi) {
		boolean flag = false;
		
        for(int i=r-1;i>=0;--i){
            for(int j=0;j<=c-1;++j){
                if(multi[i][j]==0 || multi[i][j]==1) {
                	continue;
                }
                
                //Checking cells to the right
                if(j<=c-4){
                            if(multi[i][j] == 2&&multi[i][j+1] == 2&&
                            		multi[i][j+2] == 2&&multi[i][j+3] == 2) {
                            	flag = true;
                            	return flag;
                            }  
                  
                } 
                
                //Checking cells up
                if(i>=3){
                	if(multi[i][j] == 2&&multi[i-1][j] == 2&&
                    		multi[i-2][j] == 2&&multi[i-3][j] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-4 && i>=3){
                	if(multi[i][j] == 2&&multi[i-1][j+1] == 2&&
                    		multi[i-2][j+2] == 2&&multi[i-3][j+3] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=3 && i>=3){
                	if(multi[i][j] == 2&&multi[i-1][j-1] == 2&&
                    		multi[i-2][j-2] == 2&&multi[i-3][j-3] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                	
                }  
            }
            
        }
   
		return flag;
	}
	

}
