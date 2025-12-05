class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = -1; // will flip between +1 and -1

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // Change direction when hitting top or bottom
            if (row == 0 || row == numRows - 1) {
                direction *= -1;
            }

            row += direction;
        }

        // Build final answer
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) result.append(sb);

        return result.toString();
    }
}
