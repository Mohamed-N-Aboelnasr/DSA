public class IsSubsequence {


    public static boolean isSubsequence(String str, String subseq){
        int i=0,j=0;
        while(i < str.length() && j < subseq.length()){
            if(str.charAt(i) == subseq.charAt(j))
                j++;
            i++;
        }
        return j == subseq.length();
    }


    public static void main(String[] args) {

    }
}
