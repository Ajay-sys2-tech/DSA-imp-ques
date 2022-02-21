import java.util.*;

class SCS{

    public static int[][] dp;

    public static void main(String[] args) {

        String x = "Geek";
        String y = "eke";

        int m = x.length();
        int n = y.length();

        dp = new int[m+1][n+1];
       
        for(int i=0;i<=m;i++)
        Arrays.fill(dp[i], -1);

        System.out.println(memorization(x, y, m, n));
    }


    
    public static int recursive(String x,String y,int m,int n)
    {
        if(m==0 && n==0)return 0;
        else if(m==0) return n;
        else if(n==0) return m;
        
       
        if(x.charAt(m-1) == y.charAt(n-1)){
            return 1 + recursive(x, y, m-1, n-1);
        }
        
        
        else{
            return 1 + Math.min(recursive(x, y, m-1, n),
                                           recursive(x, y, m, n-1));
        }
       
       
    }
    
    
    public static int memorization(String x,String y,int m,int n){
        if(m==0 && n==0)return 0;
        else if(m==0) return n;
        else if(n==0) return m;
        
        if(dp[m][n] != -1)return dp[m][n];
        
        if(x.charAt(m-1) == y.charAt(n-1)){
            return dp[m][n] = 1 + memorization(x, y, m-1, n-1);
        }
        
        
        else{
            return dp[m][n] = 1 + Math.min(memorization(x, y, m-1, n),
                                           memorization(x, y, m, n-1));
        }
    }

    public static int tabulation(String x, String y, int m, int n){

        dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }

                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }



}