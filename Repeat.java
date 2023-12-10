package Programs;
import java.util.*;
class Repeat{
    private int st[];
    private int cap;
    private int fr;
    private int re;
    Repeat(int m){
        cap=m;
        fr=re=0;
        st=new int[0];
    }
    void pushvalue(int v){
        if(re<(cap-1))
        st[re++]=v;
        else
        System.out.println("OVERFLOW");
    }
}