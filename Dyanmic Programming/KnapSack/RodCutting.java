class RodCutting{

    public static void main(String[] args) {
        
    }


    public int cutRod1(int price[], int n) {
        
        int[] len = new int[price.length];
        
        for(int i=0;i<price.length;i++)
        len[i] = i+1;
        
        int[][] dp = new int[price.length + 1][n+1];
        
        for(int i=1;i<=price.length;i++){
            for(int j=1;j<=n;j++){
                if(len[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1] ], dp[i-1][j]);
                }
                
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        
        return dp[price.length][n];
    }
    
    
    public int cutRod(int price[], int n) {
        
       int[] dp = new int[n+1];
       
       for(int i=1;i<=n;i++){
           int max = Integer.MIN_VALUE;
           for(int j=1;j<=i;j++){
               int curr = price[j-1] + dp[i-j];
               max = Math.max(max, curr);
           }
           
           dp[i] = max;
       }
       
       return dp[n];
    }
}