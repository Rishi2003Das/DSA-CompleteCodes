//Personalised memory intensive solution
class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;
        int maxY = 0;

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            totalArea += (double) l * l;
            maxY = Math.max(maxY, y + l);
        }

        double[] arr = new double[maxY];

        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            for (int i = y; i < y + l; i++) {
                arr[i] += l;
            }
        }
        double half = totalArea / 2.0;
        double accumulated = 0.0;

        for (int i = 0; i < maxY; i++) {
            double stripArea = arr[i];

            if (accumulated + stripArea >= half) {
                double remaining = half - accumulated;
                double fraction = remaining / stripArea;
                return i + fraction;
            }

            accumulated += stripArea;
        }
        return maxY;
    }
}
//Optimised solution

import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        TreeMap<Integer, Double> events = new TreeMap<>();
        double totalArea = 0.0;

        // Step 1: Build sweep events
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];

            totalArea += (double) l * l;

            events.put(y, events.getOrDefault(y, 0.0) + l);
            events.put(y + l, events.getOrDefault(y + l, 0.0) - l);
        }

        double half = totalArea / 2.0;
        double accumulated = 0.0;
        double activeWidth = 0.0;

        Integer prevY = null;

        // Step 2: Sweep through event intervals
        for (Map.Entry<Integer, Double> entry : events.entrySet()) {
            int currY = entry.getKey();

            if (prevY != null) {
                double height = currY - prevY;
                double area = activeWidth * height;

                if (accumulated + area >= half) {
                    double remaining = half - accumulated;
                    double fraction = remaining / activeWidth;
                    return prevY + fraction;
                }

                accumulated += area;
            }

            activeWidth += entry.getValue();
            prevY = currY;
        }

        return prevY;
    }
}
