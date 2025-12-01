class Solution {
public int lengthOfLongestSubstring(String s) {
int[] last = new int[256];    // stores last seen index of every character
Arrays.fill(last, -1);


    int maxLen = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);

        // If we have seen this character, move left
        if (last[ch] >= left) {
            left = last[ch] + 1;
        }

        last[ch] = right;  // update last seen index
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}


}
