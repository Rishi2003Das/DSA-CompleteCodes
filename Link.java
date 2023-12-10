//Assignment 13
import java.util.*;
public class Link{
    private int lnk[];//Instance array
    private int max;//Instance variable
    private int begin;
    private int end;
    public  Link(int  mm){//Parameterised constructor
        max=mm;//Initialysing the variables
        begin=0;
        end=0;
        lnk=new int[max];//Initialysing the array
     }//end of Link(int)
    public void addlink(int v){
        if(end<max){
            lnk[end]=v;//Storing value in the array from the backside
            end++;
        }//end of if
        else
        {
            System.out.println("Out Of Size");
        }//end of else
    }//end of addlink(int)
    public int dellink(){
        if(begin<end){
            begin++;
            return lnk[begin-1];
        }//end of if
        else
        {
            System.out.println("EMPTY");
            return -99;
        }//end of else
    }//end of dellink()
    public void display(){
        if(begin==end)
            System.out.println("The link is empty");
        else
        {
        System.out.println("The current elements of link are: ");
        for(int i=begin;i<end;i++){
            System.out.print(lnk[i]+" ");
        }//end of for loop
     }//end of else
    }//end of display()
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=0;//To store the total  number of element
        while(true){
            System.out.println("Enter number of elements in the link");
             n=sc.nextInt();
            if(n<=100)//Wrong case
            break;
            System.out.println("Number of elements cannot be greater than 100");
        }//end of while
        Link obj=new Link(n);
        int cho=0;
       outer: while(true){
            System.out.println("Choose what to do \n 1)Add new elements to rear \n 2)Delete elements from front \n 3)Show the current link \n Any other key to exit");
            cho=sc.nextInt();
            switch(cho){
                case 1: System.out.println("Enter element to be added");
                obj.addlink(sc.nextInt());
                break;
                case 2:int a=obj.dellink();
                System.out.println("The object deleted is "+a);
                break;
                case 3: obj.display();
                break;
                default: break outer ;
            }//end of switch
        }//end of while
    }//end of main
}//end of class
