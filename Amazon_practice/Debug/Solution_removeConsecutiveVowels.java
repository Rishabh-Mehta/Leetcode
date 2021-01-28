package Amazon_practice.Debug;



public class Solution_removeConsecutiveVowels {
    public static boolean  is_vowel(char ch) {
        return (ch == 'a') || (ch == 'e') ||
                (ch == 'i') || (ch == 'o') ||
                (ch == 'u');
    }

    public static String removeConsecutiveVowels(String str) {
        String str1 = "";
        str1 = str1+str.charAt(0);
        for(int i = 1; i < str.length(); i++)
            if((!is_vowel(str.charAt(i - 1))) || //replaced && with ||
                    (!is_vowel(str.charAt(i)))) {
                char ch = str.charAt(i);
                str1 = str1+ch;
            }
        return str1;
    }
    public static void main(String[] args) {
        System.out.println(removeConsecutiveVowels("abaa"));
         
    }

}
