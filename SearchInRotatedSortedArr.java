//Very Important question for google, facebook and Amazon
class SearchInRotatedSortedArr {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        
        if (nums[pivot] == target) {
            return pivot;
        }
        
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    
    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        SearchInRotatedSortedArr solution = new SearchInRotatedSortedArr();
        
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(solution.search(nums1, target1)); // Output: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(solution.search(nums2, target2)); // Output: -1

        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(solution.search(nums3, target3)); // Output: -1
    }
}