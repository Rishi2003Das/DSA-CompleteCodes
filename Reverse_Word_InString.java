class Solution {
    public String reverseWords(String s) {
      Stack<String> str=new Stack();
      String sp=""; 
      s=s.trim();
      s=s+" ";
      boolean p=false;
      for(int i=0;i<s.length();i++){
        char z= s.charAt(i);
        if(z!=' '){
            sp+=z;
            p=true;
        }
        if(p==false && sp!=""){
            str.push(sp);
            sp="";
        }
        p=false;
      }
      String ans="";
      while(!str.isEmpty()){
        ans=ans+str.pop()+" ";
      }
      return ans.trim();
    }
}
