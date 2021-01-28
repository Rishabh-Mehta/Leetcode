package Amazon_practice.Debug;

public class Solution_calculateSumOfNumbersInString {
    public static int calculateSumOfNumbersInString(String inputString) {
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            else
               { sum += Integer.parseInt(temp);
                //correction
                temp = "0";
                }
    //        temp = "0";
        }
        return sum + Integer.parseInt(temp);
    }
    public static void main(String[] args) {
        System.out.println(calculateSumOfNumbersInString("199"));
    }
}
