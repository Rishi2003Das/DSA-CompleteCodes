public class HeapConverter {

    // Function to heapify a subtree rooted at index i (Max Heapify)
    private static void maxHeapify(int[] heap, int n, int i) {
        int largest = i;      // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && heap[left] > heap[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && heap[right] > heap[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            // Recursively heapify the affected sub-tree
            maxHeapify(heap, n, largest);
        }
    }

    // Function to convert Min Heap to Max Heap
    public static void convertMinToMaxHeap(int[] heap) {
        int n = heap.length;

        // Start from last non-leaf node and heapify each node
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(heap, n, i);
        }
    }
