public class SortedMatrix {

    public static boolean search(int[][] matrix, int size, int val){
        int col=size-1,row=0;
        while(row<size && col>=0){
            if(matrix[row][col] == val)
                return true;
            else if(val < matrix[row][col])
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(search(matrix,4,0));
    }
}
