import java.util.*;
class AnagramOccurence{

    public static void main(String[] args) {
        String str = "";
        String pat = "";

        List<Integer> ans = findAnagrams(str, pat);

        System.out.println();
    }

// public HashMap<Character, Integer> map = new HashMap<>();
    
public static List<Integer> findAnagrams(String str, String pat) {
    int n = str.length();
    int k = pat.length();
    
    if(k>n)return new ArrayList<>();
    
    HashMap<Character, Integer> map = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    
    // filling the map with the frequency of characters of pattern
    for(int i=0;i<pat.length();i++){
        char ch = pat.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    
    for(int i=0;i<pat.length();i++){
        char ch = str.charAt(i);
        map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }
    
    List<Integer> ans = new ArrayList<>();
    
    // String window = "";
    // int i=0;
    int j=0;
    
    for(int i=pat.length();i<n;i++){
        if(map.equals(map2))ans.add(j);
        
        char ch = str.charAt(i);
        
        map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        
        char c = str.charAt(j);
        map2.put(c, map2.getOrDefault(c, 0) - 1);
        
        if(map2.get(c) <= 0)
            map2.remove(c);
        
        j++;
    }
    
     if(map.equals(map2))ans.add(j);
    
    return ans;
    
}

// public boolean isAnagram(String str){
    
     
//          HashMap<Character, Integer> map2 = new HashMap<>();
    
    
    
//         // decreasing the frequency of characters in map with the str 
//         for(int i=0;i<str.length();i++){
//             char ch = str.charAt(i);
        
//             if(map.containsKey(ch)){
//                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
//             }
        
//             else return false;
//         }
    
    
//         // checking if there is any character with frequency != 0
//         for(Character ch: map.keySet()){
//             if(map2.containsKey(ch)){
//                 if(map.get(ch) != map2.get(ch))return false;
//             }
//         }
    
//         return true;
//     }
}