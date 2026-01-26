class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int dif = arr[i] - arr[i - 1];

            if (dif < min) {
                min = dif;
                list.clear();
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            } 
            else if (dif == min) {
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return list;
    }
}
