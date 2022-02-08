import java.util.PriorityQueue;

import java.util.*;
class RangeFromKLists{


    public static void main(String[] args) {
        Integer arr1[] = new Integer[]{4, 7, 9, 12, 15};
        Integer arr2[] = new Integer[]{0, 8, 10, 14, 20};
        Integer arr3[] = new Integer[]{6, 12, 16, 30, 50};

       List<List<Integer>> nums = new ArrayList<>();

       nums.add(Arrays.asList(arr1));
       nums.add(Arrays.asList(arr2));
       nums.add(Arrays.asList(arr3));


        int[] ans = findRange(nums);

        System.out.println(ans[0] + " " + ans[1]);


    }

    public static int[] findRange(List<List<Integer>> nums){
        int[] ans = new int[]{-100000, 1000000};   //initial range
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 

        //pq is of type int[] = new int[3] where 0th will be the actual value, 
        // 1st will be the index of the elemnt in the list so that we can go to next 
        // element and then 2nd will be the index of the list

        int k = nums.size();            // no. of lists
        int max = Integer.MIN_VALUE;   // var to store curr max
        
        for(int i=0;i<k;i++){
            int mol = nums.get(i).get(0);
            int[] tba = new int[]{mol, 0, i};
            pq.add(tba);

            max = Math.max(mol, max);
        }
        
        while(true){
            int[] rem = pq.poll();

            if(max - rem[0] < ans[1] - ans[0]){
                ans[0] = rem[0];
                ans[1] = max;
            }

            rem[1]++;
            List<Integer> currList = nums.get(rem[2]); //curr list in the pq from which the element is removed 
            int size = currList.size();

            if(rem[1] == size)
            break;

            else{
                rem[0] = currList.get(rem[1]);
                max = Math.max(max, rem[0]);
                pq.add(rem);
            }
        }

        return ans;
    }
}