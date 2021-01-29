package Amazon_practice;

public class Amazon_FullfillmentCenter {
    public static int  findBox(int[] emptyBoxes , int product){
        int start = 0,end = emptyBoxes.length-1;
        int max_so_far = 0;
        int mid = 0;
        while(start <= end){
            System.out.println(start +" "+ end);
             mid = (start + end) /2;
            int diff = product - emptyBoxes[mid] ; 
            if(emptyBoxes[mid] == product){
                return emptyBoxes[mid];
            }
            else if(emptyBoxes[mid] < product){
                start = mid;
            }
            else{
                end = mid;
            }
            

        }

        System.out.println(emptyBoxes[mid]);
        return emptyBoxes[mid];

    }
    public static void main(String[] args) {
        int[] a = new int[]{2,7,9,11,13,16};
        System.out.println(findBox(a, 12));
    }
    
}
