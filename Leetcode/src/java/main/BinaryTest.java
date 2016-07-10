/**
 * Created by look on 16/7/2.
 */
public class BinaryTest {

    public static int sum(int a, int b){
        int result = 0;
        boolean carry = false;
        for (int i =0; i<32; i++){
            int mask = 1 << i;
            int ai = mask & a;
            int bi = mask & b;
            int ci = ai ^ bi;
            if (carry){
                ci = mask ^ ci;
            }
            carry = (ai >0 && bi > 0) || ((ai ^ bi) > 0 && carry) ;
            result = result | ci;

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(sum(-1,2));

    }
}
