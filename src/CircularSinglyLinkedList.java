import java.util.List;
import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList(){
        this.last = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public int length(){
        return this.length;
    }

    public void createCircularSinglyLinkedList(){
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = firstNode;
        last = fifthNode;
        this.length = 5;
    }

    public void display(){
        if(this.isEmpty())
            return;
        ListNode temp = last.next;
        while(temp != last){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            last = newNode;
        }else{
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            last = newNode;
            last.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public ListNode removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        ListNode temp = last.next;
        if(last == last.next){
           last = null;
        }else{
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode removeLast(){
        if(isEmpty())
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        ListNode temp = last;
        if(last == last.next)
            last = null;
        else{
            ListNode tempNode = last.next;
            while(tempNode.next != last){
                tempNode = tempNode.next;
            }
            tempNode.next = last.next;
            last = tempNode;
        }
        temp.next = null;
        length--;
        return temp;

    }

    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList();
        csll.display();
    }
}
