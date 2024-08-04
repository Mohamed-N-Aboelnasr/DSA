public class DutchFlagProblem {


    // Move 0's, 1's and 2's
    public static void dutchFlag(int[] arr){
        int i=0,j=0,k=arr.length-1;
        while(i<=k){
            if(arr[i]=='0'){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[i]=='1'){
                i++;
            }
            else{
                swap(arr,i,k);
                i++;
                k--;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static void main(String[] args) {

    }
}
