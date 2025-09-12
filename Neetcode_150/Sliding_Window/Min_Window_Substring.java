class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty() || s.isEmpty()) return "";

        int[] mp = new int[256];
        for (char c : t.toCharArray()) mp[c]++;

        int l = 0, minLen = Integer.MAX_VALUE, cnt = 0, sIndex = -1;
        int m = t.length();

        for (int r = 0; r < s.length(); r++) {
            if (mp[s.charAt(r)] > 0) cnt++;
            mp[s.charAt(r)]--;

            while (cnt == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                mp[s.charAt(l)]++;
                if (mp[s.charAt(l)] > 0) cnt--;
                l++;
            }
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
