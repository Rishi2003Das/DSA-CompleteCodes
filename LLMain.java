class LLMain{
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.insertFirst(4);
        list.insertFirst(11);
        list.insertFirst(42);
        list.insertFirst(25);
        list.insertFirst(74);
        list.insertLast(55);
        list.insertLast(99);
        list.insertLast(67);
        list.insertMiddle(90,3);
        list.insertMiddle(6,2);
        list.insertMiddle(15,6);
        list.display();
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}