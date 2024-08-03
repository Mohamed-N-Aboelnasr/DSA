import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String str){
       Map<Character,Integer> map = new HashMap<>();
       int start = 0;
       int maxLength = 0;
       for(int end=0; end<str.length(); end++){
           char c = str.charAt(end);
           if(map.containsKey(c)){
               start = Math.max(start,map.get(c)+1);
           }
           map.put(c,end);
           maxLength = Math.max(maxLength,end-start+1);
       }
       return maxLength;
    }

    public static String longestSubstring(String str){
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        int startOfMax = 0;
        for(int end=0; end<str.length(); end++){
            char c = str.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c)+1);
            }
            map.put(c,end);
            if((end-start+1)>maxLength){
                maxLength = end - start + 1;
                startOfMax = start;
            }
        }
        return str.substring(startOfMax,startOfMax+maxLength);
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        String str2 = "bbbb";
        String str3 = "pwwkewfzxcw";
        System.out.println(longestSubstring(str));
    }
}
