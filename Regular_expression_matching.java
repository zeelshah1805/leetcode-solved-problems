class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if the first i characters of s match the first j characters of p
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty pattern matches empty string

        // Initialize first row of dp table
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true; // '*' can match zero of the preceding element
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, move diagonally
                } else if (pc == '*') {
                    // Check zero or more of the preceding element
                    dp[i][j] = dp[i][j - 2]; // Zero occurrences of preceding character
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // One or more occurrences of preceding character
                    }
                } else {
                    dp[i][j] = false; // Characters don't match and no '*' to handle
                }
            }
        }

        return dp[m][n]; // Result for full string and pattern
    }
}
