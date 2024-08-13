public class MaximumRectangularSubmatrixOf1s {

    public int maximum(int input[][]){
        int temp[] = new int[input[0].length];
        MaximumHistogram mh = new MaximumHistogram();
        int maxArea = 0;
        int area = 0;
        for(int i=0; i < input.length; i++){
            for(int j=0; j < temp.length; j++){
                if(input[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += input[i][j];
                }
            }
            area = mh.maxHistogram(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        int input[][] = {{1,1,1,0},
                         {1,1,1,1},
                         {0,1,1,0},
                         {0,1,1,1},
                         {1,0,0,1},
                         {1,1,1,1}};
        MaximumRectangularSubmatrixOf1s mrs = new MaximumRectangularSubmatrixOf1s();
        int maxRectangle = mrs.maximum(input);
        System.out.println("Max rectangle is of size " + maxRectangle);
    }
}