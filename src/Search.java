public class Search {

    public static int BinarySearch(int[] arr, int target){
        int size = arr.length;
        int low = 0;
        int high = size-1;
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public static int BinarySearchInsert(int[] arr, int target){
        int size = arr.length;
        int low = 0;
        int high = size-1;
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
