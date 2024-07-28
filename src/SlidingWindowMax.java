public class SlidingWindowMax {


    public static int[] slidingWindowMax(int[] arr, int size){
        int[] result = new int[arr.length - size + 1];
        for(int i=0; i<result.length; i++){
            int temp = i+size-1;
            int max = arr[temp];
            while(temp > i){
                if(arr[temp-1] > max){
                    max = arr[temp-1];
                }
                temp--;
            }
            result[i] = max;
        }
        return result;

    }
    public static void main(String[] args) {

        int[] arr = {44,77,33,44,88,11,56,21,90,2,0,7,11};
        int size = 4;
        int[] result = slidingWindowMax(arr,size);
        for(int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
