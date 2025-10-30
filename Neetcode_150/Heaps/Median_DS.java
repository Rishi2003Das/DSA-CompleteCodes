import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> map;
    public MedianFinder() {
        map=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(num>0)
        map.offer(num);
        return;
    }
    
    public double findMedian() {
        double med=0.0;
        if(map.size()%2==0){
            for(int i=1;i<=(map.size()/2)-1;i++){
                map.poll();
            }
            int val1=map.poll();
            int val2=map.poll();
            med=(val1+val2)/2;
        }
        else{
            for(int i=1;i<=(map.size()/2);i++){
                map.poll();
            }
            med=map.poll();
        }
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
