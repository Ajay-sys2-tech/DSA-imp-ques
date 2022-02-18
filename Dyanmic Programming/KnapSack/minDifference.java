import java.util.*;

class minDifference{


    public static void main(String[] args) {
        
    }


    public int minDifference(int arr[], int n) 
	{ 
	    int range = 0;
	    for(int i=0;i<n;i++)
	     range += arr[i];
	     
	    boolean[][] dp = new boolean[n+1][range + 1];
	    for(int i=0;i<=n;i++)
	     dp[i][0] = true;
	     
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=range;j++){
	            if(arr[i-1] <= j){
	                dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j]; 
	            }
	            else dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    
	    List<Integer> list = new ArrayList<>();
	    
	    for(int i=0;i<=range/2;i++){
	        if(dp[n][i] == true)
	        list.add(i);
	    }
	    
	    int min = Integer.MAX_VALUE;
	    
	    for(int i: list){
	        min = Math.min(min, range - 2*i);
	    }
	    
	    return min;
	} 
}