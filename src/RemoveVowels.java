import java.util.Set;

public class RemoveVowels {


    public String removeVowels(String str){
        Set<Character> vowels = Set.of('a','e','i','o','u');
        StringBuilder result = new StringBuilder();
        for(char c : str.toCharArray()){
            if(!vowels.contains(c)){
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
