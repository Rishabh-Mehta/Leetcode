# Sprint Training

Sprint Training
Imagine there are n points along a straight trail, while a runner run sprints of intervals between those point.
The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1].

For example, given n = 10, a = [2, 4, 1, 2].
The runner should run from point 2 to point 4,
then turn back from point 4 to point 1,
and then from point 1 to point 2.
Find the point that visited the most by runner after he finished training, i.e. in above example, point 2 is the most visited.
If more than one point are visited the most, find the point with minimum index.

```
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;


	class Result {

		/*
		 * Complete the 'getMostVisited' function below.
		 *
		 * The function is expected to return an INTEGER.
		 * The function accepts following parameters:
		 *  1. INTEGER n
		 *  2. INTEGER_ARRAY sprints
		 */

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

	}
	
```