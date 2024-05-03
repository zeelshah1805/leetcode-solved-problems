import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // If the sum of all numbers is less than the desired total, no player can win
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        
        if (desiredTotal <= 0)
            return true; // First player wins by not choosing any number
        
        // Create a memoization map to store the results of subproblems
        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, memo);
    }
    
    private boolean canWin(int maxChoosableInteger, int desiredTotal, int chosen, Map<Integer, Boolean> memo) {
        if (desiredTotal <= 0)
            return false;
        
        if (memo.containsKey(chosen))
            return memo.get(chosen);
        
        // Iterate through all possible choices
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if ((chosen & mask) == 0) { // If the number is not chosen yet
                if (!canWin(maxChoosableInteger, desiredTotal - i, chosen | mask, memo)) {
                    memo.put(chosen, true); // First player wins
                    return true;
                }
            }
        }
        
        memo.put(chosen, false); // First player cannot win
        return false;
    }
}
