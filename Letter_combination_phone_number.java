import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Mapping of digits to corresponding letters
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        // Backtracking to generate combinations
        backtrack(result, digits, digitToLetters, new StringBuilder(), 0);

        return result;
    }

    private void backtrack(List<String> result, String digits, Map<Character, String> digitToLetters,
                           StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, digitToLetters, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
