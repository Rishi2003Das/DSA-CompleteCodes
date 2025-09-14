class MinStack {
    ArrayList<Integer> list=new ArrayList<>();
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public void push(int val) {
        list.add(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(list.get(list.size()-1));
        list.remove(list.size()-1);
        return;
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin(){
        return pq.peek();
    }
}
