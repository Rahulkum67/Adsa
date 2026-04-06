class Solution {
    public void subset(int[] arr, int i , int n, List<Integer> res, List<List<Integer>> result)
    {
        if(i == n)
        {
            result.add(new ArrayList<>(res));
            return;
        }

        res.add(arr[i]);
        subset(arr, i + 1, n, res, result);
        res.remove(res.size() - 1);
        subset(arr, i + 1, n, res, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        subset(nums, 0, n, res, result);

        return result;

    }
}