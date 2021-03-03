package Codility_practice;

public class countSubsegments {

    static long countSubseg(int[] arr) {
 
        int[] prefix_sum = new int[arr.length];
        prefix_sum[0] = arr[0];
        int[] suffix_sum = new int[arr.length];
        suffix_sum[arr.length-1] = arr[arr.length-1];

        for(int i=1;i<arr.length;i++){
            prefix_sum[i] = prefix_sum[i-1] + arr[i];
        }
        for(int i=arr.length-2;i>=0;i--){
            suffix_sum[i] = suffix_sum[i+1] + arr[i];
        }
        
        
        int s= 1 , e = 1;
        int curr_subarray_sum = 0,count =0;
        while(s< arr.length-1 && e < arr.length -1){
            while(curr_subarray_sum >= prefix_sum[s-1] && e <arr.length -1){
                curr_subarray_sum += arr[e++];
            }
            if(curr_subarray_sum <= suffix_sum[e]){
                count++;
            }
            curr_subarray_sum -= arr[s++];
        }
        return count;
        }

        public static void main(String[] args) {
            int[] input = {1, 2, 2, 2, 5, 0};
            System.out.println(countSubseg(input));
        }
    
}
