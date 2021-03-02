# serverFarm
Two Sigma engineers process large amounts of data every day, much more than any single server could possibly handle. Their solution is to use collections of servers, or server farms, to handle the massive computational load. Maintaining the server farms can get quite expensive, and because each server farm is simultaneously used by a number of different engineers, making sure that the servers handle their backlogs efficiently is critical.

Your goal is to optimally distribute a list of jobs between servers within the same farm. Since this problem cannot be solved in polynomial time, you want to implement an approximate solution using the Longest Processing Time (LPT) algorithm. This approach sorts the jobs by their associated processing times in descending order and then assigns them to the server that's going to become available next. If two operations have the same processing time the one with the smaller index is listed first. If there are several servers with the same availability time, then the algorithm assigns the job to the server with the smallest index.

Given a list of job processing times, determine how the LPT algorithm will distribute the jobs between the servers within the farm.

Example

For jobs = [15, 30, 15, 5, 10] and servers = 3, the output should be

serverFarm(jobs, servers) = [[1],
                             [0, 4],
                             [2, 3]]
job with index 1 goes to the server with index 0;
job with index 0 goes to server 1;
job with index 2 goes to server 2;
server 1 is going to be available next, since it got the job with the shortest processing time (15). Thus job 4 goes to server 1;
finally, job 3 goes to server 2.
Check out the image below for better understanding:



Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer jobs

Unsorted array of positive integers representing the processing times of the given jobs.

Guaranteed constraints:
0 ≤ jobs.length ≤ 100,
1 ≤ jobs[i] ≤ 1000.

[input] integer servers

Guaranteed constraints:
1 ≤ servers ≤ 20.


```
List<List<Integer>> serverFarm(int[] jobs, int servers) {
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
                    return map.get(o2) - map.get(o1);

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
```

