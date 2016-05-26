
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by look on 16/6/17.
 */
public class BigNumberMultiply {

    private static int[] seperate(String s, int scale){
        int size = s.length();
        int num = size / scale;
        if (size % scale != 0){
            num++;
        }
        int[] ints = new int[num];
        for(int i=0; i< ints.length; i++){
            int endIndex = size - i*scale;
            int startIndex = endIndex - scale;
            if (startIndex < 0){
                startIndex = 0;
            }
            ints[i] = Integer.valueOf(s.substring(startIndex, endIndex));
        }
        for (int i : ints){
            System.out.print(i+",");
        }
        System.out.println();
        return ints;
    }

    public static String multiplyBigDecimal(String a, String b){
        BigDecimal ba = new BigDecimal(a);
        BigDecimal bb = new BigDecimal(b);
        return ba.multiply(bb).toPlainString();
    }


    public static String multiply(String a, String b){
        int scale = 4;
        int[] intsA = seperate(a, scale);
        int[] intsB = seperate(b, scale);

        List<Integer> total = new ArrayList<>();
        for(int i=0; i<intsA.length; i++){
            List<Integer> temp = new ArrayList<>();
            for (int n =0 ; n<i; n++){
                temp.add(0);
            }
            int toadd = 0;
            for (int j=0; j<intsB.length; j++){
                temp.add((intsA[i]*intsB[j]+toadd) % 10000);
                toadd = (intsA[i]*intsB[j]+toadd) / 10000;
            }
            if (toadd > 0){
                temp.add(toadd);
            }
            add(total, temp);
        }
        return toPlainString(total);
    }

    private static String toPlainString(List<Integer> total){
        StringBuilder sb = new StringBuilder();
        sb.append(total.get(total.size() -1));
        for (int i = total.size() -2; i >=0; i--){
            String t = total.get(i)+"";
            for (int j=t.length(); j < 4; j++){
                sb.append("0");
            }
            sb.append(t);
        }
        return sb.toString();
    }

    public static void add(List<Integer> total, List<Integer> temp){
        while (total.size() < temp.size()){
            total.add(0);
        }
        int toAdd = 0;
        for (int i=0; i< temp.size(); i++){
            int oldTotal = total.get(i);
            int tempInt = temp.get(i);
            total.set(i, (oldTotal+tempInt+toAdd) % 10000);
            toAdd = (oldTotal+tempInt+toAdd) / 10000;
        }
        if (toAdd > 0){
                for (int i=temp.size(); i< total.size(); i++){
                    int a = total.get(i);
                    total.set(i, (a+toAdd) % 10000);
                    toAdd = (a+toAdd) / 10000;
                }
                if (toAdd > 0){
                    total.add(toAdd);
                }
        }
    }

    public static void main(String[] args) {
        String a = "123456789012345";
        String b = "1234567890123456789";
        String result1 = multiplyBigDecimal(a, b);
        String result2 = multiply(a, b);
        System.out.println(result1+":"+result2+":"+result1.equals(result2));

        List<Integer> al = new ArrayList<>(Arrays.asList(9999,9999,9999));
        List<Integer> bl = Arrays.asList(1);
        add(al, bl);
        System.out.println(toPlainString(al));

    }

}
