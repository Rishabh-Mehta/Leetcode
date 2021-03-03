# sortMatrixByOccurrences
Given a square matrix of integers m, your task is to rearrange its numbers in the following way:

First, sort its values in ascending order of how frequently the number occurs in m. In the case of a tie, sort the equally frequent numbers by their values, in ascending order.
Second, place the sorted numbers diagonally, starting from the bottom right corner, like this:

For

m = [[ 1, 4, -2],
     [-2, 3,  4],
     [ 3, 1,  3]]
the output should be

sortMatrixByOccurrences(m) = [[3,  3,  4],
                              [3,  4,  1],
                              [1, -2, -2]]
First we look at the frequency of each number:

Number 1 occurs 2 times;
Number -2 occurs 2 times;
Number 3 occurs 3 times;
Number 4 occurs 2 times.
Because numbers 1, -2, and 4 occur the same number of times, we sort them by their values in ascending order. Number 3 occurs the most numbers of times, so it goes after all other numbers. Finally, after sorting we get the following array: [-2, -2, 1, 1, 4, 4, 3, 3, 3]

After sorting, the numbers should be placed diagonally starting from the bottom right corner, as follows:

[[3,  3,  4],
 [3,  4,  1],
 [1, -2, -2]]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer m

A square matrix of integers.

Guaranteed constraints:
1 ≤ m.length ≤ 40,
m[i].length = m.length,
-1000 ≤ m[i][j] ≤ 1000.

[output] array.array.integer

The matrix m rearranged according to the specifications above.
# not working
```
int[][] sortMatrixByOccurrences(int[][] m) {
    // (number, count)
    Map<Integer,Integer> map = new TreeMap<>();
    HashMap<Integer,List<Integer>> diagonalMap = new HashMap<>();
    for(int i=0;i<m.length;i++){
        for(int j=0;j<m[i].length;j++){
            map.put(m[i][j],map.getOrDefault(m[i][j], 0)+1);
            List<Integer> temp;
            if(diagonalMap.containsKey(i+j)){
                 temp= diagonalMap.get(i+j);
             
            }
            else{
                temp = new ArrayList<>();
            }
            temp.add(m[i][j]);   
            diagonalMap.put(i+j,temp);
        }
    }
    Comparator<Integer> comp = new Comparator<Integer>(){
    
        @Override
        public int compare(Integer o1, Integer o2) {
            if(map.get(o1) == map.get(o2)){
                return Integer.compare(o1, o2);
            }
            else{
                return map.get(o1) - map.get(o2);
            }
        }
    };
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(comp);
    minHeap.addAll(map.keySet());
    System.out.println(map);
    System.out.println(diagonalMap);
    System.out.println(minHeap);
    for(int i=0;i<m.length;i++){
        for(int j=0;j<m[i].length;j++){
            int val = diagonalMap.get(i+j).get(0);
            diagonalMap.get(i+j).remove(0);
            m[i][j] = val;
        }
    }
    
    return m;
}

```

