class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int val[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            if(isVowel(words[i])){
                val[i]=1;
            }
        }
        int ans[]=new int[queries.length];
        int sum=0;
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<=queries[i][1];j++){
                sum=sum+val[j];
            }
            ans[i]=sum;
            sum=0;
        }
        return ans;
    }

    boolean isVowel(String str){
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(str.length() - 1);
        ch1 = Character.toLowerCase(ch1);
        ch2 = Character.toLowerCase(ch2);
        if((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u')&&(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u'))
        return true;
        else
        return false;
    }
}
