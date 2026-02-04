import java.util.Hashtable;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Hashtable<Character, Integer> has = new Hashtable<>();
        int k = s1.length();

        // build frequency map for s1
        for (int i = 0; i < k; i++) {
            char c = s1.charAt(i);
            has.put(c, has.getOrDefault(c, 0) + 1);
        }

        int count = k;
        int i = 0, j = 0;

        while (j < s2.length()) {
            char right = s2.charAt(j);

            if (has.containsKey(right)) {
                if (has.get(right) > 0) count--;
                has.put(right, has.get(right) - 1);
            }
            j++;

            if (count == 0) return true;

            // maintain window size
            if (j - i == k) {
                char left = s2.charAt(i);
                if (has.containsKey(left)) {
                    if (has.get(left) >= 0) count++;
                    has.put(left, has.get(left) + 1);
                }
                i++;
            }
        }
        return false;
    }
}
