package Twitter_OA;
import java.util.*;
public class cutOffRanks {
    public static int numPlayers(int k, List<Integer> scores) {
        // Write your code here
        if(k == 0) return 0;
        Collections.sort(scores,Collections.reverseOrder());
        int rank =1;
        int result = 0;
        for(int i=0;i<scores.size();i++){
            if(i ==0){
                rank =1;
            }
            else if(scores.get(i) != scores.get(i-1)){
                rank = i+1;
            }
            if(rank <=k && scores.get(i)>0) result++;
            else break;
        }
    
    return result;
        }  
        public static void main(String[] args) {
            System.out.println(numPlayers(2, Arrays.asList(1,2,1,3,4)));
        }
}
