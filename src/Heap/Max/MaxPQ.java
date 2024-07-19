package Heap.Max;

public class MaxPQ {

    private Integer[] heap;
    private int size;

    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int length(){
        return size;
    }

    public int getMax(){
        return heap[1];
    }

    public void insert(int val){
        if(size == heap.length-1){
            resize(2*heap.length);
        }
        size++;
        heap[size] = val;
        swim(size);
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1,size);
        size--;
        sink(1);
        heap[size+1] = null;
        if(size <= (heap.length-1)/4)
            resize(heap.length/2);
        return max;
    }

    private void sink(int idx){
        while(idx*2 <= size){
            int j = idx*2;
            if(j<size && heap[j] < heap[j+1])
                j++;
            if(heap[idx] >= heap[j])
                break;
            swap(idx,j);
            idx = j;
        }
    }

    private void swim(int idx){
        while(idx > 1 && heap[idx] > heap[idx/2]){
            swap(idx, idx/2);
            idx = idx/2;
        }
    }

    private void swap(int idx1, int idx2){
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
    private void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i=0; i<heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMaxHeap(){
        for(int i=1; i<=size; i++){
            System.out.print(heap[i] + " ");
        }
    }
    public static void main(String[] args) {

    }
}
