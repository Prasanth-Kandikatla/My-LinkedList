public class LL{
    private Node head;
    private Node tail;
    private int size;

    LL(){
        this.size = 0;
    }

    // Creating a class for "Nodes"
    //  A node contains a value and address to the next node
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertAtLast(int value){
                        
        if (tail == null){
            insertAtFirst(value);
        }
        else{
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }


        // Use this method while we do not declare "temp" variable in LL class, but it takes O(N) to insert at last. But if we declare "tail" in LL calss we can can insert at last in O(1) (In constant time)
                            // Node temp = head;
                            // if(temp.next!=null){
                            //     temp = temp.next;
                            // }
                            // Node node = new Node(value);
                            // temp.next = node;
                            // tail = node;
        
    }

    //  Insert a node 
    public void insert(int value, int index){
        if(head == null){
            insertAtFirst(value);
            return;
        } 
        if(tail == null) {
            insertAtLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i< index; i++){
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    // Deleting a node at the begining
    public int deleteAtFirst(){
        int val = head.value;
        if(head==tail){
            head = head.next;
            tail = null;
            size--;
            return val;
        }
        head = head.next;
        size--;
        return val;
    }
    
    // kp method to delete at last there is another approach below
                // public void deleteAtLast(){
                //     Node temp = head;

                //     while(temp.next.next != null){
                //         temp = temp.next;
                //     }
                //     temp.next = null;
                //     tail = temp;
                //     size--; 
                // }


    // Alternate function to delete last element
    public int deleteLast(){
        if(head ==tail){
            return deleteAtFirst();
        }
        Node secondlast  = get(size-2);
        int val = tail.value;
        secondlast.next = null;
        tail = secondlast;

        return val;
    }

    // Delete at a particular index
    public int delete(int index){
        if (size==1){
            return deleteAtFirst();
        }
        if(index == size -1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    // function to retrieve the node at a given index
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    // Function to return value of a node at a particular index
    public int valueAt(int index){
        if(size<=1){
            return head.value;
        }
        if(index == size - 1){
            return tail.value;
        }

        Node node = get(index);
        return node.value;
    }

    // Merge two sorted LinkedLists, list1 and list2 are heads of LL1 and LL1 respectively
    public static LL merge(LL first, LL second){

        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while(f != null && s != null){
            if(f.value <= s.value){
               ans.insertAtLast(f.value);
                f = f.next;
            }
            else{
                ans.insertAtLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            ans.insertAtLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertAtLast(s.value);
            s = s.next;
        }
        return ans;
    }


    // Function to display the linkedlist
    public void display(){
        Node temp = head;
        while(temp != null){
             System.out.print(temp.value +"-->");
             temp = temp.next;
        }
        System.out.println("null");
    }
}