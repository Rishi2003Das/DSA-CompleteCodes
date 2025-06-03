class Swap{
    void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    System.out.println("After swapping, a = " + a + " and b = " + b);
}
public static void main(String[] args) {
    int x = 5, y = 10;
    System.out.println("Before swapping, x = " + x + " and y = " + y);
    Swap ob=new Swap();
    ob.swap(x,y);
}
}