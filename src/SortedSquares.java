public class SortedSquares {


    public static int[] sortedSquares(int[] arr){
        int size = arr.length;
        int[] result = new int[size];
        int i=0;
        int j=size-1;
        for(int k=size-1; k>=0; k--){
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            }else{
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
