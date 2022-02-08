import java.util.*;

class FirstNonRepeating{

    public static void main(String[] args) {
        String str = "aabc";

        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        // queue.add(str.charAt(0));
        String ans = "";
        
        for(int i=0;i<str.length();i++){
           char ch = str.charAt(i);

           if(map.get(ch) == null)
           queue.add(ch);
           
           map.put(ch, map.getOrDefault(ch, 0)+1);

           while(queue.size() > 0 && map.get(ch) > 1){
               queue.poll();
           }
           if(queue.size() == 0)ans = ans + "-1";
           else ans = ans + queue.peek();
        }

        System.out.println(ans);
    }
}