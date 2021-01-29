# Palindromic Anagram
```
import java.util.*;

class Solution {
    public boolean solve(String s) {
        HashMap<Character,Integer> set = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            set.put(ch,set.getOrDefault(ch,0)+1);
        }
        int even_count = 0;
        int odd_count = 0;
        for(int num : set.values()){
            if(num % 2 == 0){
                even_count++;
            }
            else{
                odd_count++;
            }
            
        }
        if(even_count >= 0 && odd_count <= 1){
            return true;
        }
        return false;
                
    }
}
```