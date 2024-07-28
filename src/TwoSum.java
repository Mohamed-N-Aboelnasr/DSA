import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {



    //HashMap approach
    public static int[] twoSum(int[] arr, int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],0);
        for(int i=1; i<arr.length; i++){
            if(!map.containsKey(target-arr[i])){
                map.put(arr[i],i);
            }else{
                result[0]=map.get(target-arr[i]);
                result[1] = i;
                return result;
            }
        }
        throw new IllegalArgumentException("The two indices aren't exist");
    }


    //Two pointer approach (if sorted)
    public static int[] twoSumII(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int sum=0;
        int[] result = new int[2];
        while(left<right){
            sum = arr[left] + arr[right];
            if(sum == target){
                result[0] = arr[left];
                result[1] = arr[right];     //you can use left and right if you want index not value
                return result;
            } else if (sum < target) {
                left++;
            }else{
                right--;
            }
        }
        throw new IllegalArgumentException("The two indices aren't exist");
    }

    public static void main(String[] args) {

        int[] arr = {2,11,5,10,7,8};
        int[] result = twoSumII(arr,9);
        System.out.println("The first value : "+result[0]+" And the second value : "+result[1]);
    }
}
