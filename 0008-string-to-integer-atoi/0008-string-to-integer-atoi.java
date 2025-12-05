class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If reached the end
        if (i == n) return 0;

        // 2. Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert characters to number until invalid
        long num = 0; // use long to handle overflow

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;

            // 4. Handle overflow
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) (num * sign);
    }
}
