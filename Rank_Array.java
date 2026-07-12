class Pair implements Comparable<Pair> {
    int num;
    int index;

    Pair(int n, int i) {
        this.num = n;
        this.index = i;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.num, other.num);
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return arr;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Pair(arr[i], i));
        }

        int r = 1;

        Pair curr = pq.poll();
        arr[curr.index] = r;
        int n = curr.num;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.num != n) {
                r++;
            }

            arr[p.index] = r;
            n = p.num;
        }

        return arr;
    }
}
