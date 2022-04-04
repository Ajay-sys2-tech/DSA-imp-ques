import java.util.*;

public class sqrt {
    
    public static void main(String[] args) {
        
    }

// we used long because mul mid * mid results in integer overflow when
// another way to avoid it is achieving mul by performing division e.g. mid = x/mid (mid*mid = x) 
    public int mySqrt(int x) {
        long l = 1,r = x;
        while(l<=r){
            long mid = l + (r-l)/2;
            {
//              if( mid <= x/mid && (mid+1) > x/(mid+1)){
//                 return (int)mid;
//             }
            
//             if(mid > x/mid){
//                 r = mid;
//             }
//             //  if(mid < x) {
//             //     l = mid +1;
//             // }
//             else l = mid + 1;
               
            }
            
            System.out.println(mid);
            if(mid * mid == x)
                return (int)mid;        
            if(mid * mid <= x) 
                l = mid + 1;
            else 
                r = mid - 1;
        }
        
        return (int)l-1;
    }
}
