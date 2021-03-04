package Codility_practice;
import java.util.*;

public class fitIntoRectangleBoxes {

    public static boolean[] fitIntoRectangleBox(int[][] boxes){
        int count = 0;
        List<int[]> rect = new ArrayList<int[]>();
        List<int[]>  fillBox= new ArrayList<int[]>();
        for(int i=0;i<boxes.length;i++){
            if(boxes[i][0] == 0){
                rect.add(boxes[i]);
                count++;
                
            }
            else{
                
                fillBox.add(boxes[i]);
            }
        }
        if(count == 0){
            return new boolean[]{true};
        }
        boolean[] result = new boolean[count];
        int resultIdx = 0;
        for(int i=0;i<boxes.length;i++){
            if(boxes[i][0] == 1){
                int box_width = boxes[i][1];
                int box_length = boxes[i][2];
                boolean res = false;
                for(int j=0;j<rect.size();j++){
                    int rect_width = rect.get(j)[1];
                    int rect_length = rect.get(j)[2];
                    if((rect_width<=box_width && rect_length <=box_length) || (rect_width <= box_length && rect_length <=box_width )){
                        res = true;
                    }
                    else{
                        res = false;
                        break;
                    }
                }
                result[resultIdx++] = res;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        int[][] box = {{0,1,3},{0,4,2},{1,3,4}};
        boolean[] res = fitIntoRectangleBox(box);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
        
    }
    
}
