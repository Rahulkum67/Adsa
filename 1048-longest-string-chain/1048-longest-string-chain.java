class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashMap<String, Integer> dp = new HashMap<>();

        int ans = 1;

        for (String word : words) {

            dp.put(word, 1);

            for (int i = 0; i < word.length(); i++) {

                String pred = word.substring(0, i) + word.substring(i + 1);

                if (dp.containsKey(pred)) {
                    dp.put(word,
                            Math.max(dp.get(word), dp.get(pred) + 1));
                }
            }

            ans = Math.max(ans, dp.get(word));
        }
        return ans;
    }
}