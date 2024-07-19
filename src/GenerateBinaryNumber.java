import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class GenerateBinaryNumber {


    public static String[] generateBinaryNumber(int n){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i=0; i<n; i++){
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
    }
    public static void main(String[] args) {
        int number = 10;
        String[] result = generateBinaryNumber(number);
        for(String temp : result)
            System.out.println(temp);
    }
}
