import java.util.HashMap;

class TargetSum{


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};

        int ans = findTargetSumWays(arr, 3);

        System.out.println(ans);
    }


    public static int findTargetSumWays(int[] nums, int target) { 
        
        int n = nums.length;
       
        count = 0;
        recursive(nums, target, 0, 0);
        return count;
        }
    


    public static int count = 0;
    public static int[][] dp;

        public static int memorization(int i, int target, int sum, int[] nums){
            HashMap<String, Integer> memo = new HashMap<>();

            if(i == nums.length){
                return sum == target ? 1 : 0;
            }

            String key = new StringBuilder().append(i).append(",").append(sum).toString();

            if(!memo.containsKey(key)){
                int add = memorization(i+1, target, sum + nums[i], nums);
                int diff = memorization(i+1, target, sum - nums[i], nums);

                memo.put(key, add + diff);
            }

            return memo.get(key);

        }

    public static void recursive(int[] nums, int target, int i, int sum){
        if(i == nums.length){
            if(sum == target){
                count += 1;
            }
            
        }
       
        recursive(nums, target, i+1, sum + nums[i]); 
        recursive(nums, target, i+1, sum - nums[i]);

        }
}