class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> curr, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(curr)); // found a combination
            return;
        }

        if (target < 0 || index == candidates.length)
            return; // invalid path

        // Option 1: pick the current number
        curr.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], curr, result);
        curr.remove(curr.size() - 1); // backtrack

        // Option 2: skip the current number
        backtrack(index + 1, candidates, target,curr, result);
    }
}