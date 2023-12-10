import java.util.*;
class Sorter{
    int Num[];
    int N;
    int Pos;
    Sorter(){
        Num=new int[150];
        Pos=N=0;
    }
    Sorter(int nx){
        N=nx;
        Num=new int[N];
        Pos=0;
    }
    void readnumbers(){
        for(int i=0;i<N;i++)
        Num[i]=new Scanner(System.in).nextInt();
    }
    void show(){
        for(int i:Num)
        System.out.print(i+" ");
        sortnumbers(Num,0);
        System.out.println();
        System.out.println("Sorted Array");
        for(int i:Num)
        System.out.println(i+" ");
    }
    void sortnumbers(int arr[],int size){
        if(size<arr.length-1){
            Pos=size;
            for(int j=size+1;j<arr.length;j++){
                if(arr[j]<arr[Pos])
                Pos=j;
            }
            int t=arr[size];
            arr[size]=arr[Pos];
            arr[Pos]=t;
            sortnumbers(arr,++size);
        }
    }
    public static void main(String args[]){
        Sorter ob=new Sorter(5);
        ob.readnumbers();
        ob.show();
    }
}