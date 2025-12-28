class Solution {
    public String reverseWords(String s) {
        String[] word=s.trim().split("\\s+");
        int i = 0, j = word.length - 1;
        while (i < j) {
            String temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }

        // Join words with single space
        return String.join(" ", word);
    }
}