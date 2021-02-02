package Amazon_practice;
import java.util.*;

class Solution_labelingSystem {
    public static String labelingSystem(String label,int limit) {
        
        HashMap<Character,Integer> cMap = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> b-a);
        StringBuilder result = new StringBuilder(); 
        
        for(char c:label.toCharArray()){
            cMap.put(c, cMap.getOrDefault(c, 0)+1);
        }
        queue.addAll(cMap.keySet());
        System.out.println(cMap);
        int itr = 0;
        while(!queue.isEmpty()){
            System.out.println(itr+" "+queue+" "+cMap+" "+result.toString());
            char c = queue.remove();

            itr++;
            if(cMap.get(c) <= limit){
                int size = cMap.get(c)-1;
                while(size >=0){
                    result.append(c);
                    size--;
                }
                cMap.remove(c);
            }
            else { //c has freq > limit put c back with val - limit
                int size = limit-1;
                while(size >=0){
                    result.append(c);
                    size--;
                }
                if(queue.isEmpty()){
                    return null;
                }
                char next_char = queue.remove();
                result.append(next_char);
                cMap.put(c, cMap.get(c)-limit);
                if(cMap.get(next_char)-1 > 0){
                    cMap.put(next_char, cMap.get(next_char)-1);
                    queue.add(next_char);
                }
                else
                    cMap.remove(next_char);
                queue.add(c);
                
            }

        }

        
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(labelingSystem("zzzzzzbz",3));
        
    }
}
