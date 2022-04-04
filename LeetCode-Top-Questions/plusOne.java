public class plusOne {
    
    public static void main(String[] args) {
        int[] digits = new int[]{};

        int[] ans = plusOneSolver(digits);

        
    }



    public static int[] plusOneSolver(int[] digits) {
        
        int n = digits.length;
        int carry = 1;
        
        for(int i=n-1;i>=0;i--){
            int sum = digits[i] + carry;
            // digits[i] = sum % 10;
            carry = sum /10;
            
            sum = sum % 10;
            digits[i] = sum;
            
        }
        
        if(carry <= 0) return digits;
        
        else{
            int[] ans = new int[n+1];
            ans[0] = carry;
            
            for(int i=0;i<digits.length;i++){
               ans[i+1]=digits[i];
           }
           return ans;
        }
        
    }
}
