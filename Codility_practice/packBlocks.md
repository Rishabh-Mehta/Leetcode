# packBlocks / 410. [Leetcode]Split Array Largest Sum

(Similar to 410. Split Array Largest Sum  Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays)

You are given array of integers called blocks. Each of the values in this array represents the width of a block - the ith block has a height of 1 and a width of blocks[i] (i.e. it's a 1 x blocks[i] block).

You want to pack all the given blocks into a rectangular container of dimensions height x width, according to the following rules:

Place blocks into the container row by row, starting with block 0.
For each row, place the blocks into the container one by one, in the order they are given in the blocks array.
If there is not enough space to put the current block in the current row, start filling the next row.
You are given the value height of the rectangular container. Your task is to find the minimal possible width of a rectangular container in which all blocks can fit. Find and return this minimal possible width value.

NOTE: The blocks cannot be rotated.

Example

For blocks = [1, 3, 1, 3, 3] and height = 2, the output should be packBlocks(blocks, height) = 6.

Here's how the blocks should be packed in a container of size 2 x 6:


Note that it wouldn't be possible to fit these blocks in a container that's any less wide than 6.

For blocks = [2, 3, 1, 1, 1] and height = 2, the output should be packBlocks(blocks, height) = 5.

Here's how the blocks should be packed in container of size 2 x 5:


It might seem like these blocks could be packed into a container of size 2 x 4, but since we must place them in the order they appear in the blocks array, the width must be at least 5.


```
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        return solve(nums,n,m);
    }
    public int solve(int[] arr,int n,int m){
        int start =1;
        int end = 0;
        for(int i=0;i<n;i++){
            end += arr[i];
            if(start < arr[i])
                start = arr[i];
        }
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(check(arr,mid,n,m)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }    
        }
        return ans;
    }
    public boolean check(int[] arr,int mid,int n,int m){
        int cntSubarray = 0;
        int sum =0;
        for(int i=0;i<n;i++){
            if(arr[i] > mid)
                return false;
            sum += arr[i];
            if(sum > mid){
                sum = arr[i];
                cntSubarray++;
            }
        }
        cntSubarray++;
        if(cntSubarray <= m)
            return true;
        return false;
            
        
        
        
        
    }
}

```