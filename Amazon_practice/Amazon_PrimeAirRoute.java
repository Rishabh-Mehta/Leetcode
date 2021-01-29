package Amazon_practice;
import java.util.*;


public class Amazon_PrimeAirRoute{
    public static List<List<Integer>>  getRoutes(int[][] forwardRouteList ,int[][] returnRouteList , int maxTravelDistance){

        List<List<Integer>> result = new ArrayList<>();
        Integer min = null;
        for(int i=0;i<forwardRouteList.length;i++){
            for(int j=0;j<returnRouteList.length;j++){
                int diff = forwardRouteList[i][1] + returnRouteList[j][1];
                //System.out.println("forward "+forwardRouteList[i][0]+" return "+returnRouteList[j][0]+" diff "+diff);
                if(diff <= maxTravelDistance){
                    if(min == null){
                        min = diff;
                        result.add(Arrays.asList(forwardRouteList[i][0],returnRouteList[j][0]));
                    }
                    else if(diff > min && min !=null){
                        min = diff;
                        result.clear();
                        result.add(Arrays.asList(forwardRouteList[i][0],returnRouteList[j][0]));
                    }
                    else if(diff ==min){
                        result.add(Arrays.asList(forwardRouteList[i][0],returnRouteList[j][0]));
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2000},{2,4000},{3,6000}};
        int[][] b = new int[][]{{1,2000},{2,1000}};
        System.out.println(getRoutes(a, b, 7000));
         
    }

}