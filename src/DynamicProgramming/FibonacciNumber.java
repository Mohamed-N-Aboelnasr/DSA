package DynamicProgramming;

public class FibonacciNumber {


    //Just Recursion without dynamic programming (No memorization)
    public static int fiboRecursion(int num) throws IllegalAccessException{
        if(num < 0)
            throw new IllegalAccessException("Invalid Input!!");
        if(num == 0 || num == 1)
            return num;
        else{
            int left = fiboRecursion(num-1);
            int right = fiboRecursion(num -2);
            return left+right;
        }
    }

    //Bottom-Up approach
    public static int fiboTabular(int num) throws IllegalAccessException{
        if(num < 0)
            throw new IllegalAccessException("Invalid Input!!");
        if(num == 0 || num == 1)
            return num;

        int[] tabular = new int[num+1];
        tabular[0] = 0;
        tabular[1] = 1;
        for(int i=2; i<=num; i++){
            tabular[i] = tabular[i-1] + tabular[i-2];
        }
        return tabular[num];
    }

    //Top-Down approach
    public static int fiboMemoization(int num, int[] mem) throws IllegalAccessException{
        if(num < 0)
            throw new IllegalAccessException("Invalid Input!!");
        if(num == 0 || num == 1)
            return num;

        mem[0] = 0;
        mem[1] = 1;

        if(mem[num] != 0){
            System.out.println("Stored Value of num "+num+" is "+mem[num]);
            return mem[num];
        }else {
            mem[num] = fiboMemoization(num-1, mem) + fiboMemoization(num -2, mem);
        }
        return mem[num];
    }


    public static void main(String[] args) {
        try {
            System.out.println(fiboMemoization(5, new int[6]));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
