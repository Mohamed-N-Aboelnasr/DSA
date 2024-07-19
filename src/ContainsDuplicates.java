import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static boolean containsDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();
        int size = arr.length;

        for(int i=0; i<size; i++){
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
