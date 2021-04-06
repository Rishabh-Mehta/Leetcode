package Twitter_OA;
import java.util.*;


public class SpringTraining {
    public static int getMostVisited(int n, List<Integer> sprints) {
		// Write your code here
		
		Map<Integer,Integer> map = new TreeMap<>();
		for(int mark:sprints){
			map.put(mark,0);
		}
		int currMax = Integer.MIN_VALUE;
		for(int i=0;i<sprints.size()-1;i++){
			int start = sprints.get(i);
			int end = sprints.get(i+1);
			
			if(start < end){
				for(int j=start;j<=end;j++){
					if(map.containsKey(j)){
						map.put(j,map.get(j)+1);
					}
				}
			}
			else{
				for(int j=start;j>=end;j--){
					if(map.containsKey(j)){
						map.put(j,map.get(j)+1);
					}
				}
			} 
		}
		System.out.println(map); 
		 
		 for(int key:map.keySet()){
			 currMax =Math.max(currMax,map.get(key));
		 }
		 
		 for(int key:map.keySet()){
			 if(map.get(key) == currMax){
				 return key;
			 }
			 
			 
		 }
		 
		return -1;
		

		}
        public static void main(String[] args) {
            System.out.println(getMostVisited(10, Arrays.asList(2,4,1,3)));
        }
}
