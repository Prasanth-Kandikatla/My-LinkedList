
class Main1{
    public static void main(String[] args){

        // Creating my linkedList and adding values into it

        LL list = new LL();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(5);
        
        LL list1 = new LL();
        list1.insertAtLast(1);
        list1.insertAtLast(3);
        list1.insertAtLast(4);

        list.display();
        LL ans = LL.merge(list, list1);
        ans.display();

        // Creating my DLL and performing basic operations

        // DLL list = new DLL();
        // list.atFirst(1);
        // list.atFirst(2);
        // list.atFirst(6);
        // list.atFirst(4);
        // list.atFirst(9);
        // list.atFirst(3);
        // list.addAtEnd(100);
        // list.insert(24, 2);
        // list.display();


        // Creating my CLL and performing basic operations
        // CLL list = new CLL();
        // list.addFirst(1);
        // list.addFirst(2);
        // list.addFirst(6);
        // list.delete(2);
        // list.display();

    }
}