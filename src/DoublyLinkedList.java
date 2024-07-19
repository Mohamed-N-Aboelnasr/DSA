import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{

        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public int length(){
        return this.length;
    }

    public void displayForward(){
        if(head == null)
            return;
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if(tail == null)
            return;
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(this.isEmpty()) {
            tail = newNode;
        }else{
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(this.isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public void insert(int position, int data){
        if(position > this.length()+1){
            throw new IllegalArgumentException("The position can't be bigger than the length of the list");
        }
        if(position <= 0){
            throw new IllegalArgumentException("The position can't be equal or smaller than 0");
        }
        if(position == 1) {
            this.insertFirst(data);
            return;
        }
        if(position == this.length+1) {
            this.insertLast(data);
            return;
        }
        int count = 1;
        ListNode newNode = new ListNode(data);
        ListNode temp = null;
        if(position <= this.length()/2){
            temp = head;
            while(count < position-1){
                temp = temp.next;
                count++;
            }
            newNode.previous = temp;
            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
        }else{
            position = this.length()-position+1; // position from end
            temp = tail;
            while(count < position){
                temp = temp.previous;
                count++;
            }
            newNode.next = temp;
            newNode.previous = temp.previous;
            temp.previous.next = newNode;
            temp.previous = newNode;
        }
    }

    public ListNode deleteFirst(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        ListNode temp = head;
        if(this.length() == 1){
            head = tail = null;
            return temp;
        }
        head.next.previous = null;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        ListNode temp = tail;
        if(head == tail){
            head = tail = null;
            return temp;
        }
        tail.previous.next = null;
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }



    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);
        dll.insertLast(4);
        dll.insertLast(5);
        dll.insertLast(6);
        dll.insertLast(8);
        dll.insertLast(9);
        dll.insert(7,7);
        dll.displayForward();
//        System.out.println(dll.length);
    }
}
