class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;
            
            // Handle collisions only when there's a right-moving asteroid in the stack and a left-moving asteroid in the current one
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop(); // The asteroid in the stack is destroyed
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop(); // Both are destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // Current asteroid is destroyed
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid); // Push only if it survives
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
