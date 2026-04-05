class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow case
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Repeated subtracting using shifting
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Shift divisor until it would exceed the dividend
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
