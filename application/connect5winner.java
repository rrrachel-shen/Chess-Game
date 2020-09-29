package application;

public class connect5winner {
	public static int[][] multi = connect5.multi;
	public static int r = connect5.r;
	public static int c = connect5.c;
	
	public static boolean redWin(int[][] multi) {
		boolean flag = false;
		
        for(int i=r-1;i>=0;--i){
            for(int j=0;j<=c-1;++j){
                if(multi[i][j]==0 || multi[i][j]==2 ) {
                	continue;
                }
                
                //Checking cells to the right
                if(j<=c-5){
                            if(multi[i][j] == 1&&multi[i][j+1] ==1&&
                            		multi[i][j+2] == 1&&multi[i][j+3] == 1
                            		&&multi[i][j+4] == 1) {
                            	flag = true;
                            	return flag;
                            }  
                } 
                
                //Checking cells up
                if(i>=4){
                	if(multi[i][j] == 1&&multi[i-1][j] == 1&&
                    		multi[i-2][j] == 1&&multi[i-3][j] == 1
                    		&&multi[i-4][j] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-5 && i>=4){
                	if(multi[i][j] == 1&&multi[i-1][j+1] == 1&&
                    		multi[i-2][j+2] == 1&&multi[i-3][j+3] == 1
                    		&&multi[i-4][j+4] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=4 && i>=4){
                	if(multi[i][j] == 1&&multi[i-1][j-1] == 1&&
                    		multi[i-2][j-2] == 1&&multi[i-3][j-3] == 1
                    		&&multi[i-4][j-4] == 1) {
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
                if(j<=c-5){
                            if(multi[i][j] == 2&&multi[i][j+1] == 2&&
                            		multi[i][j+2] == 2&&multi[i][j+3] == 2
                            		&&multi[i][j+4] == 2) {
                            	flag = true;
                            	return flag;
                            }  
                  
                } 
                
                //Checking cells up
                if(i>=4){
                	if(multi[i][j] == 2&&multi[i-1][j] == 2&&
                    		multi[i-2][j] == 2&&multi[i-3][j] == 2
                    		&&multi[i-4][j] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-5 && i>=4){
                	if(multi[i][j] == 2&&multi[i-1][j+1] == 2&&
                    		multi[i-2][j+2] == 2&&multi[i-3][j+3] == 2
                    		&&multi[i-4][j+4] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=4 && i>=4){
                	if(multi[i][j] == 2&&multi[i-1][j-1] == 2&&
                    		multi[i-2][j-2] == 2&&multi[i-3][j-3] == 2
                    		&&multi[i-4][j-4] == 2) {
                    	flag = true;
                    	return flag;
                    }  
                	
                }  
            }
            
        }
   
		return flag;
	}
	

}
