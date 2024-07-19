import java.util.List;

public class SinglyLinkedList<T>{

    private ListNode<T> head;

    private static class ListNode<T>{

        private T data;
        private ListNode next;

        public ListNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void printSinglyLinkedList(){
        ListNode<T> current = this.head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public int length(){
        if(head == null)
            return 0;
        int len = 0;
        ListNode<T> current = head;
        while(current.next != null){
            len++;
            current = current.next;
        }
        return len;
    }

    public void insertFirst(T value){
        ListNode<T> first = new ListNode<>(value);
        first.next = head;
        head = first;
    }

    public void insertLast(T value){
        if(head == null){
            head = new ListNode<>(value);
            return;
        }
        ListNode<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    public void insert(int position, T data){
        ListNode<T> node = new ListNode(data);
        if(position == 1){
            node.next = head;
            head = node;
        }else{
            ListNode<T> previous = head;
            int count = 1;
            while(count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode<T> current = previous.next;
            previous.next = node;
            node.next = current;

        }

    }

    public ListNode<T> deleteFirst(){
        if(head == null)
            return null;
        else{
            ListNode<T> node = head;
            head = head.next;
            node.next = null;
            return node;
        }
    }

    public ListNode<T> deleteLast(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            ListNode<T> node = head;
            head = head.next;
            return node;
        }
        ListNode<T> previous = null;
        ListNode<T> current = head;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public ListNode<T> delete(int position){
        if(head == null || position > this.length()){
            return null;
        }
        if(position == 1){
            ListNode<T> temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }else {
            int count = 1;
            ListNode<T> previous = head;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode<T> temp = previous.next;
            previous.next = temp.next;
            temp.next = null;
            return temp;
        }
    }

    public boolean find(ListNode<T> head, T searchValue){
        if(head == null)
            return false;
        ListNode<T> current = head;
        while(current != null){
            if(current.data == searchValue){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode<T> reverse(ListNode<T> head){
        if(head == null){
            return null;
        }
        ListNode<T> current = head;
        ListNode<T> previous = null;
        ListNode<T> next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode<T> findMiddleNode(ListNode<T> head){
        if(head == null)
            return null;
        ListNode<T> fastPtr = head;
        ListNode<T> slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode<T> getNthNodeFromEnd(int n){
        if(head == null)
            return null;
        if(n <= 0)
            throw new IllegalArgumentException("Invalid value: n = "+n);
        ListNode<T> refPtr = head;
        ListNode<T> mainPtr = head;
        int count = 0;
        while(count < n){
            if(refPtr == null)
                throw new IllegalArgumentException("The value of n is greater than number of nodes");
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeDuplicates(ListNode<T> head){
        if(head == null){
            return;
        }
        ListNode<T> current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current = current.next.next;
            }
            else
                current = current.next;
        }

    }

    public ListNode<T> insertNodeInSorted(int value){
        ListNode<T> node = new ListNode(value);
        if(head == null){
            head = node;
            return head;
        }
        ListNode<T> current = head;
        ListNode<T> temp = null;
        while(current != null && (int)current.data < (int)node.data){
            temp = current;
            current = current.next;
        }
        temp.next = node;
        node.next = current;
        return head;
    }

    public void deleteNode(int value){
        if(head == null){
            return;
        }
        ListNode<T> current = head;
        ListNode<T> previous = null;

        if((int)current.data == value){
            head = current.next;
            return;
        }

        while(current != null && (int)current.data != value){
            previous = current;
            current = current.next;
        }

        if(current == null)
            return;

        previous.next = current.next;
        current.next = null;
    }

    public boolean containsLoop(){
        ListNode<T> fastPtr = head;
        ListNode<T> slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            if(fastPtr == slowPtr)
                return true;
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return false;
    }

    public ListNode<T> startNodeInLoop(){
        ListNode<T> slowPtr = head;
        ListNode<T> fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            if(fastPtr == slowPtr)
                return getFirstNodeInLoop(slowPtr);
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return null;
    }

    public ListNode<T> getFirstNodeInLoop(ListNode<T> firstPtr){
        ListNode<T> secondPtr = head;
        while(firstPtr != null && firstPtr.next != null){
            if(firstPtr == secondPtr)
                return firstPtr;
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        return null;
    }

    public void removeLoop(){
        ListNode<T> fastPtr = head;
        ListNode<T> slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            if(fastPtr == slowPtr)
                 removeLoop(slowPtr);
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
    }

    private void removeLoop(ListNode<T> slowPtr){
        ListNode<T> temp = head;
        while(temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        if(temp.next == slowPtr.next){
            slowPtr.next = null;
        }
    }

    public ListNode<Integer> merge(ListNode<Integer> a, ListNode<Integer> b){
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> tail = dummy;

        while(a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null)
            tail.next = b;
        else
            tail.next = a;
        return dummy.next;

    }

    public ListNode<Integer> addTwo(ListNode<Integer> a, ListNode<Integer> b){
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int x = (a != null)?a.data:0;
            int y = (b != null)?b.data:0;
            int sum = x + y + carry;
            carry = sum/10;
            tail.next = new ListNode<>(sum%10);
            tail = tail.next;
            if(a != null)
                a = a.next;
            if(b != null)
                b = b.next;
        }
        if(carry > 0)
            tail.next = new ListNode<>(carry);
        return dummy.next;
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.head = new ListNode<>(10);
        ListNode<Integer> second = new ListNode<>(11);
        ListNode<Integer> third = new ListNode<>(12);
        ListNode<Integer> fourth = new ListNode<>(13);

        // Now we need to connect them to form a chain
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.insert(1,21);
        sll.insert(5,25);
        sll.insert(7,27);
        sll.insertLast(28);
        sll.printSinglyLinkedList();
        System.out.println("\n--------------------------");
//        sll.head = sll.reverse(sll.head);
//        sll.printSinglyLinkedList();
//        System.out.println(sll.findMiddleNode(sll.head).data);
        System.out.println(sll.getNthNodeFromEnd(9).data);
    }
}
