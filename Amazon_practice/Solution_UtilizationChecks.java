package Amazon_practice;

public class Solution_UtilizationChecks {
    public static int finalInstances(int instances, int[] averageUtil) {
        int index = 0;
        while(index < averageUtil.length){
            if(averageUtil[index] < 25){
                if(instances > 1){
                    instances = (int)Math.ceil((double)instances / 2.0);
                    index += 11;
                }
                else
                    index++;
            }
            else if(averageUtil[index] >= 25 && averageUtil[index] <= 60 ){
                index++;
            }
            else{
                if(instances * 2 <= 2 * Math.pow(10,8)){
                    instances = instances * 2;
                    index += 11;
                }
                else{
                    index++;
                }
                
            }
            
            
        }
        return instances;
    }
    
    public static void main(String[] args){
        
        int result = finalInstances(2,new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80});
        System.out.println(result);
    }
}
