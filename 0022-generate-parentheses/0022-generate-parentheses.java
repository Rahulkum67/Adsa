class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String curr,
                           int open, int close, int n) {

        // If the string is complete
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // Add '(' if we still have some left to use
        if (open < n) {
            backtrack(ans, curr + "(", open + 1, close, n);
        }

        // Add ')' only if it won't break validity
        if (close < open) {
            backtrack(ans, curr + ")", open, close + 1, n);
        }
    }
}
