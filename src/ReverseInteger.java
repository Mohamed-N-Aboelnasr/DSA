public class ReverseInteger {


    public static long reverseInteger(int number){
        boolean isNegative = number < 0;
        if(isNegative)
            number = number * -1;
        long reversedNumber = 0;
        int lastdigit;
        while(number > 0){
            lastdigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastdigit;
            number /= 10;
        }
        return isNegative?number*-1 : number;
    }

    public static void main(String[] args) {

    }
}
