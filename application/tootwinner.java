package application;

public class tootwinner {
	public static int[][] multi = mainfortoot.multi;
	public static int r = mainfortoot.r;
	public static int c = mainfortoot.c;
	
	public static boolean redWinTOOT(int[][] multi) {
		boolean flag = false;
		
        for(int i=r-1;i>=0;--i){
            for(int j=0;j<=c-1;++j){
                if(multi[i][j]==0 || multi[i][j]==2 || multi[i][j]==3 || multi[i][j]==4) {
                	continue;
                }
                
                //Checking cells to the right
                if(j<=c-4){
                            if(multi[i][j] == 1&&multi[i][j+1] == 2&&
                            		multi[i][j+2] == 2&&multi[i][j+3] == 1) {
                            	flag = true;
                            	return flag;
                            }  
                } 
                
                //Checking cells up
                if(i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j] == 2&&
                    		multi[i-2][j] == 2&&multi[i-3][j] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-4 && i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j+1] == 2&&
                    		multi[i-2][j+2] == 2&&multi[i-3][j+3] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=3 && i>=3){
                	if(multi[i][j] == 1&&multi[i-1][j-1] == 2&&
                    		multi[i-2][j-2] == 2&&multi[i-3][j-3] == 1) {
                    	flag = true;
                    	return flag;
                    }  
                	
                }  
            }
            
        }
   
		return flag;
	}
	
	public static boolean yellowWinOTTO(int[][] multi) {
		boolean flag = false;
		
        for(int i=r-1;i>=0;--i){
            for(int j=0;j<=c-1;++j){
                if(multi[i][j]==0 || multi[i][j]==1 || multi[i][j]==2 || multi[i][j]==3) {
                	continue;
                }
                
                //Checking cells to the right
                if(j<=c-4){
                            if(multi[i][j] == 4&&multi[i][j+1] == 3&&
                            		multi[i][j+2] == 3&&multi[i][j+3] == 4) {
                            	flag = true;
                            	return flag;
                            }  
                  
                } 
                
                //Checking cells up
                if(i>=3){
                	if(multi[i][j] == 4&&multi[i-1][j] == 3&&
                    		multi[i-2][j] == 3&&multi[i-3][j] == 4) {
                    	flag = true;
                    	return flag;
                    }  
                    
                } 
                
                //Checking diagonal up-right
                if(j<=c-4 && i>=3){
                	if(multi[i][j] == 4&&multi[i-1][j+1] == 3&&
                    		multi[i-2][j+2] == 3&&multi[i-3][j+3] == 4) {
                    	flag = true;
                    	return flag;
                    }  
                    
                }
                
                //Checking diagonal up-left
                if(j>=3 && i>=3){
                	if(multi[i][j] == 4&&multi[i-1][j-1] == 3&&
                    		multi[i-2][j-2] == 3&&multi[i-3][j-3] == 4) {
                    	flag = true;
                    	return flag;
                    }  
                	
                }  
            }
            
        }
   
		return flag;
	}
	

}
