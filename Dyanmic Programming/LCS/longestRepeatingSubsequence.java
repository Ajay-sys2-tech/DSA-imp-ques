import java.util.*;
public class longestRepeatingSubsequence {
  public static void main(String[] args) {
      
  }  

  public int LongestRepeatingSubsequence(String str)
  {
      return lcs(str, str);
  }
  
  public static int lcs(String str1, String str2){
      int l1 = str1.length();
      int l2 = str2.length();
      
      int[][] dp = new int[l1+1][l2+1];
      
      for(int i=1;i<=l1;i++){
          for(int j=1;j<=l2;j++){
              if(i != j && str1.charAt(i-1) == str2.charAt(j-1)){
                  dp[i][j] = dp[i-1][j-1] + 1;
              }
              else{
                  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
              }
          }
      }
      
      return dp[l1][l2];
  }
}
