import java.util.*;

class scrambleString{

    public static void main(String[] args) {
        int ans = solve("great", "rgeat");

        System.out.println(ans);
    }


    public static Map<String,Integer> map = new HashMap<>();
    public static int solve(String str1, String str2){
        if(str1.length() == 1){
           if(str1.equals(str2))return 1;
           else return 0;
        }
 
         StringBuilder sb = new StringBuilder();
         sb.append(str1);
         sb.append(" ");
         sb.append(str2);
 
         String temp = sb.toString();
         if(map.containsKey(temp))return map.get(temp);
        
         int n = str1.length();
        for(int i=1;i<str1.length();i++){
            int flag = 0;
           if(solve(str1.substring(0, i), str2.substring(0, i)) == 1 && 
              solve(str1.substring(i), str2.substring(i)) ==1) {
                  flag = 1;
                //   break;
              }

            if(solve(str1.substring(0, i), str2.substring(n-i)) == 1 && 
              solve(str1.substring(i), str2.substring(0, n-i)) == 1) {
                  flag = 1;
                //   break;
              }
            if(flag == 1){
                map.put(temp, 1);
                return 1;
            }
            
        }
        
            map.put(temp, 0);
            return 0;
     }
}