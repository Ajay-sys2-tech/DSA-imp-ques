import java.util.*;

class ConnectNRopes{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        long ans = minCost(arr, n);

        System.out.println(ans);
    }


    public static long minCost(long arr[], int n) 
    {
       PriorityQueue<Long> pq = new PriorityQueue<>();
       
       for(int i=0;i<n;i++){
           pq.add((long)arr[i]);
       }
       
       long sum = 0;
       
       while(pq.size() > 1){
         long a = pq.poll();
         long b = pq.poll();
         
         long c = a + b;
         sum += c;
         
         pq.add(c);
       }
       
       return sum;
    }
}