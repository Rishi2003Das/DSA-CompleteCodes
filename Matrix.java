 //Assignment14
import java.util.*;
class Matrix
{
    private int mat[][],m,n;//instance variables
    public void accept()
    {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Enter the row and column numbers: ");
            m = sc.nextInt();
            n = sc.nextInt();
            if(m<2 || m>10 || n<2 || n>10)
                System.out.println("Wrong input./n Enter the proper value:");
        }while(m < 2 || m > 10 || n < 2 || n > 10);//Checking of the input values
        mat = new int[m][n];//Dynamic declaration of the matrix
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < m; i++)//outer for loop
        {
            for(int j = 0; j < n; j++)//inner for loop
            {
                do
                {
                    mat[i][j] = sc.nextInt();
                    if(mat[i][j] < 100)
                        System.out.println("Elements must be at least 3-digits.\nPlease Enter again.");
                }while(mat[i][j] < 100);//Checking of the input values
            }//end of for loop
        }//end of for loop
    }//end of accept()
    public void display()
    {
        System.out.println("Original Matrix : ");
        show();//calling the method show()
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                mat[i][j] = reverse(replace(mat[i][j]));                
            }
        }
        System.out.println("Output : ");
        show();
    }
    int reverse(int x)
    {
        int r = 0;
        while(x!= 0)
        {
            r = r*10 + (x%10);
            x/=10;
        }//end of while()
        return r;
    }//end of reverse(int)
    public void show()
    {
        for(int i = 0 ; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(mat[i][j] + "\t\t");
            }//end of for
            System.out.println();
        }//end of for
    }//end of show()
    public int replace(int x)
    {
        int len = count(x);    
        int r = 0;
        while(x!= 0)
        {
            int d = x % 10;
            if(isPrime(d))
                d = nextPrime(d);
            r = (r * (int)Math.pow(10,count(d))) + d;
            x/= 10;
        }//end of while
        return r;
    }//end of replace(int)
    public int count(int x)
    {
        int c = 0;
        while(x !=0)
        {
            c++;
            x/=10;
        }//end of while
        return c;
    }//end of count(int)
    public boolean isPrime(int x)
    {
        int c = 0;
        for(int i = 1; i <= x/2; i++)
        {
            if(x%i == 0)
               c++;
        }//end of while
        return (c == 1)?true:false;//turnary operator
    }//end of isPrime(int)
    public int nextPrime(int x)
    {
        int arr[] = {2,3,5,7,11};
        int res = 0;
        for(int i = 0; i < arr.length -1; i++)
        {
            if(arr[i] == x)
            {
                res = arr[i+1];
                break;
            }//end of if
        }//end of while
        return res;
    }//end of nextPrime(int)
    public static void main(String[]args)
    {
        Matrix obj = new Matrix();
        obj.accept();//calling of the methods 
        obj.display();//calling of the methods
    }//end of main
}//end of class