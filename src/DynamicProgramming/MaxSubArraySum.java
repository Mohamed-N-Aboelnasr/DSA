package DynamicProgramming;

public class MaxSubArraySum {

    public static long maxSubArraySum(int[] arr){
        long currentMax = arr[0];
        long maxSoFar = arr[0];
        int start=0,tempStart=0,end=0;
        for(int i=1; i<arr.length; i++){
            currentMax += arr[i];
            if(currentMax < arr[i]){
                tempStart = i;      // Start a new SubArray
                end = i-1;
                currentMax = arr[i];
            }
            if(maxSoFar < currentMax){
                start = tempStart;
                end = i;
                maxSoFar = currentMax;
            }
        }
        System.out.println("The subarray starts at index : "+start+" and ends at index "+end);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,-2,6,12,7,-1,-66,70};
        System.out.println(maxSubArraySum(arr));
    }
}
