import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Character frequency mapping for string t
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int requiredChars = t.length();
        Map<Character, Integer> windowFreq = new HashMap<>();
        
        while (right < s.length()) {
            char current = s.charAt(right);
            
            // Expand the window by including the current character
            windowFreq.put(current, windowFreq.getOrDefault(current, 0) + 1);
            
            // Check if the current character is a required character
            if (targetFreq.containsKey(current) && windowFreq.get(current) <= targetFreq.get(current)) {
                requiredChars--;
            }
            
            // Try to contract the window from the left
            while (requiredChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                
                // Reduce the window size from the left
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                
                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    requiredChars++;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
