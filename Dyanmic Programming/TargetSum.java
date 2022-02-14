import java.util.HashMap;

class TargetSum{


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};

        int ans = findTargetSumWays(arr, 3);

        System.out.println(ans);
    }


    public int findTargetSumWays(int[] nums, int target) {
        
        
        int n = nums.length;
        
        int sum = 0;
        int zero = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0)zero++;
            sum += nums[i];
        }
        
        if(target > sum || target < -sum) return 0;
        count = 0;
        
        // recursive(nums, target, 0, 0);
        HashMap<String, Integer> memo = new HashMap<>();
        
        // return memorization(0, target, 0, nums, memo);
        if((sum + target) % 2 == 0){
            // if(zero == 0) return tabulation(nums, target, sum); 
           // else
               // if(zero > 1)
               //     return (int)Math.pow(2, zero) *
               //     tabulation(nums, target, sum);  
               return tabulation(nums, target, sum);  
        }
       
        
        return 0;
        
        
        }
    
    public static int memorization(int i, int target, int sum, int[] nums,  HashMap<String, Integer> memo){
            

            if(i == nums.length){
                return sum == target ? 1 : 0;
            }

            String key = new StringBuilder().append(i).append(",").append(sum).toString();

            if(!memo.containsKey(key)){
                int add = memorization(i+1, target, sum + nums[i], nums, memo);
                int diff = memorization(i+1, target, sum - nums[i], nums, memo);

                memo.put(key, add + diff);
            }

            return memo.get(key);

        }
    
    public int count = 0;
    public void recursive(int[] nums, int target, int i, int sum){
        if(i == nums.length){
            if(sum == target){
                count += 1;
            }
            return;
        }
        
        
             recursive(nums, target, i+1, sum + nums[i]); 
             recursive(nums, target, i+1, sum - nums[i]);

    }
    
    
    public static  int tabulation(int[] nums, int diff, int sum){
       
        int n = nums.length;
        
        sum = (sum + diff) / 2;
        
        int[][] dp = new int[n+1][sum + 1];
        
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        
        return dp[n][sum];
    }
}