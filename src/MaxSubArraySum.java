public class MaxSubArraySum {


    public static Long maxSubArraySum(int[] arr, int size){
        Long maxSum = Long.MIN_VALUE;
        int windowSum = 0;
        int start = 0;
        for(int i=0; i<arr.length; i++){
            windowSum += arr[i];
            if(i>=size-1){
                maxSum = Math.max(windowSum,maxSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
