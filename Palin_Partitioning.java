class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> list= new  ArrayList<>();
        func(0, s, ans, list);
        return ans;
    }

    public void func(int ind, String s, List<List<String>> ans, List<String> list){
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for( int i=ind; i < s.length(); ++i){
            if(isPalin(s,ind,i)){
                list.add(s.substring(ind, i+1));
                func(i+1, s, ans, list);
                list.remove(list.size()-1);
            }
        }
        
    }

    boolean isPalin(String str, int start, int end){// T.C.-> O(N)
    while(start<=end){
        if(str.charAt(start++)!=str.charAt(end--))
    return false;
    }
        return true;
    }
}
