class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // simply add one
                return digits; // because no carry needed
            }
            digits[i] = 0;      // turn 9 into 0 and carry left
        }

        // If all digits were 9, then we get something like 999 -> 1000
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
