// Rearrange characters in a string such that no two adjacent are same

// https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/


// Steps

// 1. Make a priorityQueue(max Heap) of type pair where pair contains character and its frequency
// 2. Make a prev variable of type pair which will store the used character
// 3. now poll(and store it in rem variable) from the pq and add the character to the ans string and  
//    decrease its frequency then assign rem to the prev variable if freq is > 0
// 4. Do this until queue is not empty
// 5. If the size of ans anf the given stirng is equal return ans else return not possible

import java.util.*;
public class RearrangeCharacters {
    

    public static void main(String[] args) {
        
    }



}
