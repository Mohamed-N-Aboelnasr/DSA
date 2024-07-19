public class RemoveElement {


    //check in leetcode #27
    // with keeping order (must be in-place)
    public static int removeElement(int[] arr, int val){
        int i=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j] != val){
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
