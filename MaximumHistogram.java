import java.util.*;
public class MaximumHistogram {

    public int maxHistogram(int input[]){
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everything from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        MaximumHistogram mh = new MaximumHistogram();
        int input[] = {2,1,5,6,2,3};
        int maxArea = mh.maxHistogram(input);
        System.out.println(maxArea);
    }
}