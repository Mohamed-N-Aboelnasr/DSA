package Stack.Array;

import java.util.EmptyStackException;

public class Stack {

    private int top;
    private int[] arr;

    public Stack(int capacity){
        top = -1;
        arr = new int[capacity];
    }

    public Stack(){
        this(10);
    }

    public int length(){
        return top+1;
    }

    public boolean isEmpty(){
        return length()==0;
    }

    public boolean isFull(){
        return length()==arr.length;
    }

    public void push(int data){
        if(isFull())
            throw new RuntimeException("The Stack is Full");
        arr[top+1] = data;
        top++;
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();
        int result = arr[top];
        top--;
        return result;
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr[top];
    }

    public static void main(String[] args) {

    }
}
