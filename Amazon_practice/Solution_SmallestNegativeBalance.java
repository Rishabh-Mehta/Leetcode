package Amazon_practice;
import java.util.*;

public class Solution_SmallestNegativeBalance {
   static List<String> minimumDebtMembers(List<debtRecord> records){
        HashMap<String,Integer> debtMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
          debtMap.put(records.get(i).borrower,debtMap.getOrDefault(records.get(i).borrower,0)-records.get(i).amount);
          debtMap.put(records.get(i).lender,debtMap.getOrDefault(records.get(i).lender,0)+records.get(i).amount);  
        }
        System.out.println(debtMap);
        PriorityQueue<String> map = new PriorityQueue<>((a,b)->debtMap.get(a)-debtMap.get(b));
        map.addAll(debtMap.keySet());
        if(debtMap.get(map.peek()) >= 0){
              return result;  
        }
        result.add(map.remove());
        while(debtMap.get(map.peek()) == debtMap.get(result.get(0))){
            result.add(map.remove());
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        List<debtRecord> records = new ArrayList<>();
       debtRecord r1 = new debtRecord();
        r1.borrower = "USA";
        r1.lender="China";
        r1.amount = 2;
       debtRecord r2 = new debtRecord();
        r2.borrower = "China";
        r2.lender = "USA";
        r2.amount = 2;
        records.add(r1);
        records.add(r2);
        debtRecord r3 = new debtRecord();
        r3.borrower = "China";
        r3.lender = "Japan";
        r3.amount = 5;
        records.add(r3);
       System.out.println( minimumDebtMembers(records));
        
    }
    
}
