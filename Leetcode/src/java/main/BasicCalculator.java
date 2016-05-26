import java.io.*;

/**
 * Created by look on 16/7/24.
 */
public class BasicCalculator {



    public int calculate(String s) {

        System.out.println("input:"+s);
        int result = 0;

        int pos = 0;
        int length = s.length();
        StringBuffer sb = new StringBuffer();
        Integer right = null;
        char previousOp = '+';
        while(pos < length){
            char c = s.charAt(pos);
            System.out.println(c);
            if (c == '('){
                int subStringStart = ++pos;
                System.out.println(pos+":"+subStringStart);
                int leftNumber = 1;
                while( pos < length){
                    c = s.charAt(pos);
                    if (c == ')'){
                        leftNumber --;
                    }
                    if (c == '('){
                        leftNumber ++;
                    }
                    pos ++;
                    if (leftNumber == 0){
                        String subString = s.substring(subStringStart, pos-1);
                        int subResult = calculate(subString);
                        right = subResult;
                        System.out.println("pos:"+pos);

                        break;
                    }
                }
            }else if (c == '+' || c == '-' ){
                if (sb.toString().length() > 0){
                    int value = Integer.parseInt(sb.toString());
                    sb = new StringBuffer();
                    right = value;
                }
                System.out.println(result+" "+previousOp+" "+right);
                if (right != null){
                    if (previousOp == '+'){
                        result += right;
                    }else if (previousOp == '-'){
                        result -= right;
                    }else {
                        System.out.println("Should not happen");
                    }
                    right = null;
                }
                previousOp = c;
                pos++;
            }else if (c == ' '){
                pos ++;
            }else {
                sb.append(c);
                pos++;
            }


            if (pos == length){
                if (sb.length() > 0){
                    right = Integer.parseInt(sb.toString());
                }
                System.out.println("result:"+result+" right:"+right);
                if (right != null){
                    if (previousOp == '+'){
                        result += right;
                    }else if (previousOp == '-'){
                        result -= right;
                    }else {
                        System.out.println("Should not happen");
                    }
                    right = null;
                }
            }



        }

        return  result;
    }

    public static String readFileToString(String path) throws IOException {
        File file = new File(path);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BasicCalculator calculator = new BasicCalculator();

        String input = readFileToString("Leetcode/src/java/main/BasicCalculator.input.txt");
        System.out.println(input);
        int sum = calculator.calculate(input);
        System.out.println(sum);
    }

}
