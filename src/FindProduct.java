public class FindProduct {


    public static int[] findProduct(int[] arr){

        int[] result = new int[arr.length];
        int temp = 1;
        for(int i=0; i<arr.length; i++){
            result[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for(int i=arr.length-1; i>=0; i--){
            result[i] = result[i] * temp;
            temp = temp * arr[i];
        }
        return result;

    }
    public static void main(String[] args) {

    }
}
