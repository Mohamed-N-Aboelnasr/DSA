import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek()<arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.pop();
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
