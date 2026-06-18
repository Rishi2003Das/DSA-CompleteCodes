class Solution {
    public double angleClock(int hour, int minutes) {

        double a1=(hour%12)*30+minutes*0.5;
        double a2=minutes*6;


        double diff=Math.abs(a1-a2);

        return Math.min(diff,360-diff);
    }
}
