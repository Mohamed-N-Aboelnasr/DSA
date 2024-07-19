import java.util.Stack;

public class StringReverse {

    public static String reverse(String str){
        Stack<Character> charsStack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            charsStack.push(c);
        }
        for(int i=0; i<str.length(); i++){
            chars[i] = charsStack.pop();
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println("The String before reverse : "+ str);
        System.out.println("The String after reverse : "+ reverse(str));
    }
}
