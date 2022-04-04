import java.util.*;

class RomanToInteger{

    public static void main(String[] args) {
        
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        int sum = 0;
        
        //Idea:
        // Add the corresponding value to the sum and 
        // subtract if the value corresponding to ith element is < (i+1)th element

        
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
               
                sum -= map.get(s.charAt(i));
            }else{
                sum += map.get(s.charAt(i));
            }
        }
        
      
            sum += map.get(s.charAt(s.length() -1));
        
        return sum;
    }
}