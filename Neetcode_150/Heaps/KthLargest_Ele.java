/*
703. Kth Largest Element in a Stream ->
  You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time.
  This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
  You are tasked to implement a class that, for a given integer k, maintains a stream of test scores and continuously returns
  the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest
  score in the sorted list of all scores.

Implement the KthLargest class:

KthLargest(int k, int[] nums) Initialises the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
Example 1:
Input:
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

Output: [null, 4, 5, 5, 8, 8]
*/

//Brute Force using Priority Queue iterator
class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue();
        this.k=k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        int c=0;
        Iterator iterator = pq.iterator();
        while(iterator.hasNext()){
            if(c==(pq.size()-k)) return (int)iterator.next();
            c++;
        }
        return -1;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

//Optimised Solution using Priority Queue
class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
