class StockSpanner {
    public Stack<int []> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int days =1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            days+=st.pop()[1];
        }
        st.push(new int[]{price,days});
        return days;
    }
}
