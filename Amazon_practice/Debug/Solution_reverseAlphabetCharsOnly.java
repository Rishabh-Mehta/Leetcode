package Amazon_practice.Debug;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution_reverseAlphabetCharsOnly {
    public static String reverseAlphabetCharsOnly(String inputString) {
        char[] inputChar = inputString.toCharArray();
        int right = inputString.length() - 1;
        int left = 0;
        while(left < right) {
            if(!Character.isAlphabetic(inputChar[left]))
                left++;
            else if(!Character.isAlphabetic(inputChar[right]))
                right--;
            else {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
                left++;
                right--; // inc  and dec operation inside else 
            }
            
        }
        return new String(inputChar);
    }
    public static void main(String[] args) {
        System.out.println(reverseAlphabetCharsOnly("^a+b-c+"));
    }
}
