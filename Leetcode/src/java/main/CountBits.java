import java.util.Arrays;

/**
 * Created by look on 16/7/4.
 */
public class CountBits {

    public int[] countBits(int num){
        int[] result =  new int[num+1];
        for (int i =1; i<= num; i++){
            result[i] = result[i/2]+i%2;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(256*256);
        CountBits countBits = new CountBits();
        int[] result = countBits.countBits(256);
        System.out.println(Arrays.toString(result));
    }
}
