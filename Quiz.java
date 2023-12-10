//Assignemnt 17
import java.util.*;
class Quiz{
    void accept(){
        int p;//Total number of participants
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Enter the number of participants: ");
            p=sc.nextInt();
            if(p<=3||p>=11)
            System.out.println("Input size out of range");
        }while(p<=3||p>=11);
        char a[][]=new char [p][5];//Array of marks of all participants
        char ans[]=new char [5];
        int scr[]=new int[p];//To store the score of each participants
        for (int i=0;i<p;i++){
            System.out.println("Participant:"+(i+1));
            for (int j=0;j<5;j++){
            System.out.println("Enter the correct option:");
             a[i][j]=Character.toUpperCase(sc.next().charAt(0));                              
            }//end of for
        }//end of for
        System.out.println("Enter answer key");
        for (int j=0;j<5;j++)
        ans[j]=Character.toUpperCase(sc.next().charAt(0));
        int score,max; 
        score=max=0;         
        for (int i=0;i<p;i++){
            for (int j=0;j<5;j++){
                if(a[i][j]==ans[j])
                score ++;
            }//end of for            
            scr[i]=score;
            score=0;
        }//end of for
        System.out.println("Output scores");
        for(int i=0;i<p;i++){
            System.out.println("Participant:"+(i+1)+"= "+scr[i]);
        }//end of for
        for(int i=0;i<p;i++){
            max=Math.max(max,scr[i]);
        }//end of for
        System.out.println("Highest score:");
        for(int i=0;i<p;i++){
            if(scr[i]==max)
            System.out.println("Participant "+(i+1));
        }//end of for        
    }//end of accept()
    public static void main(String args[]){
        Quiz ob=new Quiz();
        ob.accept();
    }//end of main
} //end of class