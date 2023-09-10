//Quick Sort in Linked List
import java.util.*;
class QSort{
    public static void main(){
        Scanner sc=new Scanner(System.in);
        LinkedList<Integer> list= new LinkedList<Integer>();
        System.out.println("Enter the length of the list");
        int n= sc.nextInt();
        for(int i=0; i<n; i++){
        System.out.println("Enter the value of the list");
        list.addLast(sc.nextInt());
        }
        QSort ob=new QSort();
        ob.qSort(list,0,n-1);
        System.out.println("The required list is: "+list);
    }
    public static void qSort(int list,int low, int high){
        if(low < high){
            int piv= partition(list,low,high);
            qSort(list,low,piv-1);
            qSort(list,piv+1,high);
        }
        else
        return;
    }
    public static int partition(int list, int low, int high){
        LinkedList<Integer> list= new LinkedList<Integer>();
        int pivot= list.get(high);
        int i= low-1;
        for(int j=low; j<high ; j++){
            if((list.get(j))< pivot){
                i++;
                int temp= list.get(i);
                list.add(i, list.get(j));
                list.add(j, temp);
            }
        }
        i++;
        int temp=list.get(i);
                list.add(i, pivot);
                list.add(high,temp);
    }
}
