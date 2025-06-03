import java.util.*;
class MaxChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charFreqMap.containsKey(c)) {
                charFreqMap.put(c, charFreqMap.get(c) + 1);
            } else {
                charFreqMap.put(c, 1);
            }
        }
        char maxChar ='\0';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq) {
                maxChar = c;
                maxFreq = freq;
            }
        }
        System.out.println("The character that occurs the maximum number of times is: " + maxChar);
    }
}