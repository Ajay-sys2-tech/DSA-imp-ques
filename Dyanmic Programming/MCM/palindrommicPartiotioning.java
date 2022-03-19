import java.util.*;

class palindrommicPartiotioning{


    public static void main(String[] args) {
        String str = "";
        int i = 0;
        int j = str.length()-1;
        
        int[][] dp = new int[j+2][j+2];
        
        for(int k=0;k<dp.length;k++){
            Arrays.fill(dp[k], -1);
        }
        
        int ans =  solve(str, i, j, dp);
    }


    public static int solve(String str, int i, int j, int[][] dp){
        if(i>=j)return 0;
        
        if(isPalindrome(str, i, j)== true)return 0;
        
        if(dp[i][j] != -1)return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            
            int temp = 1 + solve(str, i, k, dp) + solve(str, k+1, j, dp);
            
            min = Math.min(min, temp);
        }
        
        return dp[i][j] = min;
    }
    
    public static boolean isPalindrome(String str, int i, int j){
        
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
            return false;
            i++;
            j--;
        }
        
        return true;
    }
    
}