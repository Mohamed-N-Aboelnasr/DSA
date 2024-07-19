package Hashing;

public class HashTable {

    private int numOfBuckets;
    private int size;
    private HashNode[] buckets;

    public HashTable(){
        this(10);
    }

    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        this.size = 0;
        this.buckets = new HashNode[numOfBuckets];
    }

    public class HashNode{
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    // Modular Hashing
    private int getBucketIndex(Integer key){
        return key%numOfBuckets;
    }

    public String get(Integer key){
        if (key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode current = buckets[bucketIndex];

        while(current != null){
            if(current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }


    public void put(Integer key, String value){
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode current = buckets[bucketIndex];

        while(current != null){
            if(current.key.equals(key)) {
                current.value = value;  // update the value
                return;
            }
            current = current.next;
        }
        size++;
        HashNode newNode = new HashNode(key,value);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
    }


    public String remove(Integer key){
        if (key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        if(buckets[bucketIndex] == null){
            return null;
        }else{
            HashNode current = buckets[bucketIndex];
            if(current.key == key){
                buckets[bucketIndex] = current.next;
                size--;
                return current.value;
            }else {
                HashNode previous = current;
                current = current.next;
                while (current != null) {
                    if (current.key == key) {
                        previous.next = current.next;
                        size--;
                        return current.value;
                    }
                    previous = current;
                    current = current.next;
                }
                return null;
            }
        }
    }
    public static void main(String[] args) {

    }
}
