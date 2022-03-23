import java.util.*;

class booleanParenthesization{

    public static void main(String[] args) {
        
    }



    static int countWays(int N, String S){
        Map<String,Integer> mp=new HashMap<>();
       return solve(S, 0, S.length() - 1, true, mp);
   }
   
   
   public static int solve(String str, int i, int j, boolean isTrue,  Map<String,Integer> mp){
       if(i>j)return 0;
       if(i==j){
         if(isTrue==true){
             return (str.charAt(i)=='T') ? 1 : 0;
         }
         else{
             return (str.charAt(i)=='F') ? 1 : 0;
         }
     }
       
     StringBuilder sb=new StringBuilder();
     sb.append(Integer.toString(i));
     sb.append(" ");
     sb.append(Integer.toString(j));
     sb.append(" ");
     sb.append(Boolean.toString(isTrue));
     String temp=sb.toString();
       
       int ans = 0;
       
         if(mp.containsKey(temp)){
           return mp.get(temp);
         }
     
     
       for(int k=i+1;k<=j-1;k+=2){
           int lt = solve(str, i, k-1, true, mp);
           int rt = solve(str, k+1, j, true, mp);
           int lf = solve(str, i, k-1, false, mp);
           int rf = solve(str, k+1, j, false, mp);
           
           if(str.charAt(k) == '&'){
               if(isTrue == true)
                ans = ans + (lt * rt);
               else
                  ans+=(lt*rf)+(rt*lf)+(rf*lf);
           }else if(str.charAt(k) == '^'){
                if(isTrue == true){
                 ans+=(lt*rf)+(lf*rt);
             }
             else{
                 ans+=(lf*rf)+(rt*lt);
             }
           }else if(str.charAt(k) == '|'){
                 if(isTrue == true){
                 ans+=(lt*rt)+(lt*rf)+(rt*lf);
             }
             else{
                 ans+=(lf*rf);
             }
           }
       }
       
        mp.put(temp,ans%1003);
       return mp.get(temp);
       
   }
}