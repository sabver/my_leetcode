package leetcode.hard;

public class Candy {
	/**
	 * Each child must have at least one candy.
	   Children with a higher rating get more candies than their neighbors.
	 * @param ratings
	 * @return
	 */
    public int candy(int[] ratings) {
    	int [] candys = new int[ratings.length];
    	for(int i=0;i<candys.length;i++){
    		candys[i] = 1;
    	}
    	for(int i=1;i<ratings.length;i++){
    		if( ratings[i] > ratings[i-1] && candys[i] <= candys[i-1]+1 ){
    			candys[i] = candys[i-1]+1;
    		}
    	}
    	for(int i=ratings.length-2;i>=0;i--){
    		if( ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
    			candys[i] = candys[i+1]+1;
    		}
    	}    	
    	int candyNum = 0;
    	for(int i=0;i<candys.length;i++){
    		candyNum+=candys[i];
    	}
        return candyNum; 
    }
}
