package Amazon_practice;

//https://leetcode.com/problems/slowest-key/

class Solution_slowestKey {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char curr_key = keysPressed.charAt(0);
        int maxDuration = releaseTimes[0];
        for(int i =1;i<releaseTimes.length;i++){
            if(maxDuration < (releaseTimes[i] - releaseTimes[i-1])){
                maxDuration = (releaseTimes[i] - releaseTimes[i-1]);
                curr_key = keysPressed.charAt(i);
            }
            if(maxDuration == (releaseTimes[i] - releaseTimes[i-1]) ){
                curr_key = curr_key > keysPressed.charAt(i) ? curr_key : keysPressed.charAt(i);
            }
        }
        
        return curr_key;
    }
    public static void main(String[] args) {
        System.out.println(
        slowestKey(new int[]{9,29,49,50}, "cbcd"));
    }
}