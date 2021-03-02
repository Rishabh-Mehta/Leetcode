package Codility_practice;
import java.util.*;

public class serverFarm {

    public static List<List<Integer>> serverFarmSchedule(int[] jobs, int servers) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int scheduled = jobs.length;
        //index ,jobtime
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<jobs.length;i++){
            map.put(i, jobs[i]);
        }
        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if(map.get(o1) == map.get(o2))
                    return o1-o2;
                else
                    return map.get(o1) - map.get(o2);

            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comp);
        // System.out.println("Map "+map);
        maxHeap.addAll(map.keySet());
        // System.out.println("Heap "+ maxHeap);
        int curr_min = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();
        int k = 0;
        while(result.size() != servers )
        {   result.add(new ArrayList<Integer>());
            if(!maxHeap.isEmpty())
            {
            int curr_jobId = maxHeap.remove();
            result.get(k).add(curr_jobId);
            time.add(map.get(curr_jobId));
            curr_min = Math.min(curr_min,map.get(curr_jobId));
            scheduled--;
            k++;
            }
        }
        // System.out.println("Heap after inital servers "+ maxHeap);
        // System.out.println("time elapsed "+time);
        
        while(!maxHeap.isEmpty() && scheduled !=0)
        {   
            int curr_jobId = maxHeap.remove();
            
            curr_min = Collections.min(time);
            for(int i=0;i<servers;i++){
                if(time.get(i) <= curr_min){
                    result.get(i).add(curr_jobId);
                    scheduled--;
                    time.set(i,time.get(i)+map.get(curr_jobId));
                    break;
                    
                }
                }
            
        }
        
            
         return result;    
        }
        
        
        
    
    
    public static void main(String[] args) {
        int jobs[] = {8, 7, 15, 15, 13, 6, 18, 4, 16, 1, 2, 19, 2, 15, 18, 6, 20, 16, 10, 7, 3, 7, 9, 7, 12, 1, 16, 15, 7, 12, 20, 17, 17, 4, 20, 15, 20, 6, 15, 3, 5, 17, 5, 5, 19, 17, 4, 15, 2, 7};
        int servers = 9;
        List<List<Integer>> res =serverFarmSchedule(jobs, servers);
        System.out.println(res);
    }        

    

    
}
