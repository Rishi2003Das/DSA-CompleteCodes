class Pair{
    String name;
    int step;
    Pair(String n, int s){
        this.name=n;
        this.step=s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> st = new HashSet<String>();
        int len= wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().name;
            int steps=q.peek().step;
            q.remove();
            if(word.equals(endWord) == true){
                return steps;
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    String n=Character.toString(ch);
                    String newStr = word.substring(0, i) + n + word.substring(i + 1);
                    if(st.contains(newStr) == true){
                        st.remove(newStr);
                        q.add(new Pair(newStr,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
