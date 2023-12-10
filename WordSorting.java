import java.util.*;
class WordSorting{
    void accept(){
        String r="";
        String ns="";
        System.out.print("Enter the sentence:");
        String s=new Scanner(System.in).nextLine();
        char l=(s.charAt(s.length()-1));
        if(l!='.' && l!=',' && l!='?' && l!='!')
            System.out.println("Invalid Sentence");
        else
        {
            s=s.substring(0,s.length()-1);
            s=s+" ";
            for(int i=1;i<=10;i++){
                for(int j=0;j<s.length();j++){
                    char x=s.charAt(j);
                    if(x!=' ')
                    r=r+x;
                    else
                    {
                        if(r.length()==i)
                        ns+=r+" ";
                        r=" ";
                    }
                }
            }
            s=s.trim();
            ns=ns.trim();
            System.out.println(Character.toUpperCase(s.charAt(0))+s.substring(1)+l);
            System.out.println(Character.toUpperCase(ns.charAt(0))+ns.substring(1)+l);
        }
    }
    public static void main(String args[]){
        WordSorting ob=new WordSorting();
        ob.accept();
    }
}