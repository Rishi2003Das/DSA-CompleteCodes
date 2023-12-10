package Programs;
class PalinP
{
    private String w;
    PalinP(){
        w="";
    }
    void read(){
        do{
            System.out.print("Input:\t \t");
            w=new java.util.Scanner(System.in).next();
        } while(w.length()>20);
    }
    boolean check(){
        int l=w.length(), c=0;
        for(int i=0; i<=(l-1)/2; i++)
            if(w.charAt(i)!=w.charAt(l-1-i))
                c++;
        return c==1;
    }
    public static void main(String args[]){
        PalinP ob=new PalinP();
        ob.read();
        System.out.println("Output:\t \t"+(ob.check()?"POSSIBLE":"NOT POSSIBLE"));
    }
}