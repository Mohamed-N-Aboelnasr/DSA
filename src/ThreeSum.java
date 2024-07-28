import java.util.Arrays;

public class ThreeSum {


    public static void threeSum(int[] arr, int target){
        Arrays.sort(arr);
        for(int i=0; i<arr.length-2; i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    System.out.println("{"+arr[i]+","+arr[j]+","+arr[k]+"}");
                    j++;
                    k--; // numbers are distinct
                }
                else if(sum < target)
                    j++;
                else
                    k--;
            }
        }
    }
    public static void main(String[] args) {

    }
}
