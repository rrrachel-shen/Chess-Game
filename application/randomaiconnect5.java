package application;

import java.util.Random;
import java.util.Vector;

public class randomaiconnect5 {
	public static int r = connect5winner.r;
	public static int c = connect5winner.c;
	
	public static int randomAI(int[][] multi) {
		Vector<Integer> vector = new Vector<>(); 
		int index = -1;
		for (int x = 0;x<r-1;x++) {
			for(int y = 0;y<c-1;y++) {
				 if(multi[x][y] == 0) {
					 index = x * c + y;
					  vector.add(index);
				 }
				 
			}
			
		}
		if (vector.size() == 0) {
			return -1;
		}else {
		int rnd = new Random().nextInt(vector.size());
		   index = vector.get(rnd);
		return index;
		}
	}

}
