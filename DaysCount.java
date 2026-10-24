class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int month[]={31,59,90,120,151,181,212,243,273,304,334,365};//prefix sum array
        int arrAlice=transform(arriveAlice,month);
        int leaAlice=transform(leaveAlice,month);
        int arrBob=transform(arriveBob,month);
        int leaBob=transform(leaveBob,month);
        int start = Math.max(arrAlice, arrBob);
        int end = Math.min(leaAlice, leaBob);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }
    int transform(String date, int month[]){
        int m=Integer.parseInt(date.substring(0,2));
        int d=Integer.parseInt(date.substring(3,5));
        if(m==1)
        return d;
        else
        return (month[m-2]+d);
    }
}
