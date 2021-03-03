package Codility_practice;
import java.util.*;
public class sortMatrixByOccurrences {

    public static int[][] sortMatrixByOcc(int[][] m) {
        // (number, count)
        Map<Integer,Integer> map = new TreeMap<>();
        HashMap<Integer,List<Integer>> diagonalMap = new HashMap<>();
        Comparator<Integer> comp = new Comparator<Integer>(){
        
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) == map.get(o2)){
                    return Integer.compare(o2, o1);
                }
                else{
                    return map.get(o2) - map.get(o1);
                }
            }
        };
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(comp);
        
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
        for(int num:map.keySet()){
            int size = map.get(num);
            while(size !=0){
                minHeap.add(num);
                size--;
            }
        }
        
        
        for(int i=0;i<m.length+m[0].length-1;i++){
            int size = diagonalMap.get(i).size();
            List<Integer> temp = new ArrayList<>();
            while(size!=0 && !minHeap.isEmpty()){
                int val = minHeap.poll();
                temp.add(val);
                size--;
            }
            diagonalMap.put(i,temp);
            
        }
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                m[i][j]=diagonalMap.get(i+j).get(0);
                diagonalMap.get(i+j).remove(0);
        
            }
        }
        
        return m;
    }

    public static void main(String[] args) {

        int[][] input = {{ 1, 4, -2},
                        {-2, 3,  4},
                        { 3, 1,  3}};

        int[][] res = sortMatrixByOcc(input);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.print(res[i][j]+" ");
        
            }
            System.out.println();
        }

    }
    
}
