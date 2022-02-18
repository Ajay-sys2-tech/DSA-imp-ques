class Knapsack{


    public static void main(String[] args) {
        
    }



     //Function to return max value that can be put in knapsack of capacity W.
     public static int[][] dp ;
     static int knapSack(int W, int wt[], int val[], int n) 
     { 
        dp = new int[n+1][W+1];
        
        int ans = tabulation(W, wt, val, n);
        
        return ans;
     } 
     
     static int helper(int W, int wt[], int val[], int n){
         if(n==0 || W==0)
         return 0;
         
         if(dp[n][W] != 0) return dp[n][W];
         if(wt[n-1] <= W){
             int inc = val[n-1] + helper(W-wt[n-1], wt, val, n-1);
             int exc = helper(W, wt, val, n-1);
             
             return dp[n][W] = Math.max(inc, exc);
         }
         
         else if(wt[n-1] > W) return dp[n][W] = helper(W, wt, val, n-1);
         
         return 0;
     }
     
     static int tabulation(int W, int wt[], int val[], int n){
         int[][] dp = new int[n+1][W+1];
         
         for(int i=1;i<=n;i++){
             for(int j=1;j<=W;j++){
                 if(wt[i-1] <= j){
                     dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                 }
                 
                 else dp[i][j] = dp[i-1][j];
             }
         }
         
         return dp[n][W];
         
     //     for(int i=1;i<=n;i++){
     //         for(int j=1;j<=W;j++){
     //             if(wt[i-1] > j ){
     //                 dp[i][j] = dp[i-1][j];
     //             }else{
                     
     //                 dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]] , dp[i-1][j] );
                     
     //             }
                 
                 
     //         }
     //     }
     //   return dp[n][W]; 
     }
}