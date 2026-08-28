//3720. You are given two strings s and target, both having length n, consisting of lowercase English letters.
/* Return the lexicographically smallest permutation of s that is strictly greater than target.
If no permutation of s is lexicographically strictly greater than target, return an empty string.
A string a is lexicographically strictly greater than a string b (of the same length) if in the first position 
where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. */

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        // Count characters of s
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int targetChar = target.charAt(i) - 'a';

            if (count[targetChar] > 0) {

                // Temporarily use target[i]
                count[targetChar]--;

                // Check whether the remaining characters
                // can make something greater than target suffix
                if (canMakeGreater(count, target, i + 1)) {

                    // Keeping target[i] is possible
                    result.append(target.charAt(i));

                    continue;
                }

                // Keeping this character does not work.
                // Put it back.
                count[targetChar]++;
            }

            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {

                    // Put this slightly larger character
                    result.append((char) ('a' + c));

                    count[c]--;

                    // Put all remaining characters
                    // in ascending order
                    for (int k = 0; k < 26; k++) {

                        while (count[k] > 0) {
                            result.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return result.toString();
                }
            }

            // We cannot keep target[i]
            // and cannot choose anything larger.
            // Therefore this prefix is impossible.
            return "";
        }

        // target itself was the largest possible permutation
        return "";
    }

    private boolean canMakeGreater(
        int[] count,
        String target,
        int start
    ) {


        StringBuilder largest = new StringBuilder();

        for (int c = 25; c >= 0; c--) {

            while (count[c] > 0) {
                largest.append((char) ('a' + c));
                count[c]--;
            }
        }

        // Restore count because this was only a check
        for (int i = 0; i < largest.length(); i++) {
            count[largest.charAt(i) - 'a']++;
        }

        String targetSuffix = target.substring(start);

        return largest.toString().compareTo(targetSuffix) > 0;
    }
}


//3734. You are given two strings s and target, each of length n, consisting of lowercase English letters.
/* Return the lexicographically smallest string that is both a palindromic permutation of s and strictly greater than target.
If no such permutation exists, return an empty string. */

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        // --------------------------------------------------
        // STEP 1: Count frequency of every character
        // --------------------------------------------------
        int[] characterFrequency = new int[26];
        for (char currentCharacter : s.toCharArray()) {
            int characterIndex = currentCharacter - 'a';
            characterFrequency[characterIndex]++;
        }

        // --------------------------------------------------
        // STEP 2: Check whether a palindrome is possible
        // --------------------------------------------------
        int oddFrequencyCount = 0;
        char middleCharacter = 0;
        for (int characterIndex = 0; characterIndex < 26; characterIndex++) {
            if (characterFrequency[characterIndex] % 2 == 1) {
                oddFrequencyCount++;
                middleCharacter = (char) ('a' + characterIndex);
            }
        }
        // More than one odd frequency means palindrome is impossible.
        if (oddFrequencyCount > 1) {
            return "";
        }

        // --------------------------------------------------
        // STEP 3: Keep only half of every frequency
        // --------------------------------------------------
        for (int characterIndex = 0; characterIndex < 26; characterIndex++) {
            characterFrequency[characterIndex] /= 2;
        }

        int stringLength = s.length();
        int halfLength = stringLength / 2;
        char[] leftHalf = new char[halfLength];

        // --------------------------------------------------
        // STEP 4: Build the left half using backtracking
        // --------------------------------------------------
        if (buildLeftHalf(0, false, target, characterFrequency, leftHalf,
                middleCharacter, stringLength)) {
            // --------------------------------------------------
            // STEP 5: Construct the final palindrome
            // --------------------------------------------------
            String leftPart = new String(leftHalf);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            String palindrome = leftPart;
            if (stringLength % 2 == 1) {
                palindrome += middleCharacter;
            }
            palindrome += rightPart;
            return palindrome;
        }
        return "";
    }

    private boolean buildLeftHalf(int currentPosition, boolean alreadyGreaterThanTarget,
            String target, int[] characterFrequency, char[] leftHalf,
            char middleCharacter, int stringLength) {
        if (currentPosition == leftHalf.length) {
            String leftPart = new String(leftHalf);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            String palindrome = leftPart;
            if (stringLength % 2 == 1) {
                palindrome += middleCharacter;
            }
            palindrome += rightPart;
            return palindrome.compareTo(target) > 0;
        }

        char firstCharacterToTry;
        if (alreadyGreaterThanTarget) {
            firstCharacterToTry = 'a';
        } else {
            firstCharacterToTry = target.charAt(currentPosition);
        }

        for (char currentCharacter = firstCharacterToTry;
                currentCharacter <= 'z'; currentCharacter++) {
            int characterIndex = currentCharacter - 'a';
            if (characterFrequency[characterIndex] == 0) {
                continue;
            }
            leftHalf[currentPosition] = currentCharacter;
            characterFrequency[characterIndex]--;
            boolean nowGreaterThanTarget = alreadyGreaterThanTarget
                    || currentCharacter > target.charAt(currentPosition);
            if (buildLeftHalf(currentPosition + 1, nowGreaterThanTarget, target,
                    characterFrequency, leftHalf, middleCharacter, stringLength)) {
                return true;
            }
            characterFrequency[characterIndex]++;
        }
        return false;
    }
}
