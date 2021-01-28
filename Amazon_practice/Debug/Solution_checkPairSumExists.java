package Amazon_practice.Debug;

import java.util.HashSet;
import java.util.Set;

public class Solution_checkPairSumExists {
    public static boolean checkPairSumExists(int rows, int cols, int[][] arr, int sum) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(set.contains(sum - arr[i][j])) {
                    return true;
                } else {
                    //set.add(sum);
                    //correction
                    set.add(arr[i][j]);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkPairSumExists(2, 3, new int[][]{{1,2,3},{1,2,3}}, 4));
    }
}
