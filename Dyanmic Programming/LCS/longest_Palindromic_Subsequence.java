import java.util.*;
public class longest_Palindromic_Subsequence {
    
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();

        // System.out.println(isPalindrome(s));

        int tabAns = tabulation(s, rev);
        System.out.println(tabAns);
    }

    public static int max = Integer.MIN_VALUE;
    public static void recursive(String s, String ans){
        if(s.length() == 0){
            if(isPalindrome(ans) == true)
            max = Math.max(max, ans.length());
            return;
        }

        recursive(s.substring(1), ans + s.charAt(0));
        recursive(s.substring(1), ans);
    }

    public static int tabulation(String ori, String rev){
        int l1 = ori.length();
        int l2 = rev.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){

                if(ori.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }

    public static boolean isPalindrome(String s){
        int n = s.length();

        for(int i=0; i<n/2; i++){
            if(s.charAt(i) != s.charAt(n-1-i))return false;
        }

        return true;
    }
}
