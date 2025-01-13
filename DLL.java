public class DLL { 

    private Node head;
    
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        
        public Node(int value){
            this.value = value;
        }
        public Node (int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
    // Insert atFirst element
    public void atFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    // Display DLL also display reverse list
    public void display(){
        Node node = head;
        Node last = null;
        while(node!=null){
            System.out.print(node.value+"-->");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while(last!=null){
            System.out.print(last.value+"-->");
            last = last.prev;
        }
        System.out.println("START");
    }

    // Adding a node at end
    public void addAtEnd(int value){
        if(head == null){
            atFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
    }

    // Add at a particular index
    public void insert(int value, int index){
        Node node = new Node(value);
        Node p = get(index-1);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }

    }

    // function to retrieve the node at a given index
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
}
