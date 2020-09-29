package application;

import java.util.Random;
import java.util.Vector;

public class randomai {
	public static int r = main.r;
	public static int c = main.c;
	public static int AI (int[][] multi) {
		   Vector<Integer> vector = new Vector<>(); 
		   int index;
		   for(int y = 0; y<c-1;y++) {
			   int x = r-1;
			   while(multi[x][y] != 0 ) {
				   if(x > 0) {
					   x = x - 1;
				   }else {
					   break;
				   }
				   
			}
			   if(x == 0&&multi[x][y] != 0) {
				   continue;
			   }else {
			   index = x * c + y;
			   vector.add(index);
			   }
		   }
			
		   int rnd = new Random().nextInt(vector.size());
		   index = vector.get(rnd);
		   return index;
	   }

}
