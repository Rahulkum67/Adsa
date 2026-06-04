class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        for (int card : deck) {
            int idx = q.poll();
            ans[idx] = card;

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        return ans;
    }
}