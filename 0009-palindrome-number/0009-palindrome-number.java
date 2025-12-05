class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers OR numbers ending with 0 (except 0) cannot be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev = 0;

        // Reverse only HALF of the number
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // For odd digits, remove the middle digit from rev
        return x == rev || x == rev / 10;
    }
}
