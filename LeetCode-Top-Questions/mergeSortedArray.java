import java.util.*;

public class mergeSortedArray {
    

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        int m = nums1.length;
        int n = nums2.length;
        merge(nums1, m, nums2, n);

        for(int i: nums1){
            System.out.print(i +" ");
        }
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-n-1;
        int j = n - 1;
        int k = m-1;
        
        
        while(i >= 0 && j != -1){
            // if(i<0 || j<0)break;
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
                // System.out.println("Entered nums1");
            }
            
            else{
                nums1[k] = nums2[j];
                j--;
                k--;
                // System.out.println("Entered nums2");
            }

            // System.out.print(nums1[k] + " ");
        }
    }
}
