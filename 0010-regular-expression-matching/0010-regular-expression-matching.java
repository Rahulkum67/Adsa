class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] = whether s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    // Characters match, just move diagonally
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pc == '*') {
                    char prev = p.charAt(j - 2);

                    // Case 1: treat "*" as zero occurrences
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: treat "*" as one or more occurrences
                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
