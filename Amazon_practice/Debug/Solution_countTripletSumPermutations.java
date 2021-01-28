package Amazon_practice.Debug;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution_countTripletSumPermutations {
    public static int countTripletSumPermutations(int size, int[] arr, int tripletSum)
    {
        int count = 0;
        for(int i = 0; i < size - 2; i++)
        {
            if(tripletSum % arr[i] == 0)
            {
                for(int j = i+1; j < size - 1; j++) // changed from j= 0 to j = i+1
                {
                    if(tripletSum % (arr[i] * arr[j]) == 0)
                    {
                        int value = tripletSum / (arr[i] * arr[j]);
                        for(int k = j + 1; k < size; k++)
                            if(arr[k] == value)
                                count++;
                    }
                }
            }

        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countTripletSumPermutations(5, new int[]{1,1,2,2,4}, 2));
    }
}
