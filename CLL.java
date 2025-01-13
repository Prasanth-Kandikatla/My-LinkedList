public class CLL {

    private Node head;
    private Node tail;
    CLL(){
        this.head = null;
        this.tail = null;
    }

    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }

    // Add a node at begining
    public void addFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;
            return;
        }
        node.next = head;
        tail.next = node;
        head = node;
    }

    // Delete a node
    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.value == value){
            tail.next = head.next;
            head = tail.next;
            return;
        }

        do{
            Node n = node.next;
            if(n.value==value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node!=head);

    }
    // Display CLL
    public void display(){

        Node temp = head;
        do{
            System.out.print(temp.value+"-->");
            temp = temp.next;
        } while(temp!=head);
        System.out.println("HEAD");
    }    
}
