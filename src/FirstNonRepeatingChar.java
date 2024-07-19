import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {


    public int firstNonRepeatingCharacter(String str){
        Map<Character,Integer> count = new HashMap<>();
        for(char c : str.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        for(int i=0; i<str.length(); i++){
            if(count.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
