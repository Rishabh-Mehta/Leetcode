package Amazon_practice;
import java.util.*;
//https://leetcode.com/discuss/interview-question/372434
// Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

// Example 1:

// Input: nums = [1, 1, 2, 45, 46, 46], target = 47
// Output: 2
// Explanation:
// 1 + 46 = 47
// 2 + 45 = 47

public class Amazon_TwoSumUniquePairs {
    public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int num: nums){
            // System.out.println("set" +set);
            // System.out.println("visited" +visited);
            if(set.contains(target-num) && !visited.contains(num)){
                count++;
                set.add(target-num);
                visited.add(num);
                visited.add(target-num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(
        uniquePairs(new int[]{1,1,2,45,46,46},47));
    }
    
}
