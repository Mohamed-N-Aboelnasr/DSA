public class SpiralMatrix {

    public static void printSpiral(int[][] matrix, int r, int c){
        int i=0,row=0,col=0;
        while(row<r && col<c){
            for(i=col; i<c; i++){
                System.out.print(matrix[row][i] + " ");
            }
            row++;
            for(i=row; i<r; i++){
                System.out.print(matrix[i][c-1] + " ");
            }
            c--;
            if(row<r){
                for(i=c-1; i>=col; i--){
                    System.out.print(matrix[r-1][i] + " ");
                }
                r--;
            }
            if(col<c){
                for(i=r-1; i>=row; i--){
                    System.out.print(matrix[i][col] + " ");
                }
                col++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,70},
                {5,6,7,8,80},
                {9,10,11,12,90},
                {13,14,15,16,100}
        };
        printSpiral(matrix,4,5);
    }
}
