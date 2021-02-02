package Amazon_practice;

import java.util.*;

// Given a list of points, find the nearest points that shares either an x or a y coordinate with the queried point.

// The distance is denoted on a Euclidean plane: the difference in x plus the difference in y.



public class Solution_NearestCity {

    public static String[] nearestCity(String[] points , int[] xCoordinates , int[] yCoordinates ,String[] queries , int n ){
        Map<Integer,List<String>> xMap = new HashMap<>();
        Map<Integer,List<String>> yMap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!xMap.containsKey(xCoordinates[i]))
                xMap.put(xCoordinates[i],  new ArrayList<String>());
            xMap.get(xCoordinates[i]).add(points[i]);
            if(!yMap.containsKey(yCoordinates[i]))
                yMap.put(yCoordinates[i],  new ArrayList<String>());
            yMap.get(yCoordinates[i]).add(points[i]);
        }
        // System.out.println(xMap);
        // System.out.println(yMap);
        String[] result = new String[queries.length];
        int i =0;
        for(String query : queries){
            int queryX ;
            int queryY;
            int minDist = Integer.MAX_VALUE;
            List<String> neighbours = new ArrayList<>();


            //this means atleast 1 point shares x coordinate
            if(xMap.size() == points.length && yMap.size() == points.length){
                result[i++] = "None";

            }
            if(xMap.size() != points.length){
                for(int x :xMap.keySet()){
                    if(xMap.get(x).contains(query)){
                        if(x < minDist){
                            minDist = x;
                        }
                        neighbours.addAll(xMap.get(x));
                    }
                }
            }
            if(yMap.size() != points.length){
                for(int y :yMap.keySet()){
                    if(yMap.get(y).contains(query)){
                        queryY = y;
                        neighbours.addAll(yMap.get(y));
                    }
                }
            }
            if(neighbours.size() ==1 ){
                result[i++] = neighbours.get(0);
            }
            else{

            }


            

        }



        return points;
    }
    public static void main(String[] args) {
        System.out.println( nearestCity(new String[]{ "c1","c2","c3"}, new int[]{3,2,1}, new int[]{3,2,3}, new String[] {"c3","c2","c1"}, 3));
    }
    
}
