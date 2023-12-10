//Assignment5
//Calculating fine on library books
package Inheritance;
class Library{
    String name;
    String author;
    int p;
    Library(String n, String a, int x){
        name = n;
        author = a;
        p = x;
    }//end of constructor method
    void show(){
        System.out.println("Name of the book is " + name);// Printing statements of the book details
        System.out.println("Author of the book is " + author);
        System.out.println("Price of the book = " + p);
    }//end of show()
}//end of class
