class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList(), nums, visited);
        return res;
    }

    public void backtrack(List<Integer> perm, int[] nums, boolean[] visited) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList(perm));
            return;
        }
        for(int i = 0 ; i < nums.length; i++) {
            if(!visited[i]) {
                perm.add(nums[i]);
                visited[i] = true;
                backtrack(perm, nums, visited);
                perm.remove(perm.size() - 1);
                visited[i] = false;
            }
        }
    }
}
