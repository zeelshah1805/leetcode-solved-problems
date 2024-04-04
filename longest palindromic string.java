class Solution {
    public static String longestPalindrome(String str) {

        if (str.length() <= 1)
            return str;

        String LPS = "";
        for (int i = 0; i < str.length(); i++) { 
            int low = i;
            int high = i;
           
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }
           
            low++;
            high--;
            String palindrome = str.substring(low, high + 1); 
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            low = i - 1;
            high = i;
            
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }
            
            low++;
            high--;
            palindrome = str.substring(low, high + 1);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }
}

public class Main {
    public static void main(String[] args){}
}
