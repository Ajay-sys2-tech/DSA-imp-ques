class SCS{


    public static void main(String[] args) {
        
    }


    public static int[][] dp;
    public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
       dp = new int[m+1][n+1];
       
       for(int i=0;i<=m;i++)
       Arrays.fill(dp[i], -1);
       
       return helper(x, y, m, n);
    }
    
    
    public static int helper(String x,String y,int m,int n){
        if(m==0 && n==0)return 0;
        else if(m==0) return n;
        else if(n==0) return m;
        
        if(dp[m][n] != -1)return dp[m][n];
        
        if(x.charAt(m-1) == y.charAt(n-1)){
            return dp[m][n] = 1 + helper(x, y, m-1, n-1);
        }
        
        
        else{
            return dp[m][n] = 1 + Math.min(helper(x, y, m-1, n),
                                helper(x, y, m, n-1));
        }
    }
}