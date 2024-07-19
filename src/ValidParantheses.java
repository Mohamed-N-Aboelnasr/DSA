import java.util.Stack;

public class ValidParantheses {

    public static boolean isValidParantheses(String str){
        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                else{
                    if((stack.peek() == '(' && c == ')') ||  (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}'))
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

    }
}
