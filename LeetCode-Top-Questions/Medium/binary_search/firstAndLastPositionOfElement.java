import java.util.*;

class firstAndLastPositionOfElement{

    public static void main(String[] args) {
        
    }

    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int beg = 0;
        int end = n-1;
        int idx = -1;
        
        int[] ans = new int[2];
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            
            if(nums[mid] >= target)end = mid-1;
            else beg = mid + 1;
            
            if(nums[mid] == target)idx = mid;
        }
        
        ans[0] = idx;
        
        idx = -1;
        beg = 0;
        end = n - 1;
        
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            
            if(nums[mid] <= target)beg = mid + 1;
            else end = mid - 1;
            if(nums[mid] == target)idx = mid;
        }
        
        ans[1] = idx;
        
        return ans;
    }
}