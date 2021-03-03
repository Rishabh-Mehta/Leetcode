# countSubsegments
# https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
Given an array of non-negative integers arr, your task is to find the number of ways it can be split into three non-empty contiguous subarrays such that the sum of the elements in the first subarray is less than or equal to the sum of the elements in the second subarray, and the sum of the elements in the second subarray is less than or equal to the sum of the elements in the third subarray.

Note:

Each element of arr must appear in exactly one of the three contiguous subarrays.
Although the given numbers are 32-bit integers, the sum of the elements may exceed the limits of the 32-bit integer type.
Example

For arr = [1, 1, 1], the output should be countSubsegments(arr) = 1.

The only way to split this array into three non-empty contiguous subarrays is [1], [1], [1]. This triple of subarrays satisfies the conditions (1 ≤ 1 ≤ 1), so the answer is 1.

For arr = [1, 2, 0], the output should be countSubsegments(arr) = 0.

The only way to split this array into three non-empty contiguous subarrays is [1], [2], [0]. This triple of subarrays doesn't satisfy the conditions (1 ≤ 2 > 0), so the answer is 0.

For arr = [1, 2, 2, 2, 5, 0], the output should be countSubsegments(arr) = 3.

If the first subarray is [1], there are 2 possibilities of choosing the second and the third one:
Choose [2] as the second subarray and [2, 2, 5, 0] as the third subarray (1 ≤ 2 ≤ 9).
Choose [2, 2] as the second subarray and [2, 5, 0] as the third subarray (1 ≤ 4 ≤ 7).
If we choose a bigger second subarray, the sum of its elements will be at least 2 + 2 + 2 = 6, which is greater than the sum of the elements in any possible third subarray in that case.
If the first subarray is [1, 2] there is only one way of choosing the other two subarrays:
Choose [2, 2] as the second subarray and [5, 0] as the third subarray (3 ≤ 4 ≤ 5),
If we choose a bigger or smaller subarray as the second one, the conditions won't be satisfied.
There are 2 + 1 = 3 ways of dividing arr into three subarrays that meet the conditions, so the answer is 3.
Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer arr

An array of non-negative integers.

Guaranteed constraints:
3 ≤ arr.length ≤ 105,
0 ≤ arr[i] ≤ 109.

[output] integer64

Return the number of ways to split the array into three non-empty contiguous subarrays, such that all the conditions are satisfied.

# not working
```
long countSubsegments(int[] arr) {
 
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
    while(curr_subarray_sum < prefix_sum[s-1] && e <arr.length -1){
        curr_subarray_sum += arr[e++];
    }
    if(curr_subarray_sum <= suffix_sum[e]){
        count++;
    }
    curr_subarray_sum -= arr[s++];
}
return count;
}
```