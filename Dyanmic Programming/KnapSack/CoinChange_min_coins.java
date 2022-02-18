public class CoinChange_min_coins {
    public static void main(String[] args) {
        
    }

    public int[][] dp;
    
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        
        dp = new int[n + 1][amount + 1];
        
        for(int i=0;i<=amount;i++)
            dp[0][i] = Integer.MAX_VALUE-1;
        
        for(int i=1;i<=amount;i++){
             if(i % coins[0] != 0)
                dp[1][i] = Integer.MAX_VALUE-1;
             else 
                dp[1][i] = i / coins[0];
        }
           
       
         for(int i=2;i<=n;i++){
             for(int j=1;j<=amount;j++){
                 if(coins[i-1] <= j){
                   dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], 
                                              dp[i-1][j]);
                 }
                 
                 else 
                     dp[i][j] = dp[i-1][j];
                 
             }
         }
         
        if(dp[n][amount] == Integer.MAX_VALUE || 
           dp[n][amount] == Integer.MAX_VALUE-1)return -1;
         return dp[n][amount];
       }
    
    
}
