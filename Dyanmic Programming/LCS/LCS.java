class LCS{

    public static int[][] dp;
    public static void main(String[] args) {
        String a = "abcdefgh";
        String b = "abcdexhij";

        int l1 = a.length();
        int l2 = b.length();

        dp = new int[l1+1][l2+1];

        // for(int i=0;i<=l1;i++){                         //uncomment to use memo function 
        //     Arrays.fill(dp[i], -1);
        // }

        int ans = recursive(a, b, a.length(), b.length());
        System.out.println(ans);
    }


    public static int recursive(String a, String b, int l1, int l2){
        if(l1 == 0 || l2 == 0)return 0;

        if(a.charAt(l1-1) == b.charAt(l2-1))
        return 1 + recursive(a, b, l1-1, l2-1);

        else{
            return Math.max(recursive(a, b, l1-1, l2), recursive(a, b, l1, l2-1));
        }
    }

    public static int memo(String s1, String s2, int l1, int l2){
        
        if(l1 == 0 || l2 == 0)return 0;
        
        if(dp[l1][l2] != -1) return dp[l1][l2];
        
        if(s1.charAt(l1-1) == s2.charAt(l2-1))
            return dp[l1][l2] = 1+memo(s1, s2, l1-1, l2-1);
        
        else{
            return dp[l1][l2] = Math.max(memo(s1, s2, l1-1, l2), 
                                          memo(s1, s2, l1, l2-1));
        }
    }
    
    public static int tabulation(String s1, String s2, int l1, int l2){
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[l1][l2];
    }
}