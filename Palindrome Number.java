import java.util.Scanner;

public class Solution {

    public static boolean isPalindrome(int x) {
        
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int originalNum = x;
        int reversedNum = 0;
        
        while (x != 0) {
            int digit = x % 10;
            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }
        
        return originalNum == reversedNum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int x = input.nextInt();  

        boolean result = isPalindrome(x);
        System.out.println("Is the number a palindrome? " + result);
    }
}
