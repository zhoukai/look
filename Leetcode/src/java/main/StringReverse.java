/**
 * Created by look on 16/7/4.
 */
public class StringReverse {
    public static String reverse(String str){
        char[] cs = str.toCharArray();
        int length = cs.length;
        int half = length/2;
        for (int i=0;i<half;i++){
            char tmp = cs[i];
            cs[i] = cs[length -i -1];
            cs[length -i -1]=tmp;
        }
        return new String(cs);

    }

    public static String reverse2(String str){
        char[] cs = str.toCharArray();
        int length = cs.length;
        char[] cs2 = new char[length];
        for (int i=length-1;i>=0;i--){
            cs2[i]=cs[length-i-1];
        }
        return new String(cs2);

    }


    public static void main(String[] args) {
        System.out.println(reverse2("hello world"));
    }
}
