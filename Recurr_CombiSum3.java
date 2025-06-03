class Solution {
    private void solve(int i, int k, int target, List<Integer> list, List<List<Integer>> result){
        if(list.size() > k) return;
        if(target == 0 && list.size() == k){
            result.add(new ArrayList<>(list));
        }
        for(int choice=i; choice<=9; choice++){
            list.add(choice);
            solve(choice + 1, k, target - choice, list, result);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), result);
        return result;
    }
}
