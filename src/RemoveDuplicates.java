public class RemoveDuplicates {


    // with keeping order (must be in-place)
    public static int removeDuplicates(int[] arr){

        int i=1;
        for(int j=1; j<arr.length; j++){
            if(arr[j] != arr[j-1]){
                arr[i] = arr[j];
                i++;
            }
        }
        return i;

    }
    public static void main(String[] args) {

    }
}
