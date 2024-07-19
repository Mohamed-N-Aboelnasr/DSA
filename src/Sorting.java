import java.util.HashMap;
import java.util.Map;

public class Sorting {


    public static void selectionSort(int[] arr){
        int size = arr.length;
        for(int i=0; i<size-1; i++){
            int minIdx = i;
            for(int j=i+1; j<size; j++){
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }
            swap(arr, minIdx, i);
        }
    }

    public static void bubbleSort(int[] arr){
        int size = arr.length;
        for(int i=size-1; i>0; i--){
            boolean isChanged = false;
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    isChanged = true;
                }
            }
            if(!isChanged)
                break;
        }
    }

    public static void insertionSort(int[] arr){
        int size = arr.length;
        for(int i=0; i<size-1; i++){
            int j=i+1;
            int temp = arr[j];
            while(j>0){
                if(temp<arr[j-1]){
                    arr[j] = arr[j-1];
                    j--;
                }else{
                    break;
                }
            }
            arr[j] = temp;
        }
    }

    public static void mergeSort(int[] arr, int[] temp, int low, int high){
        if(low >= high)
            return;
        int mid = low + (high-low)/2;
        mergeSort(arr,temp,low,mid);
        mergeSort(arr,temp,mid+1,high);
        merge(arr,temp,low,mid,high);
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i=low; i<=high; i++){
            temp[i] = arr[i];
        }
        int i=low,j=mid+1,k=low;
        while(i<=mid && j<=high){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            arr[k] = temp[i];
            i++;
            k++;
        }

    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partitioning(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1, high);
        }
    }

    private static int partitioning(int[] arr, int low, int high) {
        int pivotVal = arr[high];
        int i=low,j=low;
        while(i<=high){
            if(arr[i] <= pivotVal){
                swap(arr,i,j);
                j++;
            }
            i++;
        }
        return j-1;
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void printArray(int[] arr){
        int size = arr.length;
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        int[] arr = {4,2,1,7,9,6,0,10};
//        System.out.println("before sorting : ");;
//        printArray(arr);
//        quickSort(arr,0,arr.length-1);
//        System.out.println("after sorting : ");
//        printArray(arr);
        
    }
}
